package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by Andree on 20/11/2016.
 */

@DatabaseTable(tableName = "invDocument")
public class InvDocument implements Serializable{

    @SerializedName("id")
    @DatabaseField(id = true)
    private Integer id;

    @SerializedName("observacion")
    @DatabaseField
    private String observacion;

    @SerializedName("id_investigador")
    @DatabaseField(foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true)
    private Integer idInvestigador;

    @SerializedName("ruta")
    @DatabaseField
    private String ruta;

    @SerializedName("version")
    @DatabaseField
    private Integer version;

    @SerializedName("id_entregable")
    @DatabaseField(foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true)
    private Integer idEntregable;

    public InvDocument() {
    }

    public InvDocument(Integer id, String observacion, Integer idInvestigador, String ruta, Integer version, Integer idEntregable) {
        this.id = id;
        this.observacion = observacion;
        this.idInvestigador = idInvestigador;
        this.ruta = ruta;
        this.version = version;
        this.idEntregable = idEntregable;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Integer getIdInvestigador() {
        return idInvestigador;
    }

    public void setIdInvestigador(Integer idInvestigador) {
        this.idInvestigador = idInvestigador;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getIdEntregable() {
        return idEntregable;
    }

    public void setIdEntregable(Integer idEntregable) {
        this.idEntregable = idEntregable;
    }
}
