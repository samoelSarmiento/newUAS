package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by Andree on 24/10/2016.
 */

@DatabaseTable(tableName = "faculty")
public class Faculty implements Serializable {

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
    //@DatabaseField
    private Integer idDocente;

    public Faculty() {
    }

    public Faculty(Integer idEspecialidad, String codigo, String nombre, String descripcion, Integer idDocente) {
        this.idEspecialidad = idEspecialidad;
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.idDocente = idDocente;
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
}
