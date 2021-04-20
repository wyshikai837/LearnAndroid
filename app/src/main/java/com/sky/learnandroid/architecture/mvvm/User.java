package com.sky.learnandroid.architecture.mvvm;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.sky.learnandroid.BR;

public class User extends BaseObservable {
    private static final String TAG = "User";

    private String userName;
    private String pwd;

    public User() {
    }

    public User(String userName, String pwd) {
        this.userName = userName;
        this.pwd = pwd;
    }

    @Bindable
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
        notifyPropertyChanged(BR.userName);
    }

    @Bindable
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
        notifyPropertyChanged(BR.pwd);
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
