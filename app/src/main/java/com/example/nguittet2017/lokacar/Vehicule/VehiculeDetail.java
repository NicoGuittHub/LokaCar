package com.example.nguittet2017.lokacar.Vehicule;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.nguittet2017.lokacar.R;

import org.parceler.Parcels;


public class VehiculeDetail extends AppCompatActivity {

    public static final String EXTRA_OBJET = "Vehicule";
    public static final String EXTRA_POSITION = "Position";
    public int position = 0;
    public Vehicule vehicule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_vehicule);

        vehicule = Parcels.unwrap(getIntent().getParcelableExtra(EXTRA_OBJET));

        TextView textViewDetailImmat = findViewById(R.id.textViewDetailImmatriculation);
        TextView textViewDetailMa = findViewById(R.id.textViewDetailMarque);
        TextView textViewDetailMo = findViewById(R.id.textViewDetailModel);
        TextView textViewDetailPx = findViewById(R.id.textViewDetailPrix);
        TextView textViewDetailLoc = findViewById(R.id.textViewDetailLocation);

        textViewDetailImmat.setText(vehicule.getImmatriculation());
        textViewDetailMa.setText(vehicule.getMarque());
        textViewDetailMo.setText(vehicule.getModele());
        textViewDetailPx.setText(vehicule.getPrix());
        //textViewDetailLoc.setText(vehicule.getLocation);

    }

}
