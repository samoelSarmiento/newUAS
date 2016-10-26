package uas.pe.edu.pucp.newuas.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.model.Projects;

/**
 * Created by Andree on 25/10/2016.
 */

public class ProjDetailFragment extends Fragment {

    TextView projName, projInitDate,projFinDate, projDeliv, projMembers;
    Button projEdit;
    Projects p;

    public ProjDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_projects_detail, container, false);

        getActivity().setTitle("Proyectos");

        projName=(TextView) view.findViewById(R.id.projName);
        projInitDate=(TextView) view.findViewById(R.id.projInitDate);
        projFinDate=(TextView) view.findViewById(R.id.projFinDate);
        projDeliv=(TextView) view.findViewById(R.id.projDeliv);
        projMembers=(TextView) view.findViewById(R.id.projMembers);
        projEdit=(Button) view.findViewById(R.id.projEdit);

        Bundle bundle = this.getArguments();
        List<Projects> proj=null;
        if (bundle != null){
            //Toast.makeText(getActivity(), "entre2", Toast.LENGTH_SHORT).show();
            proj= (List<Projects>) bundle.getSerializable("Proj");
        }
        p=proj.get(0);
        projName.setText(proj.get(0).getNombre());
        projInitDate.setText(proj.get(0).getFechaIni());
        projFinDate.setText(proj.get(0).getFechaFin());
        String cantEnt="" + proj.get(0).getNumEntregables();
        projDeliv.setText(cantEnt);
        //projMembers.setText(invGroup.get(0).getFaculty().getNombre());

        projEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("EditProj", p);
                ProjEditFragment mpvFragment = new ProjEditFragment();
                mpvFragment.setArguments(bundle);

                Context context = getActivity();
                //Toast.makeText(getActivity(), "entre", Toast.LENGTH_SHORT).show();
                ((Activity)context).getFragmentManager().beginTransaction().replace(R.id.fragment_container,mpvFragment).commit();
                ((Activity)context).setTitle("Proyectos");
            }
        });

        return view;
    }


}
