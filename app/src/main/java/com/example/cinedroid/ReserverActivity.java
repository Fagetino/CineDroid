package com.example.cinedroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ReserverActivity extends AppCompatActivity {
    private TextView tv_titre;
    private TextView tv_heure;
    private TextView tv_nbPlacesNormal;
    private TextView tv_nbPlacesEtudiant;
    private TextView tv_nbPlacesJeune;
    private Button b_plusNormal;
    private Button b_plusEtudiant;
    private Button b_plusJeune;
    private Button b_moinsNormal;
    private Button b_moinsEtudiant;
    private Button b_moinsJeune;
    private Button b_reserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserver);

        Intent intent = getIntent();

        //Récupération des views
        tv_titre = findViewById(R.id.tv_titre);
        tv_heure = findViewById(R.id.tv_heure);
        tv_nbPlacesNormal = findViewById(R.id.tv_nbPlacesNormal);
        tv_nbPlacesEtudiant = findViewById(R.id.tv_nbPlacesEtudiant);
        tv_nbPlacesJeune = findViewById(R.id.tv_nbPlacesJeune);
        b_plusNormal = findViewById(R.id.b_plusNormal);
        b_plusEtudiant = findViewById(R.id.b_plusEtudiant);
        b_plusJeune = findViewById(R.id.b_plusJeune);
        b_moinsNormal = findViewById(R.id.b_moinsNormal);
        b_moinsEtudiant = findViewById(R.id.b_moinsEtudiant);
        b_moinsJeune = findViewById(R.id.b_moinsJeune);
        b_reserver =findViewById(R.id.b_reserver);

        //Initialisation du nom du film et de l'heure
        String nomFilm="";
        String heure="";

        //Récupération des paramètres passés lors du changement d'activity
        if(intent != null){

            if(intent.hasExtra("nomFilm")){
                nomFilm = intent.getStringExtra("nomFilm");
            }
            if(intent.hasExtra("heure")){
                heure = intent.getStringExtra("heure");
            }
        }


        //Modification du titre est de l'heure avec ceux de la scéance courrante
        tv_titre.setText(nomFilm);
        tv_heure.setText(heure);

        b_plusNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementPlace(tv_nbPlacesNormal);
            }
        });

        b_moinsNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementPlace(tv_nbPlacesNormal);
            }
        });

        b_plusEtudiant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementPlace(tv_nbPlacesEtudiant);
            }
        });

        b_moinsEtudiant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementPlace(tv_nbPlacesEtudiant);
            }
        });

        b_plusJeune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementPlace(tv_nbPlacesJeune);
            }
        });

        b_moinsJeune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementPlace(tv_nbPlacesJeune);
            }
        });

        b_reserver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double coutTotal;
                double nbPlacesNormal = Integer.parseInt(tv_nbPlacesNormal.getText().toString());
                double nbPlacesEtudiant = Integer.parseInt(tv_nbPlacesEtudiant.getText().toString());
                double nbPlacesJeune = Integer.parseInt(tv_nbPlacesJeune.getText().toString());

                coutTotal = (nbPlacesNormal*9.60) + (nbPlacesEtudiant*7) + (nbPlacesJeune*5);
                if(coutTotal>0) {
                    Intent intent = new Intent(ReserverActivity.this, DetailReservationActivity.class);
                    intent.putExtra("nomFilm", tv_titre.getText());
                    intent.putExtra("heure", tv_heure.getText());
                    intent.putExtra("coutTotal", coutTotal);

                    startActivity(intent);
                } else{
                    Toast toast = Toast.makeText(ReserverActivity.this, getResources().getText(R.string.txt_toast), Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }

    public void incrementPlace(TextView tv_nbPlaces){
        int nbPlaces = Integer.parseInt(tv_nbPlaces.getText().toString());
        nbPlaces++;
        tv_nbPlaces.setText(String.valueOf(nbPlaces));
    }

    public void decrementPlace(TextView tv_nbPlaces){
        int nbPlaces = Integer.parseInt(tv_nbPlaces.getText().toString());
        if (nbPlaces>0){
            nbPlaces--;
            tv_nbPlaces.setText(String.valueOf(nbPlaces));
        }
    }
}