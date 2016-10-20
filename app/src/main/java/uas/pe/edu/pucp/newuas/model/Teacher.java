package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by samoe on 20/10/2016.
 */

public class Teacher {

    @SerializedName("IdDocente")
    private int idDocente;

    @SerializedName("IdEspecialidad")
    private int idEspecialidad;

    @SerializedName("IdUsuario")
    private int idUsuario;

    @SerializedName("Codigo")
    private String codigo;

    @SerializedName("Nombre")
    private String nombre;

    @SerializedName("ApellidoPaterno")
    private String apellidoPaterno;

    @SerializedName("ApellidoMaterno")
    private String apellidoMaterno;

    @SerializedName("Correo")
    private String correo;

    @SerializedName("Cargo")
    private String cargo;

    @SerializedName("Vigente")
    private int vigente;

    @SerializedName("rolTutoria")
    private boolean rolTutoria;

    @SerializedName("rolEvaluaciones")
    private boolean rolEvaluaciones;

    @SerializedName("oficina")
    private String oficina;

    @SerializedName("telefono")
    private String telefono;

    @SerializedName("anexo")
    private String anexo;

    @SerializedName("Descripcion")
    private String descripcion;

    public int getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public int getVigente() {
        return vigente;
    }

    public void setVigente(Integer vigente) {
        this.vigente = vigente;
    }

    public Object getRolTutoria() {
        return rolTutoria;
    }

    public void setRolTutoria(boolean rolTutoria) {
        this.rolTutoria = rolTutoria;
    }

    public boolean getRolEvaluaciones() {
        return rolEvaluaciones;
    }

    public void setRolEvaluaciones(boolean rolEvaluaciones) {
        this.rolEvaluaciones = rolEvaluaciones;
    }

    public String getOficina() {
        return oficina;
    }

    public void setOficina(String oficina) {
        this.oficina = oficina;
    }

    public Object getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getAnexo() {
        return anexo;
    }

    public void setAnexo(String anexo) {
        this.anexo = anexo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
