package com.uniquindio.android.electiva.thevozarron.vo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by cristian on 26/10/16.
 */
public class Participantes implements Parcelable {

    String nombre;
    String estado;
    int edad;
    String entrenador;
    String rol;
    String video;
    int imagen;


    public Participantes(String nombre, String estado,int edad,String entrenador,String rol,
                         String video,int imagen){
        this.nombre=nombre;
        this.estado=estado;
        this.edad=edad;
        this.entrenador=entrenador;
        this.rol=rol;
        this.video=video;
        this.imagen = imagen;
    }

    protected Participantes(Parcel in) {
        nombre = in.readString();
        estado = in.readString();
        edad = in.readInt();
        entrenador= in.readString();
        rol = in.readString();
        video  = in.readString();
        imagen = in.readInt();
    }

    public static final Parcelable.Creator<Participantes> CREATOR = new Parcelable.Creator<Participantes>() {
        @Override
        public Participantes createFromParcel(Parcel in) {
            return new Participantes(in);
        }

        @Override
        public Participantes[] newArray(int size) {
            return new Participantes[size];
        }
    };

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nombre);
        parcel.writeString(estado);
        parcel.writeInt(edad);
        parcel.writeString(entrenador);
        parcel.writeString(rol);
        parcel.writeString(video);
        parcel.writeInt(imagen);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String getEstado() {
        return estado;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getEntrenador() {
        return entrenador;
    }

    public String getRol() {
        return rol;
    }

    public String getVideo() {
        return video;
    }

    public int getImagen() {
        return imagen;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setEntrenador(String entrenador) {
        this.entrenador = entrenador;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public void setVideo(String video) {
        this.video = video;
    }
}
