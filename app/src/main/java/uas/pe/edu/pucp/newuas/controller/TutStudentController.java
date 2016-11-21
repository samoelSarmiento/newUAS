package uas.pe.edu.pucp.newuas.controller;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.content.Context;
import android.view.View;
import android.widget.ListView;


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
import uas.pe.edu.pucp.newuas.fragment.AlumnoNuevaCitaFragment;
import uas.pe.edu.pucp.newuas.fragment.StudentAppointFragment;
import uas.pe.edu.pucp.newuas.fragment.TutorInfoFragment;
import uas.pe.edu.pucp.newuas.adapter.AppointmentAdapter;
import uas.pe.edu.pucp.newuas.model.AppointmentFilterRequest;
import uas.pe.edu.pucp.newuas.model.AppointmentRequest;
import uas.pe.edu.pucp.newuas.model.AppointmentResponse;
import uas.pe.edu.pucp.newuas.model.SingleRow;
import uas.pe.edu.pucp.newuas.model.TUTInfoResponse;
import uas.pe.edu.pucp.newuas.model.TopicResponse;
import uas.pe.edu.pucp.newuas.view.NavigationDrawerTutoria;

/**
 * Created by Wingerlion on 27/10/2016.
 */
public class TutStudentController {


    public  TUTInfoResponse tutoInfo = new TUTInfoResponse();
    public  boolean valor = false;
    public TutStudentController(){};

    public boolean showTopics (final Context context) {

        Map<String, String> data = new HashMap<>();
        data.put("token", Configuration.LOGIN_USER.getToken());
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);
        Call<List<TopicResponse>> call = restCon.getTopics(data);
        //Log.d("xd", call.request().url() + "");
        call.enqueue(new Callback<List<TopicResponse>>() {
            @Override
            public void onResponse(Call<List<TopicResponse>> call, Response<List<TopicResponse>> response) {

                List<TopicResponse> topicResponses = response.body();
                for (TopicResponse topic : topicResponses) {
                    NavigationDrawerTutoria.nameTopicsList.add(topic.getNombre());
                }
                NavigationDrawerTutoria.nameTopic = new String[NavigationDrawerTutoria.nameTopicsList.size()+1];
                for (int i = 0; i < NavigationDrawerTutoria.nameTopicsList.size(); i++)
                    NavigationDrawerTutoria.nameTopic[i] = NavigationDrawerTutoria.nameTopicsList.get(i);
                NavigationDrawerTutoria.nameTopic[NavigationDrawerTutoria.nameTopicsList.size()] = "";


                //MyStudentAppointmentFragment fragment = new MyStudentAppointmentFragment();
                StudentAppointFragment fragment = new StudentAppointFragment();
                ((Activity)context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container , fragment).commit();


            }

            @Override
            public void onFailure(Call<List<TopicResponse>> call, Throwable t) {

            }
        });

