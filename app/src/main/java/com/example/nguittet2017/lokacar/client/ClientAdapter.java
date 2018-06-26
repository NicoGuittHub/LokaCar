package com.example.nguittet2017.lokacar.client;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nguittet2017.lokacar.R;

import java.util.List;

public class ClientAdapter extends RecyclerView.Adapter<ClientViewHolder> {
    // Liste d'objets métier :
    private List<Client> listeClients;

    // Constructeur :
    public ClientAdapter(List<Client> listeClients) {
        this.listeClients = listeClients;
    }

    @Override
    public ClientViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewTruc = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.liste_des_clients, parent, false);
        return new ClientViewHolder(viewTruc);
    }

    @Override
    public void onBindViewHolder(ClientViewHolder holder, int position) {
        holder.textViewNomClient.setText(listeClients.get(position).getNomClient());
        holder.textViewPrenomClient.setText(listeClients.get(position).getPrenomClient());
        holder.textViewEmailClient.setText(listeClients.get(position).getEmailClient());

    }

    @Override
    public int getItemCount() {

        return listeClients.size();
    }
}