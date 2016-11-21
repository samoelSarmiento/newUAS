package uas.pe.edu.pucp.newuas.model;

import android.widget.ImageButton;

/**
 * Created by Wingerlion on 02/11/2016.
 */
public class SingleRowCoord {

    String code;
    String studentName;
    String tutorName;
    String state;


    public SingleRowCoord(String code, String studentName,  String tutorName, String state){
        this.code = code;
        this.studentName = studentName;
        this.tutorName = tutorName;
        this.state = state;
    }

    public String getCode() {
        return code;
    }
    public String getStudentName() {return studentName;}
    public String getTutorName() {
        return tutorName;
    }
    public String getState() {
        return state;
    }


}
