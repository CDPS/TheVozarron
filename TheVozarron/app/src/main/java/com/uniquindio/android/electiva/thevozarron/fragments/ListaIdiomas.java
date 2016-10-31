package com.uniquindio.android.electiva.thevozarron.fragments;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uniquindio.android.electiva.thevozarron.R;
import com.uniquindio.android.electiva.thevozarron.util.EntrenadoresAdapter;
import com.uniquindio.android.electiva.thevozarron.util.IdiomasAdapter;
import com.uniquindio.android.electiva.thevozarron.vo.Opciones;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaIdiomas extends Fragment implements  IdiomasAdapter.OnClickAdaptadorIdiomas{

    //------------------------------------------------------------------------------
    //Atributos
    //------------------------------------------------------------------------------

    //Lista de opciones a mostrar en este fragmento
    private ArrayList<Opciones> opciones;

    //Adaptador para la lista de opciones
    private IdiomasAdapter adapter;

    //Instancia de RecyclerView utilizado en el fragmento
    private RecyclerView listadoOpciones;

    //Listener de las opciones desplegadas en el fragmento
    private OnIdiomaSeleccionado listener;

    //------------------------------------------------------------------------------
    //Constructor
    //------------------------------------------------------------------------------

    public ListaIdiomas() {
        // Required empty public constructor
    }

    //------------------------------------------------------------------------------
    //Metodos
    //------------------------------------------------------------------------------

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        opciones = new ArrayList<>();
        opciones.add(new Opciones(getString(R.string.ingles) ) );
        opciones.add(new Opciones(getString(R.string.español) ));
        return inflater.inflate(R.layout.fragment_lista_idiomas, container, false);
    }

    @Override
    public void onClickPosition(int pos) {
        listener.OnIdiomaSeleccionado(pos);
    }

    /**
     * Interfaz para el listener del fragmento
     */
    public interface OnIdiomaSeleccionado {
        void  OnIdiomaSeleccionado(int position);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listadoOpciones = (RecyclerView) getView().findViewById(R.id.listaIdiomas);
        adapter = new IdiomasAdapter(this.opciones,this);
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
                listener = (OnIdiomaSeleccionado) activity;
            } catch (ClassCastException e) {
                throw new ClassCastException(activity.toString() + " debe implementar la interfaz OnOpcionSeleccionada");
            }
        }
    }

}