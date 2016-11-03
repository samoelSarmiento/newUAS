package uas.pe.edu.pucp.newuas.model;

import android.widget.ImageButton;

/**
 * Created by Wingerlion on 02/11/2016.
 */
public class SingleRowTuto {

    String fecha;
    String hora;
    String tema;
    String estado;
    String nombreAlumno;
    int icon1;
    int icon2;

    public SingleRowTuto(String fecha, String hora, String tema, String estado, String nombreAlumno,int icon1, int icon2){
        this.fecha = fecha;
        this.hora = hora;
        this.tema = tema;
        this.estado = estado;
        this.nombreAlumno = nombreAlumno;
        this.icon1 = icon1;
        this.icon2 = icon2;
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
    public int getIcon1() {
        return icon1;
    }
    public int getIcon2() {
        return icon2;
    }

}
