package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by samoe on 20/10/2016.
 */

@DatabaseTable(tableName = "course")
public class CourseResponse implements Serializable {

    @SerializedName("IdCurso")
    @DatabaseField(id = true, columnName = "course_id")
    private int idCurso;

    @DatabaseField
    private int idAcademicCycle;

    @DatabaseField
    private int idDocente;

    @SerializedName("IdEspecialidad")
    @DatabaseField
    private int idEspecialidad;

    @SerializedName("NivelAcademico")
    @DatabaseField
    private int nivelAcademico;

    @SerializedName("Codigo")
    @DatabaseField
    private String codigo;

    @SerializedName("Nombre")
    @DatabaseField
    private String nombre;

    public CourseResponse() {
    }

    public int getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    public int getIdAcademicCycle() {
        return idAcademicCycle;
    }

    public void setIdAcademicCycle(int idAcademicCycle) {
        this.idAcademicCycle = idAcademicCycle;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    private List<Schedule> schedules = new ArrayList<Schedule>();

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

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(ArrayList<Schedule> schedules) {
        this.schedules = schedules;
    }

}
