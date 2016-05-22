package com.andre.guia.utils;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.andre.guia.R;

import java.util.ArrayList;
import java.util.List;

public class CustomDialog {


    private List<String> cidades;
    private List<String> bairros;

    private Dialog dialog;
    private FilterListener mListenerFilters;

    public Dialog showFilters(final Context context) {

        cidades = new ArrayList<>();
        bairros = new ArrayList<>();

        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View view = View.inflate(context, R.layout.layout_filter, null);

        final CheckBox cbCuritiba = (CheckBox)  view.findViewById(R.id.cb_curitiba);
        final CheckBox lapa = (CheckBox)  view.findViewById(R.id.lapa);
        final CheckBox maringa = (CheckBox)  view.findViewById(R.id.maringa);
        final CheckBox piraquara = (CheckBox)  view.findViewById(R.id.piraquara);
        final CheckBox antonina = (CheckBox)  view.findViewById(R.id.antonina);
        final CheckBox campoLargo = (CheckBox)  view.findViewById(R.id.campo_largo);

        final CheckBox boaVista = (CheckBox)  view.findViewById(R.id.boa_vista);
        final CheckBox bairroAlto = (CheckBox)  view.findViewById(R.id.bairro_alto);
        final CheckBox atuba = (CheckBox)  view.findViewById(R.id.atuba);
        final CheckBox rondinha = (CheckBox)  view.findViewById(R.id.rondinha);
        final CheckBox marafigo = (CheckBox)  view.findViewById(R.id.marafigo);
        final CheckBox vilaSantiago = (CheckBox)  view.findViewById(R.id.vila_santiago);
        final CheckBox pinheirinho = (CheckBox)  view.findViewById(R.id.pinheirinho);
        final CheckBox novoMundo = (CheckBox)  view.findViewById(R.id.novo_mundo);
        final CheckBox capadaImbuia = (CheckBox)  view.findViewById(R.id.capa_daimbuia);
        final CheckBox merces = (CheckBox)  view.findViewById(R.id.merces);
        final CheckBox xaxim = (CheckBox)  view.findViewById(R.id.xaxim);
        final CheckBox jardimDasAmericas = (CheckBox)  view.findViewById(R.id.jardim_dasamericas);
        final CheckBox centro = (CheckBox)  view.findViewById(R.id.centro);
        final CheckBox ahu = (CheckBox)  view.findViewById(R.id.ahu);
        final CheckBox batel = (CheckBox)  view.findViewById(R.id.batel);
        final CheckBox vilaJuliana = (CheckBox)  view.findViewById(R.id.vila_juliana);

        Button bFiltrar = (Button) view.findViewById(R.id.b_filtrar);

        bFiltrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(cbCuritiba.isChecked()){
                    cidades.add("curitiba");
                }

                if(lapa.isChecked()){
                    cidades.add("lapa");

                }

                if (maringa.isChecked()){
                    cidades.add("maringa");
                }

                if (piraquara.isChecked()){
                    cidades.add("piraquara");
                }

                if (antonina.isChecked()){
                    cidades.add("antonina");
                }

                if (campoLargo.isChecked()){
                    cidades.add("campo-largo");
                }

                if (boaVista.isChecked()){
                    bairros.add("boa-vista");
                }

                if (bairroAlto.isChecked()){
                    bairros.add("bairroAlto");
                }
                if (atuba.isChecked()){
                    bairros.add("atuba");
                }
                if (rondinha.isChecked()){
                    bairros.add("rondinha");
                }
                if (marafigo.isChecked()){
                    bairros.add("marfigo");
                }
                if (vilaSantiago.isChecked()){
                    bairros.add("vila-sam-tiago");
                }
                if (pinheirinho.isChecked()){
                    bairros.add("pineirinho");
                }
                if (novoMundo.isChecked()){
                    bairros.add("novo-mundo");
                }
                if (capadaImbuia.isChecked()){
                    bairros.add("capao-da-imbuia");
                }
                if (merces.isChecked()){
                    bairros.add("merces");
                }
                if (xaxim.isChecked()){
                    bairros.add("xaxim");
                }
                if (jardimDasAmericas.isChecked()){
                    bairros.add("jardim-das-americas");
                }
                if (centro.isChecked()){
                    bairros.add("centro");
                }
                if (ahu.isChecked()){
                    bairros.add("ahu");
                }
                if (batel.isChecked()){
                    bairros.add("batel");
                }
                if (vilaJuliana.isChecked()){
                    bairros.add("vilajuliana");
                }

                mListenerFilters = (FilterListener) context;
                mListenerFilters.onFiltersSelected(cidades, bairros);
                dialog.dismiss();
            }
        });


        builder.setView(view);
        dialog = builder.create();

        return dialog;
    }

    public interface FilterListener {
        void onFiltersSelected(List<String> cidades, List<String> bairros);
    }


}
