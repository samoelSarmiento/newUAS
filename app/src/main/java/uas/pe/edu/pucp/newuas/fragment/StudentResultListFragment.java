package uas.pe.edu.pucp.newuas.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.adapter.StudentResultAdapter;
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
        Bundle bundle = getArguments();
        if (bundle != null) {
            Context context = getActivity();
            List<StudentResult> list = (List<StudentResult>) bundle.getSerializable("studentResult");
            adapter = new StudentResultAdapter(context, list);
            lvStudentResults.setAdapter(adapter);
        }
        return view;
    }

}
