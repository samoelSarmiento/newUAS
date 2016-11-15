
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
import uas.pe.edu.pucp.newuas.adapter.StudentAdapter;
import uas.pe.edu.pucp.newuas.model.Student;

public class StudentListFragment extends Fragment {

    ListView lvStudents;
    StudentAdapter adapter;

    public StudentListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_student_list, container, false);
        Bundle bundle = getArguments();
        if (bundle != null) {
            List<Student> students = (List<Student>) bundle.getSerializable("students");
            if (!(students == null || students.isEmpty())) {
                TextView tvNoStudents = (TextView) view.findViewById(R.id.tvNoStudents);
                tvNoStudents.setVisibility(View.GONE);
                lvStudents = (ListView) view.findViewById(R.id.lvStudents);
                adapter = new StudentAdapter(students, getActivity());
                lvStudents.setAdapter(adapter);
            }
        }
        return view;
    }

}
