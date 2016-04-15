package com.andre.guia.entity;

import java.io.Serializable;

/**
 * Created by juanjoserodriguez on 8/04/16.
 */
public class CasaEntity implements Serializable{
    private String name;
    private String address;
    private  String tel;
    private String description;
    private int image;


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

    @Override
    public String toString() {
        return "CasaEntity{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                ", description='" + description + '\'' +
                ", image=" + image +
                '}';
    }
}
