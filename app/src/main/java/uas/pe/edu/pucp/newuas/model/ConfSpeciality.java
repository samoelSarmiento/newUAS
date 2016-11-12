package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by Marshall on 23/10/2016.
 */
@DatabaseTable(tableName = "confspecialty")
public class ConfSpeciality implements Serializable {

    @SerializedName("IdConfEspecialidad")
    @DatabaseField(id = true)
    private Integer idConfEspecialidad;

    @SerializedName("IdEspecialidad")
    @DatabaseField
    private Integer idEspecialidad;

    @SerializedName("IdPeriodo")
    @DatabaseField
    private Integer idPeriodo;

    @SerializedName("IdCicloInicio")
    @DatabaseField
    private Integer idCicloInicio;

    @SerializedName("IdCicloFin")
    @DatabaseField
    private Integer idCicloFin;

    @SerializedName("UmbralAceptacion")
    @DatabaseField
    private Integer umbralAceptacion;

    @SerializedName("NivelEsperado")
    @DatabaseField
    private Integer nivelEsperado;

    @SerializedName("CantNivelCriterio")
    @DatabaseField
    private Integer cantNivelCriterio;

    @SerializedName("cycle_academic_start")
    @DatabaseField(foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true)
    private Semester cycleAcademicStart;

    @SerializedName("cycle_academic_end")
    @DatabaseField(foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true)
    private Semester cycleAcademicEnd;

    public ConfSpeciality() {
    }

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

    public Integer getIdConfEspecialidad() {
        return idConfEspecialidad;
    }

    public void setIdConfEspecialidad(Integer idConfEspecialidad) {
        this.idConfEspecialidad = idConfEspecialidad;
    }

    public Integer getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(Integer idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public Integer getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(Integer idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public Integer getIdCicloInicio() {
        return idCicloInicio;
    }

    public void setIdCicloInicio(Integer idCicloInicio) {
        this.idCicloInicio = idCicloInicio;
    }

    public Integer getIdCicloFin() {
        return idCicloFin;
    }

    public void setIdCicloFin(Integer idCicloFin) {
        this.idCicloFin = idCicloFin;
    }

    public Integer getUmbralAceptacion() {
        return umbralAceptacion;
    }

    public void setUmbralAceptacion(Integer umbralAceptacion) {
        this.umbralAceptacion = umbralAceptacion;
    }

    public Integer getNivelEsperado() {
        return nivelEsperado;
    }

    public void setNivelEsperado(Integer nivelEsperado) {
        this.nivelEsperado = nivelEsperado;
    }

    public Integer getCantNivelCriterio() {
        return cantNivelCriterio;
    }

    public void setCantNivelCriterio(Integer cantNivelCriterio) {
        this.cantNivelCriterio = cantNivelCriterio;
    }

    public Semester getCycleAcademicStart() {
        return cycleAcademicStart;
    }

    private void setCycleAcademicStart(Semester cycleAcademicStart) {
        this.cycleAcademicStart = cycleAcademicStart;
    }

    public Semester getCycleAcademicEnd() {
        return cycleAcademicEnd;
    }

    private void setCycleAcademicEnd(Semester cycleAcademicEnd) {
        this.cycleAcademicEnd = cycleAcademicEnd;
    }
}
