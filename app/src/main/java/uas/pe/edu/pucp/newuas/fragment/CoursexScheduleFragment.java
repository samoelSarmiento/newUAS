package uas.pe.edu.pucp.newuas.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import uas.pe.edu.pucp.newuas.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CoursexScheduleFragment extends Fragment {


    public CoursexScheduleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("Horarios");
        View view = inflater.inflate(R.layout.fragment_course_x_schedule, container, false);

        return view;
    }

}
