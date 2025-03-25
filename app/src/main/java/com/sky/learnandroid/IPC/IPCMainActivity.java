package com.sky.learnandroid.IPC;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;

import com.sky.learnandroid.R;
import com.sky.reviewandroid.IDemandManager;
import com.sky.reviewandroid.MessageBean;

public class IPCMainActivity extends AppCompatActivity {

    private static final String TAG = "IPCMainActivity";

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
//                Remote1Activity.startRemote1Activity(IPCMainActivity.this);

//                Intent intent = new Intent();
//                intent.setAction("com.tengxun.aidl");//service的action
//                intent.setPackage("qdx.aidlserver");//aidl文件夹里面aidl文件的包名
//                bindService(intent, connection, Context.BIND_AUTO_CREATE);

            Intent intent = new Intent();
            intent.setAction("com.sky.reviewandroid");
            intent.setPackage("com.sky.reviewandroid");
            bindService(intent, connection, Context.BIND_AUTO_CREATE);
            }
        });
    }

    private IDemandManager demandManager;
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            demandManager = IDemandManager.Stub.asInterface(iBinder);
            try {
                Log.e(TAG, "onServiceConnected: " + demandManager.getDemand().toString());
                MessageBean messageBean = new MessageBean("first", 1);
                demandManager.setDemandIn(messageBean);
                Log.e(TAG, "onServiceConnected: " + messageBean.toString());

                messageBean.setContent("second");
                messageBean.setLevel(2);
                demandManager.setDemandOut(messageBean);
                Log.e(TAG, "onServiceConnected: " + messageBean.toString());

                messageBean.setContent("three");
                messageBean.setLevel(3);
                demandManager.setDemandInOut(messageBean);
                Log.e(TAG, "onServiceConnected: " + messageBean.toString());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
}
