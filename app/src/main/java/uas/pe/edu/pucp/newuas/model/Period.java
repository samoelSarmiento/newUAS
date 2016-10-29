package uas.pe.edu.pucp.newuas.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Marshall on 23/10/2016.
 */

public class Period implements Serializable {

    @SerializedName("IdPeriodo")
    private Integer idPeriodo;

    @SerializedName("IdEspecialidad")
    private Integer idEspecialidad;

    @SerializedName("Vigente")
    private Integer vigente;

    @SerializedName("semesters")
    private List<Semester> semesters;

    @SerializedName("configuration")
    private ConfSpeciality configuration;

    public Integer getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(Integer idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public Integer getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(Integer idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public Integer getVigente() {
        return vigente;
    }

    public void setVigente(Integer vigente) {
        this.vigente = vigente;
    }

    public List<Semester> getSemesters() {
        return semesters;
    }

    public void setSemesters(List<Semester> semesters) {
        this.semesters = semesters;
    }

    public ConfSpeciality getConfiguration() {
        return configuration;
    }

    public void setConfiguration(ConfSpeciality configuration) {
        this.configuration = configuration;
    }
}
