package uas.pe.edu.pucp.newuas.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.adapter.InvestigatorsAdapter;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.controller.InvestigatorController;
import uas.pe.edu.pucp.newuas.model.Investigator;

/**
 * Created by Andree on 25/10/2016.
 */

public class InvDetailFragment extends Fragment {

    TextView invName, invMail,invTel,invEsp;
    Button editBut;
    Investigator inv;


    public InvDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_investigators_detail, container, false);

        getActivity().setTitle("Investigadores");

        invName=(TextView) view.findViewById(R.id.invName);
        invMail=(TextView) view.findViewById(R.id.invMail);
        invTel=(TextView) view.findViewById(R.id.invTel);
        invEsp=(TextView) view.findViewById(R.id.invEsp);
        editBut=(Button)view.findViewById(R.id.invEdit) ;

        Bundle bundle = this.getArguments();
        List<Investigator> investigator=null;
        boolean botonEdit=false;
        if (bundle != null){
            //Toast.makeText(getActivity(), "entre2", Toast.LENGTH_SHORT).show();
            investigator= (List<Investigator>) bundle.getSerializable("Inv");
            botonEdit=bundle.getBoolean("BotonEdit");
        }

        if(!botonEdit) editBut.setVisibility(View.INVISIBLE);

        inv=investigator.get(0);
        invName.setText(investigator.get(0).getNombre() + " " + investigator.get(0).getApePaterno() + " " + investigator.get(0).getApeMaterno());
        invMail.setText(investigator.get(0).getCorreo());
        invTel.setText(investigator.get(0).getCelular());
        invEsp.setText(investigator.get(0).getFaculty().getNombre());


        //permisos
        /*
        editBut.setVisibility(View.GONE);
        if(Configuration.LOGIN_USER.getUser().getTeacher()!=null){
            if(proj.get(0).getGroup().getIdLider()== Configuration.LOGIN_USER.getUser().getTeacher().getIdDocente()){
                editBut.setVisibility(View.VISIBLE)

        }*/

        //permisos
        if(Configuration.LOGIN_USER.getUser().getInvestigator()!=null)
            if(investigator.get(0).getId()!= Configuration.LOGIN_USER.getUser().getInvestigator().getId())
                editBut.setVisibility(View.GONE);

        if(Configuration.isAdmin())
            editBut.setVisibility(View.VISIBLE);

        editBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("EditInv", inv);
                InvEditFragment mpvFragment = new InvEditFragment();
                mpvFragment.setArguments(bundle);

                Context context = getActivity();
                //Toast.makeText(getActivity(), "entre", Toast.LENGTH_SHORT).show();
                ((Activity)context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container,mpvFragment).commit();
                ((Activity)context).setTitle("Investigación");
            }
        });

        return view;
    }

/*
    @Override
    public void onClick(View v) {


    }*/
}
