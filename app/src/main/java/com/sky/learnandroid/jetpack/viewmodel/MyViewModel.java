package com.sky.learnandroid.jetpack.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {

    private MutableLiveData<String> name;
    public LiveData<String> getName() {
        if (null == name) {
            name = new MutableLiveData<>();
            addName();
        }
        return name;
    }

    private void addName() {
        name.setValue("sky");
    }
}
