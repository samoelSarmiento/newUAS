package uas.pe.edu.pucp.newuas.fragment;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.adapter.CoursexTeacherAdapter;
import uas.pe.edu.pucp.newuas.model.Schedule;

/**
 * A simple {@link Fragment} subclass.
 */
public class CoursexScheduleFragment extends Fragment {

    List<Schedule> list;
    CoursexTeacherAdapter adapter;
    ListView lvSchedules;

    public CoursexScheduleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_course_x_schedule, container, false);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            lvSchedules = (ListView) view.findViewById(R.id.lvSchedules);
            list = (List<Schedule>) bundle.getSerializable("ScheduleList");
            Context context = getActivity();
            adapter = new CoursexTeacherAdapter(list, context);
            lvSchedules.setAdapter(adapter);
        }
        return view;
    }

}
