package com.example.teste.gorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText iptValorConta;
    private TextView txtPerGorjeta;
    private SeekBar iptPercGorjeta;
    private TextView txtResGorjeta;
    private TextView txtResTotal;

    private Double perGorjeta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iptValorConta = findViewById(R.id.iptValor);
        txtPerGorjeta = findViewById(R.id.perGorjeta);
        iptPercGorjeta = findViewById(R.id.iptPerGorjeta);
        txtResGorjeta = findViewById(R.id.resGorjeta);
        txtResTotal = findViewById(R.id.resTotal);

        this.addListerner();
    }

    private void addListerner() {
        this.iptPercGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                perGorjeta = Double.valueOf(progress);
                txtPerGorjeta.setText(progress+"%");
                calcularTotais();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                txtPerGorjeta.setText(seekBar.getProgress() + "%");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                txtPerGorjeta.setText(seekBar.getProgress() + "%");
            }
        });
    }

    private void calcularTotais() {
        String valorContaTxt = iptValorConta.getText().toString();
        if (valorContaTxt != null && !valorContaTxt.isEmpty()) {
            Double conta = Double.valueOf(valorContaTxt);
            Double valorGorjeta = conta * (this.perGorjeta/100);
            Double valorTotal = conta + valorGorjeta;

            txtResGorjeta.setText( "R$" + valorGorjeta);
            txtResTotal.setText( "R$" + valorTotal);
        }
    }
}