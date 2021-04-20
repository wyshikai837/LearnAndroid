package com.sky.learnandroid.jetpack.databinding;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.sky.learnandroid.R;
import com.sky.learnandroid.databinding.TestDataBinding;

public class TestDataBindingActivity extends AppCompatActivity {

    private static final String TAG = "TestDataBindingActivity";

    public static void startActivity(Activity activity) {
        Intent intent = new Intent(activity, TestDataBindingActivity.class);
        activity.startActivity(intent);
    }

    private TestDataBinding mBinding;
    private User mUser = new User("sky", "a12345678");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_test_data_binding);
        mBinding.setUser(mUser);
        mBinding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e(TAG, "btnlogin onclick getText ---> " + mBinding.etUsername.getText().toString());
                Log.e(TAG, "btnLogin onclick dataBinding ---> " + mUser.getUserName());
            }
        });
        mUser.setUserName("abc");
    }
}