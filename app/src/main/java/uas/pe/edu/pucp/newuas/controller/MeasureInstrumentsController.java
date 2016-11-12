package uas.pe.edu.pucp.newuas.controller;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.datapersistency.DatabaseHelper;
import uas.pe.edu.pucp.newuas.datapersistency.DatabaseHelperOperations;
import uas.pe.edu.pucp.newuas.datapersistency.RestCon;
import uas.pe.edu.pucp.newuas.datapersistency.RetrofitHelper;
import uas.pe.edu.pucp.newuas.fragment.MeasureInstrumentsFragment;
import uas.pe.edu.pucp.newuas.model.MeasureInstrument;
import uas.pe.edu.pucp.newuas.model.Period;

/**
 * Created by Marshall on 23/10/2016.
 */

public class MeasureInstrumentsController {
    public boolean getMeasureInstrumentsOfPeriod(final Integer idPeriod, final Context context) {
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);
        Map<String, String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());
        Call<List<MeasureInstrument>> call = restCon.getMeaInstofPer(idPeriod, token);

        call.enqueue(new Callback<List<MeasureInstrument>>() {
            @Override
            public void onResponse(Call<List<MeasureInstrument>> call, Response<List<MeasureInstrument>> response) {
                if (response.isSuccessful()) {
                    List<MeasureInstrument> lmi = response.body();

                    MeasureInstrumentsFragment mif = new MeasureInstrumentsFragment();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("MeasureInst", (Serializable) lmi);
                    mif.setArguments(bundle);

                    try {
                        DatabaseHelperOperations.saveMeaInsts(context, lmi, idPeriod);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    ((Activity) context).getFragmentManager()
                            .beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.fragment_container, mif)
                            .commit();
                    ((Activity) context).setTitle("Instrumentos de Medicion");

                } else {
                    Log.d("TAG", response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<List<MeasureInstrument>> call, Throwable t) {
                try {
                    List<MeasureInstrument> lmi = DatabaseHelperOperations.retrieveMeaInstofPeriod(context, idPeriod);

                    MeasureInstrumentsFragment mif = new MeasureInstrumentsFragment();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("MeasureInst", (Serializable) lmi);
                    mif.setArguments(bundle);

                    ((Activity) context).getFragmentManager()
                            .beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.fragment_container, mif)
                            .commit();
                    ((Activity) context).setTitle("Instrumentos de Medicion");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                t.printStackTrace();
            }
        });
        return true;
    }
}
