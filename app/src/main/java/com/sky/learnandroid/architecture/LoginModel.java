package com.sky.learnandroid.architecture;

public class LoginModel {

    public final static String USER_NAME = "sky";
    public final static String PWD = "a123456";

    private ILoginCallback mCallback;

    public LoginModel(ILoginCallback callback) {
        this.mCallback = callback;
    }

    public void login(final String userName, final String pwd) {
        if (USER_NAME.equals(userName) && PWD.equals(pwd)) {
            if (null != mCallback) {
                mCallback.loginSuccessed();
            }
        } else {
            if (null != mCallback) {
                mCallback.loginFailed();
            }
        }
    }

    public interface ILoginCallback {
        void loginSuccessed();
        void loginFailed();
    }
}
