package uas.pe.edu.pucp.newuas.controller;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
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
import uas.pe.edu.pucp.newuas.fragment.AtenderCitaFragment;
import uas.pe.edu.pucp.newuas.fragment.StudentAppointFragment;
import uas.pe.edu.pucp.newuas.fragment.TutorAppointFragment;
import uas.pe.edu.pucp.newuas.adapter.AppointmentAdapterTutor;
import uas.pe.edu.pucp.newuas.fragment.TutorNewAppointFragment;
import uas.pe.edu.pucp.newuas.fragment.TutorNewNoAppointFragment;
import uas.pe.edu.pucp.newuas.fragment.VisualizarCitaFragment;
import uas.pe.edu.pucp.newuas.model.AppointInformationRegisterTuto;
import uas.pe.edu.pucp.newuas.model.AppointmentRequest;
import uas.pe.edu.pucp.newuas.model.AppointmentResponse;
import uas.pe.edu.pucp.newuas.model.AppointmentResponseTuto;
import uas.pe.edu.pucp.newuas.model.CitaInfoResponse;
import uas.pe.edu.pucp.newuas.model.NoAppointmentResponse;
import uas.pe.edu.pucp.newuas.model.NoCitaRequest;
import uas.pe.edu.pucp.newuas.model.SingleRowTuto;
import uas.pe.edu.pucp.newuas.model.TopicResponse;
import uas.pe.edu.pucp.newuas.view.NavigationDrawerTutoria;
import uas.pe.edu.pucp.newuas.view.NavigationDrawerTutoriaTutor;

/**
 * Created by Wingerlion on 02/11/2016.
 */
public class TutTutorController {

    public ListView listaGeneral;

    public boolean showTopics (final Context context) {

       // NavigationDrawerTutoria.nameTopic = null;
        // NavigationDrawerTutoria.nameTopicsList = null;
        Map<String, String> data = new HashMap<>();
        data.put("token", Configuration.LOGIN_USER.getToken());
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);
        Call<List<TopicResponse>> call = restCon.getTopics(data);
        //Log.d("xd", call.request().url() + "");
        call.enqueue(new Callback<List<TopicResponse>>() {
            @Override
            public void onResponse(Call<List<TopicResponse>> call, Response<List<TopicResponse>> response) {


                List<TopicResponse> topicResponses = response.body();
                NavigationDrawerTutoriaTutor.nameTopicsList.clear();

                for (TopicResponse topic : topicResponses) {
                    NavigationDrawerTutoriaTutor.nameTopicsList.add(topic.getNombre());
                }
                NavigationDrawerTutoriaTutor.nameTopic = new String[NavigationDrawerTutoriaTutor.nameTopicsList.size()];
                for (int i = 0; i < NavigationDrawerTutoriaTutor.nameTopicsList.size(); i++)
                    NavigationDrawerTutoriaTutor.nameTopic[i] = NavigationDrawerTutoriaTutor.nameTopicsList.get(i);

                //MyStudentAppointmentFragment fragment = new MyStudentAppointmentFragment();

                TutorAppointFragment fragment = new TutorAppointFragment();
                ((Activity) context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container, fragment).commit();

            }

            @Override
            public void onFailure(Call<List<TopicResponse>> call, Throwable t) {

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

                 TutorAppointFragment mp = new TutorAppointFragment();
                ((Activity)context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container ,mp).commit();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                 TutorAppointFragment mp = new TutorAppointFragment();
                ((Activity)context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container ,mp).commit();

            }
        });

