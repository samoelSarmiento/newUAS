package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Franz on 21/10/2016.
 */

public class PSPDocument {

    @SerializedName("IdPSPDocument")
    private
    int IdPSPDocument;
    @SerializedName("IdTipoEstado")
    private
    int IdTipoEstado;
    @SerializedName("ruta")
    private
    String ruta;
    @SerializedName("observaciones")
    private
    String observaciones;
    @SerializedName("es_obligatorio")
    private
    String es_obligatorio;
    @SerializedName("IdStudent")
    private
    int IdStudent;
    @SerializedName("IdTemplate")
    private
    int IdTemplate;
    @SerializedName("fecha_limite")
    private
    Date fecha_limite;

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
