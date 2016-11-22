package uas.pe.edu.pucp.newuas.model;

/**
 * Created by Wingerlion on 28/10/2016.
 */
public class AppointmentRequest {

    private int idUser;
    private String fecha;
    private String hora;
    private String horaF;
    private String motivo;
    private String studentFullName;
    private int duracionCita;


    public AppointmentRequest(int idUser, String fecha,String hora, String horaF, String motivo, String studentFullName, int duracionCita  ) {
        this.idUser = idUser;
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
        this.horaF = horaF;
        this.studentFullName = studentFullName;
        this.duracionCita = duracionCita;
    }


}
