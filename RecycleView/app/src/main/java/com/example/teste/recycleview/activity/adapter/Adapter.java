package com.example.teste.recycleview.activity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teste.recycleview.R;
import com.example.teste.recycleview.activity.model.Filme;

import java.util.Date;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    List<Filme> filmes;
    public Adapter(List<Filme> lista) {
        this.filmes = lista;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_lista, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Filme filme = filmes.get(position);
        holder.ano.setText(filme.getAno());
        holder.titulo.setText(filme.getTitulo());
        holder.genero.setText(filme.getGenero());
    }

    @Override
    public int getItemCount() {
        return filmes.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView titulo;
        private TextView ano;
        private TextView genero;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.titulo);
            ano = itemView.findViewById(R.id.ano);
            genero = itemView.findViewById(R.id.genero);
        }

    }
}
