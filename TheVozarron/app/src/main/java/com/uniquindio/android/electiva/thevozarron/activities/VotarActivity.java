package com.uniquindio.android.electiva.thevozarron.activities;

import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.uniquindio.android.electiva.thevozarron.R;
import com.uniquindio.android.electiva.thevozarron.fragments.ListaParticipantes;
import com.uniquindio.android.electiva.thevozarron.fragments.VotarParticipantes;
import com.uniquindio.android.electiva.thevozarron.vo.Opciones;

import java.util.ArrayList;

public class VotarActivity extends AppCompatActivity implements VotarParticipantes.OnParticpanteSeleccionado{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_votar);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar_lista_votos) );
    }

    @Override
    public void OnParticpanteSeleccionado(int position) {
        VotarParticipantes listaParticipantesFragment =(VotarParticipantes) getSupportFragmentManager().findFragmentById(R.id.fragmento_lista_votos);
        ArrayList<Opciones> p = listaParticipantesFragment.getOpciones();
        p.get(position).setDescripcion(""+ Integer.parseInt(p.get(position).getDescripcion()) +1 );
        listaParticipantesFragment.setOpciones2(p);
    }
}
