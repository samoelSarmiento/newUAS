package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by samoe on 20/10/2016.
 */

@DatabaseTable(tableName = "teacher")
public class Teacher {

    @SerializedName("IdDocente")
    @DatabaseField(id = true)
    private Integer idDocente;

    @SerializedName("IdEspecialidad")
    @DatabaseField
    private Integer idEspecialidad;

    @SerializedName("IdUsuario")
    @DatabaseField
    private Integer idUsuario;

    @SerializedName("Codigo")
    @DatabaseField
    private String codigo;

    @SerializedName("Nombre")
    @DatabaseField
    private String nombre;

    @SerializedName("ApellidoPaterno")
    @DatabaseField
    private String apellidoPaterno;

    @SerializedName("ApellidoMaterno")
    @DatabaseField
    private String apellidoMaterno;

    @SerializedName("Correo")
    @DatabaseField
    private String correo;

    @SerializedName("Cargo")
    @DatabaseField
    private String cargo;

    @SerializedName("Vigente")
    @DatabaseField
    private Integer vigente;

    @SerializedName("oficina")
    @DatabaseField
    private String oficina;

    @SerializedName("telefono")
    @DatabaseField
    private String telefono;

    @SerializedName("anexo")
    @DatabaseField
    private String anexo;

    @SerializedName("Descripcion")
    @DatabaseField
    private String descripcion;

    public void setVigente(int vigente) {
        this.vigente = vigente;
    }

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
