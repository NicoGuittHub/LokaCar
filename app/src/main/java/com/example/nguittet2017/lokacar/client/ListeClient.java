package com.example.nguittet2017.lokacar.client;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.example.nguittet2017.lokacar.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import org.json.JSONObject;
import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

//genere la liste des clients
public class ListeClient extends AppCompatActivity implements RecyclerView.OnItemTouchListener {

    private static final String TAG = "listeClient";

    public GestureDetector gestureDetector;
    public List<Client> listeClients = new ArrayList<>();
    public Client client;
    int position = 0;
    public ClientAdapter clientAdapter;
    public RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_client);

        recyclerView = (RecyclerView) findViewById(R.id.liste_des_clients);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // recherche des clients
        FirebaseFirestore dbClient = FirebaseFirestore.getInstance();

        dbClient.collection("clients")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (DocumentSnapshot document : task.getResult()) {
                                try {
                                    JSONObject jsonObject = new JSONObject(document.getData());
                                    Log.i(TAG, "onComplete: json => " + jsonObject);
                                    client = new Client(jsonObject.getString("nomClient"),
                                            jsonObject.getString("prenomClient"),
                                            jsonObject.getString("telephoneClient"),
                                            jsonObject.getString("adresseClient"),
                                            jsonObject.getString("emailClient"),
                                            jsonObject.getString("photoAssurance"),
                                            jsonObject.getString("photopermis"));


                                    listeClients.add(client);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                clientAdapter = new ClientAdapter(listeClients);
                                recyclerView.setAdapter(clientAdapter);

                                recyclerView.addOnItemTouchListener(ListeClient.this);


                            }
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });

        gestureDetector = new GestureDetector(this,
                new GestureDetector.SimpleOnGestureListener() {
                    @Override
                    public boolean onSingleTapUp(MotionEvent event) {
                        return true;
                    }
                });
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView recyclerView,
                                         MotionEvent motionEvent) {
        if (gestureDetector.onTouchEvent(motionEvent)) {

            View child = recyclerView.findChildViewUnder(motionEvent.getX(),
                    motionEvent.getY());
            if (child != null) {
                position = recyclerView.getChildAdapterPosition(child);
                Client client = (Client) listeClients.get(position);

                Intent intent = new Intent(this, DetailClient.class);
                intent.putExtra(DetailClient.EXTRA_OBJET, Parcels.wrap(client));
                intent.putExtra(DetailClient.EXTRA_POSITION, position);
                startActivityForResult(intent, 123);

                return true;
            }
        }
        return false;
    }

    public void clientSuivant(View view) {
        Log.i(TAG, "clientSuivant: position => " + position);

        position = position + 1;

        client = (Client) listeClients.get(position);

        Intent intent = new Intent(this, DetailClient.class);
        intent.putExtra(DetailClient.EXTRA_OBJET, Parcels.wrap(client));
        startActivityForResult(intent, 123);
    }
}
