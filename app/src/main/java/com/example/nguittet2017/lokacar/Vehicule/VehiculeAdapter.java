package com.example.nguittet2017.lokacar.Vehicule;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nguittet2017.lokacar.R;

import java.util.List;

public class VehiculeAdapter extends RecyclerView.Adapter<VehiculeViewHolder>{



    // Liste d'objets métier :
    private List<Vehicule> listeVehicules;
    // Constructeur :
    public VehiculeAdapter(List<Vehicule> listeVehicules)
    {
        this.listeVehicules = listeVehicules;
    }

    @Override
    public VehiculeViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View viewTruc = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_liste_vehicule, parent, false);
        return new VehiculeViewHolder(viewVehicule);
    }


}
