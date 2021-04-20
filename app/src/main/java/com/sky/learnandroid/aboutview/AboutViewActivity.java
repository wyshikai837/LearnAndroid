package com.sky.learnandroid.aboutview;

import android.app.Activity;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sky.learnandroid.R;
import com.sky.learnandroid.adapter.SimpleAdapter;

import java.util.Arrays;
import java.util.List;

public class AboutViewActivity extends AppCompatActivity {

    public static void startAboutViewActivity(Activity activity) {
        Intent intent = new Intent(activity, AboutViewActivity.class);
        activity.startActivity(intent);
    }

    private final static List<String> ABOUT_VIEW_LIST = Arrays.asList(
            "View props",
            "Move with finger",
            "ScrollView");

    private RecyclerView mRvAboutView;
    private SimpleAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_view);

        setTitle("AboutViewActivity");

        mRvAboutView = findViewById(R.id.rv_about_view);
        mRvAboutView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new SimpleAdapter(ABOUT_VIEW_LIST);
        mAdapter.setListener(new SimpleAdapter.SimpleAdapterListener() {
            @Override
            public void onItemClicked(int position) {
                switch (position) {
                    case 0:
                        ViewPropsActivity.startViewPropsActivity(AboutViewActivity.this);
                        break;
                    case 1:
                        MoveWithFingerActivity.startMoveWithFingerActivity(AboutViewActivity.this);
                        break;
                    case 2:
                        ScrollViewActivity.startScrollViewActivity(AboutViewActivity.this);
                        break;
                }
            }
        });
        mRvAboutView.setAdapter(mAdapter);
    }
}
