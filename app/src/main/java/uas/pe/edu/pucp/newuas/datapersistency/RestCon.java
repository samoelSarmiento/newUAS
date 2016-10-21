package uas.pe.edu.pucp.newuas.datapersistency;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import uas.pe.edu.pucp.newuas.model.UserRequest;
import uas.pe.edu.pucp.newuas.model.UserResponse;

/**
 * Created by samoe on 18/10/2016.
 */

public interface RestCon {
    @POST("authenticate")
    Call<UserResponse> getAccreditor(@Body UserRequest userRequest);

    @POST("authenticate")
    Call<UserResponse> getInvestigator(@Body UserRequest userRequest);

}
