package com.snow.aopproject.touch;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.snow.aopproject.R;
import com.snow.gintonic.bind.BindView;
import com.snow.gintonic.bind.BindViewParser;

/**
 * author : zyt
 * e-mail : 632105276@qq.com
 * date   : 2020-04-10
 * desc   : 测试事件传递
 */
public class SecondActivity extends Activity {
    //可以使用，缺点没有插件支持，开发效率较低
    @BindView(R.id.viewGroup)
    CustomViewGroup viewGroup;
    @BindView(R.id.view)
    CustomTextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        BindViewParser.inject(this);
        viewGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SecondActivity.this, "点击了ViewGroup", Toast.LENGTH_SHORT).show();
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SecondActivity.this, "点击了View", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("snow_aop", "Activity====dispatchTouchEvent=====");
        boolean b = super.dispatchTouchEvent(ev);
        return b;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("snow_aop", "Activity====onTouchEvent=====");
        boolean b = super.onTouchEvent(event);
        return b;
    }
}
