package com.example.firebase4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class thirdresult extends AppCompatActivity {
  ProgressBar progressBar;
  TextView t1;
  Handler handler;
  Intent intent;
    Bundle extras1,extras2,extras3,extras4,extras5;
    int t1count,t2count,t3count,total_score;
    String idd;
  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirdresult);
      progressBar=findViewById(R.id.progressbar);
      t1= findViewById(R.id.load);
      progressBar.setVisibility(View.VISIBLE);
      t1.setVisibility(View.VISIBLE);
      extras1 = getIntent().getExtras();
      extras2=getIntent().getExtras();
      extras3=getIntent().getExtras();
      extras4=getIntent().getExtras();
      extras5= getIntent().getExtras();
      t1count = extras1.getInt("fromt1");
      t2count = extras2.getInt("fromt2");
      t3count = extras3.getInt("fromt3");
      total_score = extras4.getInt("total");
      idd=extras5.getString("username");
      handler=new Handler();
       intent=new Intent(thirdresult.this,third4fire4.class);
       intent.putExtra("username",idd);
       intent.putExtra("fromt1",t1count);
       intent.putExtra("fromt2",t2count);
       intent.putExtra("fromt3",t3count);
       intent.putExtra("total",total_score);
       handler.postDelayed(new Runnable() {
            @Override
            public void run() {


                startActivity(intent);

                finishAffinity();
            }
        },4000);



  }
}
