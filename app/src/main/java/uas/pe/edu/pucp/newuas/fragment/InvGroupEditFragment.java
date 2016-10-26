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
import uas.pe.edu.pucp.newuas.model.InvGroups;

/**
 * Created by Andree on 26/10/2016.
 */

public class InvGroupEditFragment extends Fragment implements View.OnClickListener{

    EditText invGroupName, invGroupDesc,invGroupEsp;
    Button saveBut,cancelBut;
    InvGroups invG;

    public InvGroupEditFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inv_group_edit, container, false);

        getActivity().setTitle("Grupos de Inv.");

        invGroupName=(EditText) view.findViewById(R.id.invGroupName);
        invGroupDesc=(EditText) view.findViewById(R.id.invGroupDesc);
        invGroupEsp=(EditText) view.findViewById(R.id.invGroupEsp);
        saveBut=(Button) view.findViewById(R.id.invGroupSave);
        cancelBut=(Button) view.findViewById(R.id.invGroupCancel);

        Bundle bundle = this.getArguments();
        InvGroups invGroup=null;
        if (bundle != null){
            //Toast.makeText(getActivity(), "entre2", Toast.LENGTH_SHORT).show();
            invGroup= (InvGroups) bundle.getSerializable("EditInvGroup");
        }
        invG=invGroup;
        invGroupName.setText(invGroup.getNombre());
        invGroupDesc.setText(invGroup.getDescripcion());
        invGroupEsp.setText(invGroup.getFaculty().getNombre());

        saveBut.setOnClickListener(this);
        cancelBut.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {

    }
}
