package uas.pe.edu.pucp.newuas.model;

/**
 * Created by samoe on 04/11/2016.
 */

public class SuggestionRequest {
    private int idDocente;
    private int idEspecialidad;
    private String titulo;
    private String descripcion;

    public SuggestionRequest(int idDocente, int idEspecialidad, String titulo, String descripcion) {
        this.idDocente = idDocente;
        this.idEspecialidad = idEspecialidad;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }
}
