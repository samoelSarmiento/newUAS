package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Franz on 28/11/2016.
 */

public class PSPProcess implements Serializable{
@SerializedName("id")
private
int idProcess;

    @SerializedName("numero_fases")
    private
    int nPhases;
    @SerializedName("numero_plantillas")
    private
    int nTemplates;
    @SerializedName("idespecialidad")
    private
    int idSpeciality;
    @SerializedName("idcurso")
    private
    int idCurso;
    @SerializedName("idCiclo")
    private
    int idCycle;
    @SerializedName("curso")
    private
    String curso;


    public int getIdProcess() {
        return idProcess;
    }

    public void setIdProcess(int idProcess) {
        this.idProcess = idProcess;
    }

    public int getnPhases() {
        return nPhases;
    }

    public void setnPhases(int nPhases) {
        this.nPhases = nPhases;
    }

    public int getnTemplates() {
        return nTemplates;
    }

    public void setnTemplates(int nTemplates) {
        this.nTemplates = nTemplates;
    }

    public int getIdSpeciality() {
        return idSpeciality;
    }

    public void setIdSpeciality(int idSpeciality) {
        this.idSpeciality = idSpeciality;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public int getIdCycle() {
        return idCycle;
    }

    public void setIdCycle(int idCycle) {
        this.idCycle = idCycle;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
