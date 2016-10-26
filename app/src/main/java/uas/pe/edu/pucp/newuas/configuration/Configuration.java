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
    public static final String BASE_URL = "";
    public static final String API_AUTHENTICATE = "authenticate";
    public static final String Q_SELECT_ALL = "SELECT * FROM ";
    public static int CXE_ITEM_SHOW = 5;
    public static UserResponse LOGIN_USER = null;
    public static Specialty SPECIALTY = null;
}
