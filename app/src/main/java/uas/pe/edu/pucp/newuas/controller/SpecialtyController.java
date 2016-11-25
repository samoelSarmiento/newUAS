package uas.pe.edu.pucp.newuas.controller;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.j256.ormlite.android.apptools.OpenHelperManager;
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
import uas.pe.edu.pucp.newuas.datapersistency.DatabaseHelperOperations;
import uas.pe.edu.pucp.newuas.datapersistency.RestCon;
import uas.pe.edu.pucp.newuas.datapersistency.RetrofitHelper;

import uas.pe.edu.pucp.newuas.fragment.CoursesxSpecialtyFragment;
import uas.pe.edu.pucp.newuas.fragment.CoursexScheduleFragment;
import uas.pe.edu.pucp.newuas.fragment.MyCoursesFragment;
import uas.pe.edu.pucp.newuas.fragment.SpecialtyFragment;
import uas.pe.edu.pucp.newuas.fragment.StudentEffortResultFragment;
import uas.pe.edu.pucp.newuas.fragment.StudentListFragment;
import uas.pe.edu.pucp.newuas.fragment.StudentResultListFragment;
import uas.pe.edu.pucp.newuas.model.CourseResponse;
import uas.pe.edu.pucp.newuas.model.CoursesEvidences;
import uas.pe.edu.pucp.newuas.model.FileGen;
import uas.pe.edu.pucp.newuas.model.Schedule;
import uas.pe.edu.pucp.newuas.model.Specialty;
import uas.pe.edu.pucp.newuas.model.Student;
import uas.pe.edu.pucp.newuas.model.StudentEffort;
import uas.pe.edu.pucp.newuas.model.StudentResult;
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
        Call<Specialty> call = restCon.getSpecialtyById(specId, token);

        call.enqueue(new Callback<Specialty>() {
            @Override
            public void onResponse(Call<Specialty> call, retrofit2.Response<Specialty> response) {
                if (response.isSuccessful()) {
                    Specialty example = response.body();
                    Log.d("COSI", "" + (example == null));
                    Configuration.SPECIALTY = example;
                    SpecialtyFragment spFragment = new SpecialtyFragment();

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("specialty", example);
                    spFragment.setArguments(bundle);

                    /*try {
                        DatabaseHelperOperations.saveSpecialty(example, context);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }*/
                    ((Activity) context).getFragmentManager()
                            .beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.fragment_container, spFragment)
                            .commit();
                    ((Activity) context).setTitle("Especialidad");
                } else {
                    Toast.makeText(context, response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Specialty> call, Throwable t) {
                /*t.printStackTrace();
                try {
                    Specialty spec = DatabaseHelperOperations.getSpecialty(specId, context);
                    Configuration.SPECIALTY = spec;
                    SpecialtyFragment spFragment = new SpecialtyFragment();

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("specialty", spec);
                    spFragment.setArguments(bundle);

                    ((Activity) context).getFragmentManager()
                            .beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.fragment_container, spFragment)
                            .commit();
                    ((Activity) context).setTitle("Especialidad");

                } catch (SQLException e) {
                    e.printStackTrace();
                }*/
                Toast.makeText(context, R.string.connection_error, Toast.LENGTH_LONG).show();
            }
        });
        return list;
    }

    public boolean getCoursesxSpecialyxCycle(final Context context, final int idEspecialiad, final int idCycle) {
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);
        Map<String, String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());
        //Call<List<CourseResponse>> call = restCon.getCoursesxSpecialty(idEspecialiad, token);
        Call<List<CourseResponse>> call = restCon.getCoursesxSpecialty(idEspecialiad, idCycle - 1, token);
        call.enqueue(new Callback<List<CourseResponse>>() {
            @Override
            public void onResponse(Call<List<CourseResponse>> call, Response<List<CourseResponse>> response) {
                if (response.isSuccessful()) {
                    List<CourseResponse> courseResponse = response.body();
                    final List<CourseResponse> crf = courseResponse;
                    //-guardar los cursos
                    /*new AsyncTask<Void, Long, Void>() {

                        @Override
                        protected Void doInBackground(Void... params) {
                            try {
                                DatabaseHelperOperations.saveCourses(context, crf, idCycle);
                            } catch (SQLException e) {
                                Toast.makeText(context, "Error al guardar los datos", Toast.LENGTH_SHORT).show();
                                e.printStackTrace();
                            }
                            return null;
                        }
                    }.execute();*/
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
                /*try {
                    List<CourseResponse> list = DatabaseHelperOperations.retrieveCourses(context, idCycle, idEspecialiad);
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
                }*/
                Toast.makeText(context, R.string.connection_error, Toast.LENGTH_LONG).show();
            }
        });
        return true;
    }

    public boolean getCourseSchedules(final Context context, final int idCourse, final int idAcademicCycle) {
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);
        Map<String, String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());
        Call<List<Schedule>> call = restCon.getCourseSchedules(idCourse, idAcademicCycle - 1, token);
        call.enqueue(new Callback<List<Schedule>>() {
            @Override
            public void onResponse(Call<List<Schedule>> call, Response<List<Schedule>> response) {
                if (response.isSuccessful()) {
                    List<Schedule> list = response.body();
                    //--guaradmos los horarios
                    /*try {
                        DatabaseHelperOperations.saveCourseSchedule(context, list, idCourse, idAcademicCycle);
                    } catch (SQLException e) {
                        Toast.makeText(context, "Error al guardar los datos", Toast.LENGTH_SHORT).show();
                    }*/
                    //
                    Bundle bundle = new Bundle();
                    bundle.putInt("cicloAcademico", idAcademicCycle - 1);
                    bundle.putInt("curso", idCourse);
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
                /*try {
                    List<Schedule> list = DatabaseHelperOperations.retrieveCourseSchedules(context, idCourse, idAcademicCycle);
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
                } catch (SQLException e) {
                    Toast.makeText(context, "No se pudo recuperar los datos", Toast.LENGTH_LONG).show();
                }*/
                Toast.makeText(context, R.string.connection_error, Toast.LENGTH_LONG).show();
            }
        });

        return true;
    }

    public boolean getAllSpecialties(final Context context) {
        final ProgressDialog pd = new ProgressDialog(context);
        pd.setMessage("Cargando...");
        pd.setCanceledOnTouchOutside(false);
        pd.show();

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
                    /*try {
                        DatabaseHelperOperations.saveSpecialties(list, context);
                    } catch (SQLException e) {
                        Toast.makeText(context, "Error al guardar los datos", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }*/
                    //
                    Intent intent = new Intent(context, NavigationDrawerAcreditacion.class);
                    intent.putExtra("specialtyList", (Serializable) list);
                    if (pd.isShowing()) pd.dismiss();
                    context.startActivity(intent);
                } else {
                    if (pd.isShowing()) pd.dismiss();
                }
            }

            @Override
            public void onFailure(Call<List<Specialty>> call, Throwable t) {
                //Hay un error de conexion, deberia sacar las especialidades de la bd
                /*try {
                    List<Specialty> specialtyList = DatabaseHelperOperations.retriveSpecialties(context);
                    if (pd.isShowing()) pd.dismiss();
                    Intent intent = new Intent(context, NavigationDrawerAcreditacion.class);
                    intent.putExtra("specialtyList", (Serializable) specialtyList);
                    context.startActivity(intent);
                } catch (SQLException e) {
                    e.printStackTrace();
                }*/
                Toast.makeText(context, R.string.connection_error, Toast.LENGTH_LONG).show();
            }
        });
        return true;
    }

    public boolean getTeacherCourses(final Context context, int teacher_id) {
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);
        Map<String, String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());
        Call<List<CourseResponse>> call = restCon.getTeacherCourses(teacher_id, token);

        call.enqueue(new Callback<List<CourseResponse>>() {
            @Override
            public void onResponse(Call<List<CourseResponse>> call, Response<List<CourseResponse>> response) {
                if (response.isSuccessful()) {
                    List<CourseResponse> list = response.body();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("courses", (Serializable) list);
                    MyCoursesFragment fragment = new MyCoursesFragment();
                    fragment.setArguments(bundle);
                    ((Activity) context).getFragmentManager().beginTransaction().addToBackStack(null)
                            .replace(R.id.fragment_container, fragment).commit();
                } else {
                    Toast.makeText(context, "Hubo un error", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<CourseResponse>> call, Throwable t) {
                Toast.makeText(context, "Error de conexión", Toast.LENGTH_LONG).show();
            }
        });

        return true;
    }

    public boolean getStudentsbySchedule(final Context context, final int schedule_id, final int idCicloAcademico, final int idCurso, final List<FileGen> evidences) {
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);
        Map<String, String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());
        Call<List<Student>> call = restCon.getStudentsbySchedule(schedule_id, token);
        call.enqueue(new Callback<List<Student>>() {
            @Override
            public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {
                if (response.isSuccessful()) {
                    List<Student> result = response.body();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("students", (Serializable) result);
                    bundle.putInt("cicloAcademico", idCicloAcademico - 1);
                    bundle.putInt("curso", idCurso);
                    bundle.putInt("horario", schedule_id);
                    bundle.putSerializable("evidences", (Serializable) evidences);
                    StudentListFragment fragment = new StudentListFragment();
                    fragment.setArguments(bundle);

                    ((Activity) context).getFragmentManager().beginTransaction()
                            .addToBackStack(null).replace(R.id.fragment_container, fragment)
                            .commit();
                }
            }

            @Override
            public void onFailure(Call<List<Student>> call, Throwable t) {
                Toast.makeText(context, R.string.connection_error, Toast.LENGTH_LONG).show();
            }
        });
        return true;
    }


    public void getCourseContribution(final Context context, int course_id, int semester_id) {
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);
        Map<String, String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());
        Call<List<StudentResult>> call = restCon.getCourseContribution(course_id, semester_id, token);

        call.enqueue(new Callback<List<StudentResult>>() {
            @Override
            public void onResponse(Call<List<StudentResult>> call, Response<List<StudentResult>> response) {
                if (response.isSuccessful()) {
                    List<StudentResult> list = response.body();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("studentResult", (Serializable) list);

                    StudentResultListFragment srlf = new StudentResultListFragment();
                    srlf.setArguments(bundle);

                    ((Activity) context).getFragmentManager()
                            .beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.fragment_container, srlf)
                            .commit();
                } else {
                    Log.d("wat", response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<List<StudentResult>> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(context, R.string.connection_error, Toast.LENGTH_LONG).show();
            }
        });
    }

    public void getStudentEffort(final Context context, int idCicloAcademico, int idCurso, int idHorario, int idAlumno) {
        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);
        Map<String, String> token = new HashMap<>();
        token.put("token", Configuration.LOGIN_USER.getToken());

        Call<List<StudentEffort>> call = restCon.getEffortResultsbyStudent(idCicloAcademico, idCurso, idHorario, idAlumno, token);
        call.enqueue(new Callback<List<StudentEffort>>() {
            @Override
            public void onResponse(Call<List<StudentEffort>> call, Response<List<StudentEffort>> response) {
                if (response.isSuccessful()) {
                    List<StudentEffort> list = response.body();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("effort", (Serializable) list);
                    StudentEffortResultFragment fragment = new StudentEffortResultFragment();
                    fragment.setArguments(bundle);
                    ((Activity) context).getFragmentManager().beginTransaction()
                            .addToBackStack(null).replace(R.id.fragment_container, fragment).commit();
                }
            }

            @Override
            public void onFailure(Call<List<StudentEffort>> call, Throwable t) {
                Toast.makeText(context, R.string.connection_error, Toast.LENGTH_LONG).show();
            }
        });
    }
}
