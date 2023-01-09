package com.sky.learnandroid.service;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.sky.learnandroid.IPC.aidl.Book;
import com.sky.learnandroid.IPC.aidl.IBookManager;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MyService extends Service {

    private MyBinder mBinder;

    private AtomicInteger ai = new AtomicInteger(0);

    public static void startMyService(Activity activity) {
//        Intent intent = new Intent(activity, MyService.class);
//        activity.startService(intent);

        Intent intent = new Intent("com.sky.service.MyService");
        intent.setPackage("com.sky.learnandroid");
//        Intent intent = new Intent();
//        intent.setComponent(new ComponentName("com.sky.learnandroid", "com.sky.learnandroid.service.MyService"));
        activity.startService(intent);
    }

    public static void stopMyService(Activity activity) {
        Intent intent = new Intent(activity, MyService.class);
        activity.stopService(intent);
    }

    private static final String TAG = "MyService";

    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "---> service trace --> onCreate " + this);
        mBinder = new MyBinder();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "---> service trace --> onStartCommand " + this);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "---> service trace --> onBind " + this);
        return mBinder;
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Log.d(TAG, "---> service trace --> onRebind " + this);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "---> service trace --> onUnbind " + this);
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "---> service trace --> onDestroy " + this);
        super.onDestroy();
    }

    public int getSum() {
        return ai.addAndGet(1);
    }

    public class MyBinder extends Binder {
        public MyService getService() {
            return MyService.this;
        }
    }
}
