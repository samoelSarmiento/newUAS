package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by Marshall on 2/11/2016.
 */

@DatabaseTable(tableName = "improvementplantype")
public class ImprovementPlanType implements Serializable{

    @SerializedName("IdTipoPlanMejora")
    @Expose
    @DatabaseField(id=true)
    private Integer idTipoPlanMejora;
    @SerializedName("IdEspecialidad")
    @Expose
    @DatabaseField
    private Integer idEspecialidad;
    @SerializedName("Codigo")
    @Expose
    @DatabaseField
    private String codigo;
    @SerializedName("Tema")
    @Expose
    @DatabaseField
    private String tema;
    @SerializedName("Descripcion")
    @Expose
    @DatabaseField
    private String descripcion;
    /**
     * No args constructor for use in serialization
     *
     */
    public ImprovementPlanType() {
    }

    /**
     *

     * @param codigo

     * @param descripcion
     * @param tema
     * @param idTipoPlanMejora
     * @param idEspecialidad
     */
    public ImprovementPlanType(Integer idTipoPlanMejora, Integer idEspecialidad, String codigo, String tema, String descripcion) {
        this.idTipoPlanMejora = idTipoPlanMejora;
        this.idEspecialidad = idEspecialidad;
        this.codigo = codigo;
        this.tema = tema;
        this.descripcion = descripcion;

    }

    /**
     *
     * @return
     * The idTipoPlanMejora
     */
    public Integer getIdTipoPlanMejora() {
        return idTipoPlanMejora;
    }

    /**
     *
     * @param idTipoPlanMejora
     * The IdTipoPlanMejora
     */
    public void setIdTipoPlanMejora(Integer idTipoPlanMejora) {
        this.idTipoPlanMejora = idTipoPlanMejora;
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
     * The codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     *
     * @param codigo
     * The Codigo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     *
     * @return
     * The tema
     */
    public String getTema() {
        return tema;
    }

    /**
     *
     * @param tema
     * The Tema
     */
    public void setTema(String tema) {
        this.tema = tema;
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

