package com.example.cinedroid;

public class Seance {
    private long idS;
    private String nomFilm;
    private String realisateur;
    private int duree;
    private String langue;
    private String heure;

    public Seance(long idS, String nomFilm, String realisateur, int duree, String langue, String heure){
        this.idS = idS;
        this.nomFilm=nomFilm;
        this.realisateur=realisateur;
        this.duree=duree;
        this.langue=langue;
        this.heure=heure;
    }

    public Seance(String nomFilm, String realisateur, int duree, String langue, String heure){
        this.nomFilm=nomFilm;
        this.realisateur=realisateur;
        this.duree=duree;
        this.langue=langue;
        this.heure=heure;
    }

    //Getters
    public long getIdS() {
        return idS;
    }

    public String getNomFilm() {
        return nomFilm;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public int getDuree(){
        return duree;
    }

    public String getDureeToString() {
        String heures;
        String minutes;

        heures=Integer.toString((duree/60));
        if(heures.length()<2){
            heures = '0' + heures;
        }
        minutes=Integer.toString((duree%60));
        if(minutes.length()<2){
            minutes = '0' + minutes;
        }


        return heures + ':' + minutes;
    }

    public String getLangue() {
        return langue;
    }

    public String getHeure() {
        return heure;
    }

    //Setters
    public void setIdS(long idS) {
        this.idS = idS;
    }

    public void setNomFilm(String nomFilm) {
        this.nomFilm = nomFilm;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    //Methodes usuelles
    public String toString(){
        return " | " + getNomFilm() + " " + getRealisateur() + " " + getDureeToString() +  " " + getLangue() + " " + getHeure();
    }
}
