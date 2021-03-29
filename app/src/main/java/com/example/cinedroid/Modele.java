package com.example.cinedroid;

import java.util.ArrayList;

public class Modele {
    public static ArrayList<Sceance> lesSceances = new ArrayList<>();

    public static void initSceances(){
        lesSceances.clear();
        lesSceances.add(new Sceance("Countdown", "Justin Dec", "1h30", "VF", "10h"));
        lesSceances.add(new Sceance("Jocker", "Todd Phillips", "2h2", "VO", "20h"));
        lesSceances.add(new Sceance("Abominable", "Jill Culton", "1h37", "VF", "19h"));
        lesSceances.add(new Sceance("Maléfique", "Joachim Rønning", "1h58", "VF", "10h"));
        lesSceances.add(new Sceance("Tom et Jerry", "Tim Story", "1h41", "VF", "16h"));
    }
}
