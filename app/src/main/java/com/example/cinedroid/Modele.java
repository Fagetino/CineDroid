package com.example.cinedroid;

import java.util.ArrayList;

public class Modele {
    public static ArrayList<Seance> lesSeances = new ArrayList<>();

    public static void initSeances(){
        lesSeances.clear();
        lesSeances.add(new Seance("Countdown", "Justin Dec", 90, "VF", "10h"));
        lesSeances.add(new Seance("Jocker", "Todd Phillips", 122, "VO", "20h"));
        lesSeances.add(new Seance( "Abominable", "Jill Culton", 97, "VF", "19h"));
        lesSeances.add(new Seance( "Maléfique", "Joachim Rønning", 118, "VF", "10h"));
        lesSeances.add(new Seance( "Tom et Jerry", "Tim Story", 101, "VF", "16h"));
    }
}
