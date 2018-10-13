package com.sky.learnandroid.aboutview;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sky.learnandroid.R;

public class ScrollViewActivity extends AppCompatActivity {

    public static void startScrollViewActivity(Activity activity) {
        Intent intent = new Intent(activity, ScrollViewActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view);
    }
}
