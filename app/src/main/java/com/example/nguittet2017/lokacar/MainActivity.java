package com.example.nguittet2017.lokacar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.nguittet2017.lokacar.client.ListeClient;
import com.example.nguittet2017.lokacar.client.SaisieClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void saisieClient(View view) {
        Intent intent = new Intent(this, SaisieClient.class);
        startActivity(intent);

    }

    public void listeClient(View view) {

        Intent intent = new Intent(this, ListeClient.class);
        startActivity(intent);

    }
}
