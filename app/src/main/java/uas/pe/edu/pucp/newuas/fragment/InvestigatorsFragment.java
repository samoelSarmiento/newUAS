package uas.pe.edu.pucp.newuas.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.adapter.InvestigatorsAdapter;
import uas.pe.edu.pucp.newuas.adapter.MeasurePeriodAdapter;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.datapersistency.RestCon;
import uas.pe.edu.pucp.newuas.datapersistency.RetrofitHelper;
import uas.pe.edu.pucp.newuas.model.Faculty;
import uas.pe.edu.pucp.newuas.model.Investigator;
import uas.pe.edu.pucp.newuas.model.Period;
import uas.pe.edu.pucp.newuas.model.TokenRequest;
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
        getActivity().setTitle("Investigadores");
        lvInv=(ListView) view.findViewById(R.id.invList);

        /*ArrayList<UserMeResponse> items= new ArrayList<UserMeResponse>();
        items.add(item);
        investigatorsAdapter = new InvestigatorsAdapter(getActivity().getApplicationContext(), items);
        lvInv.setAdapter(investigatorsAdapter);*/

        Bundle bundle = this.getArguments();

        if (bundle != null){

            ArrayList<Investigator> investigators = (ArrayList<Investigator>) bundle.getSerializable("Investigators");


            /*
            Gson gson = new Gson();
            JsonParser jp = new JsonParser();
            JsonArray json = jp.parse(str).getAsJsonArray();
            Log.d("TAG",json.getAsString());
            Context context = getActivity();
            */

            /*
            String str = bundle.getString("Investigators");
            Gson gson = new Gson();
            JsonParser jp = new JsonParser();
            JsonArray jsonA = jp.parse(str).getAsJsonArray();//jp.parse(str).getAsJsonObject();
            int cant=jsonA.size();
            ArrayList<Investigator> investigators=new ArrayList<Investigator>();
            for(int i=0;i<cant;i++){
                JsonObject jsonO=jsonA.get(i).getAsJsonObject();
                Investigator investigator= new Investigator();

                investigator.setNombre(jsonO.get("nombre").getAsString());
                investigator.setApePaterno(jsonO.get("ape_paterno").getAsString());
                investigator.setApeMaterno(jsonO.get("ape_materno").getAsString());
                investigator.setCorreo(jsonO.get("correo").getAsString());
                investigator.setCelular(jsonO.get("celular").getAsString());

                JsonObject jsonOFac=jsonO.getAsJsonObject("faculty");
                Faculty faculty=new Faculty();
                faculty.setNombre(jsonOFac.get("Nombre").getAsString());
                investigator.setFaculty(faculty);

                investigators.add(investigator);
            }*/
            investigatorsAdapter = new InvestigatorsAdapter(getActivity(), investigators);
            lvInv.setAdapter(investigatorsAdapter);
            //Log.d("TAG",json.get("Nombre").getAsString());
            //Log.d("TAG",json.getAsString());
        }

        //RestCon restCon = RetrofitHelper.apiConnector.create(RestCon.class);
        //Call<UserMeResponse> call = restCon.getInvestigator(Configuration.LOGIN_USER.getToken());
        //Call<UserMeResponse> call = restCon.getInvestigator(new TokenRequest(Configuration.LOGIN_USER.getToken()));
        /*
        call.enqueue(new Callback<UserMeResponse>() {
            @Override
            public void onResponse(Call<UserMeResponse> call, Response<UserMeResponse> response) {
                System.out.println(response.code());
                /*UserMeResponse item = response.body();
                ArrayList<UserMeResponse> items= new ArrayList<UserMeResponse>();
                items.add(item);
                investigatorsAdapter = new InvestigatorsAdapter(getActivity().getApplicationContext(), items);
                lvInv.setAdapter(investigatorsAdapter);
            }

            @Override
            public void onFailure(Call<UserMeResponse> call, Throwable t) {

            }

        });*/
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
