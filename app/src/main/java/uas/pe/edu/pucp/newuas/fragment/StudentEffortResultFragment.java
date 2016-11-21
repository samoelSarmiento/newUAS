package uas.pe.edu.pucp.newuas.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import uas.pe.edu.pucp.newuas.R;

public class StudentEffortResultFragment extends Fragment {


    public StudentEffortResultFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_student_effort_result, container, false);

        return view;
    }

}
