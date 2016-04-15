package com.andre.guia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    private Button buttonTransicao;
    private static final int DELAY= 1000;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        TimerTask timerTask =  new TimerTask() {
            @Override
            public void run() {
                mudarTela();
                finish();
            }
        };

        Timer timer = new Timer();
        timer.schedule(timerTask, DELAY);

        //setUI();
        //setAction();
    }

    private void setUI(){
        //buttonTransicao = (Button) findViewById(R.id.buton_transicao);
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