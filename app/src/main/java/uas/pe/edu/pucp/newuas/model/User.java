package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by samoe on 20/10/2016.
 */

public class User {

    @SerializedName("IdUsuario")
    private int idUsuario;

    @SerializedName("IdPerfil")
    private int idPerfil;

    @SerializedName("Usuario")
    private String usuario;

    @SerializedName("accreditor")
    private Accreditor accreditor;

    @SerializedName("teacher")
    private Teacher teacher;

    @SerializedName("investigator")
    private Investigator investigator;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Accreditor getAccreditor() {
        return accreditor;
    }

    public void setAccreditor(Accreditor accreditor) {
        this.accreditor = accreditor;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Investigator getInvestigator() {
        return investigator;
    }

    public void setInvestigator(Investigator investigator) {
        this.investigator = investigator;
    }
}
