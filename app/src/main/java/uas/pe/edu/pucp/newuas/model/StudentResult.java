package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by samoe on 01/11/2016.
 */

@DatabaseTable(tableName = "studentresults")
public class StudentResult implements Serializable {

    @SerializedName("IdResultadoEstudiantil")
    @DatabaseField(id = true)
    private int idResultadoEstudiantil;

    @DatabaseField
    private int idObjetivoEduacional;

    @SerializedName("IdEspecialidad")
    @DatabaseField
    private int idEspecialidad;

    @SerializedName("Identificador")
    @DatabaseField
    private String identificador;

    @SerializedName("Descripcion")
    @DatabaseField
    private String descripcion;

    @SerializedName("Estado")
    @DatabaseField
    private int estado;

    public StudentResult() {
    }

    public int getIdObjetivoEduacional() {
        return idObjetivoEduacional;
    }

    public void setIdObjetivoEduacional(int idObjetivoEduacional) {
        this.idObjetivoEduacional = idObjetivoEduacional;
    }

    public int getIdResultadoEstudiantil() {
        return idResultadoEstudiantil;
    }

    public void setIdResultadoEstudiantil(int idResultadoEstudiantil) {
        this.idResultadoEstudiantil = idResultadoEstudiantil;
    }

    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
