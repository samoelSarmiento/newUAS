package uas.pe.edu.pucp.newuas.controller;

import android.content.Context;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.datapersistency.RestCon;
import uas.pe.edu.pucp.newuas.datapersistency.RetrofitHelper;

import uas.pe.edu.pucp.newuas.fragment.CoursesFragment;
import uas.pe.edu.pucp.newuas.model.CourseResponse;
import uas.pe.edu.pucp.newuas.model.UserRequest;

/**
 * Created by Marshall on 20/10/2016.
 */

public class SpecialtyController {

    public boolean getSpecialtybyid(final Context context) {
        /*
        RestCon restCon = RetrofitHelper.apiConnector.create( RestCon.class);
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
        */

        return true;


    }

    public boolean getCoursesxSpecialy(final Context context, int idEspecialiad){
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);
        Call<CourseResponse> call = restCon.getCoursesxSpecialty(idEspecialiad, Configuration.LOGIN_USER.getToken());
        call.enqueue(new Callback<CourseResponse>() {
            @Override
            public void onResponse(Call<CourseResponse> call, Response<CourseResponse> response) {
                if(response.isSuccessful()){
                    CourseResponse courseResponse = response.body();
                    System.out.println(courseResponse.getNombre());
                    Log.e("CXE",courseResponse.getNombre());
                    //CoursesFragment coursesFragment = new CoursesFragment();
                    //coursesFragment.getFragmentManager().beginTransaction().replace(R.id.fragment_container, coursesFragment).commit();
                }
            }

            @Override
            public void onFailure(Call<CourseResponse> call, Throwable t) {

            }
        });
        return true;
    }
}
