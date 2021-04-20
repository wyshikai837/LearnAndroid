package com.sky.learnandroid.architecture.mvvm;

import android.text.TextUtils;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {

    private static final String TAG = "LoginViewModel";
    public final static String USER_NAME = "sky";
    public final static String PWD = "a123456";

    private User user = new User();
    private static MutableLiveData<LoginInfo> loginInfoLiveData;

    public User getUser() {
        return user;
    }

    public LiveData<LoginInfo> getLoginInfoLiveData() {
        if (null == loginInfoLiveData) {
            loginInfoLiveData = new MutableLiveData<LoginInfo>();
        }
        return loginInfoLiveData;
    }

    public void login() {
        Log.e(TAG, String.format("---> User info: %s", user.toString()));
        LoginInfo loginInfo = new LoginInfo();
        if (TextUtils.isEmpty(user.getUserName())) {
            loginInfo.setLogin(false);
            loginInfo.setErrorMsg(LoginInfo.ERROR_MSG_USER_NAME_EMPTY);
            loginInfoLiveData.postValue(loginInfo);
            return;
        }

        if (TextUtils.isEmpty(user.getPwd())) {
            loginInfo.setLogin(false);
            loginInfo.setErrorMsg(LoginInfo.ERROR_MSG_PWD_EMPTY);
            loginInfoLiveData.postValue(loginInfo);
            return;
        }

        if (USER_NAME.equals(user.getUserName()) && PWD.equals(user.getPwd())) {
            loginInfo.setLogin(true);
            loginInfoLiveData.postValue(loginInfo);
        } else {
            loginInfo.setLogin(false);
            loginInfo.setErrorMsg(LoginInfo.ERROR_MSG_LOGINFAILED);
            loginInfoLiveData.postValue(loginInfo);
        }
    }
}
