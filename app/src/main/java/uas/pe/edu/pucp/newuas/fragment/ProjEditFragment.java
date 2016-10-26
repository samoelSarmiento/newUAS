package uas.pe.edu.pucp.newuas.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.model.Projects;

/**
 * Created by Andree on 26/10/2016.
 */

public class ProjEditFragment extends Fragment implements View.OnClickListener{

    EditText projName, projInitDate,projFinDate, projDeliv, projMembers;
    Button projSave,projCancel;
    Projects p;
    public ProjEditFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_projects_edit, container, false);

        getActivity().setTitle("Proyectos");

        projName=(EditText) view.findViewById(R.id.projName);
        projInitDate=(EditText) view.findViewById(R.id.projInitDate);
        projFinDate=(EditText) view.findViewById(R.id.projFinDate);
        projDeliv=(EditText) view.findViewById(R.id.projDeliv);
        projMembers=(EditText) view.findViewById(R.id.projMembers);
        projSave=(Button) view.findViewById(R.id.projSave);
        projCancel=(Button) view.findViewById(R.id.projCancel);

        Bundle bundle = this.getArguments();
        Projects proj=null;
        if (bundle != null){
            //Toast.makeText(getActivity(), "entre2", Toast.LENGTH_SHORT).show();
            proj= (Projects) bundle.getSerializable("EditProj");
        }
        p=proj;
        projName.setText(proj.getNombre());
        projInitDate.setText(proj.getFechaIni());
        projFinDate.setText(proj.getFechaFin());
        String cantEnt="" + proj.getNumEntregables();
        projDeliv.setText(cantEnt);
        //projMembers.setText(invGroup.get(0).getFaculty().getNombre());

        projSave.setOnClickListener(this);
        projCancel.setOnClickListener(this);



        return view;
    }


    @Override
    public void onClick(View v) {

    }
}
