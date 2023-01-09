package com.sky.learnandroid.lifecycler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.sky.learnandroid.R;

public class TestFragmentActivity extends AppCompatActivity {

    private static final String TAG = "TestFragmentActivity";

    public static void startActivity(Activity activity) {
        Intent intent = new Intent(activity, TestFragmentActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_fragment);
        Log.d(TAG, "---> onCreate");

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if (null == fragment) {
            fragment = new TestFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "---> onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "---> onStart");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "---> onRestoreInstanceState");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "---> onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "---> onPause");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "---> onSaveInstanceState");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "---> onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "---> onDestroy");
    }
}