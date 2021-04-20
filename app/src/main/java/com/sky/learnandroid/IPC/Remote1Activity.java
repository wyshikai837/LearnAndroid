package com.sky.learnandroid.IPC;

import android.app.Activity;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.sky.learnandroid.R;

public class Remote1Activity extends AppCompatActivity {

    public static void startRemote1Activity(Activity activity) {
        Intent intent = new Intent(activity, Remote1Activity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remote1);

        setTitle("Remote1Activity");

        findViewById(R.id.btn_start_remote2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Remote2Activity.startRemote2Activity(Remote1Activity.this);
            }
        });
    }
}
