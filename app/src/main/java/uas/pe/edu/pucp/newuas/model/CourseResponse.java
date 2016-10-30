package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by samoe on 20/10/2016.
 */

public class CourseResponse implements Serializable {

    @SerializedName("IdCurso")
    private int idCurso;

    @SerializedName("IdEspecialidad")
    private int idEspecialidad;

    @SerializedName("NivelAcademico")
    private int nivelAcademico;

    @SerializedName("Codigo")
    private String codigo;

    @SerializedName("Nombre")
    private String nombre;

    private ArrayList<Schedules> schedules = new ArrayList<Schedules>();

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public int getNivelAcademico() {
        return nivelAcademico;
    }

    public void setNivelAcademico(int nivelAcademico) {
        this.nivelAcademico = nivelAcademico;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Schedules> getSchedules() {
        return schedules;
    }

    public void setSchedules(ArrayList<Schedules> schedules) {
        this.schedules = schedules;
    }

}
