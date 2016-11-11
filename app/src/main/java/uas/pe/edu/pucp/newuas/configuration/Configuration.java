package uas.pe.edu.pucp.newuas.configuration;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import uas.pe.edu.pucp.newuas.datapersistency.DatabaseHelper;
import uas.pe.edu.pucp.newuas.model.CourseResponse;
import uas.pe.edu.pucp.newuas.model.Specialty;
import uas.pe.edu.pucp.newuas.model.User;
import uas.pe.edu.pucp.newuas.model.UserResponse;

/**
 * Created by samoe on 18/10/2016.
 */

public class Configuration {
    public static final String SHARED_PREFERENCE_NAME = "sharedPreferences";
    public static final String USER_PREFERENCE = "userPrefs";
    public static final String BASE_URL = "http://52.89.227.55";//"http://10.101.2.35/internetUAS/public";  //"http://52.89.227.55/api";
    public static final String FILE_URL = BASE_URL + "/uploads/";
    public static int CXE_ITEM_SHOW = 5;
    public static UserResponse LOGIN_USER = null;
    public static boolean connected = false;
    public static Specialty SPECIALTY = null;
    //public static final DatabaseHelper HELPER;

    public static boolean isAdmin() {
        return LOGIN_USER.getUser().getIdPerfil() == 3;
    }

    public static boolean isTeacher() {
        return LOGIN_USER.getUser().getIdPerfil() == 2;
    }

    public static boolean isTeacherAndInvestigator() {
        return LOGIN_USER.getUser().getInvestigator() != null && LOGIN_USER.getUser().getTeacher() != null;
    }

    public static boolean isOnlyInvestigator() {
        Log.d("mmm",(LOGIN_USER.getUser().getInvestigator() != null )+ "");
        Log.d("mmm2",(LOGIN_USER.getUser().getTeacher() == null )+ "");
        return LOGIN_USER.getUser().getInvestigator() != null && LOGIN_USER.getUser().getTeacher() == null;
    }

    public static boolean isAccreditor() {
        return LOGIN_USER.getUser().getIdPerfil() == 4;
    }

    public static boolean isOnlySupervisor() {
        return LOGIN_USER.getUser().getIdPerfil() == 6;
    }

    public static boolean isTeacherAndSupervisor() {
        return LOGIN_USER.getUser().getIdPerfil() == 6;
    }
}
