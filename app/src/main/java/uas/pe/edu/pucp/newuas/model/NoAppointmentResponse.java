package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wingerlion on 23/11/2016.
 */
public class NoAppointmentResponse implements Serializable {

    @SerializedName("duracionCita")
    private Integer duracionCita;
    @SerializedName("studentInfo")
    private List<StudentInfoResponse> studentInfo = new ArrayList<StudentInfoResponse>();
    @SerializedName("tutorInfo")
    private List<TutorInfoResponse> tutorInfo = new ArrayList<TutorInfoResponse>();
    @SerializedName("scheduleInfo")
    private List<ScheduleInfoResponse> scheduleInfo = new ArrayList<ScheduleInfoResponse>();
    @SerializedName("scheduleMeeting")
    private List<ScheduleMeetingResponse> scheduleMeeting = new ArrayList<ScheduleMeetingResponse>();
    /**
     *
     * @return
     * The duracionCita
     */
    public Integer getDuracionCita() {
        return duracionCita;
    }

    /**
     *
     * @param duracionCita
     * The duracionCita
     */
    public void setDuracionCita(Integer duracionCita) {
        this.duracionCita = duracionCita;
    }

    /**
     *
     * @return
     * The studentInfo
     */
    public List<StudentInfoResponse> getStudentInfo() {
        return studentInfo;
    }

    /**
     *
     * @param studentInfo
     * The studentInfo
     */
    public void setStudentInfo(List<StudentInfoResponse> studentInfo) {
        this.studentInfo = studentInfo;
    }

    /**
     *
     * @return
     * The tutorInfo
     */
    public List<TutorInfoResponse> getTutorInfo() {
        return tutorInfo;
    }

    /**
     *
     * @param tutorInfo
     * The tutorInfo
     */
    public void setTutorInfo(List<TutorInfoResponse> tutorInfo) {
        this.tutorInfo = tutorInfo;
    }

    /**
     *
     * @return
     * The scheduleInfo
     */
    public List<ScheduleInfoResponse> getScheduleInfo() {
        return scheduleInfo;
    }

    /**
     *
     * @param scheduleInfo
     * The scheduleInfo
     */
    public void setScheduleInfo(List<ScheduleInfoResponse> scheduleInfo) {
        this.scheduleInfo = scheduleInfo;
    }

    /**
     *
     * @return
     * The scheduleMeeting
     */
    public List<ScheduleMeetingResponse> getScheduleMeeting() {
        return scheduleMeeting;
    }

    /**
     *
     * @param scheduleMeeting
     * The scheduleMeeting
     */
    public void setScheduleMeeting(List<ScheduleMeetingResponse> scheduleMeeting) {
        this.scheduleMeeting = scheduleMeeting;
    }


}
