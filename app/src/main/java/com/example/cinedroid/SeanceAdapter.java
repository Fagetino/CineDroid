package com.example.cinedroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SeanceAdapter extends BaseAdapter {
    private Context context;
    private final ArrayList<Seance> listeSeance;
    private LayoutInflater inflater;
    private TextView tv_nomFilm;
    private TextView tv_realisateur;
    private TextView tv_duree;
    private TextView tv_langue;

    public SeanceAdapter(Context context, ArrayList<Seance> listeSeance){
        this.context = context;
        this.listeSeance = listeSeance;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listeSeance.size();
    }

    @Override
    public Seance getItem(int i) {
        return listeSeance.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.adapter_item, null);

        Seance maSeance = getItem(i); //Item courrant

        //Récupération des view de mon item
        tv_nomFilm = view.findViewById(R.id.tv_nomFilm);
        tv_realisateur = view.findViewById(R.id.tv_realisateur);
        tv_duree = view.findViewById(R.id.tv_duree);
        tv_langue = view.findViewById(R.id.tv_langue);

        //Attribution des caractéristique la seance aux diferentes vues
        tv_nomFilm.setText(maSeance.getNomFilm());
        tv_realisateur.setText(maSeance.getRealisateur());
        tv_duree.setText(maSeance.getDureeToString());
        tv_langue.setText(maSeance.getLangue());

        return view;
    }
}
