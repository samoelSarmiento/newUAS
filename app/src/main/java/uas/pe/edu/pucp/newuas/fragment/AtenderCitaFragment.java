package uas.pe.edu.pucp.newuas.fragment;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import uas.pe.edu.pucp.newuas.R;


public class AtenderCitaFragment extends Fragment {


    public AtenderCitaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_atender_cita, container, false);

        TextView codigoCita = (TextView) view.findViewById(R.id.codigoAtenderCita);
        TextView alumnoCita = (TextView) view.findViewById(R.id.alumnoAtenderCita);
        TextView fechaCita = (TextView) view.findViewById(R.id.fechaAtenderCita);
        TextView horaI = (TextView) view.findViewById(R.id.horaIAtenderCita);
        TextView lugarCita = (TextView) view.findViewById(R.id.lugarAtenderCita);
        TextView extraCita = (TextView) view.findViewById(R.id.extraAtenderCita);
        EditText obsCita = (EditText) view.findViewById(R.id.observacionAtenderCita);

        return view;
    }


}
