package com.example.mygit.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

public class BadViewPager extends ViewPager {

    public BadViewPager(@NonNull Context context) {
        super(context);
    }

    public BadViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    int mLastX;
    int mLastY;

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        if(ev.getAction() == MotionEvent.ACTION_DOWN){
//            super.onInterceptTouchEvent(ev);
//            return false;
//        }
//        return true;
        int x = (int) ev.getX();
        int y = (int) ev.getY();
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mLastY = (int)ev.getY();
                mLastX = (int)ev.getX();
            break;

            case MotionEvent.ACTION_MOVE:
                int deltX = x - mLastX;
                int deltY = y - mLastY;
                if (Math.abs(deltX) > Math.abs(deltY)) {
                    return true;
                }
                break;

            case MotionEvent.ACTION_UP:
                break;

            default:
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }
}
