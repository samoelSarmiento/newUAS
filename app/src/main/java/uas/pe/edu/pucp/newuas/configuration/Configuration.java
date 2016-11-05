package uas.pe.edu.pucp.newuas.configuration;

import java.util.ArrayList;
import java.util.List;

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
    public static final String BASE_URL = "http://52.89.227.55/api";
    public static int CXE_ITEM_SHOW = 5;
    public static UserResponse LOGIN_USER = null;
    public static boolean connected = false;
    public static Specialty SPECIALTY = null;
}
