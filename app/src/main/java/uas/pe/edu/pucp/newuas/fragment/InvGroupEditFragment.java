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
import android.widget.Toast;

import java.util.List;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.controller.ImprovementPlanController;
import uas.pe.edu.pucp.newuas.controller.InvGroupController;
import uas.pe.edu.pucp.newuas.controller.InvestigatorController;
import uas.pe.edu.pucp.newuas.model.InvGroups;
import uas.pe.edu.pucp.newuas.model.Investigator;
import uas.pe.edu.pucp.newuas.model.SuggestionRequest;

/**
 * Created by Andree on 26/10/2016.
 */

public class InvGroupEditFragment extends Fragment implements View.OnClickListener{
    private final String regex = "[a-zA-ZñÑáéíóúÁÉÍÓÚ ]+";
    EditText invGroupName, invGroupDesc;
    TextView invGroupEsp;
    Button saveBut,cancelBut;
    InvGroups invG;
    Context context;

    public InvGroupEditFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inv_group_edit, container, false);
        context=getActivity();
        getActivity().setTitle("Grupos de Inv.");

        invGroupName=(EditText) view.findViewById(R.id.invGroupName);
        invGroupDesc=(EditText) view.findViewById(R.id.invGroupDesc);
        invGroupEsp=(TextView) view.findViewById(R.id.invGroupEsp);
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
        InvGroupController invGroupController = new InvGroupController();
        switch (v.getId()){
            case R.id.invGroupSave:

                //Toast.makeText(getActivity(), "entre", Toast.LENGTH_SHORT).show();
                String nom = invGroupName.getText().toString();
                String desc = invGroupDesc.getText().toString();
                if (!nom.isEmpty() && !desc.isEmpty()) {
                    if (nom.matches(regex) && desc.matches(regex)) {
                        InvGroups changedIG = invG;
                        changedIG.setNombre(invGroupName.getText().toString());
                        changedIG.setDescripcion(invGroupDesc.getText().toString());
                        invGroupController.editInvGroup(context,changedIG);
                    } else {
                        Toast.makeText(getActivity(), "Solo se aceptan letras", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getActivity(), "Verifique los campos vacíos", Toast.LENGTH_LONG).show();
                }


                //invGroupController.getInvGroupById(context,invG.getId());
                //Toast.makeText(getActivity(), "entre", Toast.LENGTH_SHORT).show();
                break;

            case R.id.invGroupCancel:
                invGroupController.getInvGroupById(context,invG.getId());
                break;
        }
    }
}
