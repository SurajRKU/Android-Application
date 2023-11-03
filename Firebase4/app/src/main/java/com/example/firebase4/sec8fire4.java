package com.example.firebase4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class sec8fire4 extends AppCompatActivity {
TextView basic , inter,expert,total,per;
 Bundle extras1,extras2,extras3,extras4,extrasnav;
 String  usrn;
boolean doubleBackToExitPressedOnce;
 Button quit,menu;
 int bcount,icount,ecount,t;
    Intent intent,intent1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec8fire4);
       basic =findViewById(R.id.basic);
       menu = findViewById(R.id.menuoff);
       inter = findViewById(R.id.intermediate);
       expert = findViewById(R.id.expert);
       total = findViewById(R.id.total);
       quit = findViewById(R.id.thank);
       per=findViewById(R.id.performance);
       extras1 = getIntent().getExtras();
       extras2=getIntent().getExtras();
       extras3=getIntent().getExtras();
       extras4=getIntent().getExtras();
//doubleBackPressedOnce = false;
        doubleBackToExitPressedOnce=false;
        bcount = extras1.getInt("Bfrom5");
        icount = extras2.getInt("Ifrom6");
        ecount = extras3.getInt("Efrom7");
        t = extras4.getInt("Totalscore");
       basic.setText(String.valueOf(bcount)+"/50");
        inter.setText(String.valueOf(icount)+"/50");
        expert.setText(String.valueOf(ecount)+"/50");
        total.setText(String.valueOf(t)+"/150");
  intent = new Intent(sec8fire4.this,sec9fire4.class);

        if(t>=120){
        per.setText("Outstanding Performance!!!");
        }
       else if(t<120&&t>=90) {
            per.setText("Excellent Performance!!!");
        }
         else if(t<90&&t>=40)
             per.setText("Good Performance!!!");
         else
             per.setText("Poor Performance!!!");

       quit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               startActivity(intent);

           }
       });

    menu.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            extrasnav=getIntent().getExtras();
            usrn = extrasnav.getString("username");

            intent1=new Intent(sec8fire4.this,nav_bar.class);
             intent1.putExtra("username",usrn);
                    startActivity(intent1);
               new Handler().postDelayed(new Runnable() {
                   @Override
                   public void run() {
                       finishAffinity();
                   }
               },500);

        }
    });


    }

    @Override
    public void onBackPressed() {

        if(doubleBackToExitPressedOnce==true)
        {
            super.onBackPressed();
            finishAffinity();
        }
        else
        {
            this.doubleBackToExitPressedOnce=true;
            Toast.makeText(sec8fire4.this,"Press back again to exit",Toast.LENGTH_SHORT).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubleBackToExitPressedOnce= false;
                }
            },2000);



        }

    }





}
