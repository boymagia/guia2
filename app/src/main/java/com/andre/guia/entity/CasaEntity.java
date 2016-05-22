package com.andre.guia.entity;

import java.io.Serializable;

public class CasaEntity implements Serializable{
    private String name;
    private String address;
    private  String tel;
    private String description;
    private String bairro;
    private String cidade;
    private int image;
    private double lat;
    private double lng;


    public String getCidade() {return cidade;}

    public void setCidade(String cidade) {this.cidade = cidade;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getBairro() {return bairro;}

    public void setBairro(String bairro) {this.bairro = bairro;}

    @Override
    public String toString() {
        return "CasaEntity{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                ", description='" + description + '\'' +
                ", image=" + image +
                ", lat=" + lat +
                ", lng=" + lng +
                '}';
    }
}
