package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Franz on 09/11/2016.
 */

public class PSPMessage implements Serializable {


    @SerializedName("message")
    private String messsage;


    public String getMesssage() {
        return messsage;
    }

    public void setMesssage(String messsage) {
        this.messsage = messsage;
    }
}
