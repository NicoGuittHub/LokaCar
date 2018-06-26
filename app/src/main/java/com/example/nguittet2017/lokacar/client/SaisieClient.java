package com.example.nguittet2017.lokacar.client;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nguittet2017.lokacar.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SaisieClient extends AppCompatActivity {

    private static final String TAG = "kcc_ajout_client";
    private static final String ASSUR = "ASSUR_";
    private static final String PERMIS = "PERMIS_";
    String mCurrentPhotoPathPhoto;
    String mCurrentPhotoPathAssurance;
    static final int REQUEST_TAKE_PHOTO_PERMIS = 1;
    static final int REQUEST_TAKE_PHOTO_ASSURANCE = 2;
    Button buttonPermis;
    Button buttonAssurance;
    Button buttonValide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saisie_client);

        // active les boutons
        buttonPermis = findViewById(R.id.saisiePermis);
        buttonPermis.setEnabled(true);
        buttonPermis.setOnClickListener(mCorkyListener);

        buttonAssurance = findViewById(R.id.saisieAssurance);
        buttonAssurance.setEnabled(true);
        buttonAssurance.setOnClickListener(mCorkyListener);

        buttonValide = findViewById(R.id.valid);
        buttonValide.setEnabled(false);
        buttonValide.setOnClickListener(mCorkyListener);

        Log.i(TAG, "onCreate: debut");


    }

    public void valideClient(View view) {
        // si il n'existe pas de photo pemis et assurances impossible de créer le conducteur.

        FirebaseFirestore dbClient = FirebaseFirestore.getInstance();

        final TextView textViewNom = findViewById(R.id.editNom);
        TextView textViewPrenom = findViewById(R.id.editPrenom);
        TextView textViewAdresse = findViewById(R.id.editAdresse);
        TextView textViewTelephone = findViewById(R.id.editTelephone);
        TextView textViewEmail = findViewById(R.id.editEmail);

        final String email = textViewEmail.getText().toString();
        // On déclare le pattern que l’on doit vérifier
        Pattern p1 = Pattern.compile(".+@.+\\.[a-z]+");
        // On déclare un matcher, qui comparera le pattern avec la
        // string passée en argument
        Matcher m1 = p1.matcher(email);
        // Si l’adresse mail saisie ne correspond au format d’une
        // adresse mail on un affiche un message à l'utilisateur
        final String telephone = textViewTelephone.getText().toString();
        Pattern p2 = Pattern.compile("[0-9]{10}");
        Matcher m2 = p2.matcher(telephone);



        if (textViewNom.getText().toString().matches("")) {
            Toast.makeText(SaisieClient.this, "le nom n'est pas rempli"
                    , Toast.LENGTH_LONG).show();
        } else if (textViewPrenom.getText().toString().matches("")) {
            Toast.makeText(SaisieClient.this, "le prenom n'est pas rempli"
                    , Toast.LENGTH_LONG).show();
        } else if (textViewAdresse.getText().toString().matches("")) {
            Toast.makeText(SaisieClient.this, "l'adresse n'est pas remplie"
                    , Toast.LENGTH_LONG).show();
        } else if (textViewTelephone.getText().toString().matches("")) {
            Toast.makeText(SaisieClient.this, "le téléphone n'est rempli"
                    , Toast.LENGTH_LONG).show();
        }else if (!m2.matches()){
            Toast.makeText(SaisieClient.this, "le téléphone doit contenir 10 chiffres"
                    , Toast.LENGTH_LONG).show();

        } else if (textViewEmail.getText().toString().matches("") ){
            Toast.makeText(SaisieClient.this, "l'émail n'est pas rempli "
                    , Toast.LENGTH_LONG).show();
        } else if (!m1.matches() ){
            Toast.makeText(SaisieClient.this, "l'émail n'est pas correct "
                    , Toast.LENGTH_LONG).show();
        } else {
            final Map<String, Object> client = new HashMap<>();
            client.put("nomClient", textViewNom.getText().toString());
            client.put("prenomClient", textViewPrenom.getText().toString());
            client.put("adresseClient", textViewAdresse.getText().toString());
            client.put("telephoneClient", textViewTelephone.getText().toString());
            client.put("emailClient", textViewEmail.getText().toString());
            client.put("photopermis", mCurrentPhotoPathPhoto);
            client.put("photoAssurance", mCurrentPhotoPathAssurance);


            dbClient.collection("clients")
                    .add(client)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Toast.makeText(SaisieClient.this, "le client : "
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
            finish();
        }
    }

    private File createImageFile(String photo, boolean isPhoto) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = photo + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        if (!isPhoto) {
            mCurrentPhotoPathPhoto = image.getAbsolutePath();
        } else {
            mCurrentPhotoPathAssurance = image.getAbsolutePath();
        }
        return image;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_TAKE_PHOTO_PERMIS && resultCode == RESULT_OK) {
            buttonPermis.setEnabled(false);
            Log.i(TAG, "onActivityResult: photo");
            if (!buttonAssurance.isEnabled() && !buttonPermis.isEnabled()) {
                buttonValide.setEnabled(true);
            }

        }
        if (requestCode == REQUEST_TAKE_PHOTO_ASSURANCE && resultCode == RESULT_OK) {
            buttonAssurance.setEnabled(false);
            Log.i(TAG, "onActivityResult: assurance");
            if (!buttonAssurance.isEnabled() && !buttonPermis.isEnabled()) {
                buttonValide.setEnabled(true);
            }
        }


    }

    private View.OnClickListener mCorkyListener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            String photo = "";
            File photoFile = null;
            boolean isAssur = view.getId() == R.id.saisieAssurance;
            boolean isPermis = view.getId() == R.id.saisiePermis;
            boolean isValid = view.getId() == R.id.valid;

            Log.i(TAG, "onClick: ");
            if (isAssur || isPermis) {
                Log.i(TAG, "onClick: assur" + isAssur);
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {

                    try {
                        photoFile = createImageFile(isAssur ? ASSUR : PERMIS, isAssur);
                    } catch (IOException ex) {

                    }

                    if (photoFile != null) {
                        Uri photoURI = FileProvider.getUriForFile(SaisieClient.this,
                                "com.example.nguittet2017.lokacar",
                                photoFile);
                        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                        startActivityForResult(takePictureIntent, isAssur ? REQUEST_TAKE_PHOTO_ASSURANCE : REQUEST_TAKE_PHOTO_PERMIS);
                    }
                }
            } else if (isValid) {
                Log.i(TAG, "onClick: valid");
                valideClient(view);
            }

        }
    };

}