        return true;
    }

    public boolean getAppointment (final Context context, final View view, int id) {

        Map<String, String> data = new HashMap<>();
        data.put("token", Configuration.LOGIN_USER.getToken());
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);
        Call<List<AppointmentResponse>> call = restCon.getAppointment(id,data);
        Log.d("xd", call.request().url() + "traFIKANTE PUKEE  E");
        call.enqueue(new Callback<List<AppointmentResponse>>() {

            @Override
            public void onResponse(Call<List<AppointmentResponse>> call, Response<List<AppointmentResponse>> response) {

               if (response.isSuccessful()){
                    List<AppointmentResponse>  appointResponse = response.body();
                    List<SingleRow> sr = new  ArrayList<SingleRow>();

                    for (AppointmentResponse ap : appointResponse){
                        String fechaHoraInicio =  ap.getInicio();
                        String fechaI = fechaHoraInicio.substring(0,10);
                        String horaI  = fechaHoraInicio.substring(11);
                        String tema = ap.getNombreTema();
                        String estado = ap.getNombreEstado();
                        sr.add(new SingleRow(fechaI,horaI,tema,estado));
                        Log.d("tag", fechaI + horaI + tema + estado);

                    }
                    ListView listV = (ListView) view.findViewById(R.id.listViewCustom);
                    listV.setAdapter(new AppointmentAdapter(context,sr));
                }
            }

            @Override
            public void onFailure(Call<List<AppointmentResponse>> call, Throwable t) {

            }
        });

        return true;
    }


    public boolean showTutoInfo(final Context context, int id){

        Map<String, String> data = new HashMap<>();
        data.put("token", Configuration.LOGIN_USER.getToken());
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);
        Call<List<TUTInfoResponse>> call = restCon.getTutorInfo(id,data);

        call.enqueue(new Callback<List<TUTInfoResponse>>() {
            @Override
            public void onResponse(Call<List<TUTInfoResponse>> call, Response<List<TUTInfoResponse>> response) {
                if(response.isSuccessful()) {
                    List<TUTInfoResponse> tutoInformation = response.body();
                    tutoInfo = tutoInformation.get(0);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Tutoria", (Serializable)tutoInformation);
                    TutorInfoFragment tiFragment = new TutorInfoFragment();
                    tiFragment.setArguments(bundle);
                    ((Activity)context).setTitle("Tutoria");
                    ((Activity)context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container ,tiFragment).commit();
                }
            }

            @Override
            public void onFailure(Call<List<TUTInfoResponse>> call, Throwable t) {

            }
        });

        return true;
    }


    public boolean getInfoSchedule(final Context context, int id){

        Map<String, String> data = new HashMap<>();
        data.put("token", Configuration.LOGIN_USER.getToken());
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);
        Call<List<TUTInfoResponse>> call = restCon.getTutorInfo(id,data);

        call.enqueue(new Callback<List<TUTInfoResponse>>() {
            @Override
            public void onResponse(Call<List<TUTInfoResponse>> call, Response<List<TUTInfoResponse>> response) {
                if(response.isSuccessful()) {
                    List<TUTInfoResponse> tutoInformation = response.body();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Tutoria", (Serializable)tutoInformation);
                    AlumnoNuevaCitaFragment tiFragment = new AlumnoNuevaCitaFragment();
                    tiFragment.setArguments(bundle);
                    ((Activity)context).setTitle("Tutoria");
                    ((Activity)context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container ,tiFragment).commit();
                }
            }

            @Override
            public void onFailure(Call<List<TUTInfoResponse>> call, Throwable t) {

            }
        });

        return true;
    }


    public boolean appointmentRequest(final Context context, int idUser, String fecha, String hora, String motivo){

        Map<String, String> data = new HashMap<>();
        data.put("token", Configuration.LOGIN_USER.getToken());
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);
        //Log.d("tag","CONTEXTOO " + hora + " " +  " " + motivo);
        Call<String> call = restCon.doAppointment(new AppointmentRequest(idUser,fecha,hora,motivo,null),data);
        // Log.d("xd",  "ke pasa aca " + call.request().url() );
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                StudentAppointFragment mp = new StudentAppointFragment();
                ((Activity)context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container ,mp).commit();

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                StudentAppointFragment mp = new StudentAppointFragment();
                ((Activity)context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container ,mp).commit();
            }
        });

        return true;
    }

    public boolean filterAppointment(final Context context, final View view, int idUser, String fechaI, String fechaF, String motivo){

        Map<String, String> data = new HashMap<>();
        data.put("token", Configuration.LOGIN_USER.getToken());
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);
        Call<List<AppointmentResponse>> call = restCon.filterStudentAppointment(new AppointmentFilterRequest(idUser,fechaI,fechaF,motivo),data);
        // Log.d("xd",  "ke pasa aca " + call.request().url() );

        call.enqueue(new Callback<List<AppointmentResponse>>() {
            @Override
            public void onResponse(Call<List<AppointmentResponse>> call, Response<List<AppointmentResponse>> response) {

                if (response.isSuccessful()){


                    List<AppointmentResponse>  appointResponse = response.body();
                    List<SingleRow> sr = new  ArrayList<SingleRow>();

                    for (AppointmentResponse ap : appointResponse){
                        String fechaHoraInicio =  ap.getInicio();
                        String fechaI = fechaHoraInicio.substring(0,10);
                        String horaI  = fechaHoraInicio.substring(11);
                        String tema = ap.getNombreTema();
                        String estado = ap.getNombreEstado();
                        sr.add(new SingleRow(fechaI,horaI,tema,estado));
                        Log.d("tag", fechaI + horaI + tema + estado);

                    }
                    ListView listV = (ListView) view.findViewById(R.id.listViewCustom);
                    listV.setAdapter(new AppointmentAdapter(context,sr));
                }

            }

            @Override
            public void onFailure(Call<List<AppointmentResponse>> call, Throwable t) {


            }
        });
        return true;
    }


}

