package uas.pe.edu.pucp.newuas.datapersistency;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import uas.pe.edu.pucp.newuas.model.CourseResponse;
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
    Call<CourseResponse> getCoursesxSpecialty(@Path("faculty_id") int faculty_id, @Header("token") String tokenRequest);

    @POST("users/me")
    Call<UserMeResponse> getInvestigator(@Body TokenRequest token);

}
