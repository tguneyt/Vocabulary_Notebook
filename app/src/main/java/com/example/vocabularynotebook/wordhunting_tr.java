package com.example.vocabularynotebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.example.vocabularynotebook.MainActivity.MainTitle;
import static com.example.vocabularynotebook.MainActivity.t1;


import android.os.Bundle;

public class wordhunting_tr extends AppCompatActivity {

    LinearLayout lay11, lay21, lay31, lay41, lay51, lay61;
    LinearLayout laymatch, layall_eng, layall2, layall_tr;

    CardView card11, card21, card31, card41, card51, card61;
    Button eng, tr;
   // List<vocabularyclass> list;
    //List<vocabularyclass> list1;
    ArrayList<vocabularyclass> list1;
    TextView huntingtitle;
    TextView targetword_Text, wordtext1, wordtext2, wordtext3, wordtext4, wordtext5, wordtext6;
    TextView targetword_Text1, wordtext11, wordtext21, wordtext31, wordtext41, wordtext51, wordtext61;
    Context context;
    FirebaseDatabase database11;
    DatabaseReference myRef11;
    FirebaseDatabase database12;
    DatabaseReference myRef12;
    String xc;
    int r, r1, r3, r4, r5, r6, r2;
    int rr, rr1, rr3, rr4, rr5, rr6, rr2;
    int row1, row11;
    String engquestion, trquestion;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wordhunting_tr);

        targetword_Text = (TextView) findViewById(R.id.targetword_text);
        wordtext1 = findViewById(R.id.wordtext1);
        wordtext2 = findViewById(R.id.wordtext2);
        wordtext3 = findViewById(R.id.wordtext3);
        wordtext4 = findViewById(R.id.wordtext4);
        wordtext5 = findViewById(R.id.wordtext5);
        wordtext6 = findViewById(R.id.wordtext6);
        targetword_Text1 = (TextView) findViewById(R.id.targetword_text1);
        wordtext11 = findViewById(R.id.wordtext11);
        wordtext21 = findViewById(R.id.wordtext21);
        wordtext31 = findViewById(R.id.wordtext31);
        wordtext41 = findViewById(R.id.wordtext41);
        wordtext51 = findViewById(R.id.wordtext51);
        wordtext61 = findViewById(R.id.wordtext61);

        lay11 = findViewById(R.id.lay11);
        lay21 = findViewById(R.id.lay21);
        lay31 = findViewById(R.id.lay31);
        lay41 = findViewById(R.id.lay41);
        lay51 = findViewById(R.id.lay51);
        lay61 = findViewById(R.id.lay61);

        laymatch = findViewById(R.id.laymatch);
        layall_eng = findViewById(R.id.layall_eng);
        layall_tr = findViewById(R.id.layall_tr);
        layall2 = findViewById(R.id.layall2);

        card11 = findViewById(R.id.word_card11);
        card21 = findViewById(R.id.word_card21);
        card31 = findViewById(R.id.word_card31);
        card41 = findViewById(R.id.word_card41);
        card51 = findViewById(R.id.word_card51);
        card61 = findViewById(R.id.word_card61);

        eng = findViewById(R.id.eng);
        tr = findViewById(R.id.tr);

        //eng.setText(MainTitle);
        //tr.setText(t1);
        ////Title

        huntingtitle = (TextView) findViewById(R.id.huntingtitle);
        String g ="aaaaaaaaaa";
       //  g =list1.get(0).orj;
        huntingtitle.setText(g);
        Typeface font1 = Typeface.createFromAsset(getAssets(), "font/topsecret.ttf");
        huntingtitle.setTypeface(font1);
        ////Title

       // DbList3();

        tr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layall2.setVisibility(View.GONE);
                layall_tr.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out));


                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        layall_tr.setVisibility(View.VISIBLE);
                        layall_tr.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in));

                    }
                }, 100);

            }
        });
        /*

        card11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (trquestion.equalsIgnoreCase(wordtext11.getText().toString())) {
                    lay11.setBackgroundColor(getResources().getColor(R.color.yesil));
                    EnableFalseTR();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            EnableTrueTR();
                            DbList3(); ///görünür olsun
                        }
                    }, 800); ///

                } else {
                    lay11.setBackgroundColor(getResources().getColor(R.color.kirmizi));
                    EnableFalseTR();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            lay11.setBackgroundColor(getResources().getColor(R.color.lacivert)); ///görünür olsun
                            EnableTrueTR();
                        }
                    }, 800); ///5 sn sonra görünür olsun
                }
            }
        });
        card21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (trquestion.equalsIgnoreCase(wordtext21.getText().toString())) {
                    lay21.setBackgroundColor(getResources().getColor(R.color.yesil));
                    EnableFalseTR();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            EnableTrueTR();
                            DbList3(); ///görünür olsun
                        }
                    }, 800); ///

                } else {
                    lay21.setBackgroundColor(getResources().getColor(R.color.kirmizi));
                    EnableFalseTR();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            lay21.setBackgroundColor(getResources().getColor(R.color.lacivert)); ///görünür olsun
                            EnableTrueTR();
                        }
                    }, 800); ///5 sn sonra görünür olsun
                }
            }
        });
        card31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (trquestion.equalsIgnoreCase(wordtext31.getText().toString())) {
                    lay31.setBackgroundColor(getResources().getColor(R.color.yesil));
                    EnableFalseTR();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            EnableTrueTR();
                            DbList3(); ///görünür olsun
                        }
                    }, 800); ///

                } else {
                    lay31.setBackgroundColor(getResources().getColor(R.color.kirmizi));
                    EnableFalseTR();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            lay31.setBackgroundColor(getResources().getColor(R.color.lacivert)); ///görünür olsun
                            EnableTrueTR();
                        }
                    }, 800); ///5 sn sonra görünür olsun
                }
            }
        });
        card41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (trquestion.equalsIgnoreCase(wordtext41.getText().toString())) {
                    lay41.setBackgroundColor(getResources().getColor(R.color.yesil));
                    EnableFalseTR();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            EnableTrueTR();
                            DbList3(); ///görünür olsun
                        }
                    }, 800); ///

                } else {
                    lay41.setBackgroundColor(getResources().getColor(R.color.kirmizi));
                    EnableFalseTR();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            lay41.setBackgroundColor(getResources().getColor(R.color.lacivert)); ///görünür olsun
                            EnableTrueTR();
                        }
                    }, 800); ///5 sn sonra görünür olsun
                }
            }
        });
        card51.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (trquestion.equalsIgnoreCase(wordtext51.getText().toString())) {
                    lay51.setBackgroundColor(getResources().getColor(R.color.yesil));
                    EnableFalseTR();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            EnableTrueTR();
                            DbList3(); ///görünür olsun
                        }
                    }, 800); ///

                } else {
                    lay51.setBackgroundColor(getResources().getColor(R.color.kirmizi));
                    EnableFalseTR();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            lay51.setBackgroundColor(getResources().getColor(R.color.lacivert)); ///görünür olsun
                            EnableTrueTR();
                        }
                    }, 800); ///5 sn sonra görünür olsun
                }
            }
        });
        card61.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (trquestion.equalsIgnoreCase(wordtext61.getText().toString())) {
                    lay61.setBackgroundColor(getResources().getColor(R.color.yesil));
                    EnableFalseTR();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            EnableTrueTR();
                            DbList3(); ///görünür olsun
                        }
                    }, 800); ///

                } else {
                    lay61.setBackgroundColor(getResources().getColor(R.color.kirmizi));
                    EnableFalseTR();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            lay61.setBackgroundColor(getResources().getColor(R.color.lacivert)); ///görünür olsun
                            EnableTrueTR();
                        }
                    }, 800); ///5 sn sonra görünür olsun
                }
            }
        });

        */
    }

    private void EnableTrueENG() {
//        card2.setEnabled(true);
//        card3.setEnabled(true);
//        card4.setEnabled(true);
//        card5.setEnabled(true);
//        card6.setEnabled(true);
//        card1.setEnabled(true);
    }

    private void EnableFalseENG() {
//        card2.setEnabled(false);
//        card3.setEnabled(false);
//        card4.setEnabled(false);
//        card5.setEnabled(false);
//        card6.setEnabled(false);
//        card1.setEnabled(false);
    }

    private void EnableTrueTR() {
        card21.setEnabled(true);
        card31.setEnabled(true);
        card41.setEnabled(true);
        card51.setEnabled(true);
        card61.setEnabled(true);
        card11.setEnabled(true);
    }

    private void EnableFalseTR() {
        card21.setEnabled(false);
        card31.setEnabled(false);
        card41.setEnabled(false);
        card51.setEnabled(false);
        card61.setEnabled(false);
        card11.setEnabled(false);
    }

    private void DbList3() {/*
        lay11.setBackgroundColor(getResources().getColor(R.color.lacivert));
        lay21.setBackgroundColor(getResources().getColor(R.color.lacivert));
        lay31.setBackgroundColor(getResources().getColor(R.color.lacivert));
        lay41.setBackgroundColor(getResources().getColor(R.color.lacivert));
        lay51.setBackgroundColor(getResources().getColor(R.color.lacivert));
        lay61.setBackgroundColor(getResources().getColor(R.color.lacivert));
//        String value5 = "English";
////        recycle = (RecyclerView) findViewById(R.id.recycle);
//        database12 = FirebaseDatabase.getInstance();
//        myRef12 = database12.getReference(value5);
//        myRef12.orderByKey().addValueEventListener(new ValueEventListener() {
//            @SuppressLint("SetTextI18n")
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                list1 = new ArrayList<vocabularyclass>();
//                for (DataSnapshot dataSnapshot2 : dataSnapshot.getChildren()) {
//
//                    vocabularyclass value12 = dataSnapshot2.getValue(vocabularyclass.class);
//                    vocabularyclass fire2 = new vocabularyclass();
//                    //Query query =  myRef.orderByChild("logo").equalTo("11");
//
//                    String orj = value12.getOrj();
//                    String mean1 = value12.getMean1();
//                    String mean2 = value12.getMean2();
//                    String mean3 = value12.getMean3();
//
//
//                    fire2.setOrj(orj);
//                    fire2.setMean1(mean1);
//                    fire2.setMean2(mean2);
//                    fire2.setMean3(mean3);
//
//                    list1.add(fire2);
//
//                }

                Random random = new Random();
                rr = random.nextInt(list1.size());
                rr1 = random.nextInt(list1.size());
                rr2 = random.nextInt(list1.size());
                rr3 = random.nextInt(list1.size());
                rr4 = random.nextInt(list1.size());
                rr5 = random.nextInt(list1.size());
                rr6 = random.nextInt(list1.size());
                while (rr == rr1 || rr == rr2 || rr == rr3 || rr == rr4 || rr == rr5 || rr == rr6 || rr1 == rr2 || rr1 == rr3 || rr1 == rr4 ||
                        rr1 == rr5 || rr1 == rr6 || rr2 == rr3 || rr2 == rr4 || rr2 == rr5 || rr2 == rr6 || rr3 == rr4 || rr3 == rr5 ||
                        rr3 == rr6 || rr4 == rr5 || rr4 == rr6 || rr5 == rr6) {
                    if (rr == rr1 || rr == rr2 || rr == rr3 || rr == rr4 || rr == rr5 || rr == rr6) {
                        rr = random.nextInt(list1.size());
                    }
                    if (rr1 == rr2 || rr1 == rr3 || rr1 == rr4 || rr1 == rr5 || rr1 == rr6) {
                        rr1 = random.nextInt(list1.size());
                    }
                    if (rr2 == rr3 || rr2 == rr4 || rr2 == rr5 || rr2 == rr6) {
                        rr2 = random.nextInt(list1.size());
                    }
                    if (rr3 == rr4 || rr3 == rr5 || rr3 == rr6) {
                        rr3 = random.nextInt(list1.size());
                    }
                    if (rr4 == rr5 || rr4 == rr6) {
                        rr4 = random.nextInt(list1.size());
                    }
                    if (rr5 == rr6) {
                        rr5 = random.nextInt(list1.size());
                    }
                }
////////////////////********************************************************************************
                Random random1 = new Random();
                row11 = random1.nextInt(6);
                if (list1.get(0).orj != null) {

                    // targetword_Text1.setText(list.get(rr).mean1);
                    if (!(list1.get(rr).mean2.equalsIgnoreCase("")) && (list1.get(rr).mean3.equalsIgnoreCase(""))) {
                        targetword_Text1.setText(list1.get(rr).mean1 + "," + list1.get(rr).mean2);
                    }
                    if (!(list1.get(rr).mean2.equalsIgnoreCase("")) && !(list1.get(rr).mean3.equalsIgnoreCase(""))) {
                        targetword_Text1.setText(list1.get(rr).mean1 + "," + list1.get(rr).mean2 + "," + list1.get(rr).mean3);
                    }
                    if (list1.get(rr).mean2.equalsIgnoreCase("") && list1.get(rr).mean3.equalsIgnoreCase("")) {
                        targetword_Text1.setText(list1.get(rr).mean1);
                    }
                    trquestion = list1.get(rr).orj;
                    wordtext11.setText(list1.get(rr1).orj);
                    wordtext21.setText(list1.get(rr2).orj);
                    wordtext31.setText(list1.get(rr3).orj);
                    wordtext41.setText(list1.get(rr4).orj);
                    wordtext51.setText(list1.get(rr5).orj);
                    wordtext61.setText(list1.get(rr6).orj);

                    if (row11 == 0) {
                        wordtext11.setText(list1.get(rr).orj);
                    }
                    if (row11 == 1) {
                        wordtext21.setText(list1.get(rr).orj);
                    }
                    if (row11 == 2) {
                        wordtext31.setText(list1.get(rr).orj);
                    }
                    if (row11 == 3) {
                        wordtext41.setText(list1.get(rr).orj);
                    }
                    if (row11 == 4) {
                        wordtext51.setText(list1.get(rr).orj);
                    }
                    if (row11 == 5) {
                        wordtext61.setText(list1.get(rr).orj);
                    }
                    //////////doğru cevabı random yerleştir


                    /*
/////////////////////////////////////////////////////
                    targetword_Text.setText(list.get(r).orj);

                    if(!(list.get(r).mean2.equalsIgnoreCase("")) && (list.get(r).mean3.equalsIgnoreCase(""))){
                        // wordtext1.setText(list.get(r).mean1+","+list.get(r).mean2);
                        soru=list.get(r).mean1+","+list.get(r).mean2;
                    }
                    if(!(list.get(r).mean2.equalsIgnoreCase("")) && !(list.get(r).mean3.equalsIgnoreCase(""))){
                        //wordtext1.setText(list.get(r).mean1+","+list.get(r).mean2+","+list.get(r).mean3);
                        soru=list.get(r).mean1+","+list.get(r).mean2+","+list.get(r).mean3;
                    }
                    if(list.get(r).mean2.equalsIgnoreCase("")&&list.get(r).mean3.equalsIgnoreCase("")){
                        //wordtext1.setText(list.get(r).mean1);
                        soru=list.get(r).mean1;
                    }

//                    if(!(list.get(r).mean2.equalsIgnoreCase("")) && (list.get(r).mean3.equalsIgnoreCase(""))){
//                        wordtext1.setText(list.get(r).mean1+","+list.get(r).mean2);
//                    }
//                    if(!(list.get(r).mean2.equalsIgnoreCase("")) && !(list.get(r).mean3.equalsIgnoreCase(""))){
//                        wordtext1.setText(list.get(r).mean1+","+list.get(r).mean2+","+list.get(r).mean3);
//                    }
//                    if(list.get(r).mean2.equalsIgnoreCase("")&&list.get(r).mean3.equalsIgnoreCase("")){
//                        wordtext1.setText(list.get(r).mean1);
//                    }
//////////////////////////////////////////////////

                    if(!(list.get(r1).mean2.equalsIgnoreCase("")) && (list.get(r1).mean3.equalsIgnoreCase(""))){
                        wordtext1.setText(list.get(r1).mean1+","+list.get(r1).mean2);
                    }
                    if(!(list.get(r1).mean2.equalsIgnoreCase("")) && !(list.get(r1).mean3.equalsIgnoreCase(""))){
                        wordtext1.setText(list.get(r1).mean1+","+list.get(r1).mean2+","+list.get(r1).mean3);
                    }
                    if(list.get(r1).mean2.equalsIgnoreCase("")&&list.get(r1).mean3.equalsIgnoreCase("")){
                        wordtext1.setText(list.get(r1).mean1);
                    }
//////////////////////////////////////////////////
                    // wordtext2.setText(list.get(60).mean1+"-"+r2);

                    if(!(list.get(r2).mean2.equalsIgnoreCase("")) && (list.get(r2).mean3.equalsIgnoreCase(""))){
                        wordtext2.setText(list.get(r2).mean1+","+list.get(r2).mean2);
                    }
                    if(!(list.get(r2).mean2.equalsIgnoreCase("")) && !(list.get(r2).mean3.equalsIgnoreCase(""))){
                        wordtext2.setText(list.get(r2).mean1+","+list.get(r2).mean2+","+list.get(r2).mean3);
                    }
                    if(list.get(r2).mean2.equalsIgnoreCase("")&&list.get(r2).mean3.equalsIgnoreCase("")){
                        wordtext2.setText(list.get(r2).mean1);
                    }
/////////////////////////////////////////////////
                    // wordtext3.setText(list.get(r3).mean1+"-"+r3);

                    if(!(list.get(r3).mean2.equalsIgnoreCase("")) && (list.get(r3).mean3.equalsIgnoreCase(""))){
                        wordtext3.setText(list.get(r3).mean1+","+list.get(r3).mean2);
                    }
                    if(!(list.get(r3).mean2.equalsIgnoreCase("")) && !(list.get(r3).mean3.equalsIgnoreCase(""))){
                        wordtext3.setText(list.get(r3).mean1+","+list.get(r3).mean2+","+list.get(r3).mean3);
                    }
                    if(list.get(r3).mean2.equalsIgnoreCase("")&&list.get(r3).mean3.equalsIgnoreCase("")){
                        wordtext3.setText(list.get(r3).mean1);
                    }
///////////////////////////////////////////////
                    // wordtext4.setText(list.get(r4).mean1+"-"+r4);
                    if(!(list.get(r4).mean2.equalsIgnoreCase("")) && (list.get(r4).mean3.equalsIgnoreCase(""))){
                        wordtext4.setText(list.get(r4).mean1+","+list.get(r4).mean2);
                    }
                    if(!(list.get(r4).mean2.equalsIgnoreCase("")) && !(list.get(r4).mean3.equalsIgnoreCase(""))){
                        wordtext4.setText(list.get(r4).mean1+","+list.get(r4).mean2+","+list.get(r4).mean3);
                    }
                    if(list.get(r4).mean2.equalsIgnoreCase("")&&list.get(r4).mean3.equalsIgnoreCase("")){
                        wordtext4.setText(list.get(r4).mean1);
                    }
///////////////////////////////////////////////
                    // wordtext5.setText(list.get(r5).mean1+"-"+r5);

                    if(!(list.get(r5).mean2.equalsIgnoreCase("")) && (list.get(r5).mean3.equalsIgnoreCase(""))){
                        wordtext5.setText(list.get(r5).mean1+","+list.get(r5).mean2);
                    }
                    if(!(list.get(r5).mean2.equalsIgnoreCase("")) && !(list.get(r5).mean3.equalsIgnoreCase(""))){
                        wordtext5.setText(list.get(r5).mean1+","+list.get(r5).mean2+","+list.get(r5).mean3);
                    }
                    if(list.get(r5).mean2.equalsIgnoreCase("")&&list.get(r5).mean3.equalsIgnoreCase("")){
                        wordtext5.setText(list.get(r5).mean1);
                    }
///////////////////////////////////////////////
                    // wordtext6.setText(list.get(r6).mean1+"-"+r6);

                    if(!(list.get(r6).mean2.equalsIgnoreCase("")) && (list.get(r6).mean3.equalsIgnoreCase(""))){
                        wordtext6.setText(list.get(r6).mean1+","+list.get(r6).mean2);
                    }
                    if(!(list.get(r6).mean2.equalsIgnoreCase("")) && !(list.get(r6).mean3.equalsIgnoreCase(""))){
                        wordtext6.setText(list.get(r6).mean1+","+list.get(r6).mean2+","+list.get(r6).mean3);
                    }
                    if(list.get(r6).mean2.equalsIgnoreCase("")&&list.get(r6).mean3.equalsIgnoreCase("")){
                        wordtext6.setText(list.get(r6).mean1);
                    }
///////////////////////////////////////////////

                    //////////doğru cevabı random yerleştir
                    if(row1==0){
                        if(!(list.get(r).mean2.equalsIgnoreCase("")) && (list.get(r).mean3.equalsIgnoreCase(""))){
                            wordtext1.setText(list.get(r).mean1+","+list.get(r).mean2);
                        }
                        if(!(list.get(r).mean2.equalsIgnoreCase("")) && !(list.get(r).mean3.equalsIgnoreCase(""))){
                            wordtext1.setText(list.get(r).mean1+","+list.get(r).mean2+","+list.get(r).mean3);
                        }
                        if(list.get(r).mean2.equalsIgnoreCase("")&&list.get(r).mean3.equalsIgnoreCase("")){
                            wordtext1.setText(list.get(r).mean1);
                        }

                    }
                    if(row1==1){
                        if(!(list.get(r).mean2.equalsIgnoreCase("")) && (list.get(r).mean3.equalsIgnoreCase(""))){
                            wordtext2.setText(list.get(r).mean1+","+list.get(r).mean2);
                        }
                        if(!(list.get(r).mean2.equalsIgnoreCase("")) && !(list.get(r).mean3.equalsIgnoreCase(""))){
                            wordtext2.setText(list.get(r).mean1+","+list.get(r).mean2+","+list.get(r).mean3);
                        }
                        if(list.get(r).mean2.equalsIgnoreCase("")&&list.get(r).mean3.equalsIgnoreCase("")){
                            wordtext2.setText(list.get(r).mean1);
                        }

                    }
                    if(row1==2){
                        if(!(list.get(r).mean2.equalsIgnoreCase("")) && (list.get(r).mean3.equalsIgnoreCase(""))){
                            wordtext3.setText(list.get(r).mean1+","+list.get(r).mean2);
                        }
                        if(!(list.get(r).mean2.equalsIgnoreCase("")) && !(list.get(r).mean3.equalsIgnoreCase(""))){
                            wordtext3.setText(list.get(r).mean1+","+list.get(r).mean2+","+list.get(r).mean3);
                        }
                        if(list.get(r).mean2.equalsIgnoreCase("")&&list.get(r).mean3.equalsIgnoreCase("")){
                            wordtext3.setText(list.get(r).mean1);
                        }

                    }
                    if(row1==3){
                        if(!(list.get(r).mean2.equalsIgnoreCase("")) && (list.get(r).mean3.equalsIgnoreCase(""))){
                            wordtext4.setText(list.get(r).mean1+","+list.get(r).mean2);
                        }
                        if(!(list.get(r).mean2.equalsIgnoreCase("")) && !(list.get(r).mean3.equalsIgnoreCase(""))){
                            wordtext4.setText(list.get(r).mean1+","+list.get(r).mean2+","+list.get(r).mean3);
                        }
                        if(list.get(r).mean2.equalsIgnoreCase("")&&list.get(r).mean3.equalsIgnoreCase("")){
                            wordtext4.setText(list.get(r).mean1);
                        }

                    }
                    if(row1==4){
                        if(!(list.get(r).mean2.equalsIgnoreCase("")) && (list.get(r).mean3.equalsIgnoreCase(""))){
                            wordtext5.setText(list.get(r).mean1+","+list.get(r).mean2);
                        }
                        if(!(list.get(r).mean2.equalsIgnoreCase("")) && !(list.get(r).mean3.equalsIgnoreCase(""))){
                            wordtext5.setText(list.get(r).mean1+","+list.get(r).mean2+","+list.get(r).mean3);
                        }
                        if(list.get(r).mean2.equalsIgnoreCase("")&&list.get(r).mean3.equalsIgnoreCase("")){
                            wordtext5.setText(list.get(r).mean1);
                        }

                    }
                    if(row1==5){
                        if(!(list.get(r).mean2.equalsIgnoreCase("")) && (list.get(r).mean3.equalsIgnoreCase(""))){
                            wordtext6.setText(list.get(r).mean1+","+list.get(r).mean2);
                        }
                        if(!(list.get(r).mean2.equalsIgnoreCase("")) && !(list.get(r).mean3.equalsIgnoreCase(""))){
                            wordtext6.setText(list.get(r).mean1+","+list.get(r).mean2+","+list.get(r).mean3);
                        }
                        if(list.get(r).mean2.equalsIgnoreCase("")&&list.get(r).mean3.equalsIgnoreCase("")){
                            wordtext6.setText(list.get(r).mean1);
                        }

                    }
                    //////////doğru cevabı random yerleştir


                }
                        */
            }

//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//                Log.w("Hello", "Failed to read value.", error.toException());
//            }
//
//        });
//    }
}