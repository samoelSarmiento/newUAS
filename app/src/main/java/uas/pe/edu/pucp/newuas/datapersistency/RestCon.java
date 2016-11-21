package uas.pe.edu.pucp.newuas.datapersistency;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import uas.pe.edu.pucp.newuas.model.Action;
import uas.pe.edu.pucp.newuas.model.AppointInformationRegisterTuto;
import uas.pe.edu.pucp.newuas.model.AppointmentFilterRequest;
import uas.pe.edu.pucp.newuas.model.AppointmentRequest;
import uas.pe.edu.pucp.newuas.model.Aspect;
import uas.pe.edu.pucp.newuas.model.AppointmentResponse;
import uas.pe.edu.pucp.newuas.model.AppointmentResponseTuto;
import uas.pe.edu.pucp.newuas.model.CoordinatorStudentsResponse;
import uas.pe.edu.pucp.newuas.model.CourseResponse;
import uas.pe.edu.pucp.newuas.model.Deliverable;
import uas.pe.edu.pucp.newuas.model.Evaluation;
import uas.pe.edu.pucp.newuas.model.Criterion;
import uas.pe.edu.pucp.newuas.model.CriterionLevel;
import uas.pe.edu.pucp.newuas.model.InscriptionFilePSP;
import uas.pe.edu.pucp.newuas.model.EducationalObjective;
import uas.pe.edu.pucp.newuas.model.ImprovementPlan;
import uas.pe.edu.pucp.newuas.model.InvEvent;
import uas.pe.edu.pucp.newuas.model.InvGroups;
import uas.pe.edu.pucp.newuas.model.InvGroupsRequest;
import uas.pe.edu.pucp.newuas.model.Investigator;
import uas.pe.edu.pucp.newuas.model.MeasureInstrument;
import uas.pe.edu.pucp.newuas.model.PSPGrade;
import uas.pe.edu.pucp.newuas.model.PSPGroup;
import uas.pe.edu.pucp.newuas.model.PSPMeeting;
import uas.pe.edu.pucp.newuas.model.PSPMeetingRequest;
import uas.pe.edu.pucp.newuas.model.PSPMessage;
import uas.pe.edu.pucp.newuas.model.PSPPhase;
import uas.pe.edu.pucp.newuas.model.Period;
import uas.pe.edu.pucp.newuas.model.Psp_dates_supervisor_employers;
import uas.pe.edu.pucp.newuas.model.Psp_dates_supervisor_employers_get;
import uas.pe.edu.pucp.newuas.model.Schedule;
import uas.pe.edu.pucp.newuas.model.Semester;
import uas.pe.edu.pucp.newuas.model.Projects;
import uas.pe.edu.pucp.newuas.model.Specialty;
import uas.pe.edu.pucp.newuas.model.StringResponse;
import uas.pe.edu.pucp.newuas.model.Student;
import uas.pe.edu.pucp.newuas.model.StudentEffort;
import uas.pe.edu.pucp.newuas.model.StudentResult;
import uas.pe.edu.pucp.newuas.model.Suggestion;
import uas.pe.edu.pucp.newuas.model.SuggestionRequest;
import uas.pe.edu.pucp.newuas.model.TUTInfoResponse;
import uas.pe.edu.pucp.newuas.model.TopicResponse;
import uas.pe.edu.pucp.newuas.model.TutStudentForPsp;
import uas.pe.edu.pucp.newuas.model.UserMeResponse;
import uas.pe.edu.pucp.newuas.model.TokenRequest;
import uas.pe.edu.pucp.newuas.model.UserRequest;
import uas.pe.edu.pucp.newuas.model.UserResponse;

/**
 * Created by samoe on 18/10/2016.
 */

public interface RestCon {
    @POST("authenticate")
    Call<UserResponse> getUser(@Body UserRequest userRequest);

    @GET("faculties/schedule/{schedule_id}/students")
    Call<List<Student>> getStudentsbySchedule(@Path("schedule_id") int schedule_id,
                                              @QueryMap Map<String, String> token);

    @GET("faculties/effort_table/cycle/{academic_cycle_id}/course/{course_id}/schedule/{schedule_id}/student/{student_id}")
    Call<List<StudentEffort>> getEffortResultsbyStudent(@Path("academic_cycle_id") int idCicloAcademico,
                                                        @Path("course_id") int idCurso,
                                                        @Path("schedule_id") int idHorario,
                                                        @Path("student_id") int idAlumno,
                                                        @QueryMap Map<String, String> token);

