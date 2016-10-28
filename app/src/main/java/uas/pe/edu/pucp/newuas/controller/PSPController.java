package uas.pe.edu.pucp.newuas.controller;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

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
import uas.pe.edu.pucp.newuas.model.PSPGroup;

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


        });



        return true;
    }
    public PSPStudent getDocumentsByStudent (final Context context) {
        RestCon restCon  = RetrofitHelper.apiConnector.create(RestCon.class);
        Map<String,String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());

        Call<List<PSPDocument>> call = restCon.getDocuments(token);
        call.enqueue(new Callback<List<PSPDocument>>() {


            @Override
            public void onResponse(Call<List<PSPDocument>> call, Response<List<PSPDocument>> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(context, "Alumnos del ciclo", Toast.LENGTH_SHORT).show();
                    List<PSPDocument> example = response.body();
                    Bundle  bundle =  new Bundle();
                    bundle.putSerializable("PSPDocument",(Serializable) example);
                    psp_documents_detail spFragment = new psp_documents_detail();
                    spFragment.setArguments(bundle);
                    ((Activity)context).getFragmentManager().beginTransaction().replace(R.id.fragment_container_psp,spFragment).commit();
                    ((Activity)context).setTitle("Alumnosss");

                } else {
                    //Toast.makeText(context, response.message(), Toast.LENGTH_SHORT);
                    // Toast.makeText(context, "fuepe", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<List<PSPDocument>> call, Throwable t) {
                t.printStackTrace();
            }


        });


        return list;

    }

}
