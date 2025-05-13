package com.example.firebase4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class sec4fire4 extends AppCompatActivity {
    RadioGroup rg;
    RadioButton procedure;
    RadioButton object;
    RadioButton leader;
    Button proceed;
    Intent intent1,intent2,intent3;
   Bundle extras1;
   String idd;
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec4fire4);
        procedure = findViewById(R.id.Procedure);
        object = findViewById(R.id.Object);
        rg = findViewById(R.id.radio_group);
        intent1 = new Intent(sec4fire4.this, sec5fire4.class);
        proceed = findViewById(R.id.Proceed);
        intent3=new Intent(sec4fire4.this,leaderboard.class);
        leader=findViewById(R.id.leaderboard2);
        intent2= new Intent(sec4fire4.this,third1fire4.class);
        extras1=getIntent().getExtras();
        idd =extras1.getString("username");
        //extras2=getIntent().getExtras();
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               if(rg.getCheckedRadioButtonId()==-1)
               {
                   Toast.makeText(sec4fire4.this,"Please select one of above",Toast.LENGTH_SHORT).show();
               }

                switch (rg.getCheckedRadioButtonId()) {
                    case R.id.Procedure :{
                        intent2.putExtra("username",idd);
                       // Toast.makeText(sec4fire4.this,idd,Toast.LENGTH_SHORT).show();
                        startActivity(intent2);
                        break;
                    }

                    case R.id.Object:{
                        intent1.putExtra("username",idd);
                        startActivity(intent1);
                      break;
                    }

                    case R.id.leaderboard2:{

                        startActivity(intent3);
                      break;
                    }


                };
            }
        });

    }
}