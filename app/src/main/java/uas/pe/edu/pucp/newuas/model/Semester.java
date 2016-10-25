package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by samoe on 20/10/2016.
 */
public class Semester implements Serializable {

    @SerializedName("IdCicloAcademico")
    private int idCicloAcademico;

    @SerializedName("IdCiclo")
    private int idCiclo;

    @SerializedName("IdEspecialidad")
    private int idEspecialidad;

    @SerializedName("IdDocente")
    private int idDocente;

    @SerializedName("IdPeriodo")
    private int idPeriodo;

    @SerializedName("Descripcion")
    private String descripcion;

    @SerializedName("FechaInicio")
    private String fechaInicio;

    @SerializedName("FechaFin")
    private String fechaFin;

    @SerializedName("pivot")
    private Pivot pivot;

    public Pivot getPivot() {
        return pivot;
    }

    public void setPivot(Pivot pivot) {
        this.pivot = pivot;
    }

    public int getIdCicloAcademico() {
        return idCicloAcademico;
    }

    public void setIdCicloAcademico(int idCicloAcademico) {
        this.idCicloAcademico = idCicloAcademico;
    }

    public int getIdCiclo() {
        return idCiclo;
    }

    public void setIdCiclo(int idCiclo) {
        this.idCiclo = idCiclo;
    }

    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public int getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    public int getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(int idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }
}
