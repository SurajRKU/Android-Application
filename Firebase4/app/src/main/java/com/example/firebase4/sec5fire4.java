package com.example.firebase4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class sec5fire4 extends AppCompatActivity {

    public int count,bcount;
    int id1,id2,id3,id4,id5;
    String score;
    TextView Q1;
    TextView Q2;
    TextView Q3;
    TextView Q4;
    TextView Q5;
    RadioButton q1r1;
    RadioButton q1r2;
    RadioButton q1r3;
    RadioButton q1r4;
   String usrn;
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
    Intent intent1;
    Bundle extras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec5fire4);
        submit = findViewById(R.id.submit);
        reset = findViewById(R.id.reset);
        extras= getIntent().getExtras();
        usrn = extras.getString("username");
        r1 = findViewById(R.id.radiogroup_q1);
        r2 = findViewById(R.id.radiogroup_q2);
        r3 = findViewById(R.id.radiogroup_q3);
        r4 = findViewById(R.id.radiogroup_q4);
        r5= findViewById(R.id.radiogroup_q5);
        Q1 = findViewById(R.id.question1);
        Q2 = findViewById(R.id.question2);
        Q3 = findViewById(R.id.question3);
        Q4 = findViewById(R.id.question4);
        Q5 = findViewById(R.id.question5);
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
        intent1 = new Intent(sec5fire4.this,sec6fire4.class);

        Q1.setText("\t If You want subclasses in any package to have access to members of a superclass. Which is the most restrictive access that accomplishes this objective?");

        q1r1.setText("Public");
        q1r2.setText("Private");
        q1r3.setText("Protected");
        q1r4.setText("Transient");

        Q2.setText("Which of the following is/are legal method declarations?\n"

        +"1.protected abstract void m1();\n"+
        "2.static final void m1(){}\n"+
        "3.synchronized public final void m1() {}\n"+
        "4.private native void m1();\n"
);


        q2r1.setText("1 and 3");
        q2r2.setText("2 and 4");
        q2r3.setText("1 only");
        q2r4.setText("All of th above");


        Q3.setText("\t interface Base \n" +
                "{\n" +
                "    boolean m1 ();\n" +
                "    byte m2(short s);\n" +
                "}\n" +
                "\n" +
                "which two code fragments will compile?\n" +
                "\n" +
                "   1.interface Base2 implements Base {}\n" +
                "   2.abstract class Class2 extends Base\n" +
                "    { \npublic boolean m1(){ return true; }}\n" +
                "   3.abstract class Class2 implements Base {}\n" +
                "   4.abstract class Class2 implements Base\n" +
                "    { \npublic boolean m1(){ return (7 > 4); }}\n" +
                "   5.abstract class Class2 implements Base\n" +
                "    { \nprotected boolean m1(){ return (5 > 7) }}\n");

        q3r1.setText("1 and 2");
        q3r2.setText("2 and 3");
        q3r3.setText("3 and 4");
        q3r4.setText("1 and 5");


        Q4.setText("\t public class Test { }\n" +
                "\n" +
                "What is the prototype of the default constructor?\n");

        q4r1.setText("\tTest( )");
        q4r2.setText("\tTest(void)");
        q4r3.setText("\tpublic Test( )");
        q4r4.setText("\tpublic Test(void)");


        Q5.setText("\t Which of the following class level (nonlocal) variable declarations will not compile?");

        q5r1.setText("\tprotected int a;");
        q5r2.setText("\ttransient int b = 3;");
        q5r3.setText("\tprivate synchronized int e");
        q5r4.setText("\tvolatile int d;");


        submit.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                count=0;
                bcount=0;
                if((r1.getCheckedRadioButtonId()==-1) || (r2.getCheckedRadioButtonId()==-1)||(r3.getCheckedRadioButtonId()==-1)||(r4.getCheckedRadioButtonId()==-1)||(r5.getCheckedRadioButtonId()==-1)) {
                   Toast.makeText(sec5fire4.this, "Please Answer all the questions", Toast.LENGTH_SHORT).show();
               }
               else {
                   switch (r1.getCheckedRadioButtonId())
                   {
                       case R.id.rg1b3: {
                           count=count+10;
                           bcount=bcount+10;
                           break;
                       }
                       default:{}

                   };
                   switch (r2.getCheckedRadioButtonId())
                   {
                       case R.id.rg2b4: {
                           count=count+10;
                           bcount=bcount+10;
                           break;
                       }
                       default:{}

                   };
                   switch (r3.getCheckedRadioButtonId())
                   {
                       case R.id.rg3b3: {
                           count=count+10;
                           bcount=bcount+10;
                           break;
                       }
                       default:{}

                   };
                   switch (r4.getCheckedRadioButtonId())
                   {
                       case R.id.rg4b3: {
                           count=count+10;
                           bcount=bcount+10;
                           break;
                       }
                       default:{}

                   };
                   switch (r5.getCheckedRadioButtonId())
                   {
                       case R.id.rg5b3: {
                           count = count+10;
                           bcount=bcount+10;
                           break;
                       }
                       default:{}

                   };

                  // Toast.makeText(sec5fire4.this,"You Scored "+ String.valueOf(bcount)+"/50", Toast.LENGTH_SHORT).show();
                   intent1.putExtra("username",usrn);
                    intent1.putExtra("Score",count);
                   intent1.putExtra("Bfrom5",bcount);
                   startActivity(intent1);

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
