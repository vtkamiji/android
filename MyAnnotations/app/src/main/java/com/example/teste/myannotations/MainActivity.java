package com.example.teste.myannotations;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.teste.myannotations.databinding.ActivityMainBinding;
import com.google.android.material.textfield.TextInputEditText;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private static final String ARQUIVO_PREFERENCES = "preferencias";
    private static final String ANOTACAO = "anotacao";
    private static final String VAZIO = "Escreva sua anotacao";
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    private EditText anotacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        anotacao = findViewById(R.id.txtAnnotation);

        prefs = getSharedPreferences(ARQUIVO_PREFERENCES, 0);
        editor = prefs.edit();

        carregarTextoSalvo(prefs.getString(ANOTACAO, VAZIO));

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarAnotacao();
                Toast.makeText(view.getContext(), "Anotacao Salva", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void carregarTextoSalvo(String anotacao) {
        this.anotacao.setText(anotacao);
    }

    private void salvarAnotacao() {
        if (anotacao.getText() != null &&  anotacao.getText().toString() != "") {
            editor.putString(ANOTACAO, anotacao.getText().toString());
            editor.commit();
        }
    }
}