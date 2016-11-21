package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Franz on 21/10/2016.
 */

public class PSPSupervisor implements Serializable {

    @SerializedName("nombres")
    private String name;

    @SerializedName("apellido_paterno")
    private String apellidoPaterno;

    @SerializedName("apellido_materno")
    private String apellidoMaterno;
    @SerializedName("id")
    private int idSupervisor;

    private String identifier;


    public String getName() {
        return name;
    }

    public void setNombre(String nombre) {
        this.name = nombre;
    }

    public String getCodigo() {
        return identifier;
    }

    public void setCodigo(String codigo) {
        this.identifier = codigo;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public int getIdSupervisor() {
        return idSupervisor;
    }

    public void setIdSupervisor(int idSupervisor) {
        this.idSupervisor = idSupervisor;
    }
}
