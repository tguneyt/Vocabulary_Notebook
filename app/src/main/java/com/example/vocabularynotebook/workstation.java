package com.example.vocabularynotebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

import static com.example.vocabularynotebook.MainActivity.MainTitle;

public class workstation extends AppCompatActivity {
    DatabaseReference myRef3 ;
    FirebaseDatabase database3;
    String ref3;
    EditText editText;
    FirebaseDatabase database;
    DatabaseReference myRef ;
    static FirebaseDatabase sdatabase;
    static DatabaseReference mysRef ;
    List<vocabularyclass> list;
    String Generated_Key;
    TextView stationtitle , textdeneme;
    CardView word,addwordcard,ManuelText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workstation);

        ManuelText=(CardView) findViewById(R.id.manuelword);

        word = (CardView) findViewById(R.id.wordhuntinggame);
        addwordcard = (CardView) findViewById(R.id.addwordcard);

        ////Title
        stationtitle = (TextView) findViewById(R.id.stationtitle);
        stationtitle.setText(MainTitle);
        Typeface font1 = Typeface.createFromAsset(getAssets(),"font/topsecret.ttf");
        stationtitle.setTypeface(font1);
        ////Title

/*
        String value3 = "English";
        //recycle = (RecyclerView) findViewById(R.id.recycle);
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
                    if(list.get(0).orj!=null) {

                    }
                    //Toast.makeText(getBaseContext(),name, Toast.LENGTH_SHORT).show();



                }

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Hello", "Failed to read value.", error.toException());
            }

        });
        */

        addwordcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  key_generate ();
              //  kaydetAllStores();
                Toast.makeText(getApplicationContext(),"COMING SOON",Toast.LENGTH_SHORT).show();
            }
        });


        word.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

    //    String x = stationtitle.getText().toString();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


        Intent wordHunting = new Intent(workstation.this, wordhunting.class);


        startActivity(wordHunting);
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out); // geçiş animasyonu
                finish();   /// geri tuşu ile önceki ekrana (main) dönmez
            }
        },10);

    }
});

        ManuelText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"COMING SOON",Toast.LENGTH_SHORT).show();

//                Intent wordHunting = new Intent(workstation.this, SelfText.class);
//
//                startActivity(wordHunting);
            }
        });


    }

/*
    public void kaydetAllStores (){

        //key_generate();

        ref3 = "English/"+Generated_Key;
        String value = ref3;

        database3 = FirebaseDatabase.getInstance();
        myRef3 = database3.getReference(value);
        myRef3.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                for(DataSnapshot dataSnapshot1 :dataSnapshot.getChildren()){

                }

                myRef3.child("orj").setValue("computer");
                myRef3.child("mean1").setValue("bilgisayar");


            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Merhaba", "Beklenmeyen Bir Hata Oluştu!", error.toException());
            }


        });

        Toast.makeText(getBaseContext(),"Bilgiler başarıyla yüklendi3.", Toast.LENGTH_SHORT).show();
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
        Generated_Key = "1";

    }
*/
}