package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Pedro on 04/11/2016.
 */

public class Evaluation {
    @SerializedName("id")
    private int Id;

    @SerializedName("fecha_inicio")
    private Date fecha_Inicio;

    @SerializedName("fecha_fin")
    private Date fecha_Fin;

    @SerializedName("nombre")
    private String Nombre;

    @SerializedName("descripcion")
    private String Descripcion;

    @SerializedName("tiempo")
    private int Tiempo;

    @SerializedName("id_especialidad")
    private int id_Especialidad;

    @SerializedName("estado")
    private int Estado;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Date getFecha_Inicio() {
        return fecha_Inicio;
    }

    public void setFecha_Inicio(Date fecha_Inicio) {
        this.fecha_Inicio = fecha_Inicio;
    }

    public Date getFecha_Fin() {
        return fecha_Fin;
    }

    public void setFecha_Fin(Date fecha_Fin) {
        this.fecha_Fin = fecha_Fin;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public int getTiempo() {
        return Tiempo;
    }

    public void setTiempo(int tiempo) {
        Tiempo = tiempo;
    }

    public int getId_Especialidad() {
        return id_Especialidad;
    }

    public void setId_Especialidad(int id_Especialidad) {
        this.id_Especialidad = id_Especialidad;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int estado) {
        Estado = estado;
    }
}
