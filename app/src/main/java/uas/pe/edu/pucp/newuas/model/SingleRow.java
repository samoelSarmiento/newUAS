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
    int icon1;
    int icon2;
    int idAppoint;

    public SingleRow(String fecha, String hora, String tema, String estado, int icon1, int icon2, int idAppoint){
        this.fecha = fecha;
        this.hora = hora;
        this.tema = tema;
        this.estado = estado;
        this.icon1 = icon1;
        this.icon2 = icon2;
        this.idAppoint = idAppoint;
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
    public int getIcon1() {
        return icon1;
    }
    public int getIcon2() {
        return icon2;
    }
    public int getIdAppoint() {
        return idAppoint;
    }

}