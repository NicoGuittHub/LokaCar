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

public class SaisieClientFinal extends AppCompatActivity {

    private static final String TAG = "kcc_ajout_client";
    String mCurrentPhotoPathPhoto;
    String mCurrentPhotoPathAssurance;
    static final int REQUEST_TAKE_PHOTO_PERMIS = 1;
    static final int REQUEST_TAKE_PHOTO_ASSURANCE = 2;
    Button buttonPermis;
    Button buttonAssurance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saisie_client);

        // active les boutons
        buttonPermis = findViewById(R.id.saisiePermis);
        buttonPermis.setEnabled(true);

        buttonAssurance = findViewById(R.id.saisieAssurance);
        buttonAssurance.setEnabled(true);
    }

    public void valideClient(View view) {
        // si il n'existe pas de photo pemis et assurances impossible de créer le conducteur.
        if (!buttonPermis.isEnabled() && !buttonAssurance.isEnabled()) {

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
            client.put("photopermis", mCurrentPhotoPathPhoto);
            client.put("photoAssurance", mCurrentPhotoPathAssurance);


            dbClient.collection("clients")
                    .add(client)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Toast.makeText(SaisieClientFinal.this, "le client : "
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
        } else {
            Toast.makeText(SaisieClientFinal.this, "Vous n'avez pas saisi le permis du conducteur ou l'assurance ! "
                    , Toast.LENGTH_LONG).show();
        }
    }

    //permet la prise des photos
    public void saisiePermis(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {

            File photoFile = null;
            try {
                photoFile = createImageFilePhoto();
            } catch (IOException ex) {

            }

            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        "com.example.nguittet2017.lokacar",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO_PERMIS);
            }
        }
    }
    public void saisieAssurance(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {

            File photoFile = null;
            try {
                photoFile = createImageFileAssurance();
            } catch (IOException ex) {

            }

            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        "com.example.nguittet2017.lokacar",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO_ASSURANCE);
            }
        }
    }

    private File createImageFilePhoto() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "PERMIS_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );
        mCurrentPhotoPathPhoto = image.getAbsolutePath();
        return image;
    }

    private File createImageFileAssurance() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "ASSURANCE_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );
        mCurrentPhotoPathAssurance = image.getAbsolutePath();
        return image;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_TAKE_PHOTO_PERMIS && resultCode == RESULT_OK) {
            buttonPermis.setEnabled(false);
            Log.i(TAG, "onActivityResult: photo");
        }
        if (requestCode == REQUEST_TAKE_PHOTO_ASSURANCE && resultCode == RESULT_OK) {
            buttonAssurance.setEnabled(false);
            Log.i(TAG, "onActivityResult: assurance");
        }

    }


}
