package com.sky.learnandroid.service;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.sky.learnandroid.R;

public class ServiceMainActivity extends AppCompatActivity {

    private static final String TAG = "ServiceMainActivity";

    public static void startServiceMainActivity(Activity activity) {
        Intent intent = new Intent(activity, ServiceMainActivity.class);
        activity.startActivity(intent);
    }

    private boolean binded = false;
    private MyService mService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_main);

        findViewById(R.id.btn_start_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "service trace --> start service");
                MyService.startMyService(ServiceMainActivity.this);
            }
        });

        findViewById(R.id.btn_stop_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "service trace --> stop service");
                MyService.stopMyService(ServiceMainActivity.this);
            }
        });

        findViewById(R.id.btn_bind_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "service trace --> bind service");
                Intent intent = new Intent(ServiceMainActivity.this, MyService.class);
                bindService(intent, serviceConnection, BIND_AUTO_CREATE);
            }
        });

        findViewById(R.id.btn_get_sum).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mService) {
                    Log.d(TAG, "service trace --> sum = " + mService.getSum());
                }
            }
        });

        findViewById(R.id.btn_unbind_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "service trace --> unbind service");
                if (binded) {
                    unbindService(serviceConnection);
                    binded = false;
                    mService = null;
                }
            }
        });

        findViewById(R.id.btn_start_another_act_to_bind).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "service trace --> start another activity to bind");
                AnotherBindServiceActivity.startAnotherBindServiceActivity(ServiceMainActivity.this);
            }
        });
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
