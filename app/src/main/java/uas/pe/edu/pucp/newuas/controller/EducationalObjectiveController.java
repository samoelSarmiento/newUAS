package uas.pe.edu.pucp.newuas.controller;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.datapersistency.RestCon;
import uas.pe.edu.pucp.newuas.datapersistency.RetrofitHelper;
import uas.pe.edu.pucp.newuas.fragment.EducationalObjectiveFragment;
import uas.pe.edu.pucp.newuas.model.EducationalObjective;

/**
 * Created by Marshall on 31/10/2016.
 */

public class EducationalObjectiveController {

    public void getEducationalObjectivesofPeriodSpec(final Context context, Integer idPeriod, Integer idSpecialty){
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);

        Map<String, String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());

        Call<List<EducationalObjective>> call = restCon.getEducationalObjectivesByPeriodSpecialty(idPeriod, idSpecialty,token);

        call.enqueue(new Callback<List<EducationalObjective>>() {
            @Override
            public void onResponse(Call<List<EducationalObjective>> call, Response<List<EducationalObjective>> response) {
                if(response.isSuccessful()){
                    List<EducationalObjective> eos = response.body();
                    EducationalObjectiveFragment eof = new EducationalObjectiveFragment();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("EducObjs", (Serializable)eos);
                    eof.setArguments(bundle);

                    ((Activity) context).getFragmentManager()
                            .beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.fragment_container, eof)
                            .commit();
                    ((Activity) context).setTitle("Objetivos Educacionales");



                }else{

                }
            }

            @Override
            public void onFailure(Call<List<EducationalObjective>> call, Throwable t) {
                //offline

            }
        });




    }
}
