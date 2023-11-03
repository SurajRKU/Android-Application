package com.example.firebase4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;


import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
public class sec6fire4 extends AppCompatActivity {
   Bundle extras,extras2,extras3;
    TextView iq1, iq2, iq3, iq4, iq5;
    int count,bcount,icount;
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
    Intent intent2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec6fire4);
        intent2 = new Intent(sec6fire4.this , sec7fire4.class);


            iq1 = findViewById(R.id.question1);
            iq2 = findViewById(R.id.question2);
            iq3 = findViewById(R.id.question3);
            iq4 = findViewById(R.id.question4);
            iq5 = findViewById(R.id.question5);
            submit = findViewById(R.id.submit);
            reset = findViewById(R.id.reset);
            r1 = findViewById(R.id.radiogroup_q1);
            r2 = findViewById(R.id.radiogroup_q2);
            r3 = findViewById(R.id.radiogroup_q3);
            r4 = findViewById(R.id.radiogroup_q4);
            r5 = findViewById(R.id.radiogroup_q5);

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

            iq1.setText("Which four options describe the correct default values for array elements of the types indicated?\n" +
                    "\n" +
                    "  1.  int -> 0\n" +
                    "  2.  String -> \"null\"\n" +
                    "  3.  Dog -> null\n" +
                    "  4  char -> '\\u0000'\n" +
                    "  5  float -> 0.0f\n" +
                    "  6 boolean -> true");
            iq2.setText("Which one of these lists contains only Java programming language keywords?\n");
            iq3.setText("Which will legally declare, construct, and initialize an array?");
            iq4.setText("Which is a reserved word in the Java programming language?");
            iq5.setText("Which three are legal array declarations?\n" +
                    "\n" +
                    "   1. int [] myScores [];\n" +
                    "   2. char [] myChars;\n" +
                    "   3. int [6] myScores;\n" +
                    "   4. Dog myDogs [];\n" +
                    "   5. Dog myDogs [7];\n");
            //Question 1
            q1r1.setText("1,2,3,4");
            q1r2.setText("1,3,4,5");
            q1r3.setText("2,4,5,6");
            q1r4.setText("3,4,5,6");

            //Question 2
            q2r1.setText("class, if, void, long, Int, continue");
            q2r2.setText("goto, instanceof, native, finally, default, throws");
            q2r3.setText("try, virtual, throw, final, volatile, transient");
            q2r4.setText("strictfp, constant, super, implements, do");

            //Question 3
            q3r1.setText("int [] myList = {\"1\", \"2\", \"3\"};");
            q3r2.setText("int [] myList = (5, 8, 2);");
            q3r3.setText("int myList [] [] = {4,9,7,0};");
            q3r4.setText("int myList [] = {4, 3, 7};");

            //Question 4
            q4r1.setText("Method");
            q4r2.setText("Native");
            q4r3.setText("subclasses");
            q4r4.setText("reference");

            //Question 5
            q5r1.setText("1,2,4");
            q5r2.setText("2,4,5");
            q5r3.setText("2,3,4");
            q5r4.setText("All are correct");

            submit.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View view) {
                    extras2=getIntent().getExtras();
                    extras= getIntent().getExtras();
                    extras3=getIntent().getExtras();
                    usrn = extras3.getString("username");
                    count = extras.getInt("Score");
                     icount=0;
                    if ((r1.getCheckedRadioButtonId() == -1) || (r2.getCheckedRadioButtonId() == -1) || (r3.getCheckedRadioButtonId() == -1) || (r4.getCheckedRadioButtonId() == -1) || (r5.getCheckedRadioButtonId() == -1)) {
                        Toast.makeText(sec6fire4.this, "Please Answer all the questions", Toast.LENGTH_SHORT).show();

                    } else {
                        switch (r1.getCheckedRadioButtonId()) {
                            case R.id.rg1b2: {
                                count = count + 10;
                                icount = icount + 10;
                                break;
                            }
                            default: {
                            }

                        }
                        ;
                        switch (r2.getCheckedRadioButtonId()) {
                            case R.id.rg2b2: {
                                count = count + 10;
                                icount = icount + 10;
                                break;
                            }
                            default: {
                            }

                        }
                        ;
                        switch (r3.getCheckedRadioButtonId()) {
                            case R.id.rg3b4: {
                                count = count + 10;
                                icount = icount + 10;
                                break;
                            }
                            default: {
                            }

                        }
                        ;
                        switch (r4.getCheckedRadioButtonId()) {
                            case R.id.rg4b2: {
                                count = count + 10;
                                icount = icount + 10;
                                break;
                            }
                            default: {
                            }

                        };

                        switch (r5.getCheckedRadioButtonId()) {
                            case R.id.rg5b1: {
                                count = count + 10;
                                icount = icount + 10;
                                break;
                            }
                            default: {}

                        };

                       // Toast.makeText(sec6fire4.this, "You Scored " + String.valueOf(icount) + "/50", Toast.LENGTH_SHORT).show();
                        bcount = extras2.getInt("Bfrom5");
                       intent2.putExtra("username",usrn);
                        intent2.putExtra("Bfrom5",bcount);
                        intent2.putExtra("Score2",count);
                        intent2.putExtra("Ifrom6",icount);
                        startActivity(intent2);
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
