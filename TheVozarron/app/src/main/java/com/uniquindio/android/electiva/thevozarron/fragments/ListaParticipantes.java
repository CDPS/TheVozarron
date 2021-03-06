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
import com.uniquindio.android.electiva.thevozarron.util.ParticipantesAdapter;
import com.uniquindio.android.electiva.thevozarron.vo.Opciones;
import com.uniquindio.android.electiva.thevozarron.vo.Participantes;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaParticipantes extends Fragment implements ParticipantesAdapter.OnClickAdaptadorParticipantes{

    //------------------------------------------------------------------------------
    //Atributos
    //------------------------------------------------------------------------------

    //Lista de opciones a mostrar en este fragmento
    private ArrayList<Opciones> opciones;

    //Adaptador para la lista de opciones
    private ParticipantesAdapter adapter;

    //Instancia de RecyclerView utilizado en el fragmento
    private RecyclerView listadoParticipantes;

    //Listener de las opciones desplegadas en el fragmento
    private OnEntrenadorSeleccionado listener;


    //------------------------------------------------------------------------------
    //Constructor
    //------------------------------------------------------------------------------
    public ListaParticipantes() {
        // Required empty public constructor
    }


    //------------------------------------------------------------------------------
    //Metodos
    //------------------------------------------------------------------------------
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        opciones = new ArrayList<>();
        return inflater.inflate(R.layout.fragment_lista_participantes, container, false);
    }


    @Override
    public void onClickPosition(int pos) {listener.OnEntrenadorSeleccionado(pos); }

    /**
     * Interfaz para el listener del fragmento
     */
    public interface OnEntrenadorSeleccionado {
        void OnEntrenadorSeleccionado(int position);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listadoParticipantes = (RecyclerView) getView().findViewById(R.id.listaParticipantes);
        adapter = new ParticipantesAdapter(this.opciones,this);
        listadoParticipantes.setAdapter(adapter);
        listadoParticipantes.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
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
    /**
      * Metodo que permite configurar la lista de
      * opciones a mostrar segun la lista de participantes ingresados
      * @param p lista de participantes a mostrar en las opciones de esta interfaz
      */
    public void setOpciones(ArrayList<Participantes> p){
        for(int i=0;i<p.size();i++){
            opciones.add(new Opciones(p.get(i).getNombre(),p.get(i).getEstado(),p.get(i).getImagen()));
        }
    }
}
