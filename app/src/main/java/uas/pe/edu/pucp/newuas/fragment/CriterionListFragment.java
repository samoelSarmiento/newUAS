package uas.pe.edu.pucp.newuas.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.adapter.AspectAdapter;
import uas.pe.edu.pucp.newuas.adapter.CriterionAdapter;
import uas.pe.edu.pucp.newuas.controller.EducationalObjectiveController;
import uas.pe.edu.pucp.newuas.model.Criterion;

/**
 * Created by Marshall on 4/11/2016.
 */

public class CriterionListFragment extends Fragment {

    ListView lvCrits = null;
    CriterionAdapter crAdapter;


    public CriterionListFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getActivity().setTitle("Criterios");
        View view = inflater.inflate(R.layout.fragment_criterion_list, container, false);
        lvCrits = (ListView) view.findViewById(R.id.lvCriterions);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            List<Criterion> list = (List<Criterion>) bundle.getSerializable("crits");
            final List<Criterion> listlev = list;
            Context context = getActivity();
            crAdapter = new CriterionAdapter(context, list);
            lvCrits.setAdapter(crAdapter);

            lvCrits.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    EducationalObjectiveController eoc = new EducationalObjectiveController();
                    eoc.getLevelsofCriterion(getActivity(), listlev.get(position).getIdCriterio());
                }
            });
        }
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }
}
