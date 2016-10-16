package uas.pe.edu.pucp.newuas.controller;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.widget.Toast;

import com.android.volley.Network;
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

import uas.pe.edu.pucp.newuas.model.User;

/**
 * Created by samoe on 21/09/2016.
 */
public class UserController {
    public static boolean LogIn(final Context context , String user, String password){
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
                            Intent intent = new Intent(context,null);
                            //mover al intent siguiente de vista inicial
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
                        Toast.makeText(context,"Usuario o contraseña incorrrectos",Toast.LENGTH_LONG).show();
                        //regresar al intent normal
                    }
                });
        //Se verifica incialmente si se esta conectado a internet
        if(!InternetConnection.isOnline(context)){
            DatabaseHandler db = new DatabaseHandler(context,"dp2",null,1);
            //verificar si el usuario ya existe
            if (db.checkIfUserExists(user)){
                User userLogged = db.queryUser(user,"");
                //retornar true supongo
                return true;
            }else{
                Toast.makeText(context,"Error de conexion",Toast.LENGTH_LONG).show();
                return false;
            }
        }
        //si tiene internet realizar el request al server
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(jsArrayRequest);
        return true;
    }
}
