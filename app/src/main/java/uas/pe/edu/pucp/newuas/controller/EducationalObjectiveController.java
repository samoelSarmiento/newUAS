package uas.pe.edu.pucp.newuas.controller;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.Toast;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.query.In;

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
import uas.pe.edu.pucp.newuas.fragment.CriterionLevelListFragment;
import uas.pe.edu.pucp.newuas.fragment.CriterionListFragment;
import uas.pe.edu.pucp.newuas.fragment.EducationalObjectiveListFragment;
import uas.pe.edu.pucp.newuas.fragment.StudentResultListFragment;
import uas.pe.edu.pucp.newuas.model.Aspect;
import uas.pe.edu.pucp.newuas.model.Criterion;
import uas.pe.edu.pucp.newuas.model.CriterionLevel;
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

    public void getStudentResultAspects(final Context context, final int idStudenResult) {
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);
        Map<String, String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());

        Call<List<Aspect>> call = restCon.getStudentResultAspects(idStudenResult, token);
        call.enqueue(new Callback<List<Aspect>>() {
            @Override
            public void onResponse(Call<List<Aspect>> call, Response<List<Aspect>> response) {
                if (response.isSuccessful()) {
                    List<Aspect> list = response.body();
                    //guardar aspectos
                    try {
                        saveAspects(context, list);
                    } catch (SQLException e) {
                        Toast.makeText(context, "Error al guardar los datos", Toast.LENGTH_SHORT).show();
                    }
                    //--
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("aspects", (Serializable) list);
                    AspectListFragment aspectListFragment = new AspectListFragment();
                    aspectListFragment.setArguments(bundle);
                    ((Activity) context).getFragmentManager().beginTransaction()
                            .addToBackStack(null).replace(R.id.fragment_container, aspectListFragment).commit();
                }
            }

            @Override
            public void onFailure(Call<List<Aspect>> call, Throwable t) {
                try {
                    List<Aspect> list = retrieveAspects(context, idStudenResult);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("aspects", (Serializable) list);
                    AspectListFragment aspectListFragment = new AspectListFragment();
                    ((Activity) context).getFragmentManager().beginTransaction()
                            .addToBackStack(null).replace(R.id.fragment_container, aspectListFragment).commit();
                } catch (SQLException e) {
                    Toast.makeText(context, "Error al recuperar los datos", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    public void getCriterionsofAspect(final Context context, final Integer idAspect){

        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);
        Map<String, String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());

        Call<List<Criterion>> call = restCon.getCriterionsofAspect(idAspect, token);

        call.enqueue(new Callback<List<Criterion>>() {
            @Override
            public void onResponse(Call<List<Criterion>> call, Response<List<Criterion>> response) {
                if(response.isSuccessful()){
                    List<Criterion> crits = response.body();

                    CriterionListFragment clf = new CriterionListFragment();

                    try {
                        saveCriterions(context,crits);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }


                    Bundle bundle = new Bundle();
                    bundle.putSerializable("crits",(Serializable)crits);

                    clf.setArguments(bundle);

                    ((Activity) context).getFragmentManager().beginTransaction()
                            .addToBackStack(null).replace(R.id.fragment_container, clf).commit();



                }else{
                    Log.d("wat",response.errorBody().toString());




                }
            }

            @Override
            public void onFailure(Call<List<Criterion>> call, Throwable t) {

                List<Criterion> crits = null;
                try {
                    crits = retrieveCriterionsfromAspect(context,idAspect);

                    CriterionListFragment clf = new CriterionListFragment();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("crits",(Serializable)crits);

                    clf.setArguments(bundle);

                    ((Activity) context).getFragmentManager().beginTransaction()
                            .addToBackStack(null).replace(R.id.fragment_container, clf).commit();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        });



    }


    public void getLevelsofCriterion(final Context context, final Integer critId){
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);
        Map<String, String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());

        Call<List<CriterionLevel>> call = restCon.getLevelsofCriterion(critId, token);
        call.enqueue(new Callback<List<CriterionLevel>>() {
            @Override
            public void onResponse(Call<List<CriterionLevel>> call, Response<List<CriterionLevel>> response) {
                if(response.isSuccessful()){
                    List<CriterionLevel> cls = response.body();

                    try {
                        saveCritLevs(context,cls);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    CriterionLevelListFragment cllf = new CriterionLevelListFragment();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("critlevs",(Serializable)cls);
                    cllf.setArguments(bundle);

                    ((Activity) context).getFragmentManager().beginTransaction()
                            .addToBackStack(null).replace(R.id.fragment_container, cllf).commit();





                }else{
                    Log.d("wat",response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<List<CriterionLevel>> call, Throwable t) {

                List<CriterionLevel> cls = null;
                try {
                    cls = retrieveCritLevelsfromCriterion(context, critId);
                    CriterionLevelListFragment cllf = new CriterionLevelListFragment();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("critlevs",(Serializable)cls);
                    cllf.setArguments(bundle);

                    ((Activity) context).getFragmentManager().beginTransaction()
                            .addToBackStack(null).replace(R.id.fragment_container, cllf).commit();

                } catch (SQLException e) {
                    e.printStackTrace();
                }




            }
        });
    }

    private void saveAspects(final Context context, List<Aspect> list) throws SQLException {
        DatabaseHelper helper = OpenHelperManager.getHelper(context,DatabaseHelper.class);;
        Dao<Aspect, Integer> aspectDao = helper.getAspectDao();
        for (Aspect aspect : list) {
            Aspect find = aspectDao.queryForId(aspect.getIdAspecto());
            if (find == null) {
                aspectDao.create(aspect);
            } else {
                aspectDao.update(aspect);
            }
        }
    }

    private List<Aspect> retrieveAspects(final Context context, int idStudenResult) throws SQLException {
        DatabaseHelper helper = OpenHelperManager.getHelper(context,DatabaseHelper.class);;
        Dao<Aspect, Integer> aspectDao = helper.getAspectDao();
        return aspectDao.queryBuilder().where().eq("idResultadoEstudiantil", idStudenResult).query();
    }

    private void saveStudenResult(final Context context, List<StudentResult> list, int idObjetivoEducacional) throws SQLException {
        DatabaseHelper helper = OpenHelperManager.getHelper(context,DatabaseHelper.class);;
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
        DatabaseHelper helper = OpenHelperManager.getHelper(context,DatabaseHelper.class);;
        Dao<StudentResult, Integer> studentResultDao = helper.getStudentResultDao();
        return studentResultDao.queryBuilder().where()
                .eq("IdEspecialidad", idSpecialty)
                .and().eq("idObjetivoEduacional", idObjetivoEducacional).query();
    }

    private void saveEducationalObjectives(final Context context, List<EducationalObjective> list, int idPeriod) throws SQLException {
        DatabaseHelper helper = OpenHelperManager.getHelper(context,DatabaseHelper.class);;
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
        DatabaseHelper helper = OpenHelperManager.getHelper(context,DatabaseHelper.class);;
        Dao<EducationalObjective, Integer> eosDao = helper.getEducationalObjectiveDao();
        return eosDao.queryBuilder().where().eq("idEspecialidad", idSpecialty)
                .and().eq("period_id", idPeriod).query();
    }

    private List<Criterion> retrieveCriterionsfromAspect(final Context context, int idAspect) throws SQLException{
        DatabaseHelper helper = OpenHelperManager.getHelper(context,DatabaseHelper.class);;
        Dao<Criterion, Integer> criterionDao = helper.getCriterionDao();
        return criterionDao.queryBuilder().where().eq("IdAspecto",idAspect).query();
    }

    private void saveCriterions(final Context context, List<Criterion> crits) throws SQLException {
        DatabaseHelper helper = OpenHelperManager.getHelper(context,DatabaseHelper.class);;
        Dao<Criterion,Integer> criterionDao = helper.getCriterionDao();
        for (Criterion crit : crits){
            Criterion find = criterionDao.queryForId(crit.getIdCriterio());
            if(find==null){
                criterionDao.create(crit);
            }else{
                criterionDao.update(crit);
            }
        }
    }

    private List<CriterionLevel> retrieveCritLevelsfromCriterion(final Context context, int idCriterion) throws SQLException{
        DatabaseHelper helper = OpenHelperManager.getHelper(context,DatabaseHelper.class);;
        Dao<CriterionLevel,Integer> critLevDao = helper.getCritLevDao();
        return critLevDao.queryBuilder().where().eq("IdCriterio",idCriterion).query();
    }

    private void saveCritLevs(final Context context, List<CriterionLevel> criterionLevels) throws SQLException{

        DatabaseHelper helper = OpenHelperManager.getHelper(context,DatabaseHelper.class);  //OpenHelperManager.getHelper(context,DatabaseHelper.class);;
        Dao<CriterionLevel,Integer> critLevDao = helper.getCritLevDao();
        for(CriterionLevel cl : criterionLevels){
            CriterionLevel find = critLevDao.queryForId(cl.getIdNivelCriterio());
            if(find==null){
                critLevDao.create(cl);
            }else{
                critLevDao.update(cl);
            }
        }
    }

}
