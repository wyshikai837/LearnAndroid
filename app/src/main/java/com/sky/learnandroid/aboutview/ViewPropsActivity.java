package com.sky.learnandroid.aboutview;

import android.app.Activity;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.sky.learnandroid.R;

public class ViewPropsActivity extends AppCompatActivity {

    private static final String TAG = "ViewPropsActivity";

    public static void startViewPropsActivity(Activity activity) {
        Intent intent = new Intent(activity, ViewPropsActivity.class);
        activity.startActivity(intent);
    }

    private TextView mTvText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_props);

        setTitle("ViewPropsActivity");

        mTvText = findViewById(R.id.tv_text);

        findViewById(R.id.btn_get_view_props).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvText.scrollTo(-40, 0);

                Log.d(TAG, "left = " + mTvText.getLeft());
                Log.d(TAG, "x = " + mTvText.getX());
                Log.d(TAG, "translationX = " + mTvText.getTranslationX());
                Log.d(TAG, "scrollX = " + mTvText.getScrollX());


                Log.d(TAG, "top = " + mTvText.getTop());
                Log.d(TAG, "y = " + mTvText.getY());
                Log.d(TAG, "translationY = " + mTvText.getTranslationY());
                Log.d(TAG, "scrollY = " + mTvText.getScrollY());
            }
        });
    }
}
