package uas.pe.edu.pucp.newuas.model;

/**
 * Created by Wingerlion on 28/10/2016.
 */
public class AppointmentRequest {

    private int idUser;
    private String fecha;
    private String hora;
    private String motivo;
    private String studentFullName;


    public AppointmentRequest(int idUser, String fecha,String hora, String motivo, String studentFullName   ) {
        this.idUser = idUser;
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
        this.studentFullName = studentFullName;
    }


}
