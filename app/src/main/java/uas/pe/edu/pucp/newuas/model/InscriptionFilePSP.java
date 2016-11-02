package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by jemarroquin on 31/10/2016.
 */
public class InscriptionFilePSP implements Serializable {

    @SerializedName("id")
    private Integer id;

    @SerializedName("tiene_convenio")
    private Integer tieneConvenio;

    @SerializedName("fecha_recep_convenio")
    private String fechaRecepConvenio;

    @SerializedName("fecha_inicio")
    private String fechaInicio;

    @SerializedName("fecha_termino")
    private String fechaTermino;

    @SerializedName("activ_formativas")
    private String activFormativas;

    @SerializedName("razon_social")
    private String razonSocial;

    @SerializedName("actividad_economica")
    private String actividadEconomica;

    @SerializedName("direccion_empresa")
    private String direccionEmpresa;

    @SerializedName("distrito_empresa")
    private String distritoEmpresa;

    @SerializedName("nombre_area")
    private String nombreArea;

    @SerializedName("ubicacion_area")
    private String ubicacionArea;

    @SerializedName("equipamiento_area")
    private String equipamientoArea;

    @SerializedName("equi_del_practicante")
    private String equiDelPracticante;

    @SerializedName("personal_area")
    private String personalArea;

    @SerializedName("cond_seguridad_area")
    private String condSeguridadArea;

    @SerializedName("Correo_jefe_directo")
    private String correoJefeDirecto;

    @SerializedName("telef_jefe_directo")
    private String telefJefeDirecto;

    @SerializedName("jefe_directo_aux")
    private String jefeDirectoAux;

    @SerializedName("puesto")
    private String puesto;

    @SerializedName("recomendaciones")
    private String recomendaciones;

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
     * The tieneConvenio
     */
    public Integer getTieneConvenio() {
        return tieneConvenio;
    }

    /**
     *
     * @param tieneConvenio
     * The tiene_convenio
     */
    public void setTieneConvenio(Integer tieneConvenio) {
        this.tieneConvenio = tieneConvenio;
    }

    /**
     *
     * @return
     * The fechaRecepConvenio
     */
    public String getFechaRecepConvenio() {
        return fechaRecepConvenio;
    }

    /**
     *
     * @param fechaRecepConvenio
     * The fecha_recep_convenio
     */
    public void setFechaRecepConvenio(String fechaRecepConvenio) {
        this.fechaRecepConvenio = fechaRecepConvenio;
    }

    /**
     *
     * @return
     * The fechaInicio
     */
    public String getFechaInicio() {
        return fechaInicio;
    }

    /**
     *
     * @param fechaInicio
     * The fecha_inicio
     */
    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     *
     * @return
     * The fechaTermino
     */
    public String getFechaTermino() {
        return fechaTermino;
    }

    /**
     *
     * @param fechaTermino
     * The fecha_termino
     */
    public void setFechaTermino(String fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    /**
     *
     * @return
     * The activFormativas
     */
    public String getActivFormativas() {
        return activFormativas;
    }

    /**
     *
     * @param activFormativas
     * The activ_formativas
     */
    public void setActivFormativas(String activFormativas) {
        this.activFormativas = activFormativas;
    }

    /**
     *
     * @return
     * The razonSocial
     */
    public String getRazonSocial() {
        return razonSocial;
    }

    /**
     *
     * @param razonSocial
     * The razon_social
     */
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    /**
     *
     * @return
     * The actividadEconomica
     */
    public String getActividadEconomica() {
        return actividadEconomica;
    }

    /**
     *
     * @param actividadEconomica
     * The actividad_economica
     */
    public void setActividadEconomica(String actividadEconomica) {
        this.actividadEconomica = actividadEconomica;
    }

    /**
     *
     * @return
     * The direccionEmpresa
     */
    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    /**
     *
     * @param direccionEmpresa
     * The direccion_empresa
     */
    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }

