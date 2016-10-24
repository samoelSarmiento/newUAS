package uas.pe.edu.pucp.newuas.fragment;

import android.app.DialogFragment;
import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
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


        return view;

    }

}
