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
import uas.pe.edu.pucp.newuas.adapter.StudentEffortAdapter;
import uas.pe.edu.pucp.newuas.model.StudentEffort;

public class StudentEffortResultFragment extends Fragment {

    StudentEffortAdapter adapter;

    public StudentEffortResultFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_student_effort_result, container, false);
        Bundle bundle = getArguments();
        if (bundle != null) {
            List<StudentEffort> list = (List<StudentEffort>) bundle.getSerializable("effort");
            ListView lvResults = (ListView) view.findViewById(R.id.lvResults);
            if (list != null && !list.isEmpty()) {
                adapter = new StudentEffortAdapter(getActivity(), list);
                lvResults.setAdapter(adapter);
            } else {
                TextView tvNoCriterio = (TextView) view.findViewById(R.id.tvNoCriterios);
                tvNoCriterio.setVisibility(View.VISIBLE);
                lvResults.setVisibility(View.GONE);
            }
        }
        return view;
    }

}
