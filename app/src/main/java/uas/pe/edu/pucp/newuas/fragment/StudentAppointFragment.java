package uas.pe.edu.pucp.newuas.fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.controller.TutStudentController;
import uas.pe.edu.pucp.newuas.model.AppointmentAdapter;
import uas.pe.edu.pucp.newuas.model.AppointmentResponse;
import uas.pe.edu.pucp.newuas.model.SingleRow;
import uas.pe.edu.pucp.newuas.view.NavigationDrawerTutoriaTutor;


public class StudentAppointFragment extends Fragment {

    ListView listV;
    Button newAppointment;
    ImageButton btnAceptar;
    public static ArrayList<SingleRow> list;


    public StudentAppointFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View view = inflater.inflate(R.layout.fragment_student_appoint, container, false);

        TutStudentController ts = new TutStudentController();
        ts.getAppointment(getActivity(),view, Configuration.LOGIN_USER.getUser().getIdUsuario());

        newAppointment = (Button) view.findViewById(R.id.btnNewAssignment);
        newAppointment.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //((NavigationDrawerTutoria)getActivity()).replaceFragment(new AlumnoNuevaCitaFragment());
                        Bundle bundle = new Bundle();
                        AlumnoNuevaCitaFragment ap = new AlumnoNuevaCitaFragment();
                        ap.setArguments(bundle);
                        getActivity().getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container, ap).commit();
                    }
                }
        );

        /*
        btnAceptar = (ImageButton)view.findViewById(R.id.icon1SingleRowTuto);
        btnAceptar.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Log.d("xD","XDDDDDDDDDDDDDDDD");
                        ((NavigationDrawerTutoriaTutor)getActivity()).showDialogFragment(new AcceptAppointmentStudentFragment());

                    }
                }


        );
        */

        return view;
    }

}
