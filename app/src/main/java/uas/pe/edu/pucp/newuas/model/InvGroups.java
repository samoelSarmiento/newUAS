package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by Andree on 25/10/2016.
 */

@DatabaseTable(tableName = "invGroup")
public class InvGroups implements Serializable {

    @SerializedName("id")
    @DatabaseField(id = true)
    private Integer id;

    @SerializedName("nombre")
    @DatabaseField
    private String nombre;

    @SerializedName("id_especialidad")
    @DatabaseField
    private Integer idEspecialidad;

    @SerializedName("descripcion")
    @DatabaseField
    private String descripcion;

    @SerializedName("imagen")
    @DatabaseField
    private String imagen;

    @SerializedName("id_lider")
    @DatabaseField
    private Integer idLider;

    @SerializedName("faculty")
    @DatabaseField(foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true)
    private Specialty faculty;

    @SerializedName("leader")
    private Teacher leader;

    public InvGroups() {
    }

    public InvGroups(Integer id, String nombre, Integer idEspecialidad, String descripcion, String imagen, Integer idLider, Specialty faculty, Teacher leader) {
        this.id = id;
        this.nombre = nombre;
        this.idEspecialidad = idEspecialidad;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.idLider = idLider;
        this.faculty = faculty;
        this.leader = leader;
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

    public Integer getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(Integer idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Integer getIdLider() {
        return idLider;
    }

    public void setIdLider(Integer idLider) {
        this.idLider = idLider;
    }

    public Specialty getFaculty() {
        return faculty;
    }

    public void setFaculty(Specialty faculty) {
        this.faculty = faculty;
    }

    public Teacher getLeader() {
        return leader;
    }

    public void setLeader(Teacher leader) {
        this.leader = leader;
    }
}
