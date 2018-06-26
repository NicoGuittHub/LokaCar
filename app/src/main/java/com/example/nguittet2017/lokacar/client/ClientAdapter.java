package com.example.nguittet2017.lokacar.client;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nguittet2017.lokacar.R;

import java.util.List;

//permet la liaison entre la liste des clients et l'affichage

public class ClientAdapter extends RecyclerView.Adapter<ClientViewHolder> {
    // Liste d'objets métier :
    private List<Client> listeClients;

    // Constructeur :
    public ClientAdapter(List<Client> listeClients) {
        this.listeClients = listeClients;
    }

    //crée la vue d'un client
    @Override
    public ClientViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewClient = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.liste_des_clients, parent, false);
        return new ClientViewHolder(viewClient);
    }

    // met les données dans les cases
    @Override
    public void onBindViewHolder(ClientViewHolder holder, int position) {
        holder.textViewNomClient.setText(listeClients.get(position).getNomClient());
        holder.textViewPrenomClient.setText(listeClients.get(position).getPrenomClient());
        holder.textViewEmailClient.setText(listeClients.get(position).getEmailClient());

    }

    //compte le nombre de client
    @Override
    public int getItemCount() {

        return listeClients.size();
    }
}