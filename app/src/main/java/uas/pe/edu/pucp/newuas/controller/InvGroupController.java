package uas.pe.edu.pucp.newuas.controller;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
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
import uas.pe.edu.pucp.newuas.fragment.InvGroupDetailFragment;
import uas.pe.edu.pucp.newuas.fragment.InvGroupFragment;
import uas.pe.edu.pucp.newuas.fragment.InvestigatorsFragment;
import uas.pe.edu.pucp.newuas.model.InvGroups;
import uas.pe.edu.pucp.newuas.model.Investigator;

/**
 * Created by Andree on 25/10/2016.
 */

public class InvGroupController {

    InvGroups list = null;

    public InvGroups getInvGroups(final Context context) {

        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);

        Map<String, String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());
        Call<List<InvGroups>> call = restCon.getInvGroups(token);

        call.enqueue(new Callback<List<InvGroups>>() {
            @Override
            public void onResponse(Call<List<InvGroups>> call, retrofit2.Response<List<InvGroups>> response) {
                //Toast.makeText(context,response.toString(), Toast.LENGTH_SHORT).show();

                if (response.isSuccessful()) {
                    //okhttp3.Response raw = response.raw();
                    //SpecialtyResponse
                    List<InvGroups> example = response.body();

                    //Gson gson = new Gson();

                    //UserResponse userr = Configuration.LOGIN_USER;
                    //User user = userr.getUser();

                    //Configuration.SPECIALTY = example;

                    //Gson gsonf = new Gson();
                    //String spj = gsonf.toJson(example);
                    //System.out.println(spj);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Groups", (Serializable)example);
                    //bundle.putString("Groups", spj);

                    InvGroupFragment spFragment = new InvGroupFragment();
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
            public void onFailure(Call<List<InvGroups>> call, Throwable t) {
                t.printStackTrace();
                //Toast.makeText(context, call.request().url().toString(), Toast.LENGTH_SHORT);
                //Toast.makeText(context, "Error2aa", Toast.LENGTH_SHORT).show();
            }


        });

        return list;
    }

    public InvGroups getInvGroupById(final Context context, final int id){

        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);

        Map<String, String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());
        Call<List<InvGroups>> call = restCon.getInvGroupById(id,token);

        call.enqueue(new Callback<List<InvGroups>>() {
            @Override
            public void onResponse(Call<List<InvGroups>> call, retrofit2.Response<List<InvGroups>> response) {
                //Toast.makeText(context,response.toString(), Toast.LENGTH_SHORT).show();

                if (response.isSuccessful()) {

                    List<InvGroups> example = response.body();

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("InvGroup", (Serializable)example);
                    

                    InvGroupDetailFragment spFragment = new InvGroupDetailFragment();
                    spFragment.setArguments(bundle);
                    //Toast.makeText(context, "entre3", Toast.LENGTH_SHORT).show();
                    ((Activity)context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container,spFragment).commit();
                    ((Activity)context).setTitle("Grupos de Inv.");
                    //Toast.makeText(context, "entre4", Toast.LENGTH_SHORT).show();
                    //Toast.makeText(context, "entre", Toast.LENGTH_SHORT).show();

                } else {

                }

            }

            @Override
            public void onFailure(Call<List<InvGroups>> call, Throwable t) {
                t.printStackTrace();
            }
        });

        return  list;
    }

    public void editInvGroup(final Context context,final InvGroups invG){
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);

        Map<String, String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());

        Call<String> call = restCon.editInvGroup(invG.getId(),token,invG);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, retrofit2.Response<String> response) {
                //Toast.makeText(context,response.toString(), Toast.LENGTH_SHORT).show();

                if (response.isSuccessful()) {


                    //List<InvGroups> example = response.body();

                    //Bundle bundle = new Bundle();
                    //bundle.putSerializable("InvGroup", (Serializable)example);
                    //bundle.putString("Investigators", spj);

                    //InvGroupDetailFragment spFragment = new InvGroupDetailFragment();
                    //spFragment.setArguments(bundle);
                    //((Activity)context).getFragmentManager().popBackStack();
                    //((Activity)context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container,spFragment).commit();
                    //((Activity)context).setTitle("Grupos de Inv.");
                    //Toast.makeText(context, "entre", Toast.LENGTH_SHORT).show();

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
