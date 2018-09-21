package com.sky.learnandroid.IPC;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sky.learnandroid.R;

public class Remote2Activity extends AppCompatActivity {

    public static void startRemote2Activity(Activity activity) {
        Intent intent = new Intent(activity, Remote2Activity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remote2);

        setTitle("Remote2Activity");
    }
}
