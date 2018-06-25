package com.example.nguittet2017.lokacar.Vehicule;

import android.net.Uri;

public class Vehicule {

    private String immatriculation;
    private String marque;
    private String modele;
    private double prix;
    private Uri photo;
    private boolean location;

    public Vehicule(){

    };

    public Vehicule(String immatriculation, String marque, String modele, double prix, Uri photo, boolean location) {
        this.immatriculation = immatriculation;
        this.marque = marque;
        this.modele = modele;
        this.prix = prix;
        this.photo = photo;
        this.location = location;
    }

    public Vehicule(String immatriculation, String marque, String modele, double prix, boolean location) {
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

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
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
