package uas.pe.edu.pucp.newuas.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.view.NavigationDrawerTutoria;


public class MyStudentAppointmentFragment extends Fragment {

    Button newAppointment;
    ImageButton btnInfo, btnAceptar;

    public MyStudentAppointmentFragment() {
        // Required empty public constructor
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view =   inflater.inflate(R.layout.fragment_my_student_appointment, container, false);
        newAppointment = (Button)view.findViewById(R.id.btnNewAssignment);

        newAppointment.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        //((NavigationDrawerTutoria)getActivity()).replaceFragment(new AlumnoNuevaCitaFragment());
                        Bundle bundle = new Bundle();
                        AlumnoNuevaCitaFragment ap = new AlumnoNuevaCitaFragment();
                        ap.setArguments(bundle);
                        getActivity().getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container , ap).commit();
                    }
                }
        );



        return view;

    }

}
