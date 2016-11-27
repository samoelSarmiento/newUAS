package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Franz on 04/11/2016.
 */

public class PSPGrade implements Serializable{

    private int idStudent;
    @SerializedName("nota")
    private
    int nota;
    private PSPCriterio criterio;

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public PSPCriterio getCriterio() {
        return criterio;
    }

    public void setCriterio(PSPCriterio criterio) {
        this.criterio = criterio;
    }
}
