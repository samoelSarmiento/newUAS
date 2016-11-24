package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wingerlion on 23/11/2016.
 */
public class CitaInfoResponse implements Serializable {

    @SerializedName("id")
    private Integer id;
    @SerializedName("inicio")
    private String inicio;
    @SerializedName("fin")
    private String fin;
    @SerializedName("duracion")
    private Integer duracion;
    @SerializedName("no_programada")
    private Integer noProgramada;
    @SerializedName("observacion")
    private String observacion;
    @SerializedName("lugar")
    private String lugar;
    @SerializedName("adicional")
    private String   adicional;
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
    private String updatedAt;
    @SerializedName("studentInfo")
    private List<StudentInfoResponse> studentInfo = new ArrayList<StudentInfoResponse>();

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
    public String getFin() {
        return fin;
    }

    /**
     *
     * @param fin
     * The fin
     */
    public void setFin(String fin) {
        this.fin = fin;
    }

    /**
     *
     * @return
     * The duracion
     */
    public Integer getDuracion() {
        return duracion;
    }

    /**
     *
     * @param duracion
     * The duracion
     */
    public void setDuracion(Integer duracion) {
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
    public String getObservacion() {
        return observacion;
    }

    /**
     *
     * @param observacion
     * The observacion
     */
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    /**
     *
     * @return
     * The lugar
     */
    public String getLugar() {
        return lugar;
    }

    /**
     *
     * @param lugar
     * The lugar
     */
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    /**
     *
     * @return
     * The adicional
     */
    public String getAdicional() {
        return adicional;
    }

    /**
     *
     * @param adicional
     * The adicional
     */
    public void setAdicional(String adicional) {
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
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     *
     * @param updatedAt
     * The updated_at
     */
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     *
     * @return
     * The studentInfo
     */
    public List<StudentInfoResponse> getStudentInfo() {
        return studentInfo;
    }

    /**
     *
     * @param studentInfo
     * The studentInfo
     */
    public void setStudentInfo(List<StudentInfoResponse> studentInfo) {
        this.studentInfo = studentInfo;
    }
}
