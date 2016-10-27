package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Andree on 25/10/2016.
 */

public class Projects implements Serializable{

    @SerializedName("id")
    private int id;

    @SerializedName("nombre")
    private String nombre;

    @SerializedName("descripcion")
    private String descripcion;

    @SerializedName("num_entregables")
    private int numEntregables;

    @SerializedName("fecha_ini")
    private String fechaIni;

    @SerializedName("fecha_fin")
    private String fechaFin;

    @SerializedName("id_grupo")
    private int idGrupo;

    @SerializedName("id_area")
    private int idArea;

    @SerializedName("id_status")
    private int idStatus;

    @SerializedName("deleted_at")
    private String deletedAt;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("area")
    private Area area;

    @SerializedName("group")
    private InvGroups group;

    @SerializedName("status")
    private ProjectStatus status;

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getNumEntregables() {
        return numEntregables;
    }

    public void setNumEntregables(int numEntregables) {
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

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    public String getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(String deletedAt) {
        this.deletedAt = deletedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
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
