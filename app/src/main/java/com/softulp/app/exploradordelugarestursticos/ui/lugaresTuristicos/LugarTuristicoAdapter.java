package com.softulp.app.exploradordelugarestursticos.ui.lugaresTuristicos;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.softulp.app.exploradordelugarestursticos.R;

import java.util.List;

public class LugarTuristicoAdapter extends RecyclerView.Adapter<LugarTuristicoAdapter.ViewHolder> {
    private List<LugarTuristico> lista;
    Context context;

    public LugarTuristicoAdapter(List<LugarTuristico> lista,Context context){

        this.lista=lista;
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LugarTuristico lugar=lista.get(position);
        holder.nombre.setText(lugar.getNombre());
        holder.descripcion.setText(lugar.getDescripcion());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle=new Bundle();
                bundle.putSerializable("lugar",lugar);
                Navigation.findNavController((Activity) v.getContext(), R.id.nav_host_fragment_content_main).navigate(R.id.nav_masInfoFragment,bundle);


            }

        });

    }

    @Override
    public int getItemCount() {

            return lista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nombre,descripcion;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre=itemView.findViewById(R.id.tvNombre);
            descripcion=itemView.findViewById(R.id.tvDescripcion);

        }
    }
}

