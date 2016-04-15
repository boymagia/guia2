package com.andre.guia;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.andre.guia.entity.CasaEntity;

public class DescriptionActivity extends AppCompatActivity {

    private CasaEntity casa;
    private TextView endereco;
    private TextView telefone;
    private  TextView descricao;
    private Button ligar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        casa = (CasaEntity) getIntent().getSerializableExtra("casa");
        setUI();
        setInfo();


    }

    private void setUI(){
        endereco = (TextView) findViewById(R.id.edereco);
        telefone = (TextView) findViewById(R.id.telefone);
        descricao = (TextView) findViewById(R.id.descricao);
        ligar = (Button) findViewById(R.id.ligar);
    }

    private void setInfo(){

        endereco.setText(casa.getAddress());
        telefone.setText(casa.getTel());
        descricao.setText(casa.getDescription());
        ligar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String number = (casa.getTel());
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", number, null));
                startActivity(intent);
            }
        });

    }

}
