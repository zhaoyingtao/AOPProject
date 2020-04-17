package com.snow.aopproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.snow.gintonic.UserBean;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "snow_aop";

    //    @DebugTimeConsuming
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myPrivate("李四");
        myPublic(new UserBean("张三", 19));
        myNoParamsMethod();
        findViewById(R.id.btn_01).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AActivity.class));
            }
        });
    }

    private void myNoParamsMethod() {

    }

    private boolean myPrivate(String mm) {
        return false;
    }

    public void myPublic(UserBean userBean) {

    }

    //    @DebugTimeConsuming//打印方法执行的时间
//    private void customAopMethod() {
//
//    }
//    @Override
//    protected void onRestart() {
//        super.onRestart();
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//    }
//
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//    }
}
