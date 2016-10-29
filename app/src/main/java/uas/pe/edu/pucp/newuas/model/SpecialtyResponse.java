package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Marshall on 20/10/2016.
 */

public class SpecialtyResponse {
    /*@SerializedName("token")
    private String token; */

    private List<Specialty> specialtyList;

    /*
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
*/

    public List<Specialty> getSpecialtyList() {
        return specialtyList;
    }

    public void setSpecialtyList(List<Specialty> specialtyList) {
        this.specialtyList = specialtyList;
    }
}
