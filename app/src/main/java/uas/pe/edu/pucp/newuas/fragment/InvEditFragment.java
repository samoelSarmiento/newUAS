package uas.pe.edu.pucp.newuas.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.model.Investigator;

/**
 * Created by Andree on 26/10/2016.
 */

public class InvEditFragment extends Fragment implements View.OnClickListener{

    EditText invName, invMail,invTel,invEsp;
    Button saveBut,cancelBut;
    Investigator inv=null;


    public InvEditFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_investigators_edit, container, false);

        getActivity().setTitle("Investigadores");

        invName=(EditText) view.findViewById(R.id.invName);
        invMail=(EditText) view.findViewById(R.id.invMail);
        invTel=(EditText) view.findViewById(R.id.invTel);
        invEsp=(EditText) view.findViewById(R.id.invEsp);
        saveBut=(Button) view.findViewById(R.id.invSave);
        cancelBut=(Button) view.findViewById(R.id.invCancel);

        Bundle bundle = this.getArguments();

        if (bundle != null){
            //Toast.makeText(getActivity(), "entre2", Toast.LENGTH_SHORT).show();
            inv= (Investigator) bundle.getSerializable("EditInv");
        }

        invName.setText(inv.getNombre() + " " + inv.getApePaterno() + " " + inv.getApeMaterno());
        invMail.setText(inv.getCorreo());
        invTel.setText(inv.getCelular());
        invEsp.setText(inv.getFaculty().getNombre());

        saveBut.setOnClickListener(this);
        cancelBut.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View v) {

    }
}
