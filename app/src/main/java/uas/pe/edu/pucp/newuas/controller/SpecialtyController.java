package uas.pe.edu.pucp.newuas.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.Where;

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

import uas.pe.edu.pucp.newuas.fragment.CoursesxSpecialtyFragment;
import uas.pe.edu.pucp.newuas.fragment.CoursexScheduleFragment;
import uas.pe.edu.pucp.newuas.fragment.SpecialtyFragment;
import uas.pe.edu.pucp.newuas.model.CourseResponse;
import uas.pe.edu.pucp.newuas.model.Schedule;
import uas.pe.edu.pucp.newuas.model.Specialty;
import uas.pe.edu.pucp.newuas.model.Teacher;
import uas.pe.edu.pucp.newuas.model.User;
import uas.pe.edu.pucp.newuas.model.UserResponse;
import uas.pe.edu.pucp.newuas.view.NavigationDrawerAcreditacion;

/**
 * Created by Marshall on 20/10/2016.
 */

public class SpecialtyController {

    Specialty list = null;

    public Specialty getSpecialties(final Context context, final Integer specId) {

        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);

        Map<String, String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());
        Specialty specialty;

        /*
        if (Configuration.LOGIN_USER.getUser().getIdPerfil() == 3)
            return Configuration.SPECIALTY;
            */
        /*
        Call<Specialty> call = null;
        if (Configuration.LOGIN_USER.getUser().getAccreditor() != null){
            call = restCon.getSpecialtyById(Configuration.LOGIN_USER.getUser().getAccreditor().getIdEspecialidad(), token);
        }
        if (Configuration.LOGIN_USER.getUser().getTeacher() != null){
            call = restCon.getSpecialtyById(Configuration.LOGIN_USER.getUser().getAccreditor().getIdEspecialidad(), token);
        }*/

        Call<Specialty> call = restCon.getSpecialtyById(specId, token);


        call.enqueue(new Callback<Specialty>() {
            @Override
            public void onResponse(Call<Specialty> call, retrofit2.Response<Specialty> response) {
                Log.d("LOG", response.isSuccessful() + "");

                if (response.isSuccessful()) {
                    okhttp3.Response raw = response.raw();
                    //SpecialtyResponse
                    Specialty example = response.body();
                    Log.d("LOG", String.valueOf(response.code()));
                    Log.d("LOG", response.body().toString());
                    Log.d("LOG", response.message());

                    Log.d("llego", "llego");
                    Gson gson = new Gson();
                    Log.d("wat ", gson.toJson(example));
                    Log.d("llego", "llego");
                    UserResponse userr = Configuration.LOGIN_USER;
                    User user = userr.getUser();

                    Configuration.SPECIALTY = example;
                    SpecialtyFragment spFragment = new SpecialtyFragment();
                    //DatabaseHandler dbHandler = new DatabaseHandler(context, Configuration.DATABASE_NAME, null, Configuration.DATABASE_VERSION);
                    //dbHandler.addSpecialty(example);


                    Gson gsonf = new Gson();
                    String spj = gsonf.toJson(example);
                    System.out.println(spj);
                    Bundle bundle = new Bundle();
                    bundle.putString("Specialty", spj);
                    spFragment.setArguments(bundle);

                    try {
                        saveSpecialty(example, context);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }


                    ((Activity) context).getFragmentManager()
                            .beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.fragment_container, spFragment)
                            .commit();
                    ((Activity) context).setTitle("Especialidad");


                } else {
                    Log.d("wat", response.errorBody().toString());

                    Toast.makeText(context, response.message(), Toast.LENGTH_SHORT);
                    Toast.makeText(context, "fuepe", Toast.LENGTH_SHORT).show();

                }


            }

            @Override
            public void onFailure(Call<Specialty> call, Throwable t) {
                //Log.d("wat", t.getMessage());
                //Log.d("wat", t.getMessage());

                t.printStackTrace();

                try {
                    Specialty spec = getSpecialty(specId, context);


                    SpecialtyFragment spFragment = new SpecialtyFragment();


                    Gson gsonf = new Gson();
                    String spj = gsonf.toJson(spec);
                    System.out.println(spj);
                    Bundle bundle = new Bundle();
                    bundle.putString("Specialty", spj);
                    spFragment.setArguments(bundle);

                    ((Activity) context).getFragmentManager()
                            .beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.fragment_container, spFragment)
                            .commit();
                    ((Activity) context).setTitle("Especialidad");

                } catch (SQLException e) {
                    e.printStackTrace();
                }




                /*
                DatabaseHandler dbHandler = new DatabaseHandler(context, Configuration.DATABASE_NAME, null, Configuration.DATABASE_VERSION);

                Specialty sp = null;
                if (Configuration.LOGIN_USER.getUser().getIdPerfil() == 3)
                    sp = dbHandler.getSpecialtyById(Configuration.SPECIALTY.getIdEspecialidad());
                else {
                    sp = dbHandler.getSpecialtyById(Configuration.LOGIN_USER.getUser().getAccreditor().getIdEspecialidad());

                }

                SpecialtyFragment spFragment = new SpecialtyFragment();
                Gson gsonf = new Gson();
                String spj = gsonf.toJson(sp);
                System.out.println(spj);
                Bundle bundle = new Bundle();
                bundle.putString("Specialty", spj);
                spFragment.setArguments(bundle);

                ((Activity) context).getFragmentManager()
                        .beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.fragment_container, spFragment)
                        .commit();
                ((Activity) context).setTitle("Especialidad");
                //Call<Specialty> call = restCon.getSpecialtyById(Configuration.LOGIN_USER.getUser().getAccreditor().getIdEspecialidad(), token);


                //Toast.makeText(context, call.request().url().toString(), Toast.LENGTH_SHORT);
                Toast.makeText(context, "Error2aa", Toast.LENGTH_SHORT).show();
                */


            }
        });


