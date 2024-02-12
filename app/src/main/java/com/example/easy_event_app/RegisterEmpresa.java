package com.example.easy_event_app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
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

public class RegisterEmpresa extends AppCompatActivity {

    EditText nitEmp;
    EditText direEmp;
    EditText nomEmp;
    EditText telEmp;
    EditText corrEmp;

    private RegisterEmpAPIService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_empresa);

        nitEmp = findViewById(R.id.nitEmp);
        direEmp = findViewById(R.id.direEmp);
        nomEmp = findViewById(R.id.nomEmp);
        telEmp = findViewById(R.id.telEmp);
        corrEmp = findViewById(R.id.corrEmp);

        Button volverButton = findViewById(R.id.volverButton);

        volverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        service = RegisterEmpAPICliente.getRegisterEmpService();
    }

    public void showPrivacyPolicyDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Políticas de Privacidad");
        builder.setMessage(Html.fromHtml(
                "<br><b>PRIVACIDAD Y DATOS PERSONALES:</b><br><br>\n" +
                        "<b>1. Información Básica del Usuario:</b><br><br>\n" +
                        "La aplicación recopila y utiliza información básica del usuario, como nombre, dirección de correo electrónico y ubicación, con el fin de proporcionar servicios personalizados.<br><br>\n" +
                        "\n" +
                        "<b>2. Uso de Datos:</b><br><br>\n" +
                        "Easy Event utiliza la información proporcionada por los usuarios para mejorar la experiencia y ofrecer recomendaciones personalizadas de eventos.<br><br>\n" +
                        "\n" +
                        "<b>3. Confidencialidad:</b><br><br>\n" +
                        "La información del usuario se trata con confidencialidad y no se comparte con terceros sin el consentimiento explícito del usuario, excepto en casos requeridos por la ley.<br><br>\n" +
                        "\n" +
                        "<b>4. Cookies y Tecnologías Similares:</b><br><br>\n" +
                        "La aplicación puede utilizar cookies u otras tecnologías similares para mejorar la navegación y la experiencia del usuario. Al utilizar la aplicación, el usuario acepta el uso de estas tecnologías.<br>\n" +
                        "\n" +
                        "<br><br><b>USO ADECUADO DE LA APLICACION:</b><br><br>\n" +
                        "<b>1. Responsabilidades del Usuario:</b><br><br>\n" +
                        "Los usuarios se comprometen a utilizar la aplicación de manera ética y legal, respetando las leyes locales y los derechos de otros usuarios.<br><br>\n" +
                        "\n" +
                        "<b>2. Contenido Generado por Usuarios:</b><br><br>\n" +
                        "Easy Event no se hace responsable del contenido generado por los usuarios, pero se reserva el derecho de eliminar o modificar contenido que viole los términos de servicio.<br><br>\n" +
                        "\n" +
                        "<b>3. Cuenta del Usuario:</b><br><br>\n" +
                        "Los usuarios son responsables de mantener la confidencialidad de su cuenta y contraseña. Cualquier actividad realizada desde su cuenta será responsabilidad del usuario.<br><br><br>\n" +
                        "\n" +

                        "<b>REGISTRO Y DATOS DE LA EMPRESA:</b><br><br>" +
                        "<b>1. Información de la Empresa:</b><br><br>" +
                        "Los empresarios deben proporcionar información precisa y actualizada sobre su empresa al registrarse en Easy Event, incluyendo nombre, dirección y detalles de contacto.<br><br>" +
                        "<b>2. Responsabilidad de la Información:</b><br><br>" +
                        "Los empresarios son responsables de la veracidad y legalidad de la información proporcionada. Easy Event se reserva el derecho de verificar la información y tomar medidas si se detecta información falsa.<br><br><br>" +
                        "<b>POLITICAS Y RESPONSABILIDADES:</b><br><br>" +
                        "<b>1. Políticas de Publicación:</b><br><br>" +
                        "Los empresarios aceptan seguir las políticas de publicación de Easy Event, incluyendo pautas sobre contenido permitido, precios transparentes y cualquier otra política relevante.<br><br>" +
                        "<b>2. Responsabilidad Legal:</b><br><br>" +
                        "Los empresarios comprenden que son responsables de cumplir con las leyes y regulaciones locales en relación con sus servicios y eventos publicados en Easy Event.<br><br>" +
                        "<b>3. Comunicación con Usuarios:</b><br><br>" +
                        "Easy Event puede facilitar la comunicación entre empresarios y usuarios, pero la responsabilidad de la calidad del servicio y la comunicación recae en los empresarios.<br>"

        ));

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                performRegistration();
            }
        });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();

                Reg();
            }
        });

        builder.show();
    }

    public void Reg() {
        startActivity(new Intent(RegisterEmpresa.this, MainActivity.class));
    }
    public void registerEmpresa(View view) {
        showPrivacyPolicyDialog();
    }

    private void performRegistration() {
        String cedula = getIntent().getStringExtra("cedula");
        String nombre = getIntent().getStringExtra("nombre");
        String apellido = getIntent().getStringExtra("apellido");
        String correo = getIntent().getStringExtra("correo");
        String fechaNacimiento = getIntent().getStringExtra("fechaNacimiento");
        String telefono = getIntent().getStringExtra("telefono");
        String contraseña = getIntent().getStringExtra("contraseña");

        String nitEmpresa = nitEmp.getText().toString();
        String direEmpresa = direEmp.getText().toString();
        String nomEmpresa = nomEmp.getText().toString();
        String telEmpresa = telEmp.getText().toString();
        String corrEmpresa = corrEmp.getText().toString();

        service.registerEmpresario(cedula, nombre, apellido, correo, fechaNacimiento, telefono, contraseña, nitEmpresa, direEmpresa, nomEmpresa, telEmpresa, corrEmpresa)
                .enqueue(new Callback<RespuestaRegister>() {
                    @Override
                    public void onResponse(Call<RespuestaRegister> call, Response<RespuestaRegister> response) {
                        if (response.isSuccessful()) {
                            Datainfo.resultRegister = response.body();
                            Intent register = new Intent(RegisterEmpresa.this, MainActivity.class);
                            startActivity(register);
                        } else {
                            Toast.makeText(RegisterEmpresa.this, "Error en el registro", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<RespuestaRegister> call, Throwable t) {
                        Toast.makeText(RegisterEmpresa.this, "Error en el registro: " + t.getMessage(), Toast.LENGTH_LONG).show();
                        t.printStackTrace();
                    }
                });
    }
}