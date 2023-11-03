package com.example.firebase4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class sec7fire4 extends AppCompatActivity {
    TextView eq1,eq2,eq3,eq4,eq5;
    int count,bcount,icount,ecount;
    RadioButton q1r1;
    RadioButton q1r2;
    RadioButton q1r3;
    RadioButton q1r4;

    RadioButton q2r1;
    RadioButton q2r2;
    RadioButton q2r3;
    RadioButton q2r4;

    RadioButton q3r1;
    RadioButton q3r2;
    RadioButton q3r3;
    RadioButton q3r4;

    RadioButton q4r1;
    RadioButton q4r2;
    RadioButton q4r3;
    RadioButton q4r4;
  Bundle extrasnav;
    RadioButton q5r1;
    RadioButton q5r2;
    RadioButton q5r3;
    RadioButton q5r4;

    RadioGroup r1;
    RadioGroup r2;
    RadioGroup r3;
    RadioGroup r4;
    RadioGroup r5;

    Button submit;
    Button reset;
   Bundle extras,extras2,extras3;
   Intent intent3;
 String usrn;
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec7fire4);

        eq1=findViewById(R.id.question1);
        eq2=findViewById(R.id.question2);
        eq3=findViewById(R.id.question3);
        eq4=findViewById(R.id.question4);
        eq5=findViewById(R.id.question5);
        submit = findViewById(R.id.submit);
        reset = findViewById(R.id.reset);
        r1 = findViewById(R.id.radiogroup_q1);
        r2 = findViewById(R.id.radiogroup_q2);
        r3 = findViewById(R.id.radiogroup_q3);
        r4 = findViewById(R.id.radiogroup_q4);
        r5= findViewById(R.id.radiogroup_q5);

        q1r1 = findViewById(R.id.rg1b1);
        q1r2 = findViewById(R.id.rg1b2);
        q1r3 = findViewById(R.id.rg1b3);
        q1r4 = findViewById(R.id.rg1b4);

        q2r1 = findViewById(R.id.rg2b1);
        q2r2 = findViewById(R.id.rg2b2);
        q2r3 = findViewById(R.id.rg2b3);
        q2r4 = findViewById(R.id.rg2b4);

        q3r1 = findViewById(R.id.rg3b1);
        q3r2 = findViewById(R.id.rg3b2);
        q3r3 = findViewById(R.id.rg3b3);
        q3r4 = findViewById(R.id.rg3b4);

        q4r1 = findViewById(R.id.rg4b1);
        q4r2 = findViewById(R.id.rg4b2);
        q4r3 = findViewById(R.id.rg4b3);
        q4r4 = findViewById(R.id.rg4b4);

        q5r1 = findViewById(R.id.rg5b1);
        q5r2 = findViewById(R.id.rg5b2);
        q5r3 = findViewById(R.id.rg5b3);
        q5r4 = findViewById(R.id.rg5b4);

        eq1.setText("Suppose that you would like to create an instance of a new Map that has an iteration order that is the same as the iteration order of an existing instance of a Map. Which concrete implementation of the Map interface should be used for the new instance?");
        eq2.setText("Which class does not override the equals() and hashCode() methods, inheriting them directly from class Object?");
        eq3.setText("Which collection class allows you to grow or shrink its size and provides indexed access to its elements, but whose methods are not synchronized?");
        eq4.setText("You need to store elements in a collection that guarantees that no duplicates are stored and all elements can be accessed in natural order. Which interface provides that capability?");
        eq5.setText("Which interface does java.util.Hashtable implement?");
        //Question 1
        q1r1.setText("TreeMap");
        q1r2.setText("HashMap");
        q1r3.setText("LinkedHashMap");
        q1r4.setText("Answer depends upon the implementation");

        //Question 2
        q2r1.setText("java.lang.String");
        q2r2.setText("java.lang.Double");
        q2r3.setText("java.lang.StringBuffer");
        q2r4.setText("java.lang.Character");

        //Question 3
        q3r1.setText("java.util.HashSet");
        q3r2.setText("java.util.LinkedHashSet");
        q3r3.setText("java.util.List");
        q3r4.setText("java.util.ArrayList");

        //Question 4
        q4r1.setText("java.util.Map");
        q4r2.setText("java.util.Set");
        q4r3.setText("java.util.List");
        q4r4.setText("java.util.Collection");

        //Question 5
        q5r1.setText("Java.util.Map");
        q5r2.setText("Java.util.List");
        q5r3.setText("Java.util.HashTable");
        q5r4.setText("Java.util.Collection");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                extras = getIntent().getExtras();
                extras2=getIntent().getExtras();
                extras3=getIntent().getExtras();
                count = extras.getInt("Score2");
                ecount=0;
                if((r1.getCheckedRadioButtonId()==-1) || (r2.getCheckedRadioButtonId()==-1)||(r3.getCheckedRadioButtonId()==-1)||(r4.getCheckedRadioButtonId()==-1)||(r5.getCheckedRadioButtonId()==-1)) {
                    Toast.makeText(sec7fire4.this, "Please Answer all the questions", Toast.LENGTH_SHORT).show();

                }
                else {
                    switch (r1.getCheckedRadioButtonId())
                    {
                        case R.id.rg1b3: {
                            count=count+10;
                            ecount = ecount+10;
                            break;
                        }
                        default:{}

                    };
                    switch (r2.getCheckedRadioButtonId())
                    {
                        case R.id.rg2b3: {
                            count=count+10;
                            ecount = ecount+10;
                            break;
                        }
                        default:{}

                    };
                    switch (r3.getCheckedRadioButtonId())
                    {
                        case R.id.rg3b4: {
                            count=count+10;
                            ecount = ecount+10;
                            break;
                        }
                        default:{}

                    };
                    switch (r4.getCheckedRadioButtonId())
                    {
                        case R.id.rg4b2: {
                            count=count+10;
                            ecount = ecount+10;
                            break;
                        }
                        default:{}

                    };
                    switch (r5.getCheckedRadioButtonId())
                    {
                        case R.id.rg5b1: {
                            count=count+10;
                            ecount = ecount+10;
                            break;
                        }
                        default:{}

                    }
                   // Toast.makeText(sec7fire4.this,"You Scored "+ String.valueOf(ecount)+"/50", Toast.LENGTH_SHORT).show();
                    intent3 = new Intent(sec7fire4.this,sec8fire4.class);
                    extrasnav=getIntent().getExtras();
                    usrn = extrasnav.getString("username");

                    bcount = extras2.getInt("Bfrom5");
                    icount = extras3.getInt("Ifrom6");
                    intent3.putExtra("username",usrn);
                    intent3.putExtra("Bfrom5",bcount);
                    intent3.putExtra("Totalscore",count);
                    intent3.putExtra("Ifrom6",icount);
                    intent3.putExtra("Efrom7",ecount);
                    startActivity(intent3);
                  new Handler().postDelayed(new Runnable() {
                      @Override
                      public void run() {
                          finishAffinity();
                      }
                  },500);

                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                r1.clearCheck();
                r2.clearCheck();
                r3.clearCheck();
                r4.clearCheck();
                r5.clearCheck();
            }
        });










    }
}
