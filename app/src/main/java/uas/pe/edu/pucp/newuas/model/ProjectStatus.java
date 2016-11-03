package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by Andree on 25/10/2016.
 */


@DatabaseTable(tableName = "projectStatus")
public class ProjectStatus implements Serializable{

    @SerializedName("id")
    @DatabaseField(id = true)
    private Integer id;

    @SerializedName("nombre")
    @DatabaseField
    private String nombre;

    @SerializedName("tipo_estado")
    @DatabaseField
    private Integer tipoEstado;

    public ProjectStatus() {
    }

    public ProjectStatus(Integer id, String nombre, Integer tipoEstado) {
        this.id = id;
        this.nombre = nombre;
        this.tipoEstado = tipoEstado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getTipoEstado() {
        return tipoEstado;
    }

    public void setTipoEstado(Integer tipoEstado) {
        this.tipoEstado = tipoEstado;
    }

}
