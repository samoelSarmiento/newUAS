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
import uas.pe.edu.pucp.newuas.adapter.InvestigatorsAdapter;
import uas.pe.edu.pucp.newuas.adapter.ProjectsAdapter;
import uas.pe.edu.pucp.newuas.model.Faculty;
import uas.pe.edu.pucp.newuas.model.InvGroups;
import uas.pe.edu.pucp.newuas.model.Projects;

/**
 * Created by Andree on 21/10/2016.
 */

public class ProjectsFragment extends Fragment {

    ListView lvProj;
    ProjectsAdapter projectsAdapter;

    public ProjectsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_projects, container, false);
        getActivity().setTitle("Proyectos");
        lvProj=(ListView) view.findViewById(R.id.projectsList);

        Bundle bundle = this.getArguments();
        if (bundle != null){
            ArrayList<Projects> projects = (ArrayList<Projects>) bundle.getSerializable("Projects");
            /*String str = bundle.getString("Projects");
            Gson gson = new Gson();
            JsonParser jp = new JsonParser();
            JsonArray jsonA = jp.parse(str).getAsJsonArray();//jp.parse(str).getAsJsonObject();
            int cant=jsonA.size();
            ArrayList<Projects> projects=new ArrayList<Projects>();
            for(int i=0;i<cant;i++){
                JsonObject jsonO=jsonA.get(i).getAsJsonObject();
                Projects proj= new Projects();

                proj.setNombre(jsonO.get("nombre").getAsString());
                proj.setFechaIni(jsonO.get("fecha_ini").getAsString());
                proj.setFechaFin(jsonO.get("fecha_fin").getAsString());
                proj.setNumEntregables(jsonO.get("num_entregables").getAsInt());
                //proj.setDescripcion(jsonO.get("descripcion").getAsString());

                //falta los integrantes

                projects.add(proj);
            }*/
            projectsAdapter = new ProjectsAdapter(getActivity(), projects);
            lvProj.setAdapter(projectsAdapter);
        }
        return view;
    }

}
