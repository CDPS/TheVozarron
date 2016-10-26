package com.uniquindio.android.electiva.thevozarron.fragments;


import android.app.Activity;
import android.content.Context;
import android.graphics.Path;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uniquindio.android.electiva.thevozarron.R;
import com.uniquindio.android.electiva.thevozarron.util.EntrenadoresAdapter;
import com.uniquindio.android.electiva.thevozarron.util.OpcionesAdapter;
import com.uniquindio.android.electiva.thevozarron.vo.Entrenador;
import com.uniquindio.android.electiva.thevozarron.vo.Opciones;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaEntrenadores extends Fragment  implements EntrenadoresAdapter.OnClickAdaptadorEntrenadores{


    private ArrayList<Opciones> opciones;
    private EntrenadoresAdapter adapter;
    private RecyclerView listadoOpciones;
    private OnEntrenadorSeleccionado listener;

    public ListaEntrenadores() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista_entrenadores, container, false);
    }

    @Override
    public void onClickPosition(int pos) {listener.OnEntrenadorSeleccionado(pos); }

    public interface OnEntrenadorSeleccionado {
        void OnEntrenadorSeleccionado(int position);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listadoOpciones = (RecyclerView) getView().findViewById(R.id.listaEntrenadores);
        adapter = new EntrenadoresAdapter(this.opciones,this);
        listadoOpciones.setAdapter(adapter);
        listadoOpciones.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity;
        if (context instanceof Activity){
            activity = (Activity) context;
            try {
                listener = (OnEntrenadorSeleccionado) activity;
            } catch (ClassCastException e) {
                throw new ClassCastException(activity.toString() + " debe implementar la interfaz OnOpcionSeleccionada");
            }
        }
    }

    public void setOpciones (ArrayList<Entrenador> e){
        opciones = new ArrayList<>();
        for(int i=0;i<e.size();i++){
            opciones.add(new Opciones(e.get(i).getNombre()));
        }
    }
}
