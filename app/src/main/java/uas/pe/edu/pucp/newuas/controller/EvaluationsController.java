package uas.pe.edu.pucp.newuas.controller;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

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
import uas.pe.edu.pucp.newuas.fragment.EvaluationResultListFragment;
import uas.pe.edu.pucp.newuas.fragment.InvDetailFragment;
import uas.pe.edu.pucp.newuas.fragment.InvestigatorsFragment;
import uas.pe.edu.pucp.newuas.model.Evaluation;
import uas.pe.edu.pucp.newuas.model.Investigator;
import uas.pe.edu.pucp.newuas.model.StringResponse;

/**
 * Created by Pedro on 04/11/2016.
 */

public class EvaluationsController {

    Evaluation list = null;

    public Evaluation getAllEvaluations(final Context context) {

        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);

        Map<String, String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());
        Call<List<Evaluation>> call = restCon.getEvaluations(token);

        call.enqueue(new Callback<List<Evaluation>>() {
            @Override
            public void onResponse(Call<List<Evaluation>> call, retrofit2.Response<List<Evaluation>> response) {
                //Toast.makeText(context,response.toString(), Toast.LENGTH_SHORT).show();

                if (response.isSuccessful()) {
                    List<Evaluation> evaluation = response.body();

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("evaluation", (Serializable)evaluation);

                    EvaluationResultListFragment fragment = new EvaluationResultListFragment();
                    fragment.setArguments(bundle);
                    ((Activity)context).getFragmentManager().beginTransaction()
                            .addToBackStack(null).replace(R.id.fragment_container,fragment).commit();
                    //bundle.putString("Investigators", spj);

                    /*InvestigatorsFragment spFragment = new InvestigatorsFragment();
                    spFragment.setArguments(bundle);
                    ((Activity)context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container,spFragment).commit();
                    ((Activity)context).setTitle("Evaluaciones");*/
                    //Toast.makeText(context, "entre", Toast.LENGTH_SHORT).show();

                } else {
                    //Toast.makeText(context, response.message(), Toast.LENGTH_SHORT);
                    //Toast.makeText(context, "fuepe", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<List<Evaluation>> call, Throwable t) {
                t.printStackTrace();
                //Toast.makeText(context, call.request().url().toString(), Toast.LENGTH_SHORT);
                //Toast.makeText(context, "Error2aa", Toast.LENGTH_SHORT).show();
                /*try {
                    List<Investigator> invList = retriveAllInv(context);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Investigators", (Serializable)invList);
                    //bundle.putString("Investigators", spj);

                    InvestigatorsFragment spFragment = new InvestigatorsFragment();
                    spFragment.setArguments(bundle);
                    ((Activity)context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container,spFragment).commit();
                    ((Activity)context).setTitle("Investigadores");
                } catch (SQLException e) {
                    e.printStackTrace();
                }*/
            }


        });

        return list;
    }
}
