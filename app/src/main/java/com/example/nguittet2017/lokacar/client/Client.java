package com.example.nguittet2017.lokacar.client;

import android.net.Uri;

import org.parceler.Parcel;

@Parcel
public class Client {

    public String nomClient;
    public String prenomClient;
    public String telephoneClient;
    public String adresseClient;
    public String emailClient;
    public Uri carteIdentiteClient;
    public Uri permisClient;

    public Client() {
    }

    public Client(String nomClient, String prenomClient, String telephoneClient, String adresseClient, String emailClient) {
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.telephoneClient = telephoneClient;
        this.adresseClient = adresseClient;
        this.emailClient = emailClient;
    }

    public Client(String nomClient, String prenomClient, String telephoneClient, String adresseClient, String emailClient, Uri carteIdentiteClient, Uri permisClient) {
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

    public String getTelephoneClient() {
        return telephoneClient;
    }

    public void setTelephoneClient(String telephoneClient) {
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

    @Override
    public String toString() {
        return "Client{" +
                "nomClient='" + nomClient + '\'' +
                ", prenomClient='" + prenomClient + '\'' +
                ", telephoneClient='" + telephoneClient + '\'' +
                ", adresseClient='" + adresseClient + '\'' +
                ", emailClient='" + emailClient + '\'' +
                '}';
    }
}
