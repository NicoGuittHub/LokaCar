package com.example.nguittet2017.lokacar.client;

import android.net.Uri;

public class Client {

    private String nomClient;
    private String prenomClient;
    private int telephoneClient;
    private String adresseClient;
    private String emailClient;
    private Uri carteIdentiteClient;
    private Uri permisClient;

    public Client() {
    }

    public Client(String nomClient, String prenomClient, int telephoneClient, String adresseClient, String emailClient, Uri carteIdentiteClient, Uri permisClient) {
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.telephoneClient = telephoneClient;
        this.adresseClient = adresseClient;
        this.emailClient = emailClient;
        this.carteIdentiteClient = carteIdentiteClient;
        this.permisClient = permisClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    public int getTelephoneClient() {
        return telephoneClient;
    }

    public void setTelephoneClient(int telephoneClient) {
        this.telephoneClient = telephoneClient;
    }

    public String getAdresseClient() {
        return adresseClient;
    }

    public void setAdresseClient(String adresseClient) {
        this.adresseClient = adresseClient;
    }

    public String getEmailClient() {
        return emailClient;
    }

    public void setEmailClient(String emailClient) {
        this.emailClient = emailClient;
    }

    public Uri getCarteIdentiteClient() {
        return carteIdentiteClient;
    }

    public void setCarteIdentiteClient(Uri carteIdentiteClient) {
        this.carteIdentiteClient = carteIdentiteClient;
    }

    public Uri getPermisClient() {
        return permisClient;
    }

    public void setPermisClient(Uri permisClient) {
        this.permisClient = permisClient;
    }
}
