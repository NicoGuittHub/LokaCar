package com.example.nguittet2017.lokacar.client;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.nguittet2017.lokacar.R;

public class ClientViewHolder extends RecyclerView.ViewHolder {
    // TextView intitulé course :
    public TextView textViewNomClient;
    public TextView textViewPrenomClient;
    public TextView textViewEmailClient;

    // Constructeur :
    public ClientViewHolder(View itemView) {
        super(itemView);
        textViewNomClient = itemView.findViewById(R.id.nomClient);
        textViewPrenomClient = itemView.findViewById(R.id.prenomClient);
        textViewEmailClient = itemView.findViewById(R.id.emailClient);
    }
}
