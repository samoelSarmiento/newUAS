package uas.pe.edu.pucp.newuas.model;

/**
 * Created by Andree on 04/11/2016.
 */

public class InvGroupsRequest {

    private Integer id;

    private String nombre;

    private Integer idEspecialidad;

    private String descripcion;

    private String imagen;

    private Integer idLider;

    private Specialty faculty;

    private Teacher leader;

    public InvGroupsRequest() {
    }

    public InvGroupsRequest(InvGroups ig) {
        this.id = ig.getId();
        this.nombre = ig.getNombre();
        this.idEspecialidad = ig.getIdEspecialidad();
        this.descripcion = ig.getDescripcion();
        this.imagen = ig.getImagen();
        this.idLider = ig.getIdLider();
        this.faculty = ig.getFaculty();
        this.leader = ig.getLeader();
    }

    public InvGroupsRequest(Integer id, String nombre, Integer idEspecialidad, String descripcion, String imagen, Integer idLider, Specialty faculty, Teacher leader) {
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
