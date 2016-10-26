package uas.pe.edu.pucp.newuas.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

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

        invName=(TextView) view.findViewById(R.id.invName);
        invMail=(TextView) view.findViewById(R.id.invMail);
        invTel=(TextView) view.findViewById(R.id.invTel);
        invEsp=(TextView) view.findViewById(R.id.invEsp);

        Bundle bundle = this.getArguments();
        List<Investigator> investigator=null;
        if (bundle != null){
            //Toast.makeText(getActivity(), "entre2", Toast.LENGTH_SHORT).show();
            investigator= (List<Investigator>) bundle.getSerializable("Inv");
        }
        invName.setText(investigator.get(0).getNombre() + " " + investigator.get(0).getApePaterno() + " " + investigator.get(0).getApeMaterno());
        invMail.setText(investigator.get(0).getCorreo());
        invTel.setText(investigator.get(0).getCelular());
        invEsp.setText(investigator.get(0).getFaculty().getNombre());

        return view;
    }


}
