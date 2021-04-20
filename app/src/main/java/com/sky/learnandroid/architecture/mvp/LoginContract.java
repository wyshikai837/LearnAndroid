package com.sky.learnandroid.architecture.mvp;

public interface LoginContract {

    interface View {
        void userNameIsEmpty();
        void pwdIsEmpty();
        void loginSuccessed();
        void loginFailed();
    }

    interface Presenter {
        void login(String userName, String pwd);
    }
}
