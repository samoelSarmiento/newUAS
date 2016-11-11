package uas.pe.edu.pucp.newuas.fragment;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import uas.pe.edu.pucp.newuas.R;

public class PSP_dates_supervisor extends Fragment {

    LayoutInflater layoutInflater;
    Context context  ;
    Button dateEmployer , dateStudent;
    public PSP_dates_supervisor() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_psp_dates_supervisor, container, false);
        dateEmployer = (Button)view.findViewById(R.id.psp_boton_citas_supervisor_jefe);
        dateStudent = (Button)view.findViewById(R.id.psp_boton_citas_supervisor_alumno);
        dateEmployer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Psp_dates_supervisor_jefe psp = new Psp_dates_supervisor_jefe();
                getFragmentManager().beginTransaction().replace(R.id.fragment_container_psp, psp).commit();
                //    controller.obtenerInforme(getActivity() );

            }
        });

        dateStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PSP_SupStudentNewMeetingFragment supxstudent = new PSP_SupStudentNewMeetingFragment();


                Toast.makeText(getActivity(), "Aqui comienza la cita con el alumno !", Toast.LENGTH_SHORT).show();
            }
        });

        getActivity().setTitle("Tipo de documento");
        return view;
    }



}
