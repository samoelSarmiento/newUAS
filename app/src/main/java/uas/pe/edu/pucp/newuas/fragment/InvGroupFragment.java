package uas.pe.edu.pucp.newuas.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.adapter.InvGroupsAdapter;
import uas.pe.edu.pucp.newuas.adapter.InvestigatorsAdapter;
import uas.pe.edu.pucp.newuas.model.Faculty;
import uas.pe.edu.pucp.newuas.model.InvGroups;
import uas.pe.edu.pucp.newuas.model.Investigator;

/**
 * Created by Andree on 19/10/2016.
 */
public class InvGroupFragment extends Fragment{

    ListView lvInvGroup;
    InvGroupsAdapter invGroupsAdapter;

    public InvGroupFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inv_group, container, false);
        getActivity().setTitle("Grupos de Inv.");
        lvInvGroup=(ListView) view.findViewById(R.id.invGroupList);

        Bundle bundle = this.getArguments();
        if (bundle != null){
            String str = bundle.getString("Groups");
            Gson gson = new Gson();
            JsonParser jp = new JsonParser();
            JsonArray jsonA = jp.parse(str).getAsJsonArray();//jp.parse(str).getAsJsonObject();
            int cant=jsonA.size();
            ArrayList<InvGroups> invGroups=new ArrayList<InvGroups>();
            for(int i=0;i<cant;i++){
                JsonObject jsonO=jsonA.get(i).getAsJsonObject();
                InvGroups invGroup= new InvGroups();

                invGroup.setNombre(jsonO.get("nombre").getAsString());
                invGroup.setDescripcion(jsonO.get("descripcion").getAsString());

                JsonObject jsonOFac=jsonO.getAsJsonObject("faculty");
                Faculty faculty=new Faculty();
                faculty.setNombre(jsonOFac.get("Nombre").getAsString());
                invGroup.setFaculty(faculty);

                invGroups.add(invGroup);
            }
            invGroupsAdapter = new InvGroupsAdapter(getActivity().getApplicationContext(), invGroups);
            lvInvGroup.setAdapter(invGroupsAdapter);
        }
        return view;
    }

}
