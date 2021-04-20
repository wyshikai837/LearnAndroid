package com.sky.learnandroid.lauchmode;

import android.app.Activity;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.sky.learnandroid.R;

public class SingleTaskActivity extends AppCompatActivity {

    public static void startSingleTaskActivity(Activity activity) {
        Intent intent = new Intent(activity, SingleTaskActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_task);

        setTitle("SingleTaskActivity");

        findViewById(R.id.btn_start_self).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSingleTaskActivity(SingleTaskActivity.this);
            }
        });

        findViewById(R.id.btn_start_standard_then_start_single_task).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StandardActivity.startStandardActivity(SingleTaskActivity.this);
            }
        });
    }
}
