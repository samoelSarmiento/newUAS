package uas.pe.edu.pucp.newuas.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.controller.DeliverableController;
import uas.pe.edu.pucp.newuas.model.Deliverable;
import uas.pe.edu.pucp.newuas.model.InvDocument;
import uas.pe.edu.pucp.newuas.model.Investigator;
import uas.pe.edu.pucp.newuas.model.MyToast;
import uas.pe.edu.pucp.newuas.model.StudentInfoResponse;
import uas.pe.edu.pucp.newuas.model.Teacher;

/**
 * Created by Andree on 21/11/2016.
 */

public class DelivObsFragment extends Fragment {

    Context context;
    TextView delivName, delivFechaIni, delivFechaLim, delivAvance, delivResp, delivVersion;
    EditText delivObs;
    Button delivSave, delivCancel;
    Deliverable del;
    InvDocument selectedVersion;

    public DelivObsFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_deliverable_observation, container, false);
        context = getActivity();
        getActivity().setTitle("Proyectos > Entregables");

        delivName = (TextView) view.findViewById(R.id.delivName);
        delivFechaIni = (TextView) view.findViewById(R.id.delivFechaIni);
        delivFechaLim = (TextView) view.findViewById(R.id.delivFechaLim);
        delivAvance = (TextView) view.findViewById(R.id.delivAvance);
        delivVersion = (TextView) view.findViewById(R.id.delivVersion);
        delivResp = (TextView) view.findViewById(R.id.delivResp);
        delivObs = (EditText) view.findViewById(R.id.delivObs);
        delivSave = (Button) view.findViewById(R.id.delivSave);
        delivCancel = (Button) view.findViewById(R.id.delivCancel);

        Bundle bundle = this.getArguments();
        Deliverable deliverable = null;
        InvDocument invD = null;
        //boolean botonEdit=false;
        if (bundle != null) {
            //Toast.makeText(getActivity(), "entre2", Toast.LENGTH_SHORT).show();
            //botonEdit=bundle.getBoolean("BotonEdit");
            deliverable = (Deliverable) bundle.getSerializable("DelObs");
            invD = (InvDocument) bundle.getSerializable("InvDoc");
        }
        del = deliverable;
        selectedVersion = invD;

        delivName.setText(deliverable.getNombre());
        delivFechaIni.setText(deliverable.getFechaInicio());
        delivFechaLim.setText(deliverable.getFechaLimite());
        delivAvance.setText(deliverable.getPorcenAvance() + "");
        delivVersion.setText(selectedVersion.getVersion() + "");

        List<Investigator> inv = del.getInvestigator();
        String resp = "";
        for (int i = 0; i < inv.size(); i++) {
            String nombre = inv.get(i).getNombre() + " " + inv.get(i).getApePaterno() + " " + inv.get(i).getApeMaterno();
            if (i == 0) resp = resp + nombre;
            else resp = resp + "\n" + nombre;
        }

        List<StudentInfoResponse> stud = del.getStudent();
        //Toast.makeText(getActivity(), stud.size()+"", Toast.LENGTH_SHORT).show();
        String resp2 = "";
        if (stud != null)
            for (int i = 0; i < stud.size(); i++) {
                String nombre = stud.get(i).getNombre() + " " + stud.get(i).getApePaterno() + " " + stud.get(i).getApeMaterno();
                if (i == 0) resp2 = resp2 + nombre;
                else resp2 = resp2 + "\n" + nombre;
            }

        List<Teacher> teacher = del.getTeacher();
        //Toast.makeText(getActivity(), teacher.size()+"", Toast.LENGTH_SHORT).show();
        String resp3 = "";
        if (teacher != null)
            for (int i = 0; i < teacher.size(); i++) {
                String nombre = teacher.get(i).getNombre() + " " + teacher.get(i).getApellidoPaterno() + " " + teacher.get(i).getApellidoMaterno();
                if (i == 0) resp3 = resp3 + nombre;
                else resp3 = resp3 + "\n" + nombre;
            }

        if(stud.size()!=0)resp = resp + "\n" + resp2;

        if (teacher.size()!=0) resp=resp + "\n" + resp3;

        delivResp.setText(resp);


        delivObs.setText(selectedVersion.getObservacion());

        delivSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String obs = delivObs.getText().toString();
                if (!obs.isEmpty()) {
                    InvDocument invDocument = selectedVersion;
                    invDocument.setObservacion(delivObs.getText().toString());
                    DeliverableController deliverableController = new DeliverableController();

                    deliverableController.registerObs(context, invDocument);
                } else {
                    MyToast.makeText(getActivity(), "Verifique los campos vacíos", Toast.LENGTH_LONG, MyToast.infoAlert).show();
                }

            }
        });
        delivCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeliverableController deliverableController = new DeliverableController();
                deliverableController.getDelivById(context, del.getId(), true);
            }
        });

        return view;
    }

}
