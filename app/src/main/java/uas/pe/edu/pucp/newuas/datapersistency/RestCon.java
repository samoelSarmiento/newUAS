package uas.pe.edu.pucp.newuas.datapersistency;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import uas.pe.edu.pucp.newuas.model.UserRequest;
import uas.pe.edu.pucp.newuas.model.UserResponseAccreditor;

/**
 * Created by samoe on 18/10/2016.
 */

public interface RestCon {
    @POST("authenticate")
    Call<UserResponseAccreditor> getAccreditor(@Body UserRequest userRequest);

}
