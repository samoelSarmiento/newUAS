package uas.pe.edu.pucp.newuas.fragment;

import android.app.DialogFragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import uas.pe.edu.pucp.newuas.R;


public class AcceptAppointmentStudentFragment extends DialogFragment {

    public AcceptAppointmentStudentFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        getDialog().setTitle("Confirmación de cita");
        final View view =   inflater.inflate(R.layout.fragment_accept_appointment_student, container, false);
        return view;

    }


}
