package com.example.firebase4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class sec9fire4 extends AppCompatActivity {
Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec9fire4);
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {


                finishAffinity();

            }
        },3000);

    }
}
