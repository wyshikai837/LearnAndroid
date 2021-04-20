package com.sky.learnandroid.aboutview;

import android.app.Activity;
import android.content.Intent;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.sky.learnandroid.R;

public class MoveWithFingerActivity extends AppCompatActivity {

    private static final String TAG = "MoveWithFingerActivity";

    public static void startMoveWithFingerActivity(Activity activity) {
        Intent intent = new Intent(activity, MoveWithFingerActivity.class);
        activity.startActivity(intent);
    }

    private MoveWithFingerView mMoveWithFingerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_finger);

        setTitle("MoveWithFingerActivity");

        mMoveWithFingerView = findViewById(R.id.move_with_finger_view);
        findViewById(R.id.btn_start_scroll).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMoveWithFingerView.smoothScroll(-50, 0);
            }
        });
    }
}
