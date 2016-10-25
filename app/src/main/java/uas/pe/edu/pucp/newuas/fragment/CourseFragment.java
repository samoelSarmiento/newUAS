package uas.pe.edu.pucp.newuas.fragment;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.controller.SpecialtyController;
import uas.pe.edu.pucp.newuas.model.CourseResponse;
import uas.pe.edu.pucp.newuas.model.Specialty;

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
        TextView tvValueCiclo = (TextView) view.findViewById(R.id.tvValueCicle);
        TextView tvValueEspecialidad = (TextView) view.findViewById(R.id.tvValueSpecialty);
        TextView tvValueProfesor = (TextView) view.findViewById(R.id.tvValueProfessor);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            String course = bundle.getString("Course");
            Gson gson = new Gson();
            CourseResponse courseResponse = gson.fromJson(course, CourseResponse.class);
            tvValueCurso.setText(courseResponse.getNombre());
            tvValueCiclo.setText("2016-2");
            tvValueProfesor.setText("Profesor");
        }
        return view;
    }

}
