package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by samoe on 20/10/2016.
 */
@DatabaseTable(tableName = "schedule")
public class Schedule implements Serializable {
    @SerializedName("IdHorario")
    @DatabaseField(id = true, columnName = "schedule_id")
    private int idHorario;

    @DatabaseField(columnName = "course_id")
    private int idCurso;

    @DatabaseField
    private int idCicloAcademico;

    @SerializedName("IdCursoxCiclo")
    @DatabaseField
    private int idCursoxCiclo;

    @SerializedName("Codigo")
    @DatabaseField
    private String codigo;

    @SerializedName("TotalAlumnos")
    @DatabaseField
    private int totalalumnos;

    private List<FileGen> course_evidences;

    public Schedule() {
    }

    public int getIdCiclo() {
        return idCicloAcademico;
    }

    public void setIdCiclo(int idCiclo) {
        this.idCicloAcademico = idCiclo;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    private List<Teacher> professors;

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

    public List<Teacher> getProfessors() {
        return professors;
    }

    public void setProfessors(List<Teacher> professors) {
        this.professors = professors;
    }

    public List<FileGen> getCourse_evidences() {
        return course_evidences;
    }

    public void setCourse_evidences(List<FileGen> course_evidences) {
        this.course_evidences = course_evidences;
    }
}
