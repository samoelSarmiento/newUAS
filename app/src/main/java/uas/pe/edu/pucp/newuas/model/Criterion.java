package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by Marshall on 4/11/2016.
 */

@DatabaseTable(tableName="criterion")
public class Criterion implements Serializable {
    @SerializedName("IdCriterio")
    @Expose
    @DatabaseField(id=true)
    private Integer idCriterio;
    @SerializedName("IdAspecto")
    @Expose
    @DatabaseField
    private Integer idAspecto;
    @SerializedName("Nombre")
    @Expose
    @DatabaseField
    private String nombre;
    @SerializedName("Estado")
    @Expose
    @DatabaseField
    private Integer estado;

    /**
     * No args constructor for use in serialization
     *
     */
    public Criterion() {
    }

    /**
     *

     * @param nombre
     * @param idCriterio
     * @param estado
     * @param idAspecto
     */
    public Criterion(Integer idCriterio, Integer idAspecto, String nombre,  Integer estado) {
        this.idCriterio = idCriterio;
        this.idAspecto = idAspecto;
        this.nombre = nombre;
        this.estado = estado;
    }

    /**
     *
     * @return
     * The idCriterio
     */
    public Integer getIdCriterio() {
        return idCriterio;
    }

    /**
     *
     * @param idCriterio
     * The IdCriterio
     */
    public void setIdCriterio(Integer idCriterio) {
        this.idCriterio = idCriterio;
    }

    /**
     *
     * @return
     * The idAspecto
     */
    public Integer getIdAspecto() {
        return idAspecto;
    }

    /**
     *
     * @param idAspecto
     * The IdAspecto
     */
    public void setIdAspecto(Integer idAspecto) {
        this.idAspecto = idAspecto;
    }

    /**
     *
     * @return
     * The nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     * The Nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
