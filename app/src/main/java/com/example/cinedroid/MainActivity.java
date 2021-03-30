package com.example.cinedroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Console;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lv_listeSeance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv_listeSeance = findViewById(R.id.lv_listeSeances);

        SeanceDAO seanceDAO = new SeanceDAO(this);

        //Récupération des séances contenu dans la base de données
        final ArrayList<Seance> listeSeances = new ArrayList<>(seanceDAO.getSeances());

        //Ajout des Items dans la liste des séances
        lv_listeSeance.setAdapter(new SeanceAdapter(this, listeSeances));

        //Ouverture de l'activité de détail de la séance après un clique sur une séance de la ListeView
        lv_listeSeance.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Seance maSeance = (Seance) adapterView.getItemAtPosition(i);
                Intent intent = new Intent(MainActivity.this, ReserverActivity.class);
                intent.putExtra("nomFilm", maSeance.getNomFilm());
                intent.putExtra("heure", maSeance.getHeure());

                startActivity(intent);
            }
        });


    }
}
