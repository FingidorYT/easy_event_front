package com.example.easy_event_app;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easy_event_app.model.Producto;
import com.example.easy_event_app.network.ProductoAPICliente;
import com.example.easy_event_app.network.ProductoAPIService;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InfoProductoEmpresario extends AppCompatActivity {

    private ProductoAPIService servicio;
    private ProductoAPICliente catego;
    private RecyclerView recyclerViewProductos;
    EditText editTextNumber;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_producto_empresario);

        servicio = ProductoAPICliente.getProductoService();

        int productoId = (int) getIntent().getLongExtra("PRODUCTO_ID", -1);
        Log.d("ProductoID", "ID de Producto: " + productoId);


        servicio.producto(Datainfo.resultLogin.getToken_type() + " " + Datainfo.resultLogin.getAccess_token(), productoId)
                .enqueue(new Callback<Producto>() {
                    @Override
                    public void onResponse(Call<Producto> call, Response<Producto> response) {
                        if (response.isSuccessful()) {
                            Producto producto = response.body();

                            ImageView imageView = findViewById(R.id.imageView);
                            TextView txtNombreProduc = findViewById(R.id.txtNombreProduc);
                            TextView txtPrecioProduc = findViewById(R.id.txtPrecioProduc);
                            TextView txtCantidad = findViewById(R.id.txtCantidad);

                            String ruta = "http://10.201.194.46:8000/storage/"+producto.getFoto();
                            Picasso.with(getApplicationContext()).load(ruta).into(imageView);
                            txtNombreProduc.setText(producto.getNombre_producto());
                            txtPrecioProduc.setText(String.valueOf(producto.getPrecio()));
                            txtCantidad.setText(String.valueOf(producto.getCantidad_disponible()));
                        }
                    }

                    @Override
                    public void onFailure(Call<Producto> call, Throwable t) {
                        // Manejar el fallo de la solicitud
                    }
                });

        /*editTextNumber = findViewById(R.id.editTextNumber);
        Button btnDecrease = findViewById(R.id.btnDecrease);
        Button btnIncrease = findViewById(R.id.btnIncrease);

        btnDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decreaseValue();
            }
        });

        btnIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increaseValue();
            }
        });

        Intent intent = getIntent();
        String nombreProducto = intent.getStringExtra("nombre_producto");
        int cantidadDisponible = intent.getIntExtra("cantidad_disponible", 0);
        long precioProducto = intent.getLongExtra("precio_producto", 0);


        NumberFormat format = NumberFormat.getCurrencyInstance();
        format.setMaximumFractionDigits(0);
        format.setCurrency(Currency.getInstance("COP"));
        String precioSigno = format.format(precioProducto);


        TextView txtNombreProduc = findViewById(R.id.txtNombreProduc);
        TextView txtCantidad = findViewById(R.id.txtCantidad);
        TextView txtPrecioProduc = findViewById(R.id.txtPrecioProduc);

        txtNombreProduc.setText(nombreProducto);
        txtCantidad.setText(String.valueOf(cantidadDisponible));
        txtPrecioProduc.setText(precioSigno);*/







        ImageButton volverButton = findViewById(R.id.volverButton);

        volverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    /*public void decreaseValue() {
        int currentValue = Integer.parseInt(editTextNumber.getText().toString());
        if (currentValue > 0) {
            editTextNumber.setText(String.valueOf(currentValue - 1));
        }
    }

    public void increaseValue() {
        int currentValue = Integer.parseInt(editTextNumber.getText().toString());
        editTextNumber.setText(String.valueOf(currentValue + 1));
    }*/
}