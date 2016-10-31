package com.uniquindio.android.electiva.thevozarron.activities;

import java.util.Locale;
import android.os.Bundle;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.uniquindio.android.electiva.thevozarron.R;
import com.uniquindio.android.electiva.thevozarron.fragments.ListaIdiomas;

public class CambiarIdiomaActivity extends AppCompatActivity implements ListaIdiomas.OnIdiomaSeleccionado{

    //------------------------------------------------------------------------------
    //Metodos
    //------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambiar_idioma);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar_lenguaje) );
    }

    /**
     * Listener que nos sirve para manejar cuando un idioma es seleccionada en la actividad
     * dependiendo de la posicion que es seleccionada, se cambiara el idioma.
     * @param position
     */
    @Override
    public void OnIdiomaSeleccionado(int position) {
        if(position==0){
            cambiarIdioma("en");
        }
        if(position==1){
            cambiarIdioma("es");
        }
    }

    /**
     * Metodo que sirve para cambiar el idioma de la aplicación
     * crea una nueva instancia de localizacion y setea la configuraricion
     * de la aplicacion con esta localizacion, despues de esto
     * reinicia la actividad que cambia el idioma
     * @param lang lenguaje al cual queremos cambiar la palicación
     *
     */
    void cambiarIdioma(String lang)
    {
        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this,CambiarIdiomaActivity.class);
        startActivity(refresh);
        finish();
    }
}
