package uas.pe.edu.pucp.newuas.datapersistency;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.model.Example;
import uas.pe.edu.pucp.newuas.model.UserRequest;

/**
 * Created by samoe on 18/10/2016.
 */

public interface RestCon {
    @POST("authenticate")
    Call<Example> getAccreditor(@Body UserRequest userRequest);

}
