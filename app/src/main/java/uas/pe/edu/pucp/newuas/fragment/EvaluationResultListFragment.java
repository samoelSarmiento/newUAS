package uas.pe.edu.pucp.newuas.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.Serializable;
import java.util.List;

import android.widget.AdapterView;
import android.widget.ListView;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.adapter.EvaluationAdapter;
import uas.pe.edu.pucp.newuas.adapter.EvaluationNameStateAdapter;
import uas.pe.edu.pucp.newuas.controller.EvaluationsController;
import uas.pe.edu.pucp.newuas.controller.MeasurePeriodController;
import uas.pe.edu.pucp.newuas.model.AppointInformationRegisterTuto;
import uas.pe.edu.pucp.newuas.model.Evaluation;
import uas.pe.edu.pucp.newuas.model.Period;

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
            final Context context = getActivity();
            adapter = new EvaluationAdapter(context, list);
            lvEvaluations.setAdapter(adapter);

            lvEvaluations.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Evaluation per = adapter.getItem(position);
                    Log.d("evaluation", per.getId() + "");
                    Bundle eva = new Bundle();
                    eva.putSerializable("Evaluacion", per);
                    EvaluationFragment fragment = new EvaluationFragment();
                    fragment.setArguments(eva);
                    getActivity().getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container, fragment).commit();
                }
            });
        }
        return view;
    }
}
