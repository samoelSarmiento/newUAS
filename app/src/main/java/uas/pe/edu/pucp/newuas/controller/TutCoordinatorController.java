package uas.pe.edu.pucp.newuas.controller;

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
import uas.pe.edu.pucp.newuas.adapter.AppointmentAdapterTutor;
import uas.pe.edu.pucp.newuas.adapter.CoordinatorAdapter;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.datapersistency.RestCon;
import uas.pe.edu.pucp.newuas.datapersistency.RetrofitHelper;
import uas.pe.edu.pucp.newuas.model.AppointmentResponseTuto;
import uas.pe.edu.pucp.newuas.model.CoordinatorStudentsResponse;
import uas.pe.edu.pucp.newuas.model.SingleRowCoord;
import uas.pe.edu.pucp.newuas.model.SingleRowTuto;

/**
 * Created by Wingerlion on 20/11/2016.
 */
public class TutCoordinatorController {

    public boolean getStudents (final Context context, final View view, int id) {

        final ImageButton[] b1 = new ImageButton[2] ;
        final int[] icon1 = new int[2], icon2 = new int[2];
        Map<String, String> data = new HashMap<>();
        data.put("token", Configuration.LOGIN_USER.getToken());
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);
        Call<List<CoordinatorStudentsResponse>> call = restCon.getCoordinatorStudent(data);
        Log.d("xd", call.request().url() + " ");
        call.enqueue(new Callback<List<CoordinatorStudentsResponse>>() {

            @Override
            public void onResponse(Call<List<CoordinatorStudentsResponse>> call, Response<List<CoordinatorStudentsResponse>> response) {

                if (response.isSuccessful()){

                    List<CoordinatorStudentsResponse>  appointResponse = response.body();
                    //Collections.reverse(appointResponse);
                    List<SingleRowCoord> sr = new ArrayList<SingleRowCoord>();
                    for (CoordinatorStudentsResponse ap : appointResponse){
                        String code =  ap.getCodigo();
                        String studentName = ap.getNombre() + " " + ap.getApePaterno();
                        String tutorName  = ap.getFullName();
                        int estado = ap.getIdTutoria();
                        String state;
                        if (estado == 0) state = "Sin tutor";
                        else state = "Activo";
                        sr.add(new SingleRowCoord(code,studentName,tutorName,state));
                    }
                     ListView listV = (ListView) view.findViewById(R.id.listViewCustomCoord );
                     listV.setAdapter(new CoordinatorAdapter(context,sr));
                     Log.d("xd","LOGRE REALIZAR MI OBJETIVO SHNADILEY");
                    //listaGeneral = listV;
                }

            }

            @Override
            public void onFailure(Call<List<CoordinatorStudentsResponse>> call, Throwable t) {

            }
        });

        return true;
    }

}
