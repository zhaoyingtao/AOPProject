package com.snow.aopproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.snow.gintonic.custom.DebugTimeConsuming;
import com.snow.gintonic.UserBean;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "snow_aop";

    @DebugTimeConsuming
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_01).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });
//        myPrivate("李四");
//        myPublic(new UserBean("张三", 19));

        customAopMethod();
    }

    @DebugTimeConsuming
    private void customAopMethod() {

    }

    private boolean myPrivate(String mm) {
        return false;
    }

    public void myPublic(UserBean userBean) {

    }

    @Override
    protected void onResume() {
        super.onResume();
//        Log.e(TAG, "当前===onResume:");
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
