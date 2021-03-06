package uas.pe.edu.pucp.newuas.controller;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
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
import uas.pe.edu.pucp.newuas.fragment.MeasurePeriodListFragment;
import uas.pe.edu.pucp.newuas.fragment.MeasurePeriodViewFragment;
import uas.pe.edu.pucp.newuas.fragment.SpecialtyFragment;
import uas.pe.edu.pucp.newuas.model.Period;
import uas.pe.edu.pucp.newuas.model.Specialty;

/**
 * Created by Marshall on 23/10/2016.
 */

public class MeasurePeriodController {

    public boolean getMeasurePeriods(final Context context, final Integer idSpec) {
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);
        Map<String, String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());
        Call<List<Period>> call = restCon.getPeriods(idSpec, token);

        call.enqueue(new Callback<List<Period>>() {
            @Override
            public void onResponse(Call<List<Period>> call, Response<List<Period>> response) {
                if (response.isSuccessful()) {
                    List<Period> periods = response.body();
                    MeasurePeriodListFragment mplFragment = new MeasurePeriodListFragment();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Periods", (Serializable) periods);
                    mplFragment.setArguments(bundle);
                    /*try {
                        DatabaseHelperOperations.savePeriods(context, periods);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }*/
                    ((Activity) context).getFragmentManager()
                            .beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.fragment_container, mplFragment)
                            .commit();
                    ((Activity) context).setTitle("Periodos de Medicion");
                } else {
                    Log.d("tag", response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<List<Period>> call, Throwable t) {
                /*try {
                    List<Period> per = DatabaseHelperOperations.retrievePeriods(context, idSpec);
                    MeasurePeriodListFragment mplFragment = new MeasurePeriodListFragment();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Periods", (Serializable) per);
                    mplFragment.setArguments(bundle);

                    ((Activity) context).getFragmentManager()
                            .beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.fragment_container, mplFragment)
                            .commit();
                    ((Activity) context).setTitle("Periodos de Medicion");
                } catch (SQLException e) {
                    e.printStackTrace();
                }*/
                Toast.makeText(context, R.string.connection_error, Toast.LENGTH_LONG).show();
            }
        });
        return true;
    }

    public boolean getMeasurePeriod(final Context context, final Integer idPeriod) {
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);
        Map<String, String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());
        Call<Period> call = restCon.getPeriod(idPeriod, token);

        call.enqueue(new Callback<Period>() {
            @Override
            public void onResponse(Call<Period> call, Response<Period> response) {
                if (response.isSuccessful()) {
                    Period periods = response.body();

                    MeasurePeriodViewFragment mpvFragment = new MeasurePeriodViewFragment();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Period", (Serializable) periods);
                    mpvFragment.setArguments(bundle);
                    Log.d("TAG", response.body().toString());

                    /*try {
                        DatabaseHelperOperations.savePeriod(periods, context);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }*/

                    ((Activity) context).getFragmentManager()
                            .beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.fragment_container, mpvFragment)
                            .commit();
                    ((Activity) context).setTitle("Periodos de Medicion");
                } else {
                    Log.d("tag", response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<Period> call, Throwable t) {
                /*try {
                    Period per = DatabaseHelperOperations.getPeriod(idPeriod, context);
                    MeasurePeriodViewFragment mpvFragment = new MeasurePeriodViewFragment();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Period", (Serializable) per);
                    mpvFragment.setArguments(bundle);

                    ((Activity) context).getFragmentManager()
                            .beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.fragment_container, mpvFragment)
                            .commit();
                    ((Activity) context).setTitle("Periodo de Medicion");
                } catch (SQLException e) {
                    e.printStackTrace();
                }*/
                Toast.makeText(context, R.string.connection_error, Toast.LENGTH_LONG).show();
            }
        });
        return true;
    }
}
