package uas.pe.edu.pucp.newuas.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.controller.PSPControllerJ;
import uas.pe.edu.pucp.newuas.controller.TutStudentController;
import uas.pe.edu.pucp.newuas.model.SingleRow;
import uas.pe.edu.pucp.newuas.view.NavigationDrawerTutoriaTutor;

public class DateSupervisorStudentEmployer extends Fragment {

    ListView listV;
    Button newAppointment;
    ImageButton btnAceptar;
    public static ArrayList<SingleRow> list;

    public DateSupervisorStudentEmployer() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View view = inflater.inflate(R.layout.fragment_date_supervisor_student_employer, container, false);



        TutStudentController ts = new TutStudentController();
        ts.getAppointment(getActivity(),view, Configuration.LOGIN_USER.getUser().getIdUsuario());
        newAppointment = (Button) view.findViewById(R.id.btnNewAssignment_psp_dates_sup_emp);
        newAppointment.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //((NavigationDrawerTutoria)getActivity()).replaceFragment(new AlumnoNuevaCitaFragment());

                            PSPControllerJ controller = new PSPControllerJ() ;
                             controller.getStudentsForDates(getActivity());


                    }
                }
        );


        return view;
    }

}
