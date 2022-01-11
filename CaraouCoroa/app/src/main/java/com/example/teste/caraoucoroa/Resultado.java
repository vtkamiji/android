package com.example.teste.caraoucoroa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    private static final String CARA = "cara";
    private static final String COROA = "coroa";

    private ImageView caraCoroaImagem;
    private TextView resultado;
    private Button btVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        caraCoroaImagem = findViewById(R.id.caraCoroaImagem);
        resultado = findViewById(R.id.txtResultado);
        btVoltar = findViewById(R.id.btVoltar);

        Bundle dados = getIntent().getExtras();
        String caraOuCoroa = dados.get("resultado").toString();

        if (CARA.equals(caraOuCoroa)) {
            caraCoroaImagem.setImageResource(R.drawable.moeda_cara);
            resultado.setText("CARA");
        } else {
            caraCoroaImagem.setImageResource(R.drawable.moeda_coroa);
            resultado.setText("COROA");
        }

        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}