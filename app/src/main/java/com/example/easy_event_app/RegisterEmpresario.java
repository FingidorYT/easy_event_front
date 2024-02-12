package com.example.easy_event_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.easy_event_app.model.RespuestaRegister;
import com.example.easy_event_app.network.RegisterEmpAPICliente;
import com.example.easy_event_app.network.RegisterEmpAPIService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterEmpresario extends AppCompatActivity {

    public void Next(View view) {
        startActivity(new Intent(this, RegisterEmpresa.class));
    }

    EditText ced;
    EditText nom;
    EditText apell;
    EditText corr;
    EditText fech;
    EditText tel;
    EditText cont;


    private RegisterEmpAPIService service;

    public void registerEmpresario (View view) {
        ced = findViewById(R.id.ced);
        nom = findViewById(R.id.nom);
        apell = findViewById(R.id.apell);
        corr = findViewById(R.id.corr);
        fech = findViewById(R.id.fech);
        tel = findViewById(R.id.tel);
        cont = findViewById(R.id.cont);


        String cedula = ced.getText().toString().trim();
        String nombre = nom.getText().toString();
        String apellido = apell.getText().toString();
        String correo = corr.getText().toString();
        String fechaNacimiento = fech.getText().toString();
        String telefono = tel.getText().toString();
        String contraseña = cont.getText().toString();

        Intent pasar = new Intent(this, RegisterEmpresa.class);
        pasar.putExtra("cedula", cedula);
        pasar.putExtra("nombre", nombre);
        pasar.putExtra("apellido", apellido);
        pasar.putExtra("correo", correo);
        pasar.putExtra("fechaNacimiento", fechaNacimiento);
        pasar.putExtra("telefono", telefono);
        pasar.putExtra("contraseña", contraseña);
        startActivity(pasar);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_empresario);

        Button volverButton = findViewById(R.id.volverButton);

        volverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        service = RegisterEmpAPICliente.getRegisterEmpService();
    }
}