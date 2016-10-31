package com.uniquindio.android.electiva.thevozarron.vo;

/**
 * Created by cristian on 23/10/16.
 */
public class Opciones {

    //------------------------------------------------------------------------------
    //Atributos
    //------------------------------------------------------------------------------

    //Describe una opcion a seleccionar
    String opcion;

    //Describe una imagen que acompaña la opcion
    int image;

    //Describe una descripcion adicional
    String descripcion;


    //------------------------------------------------------------------------------
    //Constructores
    //------------------------------------------------------------------------------

    /**
     * Constructor para opciones simples como las de idiomas
     * o las de seccion principal
     * @param opcion opcion  a mostrar
     */
    public Opciones(String opcion){
        this.opcion = opcion;
    }

    /**
     * Constructor para las opciones de participantes
     * en donde se necesita mostrar la foto y el estado
     * @param opcion opcion a mostrar
     * @param descripcion descripcion del participante
     * @param image referencia de la imagen a mostrar
     */
    public Opciones(String opcion,String descripcion, int image){
        this.opcion = opcion;
        this.descripcion = descripcion;
        this.image = image;
    }

    /**
     * Constructor para las opciones de entrenadores
     * en donde se necesita mostrar el entenador y una foto
     * @param opcion nombre del entrenador a mostrar
     * @param image referencia de la imagen a mostrar
     */
    public Opciones(String opcion, int image){
        this.opcion = opcion;
        this.image = image;
    }

    //------------------------------------------------------------------------------
    //Metodos Getters and Setters
    //------------------------------------------------------------------------------

    public int getImage() {
        return image;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getOpcion() {
        return opcion;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }
}
