package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EstudianteAdapter extends RecyclerView.Adapter<EstudianteAdapter.EstudianteViewHolder> {

    private ArrayList<Estudiante> ListaEstudiantes;

    public EstudianteAdapter(ArrayList<Estudiante> listaEstudiantes){this.ListaEstudiantes=listaEstudiantes;}

    @NonNull
    @Override
    public EstudianteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View Itemview = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_estudiante, parent, false);

        return new EstudianteViewHolder(Itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull EstudianteViewHolder holder, int position) {
        Estudiante estudiante=ListaEstudiantes.get(position);
        holder.tvNombre.setText(estudiante.getNombre());
        holder.tvApellido.setText(estudiante.getApellido());
        holder.tvSexo.setText(estudiante.getSexo());
        holder.tvCarrera.setText(estudiante.getCarrera());

        String inicial=estudiante.getNombre().substring(0,1).toUpperCase();
        holder.tvInicial.setText(inicial);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {return ListaEstudiantes.size();}

    public static class EstudianteViewHolder extends RecyclerView.ViewHolder{

        public TextView tvNombre,tvApellido,tvSexo,tvCarrera,tvInicial;
        public EstudianteViewHolder(View view) {
            super(view);
            tvNombre=view.findViewById(R.id.tvNombre);
            tvApellido=view.findViewById(R.id.tvApellido);
            tvSexo=view.findViewById(R.id.tvSexo);
            tvCarrera=view.findViewById(R.id.tvCarrera);
            tvInicial=view.findViewById(R.id.tvIncial);
        }
    }
}
