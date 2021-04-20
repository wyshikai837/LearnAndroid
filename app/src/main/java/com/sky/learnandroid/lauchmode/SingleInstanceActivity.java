package com.sky.learnandroid.lauchmode;

import android.app.Activity;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.sky.learnandroid.R;

public class SingleInstanceActivity extends AppCompatActivity {

    public static void startSingleInstanceActivity(Activity activity) {
        Intent intent = new Intent(activity, SingleInstanceActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_instance);

        setTitle("SingleInstanceActivity");

        findViewById(R.id.btn_start_self).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSingleInstanceActivity(SingleInstanceActivity.this);
            }
        });

        findViewById(R.id.btn_start_standard_then_start_single_instance).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StandardActivity.startStandardActivity(SingleInstanceActivity.this);
            }
        });
    }
}
