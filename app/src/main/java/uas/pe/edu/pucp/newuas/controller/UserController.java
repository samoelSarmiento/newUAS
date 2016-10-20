package uas.pe.edu.pucp.newuas.controller;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import uas.pe.edu.pucp.newuas.datapersistency.RestCon;
import uas.pe.edu.pucp.newuas.datapersistency.RetrofitHelper;
import uas.pe.edu.pucp.newuas.model.Example;
import uas.pe.edu.pucp.newuas.model.UserRequest;
import uas.pe.edu.pucp.newuas.view.MainActivity;

/**
 * Created by samoe on 21/09/2016.
 */
public class UserController {


    public boolean LogIn(final Context context, String user, String password) {
        RestCon restCon = RetrofitHelper.apiConnector.create(   RestCon.class);
        Call<Example> call = restCon.getAccreditor(new UserRequest(user, password));

        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, retrofit2.Response<Example> response) {
                Example example = response.body();
                System.out.println(example.getUser().getAccreditor().getNombre());
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(context, "Error2aa", Toast.LENGTH_SHORT).show();
            }
        });

        return true;
    }
}
