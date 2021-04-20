package com.sky.learnandroid.architecture.mvc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sky.learnandroid.R;
import com.sky.learnandroid.architecture.LoginModel;

public class MvcActivity extends AppCompatActivity {

    public static void startActivity(Activity activity) {
        Intent intent = new Intent(activity, MvcActivity.class);
        activity.startActivity(intent);
    }

    private EditText mEtUsername;
    private EditText mEtPwd;
    private Button mBtnLogin;

    private LoginModel mLoginModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);
        this.initView();
        mLoginModel = new LoginModel(new LoginModel.ILoginCallback() {
            @Override
            public void loginSuccessed() {
                Toast.makeText(MvcActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void loginFailed() {
                Toast.makeText(MvcActivity.this, "登陆失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        mEtUsername = findViewById(R.id.et_username);
        mEtPwd = findViewById(R.id.et_pwd);
        mBtnLogin = findViewById(R.id.btn_login);

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = mEtUsername.getText().toString();
                String pwd = mEtPwd.getText().toString();
                if (!isLoginInfoEmpty(userName, pwd)) {
                    mLoginModel.login(userName, pwd);
                }
            }
        });
    }

    protected boolean isLoginInfoEmpty(String userName, String pwd) {
        if (TextUtils.isEmpty(userName)) {
            Toast.makeText(MvcActivity.this, "请输入用户名", Toast.LENGTH_SHORT).show();
            return true;
        }

        if (TextUtils.isEmpty(pwd)) {
            Toast.makeText(MvcActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
            return true;
        }

        return false;
    }
}