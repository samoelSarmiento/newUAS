package uas.pe.edu.pucp.newuas.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import uas.pe.edu.pucp.newuas.R;

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
        return inflater.inflate(R.layout.fragment_search_evaluation_query, container, false);
    }

}
