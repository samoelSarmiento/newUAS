package uas.pe.edu.pucp.newuas.controller;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
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
import uas.pe.edu.pucp.newuas.datapersistency.SharedPreference;
import uas.pe.edu.pucp.newuas.fragment.PSP_groupsFragment;
import uas.pe.edu.pucp.newuas.fragment.PSP_phasesFragment;
import uas.pe.edu.pucp.newuas.fragment.PSP_studentsFragment;
import uas.pe.edu.pucp.newuas.fragment.PSP_supDocumentFragment;
import uas.pe.edu.pucp.newuas.fragment.PSP_supDocumentsByStudent;
import uas.pe.edu.pucp.newuas.model.Document;
import uas.pe.edu.pucp.newuas.model.PSPGroup;
import uas.pe.edu.pucp.newuas.model.PSPPhase;
import uas.pe.edu.pucp.newuas.model.Student;

import static android.R.attr.fragment;

/**
 * Created by Franz on 26/10/2016.
 */

public class PSPController {


    public boolean getGroups(final Context context) {
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);

        Map<String, String> token = new HashMap<>();

        token.put("token", Configuration.LOGIN_USER.getToken());


        Call<List<PSPGroup>> call = restCon.getGroupsPsp(token);

        call.enqueue(new Callback<List<PSPGroup>>() {
            @Override
            public void onResponse(Call<List<PSPGroup>> call, Response<List<PSPGroup>> response) {

                if (response.isSuccessful()) {

                    List<PSPGroup> pspGroupList = response.body();

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("PSPGroups", (Serializable) pspGroupList);


                    PSP_groupsFragment groupsFragment = new PSP_groupsFragment();
                    groupsFragment.setArguments(bundle);


                    ((Activity) context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container_psp, groupsFragment).commit();
                    ((Activity) context).setTitle("Seleccionar grupos");
                } else {
                    Toast.makeText(context, "Error en seleccionar grupo", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<PSPGroup>> call, Throwable t) {
                Toast.makeText(context, "Error de conexion", Toast.LENGTH_SHORT).show();
            }
        });


        return true;
    }

    public boolean updateGroup(final Context context, final int idGroup) {
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);


        Map<String, String> token = new HashMap<>();

        token.put("token", Configuration.LOGIN_USER.getToken());


        Call<String> call = restCon.updateGroup(idGroup, token);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {


                    Log.d("RESPONSE", response.message());
                    Log.d("RESPONSE", response.body());
                    Log.d("RESPONSE", response.toString());
                    String answer = response.body();


                    SharedPreference shared = new SharedPreference(context);
                    shared.setGroupStatus(Configuration.LOGIN_USER.getUser());
                    Toast.makeText(context, answer, Toast.LENGTH_SHORT).show();


                } else {

                    Log.d("Response", "Algo paso");
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

                t.printStackTrace();

            }
        });


        return true;
    }


    public boolean getPhases(final Context context) {

        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);

        Map<String, String> token = new HashMap<>();

        token.put("token", Configuration.LOGIN_USER.getToken());

        Call<List<PSPPhase>> call = restCon.getPhasesPsp(token);

        call.enqueue(new Callback<List<PSPPhase>>() {
            @Override
            public void onResponse(Call<List<PSPPhase>> call, Response<List<PSPPhase>> response) {
                if (response.isSuccessful()) {

                    Log.d("RESPONSE", "todo bien");

                    List<PSPPhase> pspPhaseList = response.body();

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("PSPPhases", (Serializable) pspPhaseList);


                    PSP_phasesFragment phasesFragment = new PSP_phasesFragment();
                    phasesFragment.setArguments(bundle);


                    ((Activity) context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container_psp, phasesFragment).commit();
                    ((Activity) context).setTitle("Fases");
                } else {

                    Toast.makeText(context, "Error mostrar fases", Toast.LENGTH_SHORT).show();


                }


            }

            @Override
            public void onFailure(Call<List<PSPPhase>> call, Throwable t) {
                t.printStackTrace();

            }
        });

        return true;
    }


    public boolean getDocumentsByStudent(final Context context, int idStudent) {

        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);

        Map<String, String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());

        Call<List<Document>> call = restCon.getDocumentsByStudent(idStudent, token);
        call.enqueue(new Callback<List<Document>>() {
            @Override
            public void onResponse(Call<List<Document>> call, Response<List<Document>> response) {

                List<Document> pspPhaseList = response.body();
                PSP_supDocumentsByStudent fragment = new PSP_supDocumentsByStudent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("PSPDocuments", (Serializable) pspPhaseList);
                fragment.setArguments(bundle);
                ((Activity) context).getFragmentManager().beginTransaction()
                        .setCustomAnimations(R.animator.enter, R.animator.exit, R.animator.slide_out_right, R.animator.slide_in_right)//,R.animator.pop_enter,R.animator.pop_exit)
                        .addToBackStack(null).replace(R.id.fragment_container_psp, fragment).commit();

            }

            @Override
            public void onFailure(Call<List<Document>> call, Throwable t) {

                t.printStackTrace();
            }
        });

        return true;
    }


    public boolean getStudentGroup(final Context context) {

        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);

        Map<String, String> token = new HashMap<>();

        token.put("token", Configuration.LOGIN_USER.getToken());


        Call<PSPGroup> call = restCon.getStudentGroup(token);

        call.enqueue(new Callback<PSPGroup>() {
            @Override
            public void onResponse(Call<PSPGroup> call, Response<PSPGroup> response) {

                if (response.isSuccessful()) {

                    PSPGroup group = response.body();

                    if (group != null) {


                        Log.d("GROUP", "NO ES NULL");
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("PSPGroup", group);


                        PSP_groupsFragment groupFragment = new PSP_groupsFragment();
                        groupFragment.setArguments(bundle);


                        ((Activity) context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container_psp, groupFragment).commit();
                        ((Activity) context).setTitle("Grupos");





                    } else {

                        Log.d("GROUP", "ES NULL");


                    }


                }

            }


            @Override
            public void onFailure(Call<PSPGroup> call, Throwable t) {


                getGroups(context);

            }
        });

        return  true;

    }
}
