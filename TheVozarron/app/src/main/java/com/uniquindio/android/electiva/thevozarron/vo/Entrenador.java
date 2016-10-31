package com.uniquindio.android.electiva.thevozarron.vo;

import android.net.ParseException;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by cristian on 25/10/16.
 */
public class Entrenador implements Parcelable {


    //------------------------------------------------------------------------------
    //Atributos
    //------------------------------------------------------------------------------

    //Describe el nombre del entrenador
    String nombre;

    //Describe el genero que canta el entrenador
    String genero;

    //Describe una historia completa de lo que ha hecho el entrenador en su carrera
    String historial;

    //Identificador de la foto del entrenador
    int image;

    //Lista de participantes que este entrena
    ArrayList<Participantes> listaParticipantes;

    //------------------------------------------------------------------------------
    //Constructores
    //------------------------------------------------------------------------------

    public Entrenador(String nombre, String genero, String historial, int image){
        this.nombre = nombre;
        this.genero = genero;
        this.historial = historial;
        this.image = image;
        listaParticipantes = new ArrayList<>();
    }

    /**
     * Constructor que permite crear un entrenador a traves
     * de parce lable
     * @param in
     */
    protected Entrenador(Parcel in) {
        nombre = in.readString();
        genero = in.readString();
        historial = in.readString();
        image = in.readInt();
    }


    //------------------------------------------------------------------------------
    //Metodos Getters and Setters
    //------------------------------------------------------------------------------

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setHistorial(String historial) {
        this.historial = historial;
    }

    public String getNombre() {
        return nombre;
    }

    public String getGenero() {
        return genero;
    }

    public String getHistorial() {
        return historial;
    }

    public int getImage() {
        return image;
    }

    public ArrayList<Participantes> getListaParticipantes() {
        return listaParticipantes;
    }

    //------------------------------------------------------------------------------
    //Metodos
    //------------------------------------------------------------------------------

    public static final Parcelable.Creator<Entrenador> CREATOR = new Parcelable.Creator<Entrenador>() {
        @Override
        public Entrenador createFromParcel(Parcel in) {
            return new Entrenador(in);
        }

        @Override
        public Entrenador[] newArray(int size) {
            return new Entrenador[size];
        }
    };

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nombre);
        parcel.writeString(genero);
        parcel.writeString(historial);
        parcel.writeInt(image);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
