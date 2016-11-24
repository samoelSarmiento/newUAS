package uas.pe.edu.pucp.newuas.model;

/**
 * Created by Wingerlion on 23/11/2016.
 */
public class NoCitaRequest {

    private int idUser;
    private int idAlumno;
    private String fecha;
    private String hora;
    private String tema;
    private String observacion;
    private int duracionCita;


    public NoCitaRequest(int idUser, String fecha,String hora, String tema, String observacion, int idAlumno , int duracionCita  ) {
        this.idUser = idUser;
        this.fecha = fecha;
        this.hora = hora;
        this.tema = tema;
        this.observacion = observacion;
        this.idAlumno = idAlumno;
        this.duracionCita = duracionCita;
    }

}
