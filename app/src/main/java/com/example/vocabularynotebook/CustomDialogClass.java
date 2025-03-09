package com.example.vocabularynotebook;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.util.Log;

public class CustomDialogClass extends Dialog implements
        View.OnClickListener {

    public Activity c;
    public Dialog d;
    public Button yes, no;
    EditText edit1, edit2;

    public CustomDialogClass(Activity a) {
        super(a);
        // TODO Auto-generated constructor stub
        this.c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.language_entry);
        yes = (Button) findViewById(R.id.buttonok);
        no = (Button) findViewById(R.id.buttoncancel);
        edit1 = (EditText) findViewById(R.id.editlanguage1);
        edit2 = (EditText) findViewById(R.id.editlanguage2);

        yes.setOnClickListener(this);
        no.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.buttonok) {
            String input1 = edit1.getText().toString();
            String input2 = edit2.getText().toString();

            // Eğer bu verileri kullanmak istiyorsanız, burada işlem yapın
            Log.d("CustomDialog", "Edit1: " + input1 + ", Edit2: " + input2);

        } else if (id == R.id.buttoncancel) {
            dismiss();
        }

        dismiss(); // Dialog'u kapat
    }
}