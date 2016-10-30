package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Franz on 28/10/2016.
 */

public class Status {
    @SerializedName("IdTipoEstado")
    int idStatus;
    @SerializedName("descripcion")
    String description;
}
