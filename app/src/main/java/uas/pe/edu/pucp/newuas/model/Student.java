package uas.pe.edu.pucp.newuas.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Franz on 20/10/2016.
 */

public class Student {
    @SerializedName("IdAlumno")
    private int IdAlumno;
    @SerializedName("IdHorario")
    private int IdHorario;
    @SerializedName("Id")
    private int Id;
    @SerializedName("nombre")
    private String nombre;
    @SerializedName("apellidoPaterno")
    private String apellidoPaterno;
    @SerializedName("apellidoMaterno")
    private String apellidoMaterno;
    @SerializedName("telefono")
    private String telefono;
    @SerializedName("correo")
    private String correo;
    @SerializedName("direccion")
    private String direccion;
    @SerializedName("codigo")
    private String codigo;
    @SerializedName("idUsuario")
    private int idUsuario;
    @SerializedName("IdPspGroup")
    private int IdPspGroup;
    @SerializedName("IdEspecialidad")
    private int IdEspecialidad;
    @SerializedName("IdSupervisor")
    private int IdSupervisor;
    @SerializedName("lleva_psp")
    private String lleva_psp;


    public int getIdAlumno() {
        return IdAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        IdAlumno = idAlumno;
    }

    public int getIdHorario() {
        return IdHorario;
    }

    public void setIdHorario(int idHorario) {
        IdHorario = idHorario;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdPspGroup() {
        return IdPspGroup;
    }

    public void setIdPspGroup(int idPspGroup) {
        IdPspGroup = idPspGroup;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }
}
