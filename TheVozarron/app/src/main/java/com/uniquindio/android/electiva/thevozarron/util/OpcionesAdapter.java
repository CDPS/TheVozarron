package com.uniquindio.android.electiva.thevozarron.util;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uniquindio.android.electiva.thevozarron.R;
import com.uniquindio.android.electiva.thevozarron.fragments.MenuOpciones;
import com.uniquindio.android.electiva.thevozarron.vo.Opciones;

import java.util.ArrayList;

/**
 * Created by cristian on 24/10/16.
 */
public class OpcionesAdapter extends RecyclerView.Adapter<OpcionesAdapter.OpcionViewHolder> {

    private static OnClickAdaptadorOPciones listener;
    private ArrayList<Opciones> opciones;

    public interface OnClickAdaptadorOPciones{
        public void onClickPosition(int pos);
    }

    public OpcionesAdapter(ArrayList<Opciones> opciones, MenuOpciones op){
        this.opciones = opciones;
        listener = (OnClickAdaptadorOPciones) op;
    }

    public static class OpcionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView txtOpcion;

        public OpcionViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txtOpcion = (TextView) itemView.findViewById(R.id.opcion);
        }

        public void binOpcion(Opciones o) {
            txtOpcion.setText(o.getOpcion());
        }

        @Override
        public void onClick(View view) {
            listener.onClickPosition(getAdapterPosition());
        }
    }

    @Override
    public OpcionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.opcion_opciones, parent, false);
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