    @GET("improvementplans/{ip_id}/suggestions")
    Call<List<Suggestion>> getImprPlanSuggestion(@Path("ip_id") int idImprPlan,
                                                 @QueryMap Map<String, String> token);

    @POST("improvementplans/{ip_id}/suggestions")
    Call<StringResponse> sendSuggestion(@Path("ip_id") int idImprPlan,
                                        @Body SuggestionRequest suggestionRequest,
                                        @QueryMap Map<String, String> token);

    @GET("faculties/{f_id}/semester/{s_id}/courses")
    Call<List<CourseResponse>> getCoursesxSpecialty(@Path("f_id") int faculty_id,
                                                    @Path("s_id") int semester_id,
                                                    @QueryMap Map<String, String> token);

    @GET("faculties/teacher/{teacher_id}/courses")
    Call<List<CourseResponse>> getTeacherCourses(@Path("teacher_id") int teacher_id,
                                                 @QueryMap Map<String, String> token);

    /*
    @GET("faculties/{faculty_id}/evaluated_courses")
    Call<List<CourseResponse>> getCoursesxSpecialty(@Path("faculty_id") int faculty_id,@QueryMap Map<String, String> token);
    */
    @GET("faculties")
    Call<List<Specialty>> getAllSpecialties(@QueryMap Map<String, String> token);

    @GET("periods/{p_id}/show")
    Call<Period> getPeriod(@Path("p_id") int period_id, @QueryMap Map<String, String> token);

    @GET("faculties/course/{course_id}/cycle/{academic_cycle_id}")
    Call<List<Schedule>> getCourseSchedules(@Path("course_id") int course_id,
                                            @Path("academic_cycle_id") int academic_cycle_id,
                                            @QueryMap Map<String, String> token);

    @GET("faculties/student_result/{sr_id}/aspects")
    Call<List<Aspect>> getStudentResultAspects(@Path("sr_id") int idStudentResult,
                                               @QueryMap Map<String, String> token);

    @GET("faculties/{faculty_id}/eob/{eos_id}/students_results")
    Call<List<StudentResult>> getStudentResults(@Path("faculty_id") int idSpecialty,
                                                @Path("eos_id") int idEdObj,
                                                @QueryMap Map<String, String> token);

    @GET("aspects/{id}/criterions")
    Call<List<Criterion>> getCriterionsofAspect(@Path("id") int idAspect, @QueryMap Map<String, String> toe);

    @GET("criterions/{id}/levels")
    Call<List<CriterionLevel>> getLevelsofCriterion(@Path("id") int idCriterion, @QueryMap Map<String, String> token);


    @GET("periods/{p_id}/{f_id}/objectives")
    Call<List<EducationalObjective>> getEducationalObjectivesByPeriodSpecialty(@Path("p_id") int period_id,
                                                                               @Path("f_id") int faculty_id,
                                                                               @QueryMap Map<String, String> token);

    @GET("faculties/course/{c_id}/{s_id}/contributions")
    Call<List<StudentResult>> getCourseContribution(@Path("c_id") int course_id, @Path("s_id") int semester_id, @QueryMap Map<String, String> token);


    @POST("users/me")
    Call<UserMeResponse> getInvestigator(@Body TokenRequest token);

    @GET("faculties/{faculty_id}/improvement_plans")
    Call<List<ImprovementPlan>> getImprovementPlansofSpecialty(@Path("faculty_id") int specId, @QueryMap Map<String, String> token);

    @GET("improvementplans/{ip_id}/view")
    Call<ImprovementPlan> getImprovementPlanById(@Path("ip_id") int ipId, @QueryMap Map<String, String> token);

    @GET("improvementplans/{ip_id}/actions")
    Call<List<Action>> getActionsofImprovementPlan(@Path("ip_id") int ipId, @QueryMap Map<String, String> token);


    /*Evaluaciones*/
    @GET("evaluation/getAllEvaluations")
    Call<List<Evaluation>> getEvaluations(@QueryMap Map<String, String> token);

    @GET("evaluation/getEvaluationsByFilter/{name}/{state}/{id}")
    Call<List<Evaluation>> getEvaluationsByFilter(@Path("name") String name, @Path("state") int status, @Path("id") int specId, @QueryMap Map<String, String> token);


