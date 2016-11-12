package uas.pe.edu.pucp.newuas.datapersistency;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

import uas.pe.edu.pucp.newuas.model.ConfSpeciality;
import uas.pe.edu.pucp.newuas.model.Period;
import uas.pe.edu.pucp.newuas.model.Semester;

/**
 * Created by samoe on 12/11/2016.
 */

public class DatabaseHelperOperations {
    /*PERIODS*/
    public static List<Period> retrievePeriods(final Context context, Integer idSpec) throws SQLException {
        DatabaseHelper helper = OpenHelperManager.getHelper(context, DatabaseHelper.class);
        Dao<Period, Integer> periodDao = helper.getPeriodDao();
        List<Period> result = periodDao.queryBuilder().where().eq("idEspecialidad", idSpec).query();
        //Dao<ConfSpeciality, Integer> confDao = helper.getConfSpecialtyDao();
        /*Log.d("ESTOY AQUI??", "SIII");
        for (Period period : result) {
            Log.d("CONF DAOS??? NULL", "" + (period.getConfiguration() == null));
            confDao.refresh(period.getConfiguration());
        }*/
        return result;
    }

    public static void savePeriods(final Context context, List<Period> periodList) throws SQLException {
        DatabaseHelper helper = OpenHelperManager.getHelper(context, DatabaseHelper.class);
        Dao<Period, Integer> periodDao = helper.getPeriodDao();
        Dao<ConfSpeciality, Integer> confDao = helper.getConfSpecialtyDao();
        for (Period period : periodList) {
            //veo si la especialidad existe
            Period find = periodDao.queryForId(period.getIdPeriodo());
            if (find == null) {
                //si no existe, creo su confspecialty
                period.getConfiguration().setIdPeriodo(period.getIdPeriodo());
                //saveConfSpecialty(context, period.getConfiguration());
                periodDao.create(period);
            } else {
                //si se encontro la actualizo(?, no se si actualiza todo)
                //si no existe, creo su confspecialty
                period.getConfiguration().setIdPeriodo(period.getIdPeriodo());
                //confDao.update(period.getConfiguration());
                periodDao.update(period);
            }
        }
    }

    public static Period getPeriod(Integer id, final Context context) throws SQLException {
        DatabaseHelper helper = OpenHelperManager.getHelper(context, DatabaseHelper.class);
        Dao<Period, Integer> periodDao = helper.getPeriodDao();
        return periodDao.queryForId(id);
    }

    public static void savePeriod(Period period, final Context context) throws SQLException {
        DatabaseHelper helper = OpenHelperManager.getHelper(context, DatabaseHelper.class);
        Dao<Period, Integer> periodDao = helper.getPeriodDao();
        Period find = periodDao.queryForId(period.getIdPeriodo());
        if (find == null) {
            periodDao.create(period);
        } else {
            periodDao.update(period);
        }
    }

    /*SEMESTERS*/
    public static List<Semester> getSemestersListofPeriod(final Context context, Integer periodId) throws SQLException {
        DatabaseHelper helper = OpenHelperManager.getHelper(context, DatabaseHelper.class);
        Dao<Semester, Integer> semesterDao = helper.getSemesterDao();
        return semesterDao.queryForEq("idPeriodo", periodId);
    }

    public static void saveSemesters(final Context context, List<Semester> semesters) throws SQLException {
        DatabaseHelper helper = OpenHelperManager.getHelper(context, DatabaseHelper.class);
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

    public static Semester getSemesterById(final Context context, Integer idSem) throws SQLException {
        DatabaseHelper helper = OpenHelperManager.getHelper(context, DatabaseHelper.class);
        Dao<Semester, Integer> semesterDao = helper.getSemesterDao();
        return semesterDao.queryForId(idSem);
    }

    public static void saveSemester(final Context context, Semester semester) throws SQLException {
        DatabaseHelper helper = OpenHelperManager.getHelper(context, DatabaseHelper.class);
        Dao<Semester, Integer> semesterDao = helper.getSemesterDao();
        Semester find = semesterDao.queryForId(semester.getIdEspecialidad());
        if (find == null) {
            semesterDao.create(semester);
        } else {
            semesterDao.update(semester);
        }
    }

    /*CONFSPECIALTY*/
    public static ConfSpeciality getConfSpecialty(final Context context, Integer idSem) throws SQLException {
        DatabaseHelper helper = OpenHelperManager.getHelper(context, DatabaseHelper.class);
        Dao<ConfSpeciality, Integer> confDao = helper.getConfSpecialtyDao();
        return confDao.queryForId(idSem);
    }

    public static void saveConfSpecialty(final Context context, ConfSpeciality confSpeciality) throws SQLException {
        DatabaseHelper helper = OpenHelperManager.getHelper(context, DatabaseHelper.class);
        Dao<ConfSpeciality, Integer> confDao = helper.getConfSpecialtyDao();
        ConfSpeciality find = confDao.queryForId(confSpeciality.getIdConfEspecialidad());
        //datos de conf
        //---idConfSpecialidad
        confSpeciality.getCycleAcademicStart().setIdConfEspecialidad(confSpeciality.getIdConfEspecialidad());
        confSpeciality.getCycleAcademicEnd().setIdConfEspecialidad(confSpeciality.getIdConfEspecialidad());
        //--idEspecialidad
        confSpeciality.getCycleAcademicStart().setIdEspecialidad(confSpeciality.getIdEspecialidad());
        confSpeciality.getCycleAcademicEnd().setIdEspecialidad(confSpeciality.getIdEspecialidad());
        //
        //saveSemester(context, confSpeciality.getCycleAcademicStart());
        //saveSemester(context, confSpeciality.getCycleAcademicEnd());
        if (find == null) {
            confDao.create(confSpeciality);
        } else {
            confDao.update(confSpeciality);
        }
    }

}
