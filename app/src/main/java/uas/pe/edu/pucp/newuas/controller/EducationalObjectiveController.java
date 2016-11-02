package uas.pe.edu.pucp.newuas.controller;

import android.app.Activity;
import android.content.Context;
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
import retrofit2.Response;
import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.datapersistency.DatabaseHelper;
import uas.pe.edu.pucp.newuas.datapersistency.RestCon;
import uas.pe.edu.pucp.newuas.datapersistency.RetrofitHelper;
import uas.pe.edu.pucp.newuas.fragment.AspectListFragment;
import uas.pe.edu.pucp.newuas.fragment.EducationalObjectiveListFragment;
import uas.pe.edu.pucp.newuas.fragment.StudentResultListFragment;
import uas.pe.edu.pucp.newuas.model.Aspect;
import uas.pe.edu.pucp.newuas.model.EducationalObjective;
import uas.pe.edu.pucp.newuas.model.Student;
import uas.pe.edu.pucp.newuas.model.StudentResult;

/**
 * Created by Marshall on 31/10/2016.
 */

public class EducationalObjectiveController {

    public void getEducationalObjectivesofPeriodSpec(final Context context, final Integer idPeriod, final Integer idSpecialty) {
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);

        Map<String, String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());

        Call<List<EducationalObjective>> call = restCon.getEducationalObjectivesByPeriodSpecialty(idPeriod, idSpecialty, token);

        call.enqueue(new Callback<List<EducationalObjective>>() {
            @Override
            public void onResponse(Call<List<EducationalObjective>> call, Response<List<EducationalObjective>> response) {
                if (response.isSuccessful()) {
                    List<EducationalObjective> eos = response.body();
                    //--guardar los objetivos
                    try {
                        saveEducationalObjectives(context, eos, idPeriod);
                    } catch (SQLException e) {
                        Toast.makeText(context, "Error al guardar los datos", Toast.LENGTH_SHORT).show();
                    }
                    //
                    EducationalObjectiveListFragment eof = new EducationalObjectiveListFragment();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("EducObjs", (Serializable) eos);
                    eof.setArguments(bundle);

                    ((Activity) context).getFragmentManager()
                            .beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.fragment_container, eof)
                            .commit();
                    ((Activity) context).setTitle("Objetivos Educacionales");
                }
            }

            @Override
            public void onFailure(Call<List<EducationalObjective>> call, Throwable t) {
                try {
                    List<EducationalObjective> eos = retrieveEducationalObjectives(context, idSpecialty, idPeriod);
                    EducationalObjectiveListFragment eof = new EducationalObjectiveListFragment();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("EducObjs", (Serializable) eos);
                    eof.setArguments(bundle);
                    ((Activity) context).getFragmentManager()
                            .beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.fragment_container, eof)
                            .commit();
                    ((Activity) context).setTitle("Objetivos Educacionales");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void getStudentResults(final Context context, final int idSpecialty, final int idEdOb) {
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);
        Map<String, String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());

        Call<List<StudentResult>> call = restCon.getStudentResults(idSpecialty, idEdOb, token);
        call.enqueue(new Callback<List<StudentResult>>() {
            @Override
            public void onResponse(Call<List<StudentResult>> call, Response<List<StudentResult>> response) {
                if (response.isSuccessful()) {
                    List<StudentResult> list = response.body();
                    //--guardar el resultado estudiantil
                    try {
                        saveStudenResult(context, list, idEdOb);
                    } catch (SQLException e) {
                        Toast.makeText(context, "Error al guardar los datos", Toast.LENGTH_SHORT).show();
                    }
                    //
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("studentResult", (Serializable) list);
                    StudentResultListFragment studentResultListFragment = new StudentResultListFragment();
                    studentResultListFragment.setArguments(bundle);
                    ((Activity) context).getFragmentManager().beginTransaction().addToBackStack(null)
                            .replace(R.id.fragment_container, studentResultListFragment).commit();
                    ((Activity) context).setTitle("Resultados Estudiantiles");
                }
            }

            @Override
            public void onFailure(Call<List<StudentResult>> call, Throwable t) {
                try {
                    List<StudentResult> list = retrieveStudentResult(context, idSpecialty, idEdOb);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("studentResult", (Serializable) list);
                    StudentResultListFragment studentResultListFragment = new StudentResultListFragment();
                    studentResultListFragment.setArguments(bundle);
                    ((Activity) context).getFragmentManager().beginTransaction().addToBackStack(null)
                            .replace(R.id.fragment_container, studentResultListFragment).commit();
                    ((Activity) context).setTitle("Resultados Estudiantiles");
                } catch (SQLException e) {
                    Toast.makeText(context, "Error al recuperar los datos", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void getStudentResultAspects(final Context context, int idStudenResult) {
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);
        Map<String, String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());

        Call<List<Aspect>> call = restCon.getStudentResultAspects(idStudenResult, token);
        call.enqueue(new Callback<List<Aspect>>() {
            @Override
            public void onResponse(Call<List<Aspect>> call, Response<List<Aspect>> response) {
                if (response.isSuccessful()) {
                    List<Aspect> list = response.body();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("aspects", (Serializable) list);
                    AspectListFragment aspectListFragment = new AspectListFragment();
                    ((Activity) context).getFragmentManager().beginTransaction()
                            .addToBackStack(null).replace(R.id.fragment_container, aspectListFragment).commit();
                }
            }

            @Override
            public void onFailure(Call<List<Aspect>> call, Throwable t) {

            }
        });
    }

    private void saveStudenResult(final Context context, List<StudentResult> list, int idObjetivoEducacional) throws SQLException {
        DatabaseHelper helper = new DatabaseHelper(context);
        Dao<StudentResult, Integer> studentResultsDao = helper.getStudentResultDao();
        for (StudentResult studentResult : list) {
            studentResult.setIdObjetivoEduacional(idObjetivoEducacional);
            StudentResult find = studentResultsDao.queryForId(studentResult.getIdResultadoEstudiantil());
            if (find == null) {
                studentResultsDao.create(studentResult);
            } else {
                studentResultsDao.update(studentResult);
            }
        }

    }

    private List<StudentResult> retrieveStudentResult(final Context context, int idSpecialty, int idObjetivoEducacional) throws SQLException {
        DatabaseHelper helper = new DatabaseHelper(context);
        Dao<StudentResult, Integer> studentResultDao = helper.getStudentResultDao();
        return studentResultDao.queryBuilder().where()
                .eq("IdEspecialidad", idSpecialty)
                .and().eq("idObjetivoEduacional", idObjetivoEducacional).query();
    }

    private void saveEducationalObjectives(final Context context, List<EducationalObjective> list, int idPeriod) throws SQLException {
        DatabaseHelper helper = new DatabaseHelper(context);
        Dao<EducationalObjective, Integer> eosDao = helper.getEducationalObjectiveDao();
        for (EducationalObjective eos : list) {
            eos.setPeriod_id(idPeriod);
            EducationalObjective find = eosDao.queryForId(eos.getIdObjetivoEducacional());
            if (find == null) {
                eosDao.create(eos);
            } else {
                eosDao.update(eos);
            }
        }
    }

    private List<EducationalObjective> retrieveEducationalObjectives(final Context context, int idSpecialty, int idPeriod) throws SQLException {
        DatabaseHelper helper = new DatabaseHelper(context);
        Dao<EducationalObjective, Integer> eosDao = helper.getEducationalObjectiveDao();
        return eosDao.queryBuilder().where().eq("idEspecialidad", idSpecialty)
                .and().eq("period_id", idPeriod).query();
    }
}
