package com.example.teste.cardview.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.teste.cardview.R;
import com.example.teste.cardview.activity.adapter.CardViewAdapter;
import com.example.teste.cardview.activity.model.Postagem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView view;
    private List<Postagem> postagens;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = findViewById(R.id.recycleView);
//        RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext());
//        LinearLayoutManager manager = new LinearLayoutManager(this);
//        manager.setOrientation(RecyclerView.HORIZONTAL);

        GridLayoutManager manager = new GridLayoutManager(this, 2);



        view.setLayoutManager(manager);

        CardViewAdapter adapter = new CardViewAdapter();
        view.setAdapter(adapter );

        postagens = montarPostagens();
        adapter.setPostagens(postagens);

    }

    private List<Postagem> montarPostagens() {
        List<Postagem> retorno = new ArrayList<Postagem>();
        retorno.add(new Postagem("Valter Kamiji", "Viagem daHora!!", R.drawable.imagem1));
        retorno.add(new Postagem("Dani", "Super! Hiper!", R.drawable.imagem2));
        retorno.add(new Postagem("Victor", "trilegal Tche!!", R.drawable.imagem3));
        retorno.add(new Postagem("Rafael", "Ohhh trem Baum!!", R.drawable.imagem4));

        return retorno;
    }
}