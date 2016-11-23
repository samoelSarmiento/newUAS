package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by jemarroquin on 20/11/2016.
 */
public class DocumentStudentPsp implements Serializable {

    @SerializedName("id")
    private Integer id;
    @SerializedName("ruta")
    private String ruta;
    @SerializedName("titulo_plantilla")
    private String tituloPlantilla;
    @SerializedName("ruta_plantilla")
    private String rutaPlantilla;
    @SerializedName("observaciones")
    private String observaciones;
    @SerializedName("es_obligatorio")
    private String esObligatorio;
    @SerializedName("idstudent")
    private Integer idstudent;
    @SerializedName("idtemplate")
    private Integer idtemplate;
    @SerializedName("idtipoestado")
    private Integer idtipoestado;
    @SerializedName("numerofase")
    private Integer numerofase;
    @SerializedName("fecha_limite")
    private String fechaLimite;
    @SerializedName("es_fisico")
    private Integer esFisico;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRuta() {
        return ruta;
    }

     public void setRuta(String ruta) {
        this.ruta = ruta;
    }

     public String getTituloPlantilla() {
        return tituloPlantilla;
    }

       public void setTituloPlantilla(String tituloPlantilla) {
        this.tituloPlantilla = tituloPlantilla;
    }

       public String getRutaPlantilla() {
        return rutaPlantilla;
    }


    public void setRutaPlantilla(String rutaPlantilla) {
        this.rutaPlantilla = rutaPlantilla;
    }

       public String getObservaciones() {
        return observaciones;
    }

       public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

     public String getEsObligatorio() {
        return esObligatorio;
    }

      public void setEsObligatorio(String esObligatorio) {
        this.esObligatorio = esObligatorio;
    }


    public Integer getIdstudent() {
        return idstudent;
    }

       public void setIdstudent(Integer idstudent) {
        this.idstudent = idstudent;
    }

       public Integer getIdtemplate() {
        return idtemplate;
    }

      public void setIdtemplate(Integer idtemplate) {
        this.idtemplate = idtemplate;
    }

      public Integer getIdtipoestado() {
        return idtipoestado;
    }
    public void setIdtipoestado(Integer idtipoestado) {
        this.idtipoestado = idtipoestado;
    }

        public Integer getNumerofase() {
        return numerofase;
    }


    public void setNumerofase(Integer numerofase) {
        this.numerofase = numerofase;
    }


    public String getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(String fechaLimite) {
        this.fechaLimite = fechaLimite;
    }


    public Integer getEsFisico() {
        return esFisico;
    }

    public void setEsFisico(Integer esFisico) {
        this.esFisico = esFisico;
    }






}
