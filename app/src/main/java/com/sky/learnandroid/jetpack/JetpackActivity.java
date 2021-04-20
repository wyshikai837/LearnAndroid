package com.sky.learnandroid.jetpack;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sky.learnandroid.R;
import com.sky.learnandroid.adapter.SimpleAdapter;
import com.sky.learnandroid.jetpack.databinding.TestDataBindingActivity;
import com.sky.learnandroid.jetpack.viewbinding.ClickMeActivity;

import java.util.Arrays;
import java.util.List;

public class JetpackActivity extends AppCompatActivity {

    public static void startActivity(Activity activity) {
        Intent intent = new Intent(activity, JetpackActivity.class);
        activity.startActivity(intent);
    }

    private final static List<String> mArchitectureList = Arrays.asList(
            "ViewBinding",
            "DataBinding",
            "LiveData");

    private RecyclerView mRecyclerView;
    private SimpleAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jetpack);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mAdapter = new SimpleAdapter(mArchitectureList);
        mAdapter.setListener(new SimpleAdapter.SimpleAdapterListener() {
            @Override
            public void onItemClicked(int position) {
                switch (position) {
                    case 0:
                        ClickMeActivity.startActivity(JetpackActivity.this);
                        break;
                    case 1:
                        TestDataBindingActivity.startActivity(JetpackActivity.this);
                        break;
                }
            }
        });
        mRecyclerView.setAdapter(mAdapter);
    }
}