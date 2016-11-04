package uas.pe.edu.pucp.newuas.datapersistency;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.model.Area;
import uas.pe.edu.pucp.newuas.model.Aspect;
import uas.pe.edu.pucp.newuas.model.ConfSpeciality;
import uas.pe.edu.pucp.newuas.model.CourseResponse;
import uas.pe.edu.pucp.newuas.model.EducationalObjective;
import uas.pe.edu.pucp.newuas.model.InvEvent;
import uas.pe.edu.pucp.newuas.model.InvGroups;
import uas.pe.edu.pucp.newuas.model.Investigator;
import uas.pe.edu.pucp.newuas.model.MeasureInstrument;
import uas.pe.edu.pucp.newuas.model.Period;
import uas.pe.edu.pucp.newuas.model.ProjectStatus;
import uas.pe.edu.pucp.newuas.model.Projects;
import uas.pe.edu.pucp.newuas.model.Schedule;
import uas.pe.edu.pucp.newuas.model.Semester;
import uas.pe.edu.pucp.newuas.model.Specialty;
import uas.pe.edu.pucp.newuas.model.StudentResult;
import uas.pe.edu.pucp.newuas.model.Teacher;

/**
 * Created by samoe on 27/10/2016.
 */

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
    private static final String DATABASE_NAME = "uas100.db";
    private static final int DATABASE_VERSION = 1;
    private Dao<Specialty, Integer> specialtyDao = null;
    private Dao<Teacher, Integer> teacherDao = null;
    private Dao<Period, Integer> periodDao = null;
    private Dao<Semester, Integer> semesterDao = null;
    private Dao<CourseResponse, Integer> courseDao = null;
    private Dao<Schedule, Integer> scheduleDao = null;
    private Dao<EducationalObjective, Integer> educationalObjectiveDao = null;
    private Dao<StudentResult, Integer> studentResultDao = null;
    private Dao<Investigator, Integer> investigatorDao = null;
    private Dao<InvGroups, Integer> invGroupDao = null;
    private Dao<Projects, Integer> projDao = null;
    private Dao<Area, Integer> areaDao;
    private Dao<ProjectStatus, Integer> projStatDao = null;
    private Dao<MeasureInstrument, Integer> measureinstrumentDao = null;
    private Dao<Aspect, Integer> aspectDao = null;
    private Dao<InvEvent,Integer> invEventDao = null;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION, R.raw.ormlite_config);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTableIfNotExists(connectionSource, Aspect.class);
            TableUtils.createTableIfNotExists(connectionSource, Area.class);
            TableUtils.createTableIfNotExists(connectionSource, StudentResult.class);
            TableUtils.createTableIfNotExists(connectionSource, EducationalObjective.class);
            TableUtils.createTableIfNotExists(connectionSource, CourseResponse.class);
            TableUtils.createTableIfNotExists(connectionSource, Schedule.class);
            TableUtils.createTableIfNotExists(connectionSource, Specialty.class);
            TableUtils.createTableIfNotExists(connectionSource, Teacher.class);
            TableUtils.createTableIfNotExists(connectionSource, Period.class);
            TableUtils.createTableIfNotExists(connectionSource, Semester.class);
            TableUtils.createTableIfNotExists(connectionSource, ConfSpeciality.class);
            TableUtils.createTableIfNotExists(connectionSource, Investigator.class);
            TableUtils.createTableIfNotExists(connectionSource, InvGroups.class);
            TableUtils.createTableIfNotExists(connectionSource, Projects.class);
            TableUtils.createTableIfNotExists(connectionSource, ProjectStatus.class);
            TableUtils.createTableIfNotExists(connectionSource, MeasureInstrument.class);
            TableUtils.createTableIfNotExists(connectionSource, InvEvent.class);
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
            TableUtils.dropTable(source, Aspect.class, true);
            TableUtils.dropTable(source, Area.class, true);
            TableUtils.dropTable(source, StudentResult.class, true);
            TableUtils.dropTable(source, EducationalObjective.class, true);
            TableUtils.dropTable(source, CourseResponse.class, true);
            TableUtils.dropTable(source, Schedule.class, true);
            TableUtils.dropTable(source, Teacher.class, true);
            TableUtils.dropTable(source, Period.class, true);
            TableUtils.dropTable(source, Semester.class, true);
            TableUtils.dropTable(source, ConfSpeciality.class, true);
            TableUtils.dropTable(source, Specialty.class, true);
            TableUtils.dropTable(source, Investigator.class, true);
            TableUtils.dropTable(source, InvGroups.class, true);
            TableUtils.dropTable(source, Projects.class, true);
            TableUtils.dropTable(source, ProjectStatus.class, true);
            TableUtils.dropTable(source, InvEvent.class, true);
            //Se crean denuevo
            onCreate(db, source);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Dao<Aspect, Integer> getAspectDao() throws SQLException {
        if (aspectDao == null) aspectDao = getDao(Aspect.class);
        return aspectDao;
    }

    public void setAspectDao(Dao<Aspect, Integer> aspectDao) {
        this.aspectDao = aspectDao;
    }

    public Dao<Area, Integer> getAreaDao() throws SQLException {
        if (areaDao == null) areaDao = getDao(Area.class);
        return areaDao;
    }

    public void setAreaDao(Dao<Area, Integer> areaDao) {
        this.areaDao = areaDao;
    }

    public Dao<StudentResult, Integer> getStudentResultDao() throws SQLException {
        if (studentResultDao == null) studentResultDao = getDao(StudentResult.class);
        return studentResultDao;
    }

    public void setStudentResultDao(Dao<StudentResult, Integer> studentResultDao) {
        this.studentResultDao = studentResultDao;
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

    public Dao<Investigator, Integer> getInvestigatorDao() throws SQLException {
        if (investigatorDao == null) investigatorDao = getDao(Investigator.class);
        return investigatorDao;
    }

    public void setInvestigatorDao(Dao<Investigator, Integer> investigatorDao) {
        this.investigatorDao = investigatorDao;
    }

    public Dao<InvGroups, Integer> getInvGroupDao() throws SQLException {
        if (invGroupDao == null) invGroupDao = getDao(InvGroups.class);
        return invGroupDao;
    }

    public void setInvGroupDao(Dao<InvGroups, Integer> invGroupDao) {
        this.invGroupDao = invGroupDao;
    }

    public Dao<Projects, Integer> getProjDao() throws SQLException {
        if (projDao == null) projDao = getDao(Projects.class);
        return projDao;
    }

    public void setProjDao(Dao<Projects, Integer> projDao) {
        this.projDao = projDao;
    }

    public Dao<ProjectStatus, Integer> getProjStatDao() throws SQLException {
        if (projStatDao == null) projStatDao = getDao(ProjectStatus.class);
        return projStatDao;
    }

    public void setProjStatDao(Dao<ProjectStatus, Integer> projStatDao) {
        this.projStatDao = projStatDao;
    }


    public Dao<MeasureInstrument, Integer> getMeasureInstrumentDao() throws SQLException {
        if (measureinstrumentDao == null) measureinstrumentDao = getDao(MeasureInstrument.class);
        return measureinstrumentDao;
    }

    public void setMeasureInstrumentDao(Dao<MeasureInstrument, Integer> measureinstrumentDao) {
        this.measureinstrumentDao = measureinstrumentDao;
    }

    public Dao<InvEvent, Integer> getInvEventDao() throws SQLException{
        if (invEventDao == null) invEventDao = getDao(InvEvent.class);
        return invEventDao;
    }

    public void setInvEventDao(Dao<InvEvent, Integer> invEventDao) {
        this.invEventDao = invEventDao;
    }

    @Override
    public void close() {
        super.close();
        specialtyDao = null;
        teacherDao = null;
    }
}
