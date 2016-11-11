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
import uas.pe.edu.pucp.newuas.fragment.DateSupervisorStudentEmployer;
import uas.pe.edu.pucp.newuas.fragment.InscriptionFilePSPJ;
import uas.pe.edu.pucp.newuas.fragment.PSP_supDocumentFragment;
import uas.pe.edu.pucp.newuas.fragment.PSP_supDocumentsByStudent;

import uas.pe.edu.pucp.newuas.fragment.PspGetStudentsForDateEmployer;
import uas.pe.edu.pucp.newuas.fragment.PspStudentSelectAll;
import uas.pe.edu.pucp.newuas.fragment.StudentAppointFragment;
import uas.pe.edu.pucp.newuas.fragment.checkStudentDetailPsp;
import uas.pe.edu.pucp.newuas.fragment.psp_dates_supervisor_jefe;
import uas.pe.edu.pucp.newuas.model.AppointmentRequest;
import uas.pe.edu.pucp.newuas.model.InscriptionFilePSP;
import uas.pe.edu.pucp.newuas.model.Psp_dates_supervisor_employers;
import uas.pe.edu.pucp.newuas.model.Psp_dates_supervisor_employers_get;
import uas.pe.edu.pucp.newuas.model.Student;
import uas.pe.edu.pucp.newuas.model.StudentPsp;
import uas.pe.edu.pucp.newuas.model.TutStudentForPsp;

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
    }

    public boolean getStudentsForDates (final Context context) {

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
                    PspGetStudentsForDateEmployer spFragment = new PspGetStudentsForDateEmployer();
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

    public boolean appointmentRequest(final Context context, int idUser, String fecha, String hora, int idAlumno, String lugar){

//falta mandar el idAlumno !
        Toast.makeText(context , "Lugar " + lugar , Toast.LENGTH_SHORT).show();
        RestCon restCon  = RetrofitHelper.apiConnector.create(RestCon.class);
        Map<String,String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());
String motivo  = "Motivo académicofv" ;
        Psp_dates_supervisor_employers psdse = new Psp_dates_supervisor_employers( idUser,fecha,hora,motivo,idAlumno,lugar );

       // Toast.makeText(context , fecha +" " +  psdse.getIdAlumno(), Toast.LENGTH_SHORT).show();


        Call<String> call = restCon.realizarCitasPSPsupervJefe(   token , psdse ); //colocar los parámetros que s e enviarán.




        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                Toast.makeText(context , "Se registro la cita con éxito", Toast.LENGTH_SHORT).show();

                     //    StudentAppointFragment mp = new StudentAppointFragment();
             //   ((Activity)context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container ,mp).commit();

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
             //   Toast.makeText(context , "No hay conexión", Toast.LENGTH_SHORT).show();
             //   StudentAppointFragment mp = new StudentAppointFragment();
             //   ((Activity)context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container ,mp).commit();
            }
        });
        return true;
    }



    public boolean getStudentsForSelectAll (final Context context) {

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
                    PspStudentSelectAll spFragment = new PspStudentSelectAll();
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







    public boolean getInformationStudent (final Context context) {

        RestCon restCon  = RetrofitHelper.apiConnector.create(RestCon.class);
        Map<String,String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());
        int idAlumno = PspStudentSelectAll.studentSelected.getIdAlumno();


        Call<List<TutStudentForPsp>> call = restCon.getTutStudentDetail( idAlumno ,token);
        call.enqueue(new Callback<List<TutStudentForPsp>>() {

            @Override
            public void onResponse(Call<List<TutStudentForPsp>> call, retrofit2.Response<List<TutStudentForPsp>> response) {
                if (response.isSuccessful()) {
                    List<TutStudentForPsp> informe = response.body();
            //        Toast.makeText(context, "Informe de inscripción", Toast.LENGTH_SHORT).show();
                    Bundle bundle =  new Bundle();
                    bundle.putSerializable("tutstudentpsp",(Serializable) informe);
                    checkStudentDetailPsp fragment = new checkStudentDetailPsp();
                    fragment.setArguments(bundle);
                    ((Activity)context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container_psp,fragment).commit();
                    //((Activity)context).setTitle("Alumnos");

                } else {

                    Toast.makeText(context, "Hubo un problema" , Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<List<TutStudentForPsp>> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(context, "Fallo la conexión", Toast.LENGTH_SHORT).show();

            }
        });
        return true;

    }



    public boolean getDatesSupervisorEmployerStudent (final Context context) {

        RestCon restCon  = RetrofitHelper.apiConnector.create(RestCon.class);
        Map<String,String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());

        Call<List<Psp_dates_supervisor_employers_get>> call = restCon.getDatesSuperEmployerPsp(token);
        call.enqueue(new Callback<List<Psp_dates_supervisor_employers_get>>() {

            @Override
            public void onResponse(Call<List<Psp_dates_supervisor_employers_get>> call, retrofit2.Response<List<Psp_dates_supervisor_employers_get>> response) {
                if (response.isSuccessful()) {
                    List<Psp_dates_supervisor_employers_get> listaEstudiantes = response.body();
                    Toast.makeText(context, "Lista de alumnos", Toast.LENGTH_SHORT).show();
                    Bundle bundle =  new Bundle();
                    bundle.putSerializable("DateSuperEmployerPSP",(Serializable) listaEstudiantes);
                    DateSupervisorStudentEmployer spFragment = new DateSupervisorStudentEmployer();
                    spFragment.setArguments(bundle);
                    ((Activity)context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container_psp,spFragment).commit();
                    ((Activity)context).setTitle("Citas");

                } else {

                    Toast.makeText(context, "Hubo un problema" , Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<List<Psp_dates_supervisor_employers_get>> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(context, "Fallo la conexión", Toast.LENGTH_SHORT).show();

            }
        });
        return true;

    }






}