    /*Investigacion*/
    @GET("investigation/getAllInvestigators")
    Call<List<Investigator>> getInvestigators(@QueryMap Map<String, String> token);


    @GET("investigation/getAllInvGroups")
    Call<List<InvGroups>> getInvGroups(@QueryMap Map<String, String> token);

    @GET("investigation/getAllProjects")
    Call<List<Projects>> getProjects(@QueryMap Map<String, String> token);

    @POST("investigation/{id}/projects")
    Call<StringResponse> editProject(@Path("id") int groupId, @QueryMap Map<String, String> token, @Body Projects projects);

    @GET("investigation/{id}/investigators")
    Call<List<Investigator>> getInvById(@Path("id") int invId, @QueryMap Map<String, String> token);

    @GET("investigation/{id}/groups")
    Call<List<InvGroups>> getInvGroupById(@Path("id") int groupId, @QueryMap Map<String, String> token);

    @POST("investigation/{id}/groups")
    Call<StringResponse> editInvGroup(@Path("id") int groupId, @QueryMap Map<String, String> token, @Body InvGroupsRequest invGroups);

    @POST("investigation/{id}/investigators")
    Call<StringResponse> editInvestigator(@Path("id") int groupId, @QueryMap Map<String, String> token, @Body Investigator investigator);

    @GET("investigation/{id}/projects")
    Call<List<Projects>> getProjById(@Path("id") int projId, @QueryMap Map<String, String> token);

    @GET("investigation/{id}/event")
    Call<List<InvEvent>> getEvById(@Path("id") int id, @QueryMap Map<String, String> token);

    @GET("investigation/{id}/events")
    Call<List<InvEvent>> getEvByGroupId(@Path("id") int id, @QueryMap Map<String, String> token);

    @POST("investigation/{id}/event")
    Call<StringResponse> editInvEv(@Path("id") int id, @QueryMap Map<String, String> token, @Body InvEvent invEvent);

    @GET("investigation/{id}/deliverable")
    Call<List<Deliverable>> getDelById(@Path("id") int id, @QueryMap Map<String, String> token);

    @GET("investigation/{id}/deliverables")
    Call<List<Deliverable>> getDelByProjId(@Path("id") int id, @QueryMap Map<String, String> token);

    /*--------------*/


    /*@GET("users/me")
    Call<UserResponse> getInvestigator(@Body String token);*/

    /*@GET("faculties")
    Call<List<Specialty>> getSpecialtyList(@QueryMap Map<String, String> token);*/

    @GET("faculties/getFaculty/{faculty_id}")
    Call<Specialty> getSpecialtyById(@Path("faculty_id") int faculty_id, @QueryMap Map<String, String> token);

    /* TUTORIA Section*/

    @GET("getTopics")
    Call<List<TopicResponse>> getTopics(@QueryMap Map<String, String> token);

    @GET("getAppointmentList/{id_usuario}")
    Call<List<AppointmentResponse>> getAppointment(@Path("id_usuario") int id_usuario, @QueryMap Map<String, String> token);

    @GET("getTutorInfo/{id_usuario}")
    Call<List<TUTInfoResponse>> getTutorInfo(@Path("id_usuario") int id_usuario, @QueryMap Map<String, String> token);

    @GET("getTutorAppoints/{id_usuario}")
    Call<List<AppointmentResponseTuto>> getTutorAppoints(@Path("id_usuario") int id_usuario, @QueryMap Map<String, String> token);

    @GET("getCoordinatorStudent ")
    Call<List<CoordinatorStudentsResponse>> getCoordinatorStudent(@QueryMap Map<String, String> token);

    @POST("registerStudentAppointment")
    Call<String> doAppointment(@Body AppointmentRequest appointmentRequest, @QueryMap Map<String, String> token);

    @POST("registerTutorAppointment")
    Call<String> doAppointmentTutor(@Body AppointmentRequest appointmentRequest, @QueryMap Map<String, String> token);

    @GET("getAppointInformationTuto/{id_usuario}")
    Call<List<AppointInformationRegisterTuto>> getAppointInfoTuto(@Path("id_usuario") int id_usuario, @QueryMap Map<String, String> token);

    @POST("filterStudentAppointment")
    Call<List<AppointmentResponse>> filterStudentAppointment(@Body AppointmentFilterRequest appointmentFilterRequest, @QueryMap Map<String, String> token);

