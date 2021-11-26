package com.example.mygit.srl;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.ViewPager;

public class CustomVPInner extends ViewPager {
    public CustomVPInner(@NonNull Context context) {
        super(context);
    }

    public CustomVPInner(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    int mLastX;
    int mLastY;
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        int x = (int)ev.getY();
        int y= (int)ev.getY();
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.e("seal","dispatchTouchEvent down");
                mLastX = x;
                mLastY = y;
//                ViewCompat.setNestedScrollingEnabled(this,true);
                getParent().requestDisallowInterceptTouchEvent(true);
                break;

            case MotionEvent.ACTION_MOVE:
                Log.e("seal","dispatchTouchEvent move");
                int deltX = x-mLastX;
                int deltY = y-mLastY;
                if(Math.abs(deltX)<Math.abs(deltY)){
//                    ViewCompat.setNestedScrollingEnabled(this,true);
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
                break;

            case MotionEvent.ACTION_UP:
                break;

                default:
                    break;
        }
        return super.dispatchTouchEvent(ev);
    }
}
