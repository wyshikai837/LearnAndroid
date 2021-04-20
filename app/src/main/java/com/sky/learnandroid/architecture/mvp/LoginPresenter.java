package com.sky.learnandroid.architecture.mvp;

import androidx.annotation.NonNull;
import android.text.TextUtils;

import com.sky.learnandroid.architecture.LoginModel;

public class LoginPresenter implements LoginContract.Presenter{

    private LoginContract.View mView;
    private LoginModel mModel;

    public LoginPresenter(@NonNull LoginContract.View view) {
        this.mView = view;
        mModel = new LoginModel(new LoginModel.ILoginCallback() {
            @Override
            public void loginSuccessed() {
                mView.loginSuccessed();
            }

            @Override
            public void loginFailed() {
                mView.loginFailed();
            }
        });
    }

    @Override
    public void login(String userName, String pwd) {
        if (TextUtils.isEmpty(userName)) {
            mView.userNameIsEmpty();
            return;
        }

        if (TextUtils.isEmpty(pwd)) {
            mView.pwdIsEmpty();
            return;
        }

        mModel.login(userName, pwd);
    }
}
