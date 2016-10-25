package uas.pe.edu.pucp.newuas.model;

/**
 * Created by samoe on 18/10/2016.
 */

public class UserPrefs {
    private int idUsuario;
    private String usuario;
    private boolean login;

    public UserPrefs(int idUsuario, String usuario) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.login = false;
    }
}
