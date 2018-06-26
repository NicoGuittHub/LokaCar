package com.example.nguittet2017.lokacar.Vehicule;

import android.net.Uri;

import org.parceler.Parcel;

@Parcel
public class Vehicule {

    public String immatriculation;
    public String marque;
    public String modele;
    public Integer prix;
    public Uri photo;
    public boolean location;

    public Vehicule(){

    };

    public Vehicule(String immatriculation, String marque, String modele, Integer prix) {
        this.immatriculation = immatriculation;
        this.marque = marque;
        this.modele = modele;
        this.prix = prix;
    }

    public Vehicule(String immatriculation, String marque, String modele, Integer prix, Uri photo, boolean location) {
        this.immatriculation = immatriculation;
        this.marque = marque;
        this.modele = modele;
        this.prix = prix;
        this.photo = photo;
        this.location = location;
    }

    public Vehicule(String immatriculation, String marque, String modele, Integer prix, boolean location) {
        this.immatriculation = immatriculation;
        this.marque = marque;
        this.modele = modele;
        this.prix = prix;
        this.location = location;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    public Uri getPhoto() {
        return photo;
    }

    public void setPhoto(Uri photo) {
        this.photo = photo;
    }

    public boolean isLocation() {
        return location;
    }

    public void setLocation(boolean location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Vehicule{" +
                "immatriculation='" + immatriculation + '\'' +
                ", marque='" + marque + '\'' +
                ", modele='" + modele + '\'' +
                ", prix=" + prix +
                ", photo=" + photo +
                ", location=" + location +
                '}';
    }
}
