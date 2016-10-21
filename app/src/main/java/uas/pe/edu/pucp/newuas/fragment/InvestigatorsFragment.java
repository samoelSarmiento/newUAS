package uas.pe.edu.pucp.newuas.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.adapter.InvestigatorsAdapter;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.datapersistency.RestCon;
import uas.pe.edu.pucp.newuas.datapersistency.RetrofitHelper;
import uas.pe.edu.pucp.newuas.model.User;
import uas.pe.edu.pucp.newuas.model.UserMe;
import uas.pe.edu.pucp.newuas.model.UserMeResponse;
import uas.pe.edu.pucp.newuas.model.UserRequest;
import uas.pe.edu.pucp.newuas.model.UserResponse;

/**
 * Created by Andree on 20/10/2016.
 */

public class InvestigatorsFragment extends Fragment{

    ListView lvInv;
    InvestigatorsAdapter investigatorsAdapter;

    public InvestigatorsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_investigators, container, false);
        getActivity().setTitle("Invetigadores");
        lvInv=(ListView) view.findViewById(R.id.invList);


        RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);


        Call<UserMeResponse> call = restCon.getInvestigator(Configuration.LOGIN_USER.getToken());
        call.enqueue(new Callback<UserMeResponse>() {
            @Override
            public void onResponse(Call<UserMeResponse> call, Response<UserMeResponse> response) {
                UserMeResponse item = response.body();
                ArrayList<UserMeResponse> items= new ArrayList<UserMeResponse>();
                items.add(item);
                investigatorsAdapter = new InvestigatorsAdapter(getActivity().getApplicationContext(), items);
                lvInv.setAdapter(investigatorsAdapter);
            }

            @Override
            public void onFailure(Call<UserMeResponse> call, Throwable t) {

            }

        });

        /*
        Call<ArrayList<UserResponse>> call = restCon.getInvestigator();
        call.enqueue(new Callback<ArrayList<UserResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<UserResponse>> call, Response<ArrayList<UserResponse>> response) {
                ArrayList<UserResponse> items = response.body();
                investigatorsAdapter = new InvestigatorsAdapter(getActivity().getApplicationContext(), items);
                lvInv.setAdapter(investigatorsAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<UserResponse>> call, Throwable t) {

            }
        });
        */
        return view;
    }

}
