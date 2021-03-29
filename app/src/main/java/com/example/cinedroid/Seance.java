package com.example.cinedroid;

public class Seance {
    private long idS;
    private String nomFilm;
    private String realisateur;
    private String duree;
    private String langue;
    private String heure;

    public Seance(long idS, String nomFilm, String realisateur, String duree, String langue, String heure){
        this.idS = idS;
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

    public String getDuree() {
        return duree;
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

    public void setDuree(String duree) {
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
        return " | " + getNomFilm() + " " + getRealisateur() + " " + getDuree() +  " " + getLangue() + " " + getHeure();
    }
}
