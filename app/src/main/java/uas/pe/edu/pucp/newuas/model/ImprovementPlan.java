package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marshall on 2/11/2016.
 */

@DatabaseTable(tableName="improvementplan")
public class ImprovementPlan implements Serializable{

    @SerializedName("IdPlanMejora")
    @Expose
    @DatabaseField(id=true)
    private Integer idPlanMejora;
    @SerializedName("IdTipoPlanMejora")
    @Expose
    @DatabaseField
    private Integer idTipoPlanMejora;
    @SerializedName("IdEspecialidad")
    @Expose
    @DatabaseField
    private Integer idEspecialidad;
    @SerializedName("IdArchivoEntrada")
    @Expose
    @DatabaseField
    private Integer idArchivoEntrada;
    @SerializedName("IdDocente")
    @Expose
    @DatabaseField
    private Integer idDocente;
    @SerializedName("Identificador")
    @Expose
    private Object identificador;
    @SerializedName("AnalisisCausal")
    @Expose
    @DatabaseField
    private String analisisCausal;
    @SerializedName("Hallazgo")
    @Expose
    @DatabaseField
    private String hallazgo;
    @SerializedName("Descripcion")
    @Expose
    @DatabaseField
    private String descripcion;
    @SerializedName("FechaImplementacion")
    @Expose
    @DatabaseField
    private String fechaImplementacion;
    @SerializedName("Estado")
    @Expose
    @DatabaseField
    private String estado;
    @SerializedName("file_url")
    @Expose
    @DatabaseField
    private String fileUrl;
    @SerializedName("type_improvement_plan")
    @Expose
    @DatabaseField(foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true)
    private ImprovementPlanType typeImprovementPlan;
    @SerializedName("teacher")
    @Expose
    @DatabaseField(foreign = true, foreignAutoRefresh =  true, foreignAutoCreate = true)
    private Teacher teacher;
    /*
    @SerializedName("actions")
    @Expose
    private List<Action> actions = new ArrayList<Action>();
    */

    /**
     * No args constructor for use in serialization
     *
     */
    public ImprovementPlan() {
    }

    /**
     *
     * @param idDocente
     * @param descripcion
     * @param analisisCausal
     * @param hallazgo
     * @param fileUrl

     * @param estado
     * @param idArchivoEntrada
     * @param idPlanMejora
     * @param typeImprovementPlan

     * @param identificador

     * @param teacher
     * @param idTipoPlanMejora
     * @param fechaImplementacion
     * @param idEspecialidad

     */
    public ImprovementPlan(Integer idPlanMejora, Integer idTipoPlanMejora, Integer idEspecialidad, Integer idArchivoEntrada, Integer idDocente, Object identificador, String analisisCausal, String hallazgo, String descripcion, String fechaImplementacion, String estado,  String fileUrl, ImprovementPlanType typeImprovementPlan, Teacher teacher) {
        this.idPlanMejora = idPlanMejora;
        this.idTipoPlanMejora = idTipoPlanMejora;
        this.idEspecialidad = idEspecialidad;
        this.idArchivoEntrada = idArchivoEntrada;
        this.idDocente = idDocente;
        this.identificador = identificador;
        this.analisisCausal = analisisCausal;
        this.hallazgo = hallazgo;
        this.descripcion = descripcion;
        this.fechaImplementacion = fechaImplementacion;
        this.estado = estado;
        this.fileUrl = fileUrl;
        this.typeImprovementPlan = typeImprovementPlan;
        this.teacher = teacher;

    }

    /**
     *
     * @return
     * The idPlanMejora
     */
    public Integer getIdPlanMejora() {
        return idPlanMejora;
    }

    /**
     *
     * @param idPlanMejora
     * The IdPlanMejora
     */
    public void setIdPlanMejora(Integer idPlanMejora) {
        this.idPlanMejora = idPlanMejora;
    }

    /**
     *
     * @return
     * The idTipoPlanMejora
     */
    public Integer getIdTipoPlanMejora() {
        return idTipoPlanMejora;
    }

    /**
     *
     * @param idTipoPlanMejora
     * The IdTipoPlanMejora
     */
    public void setIdTipoPlanMejora(Integer idTipoPlanMejora) {
        this.idTipoPlanMejora = idTipoPlanMejora;
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
     * The idArchivoEntrada
     */
    public Integer getIdArchivoEntrada() {
        return idArchivoEntrada;
    }

    /**
     *
     * @param idArchivoEntrada
     * The IdArchivoEntrada
     */
    public void setIdArchivoEntrada(Integer idArchivoEntrada) {
        this.idArchivoEntrada = idArchivoEntrada;
    }

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
     * The identificador
     */
    public Object getIdentificador() {
        return identificador;
    }

    /**
     *
     * @param identificador
     * The Identificador
     */
    public void setIdentificador(Object identificador) {
        this.identificador = identificador;
    }

    /**
     *
     * @return
     * The analisisCausal
     */
    public String getAnalisisCausal() {
        return analisisCausal;
    }

    /**
     *
     * @param analisisCausal
     * The AnalisisCausal
     */
    public void setAnalisisCausal(String analisisCausal) {
        this.analisisCausal = analisisCausal;
    }

    /**
     *
     * @return
     * The hallazgo
     */
    public String getHallazgo() {
        return hallazgo;
    }

    /**
     *
     * @param hallazgo
     * The Hallazgo
     */
    public void setHallazgo(String hallazgo) {
        this.hallazgo = hallazgo;
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
     * The fechaImplementacion
     */
    public String getFechaImplementacion() {
        return fechaImplementacion;
    }

    /**
     *
     * @param fechaImplementacion
     * The FechaImplementacion
     */
    public void setFechaImplementacion(String fechaImplementacion) {
        this.fechaImplementacion = fechaImplementacion;
    }

    /**
     *
     * @return
     * The estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     *
     * @param estado
     * The Estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     *
     * @return
     * The fileUrl
     */
    public String getFileUrl() {
        return fileUrl;
    }

    /**
     *
     * @param fileUrl
     * The file_url
     */
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    /**
     *
     * @return
     * The typeImprovementPlan
     */
    public ImprovementPlanType getImprovementPlanType() {
        return typeImprovementPlan;
    }

    /**
     *
     * @param typeImprovementPlan
     * The type_improvement_plan
     */
    public void setImprovementPlanType(ImprovementPlanType typeImprovementPlan) {
        this.typeImprovementPlan = typeImprovementPlan;
    }

    /**
     *
     * @return
     * The teacher
     */
    public Teacher getTeacher() {
        return teacher;
    }

    /**
     *
     * @param teacher
     * The teacher
     */
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }



}