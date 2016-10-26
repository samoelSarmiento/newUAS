package uas.pe.edu.pucp.newuas.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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
import uas.pe.edu.pucp.newuas.controller.InvestigatorController;
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

            investigatorsAdapter = new InvestigatorsAdapter(getActivity(), investigators);
            lvInv.setAdapter(investigatorsAdapter);
            //Log.d("TAG",json.get("Nombre").getAsString());
            //Log.d("TAG",json.getAsString());
        }
        lvInv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Investigator inv = (Investigator) investigatorsAdapter.getItem(position);

                InvestigatorController invController = new InvestigatorController();
                //Toast.makeText(getActivity(), "entre", Toast.LENGTH_SHORT).show();
                invController.getInvestigatorById(getActivity(),inv.getId());

            }
        });

        return view;
    }

}
