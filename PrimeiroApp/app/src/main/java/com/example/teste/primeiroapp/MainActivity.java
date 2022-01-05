package com.example.teste.primeiroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.time.Clock;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sortear(View view) {
        TextView texto = findViewById(R.id.numSorteado);
        int num = sortearNumero();
        texto.setText(Integer.toString(num));
    }

    private int sortearNumero() {
        return (int)(Math.random()*10);
    }
}