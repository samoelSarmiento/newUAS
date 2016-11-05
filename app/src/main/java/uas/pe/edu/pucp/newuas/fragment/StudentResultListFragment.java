package uas.pe.edu.pucp.newuas.fragment;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.adapter.StudentResultAdapter;
import uas.pe.edu.pucp.newuas.controller.EducationalObjectiveController;
import uas.pe.edu.pucp.newuas.controller.ImprovementPlanController;
import uas.pe.edu.pucp.newuas.model.StudentResult;

public class StudentResultListFragment extends Fragment {

    ListView lvStudentResults;
    StudentResultAdapter adapter;

    public StudentResultListFragment() {
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
        View view = inflater.inflate(R.layout.fragment_student_result_list, container, false);
        lvStudentResults = (ListView) view.findViewById(R.id.lvStudentResult);
        final Bundle bundle = getArguments();
        if (bundle != null) {
            final Context context = getActivity();
            List<StudentResult> list = (List<StudentResult>) bundle.getSerializable("studentResult");
            adapter = new StudentResultAdapter(context, list);
            lvStudentResults.setAdapter(adapter);
            lvStudentResults.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    StudentResult result = adapter.getItem(position);
                    EducationalObjectiveController controller = new EducationalObjectiveController();
                    controller.getStudentResultAspects(context, result.getIdResultadoEstudiantil());
                }
            });
        }
        return view;
    }

}
