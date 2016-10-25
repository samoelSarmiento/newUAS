package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Marshall on 23/10/2016.
 */

public class ConfSpeciality implements Serializable {

    @SerializedName("IdConfEspecialidad")
    @Expose
    private Integer idConfEspecialidad;
    @SerializedName("IdEspecialidad")
    @Expose
    private Integer idEspecialidad;
    @SerializedName("IdPeriodo")
    @Expose
    private Integer idPeriodo;
    @SerializedName("IdCicloInicio")
    @Expose
    private Integer idCicloInicio;
    @SerializedName("IdCicloFin")
    @Expose
    private Integer idCicloFin;
    @SerializedName("UmbralAceptacion")
    @Expose
    private Integer umbralAceptacion;
    @SerializedName("NivelEsperado")
    @Expose
    private Integer nivelEsperado;
    @SerializedName("CantNivelCriterio")
    @Expose
    private Integer cantNivelCriterio;
    @SerializedName("cycle_academic_start")
    private Semester cycleAcademicStart;
    @SerializedName("cycle_academic_end")
    private Semester cycleAcademicEnd;

    public ConfSpeciality() {
    }

    /**
     *
     * @param cycleAcademicStart
     * @param cantNivelCriterio
     * @param idPeriodo
     * @param updatedAt
     * @param idCicloFin
     * @param idCicloInicio
     * @param createdAt
     * @param cycleAcademicEnd
     * @param umbralAceptacion
     * @param deletedAt
     * @param nivelEsperado
     * @param idEspecialidad
     * @param idConfEspecialidad
     */
    public ConfSpeciality(Integer idConfEspecialidad, Integer idEspecialidad, Integer idPeriodo, Integer idCicloInicio, Integer idCicloFin, Integer umbralAceptacion, Integer nivelEsperado, Integer cantNivelCriterio, Object deletedAt, String createdAt, String updatedAt, Semester cycleAcademicStart, Semester cycleAcademicEnd) {
        this.idConfEspecialidad = idConfEspecialidad;
        this.idEspecialidad = idEspecialidad;
        this.idPeriodo = idPeriodo;
        this.idCicloInicio = idCicloInicio;
        this.idCicloFin = idCicloFin;
        this.umbralAceptacion = umbralAceptacion;
        this.nivelEsperado = nivelEsperado;
        this.cantNivelCriterio = cantNivelCriterio;
        this.setCycleAcademicStart(cycleAcademicStart);
        this.setCycleAcademicEnd(cycleAcademicEnd);
    }

    /**
     *
     * @return
     * The idConfEspecialidad
     */
    public Integer getIdConfEspecialidad() {
        return idConfEspecialidad;
    }

    /**
     *
     * @param idConfEspecialidad
     * The IdConfEspecialidad
     */
    public void setIdConfEspecialidad(Integer idConfEspecialidad) {
        this.idConfEspecialidad = idConfEspecialidad;
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
     * The idCicloInicio
     */
    public Integer getIdCicloInicio() {
        return idCicloInicio;
    }

    /**
     *
     * @param idCicloInicio
     * The IdCicloInicio
     */
    public void setIdCicloInicio(Integer idCicloInicio) {
        this.idCicloInicio = idCicloInicio;
    }

    /**
     *
     * @return
     * The idCicloFin
     */
    public Integer getIdCicloFin() {
        return idCicloFin;
    }

    /**
     *
     * @param idCicloFin
     * The IdCicloFin
     */
    public void setIdCicloFin(Integer idCicloFin) {
        this.idCicloFin = idCicloFin;
    }

    /**
     *
     * @return
     * The umbralAceptacion
     */
    public Integer getUmbralAceptacion() {
        return umbralAceptacion;
    }

    /**
     *
     * @param umbralAceptacion
     * The UmbralAceptacion
     */
    public void setUmbralAceptacion(Integer umbralAceptacion) {
        this.umbralAceptacion = umbralAceptacion;
    }

    /**
     *
     * @return
     * The nivelEsperado
     */
    public Integer getNivelEsperado() {
        return nivelEsperado;
    }

    /**
     *
     * @param nivelEsperado
     * The NivelEsperado
     */
    public void setNivelEsperado(Integer nivelEsperado) {
        this.nivelEsperado = nivelEsperado;
    }

    /**
     *
     * @return
     * The cantNivelCriterio
     */
    public Integer getCantNivelCriterio() {
        return cantNivelCriterio;
    }

    /**
     *
     * @param cantNivelCriterio
     * The CantNivelCriterio
     */
    public void setCantNivelCriterio(Integer cantNivelCriterio) {
        this.cantNivelCriterio = cantNivelCriterio;
    }

    public Semester getCycleAcademicStart() {
        return cycleAcademicStart;
    }

    public void setCycleAcademicStart(Semester cycleAcademicStart) {
        this.cycleAcademicStart = cycleAcademicStart;
    }

    public Semester getCycleAcademicEnd() {
        return cycleAcademicEnd;
    }

    public void setCycleAcademicEnd(Semester cycleAcademicEnd) {
        this.cycleAcademicEnd = cycleAcademicEnd;
    }
}
