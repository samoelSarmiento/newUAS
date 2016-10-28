package uas.pe.edu.pucp.newuas.datapersistency;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import uas.pe.edu.pucp.newuas.model.AppointmentRequest;
import uas.pe.edu.pucp.newuas.model.CourseResponse;



import uas.pe.edu.pucp.newuas.model.InvGroups;
import uas.pe.edu.pucp.newuas.model.Investigator;


import uas.pe.edu.pucp.newuas.model.MeasureInstrument;

import uas.pe.edu.pucp.newuas.model.PSPGroup;
import uas.pe.edu.pucp.newuas.model.PSPPhase;
import uas.pe.edu.pucp.newuas.model.Period;

import uas.pe.edu.pucp.newuas.model.Semester;


import uas.pe.edu.pucp.newuas.model.Projects;

import uas.pe.edu.pucp.newuas.model.Specialty;
import uas.pe.edu.pucp.newuas.model.SpecialtyResponse;

import uas.pe.edu.pucp.newuas.model.TUTInfoResponse;
import uas.pe.edu.pucp.newuas.model.TopicResponse;
import uas.pe.edu.pucp.newuas.model.UserMe;
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


    @GET("faculties/{f_id}/{s_id}/courses")
    Call<List<CourseResponse>> getCoursesxSpecialty(@Path("f_id") int faculty_id,
                                                    @Path("s_id") int semester_id,
                                                    @QueryMap Map<String, String> token);

    /*
    @GET("faculties/{faculty_id}/evaluated_courses")
    Call<List<CourseResponse>> getCoursesxSpecialty(@Path("faculty_id") int faculty_id,@QueryMap Map<String, String> token);
    */


    @POST("users/me")
    Call<UserMeResponse> getInvestigator(@Body TokenRequest token);

    /*Investigacion*/
    @GET("getAllInvestigators")
    Call<List<Investigator>> getInvestigators(@QueryMap Map<String,String> token);

    @GET("getAllInvGroups")
    Call<List<InvGroups>> getInvGroups(@QueryMap Map<String,String> token);

    @GET("getAllProjects")
    Call<List<Projects>> getProjects(@QueryMap Map<String,String> token);

    @GET("investigation/{id}/investigators")
    Call<List<Investigator>> getInvById(@Path("id") int invId, @QueryMap Map<String,String> token);

    @GET("investigation/{id}/groups")
    Call<List<InvGroups>> getInvGroupById(@Path("id") int groupId, @QueryMap Map<String,String> token);

    @GET("investigation/{id}/projects")
    Call<List<Projects>> getProjById(@Path("id") int projId, @QueryMap Map<String,String> token);
    /*--------------*/


    /*@GET("users/me")
    Call<UserResponse> getInvestigator(@Body String token);*/

    /*@GET("faculties")
    Call<List<Specialty>> getSpecialtyList(@QueryMap Map<String, String> token);*/

    @GET("faculties/getFaculty/{faculty_id}")
    Call<Specialty> getSpecialtyById(@Path("faculty_id") int faculty_id, @QueryMap Map<String, String> token);

    /* TUTORIA Section*/

    @GET("/internetUAS/public/api/getTopics")
    Call<List<TopicResponse>> getTopics(@QueryMap Map<String,String> token);

    @GET("/internetUAS/public/api/getTutorInfo/{id_usuario}")
    //Call<List<TUTInfoResponse>>getTutorInfo
    Call<List<TUTInfoResponse>> getTutorInfo(@Path("id_usuario") int id_usuario, @QueryMap Map<String,String> token);

    @POST("/internetUAS/public/api/registerStudentAppointment")
    Call<String> doAppointment(@Body AppointmentRequest appointmentRequest,@QueryMap Map<String,String> token) ;

    /*END SECTION*/


    @GET("periods/{f_id}/list")
    Call<List<Period>> getPeriods(@Path("f_id") int faculty_id, @QueryMap Map<String,String> token);

    @GET("periods/{p_id}/instruments")
    Call<List<MeasureInstrument>> getMeaInstofPer(@Path("p_id") int period_id, @QueryMap Map<String,String> token);

    @GET("periods/{p_id}/cycles")
    Call<List<Semester>> getSemofPer(@Path("p_id") int period_id, @QueryMap Map<String,String> token);


    /* PSP  Section*/

    @GET("psp/groups/all")
    Call<List<PSPGroup>> getGroupsPsp(@QueryMap Map<String,String> token);

    @POST("psp/groups/selectGroup/{g_id}")
    Call<String>  updateGroup(@Path("g_id") int idGroup , @QueryMap Map<String, String> token);

    @GET("psp/phases/all")
    Call<List<PSPPhase>> getPhasesPsp(@QueryMap Map<String,String> token);




    /*END SECTION*/




}

