package com.sky.learnandroid.lauchmode;

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

public class LauchModeActivity extends AppCompatActivity {

    public static void startLauchModeActivity(Activity activity) {
        Intent intent = new Intent(activity, LauchModeActivity.class);
        activity.startActivity(intent);
    }

    private final static List<String> LAUCH_MODE_LIST = Arrays.asList("standard", "singleTop", "singleTask", "singltInstance");

    private RecyclerView mRvLauchMode;
    private SimpleAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lauch_mode);

        setTitle("LauchModeActivity");

        mRvLauchMode = findViewById(R.id.rv_lauch_mode);
        mRvLauchMode.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new SimpleAdapter(LAUCH_MODE_LIST);
        mAdapter.setListener(new SimpleAdapter.SimpleAdapterListener() {
            @Override
            public void onItemClicked(int position) {
                switch (position) {
                    case 0:
                        StandardActivity.startStandardActivity(LauchModeActivity.this);
                        break;
                    case 1:
                        SingleTopActivity.startSingleTopActivity(LauchModeActivity.this);
                        break;
                    case 2:
                        SingleTaskActivity.startSingleTaskActivity(LauchModeActivity.this);
                        break;
                    case 3:
                        SingleInstanceActivity.startSingleInstanceActivity(LauchModeActivity.this);
                        break;
                }
            }
        });
        mRvLauchMode.setAdapter(mAdapter);
    }
}
