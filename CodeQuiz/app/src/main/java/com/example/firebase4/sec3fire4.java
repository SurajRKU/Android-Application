package com.example.firebase4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class sec3fire4 extends AppCompatActivity {
 Button create;
 EditText name;
 EditText user;
 EditText pass;
 EditText col;
 EditText branch;
 Button proceed;
 Entity1 entity1;
Intent intent1;
 DatabaseReference databaseReference;
 String idd;
 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec3fire4);
     name = findViewById(R.id.name);
     user =   findViewById(R.id.user);
      pass =   findViewById(R.id.pass);
      col =    findViewById(R.id.college);
      branch = findViewById(R.id.branch);
      proceed =     findViewById(R.id.save);
      entity1=new Entity1();

        databaseReference = FirebaseDatabase.getInstance().getReference("Users_database");

        proceed.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {

             idd=user.getText().toString().trim();
             if(!Patterns.EMAIL_ADDRESS.matcher(user.getText().toString().trim()).matches()) {
                 user.setError("Invalid");
                 user.requestFocus();
                 return;
             }
             if(user.getText().toString().isEmpty()|| pass.getText().toString().isEmpty())
             {
                 Toast.makeText(sec3fire4.this, "Please fill all the fields!!!",Toast.LENGTH_SHORT).show();
                 return;
             }

             FirebaseAuth.getInstance().createUserWithEmailAndPassword(user.getText().toString().trim(),pass.getText().toString().trim()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                                                                                                                                                    @Override
                                                                                                                                                                    public void onComplete(@NonNull Task<AuthResult> task) {


                                                                                                                                                                        if (task.isSuccessful()) {

                                                                                                                                                                            String id =databaseReference.push().getKey();
                                                                                                                                                                            String myname = name.getText().toString().trim();
                                                                                                                                                                            String Username = user.getText().toString().trim();
                                                                                                                                                                            String  Password = pass.getText().toString().trim();
                                                                                                                                                                            String college = col.getText().toString().trim();
                                                                                                                                                                            String Branch = branch.getText().toString().trim();
                                                                                                                                                                            //intent1 = new Intent(sec3fire4.this,sec4fire4.class);
                                                                                                                                                                            intent1 = new Intent(sec3fire4.this,nav_bar.class);

                                                                                                                                                                            entity1.setName(myname);


                                                                                                                                                                            entity1.setScore(String.valueOf(0));
                                                                                                                                                                            entity1.setCollege(college);
                                                                                                                                                                            entity1.setBranch(Branch);
                                                                                                                                                                            entity1.setPass(Password);
                                                                                                                                                                            entity1.setUsername(Username);

                                                                                                                                                                            databaseReference.child(id).setValue(entity1);
                                                                                                                                                                            intent1.putExtra("username",idd);
                                                                                                                                                                           // Toast.makeText(sec3fire4.this,idd,Toast.LENGTH_SHORT).show();
                                                                                                                                                                            Toast.makeText(sec3fire4.this, " Account created succesfully", Toast.LENGTH_SHORT).show();

                                                                                                                                                                            startActivity(intent1);
                                                                                                                                                                        }
                                                                                                                                                                        else {
                                                                                                                                                                            Toast.makeText(sec3fire4.this, "Sorry useraccount can't be created!!!", Toast.LENGTH_SHORT).show();
                                                                                                                                                                        }

                                                                                                                                                                    }
                                                                                                                                                                });

         //databaseReference.child(id).child("Name").setValue(user.getText().toString().trim());
         //databaseReference.child(id).child("Password").setValue(pass.getText().toString().trim());




         }
     });



    }
}
