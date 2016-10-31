package uas.pe.edu.pucp.newuas.fragment;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.adapter.CoursexTeacherAdapter;
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
        TextView tvValueCode = (TextView) view.findViewById(R.id.tvValueCode);
        TextView tvValueLevel = (TextView) view.findViewById(R.id.tvValueLevel);

        Bundle bundle = this.getArguments();


        if (bundle != null) {
            final CourseResponse courseResponse = (CourseResponse) bundle.getSerializable("Course");
            final int idCicloAcademio = bundle.getInt("cicloAcademico");
            if (courseResponse != null) {
                tvValueCurso.setText(courseResponse.getNombre());
                tvValueCode.setText(courseResponse.getCodigo());
                tvValueLevel.setText(courseResponse.getNivelAcademico());
                if (courseResponse.getSchedules() != null) {
                    Button btHorario = (Button) view.findViewById(R.id.btSchedules);
                    btHorario.setVisibility(View.VISIBLE);
                    final Context context = getActivity();
                    btHorario.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            SpecialtyController controller = new SpecialtyController();
                            controller.getCourseSchedules(context, courseResponse.getIdCurso(), idCicloAcademio);
                        }
                    });

                    CoursexTeacherAdapter adapter = new CoursexTeacherAdapter(courseResponse.getSchedules(), context);

                } else {
                    TextView tvNoSchedules = (TextView) view.findViewById(R.id.tvValueSchedule);
                    tvNoSchedules.setVisibility(View.VISIBLE);
                }
            }

        }
        return view;
    }

}
