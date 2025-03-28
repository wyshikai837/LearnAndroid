package com.sky.learnandroid.lifecycler;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.sky.learnandroid.R;

public class TestFragment extends Fragment {

    private static final String TAG = "TestFragment";

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(TAG, "---> onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "---> onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "---> onCreateView");
        View v = inflater.inflate(R.layout.fragment_test, container, false);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "---> onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "---> onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "---> onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "---> onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "---> onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "---> onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "---> onDetach");
    }
}
