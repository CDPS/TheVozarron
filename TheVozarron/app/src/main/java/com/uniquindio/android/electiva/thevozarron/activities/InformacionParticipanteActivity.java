package com.uniquindio.android.electiva.thevozarron.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.uniquindio.android.electiva.thevozarron.R;
import com.uniquindio.android.electiva.thevozarron.vo.Entrenador;
import com.uniquindio.android.electiva.thevozarron.vo.Participantes;

public class InformacionParticipanteActivity extends AppCompatActivity {

    TextView nombre,estado,entrenador,edad,rol,video;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_participante);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar_participante) );

        Participantes p = (Participantes) getIntent().getExtras().get("part");
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
        imageView = (ImageView) findViewById(R.id.foto_participante);
        imageView.setImageResource(p.getImagen());
    }
}
