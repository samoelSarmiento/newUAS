package uas.pe.edu.pucp.newuas.fragment;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.adapter.CoursexTeacherAdapter;
import uas.pe.edu.pucp.newuas.controller.SpecialtyController;
import uas.pe.edu.pucp.newuas.model.CourseResponse;

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
                String nivelAcademico = courseResponse.getNivelAcademico() + "";
                tvValueLevel.setText(nivelAcademico);
                if (courseResponse.getSchedules() != null && courseResponse.getSchedules().size() != 0) {
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
