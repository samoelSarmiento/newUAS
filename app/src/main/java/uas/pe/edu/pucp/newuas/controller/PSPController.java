package uas.pe.edu.pucp.newuas.controller;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.datapersistency.RestCon;
import uas.pe.edu.pucp.newuas.datapersistency.RetrofitHelper;
import uas.pe.edu.pucp.newuas.fragment.PSP_groupsFragment;
import uas.pe.edu.pucp.newuas.model.PSPGroup;

/**
 * Created by Franz on 26/10/2016.
 */

public class PSPController {


    public boolean getGroups (final Context context){
        RestCon restCon  = RetrofitHelper.apiConnector.create(RestCon.class);

        Map<String,String> token = new HashMap<>();

        token.put("token", Configuration.LOGIN_USER.getToken());


        Call<List<PSPGroup>> call = restCon.getGroupsPsp(token);

        call.enqueue(new Callback<List<PSPGroup>>() {
            @Override
            public void onResponse(Call<List<PSPGroup>> call, Response<List<PSPGroup>> response) {

                if(response.isSuccessful()){

                    List<PSPGroup> pspGroupList = response.body();

                    Bundle  bundle =  new Bundle();
                    bundle.putSerializable("PSPGroups",(Serializable) pspGroupList);


                    PSP_groupsFragment groupsFragment = new PSP_groupsFragment();
                    groupsFragment.setArguments(bundle);


                    ((Activity)context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container,groupsFragment).commit();
                    ((Activity)context).setTitle("Seleccionar grupos");





                }else{




                }


            }

            @Override
            public void onFailure(Call<List<PSPGroup>> call, Throwable t) {

            }
        });



        return true;
    }

    public boolean updateGroup(final Context context, int idGroup){
        RestCon restCon =  RetrofitHelper.apiConnector.create(RestCon.class);



        Map<String,String> token = new HashMap<>();

        token.put("token", Configuration.LOGIN_USER.getToken());


        Call<Boolean> call = restCon.updateGroup(idGroup,token);
        call.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if (response.isSuccessful()){

                    if (response.body()){


                    }




                }
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {

            }
        });


        return true;
    }


}
