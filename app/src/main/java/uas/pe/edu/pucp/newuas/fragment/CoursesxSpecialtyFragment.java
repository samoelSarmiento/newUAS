package uas.pe.edu.pucp.newuas.fragment;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.adapter.SpecialtyxCoursesAdapter;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.model.CourseResponse;


public class CoursesxSpecialtyFragment extends Fragment {

    List<CourseResponse> list;
    SpecialtyxCoursesAdapter adapter;
    ListView coursesxspecialty;
    public CoursesxSpecialtyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        coursesxspecialty = (ListView)getActivity().findViewById(R.id.lvCourses);
        return inflater.inflate(R.layout.fragment_courses_x_specialty, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        list = Configuration.COURSE_LIST;

        adapter = new SpecialtyxCoursesAdapter(getActivity(),list);
        coursesxspecialty.setAdapter(adapter);
    }
}
