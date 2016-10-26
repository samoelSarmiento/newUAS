package uas.pe.edu.pucp.newuas.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.adapter.InvestigatorsAdapter;
import uas.pe.edu.pucp.newuas.controller.InvestigatorController;
import uas.pe.edu.pucp.newuas.model.Investigator;

/**
 * Created by Andree on 25/10/2016.
 */

public class InvDetailFragment extends Fragment{

    TextView invName, invMail,invTel,invEsp;



    public InvDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_investigators_detail, container, false);
        getActivity().setTitle("Investigadores");

        invName=(TextView) view.findViewById(R.id.inv_name);
        invMail=(TextView) view.findViewById(R.id.invMail);
        invTel=(TextView) view.findViewById(R.id.invTel);
        invEsp=(TextView) view.findViewById(R.id.invEsp);

        Bundle bundle = this.getArguments();
        Investigator investigator=null;
        if (bundle != null){
            investigator= (Investigator) bundle.getSerializable("Inv");
        }
        invName.setText(investigator.getNombre());
        invMail.setText(investigator.getCorreo());
        invTel.setText(investigator.getCelular());
        invEsp.setText(investigator.getFaculty().getNombre());

        return view;
    }


}
