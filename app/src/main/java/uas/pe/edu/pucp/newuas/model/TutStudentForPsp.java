package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by jemarroquin on 11/11/2016.
 */
public class TutStudentForPsp  implements Serializable {


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
    private String deletedAt;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("updated_at")
    private String updatedAt;


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }


    public String getCodigo() {
        return codigo;
    }


    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getApePaterno() {
        return apePaterno;
    }


    public void setApePaterno(String apePaterno) {
        this.apePaterno = apePaterno;
    }


    public String getApeMaterno() {
        return apeMaterno;
    }


    public void setApeMaterno(String apeMaterno) {
        this.apeMaterno = apeMaterno;
    }


    public String getCorreo() {
        return correo;
    }


    public void setCorreo(String correo) {
        this.correo = correo;
    }


    public Integer getIdEspecialidad() {
        return idEspecialidad;
    }


    public void setIdEspecialidad(Integer idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public Integer getIdTutoria() {
        return idTutoria;
    }

    public void setIdTutoria(Integer idTutoria) {
        this.idTutoria = idTutoria;
    }



}
