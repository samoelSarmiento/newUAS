package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Franz on 23/11/2016.
 */

public class PSPStudentFinalGrade {

    @SerializedName("IdAlumno")
    private int IdAlumno;

    @SerializedName("IdHorario")
    private int IdHorario;

    //@SerializedName("id")
    private int Id;

    @SerializedName("Nombre")
    private String nombre;

    @SerializedName("ApellidoPaterno")
    private String apellidoPaterno;

    @SerializedName("ApellidoMaterno")
    private String apellidoMaterno;

    private String telefono;

    private String correo;

    private String direccion;

    @SerializedName("Codigo")
    private String codigo;

    @SerializedName("final_score")
    private
    int grade;

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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
