package uas.pe.edu.pucp.newuas.datapersistency;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.model.UserPrefs;

/**
 * Created by samoe on 17/10/2016.
 */

public class SharedPreference {
    private Context context;

    public SharedPreference(Context context) {
        this.context = context;
    }

    public void setUser(UserPrefs user){
        SharedPreferences.Editor editor = context.getSharedPreferences(Configuration.SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE).edit();
        Gson gson = new Gson();
        String json = gson.toJson(user);
        editor.putString(Configuration.USER_LOGIN,json);
        editor.apply();
    }

}
