package com.uniquindio.android.electiva.thevozarron.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.uniquindio.android.electiva.thevozarron.R;
import com.uniquindio.android.electiva.thevozarron.fragments.ListaEntrenadores;
import com.uniquindio.android.electiva.thevozarron.vo.Entrenador;
import com.uniquindio.android.electiva.thevozarron.vo.Participantes;

import java.util.ArrayList;

public class ListaEntrenadoresActivity extends AppCompatActivity implements ListaEntrenadores.OnEntrenadorSeleccionado {

    public ArrayList<Entrenador> listaEnt;
    public ArrayList<Participantes> participantes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_entrenadores);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar_lista_entrenador) );

        participantes = new ArrayList<>();
        participantes.add(new Participantes("Mario","En competencia",20,"Riahana","Estudiante","www.youtube.com",R.drawable.mario));
        participantes.add(new Participantes("Luigui","En competencia",22,"Riahana","Admin","www.youtube.com",R.drawable.luigi));
        participantes.add(new Participantes("Peach","En competencia",21,"Riahana","Estudiante","www.youtube.com",R.drawable.peach));
        participantes.add(new Participantes("Bowser","En competencia",20,"Adelle","Profesor","www.youtube.com",R.drawable.bowser));
        participantes.add(new Participantes("Don King kong","En competencia",30,"Adelle","Estudiante","www.youtube.com",R.drawable.don));
        participantes.add(new Participantes("Toad","En competencia",32,"Adelle","Profesor","www.youtube.com",R.drawable.toad));
        participantes.add(new Participantes("Waluigui","En competencia",20,"Johnny Rivera","Estudiante","www.youtube.com",R.drawable.waligui));
        participantes.add(new Participantes("Warior","En competencia",21,"Johnny Rivera","Estudiante","www.youtube.com",R.drawable.warior));
        participantes.add(new Participantes("Yoshi","En competencia",20,"Riahana","Estudiante","www.youtube.com",R.drawable.yoshi));

        listaEnt = new ArrayList<Entrenador>();
        listaEnt.add(new Entrenador("Riahana","Pop","Gano 2 grammys",R.drawable.riahana));
        listaEnt.get(0).getListaParticipantes().add(participantes.get(0));
        listaEnt.get(0).getListaParticipantes().add(participantes.get(1));
        listaEnt.get(0).getListaParticipantes().add(participantes.get(2));

        listaEnt.add(new Entrenador("Adelle","Pop","Gano premios MTV",R.drawable.adelle));
        listaEnt.get(1).getListaParticipantes().add(participantes.get(3));
        listaEnt.get(1).getListaParticipantes().add(participantes.get(4));
        listaEnt.get(1).getListaParticipantes().add(participantes.get(5));
        listaEnt.add(new Entrenador("Johnny Rirvera","Despecho","Adefesio musical",R.drawable.jhonny));
        listaEnt.get(2).getListaParticipantes().add(participantes.get(6));
        listaEnt.get(2).getListaParticipantes().add(participantes.get(7));
        listaEnt.get(2).getListaParticipantes().add(participantes.get(8));
        ListaEntrenadores listaEntrenadores = (ListaEntrenadores) getSupportFragmentManager().findFragmentById(R.id.fragmento_lista_entrenadores);
        listaEntrenadores.setOpciones(listaEnt);
    }

    @Override
    public void OnEntrenadorSeleccionado(int position) {
        Intent intent = new Intent(this,InformacionEntrenadorActivity.class);
        intent.putExtra("ent",listaEnt.get(position));
        intent.putParcelableArrayListExtra("list",listaEnt.get(position).getListaParticipantes());
        startActivity(intent);
    }
}