    /**
     *
     * @return
     * The distritoEmpresa
     */
    public String getDistritoEmpresa() {
        return distritoEmpresa;
    }

    /**
     *
     * @param distritoEmpresa
     * The distrito_empresa
     */
    public void setDistritoEmpresa(String distritoEmpresa) {
        this.distritoEmpresa = distritoEmpresa;
    }

    /**
     *
     * @return
     * The nombreArea
     */
    public String getNombreArea() {
        return nombreArea;
    }

    /**
     *
     * @param nombreArea
     * The nombre_area
     */
    public void setNombreArea(String nombreArea) {
        this.nombreArea = nombreArea;
    }

    /**
     *
     * @return
     * The ubicacionArea
     */
    public String getUbicacionArea() {
        return ubicacionArea;
    }

    /**
     *
     * @param ubicacionArea
     * The ubicacion_area
     */
    public void setUbicacionArea(String ubicacionArea) {
        this.ubicacionArea = ubicacionArea;
    }

    /**
     *
     * @return
     * The equipamientoArea
     */
    public String getEquipamientoArea() {
        return equipamientoArea;
    }

    /**
     *
     * @param equipamientoArea
     * The equipamiento_area
     */
    public void setEquipamientoArea(String equipamientoArea) {
        this.equipamientoArea = equipamientoArea;
    }

    /**
     *
     * @return
     * The equiDelPracticante
     */
    public String getEquiDelPracticante() {
        return equiDelPracticante;
    }

    /**
     *
     * @param equiDelPracticante
     * The equi_del_practicante
     */
    public void setEquiDelPracticante(String equiDelPracticante) {
        this.equiDelPracticante = equiDelPracticante;
    }

    /**
     *
     * @return
     * The personalArea
     */
    public String getPersonalArea() {
        return personalArea;
    }

    /**
     *
     * @param personalArea
     * The personal_area
     */
    public void setPersonalArea(String personalArea) {
        this.personalArea = personalArea;
    }

    /**
     *
     * @return
     * The condSeguridadArea
     */
    public String getCondSeguridadArea() {
        return condSeguridadArea;
    }

    /**
     *
     * @param condSeguridadArea
     * The cond_seguridad_area
     */
    public void setCondSeguridadArea(String condSeguridadArea) {
        this.condSeguridadArea = condSeguridadArea;
    }

    /**
     *
     * @return
     * The correoJefeDirecto
     */
    public String getCorreoJefeDirecto() {
        return correoJefeDirecto;
    }

    /**
     *
     * @param correoJefeDirecto
     * The Correo_jefe_directo
     */
    public void setCorreoJefeDirecto(String correoJefeDirecto) {
        this.correoJefeDirecto = correoJefeDirecto;
    }

    /**
     *
     * @return
     * The telefJefeDirecto
     */
    public String getTelefJefeDirecto() {
        return telefJefeDirecto;
    }

    /**
     *
     * @param telefJefeDirecto
     * The telef_jefe_directo
     */
    public void setTelefJefeDirecto(String telefJefeDirecto) {
        this.telefJefeDirecto = telefJefeDirecto;
    }

    /**
     *
     * @return
     * The jefeDirectoAux
     */
    public String getJefeDirectoAux() {
        return jefeDirectoAux;
    }

    /**
     *
     * @param jefeDirectoAux
     * The jefe_directo_aux
     */
    public void setJefeDirectoAux(String jefeDirectoAux) {
        this.jefeDirectoAux = jefeDirectoAux;
    }

    /**
     *
     * @return
     * The puesto
     */
    public String getPuesto() {
        return puesto;
    }

    /**
     *
     * @param puesto
     * The puesto
     */
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    /**
     *
     * @return
     * The recomendaciones
     */
    public String getRecomendaciones() {
        return recomendaciones;
    }

    /**
     *
     * @param recomendaciones
     * The recomendaciones
     */
    public void setRecomendaciones(String recomendaciones) {
        this.recomendaciones = recomendaciones;
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
