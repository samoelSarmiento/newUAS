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

import uas.pe.edu.pucp.newuas.fragment.InvDetailFragment;
import uas.pe.edu.pucp.newuas.fragment.PSP_documentsFragment;
import uas.pe.edu.pucp.newuas.fragment.psp_documents_detail;
import uas.pe.edu.pucp.newuas.model.Investigator;
import uas.pe.edu.pucp.newuas.model.PSPDocument;

import uas.pe.edu.pucp.newuas.datapersistency.SharedPreference;
import uas.pe.edu.pucp.newuas.fragment.PSP_groupsFragment;
import uas.pe.edu.pucp.newuas.fragment.PSP_phasesFragment;

import uas.pe.edu.pucp.newuas.model.PSPGroup;
import uas.pe.edu.pucp.newuas.model.PSPPhase;

import uas.pe.edu.pucp.newuas.model.PSPStudent;
/**
 * Created by Franz on 26/10/2016.
 */

public class PSPController {

    PSPStudent list = null;


    public PSPStudent getStudents (final Context context) {

        RestCon restCon  = RetrofitHelper.apiConnector.create(RestCon.class);
        Map<String,String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());

        Call<List<PSPStudent>> call = restCon.getStudents(token);
        call.enqueue(new Callback<List<PSPStudent>>() {


            @Override
            public void onResponse(Call<List<PSPStudent>> call, Response<List<PSPStudent>> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(context, "Lista de alumnos", Toast.LENGTH_SHORT).show();
                    List<PSPStudent> example = response.body();
                    Bundle  bundle =  new Bundle();
                    bundle.putSerializable("PSPStudent",(Serializable) example);
                    PSP_documentsFragment spFragment = new PSP_documentsFragment();
                    spFragment.setArguments(bundle);
                    ((Activity)context).getFragmentManager().beginTransaction().replace(R.id.fragment_container_psp,spFragment).commit();
                    ((Activity)context).setTitle("Alumnos");

                } else {
                    //Toast.makeText(context, response.message(), Toast.LENGTH_SHORT);
                   // Toast.makeText(context, "fuepe", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<List<PSPStudent>> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(context, "Fallo la conexión", Toast.LENGTH_SHORT).show();

            }
        });


        return list;

    }
    public boolean getGroups (Context context){
        RestCon restCon  = RetrofitHelper.apiConnector.create(RestCon.class);
        Map<String,String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());

        Call<List<PSPGroup>> call = restCon.getGroupsPsp(token);
        call.enqueue(new Callback<List<PSPGroup>>() {
            @Override
            public void onResponse(Call<List<PSPGroup>> call, Response<List<PSPGroup>> response) {

                if(response.isSuccessful()){
                    List<PSPGroup> pspGroupList = response.body();
                    Bundle  bundle =  new Bundle();
                    bundle.putSerializable("PSPGroups",(Serializable) pspGroupList);
                }else{
                }
            }
            @Override
            public void onFailure(Call<List<PSPGroup>> call, Throwable t) {

            }

                    PSP_groupsFragment groupsFragment = new PSP_groupsFragment();
                    groupsFragment.setArguments(bundle);

        });

                    ((Activity)context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container_psp,groupsFragment).commit();
                    ((Activity)context).setTitle("Seleccionar grupos");
                }else{
                    Toast.makeText(context,"Error en seleccionar grupo",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<PSPGroup>> call, Throwable t) {
                Toast.makeText(context,"Error de conexion",Toast.LENGTH_SHORT).show();
            }
        });


        return true;
    }
    public PSPStudent getDocumentsByStudent (final Context context) {
        RestCon restCon  = RetrofitHelper.apiConnector.create(RestCon.class);
        Map<String,String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());

        Call<List<PSPDocument>> call = restCon.getDocuments(token);
        call.enqueue(new Callback<List<PSPDocument>>() {



        return true;
    }


    public boolean updateGroup(final Context context, final int idGroup){
        RestCon restCon =  RetrofitHelper.apiConnector.create(RestCon.class);




        Map<String,String> token = new HashMap<>();

        token.put("token", Configuration.LOGIN_USER.getToken());


        Call<String> call = restCon.updateGroup(idGroup,token);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()){


                 Log.d("RESPONSE",response.message());
                    Log.d("RESPONSE", response.body());
                    Log.d("RESPONSE", response.toString());
                    String answer = response.body();


                    SharedPreference shared = new SharedPreference(context);
                    shared.setGroupStatus(Configuration.LOGIN_USER.getUser());
                    Toast.makeText(context,answer,Toast.LENGTH_SHORT).show();




                }else{

                    Log.d("Response", "Algo paso");
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

                t.printStackTrace();


            }


        });



        return list;

        
    }


    public boolean getPhases(final Context context){

        RestCon restCon  = RetrofitHelper.apiConnector.create(RestCon.class);

        Map<String,String> token = new HashMap<>();

        token.put("token", Configuration.LOGIN_USER.getToken());

        Call<List<PSPPhase>> call = restCon.getPhasesPsp(token);

        call.enqueue(new Callback<List<PSPPhase>>() {
            @Override
            public void onResponse(Call<List<PSPPhase>> call, Response<List<PSPPhase>> response) {
                if(response.isSuccessful()){

                    Log.d("RESPONSE", "todo bien");

                    List<PSPPhase> pspPhaseList = response.body();

                    Bundle  bundle =  new Bundle();
                    bundle.putSerializable("PSPPhases",(Serializable) pspPhaseList);


                    PSP_phasesFragment phasesFragment = new PSP_phasesFragment();
                    phasesFragment.setArguments(bundle);


                    ((Activity)context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container_psp,phasesFragment).commit();
                    ((Activity)context).setTitle("Fases");
                }else{

                    Toast.makeText(context,"Error mostrar fases",Toast.LENGTH_SHORT).show();



                }


            }

            @Override
            public void onFailure(Call<List<PSPPhase>> call, Throwable t) {
                t.printStackTrace();

            }
        });


    }

}
