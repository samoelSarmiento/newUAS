package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;


/**
 * Created by jemarroquin on 30/10/2016.
 */
public class Document implements Serializable{

    @SerializedName("IdPSPDocument")
    private
    int IdPSPDocument;
    @SerializedName("IdTipoEstado")
    private
    int IdTipoEstado;


    @SerializedName("IdStudent")
    private
    int IdStudent;
    @SerializedName("IdTemplate")
    private
    int IdTemplate;


    @SerializedName("idPSPDocument")
    private int idPSPDocument;

    @SerializedName("idTipoEstado")
    private int idTipoEstado;


    @SerializedName("ruta")
    private String ruta;

    @SerializedName("observaciones")
    private String observaciones;

    @SerializedName("es_obligatorio")
    private String es_obligatorio;

    @SerializedName("idStudent")
    private int idStudent;

    @SerializedName("idTemplate")
    private int idTemplate;


    @SerializedName("fecha_limite")
    private Date fecha_limite;


    public int getIdPSPDocument() {
        return IdPSPDocument;
    }

    public void setIdPSPDocument(int idPSPDocument) {
        IdPSPDocument = idPSPDocument;
    }

    public int getIdTipoEstado() {
        return IdTipoEstado;
    }

    public void setIdTipoEstado(int idTipoEstado) {
        IdTipoEstado = idTipoEstado;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getEs_obligatorio() {
        return es_obligatorio;
    }

    public void setEs_obligatorio(String es_obligatorio) {
        this.es_obligatorio = es_obligatorio;
    }

    public int getIdStudent() {
        return IdStudent;
    }

    public void setIdStudent(int idStudent) {
        IdStudent = idStudent;
    }

    public int getIdTemplate() {
        return IdTemplate;
    }

    public void setIdTemplate(int idTemplate) {
        IdTemplate = idTemplate;
    }

    public Date getFecha_limite() {
        return fecha_limite;
    }

    public void setFecha_limite(Date fecha_limite) {
        this.fecha_limite = fecha_limite;
    }


}
