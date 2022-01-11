package com.example.teste.fragments.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.teste.fragments.R;
import com.example.teste.fragments.fragments.FragmentOne;
import com.example.teste.fragments.fragments.FragmentoTwo;

public class MainActivity extends AppCompatActivity {

    private Button btFrag1;
    private Button btFrag2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btFrag1 = findViewById(R.id.btMenu1);
        btFrag2 = findViewById(R.id.btMenu2);

        btFrag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentOne one = FragmentOne.newInstance("fragmeto1Param", "fragmeto1Param");
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.idframeLayout, one);
                transaction.commit();
            }
        });

        btFrag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentoTwo two = FragmentoTwo.newInstance("fragmeto2Param", "fragmeto2Param");
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.idframeLayout, two);
                transaction.commit();
            }
        });
    }
}