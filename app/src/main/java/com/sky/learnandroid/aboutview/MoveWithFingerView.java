package com.sky.learnandroid.aboutview;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Scroller;

import com.nineoldandroids.view.ViewHelper;

/**
 * Created by shikai on 2018/9/11.
 */

public class MoveWithFingerView extends AppCompatTextView {
    private static final String TAG = "MoveWithFingerView";

    private int mLastX, mLastY;
    private Scroller mScroller = new Scroller(getContext());

    public MoveWithFingerView(Context context) {
        this(context, null);
    }

    public MoveWithFingerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public MoveWithFingerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
//        mScroller = new Scroller(getContext());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "onTouchEvent");
        int x = (int) event.getRawX();
        int y = (int) event.getRawY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG, "ACTION_DOWN");
                break;

            case MotionEvent.ACTION_MOVE:
                Log.d(TAG, "ACTION_MOVE");
                int deltaX = x - mLastX;
                int deltaY = y - mLastY;
                Log.d(TAG, "move, deltaX:" + deltaX + " deltaY:" + deltaY);
                int translationX = (int) ViewHelper.getTranslationX(this) + deltaX;
                int translationY = (int) ViewHelper.getTranslationY(this) + deltaY;
                ViewHelper.setTranslationX(this, translationX);
                ViewHelper.setTranslationY(this, translationY);
                break;

            case MotionEvent.ACTION_UP:
                Log.d(TAG, "ACTION_UP");
                break;
        }

        mLastX = x;
        mLastY = y;
        return true;
    }

    public void smoothScroll(int destX, int destY) {
        int scrollX = getScrollX();
        int deltaX = destX - scrollX;

        mScroller.startScroll(scrollX, 0, deltaX, 0, 1000);
        invalidate();
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        Log.d(TAG, "computeScroll");

        if (mScroller.computeScrollOffset()) {
            Log.d(TAG, "currX=" + mScroller.getCurrX());
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            postInvalidate();
        }
    }
}
