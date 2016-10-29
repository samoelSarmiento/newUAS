package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Wingerlion on 27/10/2016.
 */
public class ScheduleInfoResponse {

    @SerializedName("id")
    private Integer id;
    @SerializedName("dia")
    private Integer dia;
    @SerializedName("hora_inicio")
    private String horaInicio;
    @SerializedName("hora_fin")
    private String horaFin;
    @SerializedName("id_docente")
    private Integer idDocente;
    @SerializedName("deleted_at")
    private Object deletedAt;
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
     * The dia
     */
    public Integer getDia() {
        return dia;
    }

    /**
     *
     * @param dia
     * The dia
     */
    public void setDia(Integer dia) {
        this.dia = dia;
    }

    /**
     *
     * @return
     * The horaInicio
     */
    public String getHoraInicio() {
        return horaInicio;
    }

    /**
     *
     * @param horaInicio
     * The hora_inicio
     */
    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     *
     * @return
     * The horaFin
     */
    public String getHoraFin() {
        return horaFin;
    }

    /**
     *
     * @param horaFin
     * The hora_fin
     */
    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
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
     * The deletedAt
     */
    public Object getDeletedAt() {
        return deletedAt;
    }

    /**
     *
     * @param deletedAt
     * The deleted_at
     */
    public void setDeletedAt(Object deletedAt) {
        this.deletedAt = deletedAt;
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
