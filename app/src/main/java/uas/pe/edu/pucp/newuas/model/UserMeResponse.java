package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Andree on 21/10/2016.
 */

public class UserMeResponse {

    @SerializedName("Usuario")
    private UserMe userMe;

    public void setUserMe(UserMe userMe) {
        this.userMe = userMe;
    }

    public UserMe getUserMe() {
        return userMe;

    }
}
