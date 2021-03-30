package com.example.cinedroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailReservationActivity extends AppCompatActivity {
    private TextView tv_nomFilm;
    private TextView tv_heure;
    private TextView tv_coutTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_reservation);

        Intent intent = getIntent();

        //Récupération des views
        tv_nomFilm = findViewById(R.id.tv_nomFilm);
        tv_heure = findViewById(R.id.tv_heure);
        tv_coutTotal = findViewById(R.id.tv_coutTotal);

        //Initialisation du nom du film et de l'heure
        String nomFilm="";
        String heure="";
        double coutTotal=0;

        //Récupération des paramètres passés lors du changement d'activity
        if(intent != null){

            if(intent.hasExtra("nomFilm")){
                nomFilm = intent.getStringExtra("nomFilm");
            }
            if(intent.hasExtra("heure")){
                heure = intent.getStringExtra("heure");
            }
            if(intent.hasExtra("coutTotal")){
                coutTotal = intent.getDoubleExtra("coutTotal", 0);
            }
        }

        //Ajout du nom du film
        tv_nomFilm.setText(nomFilm);

        //Ajout de l'heure
        heure = tv_heure.getText().toString() + " " + heure;
        tv_heure.setText(heure);

        //Ajout du cout total
        String coutTotalString = tv_coutTotal.getText().toString() + " " + coutTotal + " " + getResources().getString(R.string.txt_devise);
        tv_coutTotal.setText(coutTotalString);

    }
}