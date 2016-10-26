package com.uniquindio.android.electiva.thevozarron.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.uniquindio.android.electiva.thevozarron.R;
import com.uniquindio.android.electiva.thevozarron.fragments.ListaEntrenadores;
import com.uniquindio.android.electiva.thevozarron.fragments.ListaIdiomas;

public class CambiarIdiomaActivity extends AppCompatActivity implements ListaIdiomas.OnIdiomaSeleccionado{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambiar_idioma);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar_lenguaje) );
        ListaIdiomas listaIdiomas = (ListaIdiomas) getSupportFragmentManager().findFragmentById(R.id.listaIdiomas);
    }

    @Override
    public void OnIdiomaSeleccionado(int position) {

    }
}
