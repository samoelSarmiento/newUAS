package uas.pe.edu.pucp.newuas.model;

/**
 * Created by Franz on 21/10/2016.
 */

public class PSPSupervisor {

    private String name;
    private String identifier;


    public String getName() {
        return name;
    }

    public void setNombre(String nombre) {
        this.name = nombre;
    }

    public String getCodigo() {
        return identifier;
    }

    public void setCodigo(String codigo) {
        this.identifier = codigo;
    }
}
