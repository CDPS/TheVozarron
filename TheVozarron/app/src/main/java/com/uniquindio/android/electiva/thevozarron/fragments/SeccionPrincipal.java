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
import com.uniquindio.android.electiva.thevozarron.util.SeccionPrincipalAdapter;
import com.uniquindio.android.electiva.thevozarron.vo.Opciones;

import java.security.PublicKey;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SeccionPrincipal extends Fragment implements SeccionPrincipalAdapter.OnClickAdaptadorSeccionPrincipal {

    //------------------------------------------------------------------------------
    //Atributos
    //------------------------------------------------------------------------------

    //Lista de opciones a mostrar en este fragmento
    private ArrayList<Opciones> opciones;

    //Adaptador para la lista de opciones
    private SeccionPrincipalAdapter adapter;

    //Instancia de RecyclerView utilizado en el fragmento
    private RecyclerView listadoOpciones;

    //Listener de las opciones desplegadas en el fragmento
    private OnSeccionSeleccionada listener;
    /**
     * Argumento que representa el número sección al que pertenece
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    //------------------------------------------------------------------------------
    //Constructor
    //------------------------------------------------------------------------------

    public SeccionPrincipal() {
        // Required empty public constructor
    }


    //------------------------------------------------------------------------------
    //Metodos
    //------------------------------------------------------------------------------

    @Override
    public void onClickPosition(int pos) {listener. OnSeccionSeleccionada(pos); }

    /**
     * Interfaz para el listener del fragmento
     */
    public interface OnSeccionSeleccionada {
        void OnSeccionSeleccionada(int position);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        opciones = new ArrayList<>();
        opciones.add(new Opciones(getString(R.string.entrenadores)));
        opciones.add(new Opciones(getString(R.string.participantes)));
        opciones.add(new Opciones(getString(R.string.votar) ));
        return inflater.inflate(R.layout.fragment_seccion_principal, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listadoOpciones = (RecyclerView) getView().findViewById(R.id.listaOpciones);
        adapter = new SeccionPrincipalAdapter(opciones,this);
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
                listener = (OnSeccionSeleccionada) activity;
            } catch (ClassCastException e) {
                throw new ClassCastException(activity.toString() + " debe implementar la interfaz OnOpcionSeleccionada");
            }
        }
    }

    /**
     * Crea una instancia del fragmento para ponerlo en una seccion del
     * Tabviewer de la actividad principal
     * @param sectionNumber es el numero donde queremos que este ubicado el fragmento
     * @return una instancia del fragmento Inicion
     */
    public static SeccionPrincipal newInstance(int sectionNumber) {
        SeccionPrincipal fragment = new SeccionPrincipal();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }
}
