package com.example.toni.vlifttest.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.toni.vlifttest.R;

public class SplashActivity extends AppCompatActivity {
    public static final long SPLASH_TIME = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this,LoginActivity.class));
                SplashActivity.this.finish();
            }
        },SPLASH_TIME);
    }
}
