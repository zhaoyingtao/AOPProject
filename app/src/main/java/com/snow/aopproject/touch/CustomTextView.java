package com.snow.aopproject.touch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

/**
 * author : snowzhao
 * e-mail : zyt@ttsing.com
 * date   : 2020/4/20
 * desc   :
 */
public class CustomTextView extends AppCompatTextView {
    public CustomTextView(Context context) {
        super(context);
    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("snow_aop", "view====dispatchTouchEvent====开始=");
        boolean b = super.dispatchTouchEvent(ev);
        return b;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("snow_aop", "view====onTouchEvent====开始=");
        boolean b = super.onTouchEvent(event);
        return b;
    }
}
