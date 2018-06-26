package com.example.nguittet2017.lokacar.Vehicule;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
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

public class ListeVehicule extends AppCompatActivity implements RecyclerView.OnItemTouchListener{

    private static final String TAG = "kccImportbdd";

    public GestureDetector gestureDetector;
    public List<Vehicule> listeVehicules = new ArrayList<>();
    public Vehicule vehicule;
    int position = 0;
    public VehiculeAdapter vehiculeAdapter;
    public RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_vehicule);
        Log.i(TAG, "onCreate: ");

        recyclerView = (RecyclerView) findViewById(R.id.liste_vehicules);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // recherche des vehicules
        FirebaseFirestore dbVehicule = FirebaseFirestore.getInstance();

        dbVehicule.collection("vehicules")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (DocumentSnapshot document : task.getResult()) {
                                try {
                                    JSONObject jsonObject = new JSONObject(document.getData());
                                    vehicule = new Vehicule(jsonObject.getString("immatriculation"),
                                            jsonObject.getString("marque"),
                                            jsonObject.getString("modele"),
                                            jsonObject.getInt("prix"));
                                            //jsonObject.getBoolean("location"));
                                    Log.i(TAG, "onComplete: vehicule => " + vehicule.toString());
                                    listeVehicules.add(vehicule);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                Log.i(TAG, "onCreate: listeVehicules => " + listeVehicules.toString());
                                vehiculeAdapter = new VehiculeAdapter(listeVehicules);
                                recyclerView.setAdapter(vehiculeAdapter);

                                recyclerView.addOnItemTouchListener(ListeVehicule.this);


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
                Vehicule vehicule = (Vehicule) listeVehicules.get(position);

                Intent intent = new Intent(this, VehiculeDetail.class);
                intent.putExtra(VehiculeDetail.EXTRA_OBJET, Parcels.wrap(vehicule));
                intent.putExtra(VehiculeDetail.EXTRA_POSITION, position);
                startActivityForResult(intent, 123);


                return true;
            }
        }
        return false;
    }

}
