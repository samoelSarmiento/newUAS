package uas.pe.edu.pucp.newuas.fragment;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import android.widget.ListView;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.adapter.EvaluationAdapter;
import uas.pe.edu.pucp.newuas.model.Evaluation;

/**
 * A simple {@link Fragment} subclass.
 */
public class EvaluationResultListFragment extends Fragment {

    ListView lvEvaluations;
    EvaluationAdapter adapter;
    int ipId = 0;

    public EvaluationResultListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_evaluation_result_list, container, false);
        Bundle bundle = getArguments();
        if (bundle != null) {
            List<Evaluation> list = (List<Evaluation>) bundle.getSerializable("evaluation");
            lvEvaluations = (ListView) view.findViewById(R.id.lvEvaluation);
            ipId = bundle.getInt("idIp");
            Context context = getActivity();
            adapter = new EvaluationAdapter(context, list);
            lvEvaluations.setAdapter(adapter);

        }
        return view;
    }
}
