package com.example.vocabularynotebook;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class MainActivity extends AppCompatActivity {
//    DatabaseReference myRef3 ;
//    FirebaseDatabase database3;
//    String ref3;
//    FirebaseDatabase database;
//    DatabaseReference myRef ;
//    static FirebaseDatabase sdatabase;
//    static DatabaseReference mysRef ;
//    List<vocabularyclass> list;
//    String Generated_Key;
    CheckBox checkBox;
    CardView lessonselect,edit,eklecard;
    EditText editText;
    TextView lesson11,lesson12;
    Context context;
    String editt1 ,editt2;
    String titlemain;
    String check1,check2;

    public static SharedPreferences preferences;
    public static SharedPreferences.Editor editor;
    public static String x1 = "favourite3223";
    public static String MainTitle = "title gelmedi";
    public static String title1="titlesız";
    public static String t1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lesson11 = (TextView) findViewById(R.id.lesson11);

        preferences = getSharedPreferences("b", MODE_PRIVATE);
      //  editor = preferences.edit();



            check1 = preferences.getString("x1", "");////veriyi almak için
            check2 = preferences.getString("x2", "");////veriyi almak için


            /////açılışta check1 ve check2 null gelmesin
        //****** edit text elle giriş olunca düzeltilecek/eklenecek
//            if(check1.equalsIgnoreCase("")|| check2.equalsIgnoreCase("")){
//                title1 = check1 + check2;
//                }
//            else{
//                title1 = check1 +"/"+ check2;
//                t1=check2 +"/"+ check1;
//                }
        ////açılışta check1 ve check2 null gelmesin
            //lesson11.setText(title1);
            //MainTitle = title1;
        //****** edit text elle giriş olunca düzeltilecek/eklenecek
        String c =lesson11.getText().toString();
            MainTitle=c; ///edit text elle giriş olunca düzeltilecek/silinecek
            lesson11.setTextColor(getResources().getColor(R.color.beyaz));

            t1="TURKISH/ENGLISH"; ///edit text elle giriş olunca düzeltilecek/silinecek


        lessonselect = (CardView) findViewById(R.id.lessonselect);
        edit = (CardView) findViewById(R.id.editlesson);
        eklecard = (CardView) findViewById(R.id.eklecard);

        eklecard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"COMING SOON",Toast.LENGTH_SHORT).show();
            }
        });
 edit.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {
         Toast.makeText(getApplicationContext(),"COMING SOON",Toast.LENGTH_SHORT).show();
         //popUpEditText();

     }
 });

        lessonselect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(lesson11.getText().toString().equalsIgnoreCase(""))
                {

                    Snackbar snackbar;
                    snackbar = Snackbar.make(v,"Please enter your languages names",Snackbar.LENGTH_SHORT);
                    snackbar.show();


                   // Toast.makeText(getApplicationContext(),"Edit Languages",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Intent workStation = new Intent(MainActivity.this, workstation.class);

                    startActivity(workStation);
                }

            }
        });

    }

    private void kaydetpref() {

        preferences = getSharedPreferences("b", MODE_PRIVATE);
        editor = preferences.edit();

        editor.putString("x1", editt1); ////kaydetmek için "edit1" key alan
        editor.putString("x2", editt2);
        editor.apply();
        editor.commit();
    }


    private void popUpEditText() {

        final AlertDialog dialogBuilder = new AlertDialog.Builder(this).create();
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.language_entry, null);

        EditText editText1 = (EditText) dialogView.findViewById(R.id.editlanguage1);
        EditText editText2 = (EditText) dialogView.findViewById(R.id.editlanguage2);
        Button buttonOk = (Button) dialogView.findViewById(R.id.buttonok);
        Button buttonCancel = (Button) dialogView.findViewById(R.id.buttoncancel);

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialogBuilder.dismiss();
            }
        });
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // DO SOMETHINGS

                if((editText1.getText().toString().equalsIgnoreCase(""))||(editText2.getText().toString().equalsIgnoreCase(""))){
                    Snackbar snackbar;
                    snackbar = Snackbar.make(view,"Languages can't be empty",Snackbar.LENGTH_SHORT);
                    snackbar.show();
                }
                else
                    {
                        editt1 = editText1.getText().toString();
                        editt2 = editText2.getText().toString();
                    ////Title
                       // Title title = new Twitle();
                      //  titlemain=title.titleadd(editt1,editt2);
                        titlemain=editt1+"/"+editt2;
                        
                        lesson11.setText(titlemain);
                        lesson11.setTextColor(getResources().getColor(R.color.beyaz));

                        MainTitle =titlemain;
                        t1=editt2+"/"+editt1;
                        kaydetpref();

                    ////Title
                       dialogBuilder.dismiss();
                    }

            }
        });

        dialogBuilder.setView(dialogView);
        dialogBuilder.show();

    }

    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);


        builder
                .setIcon(R.drawable.alertbox)
                .setTitle("Are you sure you want to exit ?")
                //.setMessage("Çıkmak istediğinize emin misiniz ?")
                .setCancelable(false)     //true dersek butoana bir kere daha basarsa mesaj iptal olur
                .setPositiveButton("    " + "Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.super.onBackPressed(); // bu activity'e dön
                    }
                })

                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    }
