package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by samoe on 20/10/2016.
 */

@DatabaseTable(tableName = "investigator")
public class Investigator implements Serializable {

    @SerializedName("id")
    @DatabaseField(id = true)
    private Integer id;

    @SerializedName("id_usuario")
    @DatabaseField
    private Integer idUsuario;

    @SerializedName("nombre")
    @DatabaseField
    private String nombre;

    @SerializedName("ape_paterno")
    @DatabaseField
    private String apePaterno;

    @SerializedName("ape_materno")
    @DatabaseField
    private String apeMaterno;

    @SerializedName("correo")
    @DatabaseField
    private String correo;

    @SerializedName("celular")
    @DatabaseField
    private String celular;

    @SerializedName("id_especialidad")
    @DatabaseField
    private Integer idEspecialidad;

    @SerializedName("id_area")
    @DatabaseField
    private Integer idArea;

    @SerializedName("Vigente")
    @DatabaseField
    private Integer vigente;

    @SerializedName("faculty")
    @DatabaseField(foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true)
    private Specialty specialty;

    @SerializedName("area")
    @DatabaseField(foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true)
    private Area area;

    public Investigator() {
    }

    public Investigator(Integer id, Integer idUsuario, String nombre, String apePaterno, String apeMaterno, String correo, String celular, Integer idEspecialidad, Integer idArea, Integer vigente, Specialty faculty, User user, Area area) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.correo = correo;
        this.celular = celular;
        this.idEspecialidad = idEspecialidad;
        this.idArea = idArea;
        this.vigente = vigente;
        this.specialty = faculty;
        this.area = area;
    }

    public Specialty getFaculty() {
        return specialty;
    }

    public void setFaculty(Specialty faculty) {
        this.specialty = faculty;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApePaterno() {
        return apePaterno;
    }

    public void setApePaterno(String apePaterno) {
        this.apePaterno = apePaterno;
    }

    public String getApeMaterno() {
        return apeMaterno;
    }

    public void setApeMaterno(String apeMaterno) {
        this.apeMaterno = apeMaterno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Integer getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(Integer idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public Integer getIdArea() {
        return idArea;
    }

    public void setIdArea(Integer idArea) {
        this.idArea = idArea;
    }

    public Integer getVigente() {
        return vigente;
    }

    public void setVigente(Integer vigente) {
        this.vigente = vigente;
    }

}
