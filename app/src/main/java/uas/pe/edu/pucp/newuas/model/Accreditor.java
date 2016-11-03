package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by samoe on 20/10/2016.
 */

@DatabaseTable(tableName = "accreditor")
public class Accreditor implements Serializable {

    @SerializedName("IdAcreditador")
    @DatabaseField(id = true)
    private Integer idAcreditador;

    @SerializedName("IdEspecialidad")
    @DatabaseField
    private Integer idEspecialidad;

    @SerializedName("IdUsuario")
    @DatabaseField
    private Integer idUsuario;

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

    public Accreditor() {
    }

    public Accreditor(Integer idAcreditador, Integer idEspecialidad, Integer idUsuario, String nombre, String apellidoPaterno, String apellidoMaterno, String correo) {
        this.idAcreditador = idAcreditador;
        this.idEspecialidad = idEspecialidad;
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
    }

    public Integer getIdAcreditador() {
        return idAcreditador;
    }

    public void setIdAcreditador(Integer idAcreditador) {
        this.idAcreditador = idAcreditador;
    }

    public Integer getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(Integer idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
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


}
