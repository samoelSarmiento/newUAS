package uas.pe.edu.pucp.newuas.model;

/**
 * Created by Wingerlion on 01/11/2016.
 */

public class SingleRow {

    //ImageButton icon1;
    //ImageButton icon2;

    String fecha;
    String hora;
    String tema;
    String estado;

    public SingleRow(String fecha, String hora, String tema, String estado){
        this.fecha = fecha;
        this.hora = hora;
        this.tema = tema;
        this.estado = estado;
    }

    public String getFecha() {
        return fecha;
    }public String getHora() {
        return hora;
    }public String getTema() {
        return tema;
    }public String getEstado() {
        return estado;
    }

}