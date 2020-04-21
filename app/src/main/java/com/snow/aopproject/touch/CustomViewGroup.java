package com.snow.aopproject.touch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

/**
 * author : snowzhao
 * e-mail : zyt@ttsing.com
 * date   : 2020/4/20
 * desc   :
 */
public class CustomViewGroup extends LinearLayout {
    public CustomViewGroup(Context context) {
        super(context);
    }

    public CustomViewGroup(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomViewGroup(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("snow_aop", "ViewGroup====dispatchTouchEvent=====");
        boolean b = super.dispatchTouchEvent(ev);
        return b;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e("snow_aop", "ViewGroup====onInterceptTouchEvent=====");
//        boolean b = super.onInterceptTouchEvent(ev);
//        return b;
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("snow_aop", "ViewGroup====onTouchEvent=====");
        boolean b = super.onTouchEvent(event);
        return b;
    }

}
