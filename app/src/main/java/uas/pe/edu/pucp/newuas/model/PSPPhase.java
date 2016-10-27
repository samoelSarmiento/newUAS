package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Franz on 27/10/2016.
 */

public class PSPPhase {
    @SerializedName("idPhase")
    private int idPhase;
    @SerializedName("numero")
    private int numero;
    @SerializedName("descripcion")
    private String descripcion;

    @SerializedName("fecha_inicio")
    private Date fechaInicio;

    @SerializedName("fecha_fin")
    private Date fechaFin;


    public int getIdPhase() {
        return idPhase;
    }

    public void setIdPhase(int idPhase) {
        this.idPhase = idPhase;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDesciption(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
}
