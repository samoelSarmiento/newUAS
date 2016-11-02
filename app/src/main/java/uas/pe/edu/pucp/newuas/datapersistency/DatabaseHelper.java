package uas.pe.edu.pucp.newuas.datapersistency;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TabLayout;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.model.ConfSpeciality;
import uas.pe.edu.pucp.newuas.model.CourseResponse;
import uas.pe.edu.pucp.newuas.model.EducationalObjective;
import uas.pe.edu.pucp.newuas.model.Period;
import uas.pe.edu.pucp.newuas.model.Schedule;
import uas.pe.edu.pucp.newuas.model.Semester;
import uas.pe.edu.pucp.newuas.model.Specialty;
import uas.pe.edu.pucp.newuas.model.Teacher;
import uas.pe.edu.pucp.newuas.model.User;
import uas.pe.edu.pucp.newuas.model.UserResponse;

/**
 * Created by samoe on 27/10/2016.
 */

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
    private static final String DATABASE_NAME = "uas.db";
    private static final int DATABASE_VERSION = 1;
    private Dao<Specialty, Integer> specialtyDao = null;
    private Dao<Teacher, Integer> teacherDao = null;
    private Dao<Period, Integer> periodDao = null;
    private Dao<Semester, Integer> semesterDao = null;
    private Dao<CourseResponse, Integer> courseDao = null;
    private Dao<Schedule, Integer> scheduleDao = null;
    private Dao<EducationalObjective, Integer> educationalObjectiveDao = null;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION, R.raw.ormlite_config);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTableIfNotExists(connectionSource, EducationalObjective.class);
            TableUtils.createTableIfNotExists(connectionSource, CourseResponse.class);
            TableUtils.createTableIfNotExists(connectionSource, Schedule.class);
            TableUtils.createTableIfNotExists(connectionSource, Specialty.class);
            TableUtils.createTableIfNotExists(connectionSource, Teacher.class);
            TableUtils.createTableIfNotExists(connectionSource, Period.class);
            TableUtils.createTableIfNotExists(connectionSource, Semester.class);
            TableUtils.createTableIfNotExists(connectionSource, ConfSpeciality.class);
        } catch (SQLException e) {
            Log.e("DBEror", "Error de base de datos");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource source, int oldVersion, int newVersion) {
        try {
            //Se borran todas las tablas
            TableUtils.dropTable(source, EducationalObjective.class, true);
            TableUtils.dropTable(source, CourseResponse.class, true);
            TableUtils.dropTable(source, Schedule.class, true);
            TableUtils.dropTable(source, Teacher.class, true);
            TableUtils.dropTable(source, Period.class, true);
            TableUtils.dropTable(source, Semester.class, true);
            TableUtils.dropTable(source, ConfSpeciality.class, true);
            TableUtils.dropTable(source, Specialty.class, true);
            //Se crean denuevo
            onCreate(db, source);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Dao<EducationalObjective, Integer> getEducationalObjectiveDao() throws SQLException {
        if (educationalObjectiveDao == null)
            educationalObjectiveDao = getDao(EducationalObjective.class);
        return educationalObjectiveDao;
    }

    public void setEducationalObjectiveDao(Dao<EducationalObjective, Integer> educationalObjectiveDao) {
        this.educationalObjectiveDao = educationalObjectiveDao;
    }

    public Dao<Schedule, Integer> getScheduleDao() throws SQLException {
        if (scheduleDao == null) scheduleDao = getDao(Schedule.class);
        return scheduleDao;
    }

    public void setScheduleDao(Dao<Schedule, Integer> scheduleDao) {
        this.scheduleDao = scheduleDao;
    }

    public Dao<CourseResponse, Integer> getCourseDao() throws SQLException {
        if (courseDao == null) courseDao = getDao(CourseResponse.class);
        return courseDao;
    }

    public void setCourseDao(Dao<CourseResponse, Integer> courseDao) {
        this.courseDao = courseDao;
    }

    public Dao<Specialty, Integer> getSpecialtyDao() throws SQLException {
        if (specialtyDao == null) specialtyDao = getDao(Specialty.class);
        return specialtyDao;
    }

    public void setSpecialtyDao(Dao<Specialty, Integer> specialtyDao) {
        this.specialtyDao = specialtyDao;
    }

    public Dao<Teacher, Integer> getTeacherDao() throws SQLException {
        if (teacherDao == null) teacherDao = getDao(Teacher.class);
        return teacherDao;
    }


    public void setTeacherDao(Dao<Teacher, Integer> teacherDao) {
        this.teacherDao = teacherDao;
    }


    public Dao<Period, Integer> getPeriodDao() throws SQLException {
        if (periodDao == null) periodDao = getDao(Period.class);
        return periodDao;
    }

    public void setPeriodDao(Dao<Period, Integer> periodDao) {
        this.periodDao = periodDao;
    }

    public Dao<Semester, Integer> getSemesterDao() throws SQLException {
        if (semesterDao == null) semesterDao = getDao(Semester.class);
        return semesterDao;
    }

    public void setSemesterDao(Dao<Semester, Integer> semesterDao) {
        this.semesterDao = semesterDao;
    }

    @Override
    public void close() {
        super.close();
        specialtyDao = null;
        teacherDao = null;
    }
}
