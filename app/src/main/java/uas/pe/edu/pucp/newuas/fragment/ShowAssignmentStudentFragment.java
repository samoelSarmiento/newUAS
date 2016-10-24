package uas.pe.edu.pucp.newuas.fragment;

import android.app.DialogFragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.view.NavigationDrawerTutoria;


public class ShowAssignmentStudentFragment extends Fragment {


    public ShowAssignmentStudentFragment() {
        // Required empty public constructor
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view =   inflater.inflate(R.layout.fragment_show_assignment_student, container, false);
        return view;

    }
}
