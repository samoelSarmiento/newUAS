package uas.pe.edu.pucp.newuas.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.adapter.CourseAdapter;
import uas.pe.edu.pucp.newuas.model.CourseResponse;

public class MyCoursesFragment extends Fragment {

    ListView lvCourses;


    public MyCoursesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_courses, container, false);
        Bundle bundle = getArguments();
        if (bundle != null) {
            List<CourseResponse> items = (List<CourseResponse>) bundle.getSerializable("courses");
            lvCourses = (ListView) view.findViewById(R.id.lvCourses);
            if (items == null || items.size() == 0) {
                lvCourses.setVisibility(View.GONE);
                TextView tvNoCourses = (TextView) view.findViewById(R.id.tvNoCourses);
                tvNoCourses.setVisibility(View.VISIBLE);
            } else {
                CourseAdapter adapter = new CourseAdapter(items, getActivity());
                lvCourses.setAdapter(adapter);
            }
        }
        return view;
    }

}
