package uas.pe.edu.pucp.newuas.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Marshall on 23/10/2016.
 */

@DatabaseTable(tableName = "period")
public class Period implements Serializable {

    @SerializedName("IdPeriodo")
    @DatabaseField(id = true)
    private Integer idPeriodo;

    @SerializedName("IdEspecialidad")
    @DatabaseField
    private Integer idEspecialidad;

    @SerializedName("Vigente")
    @DatabaseField
    private Integer vigente;

    @SerializedName("configuration")
    @DatabaseField(foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true)
    private ConfSpeciality configuration;

    public Integer getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(Integer idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public Integer getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(Integer idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public Integer getVigente() {
        return vigente;
    }

    public void setVigente(Integer vigente) {
        this.vigente = vigente;
    }

    public ConfSpeciality getConfiguration() {
        return configuration;
    }

    public void setConfiguration(ConfSpeciality configuration) {
        this.configuration = configuration;
    }
}
