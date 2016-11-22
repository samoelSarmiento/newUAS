package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by samoe on 20/11/2016.
 */

public class StudentEffort implements Serializable {
    @SerializedName("IdCalificacion")
    private int idCalificacion;

    @SerializedName("IdCriterio")
    private int idCriterio;

    @SerializedName("IdHorario")
    private int idHorario;

    @SerializedName("IdAlumno")
    private int idAlumno;

    @SerializedName("Nota")
    private int nota;

    @SerializedName("criterion")
    private Criterion criterion;

    public StudentEffort() {
    }

    public int getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(int idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    public int getIdCriterio() {
        return idCriterio;
    }

    public void setIdCriterio(int idCriterio) {
        this.idCriterio = idCriterio;
    }

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public Criterion getCriterion() {
        return criterion;
    }

    public void setCriterion(Criterion criterion) {
        this.criterion = criterion;
    }
}
