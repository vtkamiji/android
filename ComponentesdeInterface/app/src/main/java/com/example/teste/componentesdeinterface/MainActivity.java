package com.example.teste.componentesdeinterface;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private EditText campoNome;
    private TextInputEditText campoEmail;
    private  TextView resultado;

    private ProgressBar progressBarH;
    private ProgressBar progressBarC;

    private SeekBar seekDivertido;
    private TextView textResDivertido;
    private int divertido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.progressBarC = findViewById(R.id.progressBarC);
        this.progressBarC.setVisibility(View.GONE);
        this.progressBarH = findViewById(R.id.progressBarH);

        this.seekDivertido = findViewById(R.id.seekBarDivertido);
        setSeekBarListener(this.seekDivertido);
        this.textResDivertido = findViewById(R.id.resDivertido);
    }

    private void setSeekBarListener(SeekBar seekDivertido) {
        seekDivertido.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                divertido = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void enviar(View view) {

    }

    public void abrirToast(View view) {
        Toast.makeText(getApplicationContext(), "Toast Simples", Toast.LENGTH_LONG).show();
        abrirToastImagem(view);
    }

    public void abrirToastImagem(View view) {

        ImageView image = new ImageView(getApplicationContext());
        image.setImageResource(android.R.drawable.star_big_off);

        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(image);
        toast.show();
    }

    public void abrirDialog(View view) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Dialogo de Alerta");
        dialog.setMessage("Escolha uma alternativa");
        dialog.setCancelable(false);
        dialog.setIcon(android.R.drawable.ic_dialog_alert);

        dialog.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Escolhido SIM", Toast.LENGTH_LONG).show();
            }
        });

        dialog.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Escolhido NÃO", Toast.LENGTH_LONG).show();
            }
        });
        dialog.create();
        dialog.show();
    }

    public void incrementaProgress(View view) {
        progressBarH.setProgress(progressBarH.getProgress()+2);

        progressBarC.setVisibility(View.VISIBLE);
        if (progressBarH.getProgress() >= 10) {
            progressBarC.setVisibility(View.GONE);
            progressBarH.setVisibility(View.GONE);
        }
    }

    public void setDivertido(View view) {
        this.divertido = this.seekDivertido.getProgress();
    }

    public void recuperarValorDivertido(View view) {
        this.textResDivertido.setText("Nota " + this.divertido + " de Divertido");
    }

}