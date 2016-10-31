package com.uniquindio.android.electiva.thevozarron.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.uniquindio.android.electiva.thevozarron.R;
import com.uniquindio.android.electiva.thevozarron.vo.Participantes;

public class InformacionParticipanteActivity extends AppCompatActivity {


    //------------------------------------------------------------------------------
    //Atributos
    //------------------------------------------------------------------------------

    //textviews que sirven para mostrar la informacion general del participante
    TextView nombre,estado,entrenador,edad,rol,video;

    //ImageViews que sirven para mostrar la foto del participante
    ImageView imageView;

    //------------------------------------------------------------------------------
    //Metodos
    //------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_participante);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar_participante) );

        // Se captura el participante que se ha seleccionado para mostrar el detalle
        // de la informacion de este,
        Participantes p = (Participantes) getIntent().getExtras().get("part");

        //Se setea la informacion de los componentes de la interfaz
        //para mostrar la informacion del participante
        nombre  = (TextView)findViewById(R.id.textNombreC);
        nombre.setText(p.getNombre());
        estado = (TextView)findViewById(R.id.textEstadoC);
        estado.setText(p.getEstado());
        edad= (TextView)findViewById(R.id.textEdadC);
        edad.setText(""+p.getEdad());
        entrenador = (TextView) findViewById(R.id.textEntrenadorC);
        entrenador.setText(p.getEntrenador());
        rol = (TextView) findViewById(R.id.textRolC);
        rol.setText(p.getEntrenador());
        video = (TextView) findViewById(R.id.textVideoC);
        video.setText(p.getVideo());
        imageView = (ImageView) findViewById(R.id.foto_entrenador);
        imageView.setImageResource(p.getImagen());
    }
}
