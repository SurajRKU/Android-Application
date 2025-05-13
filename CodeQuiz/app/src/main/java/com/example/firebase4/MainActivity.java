package com.example.firebase4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    Intent homeintent;
    ProgressBar progressBar;
 private static int SPLASH_TIME_OUT=4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Handler handler = new Handler();
        progressBar =findViewById(R.id.progressbar);
        progressBar.setVisibility(View.VISIBLE);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                homeintent = new Intent(MainActivity.this,sec2fire4.class);
               startActivity(homeintent);
                progressBar.setVisibility(View.GONE);
               finish();
            }
        },SPLASH_TIME_OUT);
    }
}
