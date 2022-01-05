package com.example.teste.combustivel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText iptAlcool;
    TextInputEditText iptGasolina;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iptAlcool = findViewById(R.id.iptAlcool);
        iptGasolina = findViewById(R.id.iptGasolina);
        resultado = findViewById(R.id.idResultado);
    }

    public void calcular(View view) {
        String pAlcool = iptAlcool.getText().toString();
        String pGasolina = iptGasolina.getText().toString();

        validar(pAlcool, pGasolina);

        Double precoAlcool = Double.valueOf(iptAlcool.getText().toString());
        Double precoGasolina = Double.valueOf(iptGasolina.getText().toString());


        if (precoAlcool < (precoGasolina * 0.7)) {
            resultado.setText("Melhor utilizar Álcool");
        } else {
            resultado.setText("Melhor utilizar Gasolina");
        }
    }

    private boolean validar(String precoAlcool, String precoGasolina) {
        if (precoAlcool == null || precoAlcool == "") {
            resultado.setText("preencha o preço do álcool");
            return false;
        }
        if (precoGasolina == null || precoGasolina == "") {
            resultado.setText("preencha o preço da gasolina");
            return false;
        }
        return true;
    }
}