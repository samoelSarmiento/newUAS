package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Franz on 24/11/2016.
 */

public class PSPNotificationScpreRequest {

    @SerializedName("IdAlumno")
    private
    int codigo;

    @SerializedName("final_score")
    private
    int score;


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
