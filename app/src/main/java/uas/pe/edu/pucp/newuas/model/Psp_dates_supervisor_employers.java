package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by jemarroquin on 08/11/2016.
 */
public class Psp_dates_supervisor_employers implements Serializable {

    @SerializedName("idUser")
    private int idUser;
    @SerializedName("fecha")
    private String fecha;
    @SerializedName("hora")
    private String hora;
    @SerializedName("motivo")
    private String motivo;
    @SerializedName("idAlumno")
    private int idAlumno;
    @SerializedName("lugar")
    private String lugar;

    public Psp_dates_supervisor_employers(int idUser, String fecha,String hora, String motivo  , int idAlumno , String lugar ) {
        this.idUser = idUser;
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
        this.idAlumno = idAlumno;
        this.lugar = lugar;
    }


    public int getIdAlumno() {
        return idAlumno;
    }


}
