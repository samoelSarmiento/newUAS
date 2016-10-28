package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by Marshall on 20/10/2016.
 */

@DatabaseTable(tableName = "specialty")
public class Specialty implements Serializable {

    @SerializedName("IdEspecialidad")
    @DatabaseField(id = true)
    private Integer idEspecialidad;

    @SerializedName("Codigo")
    @DatabaseField
    private String codigo;

    @SerializedName("Nombre")
    @DatabaseField
    private String nombre;

    @SerializedName("Descripcion")
    @DatabaseField
    private String descripcion;

    @SerializedName("IdDocente")
    @DatabaseField
    private Integer idDocente;

    @SerializedName("coordinator")
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Teacher coordinator;

    public Specialty() {
    }

    public Specialty(Integer idEspecialidad, String codigo, String nombre, String descripcion, Object deletedAt, String createdAt, String updatedAt, Integer idDocente, Teacher coordinator) {
        this.idEspecialidad = idEspecialidad;
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.idDocente = idDocente;
        this.setCoordinator(coordinator);
    }

    public Integer getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(Integer idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(Integer idDocente) {
        this.idDocente = idDocente;
    }

    public Teacher getCoordinator() {
        return coordinator;
    }

    public void setCoordinator(Teacher coordinator) {
        this.coordinator = coordinator;
    }
}
