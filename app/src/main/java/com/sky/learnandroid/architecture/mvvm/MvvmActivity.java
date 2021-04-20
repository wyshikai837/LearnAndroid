package com.sky.learnandroid.architecture.mvvm;

import android.app.Activity;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.sky.learnandroid.R;
import com.sky.learnandroid.databinding.ActivityMvvmBinding;

public class MvvmActivity extends AppCompatActivity {

    private static final String TAG = "MvvmActivity";

    public static void startActivity(Activity activity) {
        Intent intent = new Intent(activity, MvvmActivity.class);
        activity.startActivity(intent);
    }

    private LoginViewModel mViewModel;
    private ActivityMvvmBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm);
        mViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        mBinding.setUser(mViewModel.getUser());
        mBinding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewModel.login();
            }
        });

        mViewModel.getLoginInfoLiveData().observe(this, new Observer<LoginInfo>() {
            @Override
            public void onChanged(LoginInfo loginInfo) {
                Log.e(TAG, "---> loginInfo: " + loginInfo.toString());
                if (loginInfo.isLogin()) {
                    Toast.makeText(MvvmActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                } else if (!TextUtils.isEmpty(loginInfo.getErrorMsg())){
                    Toast.makeText(MvvmActivity.this, loginInfo.getErrorMsg(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}