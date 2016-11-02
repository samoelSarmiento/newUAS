package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by Marshall on 31/10/2016.
 */

@DatabaseTable(tableName = "educationalobjective")
public class EducationalObjective implements Serializable {
    @SerializedName("IdObjetivoEducacional")
    @DatabaseField(id = true)
    private Integer idObjetivoEducacional;

    @DatabaseField
    private int period_id;

    @SerializedName("IdEspecialidad")
    @DatabaseField
    private Integer idEspecialidad;
    
    @SerializedName("Numero")
    @DatabaseField
    private Integer numero;

    @SerializedName("Descripcion")
    @DatabaseField
    private String descripcion;

    @SerializedName("CicloRegistro")
    private Object cicloRegistro;

    @SerializedName("Estado")
    private Integer estado;

    public EducationalObjective() {
    }

    public EducationalObjective(Integer idObjetivoEducacional, Integer idEspecialidad, Integer numero, String descripcion, Object cicloRegistro, Integer estado) {
        this.idObjetivoEducacional = idObjetivoEducacional;
        this.idEspecialidad = idEspecialidad;
        this.numero = numero;
        this.descripcion = descripcion;
        this.cicloRegistro = cicloRegistro;
        this.estado = estado;
    }

    public int getPeriod_id() {
        return period_id;
    }

    public void setPeriod_id(int period_id) {
        this.period_id = period_id;
    }

    public Integer getIdObjetivoEducacional() {
        return idObjetivoEducacional;
    }

    public void setIdObjetivoEducacional(Integer idObjetivoEducacional) {
        this.idObjetivoEducacional = idObjetivoEducacional;
    }

    public Integer getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(Integer idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Object getCicloRegistro() {
        return cicloRegistro;
    }

    public void setCicloRegistro(Object cicloRegistro) {
        this.cicloRegistro = cicloRegistro;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

}
