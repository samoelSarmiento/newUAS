package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by samoe on 02/11/2016.
 */

@DatabaseTable(tableName = "aspect")
public class Aspect implements Serializable {

    @SerializedName("IdAspecto")
    @DatabaseField(id = true)
    private int idAspecto;

    @SerializedName("IdResultadoEstudiantil")
    @DatabaseField
    private int idResultadoEstudiantil;

    @SerializedName("Nombre")
    @DatabaseField
    private String nombre;

    public Aspect() {

    }

    public int getIdAspecto() {
        return idAspecto;
    }

    public void setIdAspecto(int idAspecto) {
        this.idAspecto = idAspecto;
    }

    public int getIdResultadoEstudiantil() {
        return idResultadoEstudiantil;
    }

    public void setIdResultadoEstudiantil(int idResultadoEstudiantil) {
        this.idResultadoEstudiantil = idResultadoEstudiantil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
