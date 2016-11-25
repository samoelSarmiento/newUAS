package uas.pe.edu.pucp.newuas.fragment;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.adapter.EvaluationAdapter;
import uas.pe.edu.pucp.newuas.adapter.EvaluationNameStateAdapter;
import uas.pe.edu.pucp.newuas.model.Evaluation;

/**
 * A simple {@link Fragment} subclass.
 */
public class EvaluationFragment extends Fragment {
    View lvEvaluations;
    EvaluationNameStateAdapter adapter;
    public EvaluationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_evaluation_result_list, container, false);
        Bundle bundle = getArguments();
        if (bundle != null) {
            Evaluation eva = (Evaluation) bundle.getSerializable("evaluation");


            final Context context = getActivity();
            adapter = new EvaluationNameStateAdapter(context, eva);

        }

        return inflater.inflate(R.layout.fragment_evaluation, container, false);
    }

}
