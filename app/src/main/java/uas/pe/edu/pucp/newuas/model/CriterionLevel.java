package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by Marshall on 4/11/2016.
 */

@DatabaseTable(tableName="criterionlevel")
public class CriterionLevel implements Serializable{
    @SerializedName("IdNivelCriterio")
    @Expose
    @DatabaseField(id=true)
    private Integer idNivelCriterio;
    @SerializedName("IdCriterio")
    @Expose
    @DatabaseField
    private Integer idCriterio;
    @SerializedName("IdPeriodo")
    @Expose
    @DatabaseField
    private Integer idPeriodo;
    @SerializedName("Valor")
    @Expose
    @DatabaseField
    private Integer valor;
    @SerializedName("Descripcion")
    @Expose
    @DatabaseField
    private String descripcion;

    /**
     * No args constructor for use in serialization
     *
     */
    public CriterionLevel() {
    }

    /**
     *

     * @param idCriterio
     * @param valor

     * @param idNivelCriterio

     * @param descripcion
     * @param idPeriodo
     */
    public CriterionLevel(Integer idNivelCriterio, Integer idCriterio, Integer idPeriodo, Integer valor, String descripcion ) {
        this.idNivelCriterio = idNivelCriterio;
        this.idCriterio = idCriterio;
        this.idPeriodo = idPeriodo;
        this.valor = valor;
        this.descripcion = descripcion;
    }

    /**
     *
     * @return
     * The idNivelCriterio
     */
    public Integer getIdNivelCriterio() {
        return idNivelCriterio;
    }

    /**
     *
     * @param idNivelCriterio
     * The IdNivelCriterio
     */
    public void setIdNivelCriterio(Integer idNivelCriterio) {
        this.idNivelCriterio = idNivelCriterio;
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
     * The idPeriodo
     */
    public Integer getIdPeriodo() {
        return idPeriodo;
    }

    /**
     *
     * @param idPeriodo
     * The IdPeriodo
     */
    public void setIdPeriodo(Integer idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    /**
     *
     * @return
     * The valor
     */
    public Integer getValor() {
        return valor;
    }

    /**
     *
     * @param valor
     * The Valor
     */
    public void setValor(Integer valor) {
        this.valor = valor;
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


}
