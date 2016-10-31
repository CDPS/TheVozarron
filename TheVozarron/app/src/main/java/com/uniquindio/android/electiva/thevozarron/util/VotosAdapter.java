package com.uniquindio.android.electiva.thevozarron.util;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.uniquindio.android.electiva.thevozarron.R;
import com.uniquindio.android.electiva.thevozarron.fragments.VotarParticipantes;
import com.uniquindio.android.electiva.thevozarron.vo.Opciones;

import java.util.ArrayList;

/**
 * Created by cristian on 31/10/16.
 */
public class VotosAdapter extends   RecyclerView.Adapter <VotosAdapter.OpcionViewHolder> {

    //------------------------------------------------------------------------------
    //Atributos
    //------------------------------------------------------------------------------

    //listener para cada una de las opciones
    private static OnClickAdaptadorVotos listener;

    //lista de opciones a adaptar
    private ArrayList<Opciones> opciones;

    /**
     * Interfaz para el listener del fragmento
     */
    public interface OnClickAdaptadorVotos{
        public void onClickPosition(int pos);
    }

    //Constructor
    //------------------------------------------------------------------------------
    public VotosAdapter(ArrayList<Opciones> opciones, VotarParticipantes vp){
        this.opciones = opciones;
        listener = (OnClickAdaptadorVotos) vp;
    }


    public static class OpcionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        //------------------------------------------------------------------------------
        //Atributos
        //------------------------------------------------------------------------------

        //TexVIew que muestra el participante a  seleccionar
        private TextView txtOpcion;

        //TexVIew que muestra el estado del participante a  seleccionar
        private TextView txtDescripcion;

        //ImageView que muestra la foto del participante a seleccionar
        private ImageView imageView;

        /*Metodo que srive para incializar
         *Los componentes de esta interfaz
         */
        public OpcionViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txtOpcion = (TextView) itemView.findViewById(R.id.participantev);
            txtDescripcion =(TextView) itemView.findViewById(R.id.votos);
            imageView = (ImageView) itemView.findViewById(R.id.participantev_imagen);
        }


        /* Metodo que sirve para hacer binding entre las opciones
         * y los componetes de la interfaz
         * @param o objeto del cual se extrae la informacion para realizar el binding
         */
        public void binOpcion(Opciones o) {
            txtOpcion.setText(o.getOpcion());
            txtDescripcion.setText(o.getDescripcion());
            imageView.setImageResource(o.getImage());
        }

        @Override
        public void onClick(View view) {
            listener.onClickPosition(getAdapterPosition());
        }
    }


    //------------------------------------------------------------------------------
    //Metodos
    //------------------------------------------------------------------------------

    @Override
    public OpcionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.opcion_votar, parent, false);
        OpcionViewHolder opcion = new OpcionViewHolder(itemView);
        return opcion;
    }

    @Override
    public void onBindViewHolder(OpcionViewHolder holder, int position) {
        Opciones p = opciones.get(position);
        holder.binOpcion(p);
    }

    @Override
    public int getItemCount() {
        return opciones.size();
    }
}
