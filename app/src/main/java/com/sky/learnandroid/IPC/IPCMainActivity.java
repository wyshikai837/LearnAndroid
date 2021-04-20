package com.sky.learnandroid.IPC;

import android.app.Activity;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.sky.learnandroid.R;

public class IPCMainActivity extends AppCompatActivity {

    public static void startIPCMainActivity(Activity activity) {
        Intent intent = new Intent(activity, IPCMainActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipcmain);

        setTitle("IPCMainActivity");

        findViewById(R.id.btn_start_remote1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Remote1Activity.startRemote1Activity(IPCMainActivity.this);
            }
        });
    }
}
