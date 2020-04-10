package com.snow.aopproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.snow.gintonic.DebugTrace;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "snow_aop";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e(TAG, "当前===onCreate:");

        findViewById(R.id.btn_01).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });
        onMyPrivate();
        onMyPublic();
    }

    private boolean onMyPrivate() {
        return false;
    }

    public void onMyPublic() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "当前===onResume:");
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
