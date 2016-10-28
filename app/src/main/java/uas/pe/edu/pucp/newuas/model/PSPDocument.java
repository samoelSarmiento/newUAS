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
