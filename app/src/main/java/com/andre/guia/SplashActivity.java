package com.andre.guia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SplashActivity extends AppCompatActivity {

    private Button buttonTransicao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        setUI();
        setAction();
    }

    private void setUI(){
        buttonTransicao = (Button) findViewById(R.id.buton_transicao);
    }

    private void setAction(){

        buttonTransicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //meu codigo

                mudarTela();

            }
        });

    }

    private void mudarTela(){
        Intent intent = new Intent(SplashActivity.this,SearchActivity.class);
        startActivity(intent);
    }



}