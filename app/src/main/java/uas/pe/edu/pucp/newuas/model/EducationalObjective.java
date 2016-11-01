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
    @Expose
    @DatabaseField(id = true)
    private Integer idObjetivoEducacional;
    @SerializedName("IdEspecialidad")
    @Expose
    @DatabaseField
    private Integer idEspecialidad;
    @SerializedName("Numero")
    @Expose
    @DatabaseField
    private Integer numero;
    @SerializedName("Descripcion")
    @Expose
    @DatabaseField
    private String descripcion;
    @SerializedName("CicloRegistro")
    @Expose
    @DatabaseField
    private Object cicloRegistro;
    @SerializedName("Estado")
    @Expose
    private Integer estado;

    /**
     * No args constructor for use in serialization
     *
     */
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

    /**
     *
     * @return
     * The idObjetivoEducacional
     */
    public Integer getIdObjetivoEducacional() {
        return idObjetivoEducacional;
    }

    /**
     *
     * @param idObjetivoEducacional
     * The IdObjetivoEducacional
     */
    public void setIdObjetivoEducacional(Integer idObjetivoEducacional) {
        this.idObjetivoEducacional = idObjetivoEducacional;
    }

    /**
     *
     * @return
     * The idEspecialidad
     */
    public Integer getIdEspecialidad() {
        return idEspecialidad;
    }

    /**
     *
     * @param idEspecialidad
     * The IdEspecialidad
     */
    public void setIdEspecialidad(Integer idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    /**
     *
     * @return
     * The numero
     */
    public Integer getNumero() {
        return numero;
    }

    /**
     *
     * @param numero
     * The Numero
     */
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    /**
     *
     * @return
     * The descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     *
     * @param descripcion
     * The Descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     *
     * @return
     * The cicloRegistro
     */
    public Object getCicloRegistro() {
        return cicloRegistro;
    }

    /**
     *
     * @param cicloRegistro
     * The CicloRegistro
     */
    public void setCicloRegistro(Object cicloRegistro) {
        this.cicloRegistro = cicloRegistro;
    }


    /**
     *
     * @return
     * The estado
     */
    public Integer getEstado() {
        return estado;
    }

    /**
     *
     * @param estado
     * The Estado
     */
    public void setEstado(Integer estado) {
        this.estado = estado;
    }

}
