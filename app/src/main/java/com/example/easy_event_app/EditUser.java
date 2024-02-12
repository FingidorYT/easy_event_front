package com.example.easy_event_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class EditUser extends AppCompatActivity {

    EditText nom;
    EditText apell;
    EditText corr;
    EditText tel;
    EditText cont;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);

        nom = findViewById(R.id.nom);
        apell = findViewById(R.id.apell);
        corr = findViewById(R.id.corr);
        tel = findViewById(R.id.tel);
        cont = findViewById(R.id.cont);

    }
}