package com.uniquindio.android.electiva.thevozarron.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.uniquindio.android.electiva.thevozarron.R;
import com.uniquindio.android.electiva.thevozarron.fragments.ListaParticipantes;
import com.uniquindio.android.electiva.thevozarron.vo.Participantes;

import java.util.ArrayList;

public class ListaParticipantesActivity extends AppCompatActivity implements ListaParticipantes.OnEntrenadorSeleccionado {


    //------------------------------------------------------------------------------
    //Atributos
    //------------------------------------------------------------------------------

    //Lista de participantes a mostrar en la actividad
    private  ArrayList<Participantes> participantes;

    //------------------------------------------------------------------------------
    //Metodos
    //------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_participantes);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar_lista_participante) );

        //Se captura una lista de participantes que puede ser transferidad de otras
        //actividades
        participantes = getIntent().getParcelableArrayListExtra("list");

        //Si la lista esta vacia esto indica que se deben mostrar todos los entrenadores
        if(participantes.size()==0){
            participantes.add(new Participantes("Mario","En competencia",20,"Riahana","Estudiante","www.youtube.com",R.drawable.mario));
            participantes.add(new Participantes("Luigui","En competencia",22,"Riahana","Admin","www.youtube.com",R.drawable.luigi));
            participantes.add(new Participantes("Peach","En competencia",21,"Riahana","Estudiante","www.youtube.com",R.drawable.peach));
            participantes.add(new Participantes("Bowser","En competencia",20,"Adelle","Profesor","www.youtube.com",R.drawable.bowser));
            participantes.add(new Participantes("Don King kong","En competencia",30,"Adelle","Estudiante","www.youtube.com",R.drawable.don));
            participantes.add(new Participantes("Toad","En competencia",32,"Adelle","Profesor","www.youtube.com",R.drawable.toad));
            participantes.add(new Participantes("Waluigui","En competencia",20,"Johnny Rivera","Estudiante","www.youtube.com",R.drawable.waligui));
            participantes.add(new Participantes("Warior","En competencia",21,"Johnny Rivera","Estudiante","www.youtube.com",R.drawable.warior));
            participantes.add(new Participantes("Yoshi","En competencia",20,"Riahana","Estudiante","www.youtube.com",R.drawable.yoshi));
        }
        //Se carga el fragmento donde se deben mostrar los participantes
        //y se setea la lista de participantes en ese fragmentos
        ListaParticipantes  listaParticipantesFragment =(ListaParticipantes) getSupportFragmentManager().findFragmentById(R.id.fragmento_lista_participantes);
        listaParticipantesFragment.setOpciones(participantes);
    }

    @Override
    public void OnEntrenadorSeleccionado(int position) {
        //si se da click en un participante, se debe mostrar la informacion del
        //participante seleccionado
        Intent intent = new Intent(this,InformacionParticipanteActivity.class);
        intent.putExtra("part",participantes.get(position));
        startActivity(intent);
    }
}