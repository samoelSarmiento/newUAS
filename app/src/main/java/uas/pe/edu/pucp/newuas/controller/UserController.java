package uas.pe.edu.pucp.newuas.controller;

import android.content.Context;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import uas.pe.edu.pucp.newuas.datapersistency.RestCon;
import uas.pe.edu.pucp.newuas.datapersistency.RetrofitHelper;
import uas.pe.edu.pucp.newuas.model.UserRequest;
import uas.pe.edu.pucp.newuas.model.UserResponseAccreditor;

/**
 * Created by samoe on 21/09/2016.
 */
public class UserController {


    public boolean LogIn(final Context context, String user, String password) {
        RestCon restCon = RetrofitHelper.apiConnector.create(   RestCon.class);
        Call<UserResponseAccreditor> call = restCon.getAccreditor(new UserRequest(user, password));

        call.enqueue(new Callback<UserResponseAccreditor>() {
            @Override
            public void onResponse(Call<UserResponseAccreditor> call, retrofit2.Response<UserResponseAccreditor> response) {
                UserResponseAccreditor accreditor = response.body();
                System.out.println(accreditor.getUser().getAccreditor().getNombre());
            }

            @Override
            public void onFailure(Call<UserResponseAccreditor> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(context, "Error2aa", Toast.LENGTH_SHORT).show();
            }
        });

        return true;
    }
}
