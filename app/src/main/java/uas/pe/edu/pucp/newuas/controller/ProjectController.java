package uas.pe.edu.pucp.newuas.controller;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.datapersistency.RestCon;
import uas.pe.edu.pucp.newuas.datapersistency.RetrofitHelper;
import uas.pe.edu.pucp.newuas.fragment.InvestigatorsFragment;
import uas.pe.edu.pucp.newuas.fragment.ProjectsFragment;
import uas.pe.edu.pucp.newuas.model.Investigator;
import uas.pe.edu.pucp.newuas.model.Projects;

/**
 * Created by Andree on 25/10/2016.
 */

public class ProjectController {

    Projects list = null;

    public Projects getProjects(final Context context) {

        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);

        Map<String, String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());
        Call<List<Projects>> call = restCon.getProjects(token);

        call.enqueue(new Callback<List<Projects>>() {
            @Override
            public void onResponse(Call<List<Projects>> call, retrofit2.Response<List<Projects>> response) {
                //Toast.makeText(context,response.toString(), Toast.LENGTH_SHORT).show();

                if (response.isSuccessful()) {
                    //okhttp3.Response raw = response.raw();
                    //SpecialtyResponse
                    List<Projects> example = response.body();

                    //Gson gson = new Gson();

                    //UserResponse userr = Configuration.LOGIN_USER;
                    //User user = userr.getUser();

                    //Configuration.SPECIALTY = example;

                    //Gson gsonf = new Gson();
                    //String spj = gsonf.toJson(example);
                    //System.out.println(spj);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Projects", (Serializable)example);
                    //bundle.putString("Projects", spj);

                    ProjectsFragment spFragment = new ProjectsFragment();
                    spFragment.setArguments(bundle);
                    ((Activity)context).getFragmentManager().beginTransaction().replace(R.id.fragment_container,spFragment).commit();
                    ((Activity)context).setTitle("Proyectos");
                    //Toast.makeText(context, "entre", Toast.LENGTH_SHORT).show();

                } else {
                    //Toast.makeText(context, response.message(), Toast.LENGTH_SHORT);
                    //Toast.makeText(context, "fuepe", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<List<Projects>> call, Throwable t) {
                t.printStackTrace();
                //Toast.makeText(context, call.request().url().toString(), Toast.LENGTH_SHORT);
                //Toast.makeText(context, "Error2aa", Toast.LENGTH_SHORT).show();
            }


        });

        return list;
    }

}
