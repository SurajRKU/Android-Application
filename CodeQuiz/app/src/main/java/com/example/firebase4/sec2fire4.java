package com.example.firebase4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class sec2fire4 extends AppCompatActivity {
    Button signup;
    Button  login;
    EditText user;
    EditText pass;
    Intent intent1;
    Intent intent,intent3;
    ProgressBar spinner;
   TextView wait;
   String idd;
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec2fire4);
        signup=findViewById(R.id.submit);
        login =findViewById(R.id.quiz);
       user=findViewById(R.id.editText1);
       pass = findViewById(R.id.editText2);
       spinner = findViewById(R.id.progressbar);
      wait = findViewById(R.id.wait);
      intent3=new Intent(sec2fire4.this,nav_bar.class);
       intent1 = new Intent(sec2fire4.this,sec4fire4.class);
        intent = new Intent(sec2fire4.this,sec3fire4.class);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(final View view) {
                idd=user.getText().toString().trim();
                if(!Patterns.EMAIL_ADDRESS.matcher(user.getText().toString().trim()).matches()) {
                    user.setError("Invalid");
                    user.requestFocus();
                    return;
                }



                    idd = user.getText().toString().trim();
                if(user.getText().toString().isEmpty()||pass.getText().toString().isEmpty()||(user.getText().toString().isEmpty()&&pass.getText().toString().isEmpty()))
                {
                    Toast.makeText(sec2fire4.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                }

                else {
                    wait.setVisibility(View.VISIBLE);
                    spinner.setVisibility(View.VISIBLE);
                    FirebaseAuth.getInstance().signInWithEmailAndPassword(user.getText().toString().trim(), pass.getText().toString().trim()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {


                            if (task.isSuccessful()) {
                                spinner.setVisibility(view.GONE);
                                wait.setVisibility(View.INVISIBLE);
                                Toast.makeText(sec2fire4.this, "Sign in Successful", Toast.LENGTH_SHORT).show();
                                intent1.putExtra("username",idd);
                                intent3.putExtra("username",idd);
                             //   Toast.makeText(sec2fire4.this,idd,Toast.LENGTH_SHORT).show();
                                startActivity(intent3);
                            } else {
                               wait.setVisibility(View.INVISIBLE);
                                spinner.setVisibility(View.GONE);
                                Toast.makeText(sec2fire4.this, "User Not Found!!!", Toast.LENGTH_SHORT).show();
                            }


                        }


                    });


                }
            }
        });









    }
}
