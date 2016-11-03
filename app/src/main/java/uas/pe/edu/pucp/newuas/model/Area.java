package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by Andree on 24/10/2016.
 */

@DatabaseTable(tableName = "area")
public class Area implements Serializable {

    @SerializedName("id")
    @DatabaseField(id = true)
    private Integer id;

    @SerializedName("nombre")
    @DatabaseField
    private String nombre;

    @SerializedName("descripcion")
    @DatabaseField
    private String descripcion;

    public Area() {
    }

    public Area(Integer id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