        return true;
    }

    public boolean obtenerInformacionNoCita(final Context context,  int id ){

        Map<String, String> data = new HashMap<>();
        data.put("token", Configuration.LOGIN_USER.getToken());
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);
        Call<List<NoAppointmentResponse>> call = restCon.obtenerInformacionNoCita(id,data);
        call.enqueue(new Callback<List<NoAppointmentResponse>>() {
            @Override
            public void onResponse(Call<List<NoAppointmentResponse>> call, Response<List<NoAppointmentResponse>> response) {



                List<NoAppointmentResponse> generalInformation = response.body();
                if (generalInformation.isEmpty() || generalInformation == null) {
                    Toast.makeText(context, "El tutor no tiene alumnos registrados!", Toast.LENGTH_LONG).show();
                }
                else{
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Tutoria", (Serializable) generalInformation);
                    TutorNewNoAppointFragment ttc = new TutorNewNoAppointFragment();
                    ttc.setArguments(bundle);
                    ((Activity) context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container, ttc).commit();                }
                }

            @Override
            public void onFailure(Call<List<NoAppointmentResponse>> call, Throwable t) {

            }
        });

        return true;
    }

    public boolean getAppointInformationTuto(final Context context,  int id ){

        Map<String, String> data = new HashMap<>();
        data.put("token", Configuration.LOGIN_USER.getToken());
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);
        Call<List<AppointInformationRegisterTuto>> call = restCon.getAppointInfoTuto(id,data);
        //Log.d("xd", call.request().url() + "");
        call.enqueue(new Callback<List<AppointInformationRegisterTuto>>() {
            @Override
            public void onResponse(Call<List<AppointInformationRegisterTuto>> call, Response<List<AppointInformationRegisterTuto>> response) {

                List<AppointInformationRegisterTuto> generalInformation = response.body();

                if (generalInformation == null || generalInformation.isEmpty()){
                    Toast.makeText(context, "El tutor no tiene alumnos registrados!", Toast.LENGTH_LONG).show();
                }
                else {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Tutoria", (Serializable) generalInformation);
                    TutorNewAppointFragment tnap = new TutorNewAppointFragment();
                    tnap.setArguments(bundle);
                    ((Activity) context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container, tnap).commit();
                }
            }

            @Override
            public void onFailure(Call<List<AppointInformationRegisterTuto>> call, Throwable t) {

            }

        });


        return true;
    }


    public boolean appointmentRequest(final Context context, int idUser, String fecha, String hora, String motivo, String studentFullName){

        Map<String, String> data = new HashMap<>();
        data.put("token", Configuration.LOGIN_USER.getToken());
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);

        Log.d("xd", "fechaaa y horaa " + fecha+ " " + hora);
        Call<String> call = restCon.doAppointmentTutor(new AppointmentRequest(idUser,fecha,hora,"",motivo,studentFullName,123132),data);
         Log.d("tag",  "ke pasa aca " + call.request().url() );
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                TutorAppointFragment mp = new TutorAppointFragment();
                ((Activity)context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container ,mp).commit();

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                TutorAppointFragment mp = new TutorAppointFragment();
                ((Activity)context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container ,mp).commit();
            }
        });

        return true;
    }

    public boolean RealizarCitaConfirmada(final Context context,  int idAppoint ){

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
                AtenderCitaFragment mp = new AtenderCitaFragment();
                mp.setArguments(bundle);
                ((Activity)context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container ,mp).commit();
            }

            @Override
            public void onFailure(Call<List<CitaInfoResponse>> call, Throwable t) {


                AtenderCitaFragment mp = new AtenderCitaFragment();
                ((Activity)context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container ,mp).commit();
            }
        });


        return true;
    }

    public boolean atencionCita(final Context context,  int idAppoint, String obsCita ){

        Map<String, String> data = new HashMap<>();
        data.put("token", Configuration.LOGIN_USER.getToken());
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);
        Call<String> call = restCon.atenderCita(new AppointmentRequest(idAppoint,obsCita,"","","","", 123213), data);
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

    public boolean atencionNoConfirmada(final Context context,  int idUsuario, String fechaActual, String hora, String tema, String obs, int idAlumno, int duracionCita ){

        Map<String, String> data = new HashMap<>();
        data.put("token", Configuration.LOGIN_USER.getToken());
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);
        Call<String> call = restCon.atenderNoCita(new NoCitaRequest(idUsuario,fechaActual,hora,tema,obs,idAlumno, duracionCita), data);
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
                VisualizarCitaFragment mp = new VisualizarCitaFragment();
                mp.setArguments(bundle);
                ((Activity)context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container ,mp).commit();
            }

            @Override
            public void onFailure(Call<List<CitaInfoResponse>> call, Throwable t) {


                VisualizarCitaFragment mp = new VisualizarCitaFragment();
                ((Activity)context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container ,mp).commit();
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

                ((Activity)context).getFragmentManager().popBackStack();
                showTopics(context);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                TutorAppointFragment mp = new TutorAppointFragment();

                ((Activity)context).getFragmentManager().popBackStack();
                showTopics(context);
            }
        });

        return true;
    }

    public boolean getAppointment (final Context context, final View view, int id) {

        final ImageButton[] b1 = new ImageButton[2] ;
        final int[] icon1 = new int[2], icon2 = new int[2];
        Map<String, String> data = new HashMap<>();
        data.put("token", Configuration.LOGIN_USER.getToken());
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);
        Call<List<AppointmentResponseTuto>> call = restCon.getTutorAppoints(id,data);
        Log.d("xd", call.request().url() + " ");
        call.enqueue(new Callback<List<AppointmentResponseTuto>>() {

            @Override
            public void onResponse(Call<List<AppointmentResponseTuto>> call, Response<List<AppointmentResponseTuto>> response) {

                if (response.isSuccessful()){

                    List<AppointmentResponseTuto>  appointResponse = response.body();
                    //Collections.reverse(appointResponse);
                    List<SingleRowTuto> sr = new ArrayList<SingleRowTuto>();
                    for (AppointmentResponseTuto ap : appointResponse){
                        String fechaHoraInicio =  ap.getInicio();
                        String fechaI = fechaHoraInicio.substring(0,10);
                        String horaI  = fechaHoraInicio.substring(11);

                        Calendar c = Calendar.getInstance();
                        int year       = c.get(Calendar.YEAR);
                        int month      = c.get(Calendar.MONTH); // Jan = 0, dec = 11
                        int dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
                        String actualDate = year + "-" + (month+1) + "-" + dayOfMonth;


                        String tema = ap.getNombreTema();
                        String estado = ap.getNombreEstado();
                        String nombreP = ap.getNombreAlumno();
                        int idCreador = ap.getCreador();
                        int idAppoint = ap.getId();

                        if (estado.equals("Pendiente")){
                             icon1[0] = R.drawable.ic_nullresource;
                            icon2[0] = R.drawable.ic_cross;
                        }
                        else if (estado.equals("Confirmada") && actualDate.equals(fechaI)){
                            icon1[0] = R.drawable.ic_atendercita;
                            icon2[0] = R.drawable.ic_cross;

                        }
                        else if (estado.equals("Confirmada") && !actualDate.equals(fechaI)){
                            icon1[0] = R.drawable.ic_eye;
                            icon2[0] = R.drawable.ic_cross;

                        }
                        else if (estado.equals("Cancelada")){

                            icon1[0] = R.drawable.ic_eye;
                            icon2[0] = R.drawable.ic_nullresource;

                        }else if (estado.equals("Sugerida") ){
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

                        sr.add(new SingleRowTuto(fechaI,horaI,tema,estado,nombreP,icon1[0],icon2[0],idAppoint));
                    }
                    ListView listV = (ListView) view.findViewById(R.id.listViewCustomTuto);
                    listV.setAdapter(new AppointmentAdapterTutor(context,sr));
                    listaGeneral = listV;
                }

            }

            @Override
            public void onFailure(Call<List<AppointmentResponseTuto>> call, Throwable t) {

            }
        });

        return true;
    }
}
