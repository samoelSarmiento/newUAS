package uas.pe.edu.pucp.newuas.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Franz on 20/10/2016.
 */

public class PSPStudent  implements Serializable {


    @SerializedName("IdAlumno")
    private int idAlumno;

    @SerializedName("Codigo")
    private int codigo;

    @SerializedName("Nombre")
    private String nombre;

    @SerializedName("ApellidoPaterno")
    private String apellidoPaterno;

    @SerializedName("ApellidoMaterno")
    private String apellidoMaterno;





    public Integer getIdAlumno() {
        return idAlumno;
    }

    /**
     *
     * @param idAlumno
     * The IdAlumno
     */
    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getCodigo() {
        return codigo;
    }

    /**
     *
     * @param codigo
     * The Codigo
     */
    public void setCodigo(int codigo) {
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


}
