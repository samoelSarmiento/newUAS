package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Andree on 11/11/2016.
 */

@DatabaseTable(tableName = "deliverable")
public class Deliverable implements Serializable{

    @SerializedName("id")
    @DatabaseField(id = true)
    private Integer id;

    @SerializedName("nombre")
    @DatabaseField
    private String nombre;

    @SerializedName("id_proyecto")
    @DatabaseField
    private Integer idProyecto;

    @SerializedName("fecha_inicio")
    @DatabaseField
    private String fechaInicio;

    @SerializedName("fecha_limite")
    @DatabaseField
    private String fechaLimite;

    @SerializedName("porcen_avance")
    @DatabaseField
    private Integer porcenAvance;

    @SerializedName("project")
    @DatabaseField(foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true)
    private Projects projects;

    @SerializedName("versions")
    private List<InvDocument> invDocuments;

    @SerializedName("investigators")
    private List<InvDocument.Investigator> investigator;



    public List<InvDocument> getInvDocuments() {
        return invDocuments;
    }

    public void setInvDocuments(List<InvDocument> invDocuments) {
        this.invDocuments = invDocuments;
    }

    public List<InvDocument.Investigator> getInvestigator() {
        return investigator;
    }

    public void setInvestigator(List<InvDocument.Investigator> investigator) {
        this.investigator = investigator;
    }

    public Deliverable() {
    }

    public Deliverable(Integer id, String nombre, Integer idProyecto, String fechaInicio, String fechaLimite, Integer porcenAvance, Projects projects, List<InvDocument> invDocuments, List<InvDocument.Investigator> investigator) {
        this.id = id;
        this.nombre = nombre;
        this.idProyecto = idProyecto;
        this.fechaInicio = fechaInicio;
        this.fechaLimite = fechaLimite;
        this.porcenAvance = porcenAvance;
        this.projects = projects;
        this.invDocuments = invDocuments;
        this.investigator = investigator;
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

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(String fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public Integer getPorcenAvance() {
        return porcenAvance;
    }

    public void setPorcenAvance(Integer porcenAvance) {
        this.porcenAvance = porcenAvance;
    }

    public Projects getProjects() {
        return projects;
    }

    public void setProjects(Projects projects) {
        this.projects = projects;
    }
}
