package uas.pe.edu.pucp.newuas.controller;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

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
import uas.pe.edu.pucp.newuas.fragment.InscriptionFilePSPJ;
import uas.pe.edu.pucp.newuas.fragment.PSP_supDocumentFragment;
import uas.pe.edu.pucp.newuas.fragment.PSP_supDocumentsByStudent;

import uas.pe.edu.pucp.newuas.model.InscriptionFilePSP;
import uas.pe.edu.pucp.newuas.model.Student;

/**
 * Created by jemarroquin on 30/10/2016.
 */
public class PSPControllerJ {


    public boolean getStudents (final Context context) {

        RestCon restCon  = RetrofitHelper.apiConnector.create(RestCon.class);
        Map<String,String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());

        Call<List<Student>> call = restCon.getStudents(token);
        call.enqueue(new Callback<List<Student>>() {

            @Override
            public void onResponse(Call<List<Student>> call, retrofit2.Response<List<Student>> response) {
                        if (response.isSuccessful()) {
                    List<Student> listaEstudiantes = response.body();
                    Toast.makeText(context, "Lista de alumnos", Toast.LENGTH_SHORT).show();
                    Bundle bundle =  new Bundle();
                    bundle.putSerializable("Students",(Serializable) listaEstudiantes);
                    PSP_supDocumentFragment spFragment = new PSP_supDocumentFragment();
                    spFragment.setArguments(bundle);
                    ((Activity)context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container_psp,spFragment).commit();
                    ((Activity)context).setTitle("Alumnos");

                } else {

                    Toast.makeText(context, "Hubo un problema" , Toast.LENGTH_SHORT).show();
                     }
            }
            @Override
            public void onFailure(Call<List<Student>> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(context, "Fallo la conexión", Toast.LENGTH_SHORT).show();

            }
        });
        return true;

    }


    public boolean obtenerInforme (final Context context) {

        RestCon restCon  = RetrofitHelper.apiConnector.create(RestCon.class);
        Map<String,String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());

        Call<List<InscriptionFilePSP>> call = restCon.getInscriptionFile(token);
        call.enqueue(new Callback<List<InscriptionFilePSP>>() {

            @Override
            public void onResponse(Call<List<InscriptionFilePSP>> call, retrofit2.Response<List<InscriptionFilePSP>> response) {
                if (response.isSuccessful()) {
                    List<InscriptionFilePSP> informe = response.body();
                    Toast.makeText(context, "Informe de inscripción", Toast.LENGTH_SHORT).show();
                    Bundle bundle =  new Bundle();
                    bundle.putSerializable("InscriptionFilePSP",(Serializable) informe);
                    InscriptionFilePSPJ fragment = new InscriptionFilePSPJ();
                    fragment.setArguments(bundle);
                    ((Activity)context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container_psp,fragment).commit();
                    //((Activity)context).setTitle("Alumnos");

                } else {

                    Toast.makeText(context, "Hubo un problema" , Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<List<InscriptionFilePSP>> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(context, "Fallo la conexión", Toast.LENGTH_SHORT).show();

            }
        });
        return true;

    }





    public void enviarComentarioInforme (final Context context , InscriptionFilePSP inscription ) {

        RestCon restCon  = RetrofitHelper.apiConnector.create(RestCon.class);
        Map<String,String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());
        Call<String> call  = restCon.sendInscriptionFile( inscription.getId() ,token , inscription );


        call.enqueue(new Callback<String>() {

            @Override
            public void onResponse(Call<String> call, retrofit2.Response<String> response) {
                if (response.isSuccessful()) {


                } else {

                }
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
                t.printStackTrace();
           //     Toast.makeText(context, "Fallo la conexión", Toast.LENGTH_SHORT).show();

            }
        });





}}
