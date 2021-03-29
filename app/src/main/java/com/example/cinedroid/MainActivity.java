package com.example.cinedroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeanceDAO seanceDAO = new SeanceDAO(this);
        Log.d("onCreate", seanceDAO.getSeances().toString());
    }
}
