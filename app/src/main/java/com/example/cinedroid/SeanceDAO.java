package com.example.cinedroid;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class SeanceDAO extends SQLiteOpenHelper {

    public SeanceDAO(Context context) {
        super(context, Param.base, null, Param.version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table sceances("
                + "idS INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "nomFilm TEXT NOT NULL,"
                + "realisateur TEXT NOT NULL,"
                + "duree TEXT NOT NULL,"
                + "langue TEXT NOT NULL,"
                + "heure TEXT NOT NULL);");

        insertSeance(new Seance(0,"Countdown", "Justin Dec", "1h30", "VF", "10h"), db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public void insertSeance(Seance seance, SQLiteDatabase db){
        db.execSQL("insert into sceances(nomFilm, realisateur, duree, langue, heure) values('" + seance.getNomFilm() + "', '"+ seance.getRealisateur() +"', '"+ seance.getDuree() +"', '"+ seance.getLangue() +"', '"+ seance.getHeure() +"')");
    }

    public ArrayList<Seance> getSeances(){
        Cursor curseur;
        String req = "select * from sceances";
        curseur = this.getReadableDatabase().rawQuery(req, null);
        return curseurToSceanceArrayList(curseur);
    }

    private ArrayList<Seance> curseurToSceanceArrayList(Cursor curseur) {
        ArrayList<Seance> seancesArray = new ArrayList<>();
        long idS;
        String nomFilm;
        String realisateur;
        String duree;
        String langue;
        String heure;
        curseur.moveToFirst();
        while(!curseur.isAfterLast()) {
            idS=curseur.getLong(0);
            nomFilm=curseur.getString(1);
            realisateur=curseur.getString(2);
            duree=curseur.getString(3);
            langue=curseur.getString(4);
            heure=curseur.getString(5);
            seancesArray.add(new Seance(idS, nomFilm, realisateur, duree, langue, heure));
            curseur.moveToNext();
        }
        return seancesArray;
    }
}
