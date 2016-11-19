package uas.pe.edu.pucp.newuas.datapersistency;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.IntegerRes;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.model.Action;
import uas.pe.edu.pucp.newuas.model.ActionFile;
import uas.pe.edu.pucp.newuas.model.Area;
import uas.pe.edu.pucp.newuas.model.Aspect;
import uas.pe.edu.pucp.newuas.model.ConfSpeciality;
import uas.pe.edu.pucp.newuas.model.CourseResponse;
import uas.pe.edu.pucp.newuas.model.Criterion;
import uas.pe.edu.pucp.newuas.model.CriterionLevel;
import uas.pe.edu.pucp.newuas.model.Deliverable;
import uas.pe.edu.pucp.newuas.model.EducationalObjective;
import uas.pe.edu.pucp.newuas.model.FileGen;
import uas.pe.edu.pucp.newuas.model.ImprovementPlan;
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
    private static final String DATABASE_NAME = "uas111.db";
    private static final int DATABASE_VERSION = 2;
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
    private Dao<InvEvent, Integer> invEventDao = null;
    private Dao<Criterion, Integer> criterionDao = null;
    private Dao<CriterionLevel, Integer> critLevDao = null;
    private Dao<ImprovementPlan, Integer> improvementPlanDao = null;
    private Dao<Action, Integer> actionDao = null;
    private Dao<FileGen, Integer> fileGenDao = null;
    private Dao<ActionFile, Integer> actionFileDao = null;
    private Dao<Deliverable, Integer> deliverableDao = null;
    private Dao<ConfSpeciality, Integer> confSpecialtyDao = null;

    public DatabaseHelper(Context context) {
        //super(context, DATABASE_NAME, null, DATABASE_VERSION);
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
            TableUtils.createTableIfNotExists(connectionSource, Criterion.class);
            TableUtils.createTableIfNotExists(connectionSource, CriterionLevel.class);
            TableUtils.createTableIfNotExists(connectionSource, ImprovementPlan.class);
            TableUtils.createTableIfNotExists(connectionSource, Action.class);
            TableUtils.createTableIfNotExists(connectionSource, FileGen.class);
            TableUtils.createTableIfNotExists(connectionSource, ActionFile.class);
            TableUtils.createTableIfNotExists(connectionSource, Deliverable.class);

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
            TableUtils.dropTable(source, Criterion.class, true);
            TableUtils.dropTable(source, CriterionLevel.class, true);
            TableUtils.dropTable(source, ImprovementPlan.class, true);
            TableUtils.dropTable(source, Action.class, true);
            TableUtils.dropTable(source, FileGen.class, true);
            TableUtils.dropTable(source, ActionFile.class, true);
            TableUtils.dropTable(source, Deliverable.class, true);
            //Se crean denuevo
            onCreate(db, source);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Dao<MeasureInstrument, Integer> getMeasureinstrumentDao() throws SQLException {
        if (measureinstrumentDao == null) measureinstrumentDao = getDao(MeasureInstrument.class);
        return measureinstrumentDao;
    }

    public void setMeasureinstrumentDao(Dao<MeasureInstrument, Integer> measureinstrumentDao) {
        this.measureinstrumentDao = measureinstrumentDao;
    }

    public Dao<ConfSpeciality, Integer> getConfSpecialtyDao() throws SQLException {
        if (confSpecialtyDao == null) confSpecialtyDao = getDao(ConfSpeciality.class);
        return confSpecialtyDao;
    }

    public void setConfSpecialtyDao(Dao<ConfSpeciality, Integer> confSpecialtyDao) {
        this.confSpecialtyDao = confSpecialtyDao;
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

    public Dao<InvEvent, Integer> getInvEventDao() throws SQLException {
        if (invEventDao == null) invEventDao = getDao(InvEvent.class);
        return invEventDao;
    }

    public void setInvEventDao(Dao<InvEvent, Integer> invEventDao) {
        this.invEventDao = invEventDao;
    }

    public Dao<Criterion, Integer> getCriterionDao() throws SQLException {
        if (criterionDao == null) criterionDao = getDao(Criterion.class);
        return criterionDao;
    }

    public void setCriterionDao(Dao<Criterion, Integer> criterionDao) {
        this.criterionDao = criterionDao;
    }

    public Dao<CriterionLevel, Integer> getCritLevDao() throws SQLException {
        if (critLevDao == null) critLevDao = getDao(CriterionLevel.class);
        return critLevDao;
    }

    public void setCritLevDao(Dao<CriterionLevel, Integer> critLevDao) {
        this.critLevDao = critLevDao;
    }

    public Dao<ImprovementPlan, Integer> getImprovementPlanDao() throws SQLException {
        if (improvementPlanDao == null) improvementPlanDao = getDao(ImprovementPlan.class);
        return improvementPlanDao;
    }

    public void setImprovementPlanDao(Dao<ImprovementPlan, Integer> improvementPlanDao) {
        this.improvementPlanDao = improvementPlanDao;
    }

    public Dao<Action, Integer> getActionDao() throws SQLException {
        if (actionDao == null) actionDao = getDao(Action.class);
        return actionDao;
    }

    public void setActionDao(Dao<Action, Integer> actionDao) {
        this.actionDao = actionDao;
    }

    public Dao<FileGen, Integer> getFileGenDao() throws SQLException {
        if (fileGenDao == null) fileGenDao = getDao(FileGen.class);
        return fileGenDao;
    }

    public void setFileGenDao(Dao<FileGen, Integer> fileGenDao) {
        this.fileGenDao = fileGenDao;
    }

    public Dao<ActionFile, Integer> getActionFileDao() throws SQLException {
        if (actionFileDao == null) actionFileDao = getDao(ActionFile.class);
        return actionFileDao;

    }

    public void setActionFileDao(Dao<ActionFile, Integer> actionFileDao) {
        this.actionFileDao = actionFileDao;
    }

    public Dao<Deliverable, Integer> getDeliverableDao() throws SQLException {
        if (deliverableDao == null) deliverableDao = getDao(Deliverable.class);
        return deliverableDao;
    }

    public void setDeliverableDao(Dao<Deliverable, Integer> deliverableDao) {
        this.deliverableDao = deliverableDao;
    }

    @Override
    public void close() {
        super.close();
        specialtyDao = null;
        teacherDao = null;
    }
}
