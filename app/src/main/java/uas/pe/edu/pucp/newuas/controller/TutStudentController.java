package uas.pe.edu.pucp.newuas.controller;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.content.Context;


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
import uas.pe.edu.pucp.newuas.fragment.InvGroupDetailFragment;
import uas.pe.edu.pucp.newuas.fragment.MyStudentAppointmentFragment;
import uas.pe.edu.pucp.newuas.fragment.TutorInfoFragment;
import uas.pe.edu.pucp.newuas.model.AppointmentRequest;
import uas.pe.edu.pucp.newuas.model.InvGroups;
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
        Log.d("xd", call.request().url() + "");
        call.enqueue(new Callback<List<TopicResponse>>() {
            @Override
            public void onResponse(Call<List<TopicResponse>> call, Response<List<TopicResponse>> response) {
                List<TopicResponse> topicResponses = response.body();
                for (TopicResponse topic : topicResponses) {
                    NavigationDrawerTutoria.nameTopicsList.add(topic.getNombre());
                }
                NavigationDrawerTutoria.nameTopic = new String[NavigationDrawerTutoria.nameTopicsList.size()];
                for (int i = 0; i < NavigationDrawerTutoria.nameTopicsList.size(); i++)
                    NavigationDrawerTutoria.nameTopic[i] = NavigationDrawerTutoria.nameTopicsList.get(i);

                MyStudentAppointmentFragment fragment = new MyStudentAppointmentFragment();
                ((Activity)context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container , fragment).commit();


            }

            @Override
            public void onFailure(Call<List<TopicResponse>> call, Throwable t) {

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

        Log.d("xd","antes de tuto");
        return true;
    }



    public boolean appointmentRequest(final Context context, int idUser, String fecha, String hora, String motivo){

        Map<String, String> data = new HashMap<>();
        data.put("token", Configuration.LOGIN_USER.getToken());
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);
        Call<String> call = restCon.doAppointment(new AppointmentRequest(idUser,fecha,hora,motivo),data);
       // Log.d("xd",  "ke pasa aca " + call.request().url() );
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d("xd","SOY SUCESIASGIASG ");
                Log.d("xd","SOY SUCESIASGIASG 123123132312");

                    MyStudentAppointmentFragment mp = new MyStudentAppointmentFragment();
                    ((Activity)context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container ,mp).commit();

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("xd","SOY 123123123312312312312 ");
                MyStudentAppointmentFragment mp = new MyStudentAppointmentFragment();
                ((Activity)context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container ,mp).commit();
            }
        });
        return true;
    }


}
