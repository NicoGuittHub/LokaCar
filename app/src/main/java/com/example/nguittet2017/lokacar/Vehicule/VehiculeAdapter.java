package com.example.nguittet2017.lokacar.Vehicule;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nguittet2017.lokacar.R;

import java.util.List;

public class VehiculeAdapter extends RecyclerView.Adapter<VehiculeViewHolder>{


    private List<Vehicule> listeVehicules;

    // Constructeur :
    public VehiculeAdapter(List<Vehicule> listeVehicules) {
        this.listeVehicules = listeVehicules;
    }

    @Override
    public VehiculeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewVehicule = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_liste_vehicule, parent, false);
        return new VehiculeViewHolder(viewVehicule);
    }

    @Override
    public void onBindViewHolder(VehiculeViewHolder holder, int position) {
        holder.textViewVehiculeImmatriculation.setText(listeVehicules.get(position).immatriculation);
        holder.textViewVehiculeMarque.setText(listeVehicules.get(position).marque);
        holder.textViewVehiculeModele.setText(listeVehicules.get(position).modele);
        holder.textViewVehiculePrix.setText(Integer.toString(listeVehicules.get(position).prix));


        holder.textViewVehiculeLocation.setText("");
        if (listeVehicules.get(position).location){
            holder.textViewVehiculeLocation.setText("loué");
        }

    }

    @Override
    public int getItemCount() {

        return listeVehicules.size();
    }

}
