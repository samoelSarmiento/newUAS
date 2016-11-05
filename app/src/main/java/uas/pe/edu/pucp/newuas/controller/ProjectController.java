package uas.pe.edu.pucp.newuas.controller;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.Toast;

import com.google.gson.Gson;
import com.j256.ormlite.dao.Dao;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.datapersistency.DatabaseHelper;
import uas.pe.edu.pucp.newuas.datapersistency.RestCon;
import uas.pe.edu.pucp.newuas.datapersistency.RetrofitHelper;
import uas.pe.edu.pucp.newuas.fragment.InvestigatorsFragment;
import uas.pe.edu.pucp.newuas.fragment.ProjDetailFragment;
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
                    try {
                        saveAllProj(example, context);
                    } catch (SQLException e) {
                        //Toast.makeText(context, "Error al guardar los datos", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Projects", (Serializable)example);
                    //bundle.putString("Projects", spj);

                    ProjectsFragment spFragment = new ProjectsFragment();
                    spFragment.setArguments(bundle);
                    ((Activity)context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container,spFragment).commit();
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
                try {
                    List<Projects> projList = retriveAllProj(context);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Projects", (Serializable)projList);
                    //bundle.putString("Investigators", spj);

                    ProjectsFragment spFragment = new ProjectsFragment();
                    spFragment.setArguments(bundle);
                    ((Activity)context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container,spFragment).commit();
                    ((Activity)context).setTitle("Proyectos");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }


        });

        return list;
    }

    public Projects getProjectById(final Context context, final int id){

        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);

        Map<String, String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());
        Call<List<Projects>> call = restCon.getProjById(id,token);

        call.enqueue(new Callback<List<Projects>>() {
            @Override
            public void onResponse(Call<List<Projects>> call, retrofit2.Response<List<Projects>> response) {
                //Toast.makeText(context,response.toString(), Toast.LENGTH_SHORT).show();

                if (response.isSuccessful()) {

                    List<Projects> example = response.body();

                    try {
                        saveProj(example.get(0), context);
                    } catch (SQLException e) {
                        //Toast.makeText(context, "Error al guardar los datos", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Proj", (Serializable)example);
                    bundle.putBoolean("BotonEdit",true);
                    //bundle.putString("Investigators", spj);

                    ProjDetailFragment spFragment = new ProjDetailFragment();
                    spFragment.setArguments(bundle);
                    ((Activity)context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container,spFragment).commit();
                    ((Activity)context).setTitle("Proyectos");
                    //Toast.makeText(context, "entre", Toast.LENGTH_SHORT).show();

                } else {

                }

            }

            @Override
            public void onFailure(Call<List<Projects>> call, Throwable t) {
                t.printStackTrace();

                try {
                    Projects proj = getProj(id, context);

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Proj", (Serializable)proj);
                    bundle.putBoolean("BotonEdit",false);
                    //bundle.putString("Investigators", spj);

                    ProjDetailFragment spFragment = new ProjDetailFragment();
                    spFragment.setArguments(bundle);
                    ((Activity)context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container,spFragment).commit();
                    ((Activity)context).setTitle("Proyectos");

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });


        return  list;
    }

    public void editProj(final Context context,final Projects proj) {
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);

        Map<String, String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());

        Call<String> call = restCon.editProject(proj.getId(),token,proj);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, retrofit2.Response<String> response) {
                //Toast.makeText(context,response.toString(), Toast.LENGTH_SHORT).show();

                if (response.isSuccessful()) {

/*
                    try {
                        saveProj(proj, context);
                    } catch (SQLException e) {
                        //Toast.makeText(context, "Error al guardar los datos", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Proj", (Serializable)proj);
                    bundle.putBoolean("BotonEdit",true);
                    //bundle.putString("Investigators", spj);

                    ProjDetailFragment spFragment = new ProjDetailFragment();
                    spFragment.setArguments(bundle);
                    ((Activity)context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container,spFragment).commit();
                    ((Activity)context).setTitle("Proyectos");
*/
                } else {

                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                t.printStackTrace();
                //Toast.makeText(context, "No se pudo guardar", Toast.LENGTH_SHORT).show();
/*
                Bundle bundle = new Bundle();
                bundle.putSerializable("Proj", (Serializable)unchangedP);
                //bundle.putString("Investigators", spj);

                ProjDetailFragment spFragment = new ProjDetailFragment();
                spFragment.setArguments(bundle);
                ((Activity)context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container,spFragment).commit();
                ((Activity)context).setTitle("Proyectos");*/
            }
        });
        ConnectivityManager connectivityManager =(ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState()== NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState()==NetworkInfo.State.CONNECTED){
            //Toast.makeText(context, "conectado", Toast.LENGTH_SHORT).show();
            try {
                saveProj(proj, context);
                //Toast.makeText(context, "Se guardo en sql", Toast.LENGTH_SHORT).show();
            } catch (SQLException e) {
                //Toast.makeText(context, "Error al guardar los datos", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
            Toast.makeText(context, "Se guardo correctamente", Toast.LENGTH_SHORT).show();
        }else Toast.makeText(context, "No se pudo guardar", Toast.LENGTH_SHORT).show();

    }
    //Lista de proj
    private void saveAllProj(List<Projects> projList, final Context context) throws SQLException {
        DatabaseHelper helper = new DatabaseHelper(context);
        Dao<Projects, Integer> projDao = helper.getProjDao();
        //Toast.makeText(context, "entreDB", Toast.LENGTH_SHORT).show();
        for (Projects proj : projList) {
            //veo si la especialidad existe
            Projects find = projDao.queryForId(proj.getId());
            if (find == null) {
                projDao.create(proj);
            } else {
                //si se encontro la actualizo
                projDao.update(proj);
            }
        }
    }
    //Lista de proj.
    private List<Projects> retriveAllProj(final Context context) throws SQLException {
        DatabaseHelper helper = new DatabaseHelper(context);
        Dao<Projects, Integer> projDao = helper.getProjDao();
        return projDao.queryForAll();
    }

    public void saveProj(Projects proj, final Context context) throws SQLException {
        DatabaseHelper helper = new DatabaseHelper(context);
        Dao<Projects, Integer> projDao = helper.getProjDao();
        Projects find = projDao.queryForId(proj.getId());
        if (find == null) {
            projDao.create(proj);
        } else {
            projDao.update(proj);
        }
    }

    private Projects getProj(Integer id, final Context context) throws SQLException {
        DatabaseHelper helper = new DatabaseHelper(context);
        Dao<Projects, Integer> projDao = helper.getProjDao();
        return projDao.queryForId(id);
    }
}
