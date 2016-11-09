package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by samoe on 04/11/2016.
 */

@DatabaseTable(tableName = "suggestion")
public class Suggestion implements Serializable{

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private int idImprPlan;

    @SerializedName("name")
    @DatabaseField
    private String nombre;

    @SerializedName("created")
    @DatabaseField
    private String creado;

    @SerializedName("updated")
    @DatabaseField
    private String modificado;

    @SerializedName("title")
    @DatabaseField
    private String titulo;

    @SerializedName("description")
    @DatabaseField
    private String descripcion;

    public Suggestion() {
    }

    public String getModificado() {
        return modificado;
    }

    public void setModificado(String modificado) {
        this.modificado = modificado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdImprPlan() {
        return idImprPlan;
    }

    public void setIdImprPlan(int idImprPlan) {
        this.idImprPlan = idImprPlan;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCreado() {
        return creado;
    }

    public void setCreado(String creado) {
        this.creado = creado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
