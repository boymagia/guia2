package com.andre.guia.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.andre.guia.R;
import com.andre.guia.entity.CasaEntity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CasasAdapter extends RecyclerView.Adapter<CasasAdapter.ViewHolder> implements View.OnClickListener{


    private List<CasaEntity> casas;
    private View.OnClickListener listener;
    private Context context;

    public CasasAdapter(List<CasaEntity> casas, Context context){
        this.casas = casas;
        this.context = context;

    }
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imagen1;
        public TextView textName;
        public TextView textEndereco;

        public ViewHolder(View v) {
            super(v);
            imagen1 = (ImageView)v.findViewById(R.id.image1);
            textName = (TextView)v.findViewById(R.id.text_name);
            textEndereco = (TextView)v.findViewById(R.id.text_endereco);
        }

    }


    @Override
    public CasasAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_casa, parent, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Picasso.with(this.context).load(casas.get(position).getImage())
                .placeholder(R.drawable.logo)
                .error(R.drawable.logo)
                .resize(256, 256)
                .centerCrop()
                .into(holder.imagen1);

        holder.textName.setText(casas.get(position).getName());
        holder.textEndereco.setText(casas.get(position).getAddress());

    }


    @Override
    public int getItemCount() {
        return casas.size();
    }


    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if(listener != null)
            listener.onClick(v);
    }






}
