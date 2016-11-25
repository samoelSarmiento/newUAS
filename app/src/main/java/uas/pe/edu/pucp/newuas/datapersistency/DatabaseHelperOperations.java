package uas.pe.edu.pucp.newuas.datapersistency;

import android.content.Context;
import android.util.Log;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

import uas.pe.edu.pucp.newuas.model.ConfSpeciality;
import uas.pe.edu.pucp.newuas.model.CourseResponse;
import uas.pe.edu.pucp.newuas.model.MeasureInstrument;
import uas.pe.edu.pucp.newuas.model.Period;
import uas.pe.edu.pucp.newuas.model.Schedule;
import uas.pe.edu.pucp.newuas.model.Semester;
import uas.pe.edu.pucp.newuas.model.Specialty;
import uas.pe.edu.pucp.newuas.model.Teacher;

/**
 * Created by samoe on 12/11/2016.
 */

public class DatabaseHelperOperations {
    /*PERIODS*/
    public static List<Period> retrievePeriods(final Context context, Integer idSpec) throws SQLException {
        DatabaseHelper helper = OpenHelperManager.getHelper(context, DatabaseHelper.class);
        Dao<Period, Integer> periodDao = helper.getPeriodDao();
        List<Period> result = periodDao.queryBuilder().where().eq("idEspecialidad", idSpec).query();
        /*Dao<ConfSpeciality, Integer> confDao = helper.getConfSpecialtyDao();
        Log.d("ESTOY AQUI??", "SIII");
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

    public static void saveSemesters(final Context context, List<Semester> semesters, Integer periodId) throws SQLException {
        DatabaseHelper helper = OpenHelperManager.getHelper(context, DatabaseHelper.class);
        Dao<Semester, Integer> semesterDao = helper.getSemesterDao();
        for (Semester semester : semesters) {
            semester.setIdPeriodo(periodId);
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

    /*MEASUREMENT INSTRUMENTS*/
    public static List<MeasureInstrument> retrieveMeaInstofPeriod(final Context context, Integer idPeriod) throws SQLException {
        DatabaseHelper helper = OpenHelperManager.getHelper(context, DatabaseHelper.class);
        Dao<MeasureInstrument, Integer> measureinstrumentDao = helper.getMeasureInstrumentDao();
        return measureinstrumentDao.queryBuilder().where().eq("idPeriodo", idPeriod).query();
    }


    public static void saveMeaInsts(final Context context, List<MeasureInstrument> mis, Integer idPeriod) throws SQLException {
        DatabaseHelper helper = OpenHelperManager.getHelper(context, DatabaseHelper.class);
        Dao<MeasureInstrument, Integer> measureinstrumentDao = helper.getMeasureInstrumentDao();
        for (MeasureInstrument mi : mis) {
            mi.setIdPeriodo(idPeriod);
            MeasureInstrument find = measureinstrumentDao.queryForId(mi.getIdFuenteMedicion());
            if (find == null) {
                measureinstrumentDao.create(mi);
            } else {
                measureinstrumentDao.update(mi);
            }
        }
    }

    /*COURSES*/
    public static void saveCourseSchedule(final Context context, List<Schedule> scheduleList, int idCourse, int idAcademicCycle) throws SQLException {
        DatabaseHelper helper = OpenHelperManager.getHelper(context, DatabaseHelper.class);
        Dao<Schedule, Integer> scheduleDao = helper.getScheduleDao();
        Dao<Teacher, Integer> teacherDao = helper.getTeacherDao();
        for (Schedule schedule : scheduleList) {
            schedule.setIdCiclo(idAcademicCycle);
            schedule.setIdCurso(idCourse);
            Schedule find = scheduleDao.queryForId(schedule.getIdHorario());
            if (find == null) {
                scheduleDao.create(schedule);
            } else {
                scheduleDao.update(schedule);
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
                        teacherDao.update(teacher);
                    }
                }
            }
        }
    }

    public static List<Schedule> retrieveCourseSchedules(final Context context, int idCourse, int idCycle) throws SQLException {
        DatabaseHelper helper = OpenHelperManager.getHelper(context, DatabaseHelper.class);
        Dao<Schedule, Integer> scheduleDao = helper.getScheduleDao();
        Dao<Teacher, Integer> teacherDao = helper.getTeacherDao();
        List<Schedule> list = scheduleDao.queryBuilder()
                .where().eq("course_id", idCourse)
                .and().eq("idCicloAcademico", idCycle).query();
        for (Schedule schedule : list) {
            Log.d("COSI", schedule.getIdHorario() + "");
            List<Teacher> teacherList = teacherDao.queryBuilder()
                    .where().eq("schedule_id", schedule.getIdHorario()).query();
            schedule.setProfessors(teacherList);
        }
        return list;
    }

    public static void saveCourses(final Context context, List<CourseResponse> courseResponse, int idCycle) throws SQLException {
        DatabaseHelper helper = OpenHelperManager.getHelper(context, DatabaseHelper.class);
        Dao<CourseResponse, Integer> courseDao = helper.getCourseDao();
        for (CourseResponse crs : courseResponse) {
            crs.setIdAcademicCycle(idCycle);
            CourseResponse find = courseDao.queryForId(crs.getIdCurso());
            if (find == null) {
                courseDao.create(crs);
            } else {
                courseDao.update(crs);
            }
        }
    }

    public static List<CourseResponse> retrieveCourses(final Context context, int idCycle, int idSpecialty) throws SQLException {
        DatabaseHelper helper = OpenHelperManager.getHelper(context, DatabaseHelper.class);
        Dao<CourseResponse, Integer> courseDao = helper.getCourseDao();
        return courseDao.queryBuilder()
                .where().eq("idEspecialidad", idSpecialty)
                .and().eq("idAcademicCycle", idCycle).query();
    }

    /*SPECIALTY*/
    public static void saveSpecialties(List<Specialty> specialtyList, final Context context) throws SQLException {
        DatabaseHelper helper = OpenHelperManager.getHelper(context, DatabaseHelper.class);
        Dao<Specialty, Integer> specialtyDao = helper.getSpecialtyDao();
        for (Specialty specialty : specialtyList) {
            //veo si la especialidad existe
            Specialty find = specialtyDao.queryForId(specialty.getIdEspecialidad());
            if (find == null) {
                specialtyDao.create(specialty);
            } else {
                //si se encontro la actualizo
                specialtyDao.update(specialty);
            }
        }
    }

    public static List<Specialty> retriveSpecialties(final Context context) throws SQLException {
        DatabaseHelper helper = OpenHelperManager.getHelper(context, DatabaseHelper.class);
        Dao<Specialty, Integer> specialtyDao = helper.getSpecialtyDao();
        return specialtyDao.queryForAll();
    }

    public static void saveSpecialty(Specialty specialty, final Context context) throws SQLException {
        DatabaseHelper helper = OpenHelperManager.getHelper(context, DatabaseHelper.class);
        Dao<Specialty, Integer> specialtyDao = helper.getSpecialtyDao();
        Specialty find = specialtyDao.queryForId(specialty.getIdEspecialidad());
        if (find == null) {
            specialtyDao.create(specialty);
        } else {
            specialtyDao.update(specialty);
        }

    }

    public static Specialty getSpecialty(Integer id, final Context context) throws SQLException {
        DatabaseHelper helper = OpenHelperManager.getHelper(context, DatabaseHelper.class);
        Dao<Specialty, Integer> specialtyDao = helper.getSpecialtyDao();
        return specialtyDao.queryForId(id);
    }

}
