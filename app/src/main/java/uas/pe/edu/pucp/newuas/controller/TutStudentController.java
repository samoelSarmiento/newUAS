package uas.pe.edu.pucp.newuas.controller;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.content.Context;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
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
import uas.pe.edu.pucp.newuas.fragment.TutorAppointFragment;
import uas.pe.edu.pucp.newuas.fragment.TutorInfoFragment;
import uas.pe.edu.pucp.newuas.adapter.AppointmentAdapter;
import uas.pe.edu.pucp.newuas.fragment.VisualizarCitaAlumnoFragment;
import uas.pe.edu.pucp.newuas.fragment.VisualizarCitaFragment;
import uas.pe.edu.pucp.newuas.model.AppointmentFilterRequest;
import uas.pe.edu.pucp.newuas.model.AppointmentRequest;
import uas.pe.edu.pucp.newuas.model.AppointmentResponse;
import uas.pe.edu.pucp.newuas.model.CitaInfoResponse;
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

        //NavigationDrawerTutoria.nameTopic = null;
        //NavigationDrawerTutoria.nameTopicsList = null;
        Map<String, String> data = new HashMap<>();
        data.put("token", Configuration.LOGIN_USER.getToken());
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);
        Call<List<TopicResponse>> call = restCon.getTopics(data);
        //Log.d("xd", call.request().url() + "");
        call.enqueue(new Callback<List<TopicResponse>>() {
            @Override
            public void onResponse(Call<List<TopicResponse>> call, Response<List<TopicResponse>> response) {

                List<TopicResponse> topicResponses = response.body();
                NavigationDrawerTutoria.nameTopicsList.clear();
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
        final int[] icon1 = new int[2], icon2 = new int[2];
        Call<List<AppointmentResponse>> call = restCon.getAppointment(id,data);
        call.enqueue(new Callback<List<AppointmentResponse>>() {

            @Override
            public void onResponse(Call<List<AppointmentResponse>> call, Response<List<AppointmentResponse>> response) {

               if (response.isSuccessful()){
                    List<AppointmentResponse>  appointResponse = response.body();
                    List<SingleRow> sr = new  ArrayList<SingleRow>();

                    for (AppointmentResponse ap : appointResponse){
                        String fechaHoraInicio =  ap.getInicio();
                        String fechaI = fechaHoraInicio.substring(0,10);
                        Calendar c = Calendar.getInstance();
                        int year       = c.get(Calendar.YEAR);
                        int month      = c.get(Calendar.MONTH); // Jan = 0, dec = 11
                        int dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
                        String actualDate = year + "-" + (month+1) + "-" + dayOfMonth;

                        String horaI  = fechaHoraInicio.substring(11);
                        String tema = ap.getNombreTema();
                        String estado = ap.getNombreEstado();

                        Log.d("tag", fechaI + " "  + " " + horaI + " " + estado);

                        int idCreador = ap.getCreador();
                        if (estado.equals("Pendiente")){
                            icon1[0] = R.drawable.ic_nullresource;
                            icon2[0] = R.drawable.ic_cross;
                        }
                        else if (estado.equals("Confirmada") && actualDate.equals(fechaI)){
                            icon1[0] = R.drawable.ic_eye;
                            icon2[0] = R.drawable.ic_cross;

                        }
                        else if (estado.equals("Confirmada") && !actualDate.equals(fechaI)){
                            icon1[0] = R.drawable.ic_eye;
                            icon2[0] = R.drawable.ic_cross;

                        }
                        else if (estado.equals("Cancelada")){
                            icon1[0] = R.drawable.ic_eye;
                            icon2[0] = R.drawable.ic_nullresource;
                        }
                        else if (estado.equals("Sugerida")){
                            icon1[0] = R.drawable.ic_check;
                            icon2[0] = R.drawable.ic_cross;
                        }
                        else if (estado.equals("Rechazada")){
                            icon1[0] = R.drawable.ic_eye;
                            icon2[0] = R.drawable.ic_nullresource;
                        }
                        else if (estado.equals("Asistida")){
                            icon1[0] = R.drawable.ic_eye;
                            icon2[0] = R.drawable.ic_nullresource;
                        }
                        else if (estado.equals("No asistida")){
                            icon1[0] = R.drawable.ic_eye;
                            icon2[0] = R.drawable.ic_nullresource;
                        }

                        int idAppoint = ap.getId();
                        sr.add(new SingleRow(fechaI,horaI,tema,estado,icon1[0],icon2[0], idAppoint));
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


    public boolean visualizarCitaConfirmada(final Context context,  int idAppoint ){

        Map<String, String> data = new HashMap<>();
        data.put("token", Configuration.LOGIN_USER.getToken());
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);
        Call<List<CitaInfoResponse>> call = restCon.obtenerDatosCitaConfirmada(idAppoint,data);
        call.enqueue(new Callback<List<CitaInfoResponse>>() {
            @Override
            public void onResponse(Call<List<CitaInfoResponse>> call, Response<List<CitaInfoResponse>> response) {

                List<CitaInfoResponse> generalInformation = response.body();
                Bundle bundle = new Bundle();
                bundle.putSerializable("Tutoria", (Serializable)generalInformation);
                VisualizarCitaAlumnoFragment mp = new VisualizarCitaAlumnoFragment();
                mp.setArguments(bundle);
                ((Activity)context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container ,mp).commit();
            }

            @Override
            public void onFailure(Call<List<CitaInfoResponse>> call, Throwable t) {


                VisualizarCitaAlumnoFragment mp = new VisualizarCitaAlumnoFragment();
                ((Activity)context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container ,mp).commit();
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
                else{
                    Toast.makeText(context, "El alumno no tiene un tutor registrado!", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<TUTInfoResponse>> call, Throwable t) {
                Toast.makeText(context, "El alumno no tiene un tutor registrado!", Toast.LENGTH_LONG).show();
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
                else
                    Toast.makeText(context, "El alumno no tiene un tutor registrado!", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<List<TUTInfoResponse>> call, Throwable t) {
                Toast.makeText(context, "   El alumno no tiene tutor asignado", Toast.LENGTH_LONG).show();
            }
        });

        return true;
    }


    public boolean appointmentRequest(final Context context, int idUser, String fecha, String hora, String motivo, int duracionCita){

        Map<String, String> data = new HashMap<>();
        data.put("token", Configuration.LOGIN_USER.getToken());
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);
        //obtenemos la hora de fin
        String minFin = hora.substring(3,5);
        int minFinInt = Integer.parseInt(minFin);
        int horaFinInt = Integer.parseInt(hora.substring(0,2));
        int minToCheck = minFinInt + duracionCita;
        if (minToCheck == 60) {
            horaFinInt = horaFinInt + 1;
            minFin = "00";
        }
        else minFin = minToCheck + "";
        String hoF = horaFinInt + "";
        if (hoF.length() == 1 ) hoF = "0"+ hoF;
        String horaF = hoF + ":" + minFin;
        //fin de la obtencion de la hora F


        Call<String> call = restCon.doAppointment(new AppointmentRequest(idUser,fecha,hora,horaF,motivo,null,duracionCita),data);
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
        final int[] icon1 = new int[2], icon2 = new int[2];
        data.put("token", Configuration.LOGIN_USER.getToken());
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);
        Call<List<AppointmentResponse>> call = restCon.filterStudentAppointment(new AppointmentFilterRequest(idUser,fechaI,fechaF,motivo),data);
        Log.d("xd","sayonara bye bye bye bye");
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
                        Calendar c = Calendar.getInstance();
                        int year       = c.get(Calendar.YEAR);
                        int month      = c.get(Calendar.MONTH); // Jan = 0, dec = 11
                        int dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
                        String actualDate = year + "-" + (month+1) + "-" + dayOfMonth;

                        String horaI  = fechaHoraInicio.substring(11);
                        String tema = ap.getNombreTema();
                        String estado = ap.getNombreEstado();

                        Log.d("tag", fechaI + " "  + " " + horaI + " " + estado);

                        int idCreador = ap.getCreador();
                        if (estado.equals("Pendiente")){
                            icon1[0] = R.drawable.ic_nullresource;
                            icon2[0] = R.drawable.ic_cross;
                        }
                        else if (estado.equals("Confirmada") && actualDate.equals(fechaI)){
                            icon1[0] = R.drawable.ic_eye;
                            icon2[0] = R.drawable.ic_cross;

                        }
                        else if (estado.equals("Confirmada") && !actualDate.equals(fechaI)){
                            icon1[0] = R.drawable.ic_eye;
                            icon2[0] = R.drawable.ic_cross;

                        }
                        else if (estado.equals("Cancelada")){
                            icon1[0] = R.drawable.ic_eye;
                            icon2[0] = R.drawable.ic_nullresource;
                        }
                        else if (estado.equals("Sugerida")){
                            icon1[0] = R.drawable.ic_check;
                            icon2[0] = R.drawable.ic_cross;
                        }
                        else if (estado.equals("Rechazada")){
                            icon1[0] = R.drawable.ic_eye;
                            icon2[0] = R.drawable.ic_nullresource;
                        }
                        else if (estado.equals("Asistida")){
                            icon1[0] = R.drawable.ic_eye;
                            icon2[0] = R.drawable.ic_nullresource;
                        }
                        else if (estado.equals("No asistida")){
                            icon1[0] = R.drawable.ic_eye;
                            icon2[0] = R.drawable.ic_nullresource;
                        }

                        int idAppoint = ap.getId();
                        sr.add(new SingleRow(fechaI,horaI,tema,estado,icon1[0],icon2[0], idAppoint));
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




    public boolean cancelListTutor(final Context context,  int idAppoint ){

        Map<String, String> data = new HashMap<>();
        data.put("token", Configuration.LOGIN_USER.getToken());
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);
        Call<String> call = restCon.cancelAppointment(new AppointmentRequest(idAppoint,"","","","","", 123213), data);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                //StudentAppointFragment mp = new StudentAppointFragment();
                //((Activity)context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.drawer_layout ,mp).commit();
                ((Activity)context).getFragmentManager().popBackStack();
                showTopics(context);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                //StudentAppointFragment mp = new StudentAppointFragment();
                //((Activity)context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.drawer_layout ,mp).commit();
                ((Activity)context).getFragmentManager().popBackStack();
                showTopics(context);
            }
        });


        return true;
    }


    public boolean rechazarListTutor(final Context context,  int idAppoint ){

        Map<String, String> data = new HashMap<>();
        data.put("token", Configuration.LOGIN_USER.getToken());
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);
        Call<String> call = restCon.refuseAppointment(new AppointmentRequest(idAppoint,"","","","","", 123213), data);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                //StudentAppointFragment mp = new StudentAppointFragment();
                //((Activity)context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.drawer_layout ,mp).commit();
                ((Activity)context).getFragmentManager().popBackStack();
                showTopics(context);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                //StudentAppointFragment mp = new StudentAppointFragment();
                //((Activity)context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.drawer_layout ,mp).commit();
                ((Activity)context).getFragmentManager().popBackStack();
                showTopics(context);
            }
        });


        return true;
    }


    public boolean refreshListTutor(final Context context,  int idAppoint ){

        Map<String, String> data = new HashMap<>();
        data.put("token", Configuration.LOGIN_USER.getToken());
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);
        Call<String> call = restCon.updateAppointment(new AppointmentRequest(idAppoint,"","","","","",12213123), data);
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


}

