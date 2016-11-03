package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by Andree on 25/10/2016.
 */

@DatabaseTable(tableName = "project")
public class Projects implements Serializable{

    @SerializedName("id")
    @DatabaseField(id = true)
    private Integer id;

    @SerializedName("nombre")
    @DatabaseField
    private String nombre;

    @SerializedName("descripcion")
    @DatabaseField
    private String descripcion;

    @SerializedName("num_entregables")
    @DatabaseField
    private Integer numEntregables;

    @SerializedName("fecha_ini")
    @DatabaseField
    private String fechaIni;

    @SerializedName("fecha_fin")
    @DatabaseField
    private String fechaFin;

    @SerializedName("id_grupo")
    @DatabaseField
    private Integer idGrupo;

    @SerializedName("id_area")
    @DatabaseField
    private Integer idArea;

    @SerializedName("id_status")
    @DatabaseField
    private Integer idStatus;

    @SerializedName("area")
    @DatabaseField(foreign = true,foreignAutoCreate = true, foreignAutoRefresh = true)
    private Area area;

    @SerializedName("group")
    @DatabaseField(foreign = true,foreignAutoCreate = true, foreignAutoRefresh = true)
    private InvGroups group;

    @SerializedName("status")
    @DatabaseField(foreign = true,foreignAutoCreate = true, foreignAutoRefresh = true)
    private ProjectStatus status;

    public Projects() {
    }

    public Projects(Integer id, String nombre, String descripcion, Integer numEntregables, String fechaIni, String fechaFin, Integer idGrupo, Integer idArea, Integer idStatus, Area area, InvGroups group, ProjectStatus status) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.numEntregables = numEntregables;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.idGrupo = idGrupo;
        this.idArea = idArea;
        this.idStatus = idStatus;
        this.area = area;
        this.group = group;
        this.status = status;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getNumEntregables() {
        return numEntregables;
    }

    public void setNumEntregables(Integer numEntregables) {
        this.numEntregables = numEntregables;
    }

    public String getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(String fechaIni) {
        this.fechaIni = fechaIni;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public Integer getIdArea() {
        return idArea;
    }

    public void setIdArea(Integer idArea) {
        this.idArea = idArea;
    }

    public Integer getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Integer idStatus) {
        this.idStatus = idStatus;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public InvGroups getGroup() {
        return group;
    }

    public void setGroup(InvGroups group) {
        this.group = group;
    }
}
