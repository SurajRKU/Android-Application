package com.example.firebase4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

public class thrid2fire4 extends AppCompatActivity {
    public int Correctanswer=0;
    int id1, id2, id3, id4, id5;
    //  ProgressBar progressBar;
    String score;
    TextView g1;
    TextView g2;
    TextView g3;
    TextView g4;
    TextView g5;
    TextView loading;
    int rand, rand2, rand3, rand4, rand5;

    TextView Q1;
    TextView Q2;
    TextView Q3;
    TextView Q4;
    TextView Q5;
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

    RadioButton q5r1;
    RadioButton q5r2;
    RadioButton q5r3;
    RadioButton q5r4;
    RadioGroup r1;
    RadioGroup r2;
    RadioGroup r3;
    RadioGroup r4;
    RadioGroup r5;
    Button next;
    Button reset;
    Button back;
    Random rnd;
    Intent intent;
    int t1count;
    int t2count;
    String idd,idd2,idd3,idd4,idd5;
    DatabaseReference databaseReference;
    Entity2 question1, question2, question3, question4, question5;
    String a1, a2, a3, a4, a5,user;
    long  m1, m2, m3, m4, m5;
    RadioButton k1;
    RadioButton k2;
    RadioButton k3;
    RadioButton k4;
    RadioButton k5;
  Bundle extras1,extras2,extras3,extras4;
    TextView t1 ,t2 ,t3 ,t4,t5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_thrid2fire4);
        extras4=getIntent().getExtras();
        user= extras4.getString("username");
        init();
      updatequestion();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Correctanswer=extras1.getInt("total");
                t2count=0;

                if (r1.getCheckedRadioButtonId() == -1 || r2.getCheckedRadioButtonId() == -1 || r3.getCheckedRadioButtonId() == -1 || r4.getCheckedRadioButtonId() == -1 || r5.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(thrid2fire4.this, "Please answer all the questions", Toast.LENGTH_SHORT).show();
                } else {
                    if (r1.getCheckedRadioButtonId() != -1) {
                        m1 = r1.getCheckedRadioButtonId();
                        k1 = findViewById((int) m1);
                        idd = k1.getText().toString().trim();
                        if (idd.equals(a1)) {
                            Correctanswer = Correctanswer + 10;
                           t2count=t2count+10;
                        }
                    }
                    if (r2.getCheckedRadioButtonId() != -1) {
                        m2 = r2.getCheckedRadioButtonId();
                        k2 = findViewById((int) m2);
                        idd2 = k2.getText().toString().trim();
                        if (idd2.equals(a2)) {
                            Correctanswer = Correctanswer + 10;
                            t2count=t2count+10;
                        }

                    }

                    if (r3.getCheckedRadioButtonId() != -1) {

                        m3 = r3.getCheckedRadioButtonId();
                        k3 = findViewById((int) m3);
                        idd3 = k3.getText().toString().trim();
                        if (idd3.equals(a3)) {
                            Correctanswer = Correctanswer + 10;
                            t2count=t2count+10;
                        }
                    }
                    if (r4.getCheckedRadioButtonId() != -1) {
                        m4 = r4.getCheckedRadioButtonId();
                        k4 = findViewById((int) m4);
                        idd4 = k4.getText().toString().trim();
                        if (idd4.equals(a4)) {
                            Correctanswer = Correctanswer + 10;
                            t2count=t2count+10;
                        }
                    }
                    if (r5.getCheckedRadioButtonId() != -1) {

                        m5 = r5.getCheckedRadioButtonId();
                        k5 = findViewById((int) m5);
                        idd5 = k5.getText().toString().trim();
                        if (idd5.equals(a5)) {
                            Correctanswer = Correctanswer + 10;
                            t2count=t2count+10;
                        }

                    }
                    intent.putExtra("username",user);
                    intent.putExtra("index",rand5);
                    intent.putExtra("fromt1",t1count);
                    intent.putExtra("fromt2",t2count);
                    intent.putExtra("total",Correctanswer);
                    //Toast.makeText(thrid2fire4.this,user,Toast.LENGTH_SHORT).show();
                    //  Toast.makeText(thrid2fire4.this, String.valueOf(Correctanswer), Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    //t2count=0;
                }
            }
        });

    reset.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            clearfn();
        }
    });

    }

    public void init() {
        // progressBar.setVisibility(View.VISIBLE);
        loading = findViewById(R.id.loading);
        loading.setVisibility(View.VISIBLE);
        // progressBar= findViewById(R.id.progressbar);
          intent=new Intent(thrid2fire4.this,third3fire4.class);
        extras1 = getIntent().getExtras();
       extras2=getIntent().getExtras();
       extras3=getIntent().getExtras();

       t1count = extras2.getInt("fromt1");
        rand=extras3.getInt("index")+1;
        question1 = new Entity2();
        question2 = new Entity2();
        question3 = new Entity2();
        question4 = new Entity2();
        question5 = new Entity2();
        next = findViewById(R.id.next);

        reset = findViewById(R.id.allclear);
        t1 = findViewById(R.id.question1);
        t2 = findViewById(R.id.question2);
        t3 = findViewById(R.id.question3);
        t4 = findViewById(R.id.question4);
        t5 = findViewById(R.id.question5);
        g1 = findViewById(R.id.big1);
        g2 = findViewById(R.id.big2);


        g3 = findViewById(R.id.big3);
        g4 = findViewById(R.id.big4);
        g5 = findViewById(R.id.big5);


        r1 = findViewById(R.id.rgq1);
        r2 = findViewById(R.id.rgq2);
        r3 = findViewById(R.id.rgq3);
        r4 = findViewById(R.id.rgq4);
        r5 = findViewById(R.id.rgq5);
        Q1 = findViewById(R.id.question1);
        Q2 = findViewById(R.id.question2);
        Q3 = findViewById(R.id.question3);
        Q4 = findViewById(R.id.question4);
        Q5 = findViewById(R.id.question5);
        q1r1 = findViewById(R.id.rg11b1);
        q1r2 = findViewById(R.id.rg11b2);
        q1r3 = findViewById(R.id.rg11b3);
        q1r4 = findViewById(R.id.rg11b4);

        q2r1 = findViewById(R.id.rg22b1);
        q2r2 = findViewById(R.id.rg22b2);
        q2r3 = findViewById(R.id.rg22b3);
        q2r4 = findViewById(R.id.rg22b4);

        q3r1 = findViewById(R.id.rg33b1);
        q3r2 = findViewById(R.id.rg33b2);
        q3r3 = findViewById(R.id.rg33b3);
        q3r4 = findViewById(R.id.rg33b4);

        q4r1 = findViewById(R.id.rg44b1);
        q4r2 = findViewById(R.id.rg44b2);
        q4r3 = findViewById(R.id.rg44b3);
        q4r4 = findViewById(R.id.rg44b4);

        q5r1 = findViewById(R.id.rg55b1);
        q5r2 = findViewById(R.id.rg55b2);
        q5r3 = findViewById(R.id.rg55b3);
        q5r4 = findViewById(R.id.rg55b4);
    }

    public void updatequestion()
    {
        //   progressBar.setVisibility(View.VISIBLE);


        loading.setVisibility(View.VISIBLE);

        //rnd = new Random();


        rand2 = rand + 1;
        rand3 = rand + 2;
        rand4 = rand + 3;
        rand5 = rand + 4;

        final String sk1 = String.valueOf(rand);
        final String sk2 = String.valueOf(rand2);
        final String sk3 = String.valueOf(rand3);
        final String sk4 = String.valueOf(rand4);
        final String sk5 = String.valueOf(rand5);
        //  String sk2 = String.valueOf(rand)

        databaseReference = FirebaseDatabase.getInstance().getReference("Online_questions").child("questions_database");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                final Entity2 question1 = dataSnapshot.child(sk1).getValue(Entity2.class);
                Q1.setText(question1.getQuestion());
                q1r1.setText(question1.getOption1());
                q1r2.setText(question1.getOption2());
                q1r3.setText(question1.getOption3());
                q1r4.setText(question1.getOption4());
                a1 = question1.getAnswer().trim();

                final Entity2 question2 = dataSnapshot.child(sk2).getValue(Entity2.class);
                Q2.setText(question2.getQuestion());
                q2r1.setText(question2.getOption1());
                q2r2.setText(question2.getOption2());
                q2r3.setText(question2.getOption3());
                q2r4.setText(question2.getOption4());
                a2 = question2.getAnswer().trim();

                final Entity2 question3 = dataSnapshot.child(sk3).getValue(Entity2.class);
                Q3.setText(question3.getQuestion());
                q3r1.setText(question3.getOption1());
                q3r2.setText(question3.getOption2());
                q3r3.setText(question3.getOption3());
                q3r4.setText(question3.getOption4());
                a3 = question3.getAnswer().trim();

                final Entity2 question4 = dataSnapshot.child(sk4).getValue(Entity2.class);
                Q4.setText(question4.getQuestion());
                q4r1.setText(question4.getOption1());
                q4r2.setText(question4.getOption2());
                q4r3.setText(question4.getOption3());
                q4r4.setText(question4.getOption4());
                a4 = question4.getAnswer().trim();

                final Entity2 question5 = dataSnapshot.child(sk5).getValue(Entity2.class);
                Q5.setText(question5.getQuestion());
                q5r1.setText(question5.getOption1());
                q5r2.setText(question5.getOption2());
                q5r3.setText(question5.getOption3());
                q5r4.setText(question5.getOption4());
                a5 = question5.getAnswer().trim();
                g1.setVisibility(View.VISIBLE);
                g2.setVisibility(View.VISIBLE);
                g3.setVisibility(View.VISIBLE);
                g4.setVisibility(View.VISIBLE);
                g5.setVisibility(View.VISIBLE);
                t1.setVisibility(View.VISIBLE);
                t2.setVisibility(View.VISIBLE);
                t3.setVisibility(View.VISIBLE);
                t4.setVisibility(View.VISIBLE);
                t5.setVisibility(View.VISIBLE);
                r1.setVisibility(View.VISIBLE);
                r2.setVisibility(View.VISIBLE);
                r3.setVisibility(View.VISIBLE);
                r4.setVisibility(View.VISIBLE);
                r5.setVisibility(View.VISIBLE);


                loading.setVisibility(View.GONE);
                //  progressBar.setVisibility(View.INVISIBLE);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(thrid2fire4.this, "Can't fetch data from database", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void clearfn() {
        r1.clearCheck();
        r2.clearCheck();
        r3.clearCheck();
        r4.clearCheck();
        r5.clearCheck();
    }
}