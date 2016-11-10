package uas.pe.edu.pucp.newuas.fragment;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.controller.TutStudentController;
import uas.pe.edu.pucp.newuas.controller.TutTutorController;
import uas.pe.edu.pucp.newuas.model.SingleRow;
import uas.pe.edu.pucp.newuas.view.NavigationDrawerTutoriaTutor;

public class TutorAppointFragment extends Fragment {

    ListView listV;
    Button newAppointment;
    public static ImageButton btnAceptar;
    public static ArrayList<SingleRow> list;


    public TutorAppointFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View view = inflater.inflate(R.layout.fragment_tutor_appoint, container, false);

        TutTutorController ts = new TutTutorController();
        ts.getAppointment(getActivity(),view, Configuration.LOGIN_USER.getUser().getIdUsuario());

        newAppointment = (Button) view.findViewById(R.id.btnNewAssignmentTuto);
        newAppointment.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Bundle bundle = new Bundle();
                        //AlumnoNuevaCitaFragment ap = new AlumnoNuevaCitaFragment();
                        //ap.setArguments(bundle);
                        //getActivity().getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container, ap).commit();

                        TutTutorController ttc = new TutTutorController();
                        ttc.getAppointInformationTuto(getActivity(),Configuration.LOGIN_USER.getUser().getIdUsuario());
                    }
                }
        );



        return view;
    }

}
