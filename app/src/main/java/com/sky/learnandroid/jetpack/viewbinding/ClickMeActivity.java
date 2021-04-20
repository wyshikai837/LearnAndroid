package com.sky.learnandroid.jetpack.viewbinding;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.sky.learnandroid.databinding.ActivityClickMeBinding;

public class ClickMeActivity extends AppCompatActivity {

    public static void startActivity(Activity activity) {
        Intent intent = new Intent(activity, ClickMeActivity.class);
        activity.startActivity(intent);
    }

    private int mSum = 0;
    private ActivityClickMeBinding mViewBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewBinding = ActivityClickMeBinding.inflate(getLayoutInflater());
        setContentView(mViewBinding.getRoot());

        mViewBinding.tvClickSum.setText(String.valueOf(mSum));
        mViewBinding.btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewBinding.tvClickSum.setText(String.valueOf(++mSum));
            }
        });
    }
}