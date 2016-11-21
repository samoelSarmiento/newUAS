package uas.pe.edu.pucp.newuas.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.controller.TutStudentController;
import uas.pe.edu.pucp.newuas.model.AppointmentRequestMirror;
import uas.pe.edu.pucp.newuas.model.SingleRow;
import uas.pe.edu.pucp.newuas.model.TUTInfoResponse;
import uas.pe.edu.pucp.newuas.view.NavigationDrawerTutoriaTutor;


public class StudentAppointFragment extends Fragment {

    ListView listV;
    Button newAppointment, filterAppoint;
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

        Bundle bundle = this.getArguments();
        AppointmentRequestMirror infoAPIs= null;

        if (bundle != null){
            infoAPIs= (AppointmentRequestMirror) bundle.getSerializable("Tutoria");
        }
        else {
            infoAPIs = new AppointmentRequestMirror(Configuration.LOGIN_USER.getUser().getIdUsuario(),null,null,null,1);
        }

        if (infoAPIs.getCodigo() == 2){
            TutStudentController tsc = new TutStudentController();
            tsc.filterAppointment(getActivity (), view, Configuration.LOGIN_USER.getUser().getIdUsuario(),infoAPIs.getFechaI(), infoAPIs.getFechaF(), infoAPIs.getMotivo());
        }
        else if (infoAPIs.getCodigo() == 1) {
            TutStudentController ts = new TutStudentController();
            ts.getAppointment(getActivity(),view, Configuration.LOGIN_USER.getUser().getIdUsuario());
        }


        newAppointment = (Button) view.findViewById(R.id.btnNewAssignment);
        newAppointment.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TutStudentController ts = new TutStudentController();
                        ts.getInfoSchedule(getActivity(),Configuration.LOGIN_USER.getUser().getIdUsuario());
                    }
                }
        );

        filterAppoint = (Button) view.findViewById(R.id.btnStudentFilterAssignments);

        filterAppoint.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {

                        StudentFilterAppointmentFragment ap = new StudentFilterAppointmentFragment();
                        getActivity().getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container, ap).commit();
                        //((NavigationDrawerTutoriaTutor)getActivity()).showDialogFragment(new AcceptAppointmentStudentFragment());
                    }
                }
        );


        return view;
    }

}
