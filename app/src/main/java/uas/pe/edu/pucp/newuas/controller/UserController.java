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

import uas.pe.edu.pucp.newuas.model.Accreditor;
import uas.pe.edu.pucp.newuas.model.User;
import uas.pe.edu.pucp.newuas.view.MainActivity;

/**
 * Created by samoe on 21/09/2016.
 */
public class UserController {

    private static Accreditor parseAccreditor(JSONObject user) throws JSONException {
        int idUsuario = user.getInt("IdUsuario");
        int idPerfil = user.getInt("IdPerfil");
        String usuario = user.getString("Usuario");
        Accreditor accreditor = new Accreditor(idUsuario, idPerfil, usuario);
        JSONObject jsAccreditor = user.getJSONObject("accreditor");
        int idAcreditador = user.getInt("IdAcreditador");
        int idEspecialidad = jsAccreditor.getInt("IdEspecialidad");
        String nombre = jsAccreditor.getString("Nombre");
        String apellidoPaterno = jsAccreditor.getString("ApellidoPaterno");
        String apellidoMaterno = jsAccreditor.getString("ApellidoMaterno");
        String correo = jsAccreditor.getString("Correo");

        accreditor.setNombre(nombre);
        accreditor.setApellidoPaterno(apellidoPaterno);
        accreditor.setApellidoMaterno(apellidoMaterno);
        accreditor.setCorreo(correo);
        accreditor.setCargo("Acreditador");
        accreditor.setIdAcreditador(idAcreditador);
        accreditor.setIdEspecialidad(idEspecialidad);
        return accreditor;
    }

    public static boolean LogIn(final Context context, String user, String password) {
        String URL_BASE = "http://10.101.40.120/internetUAS/public/api/";
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
                            //if (jsonUser.getInt("IdPerfil") == 4){
                                Accreditor accreditor = parseAccreditor(jsonUser);
                            //}
                            //mover al intent siguiente de vista inicial
                            Intent intent = new Intent(context, MainActivity.class);
                            context.startActivity(intent);
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
                        Toast.makeText(context, "Usuario o contraseña incorrrectos", Toast.LENGTH_LONG).show();
                        //regresar al intent normal
                    }
                });
        //Se verifica incialmente si se esta conectado a internet
        if (!InternetConnection.isOnline(context)) {
            DatabaseHandler db = new DatabaseHandler(context, "dp2", null, 1);
            //verificar si el usuario ya existe
            if (db.checkIfUserExists(user)) {
                User userLogged = db.queryUser(user, "");
                //retornar true supongo
                return true;
            } else {
                Toast.makeText(context, "Error de conexion", Toast.LENGTH_LONG).show();
                return false;
            }
        }
        //si tiene internet realizar el request al server
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(jsArrayRequest);
        return true;
    }
}
