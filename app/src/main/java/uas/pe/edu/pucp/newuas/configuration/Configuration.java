package uas.pe.edu.pucp.newuas.configuration;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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

//"http://52.89.227.55";
    //public static final String BASE_URL = "http://52.89.227.55";//"http://192.168.0.11/internetUAS/public";//"http://52.89.227.55";//"http://10.101.2.35/internetUAS/public";  //"http://52.89.227.55/api";

    public static final String BASE_URL = "http://35.163.64.211";
    public static final String NOPHOTO_URL = "http://35.163.64.211/images/nofoto.png";


    public static final String FILE_URL = BASE_URL + "/uploads/";
    public static int CXE_ITEM_SHOW = 5;
    public static UserResponse LOGIN_USER = null;
    public static boolean connected = false;
    public static Specialty SPECIALTY = null;
    private static int idEspecialidad;
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
        return LOGIN_USER.getUser().getInvestigator() != null && LOGIN_USER.getUser().getTeacher() == null;
    }

    public static boolean isCoordinator() {
        return LOGIN_USER.getUser().getIdPerfil() == 1;
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

    public static boolean isStudent() {
        return LOGIN_USER.getUser().getIdPerfil() == 0;
    }

    public static boolean isStudentPsp() {
        return LOGIN_USER.getUser().getTutStudentForPsp() != null;
    }

    public static int getIdUsuario(){
        return LOGIN_USER.getUser().getIdUsuario();
    }

    public static boolean isConnected(Context context) {

        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

        return isConnected;

    }

    public static int getIdEspecialidad() {
        int idEspecialidad = 0;
        if (Configuration.isAccreditor()) {
            idEspecialidad = Configuration.LOGIN_USER.getUser().getAccreditor().getIdEspecialidad();
        } else {
            if (Configuration.isTeacher() || Configuration.isCoordinator()) {
                idEspecialidad = Configuration.LOGIN_USER.getUser().getTeacher().getIdEspecialidad();
            }
        }
        return idEspecialidad;
    }
}