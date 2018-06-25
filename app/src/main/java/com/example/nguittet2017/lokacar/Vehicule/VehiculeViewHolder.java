package com.example.nguittet2017.lokacar.Vehicule;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.nguittet2017.lokacar.R;

public class VehiculeViewHolder extends RecyclerView.ViewHolder{


    public TextView textViewVehiculeImmatriculation;
    public TextView textViewVehiculeMarque;
    public TextView textViewVehiculeModele;
    public TextView textViewVehiculePrix;
    public TextView textViewVehiculeLocation;
    // Constructeur :
    public VehiculeViewHolder(View itemView)
    {
        super(itemView);
        textViewVehiculeImmatriculation = itemView.findViewById(R.id.immatriculation);
        textViewVehiculeMarque = itemView.findViewById(R.id.marque);
        textViewVehiculeModele = itemView.findViewById(R.id.modele);
        textViewVehiculePrix = itemView.findViewById(R.id.prix);
        textViewVehiculeLocation = itemView.findViewById(R.id.location);
    }


}
