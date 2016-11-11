package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by jemarroquin on 10/11/2016.
 */
public class Psp_dates_supervisor_employers_get implements Serializable {


    @SerializedName("id")
    private Integer id;
    @SerializedName("idtipoestado")
    private Integer idtipoestado;
    @SerializedName("hora_inicio")
    private String horaInicio;
    @SerializedName("hora_fin")
    private String horaFin;
    @SerializedName("fecha")
    private String fecha;
    @SerializedName("idstudent")
    private Integer idstudent;
    @SerializedName("idsupervisor")
    private Integer idsupervisor;
    @SerializedName("asistencia")
    private String asistencia;
    @SerializedName("lugar")
    private String lugar;
    @SerializedName("observaciones")
    private String observaciones;
    @SerializedName("retroalimentacion")
    private String retroalimentacion;
    @SerializedName("tiporeunion")
    private Integer tiporeunion;
    @SerializedName("idfreehour")
    private Integer idfreehour;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("updated_at")
    private String updatedAt;
    @SerializedName("deleted_at")
    private String deletedAt;




    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getIdtipoestado() {
        return idtipoestado;
    }


    public void setIdtipoestado(Integer idtipoestado) {
        this.idtipoestado = idtipoestado;
    }


    public String getHoraInicio() {
        return horaInicio;
    }


    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }


    public String getHoraFin() {
        return horaFin;
    }


    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }


    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }


    public Integer getIdstudent() {
        return idstudent;
    }


    public void setIdstudent(Integer idstudent) {
        this.idstudent = idstudent;
    }


    public Integer getIdsupervisor() {
        return idsupervisor;
    }


    public void setIdsupervisor(Integer idsupervisor) {
        this.idsupervisor = idsupervisor;
    }


    public String getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(String asistencia) {
        this.asistencia = asistencia;
    }


    public String getLugar() {
        return lugar;
    }


    public void setLugar(String lugar) {
        this.lugar = lugar;
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


    public Integer getTiporeunion() {
        return tiporeunion;
    }


    public void setTiporeunion(Integer tiporeunion) {
        this.tiporeunion = tiporeunion;
    }


    public Integer getIdfreehour() {
        return idfreehour;
    }


    public void setIdfreehour(Integer idfreehour) {
        this.idfreehour = idfreehour;
    }


}
