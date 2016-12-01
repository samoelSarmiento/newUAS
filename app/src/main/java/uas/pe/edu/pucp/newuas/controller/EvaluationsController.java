package uas.pe.edu.pucp.newuas.controller;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.datapersistency.DatabaseHelper;
import uas.pe.edu.pucp.newuas.datapersistency.RestCon;
import uas.pe.edu.pucp.newuas.datapersistency.RetrofitHelper;
import uas.pe.edu.pucp.newuas.fragment.EvaluationResultListFragment;
import uas.pe.edu.pucp.newuas.fragment.InvDetailFragment;
import uas.pe.edu.pucp.newuas.fragment.InvestigatorsFragment;
import uas.pe.edu.pucp.newuas.model.Evaluation;
import uas.pe.edu.pucp.newuas.model.Investigator;
import uas.pe.edu.pucp.newuas.model.StringResponse;

/**
 * Created by Pedro on 04/11/2016.
 */

public class EvaluationsController {

    Evaluation list = null;
    List<Evaluation> resultado;

    public Evaluation getAllEvaluations(final Context context) {

        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);

        Map<String, String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());
        Call<List<Evaluation>> call = restCon.getEvaluations(token);

        call.enqueue(new Callback<List<Evaluation>>() {
            @Override
            public void onResponse(Call<List<Evaluation>> call, retrofit2.Response<List<Evaluation>> response) {
                //Toast.makeText(context,response.toString(), Toast.LENGTH_SHORT).show();

                if (response.isSuccessful()) {
                    List<Evaluation> evaluation = response.body();
                    List<Evaluation> aux = evaluation;
                    System.out.println("lista completa");

                    Bundle bundle = new Bundle();
                    //bundle.putSerializable("evaluation", (Serializable)evaluation);
                    bundle.putSerializable("evaluation", (Serializable) aux);
                    EvaluationResultListFragment fragment = new EvaluationResultListFragment();
                    fragment.setArguments(bundle);
                    ((Activity) context).getFragmentManager().beginTransaction()
                            .addToBackStack(null).replace(R.id.fragment_container, fragment).commit();
                    //bundle.putString("Investigators", spj);

                    /*InvestigatorsFragment spFragment = new InvestigatorsFragment();
                    spFragment.setArguments(bundle);
                    ((Activity)context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container,spFragment).commit();
                    ((Activity)context).setTitle("Evaluaciones");*/
                    //Toast.makeText(context, "entre", Toast.LENGTH_SHORT).show();

                } else {
                    //Toast.makeText(context, response.message(), Toast.LENGTH_SHORT);
                    //Toast.makeText(context, "fuepe", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<List<Evaluation>> call, Throwable t) {
                t.printStackTrace();
                //Toast.makeText(context, call.request().url().toString(), Toast.LENGTH_SHORT);
                //Toast.makeText(context, "Error2aa", Toast.LENGTH_SHORT).show();
                /*try {
                    List<Investigator> invList = retriveAllInv(context);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Investigators", (Serializable)invList);
                    //bundle.putString("Investigators", spj);

                    InvestigatorsFragment spFragment = new InvestigatorsFragment();
                    spFragment.setArguments(bundle);
                    ((Activity)context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container,spFragment).commit();
                    ((Activity)context).setTitle("Investigadores");
                } catch (SQLException e) {
                    e.printStackTrace();
                }*/
            }


        });

        return list;
    }

    public Evaluation getEvaluationsNameState(final Context context, final String name, final int estado) {

        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);

        Map<String, String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());
        Call<List<Evaluation>> call = restCon.getEvaluations(token);

        call.enqueue(new Callback<List<Evaluation>>() {
            @Override
            public void onResponse(Call<List<Evaluation>> call, retrofit2.Response<List<Evaluation>> response) {

                if (response.isSuccessful()) {
                    List<Evaluation> evaluationes = response.body();

                    //resultado=buscarEnLista(finalList(),name,estado);
                    resultado = buscarEnLista(evaluationes, name, estado);
                    System.out.println("lista completa");

                    Bundle bundle = new Bundle();
                    //bundle.putSerializable("evaluation", (Serializable)evaluation);
                    bundle.putSerializable("evaluation", (Serializable) resultado);
                    EvaluationResultListFragment fragment = new EvaluationResultListFragment();
                    fragment.setArguments(bundle);
                    ((Activity) context).getFragmentManager().beginTransaction()
                            .addToBackStack(null).replace(R.id.fragment_container_tutor, fragment).commit();
                }
            }

            @Override
            public void onFailure(Call<List<Evaluation>> call, Throwable t) {
                t.printStackTrace();
            }
        });
        return list;
    }

    public List<Evaluation> buscarEnLista(List<Evaluation> lista, String nombre, int estado) {
        ArrayList<Evaluation> aux = new ArrayList<Evaluation>();
        if (estado == 0 || estado == 1) {
            if (nombre.equals("")) {
                for (int i = 0; i < lista.size(); i++) {
                    if (estado == lista.get(i).getEstado()) aux.add(lista.get(i));
                }
            } else {
                for (int i = 0; i < lista.size(); i++) {
                    if (lista.get(i).getNombre().contains(nombre) && estado == lista.get(i).getEstado())
                        aux.add(lista.get(i));
                }
            }
        } else
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getNombre().contains(nombre)) aux.add(lista.get(i));
            }
        if (aux.size() == 0) return null;
        else
            return aux;
    }

    public List<Evaluation> finalList() {

        Evaluation e1, e2, e3;

        e1 = new Evaluation();
        e1.setNombre("examen uno");
        e1.setEstado(0);
        e1.setId(1000);
        e1.setFecha_Inicio("2016-11-10");
        e1.setFecha_Fin("2016-12-15");
        e2 = new Evaluation();
        e2.setNombre("examen dos");
        e2.setEstado(1);
        e2.setId(2000);
        e2.setFecha_Inicio("2016-11-12");
        e2.setFecha_Fin("2016-12-20");
        e3 = new Evaluation();
        e3.setNombre("examen tres");
        e3.setEstado(1);
        e3.setId(3000);
        e3.setFecha_Inicio("2016-11-13");
        e3.setFecha_Fin("2016-12-30");
        ArrayList<Evaluation> lista = new ArrayList<>();
        lista.add(e1);
        lista.add(e2);
        lista.add(e3);

        return lista;
    }
}
