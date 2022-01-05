package com.example.teste.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imagemPC = null;
    private Carta[] cartas = {Carta.PAPEL, Carta.TESOURA, Carta.PEDRA};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imagemPC = findViewById(R.id.cartaPC);
    }

    public void jogar(View v) {
        ImageView image = findViewById(v.getId());
        Carta cartaJogador = getCarta(image.getId());
        Carta cartaPC = getCartaPC();
        calcularVencedor(cartaJogador, cartaPC);
    }

    private void calcularVencedor(Carta cartaJogador, Carta cartaPC) {

        if (cartaJogador.equals(cartaPC)) {
            empate();
            return;
        } else if (Carta.PEDRA.equals(cartaJogador)) {
            if (Carta.PAPEL.equals(cartaPC)) {
                perdeu();
            }else if (Carta.TESOURA.equals(cartaPC)) {
                ganhou();
            }
        } else if (Carta.PAPEL.equals(cartaJogador)) {
            if (Carta.TESOURA.equals(cartaPC)) {
                perdeu();
            } else if (Carta.PEDRA.equals(cartaPC)) {
                ganhou();
            }
        } else if (Carta.TESOURA.equals(cartaJogador)) {
            if (Carta.PEDRA.equals(cartaPC)) {
                perdeu();
            }else if (Carta.PAPEL.equals(cartaPC)) {
                ganhou();
            }
        }
    }

    private void ganhou() {
        TextView resultado = findViewById(R.id.resultado);
        resultado.setText("Você ganhou :D");
    }

    private void perdeu() {
        TextView resultado = findViewById(R.id.resultado);
        resultado.setText("Você perdeu :(");
    }
    private void empate() {
        TextView resultado = findViewById(R.id.resultado);
        resultado.setText("Empate");
    }

    private Carta getCartaPC() {
        int carta = new Random().nextInt(3);
        Carta retorno = cartas[carta];
        imagemPC.setImageResource(retorno.getIdImagem());
        return retorno;
    }

    private Carta getCarta(int id) {
        Carta retorno = null;
        switch (id) {
            case R.id.pedra: retorno = Carta.PEDRA; break;
            case R.id.papel: retorno = Carta.PAPEL; break;
            case R.id.tesoura: retorno = Carta.TESOURA; break;
            default: break;
        }
        return retorno;
    }

    enum Carta {
        PEDRA("pedra", R.drawable.pedra),
        PAPEL("papel", R.drawable.papel),
        TESOURA("tesoura", R.drawable.tesoura);

        private String nome;
        private int idImagem;

        private Carta(String nome, int id) {
            this.nome = nome;
            this.idImagem = id;
        }

        public Carta getById(int id) {
            for (Carta carta: Carta.values()) {
                if (carta.getIdImagem() == id) {
                    return carta;
                }
            }
            return null;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getNome() {
            return nome;
        }

        public int getIdImagem() {
            return idImagem;
        }

        public void setIdImagem(int idImagem) {
            this.idImagem = idImagem;
        }
    }

}