//        Specialty list = null;
//        try {
//            list = call.execute().body();
//        } catch (IOException e) {
//            e.printStackTrace();
//
//
// }
        /*
        Configuration.SPECIALTY = list;

        if (Configuration.SPECIALTY == null) {
            Log.d("wat", "Es nulo");
        } else {
            Log.d("wat", "WAT");
        }
        */
        return list;

    }

    public boolean getCoursesxSpecialyxCycle(final Context context, final int idEspecialiad, final int idCycle) {
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);
        Map<String, String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());
        //Call<List<CourseResponse>> call = restCon.getCoursesxSpecialty(idEspecialiad, token);
        Call<List<CourseResponse>> call = restCon.getCoursesxSpecialty(idEspecialiad, idCycle, token);
        call.enqueue(new Callback<List<CourseResponse>>() {
            @Override
            public void onResponse(Call<List<CourseResponse>> call, Response<List<CourseResponse>> response) {
                if (response.isSuccessful()) {
                    List<CourseResponse> courseResponse = response.body();
                    //-guardar los cursos
                    try {
                        saveCourses(context, courseResponse, idCycle);
                    } catch (SQLException e) {
                        Toast.makeText(context, "Error al guardar los datos", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
                    //
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("CourseList", (Serializable) courseResponse);
                    bundle.putInt("cicloAcademico", idCycle);
                    //Fragmnet
                    CoursesxSpecialtyFragment cfFragment = new CoursesxSpecialtyFragment();
                    cfFragment.setArguments(bundle);
                    ((Activity) context).getFragmentManager()
                            .beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.fragment_container, cfFragment)
                            .commit();
                }
            }

            @Override
            public void onFailure(Call<List<CourseResponse>> call, Throwable t) {
                //leo los cursos
                try {
                    List<CourseResponse> list = retrieveCourses(context, idCycle, idEspecialiad);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("CourseList", (Serializable) list);
                    bundle.putInt("cicloAcademico", idCycle);
                    //Fragmnet
                    CoursesxSpecialtyFragment cfFragment = new CoursesxSpecialtyFragment();
                    cfFragment.setArguments(bundle);
                    ((Activity) context).getFragmentManager()
                            .beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.fragment_container, cfFragment)
                            .commit();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        return true;
    }

    public boolean getCourseSchedules(final Context context, final int idCourse, final int idAcademicCycle) {
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);
        Map<String, String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());
        Call<List<Schedule>> call = restCon.getCourseSchedules(idCourse, idAcademicCycle, token);
        call.enqueue(new Callback<List<Schedule>>() {
            @Override
            public void onResponse(Call<List<Schedule>> call, Response<List<Schedule>> response) {
                if (response.isSuccessful()) {
                    List<Schedule> list = response.body();
                    //--guaradmos los horarios
                    try {
                        saveCourseSchedule(context, list, idCourse, idAcademicCycle);
                    } catch (SQLException e) {
                        Toast.makeText(context, "Error al guardar los datos", Toast.LENGTH_SHORT).show();
                    }
                    //
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("ScheduleList", (Serializable) list);
                    //Fragment
                    CoursexScheduleFragment csFragment = new CoursexScheduleFragment();
                    csFragment.setArguments(bundle);
                    ((Activity) context).getFragmentManager()
                            .beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.fragment_container, csFragment)
                            .commit();
                } else {
                    Toast.makeText(context, "Intente nuevamente", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<Schedule>> call, Throwable t) {
                try {
                    retrieveCourseSchedules(context, idCourse, idAcademicCycle);
                } catch (SQLException e) {
                    Toast.makeText(context, "No se pudo recuperar los datos", Toast.LENGTH_LONG).show();
                }
            }
        });

        return true;
    }

    public boolean getAllSpecialties(final Context context) {
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);
        Map<String, String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());
        Call<List<Specialty>> call = restCon.getAllSpecialties(token);
        call.enqueue(new Callback<List<Specialty>>() {
            @Override
            public void onResponse(Call<List<Specialty>> call, Response<List<Specialty>> response) {
                if (response.isSuccessful()) {
                    List<Specialty> list = response.body();
                    //--guardas todas las especialidades
                    try {
                        saveSpecialties(list, context);
                    } catch (SQLException e) {
                        Toast.makeText(context, "Error al guardar los datos", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
                    //
                    Intent intent = new Intent(context, NavigationDrawerAcreditacion.class);
                    intent.putExtra("specialtyList", (Serializable) list);
                    context.startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<List<Specialty>> call, Throwable t) {
                //Hay un error de conexion, deberia sacar las especialidades de la bd
                try {
                    List<Specialty> specialtyList = retriveSpecialties(context);
                    Intent intent = new Intent(context, NavigationDrawerAcreditacion.class);
                    intent.putExtra("specialtyList", (Serializable) specialtyList);
                    context.startActivity(intent);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        return true;
    }

    private void saveCourseSchedule(final Context context, List<Schedule> scheduleList, int idCourse, int idAcademicCycle) throws SQLException {
        DatabaseHelper helper = new DatabaseHelper(context);
        Dao<Schedule, Integer> scheduleDao = helper.getScheduleDao();
        Dao<Teacher, Integer> teacherDao = helper.getTeacherDao();
        for (Schedule schedule : scheduleList) {
            schedule.setIdCiclo(idAcademicCycle);
            Schedule find = scheduleDao.queryForId(schedule.getIdHorario());
            if (find == null) {
                scheduleDao.create(schedule);
            } else {
                scheduleDao.updateId(schedule, find.getIdHorario());
            }
            //guardamos sus profesores
            List<Teacher> teachers = schedule.getProfessors();
            if (teachers != null) {
                for (Teacher teacher : teachers) {
                    teacher.setIdSchedule(schedule.getIdHorario());
                    Teacher findT = teacherDao.queryForId(teacher.getIdDocente());
                    if (findT == null) {
                        teacherDao.create(teacher);
                    } else {
                        teacherDao.updateId(teacher, findT.getIdDocente());
                    }
                }
            }
        }
    }

    private List<Schedule> retrieveCourseSchedules(final Context context, int idCourse, int idCycle) throws SQLException {
        DatabaseHelper helper = new DatabaseHelper(context);
        Dao<Schedule, Integer> scheduleDao = helper.getScheduleDao();
        Dao<Teacher, Integer> teacherDao = helper.getTeacherDao();
        List<Schedule> list = scheduleDao.queryBuilder()
                .where().eq("course_id", idCourse)
                .and().eq("idCicloAcademico", idCycle).query();
        for (Schedule schedule : list) {
            List<Teacher> teacherList = teacherDao.queryBuilder()
                    .where().eq("schedule_id", schedule.getIdHorario()).query();
            schedule.setProfessors(teacherList);
        }
        return list;
    }

    private void saveCourses(final Context context, List<CourseResponse> courseResponse, int idCycle) throws SQLException {
        DatabaseHelper helper = new DatabaseHelper(context);
        Dao<CourseResponse, Integer> courseDao = helper.getCourseDao();
        for (CourseResponse crs : courseResponse) {
            crs.setIdAcademicCycle(idCycle);
            CourseResponse find = courseDao.queryForId(crs.getIdCurso());
            if (find == null) {
                courseDao.create(crs);
            } else {
                courseDao.updateId(crs, find.getIdCurso());
            }
        }
    }

    private List<CourseResponse> retrieveCourses(final Context context, int idCycle, int idSpecialty) throws SQLException {
        DatabaseHelper helper = new DatabaseHelper(context);
        Dao<CourseResponse, Integer> courseDao = helper.getCourseDao();
        return courseDao.queryBuilder()
                .where().eq("idEspecialidad", idSpecialty)
                .and().eq("idAcademicCycle", idCycle).query();
    }

    private void saveSpecialties(List<Specialty> specialtyList, final Context context) throws SQLException {
        DatabaseHelper helper = new DatabaseHelper(context);
        Dao<Specialty, Integer> specialtyDao = helper.getSpecialtyDao();
        for (Specialty specialty : specialtyList) {
            //veo si la especialidad existe
            Specialty find = specialtyDao.queryForId(specialty.getIdEspecialidad());
            if (find == null) {
                specialtyDao.create(specialty);
            } else {
                //si se encontro la actualizo
                specialtyDao.updateId(specialty, find.getIdEspecialidad());
            }
        }
    }

    private List<Specialty> retriveSpecialties(final Context context) throws SQLException {
        DatabaseHelper helper = new DatabaseHelper(context);
        Dao<Specialty, Integer> specialtyDao = helper.getSpecialtyDao();
        return specialtyDao.queryForAll();
    }

    private void saveSpecialty(Specialty specialty, final Context context) throws SQLException {
        DatabaseHelper helper = new DatabaseHelper(context);
        Dao<Specialty, Integer> specialtyDao = helper.getSpecialtyDao();
        Specialty find = specialtyDao.queryForId(specialty.getIdEspecialidad());
        if (find == null) {
            specialtyDao.create(specialty);
        } else {
            specialtyDao.updateId(specialty, find.getIdEspecialidad());
        }

    }

    private Specialty getSpecialty(Integer id, final Context context) throws SQLException {
        DatabaseHelper helper = new DatabaseHelper(context);
        Dao<Specialty, Integer> specialtyDao = helper.getSpecialtyDao();
        return specialtyDao.queryForId(id);
    }

}
