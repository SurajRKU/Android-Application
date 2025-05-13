package com.example.firebase4;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.os.Handler;
import android.view.View;

import androidx.annotation.ContentView;
import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class nav_bar extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
long backPressedTime;
Toast backtoast;
TextView usernamee,lastlogin,mail;
Handler handler;
DatabaseReference databaseReference;
Bundle extras;
Entity1 entity1;
Intent intent,intent2,intent3,intent4,intent5,intent6,intent7;
String usrnme;
Button online,offline,leaderboard;
Boolean twice;
String mail1;
boolean doubleBackToExitPressedOnce;
//Toolbar toolbar;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_bar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
      getSupportActionBar().setTitle("CODE QUIZ");
    intent5 = new Intent(nav_bar.this, sec5fire4.class);
   // proceed = findViewById(R.id.Proceed);


   doubleBackToExitPressedOnce=false;
    intent6=new Intent(nav_bar.this,leaderboard.class);
   // leader=findViewById(R.id.leaderboard2);
    intent7= new Intent(nav_bar.this,third1fire4.class);

        /// FloatingActionButton fab = findViewById(R.id.fab);
   // usernamee=findViewById(R.id.user314);
   // lastlogin=findViewById(R.id.lastlogin);
        extras=getIntent().getExtras();
        intent=new Intent(nav_bar.this,myaccount.class);
        intent2=new Intent(nav_bar.this,sec2fire4.class);
        intent3=new Intent(nav_bar.this,edit.class);
        intent4=new Intent(nav_bar.this,feedback.class);
    //final String
            mail1=extras.getString("username");
    usrnme=extras.getString("username");

    online =findViewById(R.id.online_quiz);
       offline=findViewById(R.id.offline_quiz);
       leaderboard=findViewById(R.id.leaderboardgen);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
          NavigationView navigationView = findViewById(R.id.nav_view);
        // View contentView = navigationView.in
         View headerView = navigationView.getHeaderView(0);
        usernamee=headerView.findViewById(R.id.user314);
        lastlogin=headerView.findViewById(R.id.lastlogin);

      entity1=new Entity1();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(

                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

  databaseReference= FirebaseDatabase.getInstance().getReference("Users_database");
  databaseReference.addValueEventListener(new ValueEventListener() {
      @Override
      public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
          for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
          {
                String check;
                String name1;
                check=dataSnapshot1.child("username").getValue().toString().trim();
                if(check.equals(mail1))
                {
                   lastlogin.setText(check);
                   name1=dataSnapshot1.child("name").getValue().toString().trim();
                   usernamee.setText(name1);
               }

          }
      }

      @Override
      public void onCancelled(@NonNull DatabaseError databaseError) {

      }
  });
online.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        intent7.putExtra("username",usrnme);
        startActivity(intent7);
    }
});
  offline.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
          intent5.putExtra("username",usrnme);
          startActivity(intent5);

      }
  });
leaderboard.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        startActivity(intent6);
    }
});


}



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } //else{
              //super.onBackPressed();
        //}
          if(doubleBackToExitPressedOnce==true)
        {
            super.onBackPressed();
            finishAffinity();
        }
          else
          {
              this.doubleBackToExitPressedOnce=true;
              Toast.makeText(nav_bar.this,"Press back again to exit",Toast.LENGTH_SHORT).show();
              new Handler().postDelayed(new Runnable() {
                  @Override
                  public void run() {
                      doubleBackToExitPressedOnce= false;
                  }
              },2000);



          }

        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
        intent.putExtra("username",usrnme);
            startActivity(intent);
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            intent3.putExtra("username",usrnme);
            startActivity(intent3);
            //  Toast.makeText(nav_bar.this,"gallery pressed",Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_slideshow) {

            intent4.putExtra("username",usrnme);
            startActivity(intent4);
        } else if (id == R.id.nav_tools) {

            startActivity(intent2);
            finishAffinity();
        } /*else if (id == R.id.nav_share) {
            Toast.makeText(nav_bar.this,"share pressed",Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_send) {
            Toast.makeText(nav_bar.this,"send pressed",Toast.LENGTH_SHORT).show();
        }*/

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
