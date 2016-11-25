package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Wingerlion on 23/11/2016.
 */
public class StudentInfoResponse implements Serializable {

    @SerializedName("id")
    private Integer id;
    @SerializedName("id_usuario")
    private Integer idUsuario;
    @SerializedName("codigo")
    private String codigo;
    @SerializedName("nombre")
    private String nombre;
    @SerializedName("ape_paterno")
    private String apePaterno;
    @SerializedName("ape_materno")
    private String apeMaterno;
    @SerializedName("correo")
    private String correo;
    @SerializedName("id_especialidad")
    private Integer idEspecialidad;
    @SerializedName("id_tutoria")
    private Integer idTutoria;
    @SerializedName("deleted_at")
    private Object deletedAt;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("updated_at")
    private String updatedAt;

    /**
     *
     * @return
     * The id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The idUsuario
     */
    public Integer getIdUsuario() {
        return idUsuario;
    }

    /**
     *
     * @param idUsuario
     * The id_usuario
     */
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     *
     * @return
     * The codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     *
     * @param codigo
     * The codigo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     *
     * @return
     * The nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     * The nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     * The apePaterno
     */
    public String getApePaterno() {
        return apePaterno;
    }

    /**
     *
     * @param apePaterno
     * The ape_paterno
     */
    public void setApePaterno(String apePaterno) {
        this.apePaterno = apePaterno;
    }

    /**
     *
     * @return
     * The apeMaterno
     */
    public String getApeMaterno() {
        return apeMaterno;
    }

    /**
     *
     * @param apeMaterno
     * The ape_materno
     */
    public void setApeMaterno(String apeMaterno) {
        this.apeMaterno = apeMaterno;
    }

    /**
     *
     * @return
     * The correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     *
     * @param correo
     * The correo
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     *
     * @return
     * The idEspecialidad
     */
    public Integer getIdEspecialidad() {
        return idEspecialidad;
    }

    /**
     *
     * @param idEspecialidad
     * The id_especialidad
     */
    public void setIdEspecialidad(Integer idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    /**
     *
     * @return
     * The idTutoria
     */
    public Integer getIdTutoria() {
        return idTutoria;
    }

    /**
     *
     * @param idTutoria
     * The id_tutoria
     */
    public void setIdTutoria(Integer idTutoria) {
        this.idTutoria = idTutoria;
    }

    /**
     *
     * @return
     * The deletedAt
     */
    public Object getDeletedAt() {
        return deletedAt;
    }

    /**
     *
     * @param deletedAt
     * The deleted_at
     */
    public void setDeletedAt(Object deletedAt) {
        this.deletedAt = deletedAt;
    }

    /**
     *
     * @return
     * The createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     *
     * @param createdAt
     * The created_at
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     *
     * @return
     * The updatedAt
     */
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     *
     * @param updatedAt
     * The updated_at
     */
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }


}
