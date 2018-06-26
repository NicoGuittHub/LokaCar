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
        textViewVehiculeImmatriculation = itemView.findViewById(R.id.textViewVehiculeImmatriculation);
        textViewVehiculeMarque = itemView.findViewById(R.id.textViewVehiculeMarque);
        textViewVehiculeModele = itemView.findViewById(R.id.textViewVehiculeModele);
        textViewVehiculePrix = itemView.findViewById(R.id.textViewVehiculePrix);
        //textViewVehiculeLocation = itemView.findViewById(R.id.location);
    }


}
