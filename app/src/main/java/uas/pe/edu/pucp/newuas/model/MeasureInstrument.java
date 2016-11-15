package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by Marshall on 25/10/2016.
 */

@DatabaseTable(tableName = "measureinstrument")
public class MeasureInstrument implements Serializable {
    @SerializedName("IdFuenteMedicion")
    @DatabaseField(id = true)
    private Integer idFuenteMedicion;

    @SerializedName("IdEspecialidad")
    @DatabaseField
    private Integer idEspecialidad;

    @SerializedName("Nombre")
    @DatabaseField
    private String nombre;

    @DatabaseField(columnName = "idPeriodo")
    private int idPeriodo;

    public MeasureInstrument() {
    }

    public MeasureInstrument(Integer idFuenteMedicion, Integer idEspecialidad, String nombre) {
        this.idFuenteMedicion = idFuenteMedicion;
        this.idEspecialidad = idEspecialidad;
        this.nombre = nombre;
    }

    public Integer getIdFuenteMedicion() {
        return idFuenteMedicion;
    }

    public void setIdFuenteMedicion(Integer idFuenteMedicion) {
        this.idFuenteMedicion = idFuenteMedicion;
    }

    public Integer getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(Integer idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(int idPeriodo) {
        this.idPeriodo = idPeriodo;
    }
}
