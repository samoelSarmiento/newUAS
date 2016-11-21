package uas.pe.edu.pucp.newuas.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.adapter.CourseEvidenceAdapter;
import uas.pe.edu.pucp.newuas.model.CoursesEvidences;
import uas.pe.edu.pucp.newuas.model.FileGen;

public class CourseEvidenceFragment extends Fragment {

    List<FileGen> items;
    CourseEvidenceAdapter adapter;

    public CourseEvidenceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_course_evidence, container, false);
        Bundle bundle = getArguments();
        if (bundle != null) {
            List<FileGen> list = (List<FileGen>) bundle.getSerializable("evidence");
            adapter = new CourseEvidenceAdapter(list, getActivity());
            ListView lvEvidence = (ListView) view.findViewById(R.id.lvEvidence);
            lvEvidence.setAdapter(adapter);
        }
        return view;
    }

}
