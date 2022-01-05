package com.example.teste.cardview.activity.adapter;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teste.cardview.R;
import com.example.teste.cardview.activity.model.Postagem;

import java.util.List;

public class CardViewAdapter extends RecyclerView.Adapter<CardViewHolder> {

    private List<Postagem> postagens;

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_card_view, parent, false);
        CardViewHolder cardView = new CardViewHolder(viewLista);
        return cardView;
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        holder.getAutor().setText(postagens.get(position).getAutor());
        holder.getMensagem().setText(postagens.get(position).getMensagem());
        holder.getCardView().setImageResource(postagens.get(position).getIdImagem());
    }

    @Override
    public int getItemCount() {
        return postagens.size();
    }

    public List<Postagem> getPostagens() {
        return postagens;
    }

    public void setPostagens(List<Postagem> postagens) {
        this.postagens = postagens;
    }
}
