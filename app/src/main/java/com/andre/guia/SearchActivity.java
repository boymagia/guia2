package com.andre.guia;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.andre.guia.adapter.CasasAdapter;
import com.andre.guia.entity.CasaEntity;
import com.andre.guia.utils.CasasData;
import com.andre.guia.utils.CustomDialog;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity implements OnMapReadyCallback, CustomDialog.FilterListener {
    // private Button buttonLista;

    private RecyclerView listaCasas;
    private RelativeLayout rvMap;
    private Toolbar toolbar;
    private GoogleMap mMap;
    private Button mapa;
    private Button butonLista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        setUI();
        setToolbar(getString(R.string.app_name));
        setActions();
        setRecyclerView(CasasData.getCasas());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    private void setUI() {
        //buttonLista = (Button) findViewById(R.id.buton_Lista);
        listaCasas = (RecyclerView) findViewById(R.id.lista_casas);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        butonLista = (Button) findViewById(R.id.buton_lista);
        mapa = (Button) findViewById(R.id.buton_mapa);
        rvMap = (RelativeLayout) findViewById(R.id.rv_map);

    }

    private void setToolbar(String name){
        toolbar.setTitle(name);

        setSupportActionBar(toolbar);
    }

    private void setActions(){

        butonLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listaCasas.setVisibility(View.VISIBLE);
                rvMap.setVisibility(View.GONE);
            }
        });

        mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listaCasas.setVisibility(View.GONE);
                rvMap.setVisibility(View.VISIBLE);
            }
        });


    }



    private void setRecyclerView(final List<CasaEntity> casas) {

        listaCasas.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        listaCasas.setLayoutManager(mLayoutManager);

        CasasAdapter mAdapter = new CasasAdapter(casas, SearchActivity.this);
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

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker and move the camera
        LatLng latlng = new LatLng(-25.3814331, -49.2166298);
        mMap.addMarker(new MarkerOptions().position(latlng).title("qualquer texto"));

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(new LatLng(-25.3814331, -49.2166298))      // Sets the center of the map to Mountain View
                .zoom(16)                   // Sets the zoom
                .tilt(45)                   // Sets the tilt of the camera to 30 degrees
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.opt_filter:
                Dialog dialogOk = new CustomDialog().showFilters(SearchActivity.this);
                dialogOk.show();
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }


    @Override
    public void onFiltersSelected(List<String> cidades, List<String> bairros) {

        List<CasaEntity> tmpCasasByCidade = new ArrayList<>();
        List<CasaEntity> tmpCasasByBairro = new ArrayList<>();
        List<CasaEntity> casas = CasasData.getCasas();

        for(String cidade : cidades){
            for(CasaEntity casaTmp : casas){
                if(casaTmp.getCidade().equals(cidade)){
                    tmpCasasByCidade.add(casaTmp);
                }
            }
        }

        for(String bairro :bairros){
            for(CasaEntity casa : tmpCasasByCidade){
                if(casa.getBairro().equals(bairro)){
                    tmpCasasByBairro.add(casa);
                }
            }
        }



        casas = tmpCasasByBairro.size() == 0 ? tmpCasasByCidade :tmpCasasByBairro;

        Log.i("CASAS?", ""+casas.size());

        for(CasaEntity casa: casas){
            Log.i("CASA", casa.getName());
        }

        setRecyclerView(casas);

    }
}
