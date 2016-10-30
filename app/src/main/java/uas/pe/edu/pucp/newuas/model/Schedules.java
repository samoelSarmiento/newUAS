package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by samoe on 20/10/2016.
 */
public class Schedules implements Serializable {
    @SerializedName("IdHorario")
    private int idHorario;

    @SerializedName("IdCursoxCiclo")
    private int idCursoxCiclo;

    @SerializedName("Codigo")
    private String codigo;

    @SerializedName("TotalAlumnos")
    private int totalalumnos;

    private ArrayList<Teacher> professors;

    private ArrayList<CoursesEvidences> evidences;

    public ArrayList<CoursesEvidences> getEvidences() {
        return evidences;
    }

    public void setEvidences(ArrayList<CoursesEvidences> evidences) {
        this.evidences = evidences;
    }

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public int getIdCursoxCiclo() {
        return idCursoxCiclo;
    }

    public void setIdCursoxCiclo(int idCursoxCiclo) {
        this.idCursoxCiclo = idCursoxCiclo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getTotalalumnos() {
        return totalalumnos;
    }

    public void setTotalalumnos(int totalalumnos) {
        this.totalalumnos = totalalumnos;
    }

    public ArrayList<Teacher> getProfessors() {
        return professors;
    }

    public void setProfessors(ArrayList<Teacher> professors) {
        this.professors = professors;
    }
}
