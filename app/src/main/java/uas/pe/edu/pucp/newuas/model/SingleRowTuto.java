package uas.pe.edu.pucp.newuas.model;

/**
 * Created by Wingerlion on 02/11/2016.
 */
public class SingleRowTuto {
    //ImageButton icon1;
    //ImageButton icon2;

    String fecha;
    String hora;
    String tema;
    String estado;
    String nombreAlumno;

    public SingleRowTuto(String fecha, String hora, String tema, String estado, String nombreAlumno){
        this.fecha = fecha;
        this.hora = hora;
        this.tema = tema;
        this.estado = estado;
        this.nombreAlumno = nombreAlumno;
    }

    public String getFecha() {
        return fecha;
    }
    public String getHora() {
        return hora;
    }
    public String getTema() {
        return tema;
    }
    public String getEstado() {
        return estado;
    }
    public String getNombreAlumno() {
        return nombreAlumno;
    }

}
