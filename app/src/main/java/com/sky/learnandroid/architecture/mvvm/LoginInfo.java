package com.sky.learnandroid.architecture.mvvm;

public class LoginInfo {

    public static final String ERROR_MSG_USER_NAME_EMPTY = "请输入用户名！";
    public static final String ERROR_MSG_PWD_EMPTY = "请输入密码！";
    public static final String ERROR_MSG_LOGINFAILED = "请输入正确的用户名和密码！";

    private boolean isLogin;
    private String errorMsg;

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "LoginInfo{" +
                "isLogin=" + isLogin +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
}
