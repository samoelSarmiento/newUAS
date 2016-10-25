package uas.pe.edu.pucp.newuas.controller;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

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
import uas.pe.edu.pucp.newuas.fragment.MeasurePeriodListFragment;
import uas.pe.edu.pucp.newuas.fragment.SpecialtyFragment;
import uas.pe.edu.pucp.newuas.model.Period;
import uas.pe.edu.pucp.newuas.model.Specialty;

/**
 * Created by Marshall on 23/10/2016.
 */

public class MeasurePeriodController {

    public boolean getMeasurePeriods(final Context context){
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);

        Map<String, String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());

        Call<List<Period>> call;

        if (Configuration.LOGIN_USER.getUser().getIdPerfil() == 3){
            call = restCon.getPeriods(Configuration.SPECIALTY.getIdEspecialidad(), token);
        }else{
            call = restCon.getPeriods(Configuration.LOGIN_USER.getUser().getAccreditor().getIdEspecialidad(), token);
        }


        call.enqueue(new Callback<List<Period>>() {
            @Override
            public void onResponse(Call<List<Period>> call, Response<List<Period>> response) {
                if (response.isSuccessful()){
                    List<Period> periods = response.body();

                    MeasurePeriodListFragment mplFragment = new MeasurePeriodListFragment();
                    /*Gson gsonf = new Gson();
                    String spj = gsonf.toJson(periods);
                    System.out.println(spj);*/
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Periods", (Serializable)periods);
                    mplFragment.setArguments(bundle);
                    Log.d("TAG", response.body().toString());

                    ((Activity)context).getFragmentManager().beginTransaction().replace(R.id.fragment_container,mplFragment).commit();
                    ((Activity)context).setTitle("Periodos de Medicion");


                }else{
                    Log.d("tag",response.errorBody().toString());
                }

            }

            @Override
            public void onFailure(Call<List<Period>> call, Throwable t) {

            }
        });


        return true;
    }
}
