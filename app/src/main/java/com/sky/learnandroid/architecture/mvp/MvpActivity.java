package com.sky.learnandroid.architecture.mvp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sky.learnandroid.R;

public class MvpActivity extends AppCompatActivity implements LoginContract.View {

    public static void startActivity(Activity activity) {
        Intent intent = new Intent(activity, MvpActivity.class);
        activity.startActivity(intent);
    }

    private EditText mEtUsername;
    private EditText mEtPwd;
    private Button mBtnLogin;

    private LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        this.initView();
        mLoginPresenter = new LoginPresenter(this);
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
                mLoginPresenter.login(userName, pwd);
            }
        });
    }

    @Override
    public void loginSuccessed() {
        Toast.makeText(MvpActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFailed() {
        Toast.makeText(MvpActivity.this, "登陆失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void userNameIsEmpty() {
        Toast.makeText(MvpActivity.this, "请输入用户名", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void pwdIsEmpty() {
        Toast.makeText(MvpActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
    }
}