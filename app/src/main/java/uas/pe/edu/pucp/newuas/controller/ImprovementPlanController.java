package uas.pe.edu.pucp.newuas.controller;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

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
import uas.pe.edu.pucp.newuas.fragment.ImprovementPlanActionsFragment;
import uas.pe.edu.pucp.newuas.fragment.ImprovementPlanListFragment;
import uas.pe.edu.pucp.newuas.fragment.ImprovementPlanViewFragment;
import uas.pe.edu.pucp.newuas.fragment.SuggestionListFragment;
import uas.pe.edu.pucp.newuas.model.Action;
import uas.pe.edu.pucp.newuas.model.ImprovementPlan;
import uas.pe.edu.pucp.newuas.model.Period;
import uas.pe.edu.pucp.newuas.model.StringResponse;
import uas.pe.edu.pucp.newuas.model.Suggestion;
import uas.pe.edu.pucp.newuas.model.SuggestionRequest;

/**
 * Created by Marshall on 2/11/2016.
 */

public class ImprovementPlanController {

    public void getImprovementPlansofSpecialty(final Context context, Integer specId) {
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);

        Map<String, String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());

        Call<List<ImprovementPlan>> call;
        call = restCon.getImprovementPlansofSpecialty(specId, token);

        call.enqueue(new Callback<List<ImprovementPlan>>() {
            @Override
            public void onResponse(Call<List<ImprovementPlan>> call, Response<List<ImprovementPlan>> response) {
                if (response.isSuccessful()) {
                    List<ImprovementPlan> list = response.body();
                    ImprovementPlanListFragment iplf = new ImprovementPlanListFragment();

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("ImprovementPlans", (Serializable) list);
                    iplf.setArguments(bundle);

                    ((Activity) context).getFragmentManager()
                            .beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.fragment_container, iplf)
                            .commit();
                    ((Activity) context).setTitle("Planes de Mejora");
                } else {
                    Log.d("wat", response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<List<ImprovementPlan>> call, Throwable t) {

            }
        });
    }

    public void getImprovementPlan(final Context context, Integer ipId) {
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);

        Map<String, String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());

        Call<ImprovementPlan> call;
        call = restCon.getImprovementPlanById(ipId, token);

        call.enqueue(new Callback<ImprovementPlan>() {
            @Override
            public void onResponse(Call<ImprovementPlan> call, Response<ImprovementPlan> response) {
                if (response.isSuccessful()) {
                    ImprovementPlan ip = response.body();

                    ImprovementPlanViewFragment ipvf = new ImprovementPlanViewFragment();

                    Bundle bundle = new Bundle();

                    bundle.putSerializable("IPlan", ip);
                    ipvf.setArguments(bundle);

                    ((Activity) context).getFragmentManager()
                            .beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.fragment_container, ipvf)
                            .commit();
                    ((Activity) context).setTitle("Plan de Mejora");
                } else {
                    Log.d("wat", response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<ImprovementPlan> call, Throwable t) {

            }
        });
    }


    public void getActionsOfImprovementPlan(final Context context, Integer ipId) {

        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);

        Map<String, String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());

        Call<List<Action>> call;
        call = restCon.getActionsofImprovementPlan(ipId, token);

        call.enqueue(new Callback<List<Action>>() {
            @Override
            public void onResponse(Call<List<Action>> call, Response<List<Action>> response) {
                if (response.isSuccessful()) {
                    List<Action> list = response.body();

                    ImprovementPlanActionsFragment ipaf = new ImprovementPlanActionsFragment();

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("actions", (Serializable) list);
                    ipaf.setArguments(bundle);

                    ((Activity) context).getFragmentManager()
                            .beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.fragment_container, ipaf)
                            .commit();
                    ((Activity) context).setTitle("Acciones");
                } else {
                    Log.d("wat", response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<List<Action>> call, Throwable t) {

            }
        });
    }

    public void getImprovementPlanSuggestions(final Context context, final Integer ipId) {
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);
        Map<String, String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());
        Call<List<Suggestion>> call = restCon.getImprPlanSuggestion(ipId, token);
        call.enqueue(new Callback<List<Suggestion>>() {
            @Override
            public void onResponse(Call<List<Suggestion>> call, Response<List<Suggestion>> response) {
                if (response.isSuccessful()) {
                    List<Suggestion> list = response.body();
                    Bundle bundle = new Bundle();
                    bundle.putInt("idIp", ipId);
                    bundle.putSerializable("suggestions", (Serializable) list);
                    SuggestionListFragment listFragment = new SuggestionListFragment();
                    listFragment.setArguments(bundle);
                    ((Activity) context).getFragmentManager().beginTransaction()
                            .addToBackStack(null).replace(R.id.fragment_container, listFragment).commit();
                }
            }

            @Override
            public void onFailure(Call<List<Suggestion>> call, Throwable t) {

            }
        });
    }

    public void sendSuggestion(final Context context, final int idIp, final SuggestionRequest request) {
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);
        Map<String, String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());
        Call<StringResponse> call = restCon.sendSuggestion(idIp, request, token);
        call.enqueue(new Callback<StringResponse>() {
            @Override
            public void onResponse(Call<StringResponse> call, Response<StringResponse> response) {
                if (response.isSuccessful()) {
                    StringResponse res = response.body();
                    Toast.makeText(context, res.getMensaje(), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(context, "Ocurrió un error", Toast.LENGTH_LONG).show();
                }
                ((Activity) context).getFragmentManager().popBackStack();
                ((Activity) context).getFragmentManager().popBackStack();
                getImprovementPlanSuggestions(context, idIp);
            }

            @Override
            public void onFailure(Call<StringResponse> call, Throwable t) {
                Toast.makeText(context, "Error de conexion. Intente nuevamente", Toast.LENGTH_LONG).show();
            }
        });
    }
}


