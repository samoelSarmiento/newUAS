package uas.pe.edu.pucp.newuas.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;
import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.datapersistency.RestCon;
import uas.pe.edu.pucp.newuas.datapersistency.RetrofitHelper;

import uas.pe.edu.pucp.newuas.datapersistency.SharedPreference;
import uas.pe.edu.pucp.newuas.fragment.SpecialtyFragment;
import uas.pe.edu.pucp.newuas.model.Accreditor;
import uas.pe.edu.pucp.newuas.model.CourseResponse;
import uas.pe.edu.pucp.newuas.model.Specialty;
import uas.pe.edu.pucp.newuas.model.SpecialtyResponse;
import uas.pe.edu.pucp.newuas.model.Teacher;
import uas.pe.edu.pucp.newuas.model.User;
import uas.pe.edu.pucp.newuas.model.UserRequest;
import uas.pe.edu.pucp.newuas.model.UserResponse;
import uas.pe.edu.pucp.newuas.view.MainActivity;

/**
 * Created by Marshall on 20/10/2016.
 */

public class SpecialtyController {

    Specialty list = null;

    public Specialty getSpecialties(final Context context) {


        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);

        Map<String, String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());
        Call<Specialty> call = restCon.getSpecialtyById(Configuration.LOGIN_USER.getUser().getAccreditor().getIdEspecialidad(), token);


        call.enqueue(new Callback<Specialty>() {
            @Override
            public void onResponse(Call<Specialty> call, retrofit2.Response<Specialty> response) {
                Log.d("LOG", response.isSuccessful() + "");
                /*

                try {
                    Log.d("BODY",response.message());
                    Log.d("BODY",response.errorBody().string());
                    Log.d("BODY",response.errorBody().string());
                    Log.d("BODY",response.errorBody().string());
                } catch (Exception e) {
                    Toast.makeText(context,response.message(),Toast.LENGTH_SHORT);
                    e.printStackTrace();
                }

                */

                //Log.e("PRUBA",response.body().getToken());
                //Log.e("PRUBA"   ,response.body().getSpecialtyList().get(1).getNombre());

                if (response.isSuccessful()) {
                    okhttp3.Response raw = response.raw();
                    //SpecialtyResponse
                    Specialty example = response.body();
                    Log.d("LOG", String.valueOf(response.code()));
                    Log.d("LOG", response.body().toString());
                    Log.d("LOG", response.message());

                    Log.d("llego", "llego");
                    Gson gson = new Gson();
                    Log.d("wat ", gson.toJson(example));
                    Log.d("llego", "llego");
                    UserResponse userr = Configuration.LOGIN_USER;
                    User user = userr.getUser();
                    /*
                    System.out.println(example.get(0).getNombre());

                    if (user.getAccreditor() != null) {
                        Accreditor accreditor = user.getAccreditor();
                        for (int i = 0; i < example.size(); i++) {
                            Specialty sp = example.get(i);
                            System.out.println(sp.getNombre());
                            spec[0] = sp;
                            if (sp.getIdEspecialidad() == accreditor.getIdEspecialidad()) {
                                Configuration.SPECIALTY = sp;
                                break;
                            }
                        }


                    } else if (user.getTeacher() != null) {
                        Teacher teacher = user.getTeacher();
                        for (int i = 0; i < example.size(); i++) {
                            Specialty sp = example.get(i);
                            spec[0] = sp;
                            if (sp.getIdEspecialidad() == teacher.getIdEspecialidad()) {
                                Configuration.SPECIALTY = sp;
                                break;
                            }
                        }
                    }
                    */
                    Configuration.SPECIALTY = example;
                    SpecialtyFragment spFragment = new SpecialtyFragment();

                    Gson gsonf = new Gson();
                    String spj = gsonf.toJson(example);
                    System.out.println(spj);
                    Bundle bundle = new Bundle();
                    bundle.putString("Specialty", spj);
                    spFragment.setArguments(bundle);
                    ((Activity)context).getFragmentManager().beginTransaction().replace(R.id.fragment_container,spFragment).commit();
                    ((Activity)context).setTitle("Especialidad");


                } else {
                    Log.d("wat", response.errorBody().toString());

                    Toast.makeText(context, response.message(), Toast.LENGTH_SHORT);
                    Toast.makeText(context, "fuepe", Toast.LENGTH_SHORT).show();

                }


            }

            @Override
            public void onFailure(Call<Specialty> call, Throwable t) {
                //Log.d("wat", t.getMessage());
                //Log.d("wat", t.getMessage());

                t.printStackTrace();
                //Toast.makeText(context, call.request().url().toString(), Toast.LENGTH_SHORT);
                Toast.makeText(context, "Error2aa", Toast.LENGTH_SHORT).show();
            }
        });


//        Specialty list = null;
//        try {
//            list = call.execute().body();
//        } catch (IOException e) {
//            e.printStackTrace();
//
//
// }
        /*
        Configuration.SPECIALTY = list;

        if (Configuration.SPECIALTY == null) {
            Log.d("wat", "Es nulo");
        } else {
            Log.d("wat", "WAT");
        }
        */
        return list;

    }

    public boolean getCoursesxSpecialy(final Context context, int idEspecialiad) {
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);
        Map<String, String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());
        Call<CourseResponse> call = restCon.getCoursesxSpecialty(idEspecialiad, token);
        //Log.d("TAG",call.request().url());
        call.enqueue(new Callback<CourseResponse>() {
            @Override
            public void onResponse(Call<CourseResponse> call, Response<CourseResponse> response) {
                CourseResponse courseResponse = response.body();
                //System.out.println(courseResponse.getNombre());

                //CoursesFragment coursesFragment = new CoursesFragment();
                //coursesFragment.getFragmentManager().beginTransaction().replace(R.id.fragment_container, coursesFragment).commit();
            }

            @Override
            public void onFailure(Call<CourseResponse> call, Throwable t) {
                t.printStackTrace();
                System.out.println("ERROROROROR");
            }
        });
        return true;
    }
}
