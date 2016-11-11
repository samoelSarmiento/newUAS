package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Franz on 10/11/2016.
 */

public class PSPMeeting implements Serializable {

    @SerializedName("id")
    private int idMeeting;
    private int idFreeHour;
    @SerializedName("estado")
    private Status status;
    @SerializedName("hora_inicio")
    private String hora_inicio;
    @SerializedName("hora_fin")
    private String hora_fin;
    @SerializedName("fecha")
    private Date fecha;
    @SerializedName("idstudent")
    private int idStudent;
    @SerializedName("idsupervisor")
    private int idsupervisor;
    @SerializedName("lugar")
    private String lugar;
    @SerializedName("asistencia")
    private String asistencia;
    @SerializedName("observaciones")
    private String observaciones;
    @SerializedName("retroalimentacion")
    private String retroalimentacion;
    @SerializedName("tiporeunion")
    private int tipoReunion;


    public int getIdMeeting() {
        return idMeeting;



    }

    public void setIdMeeting(int idMeeting) {
        this.idMeeting = idMeeting;
    }

    public int getIdFreeHour() {
        return idFreeHour;

    }

    public void setIdFreeHour(int idFreeHour) {
        this.idFreeHour = idFreeHour;
    }



    public String getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public String getHora_fin() {
        return hora_fin;
    }

    public void setHare_fin(String hore_fin) {
        this.hora_fin = hore_fin;
    }

    public Date getFecha() {
        return fecha;

    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(String asistencia) {
        this.asistencia = asistencia;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getRetroalimentacion() {
        return retroalimentacion;
    }

    public void setRetroalimentacion(String retroalimentacion) {
        this.retroalimentacion = retroalimentacion;
    }

    public int getTipoReunion() {
        return tipoReunion;
    }

    public void setTipoReunion(int tipoReunion) {
        this.tipoReunion = tipoReunion;
    }

    public int getIdsupervisor() {
        return idsupervisor;
    }

    public void setIdsupervisor(int idsupervisor) {
        this.idsupervisor = idsupervisor;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
