package com.example.teste.cardview.activity.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teste.cardview.R;

public class CardViewHolder extends RecyclerView.ViewHolder {

    private TextView autor;
    private TextView mensagem;
    private ImageView cardView;

    public CardViewHolder(@NonNull View itemView) {
        super(itemView);
        autor = itemView.findViewById(R.id.txtAutor);
        mensagem = itemView.findViewById(R.id.txtPostagem);
        cardView = itemView.findViewById(R.id.imageView);
    }

    public TextView getAutor() {
        return autor;
    }

    public void setAutor(TextView autor) {
        this.autor = autor;
    }

    public TextView getMensagem() {
        return mensagem;
    }

    public void setMensagem(TextView mensagem) {
        this.mensagem = mensagem;
    }

    public ImageView getCardView() {
        return cardView;
    }

    public void setCardView(ImageView cardView) {
        this.cardView = cardView;
    }
}
