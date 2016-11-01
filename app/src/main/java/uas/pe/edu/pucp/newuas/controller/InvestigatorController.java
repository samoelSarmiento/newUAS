package uas.pe.edu.pucp.newuas.controller;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.datapersistency.RestCon;
import uas.pe.edu.pucp.newuas.datapersistency.RetrofitHelper;
import uas.pe.edu.pucp.newuas.fragment.InvDetailFragment;
import uas.pe.edu.pucp.newuas.fragment.InvestigatorsFragment;
import uas.pe.edu.pucp.newuas.fragment.MeasurePeriodListFragment;
import uas.pe.edu.pucp.newuas.model.Investigator;
import uas.pe.edu.pucp.newuas.model.Period;

/**
 * Created by Andree on 24/10/2016.
 */

public class InvestigatorController {

    Investigator list = null;

    public Investigator getInvestigators(final Context context) {

        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);

        Map<String, String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());
        Call<List<Investigator>> call = restCon.getInvestigators(token);

        call.enqueue(new Callback<List<Investigator>>() {
            @Override
            public void onResponse(Call<List<Investigator>> call, retrofit2.Response<List<Investigator>> response) {
                //Toast.makeText(context,response.toString(), Toast.LENGTH_SHORT).show();

                if (response.isSuccessful()) {
                    //okhttp3.Response raw = response.raw();
                    //SpecialtyResponse
                    List<Investigator> example = response.body();
                    //Gson gson = new Gson();

                    //UserResponse userr = Configuration.LOGIN_USER;
                    //User user = userr.getUser();

                    //Configuration.SPECIALTY = example;

                    //Gson gsonf = new Gson();
                    //String spj = gsonf.toJson(example);
                    //System.out.println(spj);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Investigators", (Serializable)example);
                    //bundle.putString("Investigators", spj);

                    InvestigatorsFragment spFragment = new InvestigatorsFragment();
                    spFragment.setArguments(bundle);
                    ((Activity)context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container,spFragment).commit();
                    ((Activity)context).setTitle("Investigadores");
                    //Toast.makeText(context, "entre", Toast.LENGTH_SHORT).show();

                } else {
                    //Toast.makeText(context, response.message(), Toast.LENGTH_SHORT);
                    //Toast.makeText(context, "fuepe", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<List<Investigator>> call, Throwable t) {
                t.printStackTrace();
                //Toast.makeText(context, call.request().url().toString(), Toast.LENGTH_SHORT);
                //Toast.makeText(context, "Error2aa", Toast.LENGTH_SHORT).show();
            }


        });

        return list;
    }

    public Investigator getInvestigatorById(final Context context, final int id){

        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);

        Map<String, String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());
        Call<List<Investigator>> call = restCon.getInvById(id,token);

        call.enqueue(new Callback<List<Investigator>>() {
            @Override
            public void onResponse(Call<List<Investigator>> call, retrofit2.Response<List<Investigator>> response) {
                //Toast.makeText(context,response.toString(), Toast.LENGTH_SHORT).show();

                if (response.isSuccessful()) {

                    List<Investigator> example = response.body();

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Inv", (Serializable)example);
                    //bundle.putString("Investigators", spj);

                    InvDetailFragment spFragment = new InvDetailFragment();
                    spFragment.setArguments(bundle);
                    ((Activity)context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container,spFragment).commit();
                    ((Activity)context).setTitle("Investigadores");
                    //Toast.makeText(context, "entre", Toast.LENGTH_SHORT).show();

                } else {

                }

            }

            @Override
            public void onFailure(Call<List<Investigator>> call, Throwable t) {
                t.printStackTrace();

            }
        });
        return  list;
    }

    public void editInv(final Context context,final Investigator inv){
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);

        Map<String, String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());

        Call<String> call = restCon.editInvestigator(inv.getId(),token,inv);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, retrofit2.Response<String> response) {
                //Toast.makeText(context,response.toString(), Toast.LENGTH_SHORT).show();

                if (response.isSuccessful()) {

                } else {
                    //Toast.makeText(context, "entre2", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                t.printStackTrace();

            }
        });
    }
}
