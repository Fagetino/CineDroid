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
        db.execSQL("create table seances("
                + "idS INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "nomFilm TEXT NOT NULL,"
                + "realisateur TEXT NOT NULL,"
                + "duree NUMBER NOT NULL,"
                + "langue TEXT NOT NULL,"
                + "heure TEXT NOT NULL);");

        Modele.initSeances();
        insertSeances(Modele.lesSeances, db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    //==================== Insertions ====================
    public void insertSeance(Seance seance, SQLiteDatabase db){
        db.execSQL("insert into seances(nomFilm, realisateur, duree, langue, heure) values('" + seance.getNomFilm() + "', '"+ seance.getRealisateur() +"', '"+ seance.getDuree() +"', '"+ seance.getLangue() +"', '"+ seance.getHeure() +"')");
    }

    public void insertSeances(ArrayList<Seance> seances, SQLiteDatabase db){
        for (Seance seance : seances) {
            insertSeance(seance, db);
        }
    }

    //==================== Requêtes ====================
    public ArrayList<Seance> getSeances(){
        Cursor curseur;
        String req = "select * from seances";
        curseur = this.getReadableDatabase().rawQuery(req, null);
        return curseurToSeanceArrayList(curseur);
    }

    public ArrayList<Seance> getSeances(String heure){
        Cursor curseur;
        String req = "select * from seances where heure like ?";
        curseur = this.getReadableDatabase().rawQuery(req, new String[]{heure+""});
        return curseurToSeanceArrayList(curseur);
    }

    public Seance getSeance(long idS){
        Seance uneSeance = null;
        Cursor curseur;
        curseur = this.getReadableDatabase().rawQuery("select * from seances where idS=?;", new String[]{idS+""});
        uneSeance = curseurToPlat(curseur);

        return uneSeance;
    }

    public Seance getSeance(String nomFilm){
        Seance uneSeance = null;
        Cursor curseur;
        curseur = this.getReadableDatabase().rawQuery("select * from plat where nomFilm=?;", new String[]{nomFilm+""});
        uneSeance = curseurToPlat(curseur);

        return uneSeance;
    }


    //==================== Transformation du curseur ====================
    private ArrayList<Seance> curseurToSeanceArrayList(Cursor curseur) {
        ArrayList<Seance> seancesArray = new ArrayList<>();
        long idS;
        String nomFilm;
        String realisateur;
        int duree;
        String langue;
        String heure;
        curseur.moveToFirst();
        while(!curseur.isAfterLast()) {
            idS=curseur.getLong(0);
            nomFilm=curseur.getString(1);
            realisateur=curseur.getString(2);
            duree=curseur.getInt(3);
            langue=curseur.getString(4);
            heure=curseur.getString(5);
            seancesArray.add(new Seance(idS, nomFilm, realisateur, duree, langue, heure));
            curseur.moveToNext();
        }
        return seancesArray;
    }

    private Seance curseurToPlat(Cursor curseur) {
        Seance uneSeance = null;
        long idS;
        String nomFilm;
        String realisateur;
        int duree;
        String langue;
        String heure;


        if(curseur.getCount()>0){
            curseur.moveToFirst();
            idS=curseur.getLong(0);
            nomFilm=curseur.getString(1);
            realisateur=curseur.getString(2);
            duree=curseur.getInt(3);
            langue=curseur.getString(4);
            heure=curseur.getString(5);
            uneSeance = new Seance(idS, nomFilm, realisateur, duree, langue, heure);
        }
        return uneSeance;
    }
}
