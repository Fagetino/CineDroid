package com.example.cinedroid;

import java.util.ArrayList;

public class Modele {
    public static ArrayList<Seance> lesSeances = new ArrayList<>();

    public static void initSeances(){
        lesSeances.clear();
        lesSeances.add(new Seance("Countdown", "Justin Dec", "1h30", "VF", "10h"));
        lesSeances.add(new Seance("Jocker", "Todd Phillips", "2h2", "VO", "20h"));
        lesSeances.add(new Seance( "Abominable", "Jill Culton", "1h37", "VF", "19h"));
        lesSeances.add(new Seance( "Maléfique", "Joachim Rønning", "1h58", "VF", "10h"));
        lesSeances.add(new Seance( "Tom et Jerry", "Tim Story", "1h41", "VF", "16h"));
    }
}
