package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Franz on 21/11/2016.
 */

public class PSPFreeHour implements Serializable {

    @SerializedName("fecha")
   private String fecha;
    @SerializedName("hora_ini")
    private String horaIni;

    @SerializedName("id")
    private int idFreeHour;
    @SerializedName("supervisor")
    private PSPSupervisor supervisor;


    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHoraIni() {
        return horaIni;
    }

    public void setHoraIni(String horaIni) {
        this.horaIni = horaIni;
    }


    public PSPSupervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(PSPSupervisor supervisor) {
        this.supervisor = supervisor;
    }

    public int getIdFreeHour() {
        return idFreeHour;
    }

    public void setIdFreeHour(int idFreeHour) {
        this.idFreeHour = idFreeHour;
    }
}
