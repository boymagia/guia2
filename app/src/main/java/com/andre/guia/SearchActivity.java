package com.andre.guia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.andre.guia.adapter.CasasAdapter;
import com.andre.guia.entity.CasaEntity;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {
    // private Button buttonLista;
    private List<CasaEntity> casas;
    private RecyclerView listaCasas;

    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        setUI();
        setToolbar(getString(R.string.app_name));
        setCasas();
        setRecyclerView();
    }

    private void setUI() {
        //buttonLista = (Button) findViewById(R.id.buton_Lista);
        casas = new ArrayList<>();
        listaCasas = (RecyclerView) findViewById(R.id.lista_casas);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    private void setToolbar(String name){
        toolbar.setTitle(name);
        setSupportActionBar(toolbar);
    }

    private void setCasas() {
        CasaEntity casa = new CasaEntity();
        casa.setName("Cravi");
        casa.setAddress("Rua José Serrato, Nº 55 - Boa Vista");
        casa.setDescription("A CRAVI atua na Modalidade de Comunidade Terapêutica");
        casa.setTel("41 3356 6100");
        casa.setImage(R.drawable.cravi);
        casa.setLat(-25.377484);
        casa.setLng(-49.242441);
        casas.add(casa);

        casa = new CasaEntity();
        casa.setName("Emunah Centro de Habilatacao");
        casa.setAddress("Rua Carlos Belão, 464 - Vila Juliana - Piraquara - PR");
        casa.setDescription("");
        casa.setTel("41 3590 0518");
        casa.setImage(R.drawable.emanuah);
        casa.setLat(-25.456100);
        casa.setLng(-49.069330);
        casas.add(casa);

        casa = new CasaEntity();
        casa.setName("VIVA Clinica Terapeutica");
        casa.setAddress("Rua Sao Sebastiao, 231 - sala 02 e 03, Bairro Ahu - Curitiba/PR");
        casa.setDescription("");
        casa.setTel("41 9118 9091");
        casa.setImage(R.drawable.viva);
        casa.setLat(-25.405545);
        casa.setLng(-49.259595);
        casas.add(casa);

        casa = new CasaEntity();
        casa.setName("Clinica Nova Esperanca");
        casa.setAddress("Av. Silva Jardim, 4205 Curitiba PR CEP: 80240-021");
        casa.setDescription("casa de apoio para usarios");
        casa.setTel("41 3244 4155");
        casa.setImage(R.drawable.novaesperanca);
        casa.setLat(-25.451949);
        casa.setLng(-49.300083);
        casas.add(casa);

        casa = new CasaEntity();
        casa.setName("Grupo Vale Comunidade teraupetica");
        casa.setAddress("Estrada do Saivá, s/n, km 02° Saivá Antonina - PR ");
        casa.setDescription("");
        casa.setTel("41 3432 0905");
        casa.setImage(R.drawable.grupovale);
        casa.setLat(-25.440405);
        casa.setLng(-48.727867);
        casas.add(casa);


    }

    private void setRecyclerView() {

        listaCasas.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        listaCasas.setLayoutManager(mLayoutManager);

        CasasAdapter mAdapter = new CasasAdapter(casas);
        mAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int position = listaCasas.getChildLayoutPosition(view);
                mudarTela(casas.get(position));

            }
        });

        listaCasas.setAdapter(mAdapter);
        listaCasas.setItemAnimator(new DefaultItemAnimator());

    }


    private void mudarTela(CasaEntity casa) {
        Intent intent = new Intent(SearchActivity.this, DescriptionActivity.class);
        intent.putExtra("casa", casa);
        startActivity(intent);
    }


}
