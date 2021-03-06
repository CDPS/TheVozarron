package com.uniquindio.android.electiva.thevozarron.util;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uniquindio.android.electiva.thevozarron.R;
import com.uniquindio.android.electiva.thevozarron.fragments.SeccionPrincipal;
import com.uniquindio.android.electiva.thevozarron.vo.Opciones;

import java.util.ArrayList;

/**
 * Created by cristian on 23/10/16.
 */
public class SeccionPrincipalAdapter  extends RecyclerView.Adapter<SeccionPrincipalAdapter.OpcionViewHolder>{

    //------------------------------------------------------------------------------
    //Atributos
    //------------------------------------------------------------------------------

    //listener para cada una de las opciones
    private static OnClickAdaptadorSeccionPrincipal listener;

    //lista de opciones a adaptar
    private ArrayList<Opciones> opciones;

    /**
     * Interfaz para el listener del fragmento
     */
    public interface OnClickAdaptadorSeccionPrincipal{
        public void onClickPosition(int pos);
    }

    //------------------------------------------------------------------------------
    //Constructor
    //------------------------------------------------------------------------------

    public SeccionPrincipalAdapter(ArrayList<Opciones> opciones, SeccionPrincipal sp){
        this.opciones = opciones;
        listener = (OnClickAdaptadorSeccionPrincipal) sp;
    }

    public static class OpcionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        //------------------------------------------------------------------------------
        //Atributos
        //------------------------------------------------------------------------------

        //TexVIew que muestra el participante a  seleccionar
        private TextView txtOpcion;

        /*Metodo que srive para incializar
        *Los componentes de esta interfaz
        */
        public OpcionViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txtOpcion = (TextView) itemView.findViewById(R.id.opcion);
        }

        /* Metodo que sirve para hacer binding entre las opciones
         * y los componetes de la interfaz
         * @param o objeto del cual se extrae la informacion para realizar el binding
         */
        public void binOpcion(Opciones o) {
            txtOpcion.setText(o.getOpcion());
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
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.opcion_seccion_principal, parent, false);
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
