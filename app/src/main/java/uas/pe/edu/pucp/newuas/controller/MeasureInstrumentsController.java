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
import uas.pe.edu.pucp.newuas.fragment.MeasureInstrumentsFragment;
import uas.pe.edu.pucp.newuas.model.MeasureInstrument;
import uas.pe.edu.pucp.newuas.model.Period;

/**
 * Created by Marshall on 23/10/2016.
 */

public class MeasureInstrumentsController {
    public boolean getMeasureInstrumentsOfPeriod(Integer idPeriod, final Context context){

        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);

        Map<String, String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());
        Call<List<MeasureInstrument>> call = restCon.getMeaInstofPer(idPeriod, token);


        call.enqueue(new Callback<List<MeasureInstrument>>() {
            @Override
            public void onResponse(Call<List<MeasureInstrument>> call, Response<List<MeasureInstrument>> response) {
                if(response.isSuccessful()){
                    List<MeasureInstrument> lmi = response.body();

                    MeasureInstrumentsFragment mif = new MeasureInstrumentsFragment();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("MeasureInst",(Serializable)lmi);
                    mif.setArguments(bundle);
                    ((Activity)context).getFragmentManager().beginTransaction().replace(R.id.fragment_container,mif).commit();
                    ((Activity)context).setTitle("Instrumentos de Medicion");

                }else{
                    Log.d("TAG",response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<List<MeasureInstrument>> call, Throwable t) {
                t.printStackTrace();

            }
        });





        return true;

    }


}
