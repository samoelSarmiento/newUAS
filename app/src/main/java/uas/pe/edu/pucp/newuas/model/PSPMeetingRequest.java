package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Franz on 11/11/2016.
 */

public class PSPMeetingRequest {

    @SerializedName("idsupervisor")
    private int idsupervisor;
    @SerializedName("lugar")
    private String lugar;
    @SerializedName("idalumno")
    private int idAlumno;
    @SerializedName("hora")
    private String hora;
    @SerializedName("fecha")
    private String fecha;


    public int getIdsupervisor() {
        return idsupervisor;
    }

    public void setIdsupervisor(int idsupervisor) {
        this.idsupervisor = idsupervisor;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
