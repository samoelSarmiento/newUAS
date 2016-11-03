package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Franz on 28/10/2016.
 */

@DatabaseTable(tableName = "status")
public class Status {
    @SerializedName("IdTipoEstado")
    @DatabaseField(id = true)
    Integer idStatus;

    @SerializedName("descripcion")
    @DatabaseField
    String description;

    public Status() {
    }

    public Status(String description, Integer idStatus) {
        this.description = description;
        this.idStatus = idStatus;
    }

    public Integer getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Integer idStatus) {
        this.idStatus = idStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
