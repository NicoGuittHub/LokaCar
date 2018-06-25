package com.example.nguittet2017.lokacar.Vehicule;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import com.example.nguittet2017.lokacar.R;

import java.util.ArrayList;
import java.util.List;

public class ListeVehicule extends AppCompatActivity implements RecyclerView.OnItemTouchListener{

    private GestureDetector gestureDetector;
    List<Vehicule> listeVehicules = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_vehicule);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.liste_vehicules);

        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        listeVehicules.add(new Vehicule("Pomme", 45, 2,"lien article", false));


        VehiculeAdapter vehiculeAdapter = new VehiculeAdapter(listeVehicules);
        recyclerView.setAdapter(vehiculeAdapter);

        recyclerView.addOnItemTouchListener(this);

        gestureDetector = new GestureDetector(this,
                new GestureDetector.SimpleOnGestureListener()
                {
                    @Override
                    public boolean onSingleTapUp(MotionEvent event)
                    {
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
                                         MotionEvent motionEvent)
    {
        if (gestureDetector.onTouchEvent(motionEvent))
        {

            View child = recyclerView.findChildViewUnder(motionEvent.getX(),
                    motionEvent.getY());
            if (child != null)
            {
                int position = recyclerView.getChildAdapterPosition(child);
                Log.i("testControle", "clic à la position : " + position);

                Vehicule vehicule = (Vehicule) listeVehicules.get(position);

                Intent intent = new Intent(this, SaisieVehicule.class);
                intent.putExtra(SaisieVehicule.EXTRA_OBJET, Parcels.wrap(vehicule));
                startActivityForResult(intent, 123);;

                return true;
            }
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.action_favori:
                Log.i("menu", "réglages");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



}
