package com.example.easy_event_app.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easy_event_app.EditUser;
import com.example.easy_event_app.R;
import com.example.easy_event_app.model.Alquiler;
import com.example.easy_event_app.InfoAlquiler;

import java.util.List;

public class AlquilerAdapter extends RecyclerView.Adapter<AlquilerAdapter.ViewHolder>{



    private List<Alquiler> alquileres;
    private Context context;

    private AlquilerAdapter.OnItemClickListener onItemClickListener; // Nueva línea

    public AlquilerAdapter(List<Alquiler> alquileres, Context context) {
        this.alquileres = alquileres;
        this.context = context;
        Log.i("alquileres", alquileres.toString());
    }

    @Override
    public AlquilerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_alquiler, parent, false);
        return new AlquilerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AlquilerAdapter.ViewHolder holder, int position) {
        Alquiler alquiler = this.alquileres.get(position);
        holder.txtNombreUser.setText(alquiler.getNombre());
        holder.txtFecha.setText(String.valueOf(alquiler.getFecha_alquiler()));
        holder.txtEstado.setText(alquiler.getEstado_pedido());
        holder.txtPrecio.setText(String.valueOf(alquiler.getPrecio_alquiler()));

        // Establecer un OnClickListener para el CardView
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener el contexto desde el CardView y abrir la nueva actividad
                Context context = view.getContext();
                Intent intent = new Intent(context, InfoAlquiler.class); // Reemplaza "NuevaActividad" con el nombre de tu actividad
                intent.putExtra("alquiler_id", alquiler.getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return alquileres != null ? alquileres.size() : 0;
    }

    public void setOnItemClickListener(AlquilerAdapter.OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(Alquiler alquiler);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtNombreUser;
        TextView txtFecha;
        TextView txtEstado;
        TextView txtPrecio;
        TextView nada;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            txtNombreUser = itemView.findViewById(R.id.txtNombreUser);
            txtFecha = itemView.findViewById(R.id.txtFecha);
            txtEstado = itemView.findViewById(R.id.txtEstado);
            txtPrecio = itemView.findViewById(R.id.txtPrecio);
            cardView = itemView.findViewById(R.id.cardView2); // Reemplaza con el ID de tu CardView
        }
    }


}
