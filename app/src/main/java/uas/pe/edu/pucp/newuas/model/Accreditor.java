package uas.pe.edu.pucp.newuas.model;

/**
 * Created by samoe on 18/10/2016.
 */

public class Accreditor extends User {
    private int idAcreditador;
    private int idEspecialidad;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String correo;
    private String cargo;

    public Accreditor(int id, int idPerfil, String user) {
        super(id, idPerfil, user);
    }

    public int getIdAcreditador() {
        return idAcreditador;
    }

    public void setIdAcreditador(int idAcreditador) {
        this.idAcreditador = idAcreditador;
    }

    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
