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
import uas.pe.edu.pucp.newuas.fragment.DelivDetailFragment;
import uas.pe.edu.pucp.newuas.fragment.DeliverableFragment;
import uas.pe.edu.pucp.newuas.fragment.InvEventDetailFragment;
import uas.pe.edu.pucp.newuas.fragment.InvEventFragment;
import uas.pe.edu.pucp.newuas.model.Deliverable;
import uas.pe.edu.pucp.newuas.model.InvEvent;
import uas.pe.edu.pucp.newuas.model.StringResponse;

/**
 * Created by Andree on 11/11/2016.
 */

public class DeliverableController {

    public void getDeliv(final Context context, Integer projId){
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);

        Map<String, String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());
        Call<List<Deliverable>> call = restCon.getDelByProjId(projId,token);

        call.enqueue(new Callback<List<Deliverable>>() {
            @Override
            public void onResponse(Call<List<Deliverable>> call, retrofit2.Response<List<Deliverable>> response) {
                //Toast.makeText(context,response.toString(), Toast.LENGTH_SHORT).show();

                if (response.isSuccessful()) {
                    //okhttp3.Response raw = response.raw();
                    //SpecialtyResponse
                    List<Deliverable> example = response.body();
/*
                    try {
                        saveAllInvEv(example, context);
                    } catch (SQLException e) {
                        Toast.makeText(context, "catched", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
*/
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Deliverables", (Serializable)example);
                    //bundle.putString("Groups", spj);

                    DeliverableFragment spFragment = new DeliverableFragment();
                    spFragment.setArguments(bundle);
                    ((Activity)context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container,spFragment).commit();
                    ((Activity)context).setTitle("Proyectos > Entregables");
                    //Toast.makeText(context, "entre", Toast.LENGTH_SHORT).show();

                } else {
                    //Toast.makeText(context, response.message(), Toast.LENGTH_SHORT);
                    //Toast.makeText(context, "fuepe", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<List<Deliverable>> call, Throwable t) {
                t.printStackTrace();
/*
                try {
                    List<InvEvent> invGList = retriveAllInvEv(context);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Events", (Serializable)invGList);
                    //bundle.putString("Groups", spj);

                    InvEventFragment spFragment = new InvEventFragment();
                    spFragment.setArguments(bundle);
                    ((Activity)context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container,spFragment).commit();
                    ((Activity)context).setTitle("Grupos de Inv. > Eventos");
                } catch (SQLException e) {
                    e.printStackTrace();
                    Toast.makeText(context, "catched", Toast.LENGTH_SHORT).show();
                }
*/
            }
        });
    }
    public void getDelivById(final Context context,final Integer id){
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);

        Map<String, String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());
            Call<List<Deliverable>> call = restCon.getDelById(id,token);

        call.enqueue(new Callback<List<Deliverable>>() {
            @Override
            public void onResponse(Call<List<Deliverable>> call, retrofit2.Response<List<Deliverable>> response) {
                //Toast.makeText(context,response.toString(), Toast.LENGTH_SHORT).show();

                if (response.isSuccessful()) {

                    List<Deliverable> example = response.body();
/*
                    try {
                        saveInvEv(example.get(0), context);
                    } catch (SQLException e) {
                        Toast.makeText(context, "catched", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
*/
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Deliverable", (Serializable)example);
                    //bundle.putBoolean("BotonEdit",true);

                    DelivDetailFragment spFragment = new DelivDetailFragment();
                    spFragment.setArguments(bundle);
                    //Toast.makeText(context, "entre3", Toast.LENGTH_SHORT).show();
                    ((Activity)context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container,spFragment).commit();
                    ((Activity)context).setTitle("Proyectos > Entregables");
                    //Toast.makeText(context, "entre4", Toast.LENGTH_SHORT).show();
                    //Toast.makeText(context, "entre", Toast.LENGTH_SHORT).show();

                } else {

                }

            }

            @Override
            public void onFailure(Call<List<Deliverable>> call, Throwable t) {
                t.printStackTrace();
/*
                try {
                    InvEvent invG = getInvEv(id, context);

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Event", (Serializable)invG);
                    bundle.putBoolean("BotonEdit",false);

                    InvEventDetailFragment spFragment = new InvEventDetailFragment();
                    spFragment.setArguments(bundle);
                    //Toast.makeText(context, "entre3", Toast.LENGTH_SHORT).show();
                    ((Activity)context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container,spFragment).commit();
                    ((Activity)context).setTitle("Grupos de Inv. > Eventos");

                } catch (SQLException e) {
                    Toast.makeText(context, "catched", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }*/
            }
        });
    }

    public void editDeliv(final Context context, final Deliverable deliverable){
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);
        //Toast.makeText(context,"llegue", Toast.LENGTH_SHORT).show();
        Map<String, String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());
        Call<StringResponse> call = restCon.editDeliv(deliverable.getId(),token,deliverable);

        call.enqueue(new Callback<StringResponse>() {
            @Override
            public void onResponse(Call<StringResponse> call, retrofit2.Response<StringResponse> response) {
                //Toast.makeText(context,response.toString(), Toast.LENGTH_SHORT).show();
                //Toast.makeText(context,"entre", Toast.LENGTH_SHORT).show();
                if (response.isSuccessful()) {
                    //Toast.makeText(context,"entre2", Toast.LENGTH_SHORT).show();

/*
                    try {
                        saveInvEv(example.get(0), context);
                    } catch (SQLException e) {
                        Toast.makeText(context, "catched", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
*/


                } else {
//                    Toast.makeText(context,"entre3", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<StringResponse> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(context, "No se pudo guardar", Toast.LENGTH_SHORT).show();
/*
                try {
                    InvEvent invG = getInvEv(id, context);

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Event", (Serializable)invG);
                    bundle.putBoolean("BotonEdit",false);

                    InvEventDetailFragment spFragment = new InvEventDetailFragment();
                    spFragment.setArguments(bundle);
                    //Toast.makeText(context, "entre3", Toast.LENGTH_SHORT).show();
                    ((Activity)context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container,spFragment).commit();
                    ((Activity)context).setTitle("Grupos de Inv. > Eventos");

                } catch (SQLException e) {
                    Toast.makeText(context, "catched", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }*/
            }
        });
    }

}
