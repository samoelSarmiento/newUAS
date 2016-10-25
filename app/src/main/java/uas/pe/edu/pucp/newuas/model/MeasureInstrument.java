package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Marshall on 25/10/2016.
 */

public class MeasureInstrument implements Serializable {
    @SerializedName("IdFuenteMedicion")
    @Expose
    private Integer idFuenteMedicion;
    @SerializedName("IdEspecialidad")
    @Expose
    private Integer idEspecialidad;
    @SerializedName("Nombre")
    @Expose
    private String nombre;


    /**
     * No args constructor for use in serialization
     *
     */
    public MeasureInstrument() {
    }

    /**

     * @param idFuenteMedicion
     * @param idEspecialidad
     */
    public MeasureInstrument(Integer idFuenteMedicion, Integer idEspecialidad, String nombre) {
        this.idFuenteMedicion = idFuenteMedicion;
        this.idEspecialidad = idEspecialidad;
        this.nombre = nombre;
    }

    /**
     *
     * @return
     * The idFuenteMedicion
     */
    public Integer getIdFuenteMedicion() {
        return idFuenteMedicion;
    }

    /**
     *
     * @param idFuenteMedicion
     * The IdFuenteMedicion
     */
    public void setIdFuenteMedicion(Integer idFuenteMedicion) {
        this.idFuenteMedicion = idFuenteMedicion;
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


}
