package uas.pe.edu.pucp.newuas.model;

/**
 * Created by Wingerlion on 06/11/2016.
 */
public class AppointmentFilterRequest {


    private int idUser;
    private String fechaI;
    private String fechaF;
    private String motivo;


    public AppointmentFilterRequest(int idUser, String fechaI,String fechaF, String motivo   ) {
        this.idUser = idUser;
        this.fechaI = fechaI;
        this.fechaF = fechaF;
        this.motivo = motivo;
    }



}
