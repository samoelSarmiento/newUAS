package uas.pe.edu.pucp.newuas.controller;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.textservice.SpellCheckerInfo;

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
import uas.pe.edu.pucp.newuas.fragment.SemesterListFragment;
import uas.pe.edu.pucp.newuas.model.Semester;
import uas.pe.edu.pucp.newuas.model.Specialty;

/**
 * Created by Marshall on 25/10/2016.
 */

public class SemesterController {

    public boolean getSemestersofPeriod(final Context context, final Integer periodId) {
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);

        Map<String, String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());

        Call<List<Semester>> call = restCon.getSemofPer(periodId, token);

        call.enqueue(new Callback<List<Semester>>() {
            @Override
            public void onResponse(Call<List<Semester>> call, Response<List<Semester>> response) {
                if (response.isSuccessful()) {
                    List<Semester> semList = response.body();

                    SemesterListFragment slf = new SemesterListFragment();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Semesters", (Serializable) semList);
                    slf.setArguments(bundle);

                    try {
                        saveSemesters(context, semList);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    ((Activity) context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container, slf).commit();
                    ((Activity) context).setTitle("Semestres");


                } else {
                    Log.d("TAG", response.errorBody().toString());

                    List<Semester> semList = null;
                    try {
                        semList = getSemestersListofPeriod(context, periodId);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    SemesterListFragment slf = new SemesterListFragment();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Semesters", (Serializable) semList);
                    slf.setArguments(bundle);

                    ((Activity) context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container, slf).commit();
                    ((Activity) context).setTitle("Semestres");
                }
            }

            @Override
            public void onFailure(Call<List<Semester>> call, Throwable t) {
                t.printStackTrace();

            }
        });

        return true;

    }


    private List<Semester> getSemestersListofPeriod(final Context context, Integer periodId) throws SQLException {
        DatabaseHelper helper = new DatabaseHelper(context);
        Dao<Semester, Integer> semesterDao = helper.getSemesterDao();
        return semesterDao.queryForEq("idPeriodo", periodId);
    }

    private void saveSemesters(final Context context, List<Semester> semesters) throws SQLException {
        DatabaseHelper helper = new DatabaseHelper(context);
        Dao<Semester, Integer> semesterDao = helper.getSemesterDao();
        for (Semester semester : semesters) {
            Semester find = semesterDao.queryForId(semester.getIdCicloAcademico());
            if (find == null) {
                semesterDao.create(semester);
            } else {
                semesterDao.update(semester);
            }
        }
    }

    private Semester getSemesterById(final Context context, Integer idSem) throws SQLException {
        DatabaseHelper helper = new DatabaseHelper(context);
        Dao<Semester, Integer> semesterDao = helper.getSemesterDao();
        return semesterDao.queryForId(idSem);

    }

    private void saveSemester(final Context context, Semester semester) throws SQLException {
        DatabaseHelper helper = new DatabaseHelper(context);
        Dao<Semester, Integer> semesterDao = helper.getSemesterDao();
        Semester find = semesterDao.queryForId(semester.getIdEspecialidad());
        if (find == null) {
            semesterDao.create(semester);
        } else {
            semesterDao.update(semester);
        }

    }


}

