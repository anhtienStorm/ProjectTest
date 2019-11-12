package com.example.projecttest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SectionIndexer;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class TestAdapter extends ArrayAdapter<String> implements SectionIndexer {

    HashMap<String, Integer> mMapIndex;
    List<String> mList;
    String[] mSections;
    Context mContext;

    public TestAdapter(Context context,  List<String> data) {
        super(context, R.layout.item_layout, data);
        this.mList = data;
        this.mContext = context;
        mMapIndex = new LinkedHashMap<>();

        for (int i = 0; i < mList.size(); i++) {
            String s = mList.get(i);
            String ch = s.substring(0,1);
            ch = ch.toUpperCase(Locale.US);

            mMapIndex.put(ch, i);
        }

        Set<String> sectionLetters = mMapIndex.keySet();

        ArrayList<String> sectionList = new ArrayList<>(sectionLetters);
        Collections.sort(sectionList);
        mSections = new String[sectionList.size()];
        sectionList.toArray(mSections);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_layout, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tvTitle = convertView.findViewById(R.id.txt_title);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tvTitle.setText(mList.get(position));
        return convertView;
    }

    @Override
    public Object[] getSections() {
        return mSections;
    }

    @Override
    public int getPositionForSection(int i) {
        return mMapIndex.get(mSections[i]);
    }

    @Override
    public int getSectionForPosition(int i) {
        return 0;
    }

    public class ViewHolder {
        TextView tvTitle;
    }
}
