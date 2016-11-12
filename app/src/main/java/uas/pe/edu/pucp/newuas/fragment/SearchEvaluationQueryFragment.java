package uas.pe.edu.pucp.newuas.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.controller.EvaluationsController;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchEvaluationQueryFragment extends Fragment {


    public SearchEvaluationQueryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search_evaluation_query, container, false);
        final EditText ename = (EditText)view.findViewById(R.id.evQuery);
        final EditText est = (EditText)view.findViewById(R.id.evst);


        Button btnSearch = (Button) view.findViewById(R.id.invSave);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ename.getText().toString().equals("") || est.getText().toString().equals("")){
                    EvaluationsController controller = new EvaluationsController();
                    controller.getAllEvaluations(getActivity());
                }else{
                    EvaluationsController controller = new EvaluationsController();
                    controller.getAEByF(getActivity(), ename.getText().toString(), Integer.parseInt(est.getText().toString()), 1);
                }

            }
        });
        return view;
    }

}
