package com.example.firebase4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class edit extends AppCompatActivity {
DatabaseReference databaseReference;
Bundle extras;
EditText t1,t2,t3;
Button submit;
Entity1 entity;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
     t1=findViewById(R.id.name_edit);
     t2=findViewById(R.id.college_edit);
     t3=findViewById(R.id.branch_edit);
      submit=findViewById(R.id.submit_edit);

       databaseReference= FirebaseDatabase.getInstance().getReference("Users_database");
       extras=getIntent().getExtras();
       final String mailid=extras.getString("username");
       entity=new Entity1();
     submit.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             databaseReference.addValueEventListener(new ValueEventListener() {
                 @Override
                 public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                     for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                     {
                         String id= dataSnapshot1.child("username").getValue().toString().trim();
                         if(mailid.equals(id))
                         { String namex=t1.getText().toString().trim();
                          String collegex=t2.getText().toString().trim();
                          String branchx=t3.getText().toString().trim();
                           if(namex.isEmpty()||collegex.isEmpty()||branchx.isEmpty())
                           {
                               Toast.makeText(edit.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                           }

                           else {

                               t3.setHint(branchx);
                               t1.setHint(namex);
                               t2.setHint(collegex);
                              databaseReference=dataSnapshot1.getRef();
                               databaseReference.child("college").setValue(collegex);
                              databaseReference.child("name").setValue(namex);
                              databaseReference.child("branch").setValue(branchx);
                               break;
                           }
                           }

                     }
                 }

                 @Override
                 public void onCancelled(@NonNull DatabaseError databaseError) {
                     Toast.makeText(edit.this,"Unable to save data!!!",Toast.LENGTH_SHORT).show();

                 }
             });


             Toast.makeText(edit.this,"Details Saved Successfully",Toast.LENGTH_SHORT).show();

         }
     });



    }
}
