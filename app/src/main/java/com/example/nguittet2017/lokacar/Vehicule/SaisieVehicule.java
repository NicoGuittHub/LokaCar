package com.example.nguittet2017.lokacar.Vehicule;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.nguittet2017.lokacar.R;
import com.example.nguittet2017.lokacar.client.SaisieClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SaisieVehicule extends AppCompatActivity {



    private static final String TAG = "ajout_vehicule";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saisie_vehicule);

    }

    public void valideVehicule(View view) {
        FirebaseFirestore dbVehicule = FirebaseFirestore.getInstance();

        final TextView textViewImmatriculation = findViewById(R.id.immatriculation);
        TextView textViewMarque = findViewById(R.id.marque);
        TextView textViewModele = findViewById(R.id.modele);
        TextView textViewPrix = findViewById(R.id.prix);
        TextView textViewLocation = findViewById(R.id.location);

        final Map<String, Object> vehicule = new HashMap<>();
        vehicule.put("immatriculation", textViewImmatriculation.getText().toString());
        vehicule.put("marque", textViewMarque.getText().toString());
        vehicule.put("modele", textViewModele.getText().toString());
        vehicule.put("prix", textViewPrix.getText().toString());
        vehicule.put("location",textViewLocation.getText().toString());
        dbVehicule.collection("vehicules")
                .add(vehicule)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.i(TAG, "onSuccess: ");
                        Toast.makeText(SaisieVehicule.this, "le véhicule immatriculé : "
                                        + textViewImmatriculation.getText().toString() + " a bien été ajouté."
                                , Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "erreur ajout véhicule", e);
                    }
                });



    }


}