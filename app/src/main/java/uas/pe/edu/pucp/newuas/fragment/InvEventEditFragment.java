package uas.pe.edu.pucp.newuas.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.controller.InvEventController;
import uas.pe.edu.pucp.newuas.model.InvEvent;
import uas.pe.edu.pucp.newuas.model.InvGroups;

/**
 * Created by Andree on 04/11/2016.
 */

public class InvEventEditFragment extends Fragment implements View.OnClickListener{

    EditText invEvName, invEvDesc,invEvFecha, invEvHora, invEvUbic;
    Button saveBut,cancelBut;
    InvEvent invEv;
    Context context;

    public InvEventEditFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inv_event_edit, container, false);
        context=getActivity();
        getActivity().setTitle("Grupos de Inv. > Eventos");

        invEvName=(EditText) view.findViewById(R.id.invEvName);
        invEvDesc=(EditText) view.findViewById(R.id.invEvDesc);
        invEvFecha=(EditText) view.findViewById(R.id.invEvFecha);
        invEvHora=(EditText) view.findViewById(R.id.invEvHora);
        invEvUbic=(EditText) view.findViewById(R.id.invEvUbic);
        saveBut=(Button) view.findViewById(R.id.invEvSave);
        cancelBut=(Button) view.findViewById(R.id.invEvCancel);

        Bundle bundle = this.getArguments();
        InvEvent invEvent=null;
        if (bundle != null){
            //Toast.makeText(getActivity(), "entre2", Toast.LENGTH_SHORT).show();
            invEvent= (InvEvent) bundle.getSerializable("EditInvEv");
        }
        invEv=invEvent;
        invEvName.setText(invEvent.getNombre());
        invEvDesc.setText(invEvent.getDescripcion());
        invEvFecha.setText(invEvent.getFecha());
        invEvHora.setText(invEvent.getHora());
        invEvUbic.setText(invEvent.getUbicacion());

        saveBut.setOnClickListener(this);
        cancelBut.setOnClickListener(this);


        return view;
    }


    @Override
    public void onClick(View v) {
        InvEventController invEvController = new InvEventController();
        switch (v.getId()){
            case R.id.invEvSave:

                //Toast.makeText(getActivity(), "entre", Toast.LENGTH_SHORT).show();

                InvEvent changedIE = invEv;
                changedIE.setNombre(invEvName.getText().toString());
                changedIE.setDescripcion(invEvDesc.getText().toString());
                changedIE.setFecha(invEvFecha.getText().toString());
                changedIE.setHora(invEvHora.getText().toString());
                changedIE.setUbicacion(invEvUbic.getText().toString());

                invEvController.editInvEv(context,changedIE);
                //invGroupController.getInvGroupById(context,invG.getId());
                //Toast.makeText(getActivity(), "entre", Toast.LENGTH_SHORT).show();
                break;

            case R.id.invEvCancel:
                invEvController.getInvEvById(context,invEv.getId());
                break;
        }
    }
}
