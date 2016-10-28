package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;

import java.util.Calendar;

/**
 * Created by Franz on 21/10/2016.
 */

public class PSPDocument {

    private String name;
    private Calendar date;
    private String author;
    private String format;

    @SerializedName("idPSPDocument")
    public int idPSPDocument;

    @SerializedName("idTipoEstado")
    public int idTipoEstado;


    @SerializedName("ruta")
    public String ruta;

    @SerializedName("observaciones")
    public String observaciones;

    @SerializedName("es_obligatorio")
    public String es_obligatorio;

    @SerializedName("idStudent")
    public int idStudent;

    @SerializedName("idTemplate")
    public int idTemplate;


    @SerializedName("fecha_limite")
    public int fecha_limite;


}
