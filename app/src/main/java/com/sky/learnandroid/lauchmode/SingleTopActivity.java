package com.sky.learnandroid.lauchmode;

import android.app.Activity;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.sky.learnandroid.R;

public class SingleTopActivity extends AppCompatActivity {

    public static void startSingleTopActivity(Activity activity) {
        Intent intent = new Intent(activity, SingleTopActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_top);

        setTitle("SingleTopActivity");

        findViewById(R.id.btn_start_self).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSingleTopActivity(SingleTopActivity.this);
            }
        });

        findViewById(R.id.btn_start_standard_then_start_single_top).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StandardActivity.startStandardActivity(SingleTopActivity.this);
            }
        });
    }
}
