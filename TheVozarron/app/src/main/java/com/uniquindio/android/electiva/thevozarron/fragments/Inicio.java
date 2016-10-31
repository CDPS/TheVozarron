package com.uniquindio.android.electiva.thevozarron.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uniquindio.android.electiva.thevozarron.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Inicio extends Fragment {

    //------------------------------------------------------------------------------
    //Atributos
    //------------------------------------------------------------------------------

    //atributo que indica que es una seccion de un tabViewer
    private static final String ARG_SECTION_NUMBER = "section_number";

    //------------------------------------------------------------------------------
    //Constructor
    //------------------------------------------------------------------------------


    public Inicio() {
        // Required empty public constructor
    }

    //------------------------------------------------------------------------------
    //Metodos
    //------------------------------------------------------------------------------

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inicio, container, false);
    }

    /**
     * Crea una instancia del fragmento para ponerlo en una seccion del
     * Tabviewer de la actividad principal
     * @param sectionNumber es el numero donde queremos que este ubicado el fragmento
     * @return una instancia del fragmento Inicion
     */
    public static  Inicio newInstance(int sectionNumber) {
        Inicio fragment = new Inicio();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }
}
