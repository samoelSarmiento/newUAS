package uas.pe.edu.pucp.newuas.controller;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

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
import uas.pe.edu.pucp.newuas.fragment.StudentAppointFragment;
import uas.pe.edu.pucp.newuas.fragment.TutorAppointFragment;
import uas.pe.edu.pucp.newuas.model.AppointmentAdapter;
import uas.pe.edu.pucp.newuas.model.AppointmentAdapterTutor;
import uas.pe.edu.pucp.newuas.model.AppointmentResponse;
import uas.pe.edu.pucp.newuas.model.AppointmentResponseTuto;
import uas.pe.edu.pucp.newuas.model.SingleRow;
import uas.pe.edu.pucp.newuas.model.SingleRowTuto;
import uas.pe.edu.pucp.newuas.model.TopicResponse;
import uas.pe.edu.pucp.newuas.view.NavigationDrawerTutoria;

/**
 * Created by Wingerlion on 02/11/2016.
 */
public class TutTutorController {

    public boolean showTopics (final Context context) {

        Map<String, String> data = new HashMap<>();
        data.put("token", Configuration.LOGIN_USER.getToken());
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);
        Call<List<TopicResponse>> call = restCon.getTopics(data);
        //Log.d("xd", call.request().url() + "");
        call.enqueue(new Callback<List<TopicResponse>>() {
            @Override
            public void onResponse(Call<List<TopicResponse>> call, Response<List<TopicResponse>> response) {

                /*
                List<TopicResponse> topicResponses = response.body();
                for (TopicResponse topic : topicResponses) {
                    NavigationDrawerTutoria.nameTopicsList.add(topic.getNombre());
                }
                NavigationDrawerTutoria.nameTopic = new String[NavigationDrawerTutoria.nameTopicsList.size()];
                for (int i = 0; i < NavigationDrawerTutoria.nameTopicsList.size(); i++)
                    NavigationDrawerTutoria.nameTopic[i] = NavigationDrawerTutoria.nameTopicsList.get(i);

                //MyStudentAppointmentFragment fragment = new MyStudentAppointmentFragment();
                */
                TutorAppointFragment fragment = new TutorAppointFragment();
                Log.d("xd","SERA ACAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");

                ((Activity) context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.drawer_layout, fragment).commit();


            }

            @Override
            public void onFailure(Call<List<TopicResponse>> call, Throwable t) {

            }
        });

        return true;
    }

    public boolean getAppointment (final Context context, final View view, int id) {

        final int[] icon1 = new int[2], icon2 = new int[2];
        Map<String, String> data = new HashMap<>();
        data.put("token", Configuration.LOGIN_USER.getToken());
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);
        Call<List<AppointmentResponseTuto>> call = restCon.getTutorAppoints(id,data);
        Log.d("xd","PIKI PIKI PIKI PIKI PIKI XDXDSAGASGSA");
        Log.d("xd", call.request().url() + " ");
        call.enqueue(new Callback<List<AppointmentResponseTuto>>() {

            @Override
            public void onResponse(Call<List<AppointmentResponseTuto>> call, Response<List<AppointmentResponseTuto>> response) {

                if (response.isSuccessful()){

                    List<AppointmentResponseTuto>  appointResponse = response.body();
                    List<SingleRowTuto> sr = new ArrayList<SingleRowTuto>();

                    for (AppointmentResponseTuto ap : appointResponse){
                        String fechaHoraInicio =  ap.getInicio();
                        String fechaI = fechaHoraInicio.substring(0,10);
                        String horaI  = fechaHoraInicio.substring(11);
                        String tema = ap.getNombreTema();
                        String estado = ap.getNombreEstado();
                        String nombreP = ap.getNombreAlumno();
                        if (estado.equals("Pendiente")){
                             icon1[0] = R.drawable.ic_check;
                             icon2[0] = R.drawable.ic_cross;
                        }
                        //Log.d("xd", nombreP);
                        sr.add(new SingleRowTuto(fechaI,horaI,tema,estado,nombreP,icon1[0],icon2[0]));
                    }
                    ListView listV = (ListView) view.findViewById(R.id.listViewCustomTuto);
                    listV.setAdapter(new AppointmentAdapterTutor(context,sr));
                    Log.d("xd","TU MAMA KALATAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
                }

            }

            @Override
            public void onFailure(Call<List<AppointmentResponseTuto>> call, Throwable t) {

            }
        });

        return true;
    }
}
