package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Franz on 26/10/2016.
 */


public class PSPGroup implements Serializable {

    @SerializedName("id")
    private int idPspGroup;

    @SerializedName("numero")
    private String numero;

    @SerializedName("description")
    private String description;

    public PSPGroup(){

    }

    public int getIdGroup() {
        return idPspGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idPspGroup = idGroup;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
