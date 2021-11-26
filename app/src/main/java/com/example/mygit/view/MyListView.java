package com.example.mygit.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

public class MyListView extends ListView {

    public MyListView(Context context) {
        super(context);
    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private int mLastX;
    private int mLastY;

//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        int x = (int) ev.getX();
//        int y = (int) ev.getY();
//
//        switch (ev.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                mLastY = y;
//                mLastX = x;
//                getParent().requestDisallowInterceptTouchEvent(true);
//                break;
//
//            case MotionEvent.ACTION_MOVE:
//                int deltX = x - mLastX;
//                int deltY = y - mLastY;
//                if (Math.abs(deltX) > Math.abs(deltY)) {
//                    getParent().requestDisallowInterceptTouchEvent(false);
//                }
//                break;
//
//            case MotionEvent.ACTION_UP:
//                break;
//
//            default:
//                break;
//        }
////        mLastY = y;
////        mLastX = x;
//        return super.dispatchTouchEvent(ev);
//    }
}
