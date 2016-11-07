package uas.pe.edu.pucp.newuas.controller;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;

import android.provider.Settings;

import android.widget.TextView;

import android.widget.Toast;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.datapersistency.DatabaseHelper;
import uas.pe.edu.pucp.newuas.datapersistency.RestCon;
import uas.pe.edu.pucp.newuas.datapersistency.RetrofitHelper;
import uas.pe.edu.pucp.newuas.model.Specialty;
import uas.pe.edu.pucp.newuas.model.Teacher;
import uas.pe.edu.pucp.newuas.model.User;
import uas.pe.edu.pucp.newuas.model.UserRequest;
import uas.pe.edu.pucp.newuas.model.UserResponse;
import uas.pe.edu.pucp.newuas.view.LogInActivity;
import uas.pe.edu.pucp.newuas.view.MainActivity;

public class UserController {





    public boolean logIn(final Context context, final String user, String password){
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);
        Call<UserResponse> call = restCon.getUser(new UserRequest(user, password));

        final ProgressDialog pd = new ProgressDialog(context );
        pd.setMessage("Cargando...");
        pd.setCanceledOnTouchOutside(false);
        pd.show();

        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, retrofit2.Response<UserResponse> response) {
                if (response.isSuccessful()) {
                    UserResponse user = response.body();
                    Configuration.LOGIN_USER = user;
                    Intent intent = new Intent(context, MainActivity.class);
                    context.startActivity(intent);
                } else {
                    Toast.makeText(context, "Usuario o contraseña incorrectos", Toast.LENGTH_LONG).show();

                    if(pd.isShowing())  pd.dismiss();
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(context, "Error de conexión.", Toast.LENGTH_SHORT).show();
                if(pd.isShowing())  pd.dismiss();
            }
        });

        return true;
    }

}
