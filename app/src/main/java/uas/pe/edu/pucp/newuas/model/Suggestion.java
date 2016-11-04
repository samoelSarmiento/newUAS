package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by samoe on 04/11/2016.
 */

@DatabaseTable(tableName = "suggestion")
public class Suggestion {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private int idImprPlan;

    @SerializedName("name")
    @DatabaseField
    private String nombre;

    @SerializedName("created")
    @DatabaseField
    private String fecha;

    @SerializedName("title")
    @DatabaseField
    private String titulo;

    @SerializedName("description")
    @DatabaseField
    private String descripcion;

    public Suggestion() {
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
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
