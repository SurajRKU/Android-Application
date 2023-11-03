package com.example.firebase4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class third4fire4 extends AppCompatActivity {
    TextView page1 , page2,page3,total,per;
    Bundle extras1,extras2,extras3,extras4,extras5;
    Button quit;
    int t1count,t2count,t3count,total_score;
    Intent intent;
    Intent intent2;
    Intent intent1;
    String user;
    Button view1,menu;
    Intent intentnav;
   boolean doubleBackToExitPressedOnce;
    DatabaseReference databaseReference;
  //  DataSnapshot dataSnapshot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third4fire4);
        page1 =findViewById(R.id.basic);
        page2 = findViewById(R.id.intermediate);
        page3 = findViewById(R.id.expert);
        menu= findViewById(R.id.menu);
        Entity1 entity =new Entity1();
      databaseReference= FirebaseDatabase.getInstance().getReference("Users_database");
    intent2=new Intent(third4fire4.this,leaderboard.class);
    //intentnav=new Intent(third4fire4.this,navigation.class);
    total = findViewById(R.id.total);
        quit = findViewById(R.id.thank);
        view1=findViewById(R.id.leaderboard3);
        per=findViewById(R.id.performance);
        extras1 = getIntent().getExtras();
        extras2=getIntent().getExtras();
        extras3=getIntent().getExtras();
        extras4=getIntent().getExtras();
       extras5=getIntent().getExtras();
    doubleBackToExitPressedOnce = false;
       user=extras5.getString("username");
        t1count = extras1.getInt("fromt1");
        t2count = extras2.getInt("fromt2");
        t3count = extras3.getInt("fromt3");
        total_score = extras4.getInt("total");
        page1.setText(String.valueOf(t1count)+"/50");
        page2.setText(String.valueOf(t2count)+"/50");
        page3.setText(String.valueOf(t3count)+"/50");
        total.setText(String.valueOf(total_score)+"/150");
        entity.setScore(String.valueOf(total_score));
        //databaseReference.orderByChild("username").equalTo(user);

      // databaseReference.child(user).setValue(entity);
        intent = new Intent(third4fire4.this,sec9fire4.class);

        if(total_score>=120){
            per.setText("Outstanding Performance!!!");
        }
        else if(total_score<120&&total_score>=90) {
            per.setText("Excellent Performance!!!");
        }
        else if(total_score<90&&total_score>=40)
            per.setText("Good Performance!!!");
        else
            per.setText("Poor Performance!!!");
        //Toast.makeText(third4fire4.this,user,Toast.LENGTH_SHORT).show();
       databaseReference.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
               {
                 String rid=dataSnapshot1.child("username").getValue().toString().trim();
                 if(rid.equals(user))
                 {
                    databaseReference=dataSnapshot1.getRef();
                    databaseReference.child("score").setValue(String.valueOf(total_score));
                    break;
                 }
               }

           }

           @Override
           public void onCancelled(@NonNull DatabaseError databaseError) {

           }
       });


        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // startActivity(intentnav);

            }

        });
    view1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(intent2);
        }
    });
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                intent1=new Intent(third4fire4.this,nav_bar.class);
                intent1.putExtra("username",user);
                startActivity(intent1);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        finishAffinity();
                    }
                },500);

            }
        });


    }
    @Override
    public void onBackPressed() {

        if(doubleBackToExitPressedOnce==true)
        {
            super.onBackPressed();
            finishAffinity();
        }
        else
        {
            this.doubleBackToExitPressedOnce=true;
            Toast.makeText(third4fire4.this,"Press back again to exit",Toast.LENGTH_SHORT).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubleBackToExitPressedOnce= false;
                }
            },2000);



        }

    }


}
