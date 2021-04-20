package com.sky.learnandroid.lauchmode;

import android.app.Activity;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.sky.learnandroid.R;

public class StandardActivity extends AppCompatActivity {

    public static void startStandardActivity(Activity activity) {
        Intent intent = new Intent(activity, StandardActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard);

        setTitle("StandardActivity");

        findViewById(R.id.btn_start_single_top).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SingleTopActivity.startSingleTopActivity(StandardActivity.this);
            }
        });

        findViewById(R.id.btn_start_single_task).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SingleTaskActivity.startSingleTaskActivity(StandardActivity.this);
            }
        });

        findViewById(R.id.btn_start_single_instance).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SingleInstanceActivity.startSingleInstanceActivity(StandardActivity.this);
            }
        });
    }
}
