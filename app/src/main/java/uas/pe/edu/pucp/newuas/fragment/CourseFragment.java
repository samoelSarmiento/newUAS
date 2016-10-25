package uas.pe.edu.pucp.newuas.fragment;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.controller.SpecialtyController;
import uas.pe.edu.pucp.newuas.model.CourseResponse;
import uas.pe.edu.pucp.newuas.model.Schedules;
import uas.pe.edu.pucp.newuas.model.Semester;
import uas.pe.edu.pucp.newuas.model.Specialty;
import uas.pe.edu.pucp.newuas.model.Teacher;

public class CourseFragment extends Fragment {

    public CourseFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_course, container, false);
        TextView tvValueCurso = (TextView) view.findViewById(R.id.tvValueCourse);
        ListView lvTeacher = (ListView) view.findViewById(R.id.lvTeacher);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            String course = bundle.getString("Course");
            Gson gson = new Gson();
            CourseResponse courseResponse = gson.fromJson(course, CourseResponse.class);
            tvValueCurso.setText(courseResponse.getNombre());
            if (courseResponse.getSchedules() != null) {
                /*//List view de profesores visible
                lvTeacher.setVisibility(View.VISIBLE);
                ArrayList<Schedules> schedules = courseResponse.getSchedules();
                Set<Teacher> teachers = new HashSet<>();
                //Para cada horario
                for (Schedules schedule : schedules) {
                    //Se saca la lista de profesores
                    List<Teacher> scheTeacherList = schedule.getProfessors();
                    //Se los añade
                    for (Teacher teacher : scheTeacherList)
                        teachers.add(teacher);
                }*/
            }
        }
        return view;
    }

}
