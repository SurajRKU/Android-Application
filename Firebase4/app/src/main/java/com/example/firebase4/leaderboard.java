package com.example.firebase4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.Formatter;
import java.util.*;
import java.util.ArrayList;
import java.lang.NullPointerException;

 public class leaderboard extends AppCompatActivity {
   TextView loader;
     Intent intent;
     int k;
    DatabaseReference databaseReference;
    String player_name;
    String num;
    int count = 0,i,j,temp,l;
    ListView listView;
    ArrayAdapter<String> arrayAdapter;
    Button quit;
    LinkedList<String>linkedList;
    String   temp1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
        //ArrayList<String>Name_array = new ArrayList<String>();
     final  Combined obj[] =new Combined[100];
     linkedList=new LinkedList<>();
   loader=findViewById(R.id.loader);
       listView=findViewById(R.id.listview);
       quit=findViewById(R.id.quit123);
        databaseReference = FirebaseDatabase.getInstance().getReference("Users_database");
     //Score_array=new int[15];
      loader.setVisibility(View.VISIBLE);
        for(l=0;l<100;l++)
      {
          obj[l]=new Combined();
      }

       for(k=0;k<100;k++)
        {
            obj[k].setName("----");
            obj[k].setScore(Integer.parseInt("0"));
        }


      databaseReference.addValueEventListener(new ValueEventListener() {
          @Override
          public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

              for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
              {

                   num = dataSnapshot1.child("score").getValue().toString();
                  player_name=dataSnapshot1.child("name").getValue().toString();

                     obj[count].setScore(Integer.parseInt(num));
                     obj[count].setName(player_name);
                  count++;
              }
             // Toast.makeText(leaderboard.this,obj[0].getName()+" "+String.valueOf(obj[0].getScore()),Toast.LENGTH_SHORT).show();
                 for(i=0;i<=count-1;i++)
                 {
                     for(j=i+1;j<=count-1;j++)
                     {
                          int scorex=obj[i].getScore();
                          int scorey=obj[j].getScore();
                          String name1=obj[i].getName();
                          String name2 = obj[j].getName();
                        if(scorex<scorey)
                        {
                            //Toast.makeText(leaderboard.this," if loop",Toast.LENGTH_SHORT).show();
                            temp=scorex;
                            scorex=scorey;
                            scorey=temp;
                            obj[i].setScore(scorex);
                            obj[j].setScore(scorey);
                            temp1=name1;
                            name1=name2;
                            name2=temp1;
                            obj[i].setName(name1);
                            obj[j].setName(name2);
                          //  Toast.makeText(leaderboard.this,obj[0].getName()+" "+String.valueOf(obj[0].getScore()),Toast.LENGTH_SHORT).show();
                        }
                     }
                 }

              String player1=obj[0].getName();
              String mark1 = String.valueOf(obj[0].getScore());
              String it1= player1+"\t\t\t\t\t\t"+"\n"+mark1;

              String player2=obj[1].getName();
              String mark2 = String.valueOf(obj[1].getScore());
              String it2 = player2+"\t\t\t\t\t\t"+"\n"+mark2;

              String player3=obj[2].getName();
              String mark3 = String.valueOf(obj[2].getScore());
              String it3 = player3+"\t\t\t\t\t\t"+"\n"+mark3;

              String player4=obj[3].getName();
              String mark4 = String.valueOf(obj[3].getScore());
              String it4 = player4+"\t\t\t\t\t\t"+"\n"+mark4;

              String player5=obj[4].getName();
              String mark5 = String.valueOf(obj[4].getScore());
              String it5 = player5+"\t\t\t\t\t\t"+"\n"+mark5;

             String player6=obj[5].getName();
              String mark6 = String.valueOf(obj[5].getScore());
              String it6= player6+"\t\t\t\t\t\t"+"\n"+mark6;

              String player7=obj[6].getName();
              String mark7 = String.valueOf(obj[6].getScore());
              String it7= player7+"\t\t\t\t\t\t"+"\n"+mark7;

              String player8=obj[7].getName();
              String mark8 = String.valueOf(obj[7].getScore());
              String it8= player8+"\t\t\t\t\t\t"+"\n"+mark8;

              String player9=obj[8].getName();
              String mark9 = String.valueOf(obj[8].getScore());
              String it9= player9+"\t\t\t\t\t\t"+"\n"+mark9;

              String player10=obj[9].getName();
              String mark10 = String.valueOf(obj[9].getScore());
              String it10= player10+"\t\t\t\t\t\t"+"\n"+mark10;

              String player11=obj[10].getName();
              String mark11 = String.valueOf(obj[10].getScore());
              String it11= player11+"\t\t\t\t\t\t"+"\n"+mark11;

              String player12=obj[11].getName();
              String mark12 = String.valueOf(obj[11].getScore());
              String it12= player12+"\t\t\t\t\t\t"+"\n"+mark12;

              String player13=obj[12].getName();
              String mark13 = String.valueOf(obj[12].getScore());
              String it13= player13+"\t\t\t\t\t\t"+"\n"+mark13;

              String player14=obj[13].getName();
              String mark14 = String.valueOf(obj[13].getScore());
              String it14= player14+"\t\t\t\t\t\t"+"\n"+mark14;

              String player15=obj[14].getName();
              String mark15 = String.valueOf(obj[14].getScore());
              String it15= player15+"\t\t\t\t\t\t"+"\n"+mark15;

              String player16=obj[15].getName();
              String mark16 = String.valueOf(obj[15].getScore());
              String it16= player16+"\t\t\t\t\t\t" +"\n"+mark16;




              linkedList.add(it1);
linkedList.add(it2);
linkedList.add(it3);
linkedList.add(it4);
linkedList.add(it5);
//linkedList.add(it5);
linkedList.add(it6);
linkedList.add(it7);

              linkedList.add(it8);
              linkedList.add(it9);
              linkedList.add(it10);
              linkedList.add(it11);
              linkedList.add(it12);
              linkedList.add(it13);
              linkedList.add(it14);
              linkedList.add(it15);
              linkedList.add(it16);

       final ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(leaderboard.this,android.R.layout.simple_list_item_1,linkedList);

  listView.setAdapter(arrayAdapter);
  loader.setVisibility(View.GONE);
    listView.setVisibility(View.VISIBLE);
    quit.setVisibility(View.VISIBLE);
          }

          @Override
          public void onCancelled(@NonNull DatabaseError databaseError) {
              Toast.makeText(leaderboard.this,"Unable to fetch Leader Board!!!",Toast.LENGTH_SHORT).show();
          }
      });
        //Toast.makeText(leaderboard.this,obj[0].getName()+" "+String.valueOf(obj[0].getScore()),Toast.LENGTH_SHORT).show();
quit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        intent=new Intent(leaderboard.this,sec9fire4.class);
        startActivity(intent);

    }
});

    }
 }
