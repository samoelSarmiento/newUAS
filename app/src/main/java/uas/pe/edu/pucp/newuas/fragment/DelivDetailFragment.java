package uas.pe.edu.pucp.newuas.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.model.Deliverable;
import uas.pe.edu.pucp.newuas.model.InvEvent;

/**
 * Created by Andree on 11/11/2016.
 */

public class DelivDetailFragment extends Fragment{

    Context context;
    TextView delivName,delivFechaIni,delivFechaLim,delivAvance;
    Spinner delivVersion;
    EditText delivResp,delivObs;
    ImageButton delivDownload;
    Button delivRegObs,delivEdit;

    public DelivDetailFragment (){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_deliverable_detail, container, false);
        context = getActivity();
        getActivity().setTitle("Proyectos > Entregables");

        delivName= (TextView) view.findViewById(R.id.delivName);
        delivFechaIni=(TextView) view.findViewById(R.id.delivFechaIni);
        delivFechaLim=(TextView) view.findViewById(R.id.delivFechaLim);
        delivAvance=(TextView) view.findViewById(R.id.delivAvance);
        delivVersion=(Spinner) view.findViewById(R.id.delivVersion);
        delivResp=(EditText) view.findViewById(R.id.delivResp);
        delivObs=(EditText) view.findViewById(R.id.delivObs);
        delivDownload=(ImageButton) view.findViewById(R.id.delivDownload);
        delivRegObs=(Button) view.findViewById(R.id.delivRegObs);
        delivEdit=(Button) view.findViewById(R.id.delivEdit);

        Bundle bundle = this.getArguments();
        List<Deliverable> deliverable=null;
        //boolean botonEdit=false;
        if (bundle != null){
            //Toast.makeText(getActivity(), "entre2", Toast.LENGTH_SHORT).show();
            //botonEdit=bundle.getBoolean("BotonEdit");
            deliverable= (List<Deliverable>) bundle.getSerializable("Deliverable");
        }

        delivName.setText(deliverable.get(0).getNombre());
        delivFechaIni.setText(deliverable.get(0).getFechaInicio());
        delivFechaLim.setText(deliverable.get(0).getFechaLimite());
        delivAvance.setText(deliverable.get(0).getPorcenAvance()+"");

        delivRegObs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        delivEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        delivDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return view;
    }
}
