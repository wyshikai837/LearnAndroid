package com.sky.learnandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sky.learnandroid.aboutview.AboutViewActivity;
import com.sky.learnandroid.adapter.SimpleAdapter;
import com.sky.learnandroid.lauchmode.LauchModeActivity;
import com.sky.learnandroid.lifecycler.LifeCyclerActivity;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private final static List<String> learnListStrs = Arrays.asList(
            "LifeCycler",
            "LaunchMode",
            "AboutView",
            "IPC");

    private RecyclerView mRvLearnList;
    private SimpleAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRvLearnList = (RecyclerView) findViewById(R.id.rv_learn_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRvLearnList.setLayoutManager(linearLayoutManager);
        mAdapter = new SimpleAdapter(learnListStrs);
        mAdapter.setListener(new SimpleAdapter.SimpleAdapterListener() {
            @Override
            public void onItemClicked(int position) {
                switch (position) {
                    case 0:
                        LifeCyclerActivity.startLifeCyclerActivity(MainActivity.this);
                        break;
                    case 1:
                        LauchModeActivity.startLauchModeActivity(MainActivity.this);
                        break;
                    case 2:
                        AboutViewActivity.startAboutViewActivity(MainActivity.this);
                        break;
                    case 3:

                        break;

                }
            }
        });
        mRvLearnList.setAdapter(mAdapter);
    }

}
