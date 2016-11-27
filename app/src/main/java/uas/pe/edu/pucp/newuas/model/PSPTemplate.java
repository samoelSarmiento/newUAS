package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Franz on 28/10/2016.
 */

public class PSPTemplate implements Serializable {
    @SerializedName("IdTemplate")
    private
    int IdTemplate;
    @SerializedName("IdPhase")
    private
    int IdPhase;

    @SerializedName("titulo")
    private
    String titulo;

    @SerializedName("IdTipoEstado")
    private
    int idTipoEstado;
    @SerializedName("ruta")
    private
    String ruta;
    @SerializedName("IdProfesor")
    private
    int idProfesor;
    @SerializedName("IdAdmin")
    private
    int idAdmin;
    @SerializedName("IdSupervisor")
    private
    int idSupervisor;

    public int getIdTemplate() {
        return IdTemplate;
    }

    public void setIdTemplate(int idTemplate) {
        IdTemplate = idTemplate;
    }

    public int getIdPhase() {
        return IdPhase;
    }

    public void setIdPhase(int idPhase) {
        IdPhase = idPhase;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getIdTipoEstado() {
        return idTipoEstado;
    }

    public void setIdTipoEstado(int idTipoEstado) {
        this.idTipoEstado = idTipoEstado;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public int getIdSupervisor() {
        return idSupervisor;
    }

    public void setIdSupervisor(int idSupervisor) {
        this.idSupervisor = idSupervisor;
    }
}
