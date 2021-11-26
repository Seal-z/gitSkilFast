package com.example.mygit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.example.mygit.srl.Main2Activity;
import com.example.mygit.view.BadViewPager;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Handler handler;

    private int[] iv = new int[]{R.mipmap.iv_0, R.mipmap.iv_1, R.mipmap.iv_2,
            R.mipmap.iv_3, R.mipmap.iv_4, R.mipmap.iv_5,
            R.mipmap.iv_6, R.mipmap.iv_7, R.mipmap.iv_8};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tv_1);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });
//        handler = new MyHandler(this);
//        handler.sendEmptyMessageDelayed(0,1000);
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                handler.sendEmptyMessageDelayed(1,500);
//            }
//        });
//        thread.start();
        BadViewPager pager = findViewById(R.id.viewpager);
        List<Map<String,Integer>> strings = new ArrayList<>();
        Map<String,Integer> map;
        for(int i = 0;i<20;i++){
            map = new HashMap<>();
            map.put("key",iv[i%9]);
            strings.add(map);
        }
        MyPagerAdapter adapter = new MyPagerAdapter(this, strings);
        pager.setAdapter(adapter);
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
