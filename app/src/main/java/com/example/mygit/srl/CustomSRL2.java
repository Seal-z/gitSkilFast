package com.example.mygit.srl;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.lang.reflect.Field;

public class CustomSRL2 extends SwipeRefreshLayout {
    private static final String TAG = "CustomSRL2";

    public CustomSRL2(@NonNull Context context) {
        super(context);
    }

    public CustomSRL2(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    int mLastX;
    int mLastY;

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        return super.onInterceptTouchEvent(ev);
//        Log.e("seal","onInterceptTouchEvent"+ev.getAction());
//        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
//            super.onInterceptTouchEvent(ev);
//            return false;
//        }
//        return true;

        //外部拦截
        int x = (int) ev.getX();
        int y = (int) ev.getY();
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                mLastX = x;
                mLastY = y;
                break;

                case MotionEvent.ACTION_MOVE:
                    int deltX = Math.abs(x- mLastX);
                    int deltY = Math.abs(y -mLastY);
                    if(deltX>deltY){
                        return false;
                    }
                    break;

                    default:
                        break;
        }
        return super.onInterceptTouchEvent(ev);

    }

//    @Override
//    public void requestDisallowInterceptTouchEvent(boolean b) {
////        super.requestDisallowInterceptTouchEvent(b);
//
//        Class clazz = ViewGroup.class;
//        try {
//            Field mGroupFlagsField = clazz.getDeclaredField("mGroupFlags");
//            mGroupFlagsField.setAccessible(true);
//            if (b) {
//                mGroupFlagsField.set(this,2900051);
//            } else {
//                mGroupFlagsField.set(this,2245715);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            Log.d(TAG, "requestDisallowInterceptTouchEvent: "+e.getMessage());
//        }
//    }
}
