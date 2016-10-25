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
import uas.pe.edu.pucp.newuas.model.CourseResponse;

import uas.pe.edu.pucp.newuas.model.Investigator;
import uas.pe.edu.pucp.newuas.model.Specialty;
import uas.pe.edu.pucp.newuas.model.SpecialtyResponse;

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

    @GET("faculties/{faculty_id}/evaluated_courses")
    Call<CourseResponse> getCoursesxSpecialty(@Path("faculty_id") int faculty_id,@QueryMap Map<String, String> token);


    @POST("users/me")
    Call<UserMeResponse> getInvestigator(@Body TokenRequest token);

    /*Investigacion*/
    @GET("internetUAS/public/api/getAllInvestigators")
    Call<List<Investigator>> getInvestigators(@QueryMap Map<String,String> token);
    /*
    @GET("internetUAS/public/api/getAllGroups")
    Call<List<InvGroupResponse>> getInvGroups(@QueryMap Map<String,String> token);

    @GET("internetUAS/public/api/getAllProjects")
    Call<List<ProjResponse>> getProjects(@QueryMap Map<String,String> token);*/
    /*--------------*/


    /*@GET("users/me")
    Call<UserResponse> getInvestigator(@Body String token);*/

    /*@GET("faculties")
    Call<List<Specialty>> getSpecialtyList(@QueryMap Map<String, String> token);*/

    @GET("faculties/getFaculty/{faculty_id}")
    Call<Specialty> getSpecialtyById(@Path("faculty_id") int faculty_id, @QueryMap Map<String, String> token);

    @GET("/internetUAS/public/api/getTopics")
    Call<List<TopicResponse>> getTopics(@QueryMap Map<String,String> token);

}

