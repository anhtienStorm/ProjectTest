package com.example.projecttest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    TestAdapter mAdapter;
    String[] mData;
    List<String> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Hello !!!");

//        final TextView textView = findViewById(R.id.text);
//
//        final CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.layout_collapsing);
//        AppBarLayout appBarLayout = findViewById(R.id.layout_appbar);
//        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
//            boolean isShow = true;
//            int scrollRange = -1;
//
//            @Override
//            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
//                if (scrollRange == -1) {
//                    scrollRange = appBarLayout.getTotalScrollRange();
//                }
//                if (scrollRange + verticalOffset == 0) {
////                    textView.setVisibility(View.GONE);
//                    toolbar.setTitle("Điện Thoại");
//                    isShow = true;
//                } else if(isShow) {
////                    textView.setVisibility(View.VISIBLE);
//                    toolbar.setTitle(" ");//careful there should a space between double quote otherwise it wont work
//                    isShow = false;
//                }
//            }
//        });

        mRecyclerView = findViewById(R.id.recyclerview);
        mData = getResources().getStringArray(R.array.array);
        mList = Arrays.asList(mData);
        mAdapter = new TestAdapter(this, mList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
}
