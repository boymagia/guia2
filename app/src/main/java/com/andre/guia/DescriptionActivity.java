package com.andre.guia;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.andre.guia.entity.CasaEntity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class DescriptionActivity extends AppCompatActivity implements OnMapReadyCallback {

    private CasaEntity casa;
    private TextView endereco;
    private TextView telefone;
    private TextView descricao;
    private Button ligar;
    private Toolbar toolbar;

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        casa = (CasaEntity) getIntent().getSerializableExtra("casa");
        setUI();
        setToolbar(casa.getName());
        setInfo();

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    private void setUI() {
        endereco = (TextView) findViewById(R.id.edereco);
        telefone = (TextView) findViewById(R.id.telefone);
        descricao = (TextView) findViewById(R.id.descricao);
        ligar = (Button) findViewById(R.id.ligar);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    private void setToolbar(String name){
        toolbar.setTitle(name);
        setSupportActionBar(toolbar);
    }
    private void setInfo() {

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
        LatLng latlng = new LatLng(casa.getLat(), casa.getLng());
        mMap.addMarker(new MarkerOptions().position(latlng).title(casa.getName()));

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(new LatLng(casa.getLat(), casa.getLng()))      // Sets the center of the map to Mountain View
                .zoom(16)                   // Sets the zoom
                .tilt(45)                   // Sets the tilt of the camera to 30 degrees
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }

}
