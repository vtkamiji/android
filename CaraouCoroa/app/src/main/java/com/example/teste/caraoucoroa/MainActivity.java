package com.example.teste.caraoucoroa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Date;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button jogar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jogar = findViewById(R.id.btJogar);
        jogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resultado = getCaraCoroa();

                Intent intent = new Intent(getApplicationContext(), Resultado.class);
                intent.putExtra("resultado", resultado);
                startActivity(intent);
            }
        });
    }

    private String getCaraCoroa() {
        Date now = new Date();
        if (now.getTime() % 2 == 0) {
            return "cara";
        } else {
            return "coroa";
        }
    }
}