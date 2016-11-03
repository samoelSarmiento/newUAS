package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by Marshall on 2/11/2016.
 */

@DatabaseTable(tableName="action")
public class Action implements Serializable{

    @SerializedName("IdPlanAccion")
    @Expose
    @DatabaseField(id=true)
    private Integer idPlanAccion;
    @SerializedName("IdPlanMejora")
    @Expose
    @DatabaseField
    private Integer idPlanMejora;
    @SerializedName("IdCicloAcademico")
    @Expose
    @DatabaseField
    private Integer idCicloAcademico;
    @SerializedName("IdDocente")
    @Expose
    @DatabaseField
    private Object idDocente;
    @SerializedName("Comentario")
    @Expose
    @DatabaseField
    private Object comentario;
    @SerializedName("Descripcion")
    @Expose
    @DatabaseField
    private String descripcion;
    @SerializedName("IdArchivoEntrada")
    @Expose
    @DatabaseField
    private Object idArchivoEntrada;
    @SerializedName("Porcentaje")
    @Expose
    @DatabaseField
    private Object porcentaje;
    @SerializedName("Estado")
    @Expose
    @DatabaseField
    private Object estado;

    /**
     * No args constructor for use in serialization
     *
     */
    public Action() {
    }

    /**
     *
     * @param porcentaje

     * @param idPlanAccion
     * @param estado
     * @param idDocente
     * @param idArchivoEntrada
     * @param idPlanMejora
     * @param descripcion
     * @param idCicloAcademico
     * @param comentario
     */
    public Action(Integer idPlanAccion, Integer idPlanMejora, Integer idCicloAcademico, Object idDocente, Object comentario, String descripcion,  Object idArchivoEntrada, Object porcentaje, Object estado) {
        this.idPlanAccion = idPlanAccion;
        this.idPlanMejora = idPlanMejora;
        this.idCicloAcademico = idCicloAcademico;
        this.idDocente = idDocente;
        this.comentario = comentario;
        this.descripcion = descripcion;

        this.idArchivoEntrada = idArchivoEntrada;
        this.porcentaje = porcentaje;
        this.estado = estado;
    }

    /**
     *
     * @return
     * The idPlanAccion
     */
    public Integer getIdPlanAccion() {
        return idPlanAccion;
    }

    /**
     *
     * @param idPlanAccion
     * The IdPlanAccion
     */
    public void setIdPlanAccion(Integer idPlanAccion) {
        this.idPlanAccion = idPlanAccion;
    }

    /**
     *
     * @return
     * The idPlanMejora
     */
    public Integer getIdPlanMejora() {
        return idPlanMejora;
    }

    /**
     *
     * @param idPlanMejora
     * The IdPlanMejora
     */
    public void setIdPlanMejora(Integer idPlanMejora) {
        this.idPlanMejora = idPlanMejora;
    }

    /**
     *
     * @return
     * The idCicloAcademico
     */
    public Integer getIdCicloAcademico() {
        return idCicloAcademico;
    }

    /**
     *
     * @param idCicloAcademico
     * The IdCicloAcademico
     */
    public void setIdCicloAcademico(Integer idCicloAcademico) {
        this.idCicloAcademico = idCicloAcademico;
    }

    /**
     *
     * @return
     * The idDocente
     */
    public Object getIdDocente() {
        return idDocente;
    }

    /**
     *
     * @param idDocente
     * The IdDocente
     */
    public void setIdDocente(Object idDocente) {
        this.idDocente = idDocente;
    }

    /**
     *
     * @return
     * The comentario
     */
    public Object getComentario() {
        return comentario;
    }

    /**
     *
     * @param comentario
     * The Comentario
     */
    public void setComentario(Object comentario) {
        this.comentario = comentario;
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
     * The idArchivoEntrada
     */
    public Object getIdArchivoEntrada() {
        return idArchivoEntrada;
    }

    /**
     *
     * @param idArchivoEntrada
     * The IdArchivoEntrada
     */
    public void setIdArchivoEntrada(Object idArchivoEntrada) {
        this.idArchivoEntrada = idArchivoEntrada;
    }

    /**
     *
     * @return
     * The porcentaje
     */
    public Object getPorcentaje() {
        return porcentaje;
    }

    /**
     *
     * @param porcentaje
     * The Porcentaje
     */
    public void setPorcentaje(Object porcentaje) {
        this.porcentaje = porcentaje;
    }

    /**
     *
     * @return
     * The estado
     */
    public Object getEstado() {
        return estado;
    }

    /**
     *
     * @param estado
     * The Estado
     */
    public void setEstado(Object estado) {
        this.estado = estado;
    }

}
