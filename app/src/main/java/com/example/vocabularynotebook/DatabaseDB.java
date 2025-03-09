package com.example.vocabularynotebook;

import android.annotation.SuppressLint;

import android.content.Context;
import android.util.Log;


import android.widget.EditText;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatabaseDB {

    DatabaseReference myRef3 ;
    FirebaseDatabase database3;
    String ref3;
    EditText editText;
    static FirebaseDatabase database;
    static DatabaseReference myRef ;
    static FirebaseDatabase sdatabase;
    static DatabaseReference mysRef ;
    static List<vocabularyclass> list;
    String Generated_Key;
    TextView Lessonname21 , Lessonname22, textdeneme,Slash1;
    CardView word,addwordcard,ManuelText;


   // public class Helper {
   Context dbcontext;
    DatabaseDB(Context contx){
            this.dbcontext= contx;
        }

    public void dblist(){
        String value3 = "English";
//        recycle = (RecyclerView) findViewById(R.id.recycle);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference(value3);
        myRef.orderByKey().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                list = new ArrayList<vocabularyclass>();
                for(DataSnapshot dataSnapshot1 :dataSnapshot.getChildren()){

                    vocabularyclass value44 = dataSnapshot1.getValue(vocabularyclass.class);
                    vocabularyclass fire = new vocabularyclass();
                    //Query query =  myRef.orderByChild("logo").equalTo("11");

                    String orj = value44.getOrj();
                    String mean1 = value44.getMean1();

                    fire.setOrj(orj);
                    fire.setMean1(mean1);

                    list.add(fire);

                    //textdeneme.setText(list.get(1).orj);

                    //Toast.makeText(getBaseContext(),name, Toast.LENGTH_SHORT).show();

//                    RecyclerAdapter recyclerAdapter = new RecyclerAdapter(list,MainActivity.this);
//                    RecyclerView.LayoutManager recyce = new GridLayoutManager(MainActivity.this,2);
//                    //RecyclerView.LayoutManager recyce = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL, false);
//                    // recycle.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
//                    recycle.setLayoutManager(recyce);
//                    recycle.setItemAnimator( new DefaultItemAnimator());
//                    recycle.setAdapter(recyclerAdapter);

                }

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Hello", "Failed to read value.", error.toException());
            }

        });

    }

// addwordcard.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            key_generate ();
//            kaydetAllStores();
//
//        }
//    });

    public void kaydetAllStores (){

        //key_generate();

        ref3 = "English/"+Generated_Key;
        String value = ref3;

        FirebaseDatabase database3 = FirebaseDatabase.getInstance();
        myRef3 = database3.getReference(value);
        myRef3.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                for(DataSnapshot dataSnapshot1 :dataSnapshot.getChildren()){

                }

                myRef3.child("item").setValue("computer");
                myRef3.child("check").setValue("bilgisayar");


            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Merhaba", "Beklenmeyen Bir Hata Oluştu!", error.toException());
            }


        });

        //Toast.makeText(getApplicationContext(),"Bilgiler başarıyla yüklendi3.", Toast.LENGTH_SHORT).show();
    }

    public void key_generate (){
        @SuppressLint("SimpleDateFormat") DateFormat df = new SimpleDateFormat("yyMMdd");
        @SuppressLint("SimpleDateFormat") DateFormat df2 = new SimpleDateFormat("HHmmss");
        Date dateobj = new Date();
        Date dateobj2 = new Date();
        //System.out.println(df.format(dateobj));
        String a = df.format(dateobj);
        String b = df2.format(dateobj2);
        int x = Integer.parseInt(a);
        int y = Integer.parseInt(b);
        int z = 999999;
        x = z - x;
        y = z - y;
        a = String.valueOf(x);
        b = String.valueOf(y);
        // Generated_Key =a+b;
        Generated_Key = "4408";

    }

}
