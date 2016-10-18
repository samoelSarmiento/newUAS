package uas.pe.edu.pucp.newuas.datapersistency;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.model.Accreditor;

/**
 * Created by samoe on 17/10/2016.
 */

public class SharedPreference {
    private Context context;

    public SharedPreference(Context context) {
        this.context = context;
    }

    public void setUser(Accreditor user){
        SharedPreferences.Editor editor = context.getSharedPreferences(Configuration.SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE).edit();
        Gson gson = new Gson();
        String json = gson.toJson(user);
        editor.putString("user",json);
        editor.commit();
    }

    public Accreditor getAccreditor(){
        SharedPreferences sharedPreferences = context.getSharedPreferences(Configuration.SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(Configuration.ACCREDITOR_OBJ, "");
        Accreditor obj = gson.fromJson(json, Accreditor.class);
        return obj;
    }
}
