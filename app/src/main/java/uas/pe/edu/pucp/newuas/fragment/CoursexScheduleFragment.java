package uas.pe.edu.pucp.newuas.fragment;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.adapter.CoursexTeacherAdapter;
import uas.pe.edu.pucp.newuas.controller.SpecialtyController;
import uas.pe.edu.pucp.newuas.model.CoursesEvidences;
import uas.pe.edu.pucp.newuas.model.Faculty;
import uas.pe.edu.pucp.newuas.model.FileGen;
import uas.pe.edu.pucp.newuas.model.Schedule;

public class CoursexScheduleFragment extends Fragment {

    List<Schedule> list;
    CoursexTeacherAdapter adapter;
    ListView lvSchedules;

    public CoursexScheduleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_course_x_schedule, container, false);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            final int idCicloAcademico = bundle.getInt("cicloAcademico");
            final int idCurso = bundle.getInt("curso");
            lvSchedules = (ListView) view.findViewById(R.id.lvSchedules);
            list = (List<Schedule>) bundle.getSerializable("ScheduleList");
            Context context = getActivity();
            adapter = new CoursexTeacherAdapter(list, context);
            lvSchedules.setAdapter(adapter);

            lvSchedules.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    List<FileGen> evidences = list.get(position).getCourse_evidences();
                    Log.d("evidences null?", "" + (evidences == null));
                    SpecialtyController controller = new SpecialtyController();
                    controller.getStudentsbySchedule(getActivity(), adapter.getItem(position).getIdHorario(), idCicloAcademico, idCurso, evidences);
                }
            });


        }
        return view;
    }

}
