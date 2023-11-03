package com.example.firebase4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.internal.Objects;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class feedback extends AppCompatActivity {
EditText t1,t2,t3;
Button submit;
feedform Entity;
Bundle extras;
DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
      t1=findViewById(R.id.feed_q1);
      t2=findViewById(R.id.feed_q2);
      t3=findViewById(R.id.feed_q3);
     extras =getIntent().getExtras();
     final String usrnam=extras.getString("username");
    Entity= new feedform();
      submit = findViewById(R.id.submit_feed);
      databaseReference= FirebaseDatabase.getInstance().getReference("Feedback_database");
      submit.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              String like = t1.getText().toString().trim();
              String opinion= t2.getText().toString().trim();
              String improve = t3.getText().toString().trim();
             if(like.isEmpty()||opinion.isEmpty()||improve.isEmpty())
             {
                 Toast.makeText(feedback.this,"Please fill all fields",Toast.LENGTH_SHORT).show();
             }
             else {
               String id = databaseReference.push().getKey();
                 Entity.setLike(like);
                 Entity.setOpinion(opinion);
                 Entity.setImprovements(improve);
                 Entity.setPerson_id(usrnam);
            databaseReference.child(id).setValue(Entity);
            Toast.makeText(feedback.this,"Feedback Submitted to Developers Successfully",Toast.LENGTH_SHORT).show();
             }
             }

      });


    }
}
