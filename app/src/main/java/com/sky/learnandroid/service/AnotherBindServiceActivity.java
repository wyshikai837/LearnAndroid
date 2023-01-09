package com.sky.learnandroid.service;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.sky.learnandroid.R;

public class AnotherBindServiceActivity extends AppCompatActivity {

    private static final String TAG = "AnotherBindServiceActiv";

    public static void startAnotherBindServiceActivity(Activity activity) {
        Intent intent = new Intent(activity, AnotherBindServiceActivity.class);
        activity.startActivity(intent);
    }

    private MyService mService;
    private boolean binded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another_bind_service);

        findViewById(R.id.btn_bind_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "---> service trace --> bind service");
                Intent intent = new Intent(AnotherBindServiceActivity.this, MyService.class);
                bindService(intent, serviceConnection, BIND_AUTO_CREATE);
            }
        });

        findViewById(R.id.btn_get_sum).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mService) {
                    Log.d(TAG, "---> service trace --> sum = " + mService.getSum());
                }
            }
        });

        findViewById(R.id.btn_unbind_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "---> service trace --> unbind service");
                if (binded) {
                    unbindService(serviceConnection);
                    binded = false;
                    mService = null;
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (binded) {
            unbindService(serviceConnection);
            binded = false;
            mService = null;
        }
    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mService = ((MyService.MyBinder) service).getService();
            binded = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
}
