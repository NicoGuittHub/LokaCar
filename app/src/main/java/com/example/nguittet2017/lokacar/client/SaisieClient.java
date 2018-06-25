package com.example.nguittet2017.lokacar.client;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nguittet2017.lokacar.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SaisieClient extends AppCompatActivity {

    private static final String TAG = "ajout_client";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saisie_client);

    }

    public void valideClient(View view) {
        FirebaseFirestore dbClient = FirebaseFirestore.getInstance();

        final TextView textViewNom = findViewById(R.id.editNom);
        TextView textViewPrenom = findViewById(R.id.editPrenom);
        TextView textViewAdresse = findViewById(R.id.editAdresse);
        TextView textViewTelephone = findViewById(R.id.editTelephone);
        TextView textViewEmail = findViewById(R.id.editEmail);

        final Map<String, Object> client = new HashMap<>();
        client.put("nomClient", textViewNom.getText().toString());
        client.put("prenomClient", textViewPrenom.getText().toString());
        client.put("adresseClient", textViewAdresse.getText().toString());
        client.put("telephoneClient", textViewTelephone.getText().toString());
        client.put("emailClient", textViewEmail.getText().toString());

        dbClient.collection("clients")
                .add(client)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.i(TAG, "onSuccess: " );
                        Toast.makeText(SaisieClient.this,"le client : "
                                + textViewNom.getText().toString() + " a bien été ajouté."
                                , Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "erreur d'intégration client", e);
                    }
                });



    }
}
