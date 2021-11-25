package com.example.mygit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tv_1);
        handler = new MyHandler(this);
        handler.sendEmptyMessageDelayed(0,1000);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                handler.sendEmptyMessageDelayed(1,500);
            }
        });
        thread.start();
    }

    public void setTextView(String s){
        if(textView!=null){
            textView.setText(s);
        }
    }

    private static class MyHandler extends Handler{
        WeakReference<MainActivity> mainActivityWeakReference;
        MyHandler(MainActivity activity) {
            super();
            mainActivityWeakReference = new WeakReference<>(activity);
        }
        @Override
        public void handleMessage(Message msg) {
            MainActivity activity = mainActivityWeakReference.get();
            if(activity!=null){
                if(msg.what == 1){
                    activity.setTextView("啊不要");
                }else {
                    activity.setTextView("啊哈哈哈");
                }

            }
        }
    }
}
