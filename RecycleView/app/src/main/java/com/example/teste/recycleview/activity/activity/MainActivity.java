package com.example.teste.recycleview.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.teste.recycleview.R;
import com.example.teste.recycleview.activity.adapter.Adapter;
import com.example.teste.recycleview.activity.adapter.RecyclerItemClickListener;
import com.example.teste.recycleview.activity.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycleView;
    List<Filme> listaFilmes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        criarFilmes();

        Adapter myAdapter = new Adapter(this.listaFilmes);

        recycleView = findViewById(R.id.recycleView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recycleView.setLayoutManager(layoutManager);

        recycleView.setHasFixedSize(true);
        recycleView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.HORIZONTAL));

        recycleView.addOnItemTouchListener(new RecyclerItemClickListener(
                getApplicationContext(),
                recycleView,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Filme selecionado = listaFilmes.get(position);
                        Toast.makeText(getApplicationContext(), "Item pressionado" + selecionado.getTitulo(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        Filme selecionado = listaFilmes.get(position);
                        Toast.makeText(getApplicationContext(), "Item Longo pressionado" + selecionado.getTitulo(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    }
                }
                )

        );

        recycleView.setAdapter(myAdapter);
    }

    private void criarFilmes() {
        this.listaFilmes = new ArrayList<>();
        listaFilmes.add(new Filme("Jurassic Park", "2018", "Aventura"));
        listaFilmes.add(new Filme("Homem Aranha", "2021", "Super Heroi"));
        listaFilmes.add(new Filme("Duna", "2018", "Ficção Científica"));
        listaFilmes.add(new Filme("Matrix Ressurrection", "2021", "Shithole"));

    }
}