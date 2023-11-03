package com.example.firebase4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class myaccount extends AppCompatActivity {
DatabaseReference databaseReference;
String username;
Bundle extras;
TextView t1,t2,t3,t4,t5;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myaccount);
        databaseReference= FirebaseDatabase.getInstance().getReference("Users_database");
        extras=getIntent().getExtras();
        t1=findViewById(R.id.name_bar);
        t2=findViewById(R.id.mail_bar);
        t3=findViewById(R.id.college_bar);
        t4=findViewById(R.id.branch_bar);
        t5=findViewById(R.id.previous_score);
        username=extras.getString("username");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                {
                    String nameuser=dataSnapshot1.child("username").getValue().toString().trim();
                    if(username.equals(nameuser)) {
                        String name = dataSnapshot1.child("name").getValue().toString().trim();
                        String score =dataSnapshot1.child("score").getValue().toString().trim();
                        String college = dataSnapshot1.child("college").getValue().toString().trim();
                        String branch = dataSnapshot1.child("branch").getValue().toString().trim();

                        t1.setText(name);
                        t2.setText(username);
                        t3.setText(college);
                        t4.setText(branch);
                        t5.setText(score);



                    }
                    }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(myaccount.this,"Could not load profile!!!",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
