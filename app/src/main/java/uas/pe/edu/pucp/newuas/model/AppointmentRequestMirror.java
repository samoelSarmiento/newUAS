package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Wingerlion on 07/11/2016.
 */
public class AppointmentRequestMirror implements Serializable {

    @SerializedName("idUser")
    private int idUser;
    @SerializedName("fechaI")
    private String fechaI;
    @SerializedName("fechaF")
    private String fechaF;
    @SerializedName("motivo")
    private String motivo;



    private int codigo;

    public AppointmentRequestMirror(int idUser, String fechaI,String fechaF, String motivo, int codigo   ) {
        this.idUser = idUser;
        this.fechaI = fechaI;
        this.fechaF = fechaF;
        this.motivo = motivo;
        this.codigo = codigo;
    }


    public String getFechaI() {
        return fechaI;
    }

    public int getIdUser() {
        return idUser;
    }

    public String getFechaF() {
        return fechaF;
    }

    public String getMotivo() {
        return motivo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }


}
