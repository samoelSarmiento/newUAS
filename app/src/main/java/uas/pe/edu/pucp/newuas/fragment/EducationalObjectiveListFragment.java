package uas.pe.edu.pucp.newuas.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.adapter.EducationalObjectiveAdapter;
import uas.pe.edu.pucp.newuas.model.EducationalObjective;

/**
 * Created by Marshall on 31/10/2016.
 */

public class EducationalObjectiveListFragment extends Fragment {

    ListView lvEduObj;
    ArrayList<EducationalObjective> list;
    EducationalObjectiveAdapter eoAdapter;

    public EducationalObjectiveListFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_educational_objective_list, container, false);
        ListView lvEduObj = (ListView) view.findViewById(R.id.lvObjectives);
        final Bundle bundle = this.getArguments();
        if (bundle != null) {
            ArrayList<EducationalObjective> str = (ArrayList<EducationalObjective>) bundle.getSerializable("EducObjs");
            list = str;
            final Context context = getActivity();
            eoAdapter = new EducationalObjectiveAdapter(context, list);
            lvEduObj.setAdapter(eoAdapter);
            lvEduObj.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    EducationalObjective educationalObjective = eoAdapter.getItem(position);
                    Bundle bundleEo = new Bundle();
                    bundleEo.putSerializable("eo", (Serializable) educationalObjective);
                    EducationalObjectiveFragment educationalObjectiveFragment = new EducationalObjectiveFragment();
                    educationalObjectiveFragment.setArguments(bundleEo);
                    ((Activity) context).getFragmentManager()
                            .beginTransaction().addToBackStack(null)
                            .replace(R.id.fragment_container, educationalObjectiveFragment).commit();
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
