package com.snow.aopproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.snow.gintonic.bind.BindView;
import com.snow.gintonic.bind.BindViewParser;
import com.snow.gintonic.custom.DebugTrace;

/**
 * author : zyt
 * e-mail : 632105276@qq.com
 * date   : 2020-04-10
 * desc   :
 */
public class SecondActivity extends Activity {
    //可以使用，缺点没有插件支持，开发效率较低
    @BindView(R.id.btn_01)
    Button btn01;
    @BindView(R.id.textview)
    TextView textView;

    @DebugTrace
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        BindViewParser.inject(this);
        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("我是被点击显示textview");
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
