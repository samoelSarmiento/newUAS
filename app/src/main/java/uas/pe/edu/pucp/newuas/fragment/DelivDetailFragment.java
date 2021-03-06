package uas.pe.edu.pucp.newuas.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.controller.FileDownloadController;
import uas.pe.edu.pucp.newuas.model.Deliverable;
import uas.pe.edu.pucp.newuas.model.InvDocument;
import uas.pe.edu.pucp.newuas.model.InvEvent;
import uas.pe.edu.pucp.newuas.model.Investigator;
import uas.pe.edu.pucp.newuas.model.Student;
import uas.pe.edu.pucp.newuas.model.StudentInfoResponse;
import uas.pe.edu.pucp.newuas.model.Teacher;
import uas.pe.edu.pucp.newuas.view.NavigationDrawerAcreditacion;

/**
 * Created by Andree on 11/11/2016.
 */

public class DelivDetailFragment extends Fragment implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {

    Context context;
    TextView delivName, delivFechaIni, delivFechaLim, delivAvance, delivObs, delivResp;
    Spinner delivVersion;
    ArrayAdapter<Integer> versionsAdapter;
    ImageButton delivDownload;
    Button delivRegObs, delivEdit;
    Deliverable del;
    ArrayList<Integer> versionesArray;
    List<InvDocument> invDocs;
    InvDocument selectedVersion;
    Boolean editEvAvailability;

    public DelivDetailFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_deliverable_detail, container, false);
        context = getActivity();
        getActivity().setTitle("Proyectos > Entregables");

        delivName = (TextView) view.findViewById(R.id.delivName);
        delivFechaIni = (TextView) view.findViewById(R.id.delivFechaIni);
        delivFechaLim = (TextView) view.findViewById(R.id.delivFechaLim);
        delivAvance = (TextView) view.findViewById(R.id.delivAvance);

        //
        delivVersion = (Spinner) view.findViewById(R.id.delivVersion);
        delivResp = (TextView) view.findViewById(R.id.delivResp);
        delivObs = (TextView) view.findViewById(R.id.delivObs);
        //

        delivDownload = (ImageButton) view.findViewById(R.id.delivDownload);
        delivRegObs = (Button) view.findViewById(R.id.delivRegObs);
        delivEdit = (Button) view.findViewById(R.id.delivEdit);

        Bundle bundle = this.getArguments();
        List<Deliverable> deliverable = null;
        //boolean botonEdit=false;
        if (bundle != null) {
            //Toast.makeText(getActivity(), "entre2", Toast.LENGTH_SHORT).show();
            //botonEdit=bundle.getBoolean("BotonEdit");
            deliverable = (List<Deliverable>) bundle.getSerializable("Deliverable");
            editEvAvailability = bundle.getBoolean("editEvAvailability");
        }
        del = deliverable.get(0);
        delivName.setText(deliverable.get(0).getNombre());
        delivFechaIni.setText(deliverable.get(0).getFechaInicio());
        delivFechaLim.setText(deliverable.get(0).getFechaLimite());
        delivAvance.setText(deliverable.get(0).getPorcenAvance() + "");

        List<InvDocument> versions = del.getInvDocuments();
        if (versions.size() == 0)
            selectedVersion = null;
        else
            selectedVersion = versions.get(0);
        ArrayList<Integer> versiones = new ArrayList<Integer>();

        invDocs = versions;

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

        /*if (resp != null)
            if(resp2!=null) resp = resp + "\n" + resp2;
        else resp = resp2;

        if (resp != null)
            if(resp3!=null) resp = resp + "\n" + resp3;
        else resp = resp3;*/

        for (int i = 0; i < versions.size(); i++)
            versiones.add(versions.get(i).getVersion());

        versionesArray = versiones;

        delivResp.setText(resp);

        //delivVersion
        versionsAdapter = new ArrayAdapter<Integer>(getActivity(), android.R.layout.simple_spinner_item, versionesArray);
        delivVersion.setOnItemSelectedListener(this);
        delivVersion.setAdapter(versionsAdapter);
        //delivObs.setText(versions.get(0).getObservacion());

        delivRegObs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("DelObs", del);
                bundle.putSerializable("InvDoc", selectedVersion);

                DelivObsFragment mpvFragment = new DelivObsFragment();
                mpvFragment.setArguments(bundle);

                Context context = getActivity();
                //Toast.makeText(getActivity(), "entre", Toast.LENGTH_SHORT).show();
                ((Activity) context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container, mpvFragment).commit();
                ((Activity) context).setTitle("Proyectos > Entregables");
            }
        });
        delivEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("EditDeliv", del);
                DelivEditFragment mpvFragment = new DelivEditFragment();
                mpvFragment.setArguments(bundle);

                Context context = getActivity();
                //Toast.makeText(getActivity(), "entre", Toast.LENGTH_SHORT).show();
                ((Activity) context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container, mpvFragment).commit();
                ((Activity) context).setTitle("Proyectos > Entregables");
            }
        });
        delivDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileDownloadController fileDownloadController = new FileDownloadController();
                if (selectedVersion != null) {
                    if (selectedVersion.getRuta() != null)
                        fileDownloadController.downloadFile(context, Configuration.BASE_URL + "/" + selectedVersion.getRuta());
                }
            }
        });
        delivRegObs.setVisibility(View.GONE);

        if(selectedVersion==null) delivDownload.setVisibility(View.GONE);
        //permisos
        if (!editEvAvailability) {
            delivRegObs.setVisibility(View.GONE);
            delivEdit.setVisibility(View.GONE);
        }

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Integer value = Integer.parseInt(delivVersion.getItemAtPosition(position).toString());
        for (int i = 0; i < invDocs.size(); i++) {
            if (invDocs.get(i).getVersion() == value) {
                delivObs.setText(invDocs.get(i).getObservacion());
                selectedVersion = invDocs.get(i);
                if (i == 0) // ultima version
                    if (editEvAvailability) //tenga los permisos
                        delivRegObs.setVisibility(View.VISIBLE);
                    else delivRegObs.setVisibility(View.GONE);
                break;
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
