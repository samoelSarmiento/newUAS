package uas.pe.edu.pucp.newuas.datapersistency;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import uas.pe.edu.pucp.newuas.model.CourseResponse;
import uas.pe.edu.pucp.newuas.model.UserRequest;
import uas.pe.edu.pucp.newuas.model.UserResponse;

/**
 * Created by samoe on 18/10/2016.
 */

public interface RestCon {
    @POST("authenticate")
    Call<UserResponse> getAccreditor(@Body UserRequest userRequest);


    @GET("users/me")
    Call<UserResponse> getInvestigator(@Body String token);


    @POST("{faculty_id}/evaluated_courses")
    Call<CourseResponse> getCoursesxSpecialty(@Path("faculty_id") int facultyId, @Body String token);

}
