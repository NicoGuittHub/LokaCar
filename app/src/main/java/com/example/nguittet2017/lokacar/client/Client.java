package com.example.nguittet2017.lokacar.client;

import android.net.Uri;

import org.parceler.Parcel;

//objet client parcelable pour tranfert entre activity

@Parcel
public class Client {

    public String nomClient;
    public String prenomClient;
    public String telephoneClient;
    public String adresseClient;
    public String emailClient;
    public String photoAssuranceClient;
    public String photoPermisClient;


    public Client() {
    }

    public Client(String nomClient, String prenomClient, String telephoneClient,
                  String adresseClient, String emailClient,
                  String photoAssuranceClient, String photoPermisClient) {
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.telephoneClient = telephoneClient;
        this.adresseClient = adresseClient;
        this.emailClient = emailClient;
        this.photoAssuranceClient = photoAssuranceClient;
        this.photoPermisClient = photoPermisClient;
    }

    @Override
    public String toString() {
        return "Client{" +
                "nomClient='" + nomClient + '\'' +
                ", prenomClient='" + prenomClient + '\'' +
                ", telephoneClient='" + telephoneClient + '\'' +
                ", adresseClient='" + adresseClient + '\'' +
                ", emailClient='" + emailClient + '\'' +
                ", photoAssuranceClient='" + photoAssuranceClient + '\'' +
                ", photoPermisClient='" + photoPermisClient + '\'' +
                '}';
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

    public String getPhotoAssuranceClient() {
        return photoAssuranceClient;
    }

    public void setPhotoAssuranceClient(String photoAssuranceClient) {
        this.photoAssuranceClient = photoAssuranceClient;
    }

    public String getPhotoPermisClient() {
        return photoPermisClient;
    }

    public void setPhotoPermisClient(String photoPermisClient) {
        this.photoPermisClient = photoPermisClient;
    }
}
