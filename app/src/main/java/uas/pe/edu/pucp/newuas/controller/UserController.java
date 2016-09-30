package uas.pe.edu.pucp.newuas.controller;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Console;
import java.util.HashMap;

/**
 * Created by samoe on 21/09/2016.
 */
public class UserController {
    public static void LogIn(Context context , String user, String password){
        String URL_BASE = "http://192.168.1.53/internetUAS/public/api/";
        //String URL_BASE = "http://52.89.227.55/api/";
        String URL_COMPLEMENTO = "authenticate";

        // Mapeo de los pares clave-valor
        HashMap<String, String> parametros = new HashMap<>();
        parametros.put("user", user);
        parametros.put("password", password);
        System.out.println("Realizando en request");
        System.out.println(new JSONObject(parametros).toString());
        JsonObjectRequest jsArrayRequest = new JsonObjectRequest(
                Request.Method.POST,
                URL_BASE + URL_COMPLEMENTO,
                new JSONObject(parametros),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        JSONObject jsonUser;
                        try {
                            jsonUser = response.getJSONObject("user");
                            System.out.println(jsonUser.toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Manejo de errores
                        System.out.println("Error en el response");
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(jsArrayRequest);
    }
}
