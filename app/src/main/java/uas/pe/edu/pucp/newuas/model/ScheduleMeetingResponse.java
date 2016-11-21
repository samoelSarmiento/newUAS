package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Wingerlion on 20/11/2016.
 */
public class ScheduleMeetingResponse {
    @SerializedName("id")
    private Integer id;
    @SerializedName("inicio")
    private String inicio;
    @SerializedName("fin")
    private Object fin;
    @SerializedName("duracion")
    private Object duracion;
    @SerializedName("no_programada")
    private Integer noProgramada;
    @SerializedName("observacion")
    private Object observacion;
    @SerializedName("lugar")
    private Object lugar;
    @SerializedName("adicional")
    private Object adicional;
    @SerializedName("creador")
    private Integer creador;
    @SerializedName("estado")
    private Integer estado;
    @SerializedName("id_topic")
    private Integer idTopic;
    @SerializedName("id_reason")
    private Object idReason;
    @SerializedName("id_tutstudent")
    private Integer idTutstudent;
    @SerializedName("id_docente")
    private Integer idDocente;
    @SerializedName("created_at")
    private Object createdAt;
    @SerializedName("updated_at")
    private Object updatedAt;

    /**
     *
     * @return
     * The id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The inicio
     */
    public String getInicio() {
        return inicio;
    }

    /**
     *
     * @param inicio
     * The inicio
     */
    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    /**
     *
     * @return
     * The fin
     */
    public Object getFin() {
        return fin;
    }

    /**
     *
     * @param fin
     * The fin
     */
    public void setFin(Object fin) {
        this.fin = fin;
    }

    /**
     *
     * @return
     * The duracion
     */
    public Object getDuracion() {
        return duracion;
    }

    /**
     *
     * @param duracion
     * The duracion
     */
    public void setDuracion(Object duracion) {
        this.duracion = duracion;
    }

    /**
     *
     * @return
     * The noProgramada
     */
    public Integer getNoProgramada() {
        return noProgramada;
    }

    /**
     *
     * @param noProgramada
     * The no_programada
     */
    public void setNoProgramada(Integer noProgramada) {
        this.noProgramada = noProgramada;
    }

    /**
     *
     * @return
     * The observacion
     */
    public Object getObservacion() {
        return observacion;
    }

    /**
     *
     * @param observacion
     * The observacion
     */
    public void setObservacion(Object observacion) {
        this.observacion = observacion;
    }

    /**
     *
     * @return
     * The lugar
     */
    public Object getLugar() {
        return lugar;
    }

    /**
     *
     * @param lugar
     * The lugar
     */
    public void setLugar(Object lugar) {
        this.lugar = lugar;
    }

    /**
     *
     * @return
     * The adicional
     */
    public Object getAdicional() {
        return adicional;
    }

    /**
     *
     * @param adicional
     * The adicional
     */
    public void setAdicional(Object adicional) {
        this.adicional = adicional;
    }

    /**
     *
     * @return
     * The creador
     */
    public Integer getCreador() {
        return creador;
    }

    /**
     *
     * @param creador
     * The creador
     */
    public void setCreador(Integer creador) {
        this.creador = creador;
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
     * The estado
     */
    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    /**
     *
     * @return
     * The idTopic
     */
    public Integer getIdTopic() {
        return idTopic;
    }

    /**
     *
     * @param idTopic
     * The id_topic
     */
    public void setIdTopic(Integer idTopic) {
        this.idTopic = idTopic;
    }

    /**
     *
     * @return
     * The idReason
     */
    public Object getIdReason() {
        return idReason;
    }

    /**
     *
     * @param idReason
     * The id_reason
     */
    public void setIdReason(Object idReason) {
        this.idReason = idReason;
    }

    /**
     *
     * @return
     * The idTutstudent
     */
    public Integer getIdTutstudent() {
        return idTutstudent;
    }

    /**
     *
     * @param idTutstudent
     * The id_tutstudent
     */
    public void setIdTutstudent(Integer idTutstudent) {
        this.idTutstudent = idTutstudent;
    }

    /**
     *
     * @return
     * The idDocente
     */
    public Integer getIdDocente() {
        return idDocente;
    }

    /**
     *
     * @param idDocente
     * The id_docente
     */
    public void setIdDocente(Integer idDocente) {
        this.idDocente = idDocente;
    }

    /**
     *
     * @return
     * The createdAt
     */
    public Object getCreatedAt() {
        return createdAt;
    }

    /**
     *
     * @param createdAt
     * The created_at
     */
    public void setCreatedAt(Object createdAt) {
        this.createdAt = createdAt;
    }

    /**
     *
     * @return
     * The updatedAt
     */
    public Object getUpdatedAt() {
        return updatedAt;
    }

    /**
     *
     * @param updatedAt
     * The updated_at
     */
    public void setUpdatedAt(Object updatedAt) {
        this.updatedAt = updatedAt;
    }
}
