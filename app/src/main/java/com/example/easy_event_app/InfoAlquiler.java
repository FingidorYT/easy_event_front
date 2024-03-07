package com.example.easy_event_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.easy_event_app.adapter.AlquilerAdapter;
import com.example.easy_event_app.adapter.ProductoAdapter;
import com.example.easy_event_app.model.Alquiler;
import com.example.easy_event_app.model.AlquilerRespuesta;
import com.example.easy_event_app.model.Producto;
import com.example.easy_event_app.network.AlquilerApiCliente;
import com.example.easy_event_app.network.AlquilerApiService;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InfoAlquiler extends AppCompatActivity {

    private AlquilerApiService servicio;
    private RecyclerView listaProductos;
    private ProductoAdapter productoAdapter;
    private List<Producto> productosLista;
    private Long alquilerId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_alquiler);
        servicio = AlquilerApiCliente.getAlquilerService();
        listaProductos = findViewById(R.id.listaProductos);
        listaProductos.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onStart() {
        super.onStart();
        alquilerId = (long) getIntent().getLongExtra("alquiler_id", -1);

        servicio.alquiler_id(Datainfo.resultLogin.getToken_type() + " " + Datainfo.resultLogin.getAccess_token(), alquilerId).enqueue(new Callback<com.example.easy_event_app.model.InfoAlquiler>() {
            @Override
            public void onResponse(Call<com.example.easy_event_app.model.InfoAlquiler> call, Response<com.example.easy_event_app.model.InfoAlquiler> response) {
                if (response.isSuccessful()) {
                    com.example.easy_event_app.model.InfoAlquiler alquiler = response.body();
                    List<Producto> todoslosproductos = response.body().getProducto_alquiler();

                    ImageView imageView = findViewById(R.id.fotoUser);
                    TextView txtNombre = findViewById(R.id.txtNombre);
                    TextView txtApellido = findViewById(R.id.txtApellido);
                    TextView txtTelefono = findViewById(R.id.txtTelefono);
                    TextView txtEntrega = findViewById(R.id.txtEntrega);
                    TextView txtMetodo = findViewById(R.id.txtMetodo);
                    TextView txtFecha = findViewById(R.id.txtFecha);
                    TextView txtPrecio = findViewById(R.id.txtPrecio);

                    String ruta = "http://10.201.194.46:8000/storage/"+alquiler.getFoto();
                    Picasso.with(getApplicationContext()).load(ruta).into(imageView);
                    txtNombre.setText(alquiler.getNombre());
                    txtApellido.setText(alquiler.getApellido());
                    txtTelefono.setText(String.valueOf(alquiler.getTelefono()));
                    txtEntrega.setText(alquiler.getLugar_entrega());
                    txtMetodo.setText(alquiler.getMetodo_pago());
                    txtFecha.setText(alquiler.getFecha_alquiler());
                    txtPrecio.setText(String.valueOf(alquiler.getPrecio_total()));

                    productosLista = todoslosproductos;
                    cargarListaProductos(productosLista);
                }
            }

            @Override
            public void onFailure(Call<com.example.easy_event_app.model.InfoAlquiler> call, Throwable t) {
                Log.e("Error", t.getMessage());
            }
        });
    }

    private void cargarListaProductos(List<Producto> data) {
        productoAdapter = new ProductoAdapter(productosLista, this);
        listaProductos.setAdapter(productoAdapter);
    }
}