    @POST("updateStudentAppointment")
    Call<String> updateAppointment(@Body AppointmentRequest appointmentRequest, @QueryMap Map<String, String> token);

    @POST("cancelStudentAppointment")
    Call<String> cancelAppointment(@Body AppointmentRequest appointmentRequest, @QueryMap Map<String, String> token);

    /*END SECTION*/


    @GET("periods/{f_id}/list")
    Call<List<Period>> getPeriods(@Path("f_id") int faculty_id, @QueryMap Map<String, String> token);

    @GET("periods/{p_id}/instruments")
    Call<List<MeasureInstrument>> getMeaInstofPer(@Path("p_id") int period_id, @QueryMap Map<String, String> token);

    @GET("periods/{p_id}/cycles")
    Call<List<Semester>> getSemofPer(@Path("p_id") int period_id, @QueryMap Map<String, String> token);


    /* PSP  Section*/

    @GET("psp/groups/all")
    Call<List<PSPGroup>> getGroupsPsp(@QueryMap Map<String, String> token);

    @POST("psp/groups/selectGroup/{g_id}")
    Call<PSPMessage> updateGroup(@Path("g_id") int idGroup, @QueryMap Map<String, String> token);

    @GET("psp/phases/all")
    Call<List<PSPPhase>> getPhasesPsp(@QueryMap Map<String, String> token);


    //@GET("psp/document/all")
    //Call<List<PSPDocument>> getDocument(@QueryMap Map<String,String> token);


    @GET("psp/studentsPSP/all")
    Call<List<Student>> getStudents(@QueryMap Map<String, String> token);

    @GET("psp/teacher/students/all")
    Call<List<Student>> getStudents2(@QueryMap Map<String, String> token);


    @GET("psp/students/inscriptioFile")
    Call<List<InscriptionFilePSP>> getInscriptionFile(@QueryMap Map<String, String> token);
    //@GET("psp/students/{s_id}/documents")
    //Call<List<PSPDocument>> getDocumentsByStudent(@Path("s_id") int s_id ,@QueryMap Map<String,String> token);

    @POST("psp/students/{id}/sendInscriptioFile")
    Call<String> sendInscriptionFile(@Path("id") int inscriptionID, @QueryMap Map<String, String> token, @Body InscriptionFilePSP inscription);

    @GET("psp/student/group")
    Call<List<PSPGroup>> getStudentGroup(@QueryMap Map<String, String> token);

    @GET("psp/student/{id}/grade")
    Call<List<PSPGrade>> getStudentGrades(@Path("id") int idStudent, @QueryMap Map<String, String> token);


    @GET("psp/supervisor/students")
    Call<List<Student>> getSupStudents(@QueryMap Map<String, String> token);

    @GET("psp/meeting/student/{id}")
    Call<List<PSPMeeting>> getSupMeetingByStudent(@Path("id") int idStudent, @QueryMap Map<String, String> token);

    @POST("psp/update/meeting")
    Call<PSPMessage> updateMeetingDetail(@Body PSPMeeting meeting, @QueryMap Map<String, String> token);

    @POST("psp/meeting/supervisor/student/store")
    Call<PSPMessage> storeSupStudentMeeting(@Body PSPMeetingRequest meeting, @QueryMap Map<String, String> token);


    @POST("psp/date/supervisor/employer")
    Call<String> realizarCitasPSPsupervJefe(@QueryMap Map<String, String> token, @Body Psp_dates_supervisor_employers inscription);

    //@GET("psp/pspstudent/{id}/detail")
    //Call<List<StudentPsp>> getInformationStudentPSP(@Path("id") int idStudent, @QueryMap Map<String, String> token);

    @GET("psp/date/super/employer/all")
    Call<List<Psp_dates_supervisor_employers_get>> getDatesSuperEmployerPsp(@QueryMap Map<String, String> token);

    @GET("psp/pspstudent/{id}/detail")
    Call<List<Psp_dates_supervisor_employers_get>> getPspStudentDetail(@Path("id") int idStudent, @QueryMap Map<String, String> token);

    @GET("psp/student/{id}/detail")
    Call<List<Psp_dates_supervisor_employers_get>> getStudentDetail(@Path("id") int idStudent, @QueryMap Map<String, String> token);

    @GET("psp/tutstudent/{id}/detail")
    Call<List<TutStudentForPsp>> getTutStudentDetail(@Path("id") int idStudent, @QueryMap Map<String, String> token);



    /*END SECTION*/
}

