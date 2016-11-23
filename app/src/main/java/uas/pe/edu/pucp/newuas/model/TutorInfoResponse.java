package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Wingerlion on 23/11/2016.
 */
public class TutorInfoResponse implements Serializable {

    @SerializedName("IdDocente")
    private Integer idDocente;
    @SerializedName("IdEspecialidad")
    private Integer idEspecialidad;
    @SerializedName("IdUsuario")
    private Integer idUsuario;
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
    private Integer vigente;
    @SerializedName("rolTutoria")
    private Integer rolTutoria;
    @SerializedName("rolEvaluaciones")
    private Object rolEvaluaciones;
    @SerializedName("oficina")
    private String oficina;
    @SerializedName("telefono")
    private String telefono;
    @SerializedName("anexo")
    private String anexo;
    @SerializedName("Descripcion")
    private String descripcion;
    @SerializedName("deleted_at")
    private Object deletedAt;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("updated_at")
    private String updatedAt;
    @SerializedName("direccion")
    private Object direccion;
    @SerializedName("es_adminpsp")
    private Object esAdminpsp;
    @SerializedName("es_supervisorpsp")
    private Object esSupervisorpsp;

    /**
     *
     * @return
     * The idDocente
     */
    public Integer getIdDocente() {
        return idDocente;
    }

    /**
     *
     * @param idDocente
     * The IdDocente
     */
    public void setIdDocente(Integer idDocente) {
        this.idDocente = idDocente;
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
     * The IdEspecialidad
     */
    public void setIdEspecialidad(Integer idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
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
     * The IdUsuario
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
     * The Codigo
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
     * The Nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     * The apellidoPaterno
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     *
     * @param apellidoPaterno
     * The ApellidoPaterno
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     *
     * @return
     * The apellidoMaterno
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     *
     * @param apellidoMaterno
     * The ApellidoMaterno
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
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
     * The Correo
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     *
     * @return
     * The cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     *
     * @param cargo
     * The Cargo
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     *
     * @return
     * The vigente
     */
    public Integer getVigente() {
        return vigente;
    }

    /**
     *
     * @param vigente
     * The Vigente
     */
    public void setVigente(Integer vigente) {
        this.vigente = vigente;
    }

    /**
     *
     * @return
     * The rolTutoria
     */
    public Integer getRolTutoria() {
        return rolTutoria;
    }

    /**
     *
     * @param rolTutoria
     * The rolTutoria
     */
    public void setRolTutoria(Integer rolTutoria) {
        this.rolTutoria = rolTutoria;
    }

    /**
     *
     * @return
     * The rolEvaluaciones
     */
    public Object getRolEvaluaciones() {
        return rolEvaluaciones;
    }

    /**
     *
     * @param rolEvaluaciones
     * The rolEvaluaciones
     */
    public void setRolEvaluaciones(Object rolEvaluaciones) {
        this.rolEvaluaciones = rolEvaluaciones;
    }

    /**
     *
     * @return
     * The oficina
     */
    public String getOficina() {
        return oficina;
    }

    /**
     *
     * @param oficina
     * The oficina
     */
    public void setOficina(String oficina) {
        this.oficina = oficina;
    }

    /**
     *
     * @return
     * The telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     *
     * @param telefono
     * The telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     *
     * @return
     * The anexo
     */
    public String getAnexo() {
        return anexo;
    }

    /**
     *
     * @param anexo
     * The anexo
     */
    public void setAnexo(String anexo) {
        this.anexo = anexo;
    }

    /**
     *
     * @return
     * The descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     *
     * @param descripcion
     * The Descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    /**
     *
     * @return
     * The direccion
     */
    public Object getDireccion() {
        return direccion;
    }

    /**
     *
     * @param direccion
     * The direccion
     */
    public void setDireccion(Object direccion) {
        this.direccion = direccion;
    }

    /**
     *
     * @return
     * The esAdminpsp
     */
    public Object getEsAdminpsp() {
        return esAdminpsp;
    }

    /**
     *
     * @param esAdminpsp
     * The es_adminpsp
     */
    public void setEsAdminpsp(Object esAdminpsp) {
        this.esAdminpsp = esAdminpsp;
    }

    /**
     *
     * @return
     * The esSupervisorpsp
     */
    public Object getEsSupervisorpsp() {
        return esSupervisorpsp;
    }

    /**
     *
     * @param esSupervisorpsp
     * The es_supervisorpsp
     */
    public void setEsSupervisorpsp(Object esSupervisorpsp) {
        this.esSupervisorpsp = esSupervisorpsp;
    }


}
