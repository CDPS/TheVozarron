package com.uniquindio.android.electiva.thevozarron.vo;

/**
 * Created by cristian on 23/10/16.
 */
public class Opciones {

    String opcion;
    int index;

    public Opciones(String opcion){
        this.opcion = opcion;
    }

    public int getIndex() {
        return index;
    }

    public String getOpcion() {
        return opcion;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }
}
