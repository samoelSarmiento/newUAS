package uas.pe.edu.pucp.newuas.model;

/**
 * Created by samoe on 28/09/2016.
 */

public class User {
    int id;
    int idPerfil;
    String user;

    public User(int id, int idPerfil, String user) {
        this.id = id;
        this.idPerfil = idPerfil;
        this.user = user;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
