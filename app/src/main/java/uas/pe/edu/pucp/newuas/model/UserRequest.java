package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by samoe on 20/10/2016.
 */

public class UserRequest {

    private String user;
    private String password;

    public UserRequest(String user, String password) {
        this.user = user;
        this.password = password;
    }
}
