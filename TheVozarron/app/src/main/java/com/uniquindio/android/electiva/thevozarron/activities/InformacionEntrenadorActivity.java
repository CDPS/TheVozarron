package com.uniquindio.android.electiva.thevozarron.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.uniquindio.android.electiva.thevozarron.R;
import com.uniquindio.android.electiva.thevozarron.fragments.SeccionPrincipal;
import com.uniquindio.android.electiva.thevozarron.vo.Entrenador;
import com.uniquindio.android.electiva.thevozarron.vo.Participantes;

import java.util.ArrayList;

public class InformacionEntrenadorActivity extends AppCompatActivity implements  SeccionPrincipal.OnSeccionSeleccionada, View.OnClickListener {


    //------------------------------------------------------------------------------
    //Atributos
    //------------------------------------------------------------------------------

    //textviews que sirven para mostrar la informacion general del entrenador
    TextView nombre, genero, historial;

    //ImageViews que sirven para mostrar la foto del entrenador
    ImageView imageView;

    //Button que sirve para mostrar los discipulos asociados a este entrenador
    Button button;

    //Participantes asociados al entrenador que se le esta mirando la informacion
    ArrayList<Participantes> participantes;


    //------------------------------------------------------------------------------
    //Metodos
    //------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_entrenador);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar_entrenador) );

        //Se captura el entrenador seleccionado con sus lista de participantes asociados
        Entrenador e = (Entrenador)getIntent().getExtras().get("ent");
        participantes = getIntent().getParcelableArrayListExtra("list");

        //Se setea la informacion de la interfaz
        nombre  = (TextView)findViewById(R.id.textNombreC);
        nombre.setText(e.getNombre());
        genero = (TextView)findViewById(R.id.textGeneroC);
        genero.setText(e.getGenero());
        historial= (TextView)findViewById(R.id.textHistorialC);
        historial.setText(e.getHistorial());
        imageView = (ImageView) findViewById(R.id.foto_entrenador);
        imageView.setImageResource(e.getImage());
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
    }


    @Override
    public void OnSeccionSeleccionada(int position) {}

    @Override
    public void onClick(View view) {
        if(view.getId() == button.getId()){
            //si se da click en el boton, se debe mostrar la lista de participantes
            Intent intent = new Intent(this, ListaParticipantesActivity.class);
            intent.putParcelableArrayListExtra("list",participantes);
            startActivity(intent);
        }
    }
}
