package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by Marshall on 2/11/2016.
 */

@DatabaseTable(tableName="action")
public class Action implements Serializable{

    @SerializedName("IdPlanAccion")
    @Expose
    @DatabaseField(id=true)
    private Integer idPlanAccion;
    @SerializedName("IdPlanMejora")
    @Expose
    @DatabaseField
    private Integer idPlanMejora;
    @SerializedName("IdCicloAcademico")
    @Expose
    @DatabaseField
    private Integer idCicloAcademico;
    @SerializedName("IdDocente")
    @Expose
    @DatabaseField
    private Integer idDocente;
    @SerializedName("Comentario")
    @Expose
    @DatabaseField
    private String comentario;
    @SerializedName("Descripcion")
    @Expose
    @DatabaseField
    private String descripcion;
    @SerializedName("IdArchivoEntrada")
    @Expose
    @DatabaseField
    private Integer idArchivoEntrada;
    @SerializedName("Porcentaje")
    @Expose
    @DatabaseField
    private Integer porcentaje;
    @SerializedName("teacher")
    @Expose
    @DatabaseField(foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true)
    private Teacher teacher;
    @SerializedName("cicle")
    @Expose
    @DatabaseField(foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true)
    private Semester cicle;
    @SerializedName("file")
    @Expose
    @DatabaseField(foreign = true, foreignAutoRefresh =  true, foreignAutoCreate = true)
    private ActionFile actionFile;

    /**
     * No args constructor for use in serialization
     *
     */
    public Action() {
    }

    /**
     *
     * @param idDocente
     * @param descripcion
     * @param idCicloAcademico
     * @param comentario

     * @param porcentaje
     * @param idPlanAccion

     * @param idArchivoEntrada
     * @param idPlanMejora
     * @param cicle

     * @param teacher|
     */
    public Action(Integer idPlanAccion, Integer idPlanMejora, Integer idCicloAcademico, Integer idDocente, String comentario, String descripcion,  Integer idArchivoEntrada, Integer porcentaje, Teacher teacher, Semester cicle, ActionFile actionFile) {
        this.idPlanAccion = idPlanAccion;
        this.idPlanMejora = idPlanMejora;
        this.idCicloAcademico = idCicloAcademico;
        this.idDocente = idDocente;
        this.comentario = comentario;
        this.descripcion = descripcion;

        this.idArchivoEntrada = idArchivoEntrada;
        this.porcentaje = porcentaje;

        this.teacher = teacher;
        this.cicle = cicle;
        this.actionFile = actionFile;
    }

    /**
     *
     * @return
     * The idPlanAccion
     */
    public Integer getIdPlanAccion() {
        return idPlanAccion;
    }

    /**
     *
     * @param idPlanAccion
     * The IdPlanAccion
     */
    public void setIdPlanAccion(Integer idPlanAccion) {
        this.idPlanAccion = idPlanAccion;
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
     * The idCicloAcademico
     */
    public Integer getIdCicloAcademico() {
        return idCicloAcademico;
    }

    /**
     *
     * @param idCicloAcademico
     * The IdCicloAcademico
     */
    public void setIdCicloAcademico(Integer idCicloAcademico) {
        this.idCicloAcademico = idCicloAcademico;
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
     * The comentario
     */
    public String getComentario() {
        return comentario;
    }

    /**
     *
     * @param comentario
     * The Comentario
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
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
     * The porcentaje
     */
    public Integer getPorcentaje() {
        return porcentaje;
    }

    /**
     *
     * @param porcentaje
     * The Porcentaje
     */
    public void setPorcentaje(Integer porcentaje) {
        this.porcentaje = porcentaje;
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

    /**
     *
     * @return
     * The cicle
     */
    public Semester getSemester() {
        return cicle;
    }

    /**
     *
     * @param cicle
     * The cicle
     */
    public void setSemester(Semester cicle) {
        this.cicle = cicle;
    }

    public ActionFile getActionFile(){
        return actionFile;
    }

    public void setActionFile(ActionFile actionFile){
        this.actionFile = actionFile;
    }

}
