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

}
