package uas.pe.edu.pucp.newuas.controller;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.Toast;

import com.j256.ormlite.dao.Dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.datapersistency.DatabaseHelper;
import uas.pe.edu.pucp.newuas.datapersistency.RestCon;
import uas.pe.edu.pucp.newuas.datapersistency.RetrofitHelper;
import uas.pe.edu.pucp.newuas.fragment.InvEventDetailFragment;
import uas.pe.edu.pucp.newuas.fragment.InvEventFragment;
import uas.pe.edu.pucp.newuas.model.InvEvent;
import uas.pe.edu.pucp.newuas.model.InvGroups;
import uas.pe.edu.pucp.newuas.model.StringResponse;

/**
 * Created by Andree on 04/11/2016.
 */

public class InvEventController {

    public void getInvEvents(final Context context, Integer invGId){
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);

        Map<String, String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());
        Call<List<InvEvent>> call = restCon.getEvByGroupId(invGId,token);

        call.enqueue(new Callback<List<InvEvent>>() {
            @Override
            public void onResponse(Call<List<InvEvent>> call, retrofit2.Response<List<InvEvent>> response) {
                //Toast.makeText(context,response.toString(), Toast.LENGTH_SHORT).show();

                if (response.isSuccessful()) {
                    //okhttp3.Response raw = response.raw();
                    //SpecialtyResponse
                    List<InvEvent> example = response.body();


                    try {
                        saveAllInvEv(example, context);
                    } catch (SQLException e) {
                        Toast.makeText(context, "catched", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Events", (Serializable)example);
                    //bundle.putString("Groups", spj);

                    InvEventFragment spFragment = new InvEventFragment();
                    spFragment.setArguments(bundle);
                    ((Activity)context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container,spFragment).commit();
                    ((Activity)context).setTitle("Grupos de Inv. > Eventos");
                    //Toast.makeText(context, "entre", Toast.LENGTH_SHORT).show();

                } else {
                    //Toast.makeText(context, response.message(), Toast.LENGTH_SHORT);
                    //Toast.makeText(context, "fuepe", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<List<InvEvent>> call, Throwable t) {
                t.printStackTrace();

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

            }


        });
    }
    public void getInvEvById(final Context context,final Integer id){
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);

        Map<String, String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());
        Call<List<InvEvent>> call = restCon.getEvById(id,token);

        call.enqueue(new Callback<List<InvEvent>>() {
            @Override
            public void onResponse(Call<List<InvEvent>> call, retrofit2.Response<List<InvEvent>> response) {
                //Toast.makeText(context,response.toString(), Toast.LENGTH_SHORT).show();

                if (response.isSuccessful()) {

                    List<InvEvent> example = response.body();

                    try {
                        saveInvEv(example.get(0), context);
                    } catch (SQLException e) {
                        Toast.makeText(context, "catched", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Event", (Serializable)example);
                    bundle.putBoolean("BotonEdit",true);

                    InvEventDetailFragment spFragment = new InvEventDetailFragment();
                    spFragment.setArguments(bundle);
                    //Toast.makeText(context, "entre3", Toast.LENGTH_SHORT).show();
                    ((Activity)context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container,spFragment).commit();
                    ((Activity)context).setTitle("Grupos de Inv. > Eventos");
                    //Toast.makeText(context, "entre4", Toast.LENGTH_SHORT).show();
                    //Toast.makeText(context, "entre", Toast.LENGTH_SHORT).show();

                } else {

                }

            }

            @Override
            public void onFailure(Call<List<InvEvent>> call, Throwable t) {
                t.printStackTrace();

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
                }
            }
        });
    }

    public void editInvEv (final Context context, InvEvent invEvent){
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);

        Map<String, String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());

        //InvGroupsRequest igr= new InvGroupsRequest(invG);

        Call<String> call = restCon.editInvEv(invEvent.getId(),token,invEvent);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, retrofit2.Response<String> response) {
                //Toast.makeText(context,response.toString(), Toast.LENGTH_SHORT).show();

                if (response.isSuccessful()) {
                    /*
                    try {
                        saveInvGroup(invG, context);
                        //Toast.makeText(context, "Se guardo en sql", Toast.LENGTH_SHORT).show();
                    } catch (SQLException e) {
                        Toast.makeText(context, "catched", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }*/
/*
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("InvGroup", (Serializable)invG);
                    bundle.putBoolean("BotonEdit",true);
                    //bundle.putString("Investigators", spj);

                    InvGroupDetailFragment spFragment = new InvGroupDetailFragment();
                    spFragment.setArguments(bundle);
                    //Toast.makeText(context, "entre3", Toast.LENGTH_SHORT).show();
                    ((Activity)context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container,spFragment).commit();
                    ((Activity)context).setTitle("Grupos de Inv.");*/

                } else {

                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                t.printStackTrace();
                //Toast.makeText(context, "No se pudo guardar", Toast.LENGTH_SHORT).show();
            }
        });
        ConnectivityManager connectivityManager =(ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState()== NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState()==NetworkInfo.State.CONNECTED){
            //Toast.makeText(context, "conectado", Toast.LENGTH_SHORT).show();
            try {
                saveInvEv(invEvent, context);
                //Toast.makeText(context, "Se guardo en sql", Toast.LENGTH_SHORT).show();
            } catch (SQLException e) {
                Toast.makeText(context, "catched", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
            Toast.makeText(context, "Se guardo correctamente", Toast.LENGTH_SHORT).show();
        }else Toast.makeText(context, "No se pudo guardar", Toast.LENGTH_SHORT).show();
    }

    private void saveAllInvEv(List<InvEvent> invGList, final Context context) throws SQLException {
        DatabaseHelper helper = new DatabaseHelper(context);
        Dao<InvEvent, Integer> invGDao = helper.getInvEventDao();
        //Toast.makeText(context, "entreDB", Toast.LENGTH_SHORT).show();
        for (InvEvent invG : invGList) {
            //veo si la especialidad existe
            InvEvent find = invGDao.queryForId(invG.getId());
            if (find == null) {
                invGDao.create(invG);
            } else {
                //si se encontro la actualizo
                invGDao.update(invG);
            }
        }
    }
    //Lista de inv g.
    private List<InvEvent> retriveAllInvEv(final Context context) throws SQLException {
        DatabaseHelper helper = new DatabaseHelper(context);
        Dao<InvEvent, Integer> invGDao = helper.getInvEventDao();
        return invGDao.queryForAll();
    }

    private void saveInvEv(InvEvent invG, final Context context) throws SQLException {
        DatabaseHelper helper = new DatabaseHelper(context);
        Dao<InvEvent, Integer> invGDao = helper.getInvEventDao();
        InvEvent find = invGDao.queryForId(invG.getId());
        if (find == null) {
            invGDao.create(invG);
        } else {
            invGDao.update(invG);
        }
    }

    private InvEvent getInvEv(Integer id, final Context context) throws SQLException {
        DatabaseHelper helper = new DatabaseHelper(context);
        Dao<InvEvent, Integer> invGDao = helper.getInvEventDao();
        return invGDao.queryForId(id);
    }

}
