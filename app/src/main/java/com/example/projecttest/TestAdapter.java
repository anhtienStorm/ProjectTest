package com.example.projecttest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SectionIndexer;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestViewHolder> {

    List<String> mList;
    Context mContext;

    public TestAdapter(Context context,  List<String> data) {
        this.mList = data;
        this.mContext = context;
    }

    @NonNull
    @Override
    public TestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TestViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TestViewHolder holder, int position) {
        String s = mList.get(position);
        holder.tvTitle.setText(s);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    // class
    public class TestViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;

        public TestViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.txt_title);
        }
    }
}
