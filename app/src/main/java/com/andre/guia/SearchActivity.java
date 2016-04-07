package com.andre.guia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

public class SearchActivity extends AppCompatActivity {
    private Button buttonLista;
    private CardView cardViewNumero1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        setUI();
        setAction();
    }

    private void setUI() {
        buttonLista = (Button) findViewById(R.id.buton_Lista);
        cardViewNumero1 = (CardView) findViewById(R.id.card_numero1);

    }


    private void setAction() {
        buttonLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //meu codigo

                mudarTela();
                //mostrar mensagen
            }
        });
    }
    private void mudarTela(){
        Intent intent = new Intent(SearchActivity.this,DescriptionActivity.class);
        startActivity(intent);
    }


}
