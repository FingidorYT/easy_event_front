package com.example.easy_event_app;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.easy_event_app.adapter.ProductoAdapter;
import com.example.easy_event_app.model.Producto;
import com.example.easy_event_app.model.ProductoRespuesta;
import com.example.easy_event_app.network.ProductoAPICliente;
import com.example.easy_event_app.network.ProductoAPIService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProductosEmpresario#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProductosEmpresario extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ProductoAPIService servicios;
    private ProductoAdapter productoAdapter;
    private List<Producto> productosLista;
    private RecyclerView productoRecyclerView;
    private SwipeRefreshLayout refresh;
    private FloatingActionButton addProducto;

    public ProductosEmpresario() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProductosEmpresario.
     */
    // TODO: Rename and change types and number of parameters
    public static ProductosEmpresario newInstance(String param1, String param2) {
        ProductosEmpresario fragment = new ProductosEmpresario();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        servicios = ProductoAPICliente.getProductoService();
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    @Override
    public void onStart() {
        super.onStart();

        cargarProductos();

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_productos_empresario, container, false);

        refresh = view.findViewById(R.id.refresh);
        refresh.setOnRefreshListener(this);
        addProducto = view.findViewById((R.id.addProducto));
        addProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent add = new Intent(getActivity(), AddProducto.class);
                startActivity(add);
            }
        });

        productoRecyclerView = view.findViewById(R.id.lista);
        productoRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        productoAdapter = new ProductoAdapter(productosLista, getActivity());
        productoRecyclerView.setAdapter(productoAdapter);
        return view;
    }

    private void cargarProductos(){
        servicios.productos(Datainfo.resultLogin.getToken_type() + " " + Datainfo.resultLogin.getAccess_token()).enqueue(new Callback<ProductoRespuesta>() {
            @Override
            public void onResponse(Call<ProductoRespuesta> call, Response<ProductoRespuesta> response) {
                if (response.isSuccessful()) {
                    List<Producto> todosLosProductos = response.body().getProducto();
                    productosLista = todosLosProductos;
                    cargarListaProductos(productosLista);
                }
            }

            @Override
            public void onFailure(Call<ProductoRespuesta> call, Throwable t) {
                Log.e("Error", t.getMessage());
            }
        });
    }

    private void cargarListaProductos(List<Producto> data) {
        productoAdapter = new ProductoAdapter(productosLista, getActivity());
        productoRecyclerView.setAdapter(productoAdapter);
    }


    @Override
    public void onRefresh() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                refresh.setRefreshing(false);
                cargarProductos();

            }
        }, 100);

    }
}