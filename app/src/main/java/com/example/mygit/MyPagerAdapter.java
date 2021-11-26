package com.example.mygit;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;
import java.util.Map;

public class MyPagerAdapter extends PagerAdapter {

    private Context mContext;
    private List<Map<String,Integer>> mData;

    public MyPagerAdapter(Context context,List<Map<String,Integer>> list){
        mContext = context;
        mData  = list;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = View.inflate(mContext,R.layout.item_list,null);
        ListView list = view.findViewById(R.id.list);
        list.setAdapter(new SimpleAdapter(container.getContext(), mData, R.layout.item_base, new String[]{"key"}, new int[]{R.id.iv}));
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
