package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by samoe on 28/09/2016.
 */

public class UserResponse {

    @SerializedName("token")
    private String token;

    @SerializedName("user")
    private User user;

    @SerializedName("faculties")
    private List<Specialty> specialtyList;

    public UserResponse() {

    }

    public List<Specialty> getSpecialtyList() {
        return specialtyList;
    }

    public void setSpecialtyList(ArrayList<Specialty> specialtyList) {
        this.specialtyList = specialtyList;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}