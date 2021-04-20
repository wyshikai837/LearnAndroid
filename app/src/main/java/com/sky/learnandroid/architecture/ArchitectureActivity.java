package com.sky.learnandroid.architecture;

import android.app.Activity;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sky.learnandroid.R;
import com.sky.learnandroid.adapter.SimpleAdapter;
import com.sky.learnandroid.architecture.mvc.MvcActivity;
import com.sky.learnandroid.architecture.mvp.MvpActivity;
import com.sky.learnandroid.architecture.mvvm.LoginInfo;
import com.sky.learnandroid.architecture.mvvm.LoginViewModel;
import com.sky.learnandroid.architecture.mvvm.MvvmActivity;

import java.util.Arrays;
import java.util.List;

public class ArchitectureActivity extends AppCompatActivity {

    private static final String TAG = "ArchitectureActivity";

    public static void startActivity(Activity activity) {
        Intent intent = new Intent(activity, ArchitectureActivity.class);
        activity.startActivity(intent);
    }

    private final static List<String> mArchitectureList = Arrays.asList(
            "NoArchitecture",
            "MVC",
            "MVP",
            "MVVM");

    private RecyclerView mRecyclerView;
    private SimpleAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_architecture);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mAdapter = new SimpleAdapter(mArchitectureList);
        mAdapter.setListener(new SimpleAdapter.SimpleAdapterListener() {
            @Override
            public void onItemClicked(int position) {
                switch (position) {
                    case 0:
                        NoArchitectureActivity.startActivity(ArchitectureActivity.this);
                        break;
                    case 1:
                        MvcActivity.startActivity(ArchitectureActivity.this);
                        break;
                    case 2:
                        MvpActivity.startActivity(ArchitectureActivity.this);
                        break;
                    case 3:
                        MvvmActivity.startActivity(ArchitectureActivity.this);
                        break;

                }
            }
        });
        mRecyclerView.setAdapter(mAdapter);

        LoginViewModel loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        loginViewModel.getLoginInfoLiveData().observe(this, new Observer<LoginInfo>() {
            @Override
            public void onChanged(LoginInfo loginInfo) {
                Log.e(TAG, "---> observe loginInfo: " + loginInfo.toString());
            }
        });

        loginViewModel.getLoginInfoLiveData().observeForever(new Observer<LoginInfo>() {
            @Override
            public void onChanged(LoginInfo loginInfo) {
                Log.e(TAG, "---> observeForever loginInfo: " + loginInfo.toString());
            }
        });
    }
}