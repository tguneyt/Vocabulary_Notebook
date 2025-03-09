package com.example.vocabularynotebook;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.vocabularynotebook.MainActivity.MainTitle;

public class SelfText extends AppCompatActivity {

    TextView selftitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_text);
        ////Title
        selftitle = (TextView) findViewById(R.id.selftitle);
        selftitle.setText(MainTitle);
        Typeface font1 = Typeface.createFromAsset(getAssets(),"font/topsecret.ttf");
        selftitle.setTypeface(font1);
        ////Title

    }
}