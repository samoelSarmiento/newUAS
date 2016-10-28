package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Marshall on 20/10/2016.
 */

public class Specialty implements Serializable {

    @SerializedName("IdEspecialidad")
    private Integer idEspecialidad;
    @SerializedName("Codigo")
    private String codigo;
    @SerializedName("Nombre")
    private String nombre;
    @SerializedName("Descripcion")
    private String descripcion;
    @SerializedName("deleted_at")
    private Object deletedAt;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("updated_at")
    private String updatedAt;
    @SerializedName("IdDocente")
    private Integer idDocente;
    @SerializedName("coordinator")
    private Teacher coordinator;

    /**
     * No args constructor for use in serialization
     */
    public Specialty() {
    }

    /**
     * @param updatedAt
     * @param nombre
     * @param codigo
     * @param idDocente
     * @param createdAt
     * @param deletedAt
     * @param descripcion
     * @param idEspecialidad
     */
    public Specialty(Integer idEspecialidad, String codigo, String nombre, String descripcion, Object deletedAt, String createdAt, String updatedAt, Integer idDocente, Teacher coordinator) {
        this.idEspecialidad = idEspecialidad;
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.deletedAt = deletedAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.idDocente = idDocente;
        this.setCoordinator(coordinator);
    }

    /**
     * @return The idEspecialidad
     */
    public Integer getIdEspecialidad() {
        return idEspecialidad;
    }

    /**
     * @param idEspecialidad The IdEspecialidad
     */
    public void setIdEspecialidad(Integer idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    /**
     * @return The codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo The Codigo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return The nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre The Nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return The descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion The Descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return The deletedAt
     */
    public Object getDeletedAt() {
        return deletedAt;
    }

    /**
     * @param deletedAt The deleted_at
     */
    public void setDeletedAt(Object deletedAt) {
        this.deletedAt = deletedAt;
    }

    /**
     * @return The createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt The created_at
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return The updatedAt
     */
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @param updatedAt The updated_at
     */
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * @return The idDocente
     */
    public Integer getIdDocente() {
        return idDocente;
    }

    /**
     * @param idDocente The IdDocente
     */
    public void setIdDocente(Integer idDocente) {
        this.idDocente = idDocente;
    }

    public Teacher getCoordinator() {
        return coordinator;
    }

    public void setCoordinator(Teacher coordinator) {
        this.coordinator = coordinator;
    }
}
