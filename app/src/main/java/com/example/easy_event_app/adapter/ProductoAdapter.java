package com.example.easy_event_app.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easy_event_app.EditUser;
import com.example.easy_event_app.InfoProductoEmpresario;
import com.example.easy_event_app.R;
import com.example.easy_event_app.model.Producto;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ViewHolder>{


    private List<Producto> productos;
    private Context context;

    private OnItemClickListener onItemClickListener; // Nueva línea

    public ProductoAdapter(List<Producto> productos, Context context) {
        this.productos = productos;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_producto, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Producto producto = this.productos.get(position);
        holder.txtNombreProducto.setText(producto.getNombre_producto());
        holder.CantidadDisponible.setText(""+producto.getCantidad_disponible());
        String ruta = "http://10.201.194.46:8000/storage/"+producto.getFoto();
        Picasso.with(context).load(ruta).into(holder.FotoProducto);
        holder.txtPrecio.setText(String.valueOf(producto.getPrecio()));

        // Establecer un OnClickListener para el CardView
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener el contexto desde el CardView y abrir la nueva actividad
                Context context = view.getContext();
                Intent intent = new Intent(context, InfoProductoEmpresario.class); // Reemplaza "NuevaActividad" con el nombre de tu actividad
                intent.putExtra("PRODUCTO_ID", producto.getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productos != null ? productos.size() : 0;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(Producto producto);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtNombreProducto;
        TextView txtPrecio;
        ImageView FotoProducto;
        TextView CantidadDisponible;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            txtNombreProducto = itemView.findViewById(R.id.txtNombreProducto);
            FotoProducto = itemView.findViewById(R.id.FotoProducto);
            CantidadDisponible = itemView.findViewById(R.id.CantidadDisponible);
            txtPrecio = itemView.findViewById(R.id.txtPrecio);
            cardView = itemView.findViewById(R.id.cardView2); // Reemplaza con el ID de tu CardView
        }
    }

}
