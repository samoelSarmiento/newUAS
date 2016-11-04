package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by Andree on 04/11/2016.
 */

@DatabaseTable(tableName = "event")
public class InvEvent implements Serializable{

    @SerializedName("id")
    @DatabaseField(id = true)
    private Integer id;

    @SerializedName("nombre")
    @DatabaseField
    private String nombre;

    @SerializedName("ubicacion")
    @DatabaseField
    private String ubicacion;

    @SerializedName("descripcion")
    @DatabaseField
    private String descripcion;

    @SerializedName("fecha")
    @DatabaseField
    private String fecha;

    @SerializedName("hora")
    @DatabaseField
    private String hora;

    @SerializedName("duracion")
    @DatabaseField
    private Integer duracion;

    @SerializedName("tipo")
    @DatabaseField
    private Integer tipo;

    @SerializedName("imagen")
    @DatabaseField
    private Object imagen;

    @SerializedName("id_grupo")
    @DatabaseField
    private Integer idGrupo;

    @SerializedName("group")
    @DatabaseField(foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true)
    private InvGroups invGroups;

    public InvEvent() {
    }

    public InvEvent(Integer id, String nombre, String ubicacion, String descripcion, String fecha, String hora, Integer duracion, Integer tipo, Object imagen, Integer idGrupo, InvGroups invGroups) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.hora = hora;
        this.duracion = duracion;
        this.tipo = tipo;
        this.imagen = imagen;
        this.idGrupo = idGrupo;
        this.invGroups = invGroups;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Object getImagen() {
        return imagen;
    }

    public void setImagen(Object imagen) {
        this.imagen = imagen;
    }

    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public InvGroups getInvGroups() {
        return invGroups;
    }

    public void setInvGroups(InvGroups invGroups) {
        this.invGroups = invGroups;
    }
}
