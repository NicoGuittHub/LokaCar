package com.example.nguittet2017.lokacar.client;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nguittet2017.lokacar.R;

import org.parceler.Parcels;

// crée une vue en détail d'un client.
public class DetailClient extends AppCompatActivity {

    public static final String EXTRA_OBJET = "Client";
    public static final String EXTRA_POSITION = "Position";
    public int position = 0;
    public Client client;

    private static final String TAG = "kcc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_client);

        // récupere le client a partir d'un clic sur le client dans la liste
        client = Parcels.unwrap(
                getIntent().getParcelableExtra(EXTRA_OBJET));

        TextView textViewdetailNomClientTrouve = findViewById(R.id.detailNomClientTrouve);
        TextView textViewdetailPrenomClientTrouve = findViewById(R.id.detailPrenomClientTrouve);
        TextView textViewdetailAdresseClientTrouve = findViewById(R.id.detailAdresseClientTrouve);
        TextView textViewdetailTelephoneClientTrouve = findViewById(R.id.detailTelephoneClientTrouve);
        TextView textViewdetailEmailClientTrouve = findViewById(R.id.detailEmailClientTrouve);
        ImageView imageViewAssurance = findViewById(R.id.imageAssurance);
        ImageView imageViewPermis = findViewById(R.id.imagePermis);

        textViewdetailNomClientTrouve.setText(client.getNomClient());
        textViewdetailPrenomClientTrouve.setText(client.getPrenomClient());
        textViewdetailAdresseClientTrouve.setText(client.getAdresseClient());
        textViewdetailTelephoneClientTrouve.setText(client.getTelephoneClient());
        textViewdetailEmailClientTrouve.setText(client.getEmailClient());

        Bitmap imagePermis = BitmapFactory.decodeFile(client.photoPermisClient);
        imageViewPermis.setImageBitmap(imagePermis);

        Bitmap imageAssurance = BitmapFactory.decodeFile(client.photoAssuranceClient);
        imageViewAssurance.setImageBitmap(imageAssurance);

    }


}


