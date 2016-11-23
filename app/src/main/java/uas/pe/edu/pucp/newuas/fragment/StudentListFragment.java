package uas.pe.edu.pucp.newuas.fragment;

import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.adapter.StudentAdapter;
import uas.pe.edu.pucp.newuas.controller.SpecialtyController;
import uas.pe.edu.pucp.newuas.model.CoursesEvidences;
import uas.pe.edu.pucp.newuas.model.FileGen;
import uas.pe.edu.pucp.newuas.model.Student;

public class StudentListFragment extends Fragment {

    ListView lvStudents;
    StudentAdapter adapter;

    public StudentListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_student_list, container, false);
        Bundle bundle = getArguments();
        if (bundle != null) {
            List<Student> students = (List<Student>) bundle.getSerializable("students");
            final int idCicloAcademico = bundle.getInt("cicloAcademico");
            final int idCurso = bundle.getInt("curso");
            final int idHorario = bundle.getInt("horario");

            if (students != null && !students.isEmpty()) {
                TextView tvNoStudents = (TextView) view.findViewById(R.id.tvNoStudents);
                tvNoStudents.setVisibility(View.GONE);
                lvStudents = (ListView) view.findViewById(R.id.lvStudents);
                lvStudents.setVisibility(View.VISIBLE);
                adapter = new StudentAdapter(students, getActivity());
                lvStudents.setAdapter(adapter);
                lvStudents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Student student = adapter.getItem(position);
                        SpecialtyController controller = new SpecialtyController();
                        controller.getStudentEffort(getActivity(), idCicloAcademico, idCurso, idHorario, student.getIdAlumno());
                    }
                });


            } else {
                TextView tvResults = (TextView) view.findViewById(R.id.tvResults);
                tvResults.setVisibility(View.GONE);
                TextView tvNoStudes = (TextView) view.findViewById(R.id.tvNoStudents);
                tvNoStudes.setVisibility(View.VISIBLE);
            }
            final List<FileGen> coursesEvidences = (List<FileGen>) bundle.getSerializable("evidences");
            Button btEvidence = (Button) view.findViewById(R.id.btEvidence);
            if (coursesEvidences != null && !coursesEvidences.isEmpty()) {
                btEvidence.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Bundle bundle1 = new Bundle();
                        bundle1.putSerializable("evidence", (Serializable) coursesEvidences);
                        CourseEvidenceFragment fragment = new CourseEvidenceFragment();
                        fragment.setArguments(bundle1);
                        getActivity().setTitle("Evidencias del Horario");
                        getActivity().getFragmentManager().beginTransaction()
                                .addToBackStack(null).replace(R.id.fragment_container, fragment).commit();
                    }
                });
            } else {
                TextView tvNoEvidence = (TextView) view.findViewById(R.id.tvNoEvidence);
                tvNoEvidence.setVisibility(View.VISIBLE);
                btEvidence.setVisibility(View.GONE);
            }
        }
        return view;
    }
}
