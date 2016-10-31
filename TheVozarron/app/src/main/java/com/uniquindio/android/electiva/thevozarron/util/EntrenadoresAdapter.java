package com.uniquindio.android.electiva.thevozarron.util;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.uniquindio.android.electiva.thevozarron.R;
import com.uniquindio.android.electiva.thevozarron.fragments.ListaEntrenadores;
import com.uniquindio.android.electiva.thevozarron.vo.Opciones;

import java.util.ArrayList;

/**
 * Created by cristian on 25/10/16.
 */
public class EntrenadoresAdapter  extends  RecyclerView.Adapter<EntrenadoresAdapter.OpcionViewHolder>  {

    //------------------------------------------------------------------------------
    //Atributos
    //------------------------------------------------------------------------------

    //listener para cada una de las opciones
    private static OnClickAdaptadorEntrenadores listener;

    //lista de opciones a adaptar
    private ArrayList<Opciones> opciones;

    /**
     * Interfaz para el listener del fragmento
     */
    public interface OnClickAdaptadorEntrenadores{
        public void onClickPosition(int pos);
    }

    //------------------------------------------------------------------------------
    //Constructor
    //------------------------------------------------------------------------------
    public EntrenadoresAdapter(ArrayList<Opciones> opciones, ListaEntrenadores le){
        this.opciones = opciones;
        listener = (OnClickAdaptadorEntrenadores) le;
    }

    public static class OpcionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        //------------------------------------------------------------------------------
        //Atributos
        //------------------------------------------------------------------------------

        //TexVIew que muestra el entrenador a  seleccionar
        private TextView txtOpcion;

        //ImageView que muestra la foto del entrenador a seleccionar
        private ImageView imageView;

        /*Metodo que srive para incializar
         *Los componentes de esta interfaz
         */
        public OpcionViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txtOpcion = (TextView) itemView.findViewById(R.id.entrenador);
            imageView = (ImageView)itemView.findViewById(R.id.entrenador_imagen);
        }

        /* Metodo que sirve para hacer binding entre las opciones
         * y los componetes de la interfaz
         * @param o objeto del cual se extrae la informacion para realizar el binding
         */
        public void binOpcion(Opciones o) {
            txtOpcion.setText(o.getOpcion());
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
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.opcion_entrenador, parent, false);
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

