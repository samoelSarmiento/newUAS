package uas.pe.edu.pucp.newuas.controller;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

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
import uas.pe.edu.pucp.newuas.fragment.ImprovementPlanListFragment;
import uas.pe.edu.pucp.newuas.model.ImprovementPlan;
import uas.pe.edu.pucp.newuas.model.Period;

/**
 * Created by Marshall on 2/11/2016.
 */

public class ImprovementPlanController {

    public void getImprovementPlansofSpecialty(final Context context, Integer specId){
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);

        Map<String, String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());

        Call<List<ImprovementPlan>> call;
        call = restCon.getImprovementPlansofSpecialty(specId,token);

        call.enqueue(new Callback<List<ImprovementPlan>>() {
            @Override
            public void onResponse(Call<List<ImprovementPlan>> call, Response<List<ImprovementPlan>> response) {
                if(response.isSuccessful()){
                    List<ImprovementPlan> list = response.body();
                    ImprovementPlanListFragment iplf = new ImprovementPlanListFragment();

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("ImprovementPlans",(Serializable)list);
                    iplf.setArguments(bundle);

                    ((Activity) context).getFragmentManager()
                            .beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.fragment_container, iplf)
                            .commit();
                    ((Activity) context).setTitle("Planes de Mejora");




                }else{
                    Log.d("wat",response.errorBody().toString());

                }

            }

            @Override
            public void onFailure(Call<List<ImprovementPlan>> call, Throwable t) {

            }
        });



    }

}
