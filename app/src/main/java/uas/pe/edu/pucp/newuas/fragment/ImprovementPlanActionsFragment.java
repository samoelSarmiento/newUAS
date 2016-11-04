package uas.pe.edu.pucp.newuas.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.adapter.ActionAdapter;
import uas.pe.edu.pucp.newuas.adapter.ImprovementPlanAdapter;
import uas.pe.edu.pucp.newuas.model.Action;
import uas.pe.edu.pucp.newuas.model.ImprovementPlan;

/**
 * Created by Marshall on 3/11/2016.
 */

public class ImprovementPlanActionsFragment extends Fragment {
    ListView lvAct;
    ArrayList<Action> list;

    ActionAdapter actAdapter;

    public ImprovementPlanActionsFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        getActivity().setTitle("Acciones");

        View view = inflater.inflate(R.layout.fragment_improvement_plan_actions,container,false);

        lvAct = (ListView) view.findViewById(R.id.lvActions);

        Bundle bundle = this.getArguments();
        if(bundle!=null){
            ArrayList<Action> listAct = (ArrayList<Action>) bundle.getSerializable("actions");
            list=listAct;
            Context context = getActivity();
            actAdapter = new ActionAdapter(context,list);
            lvAct.setAdapter(actAdapter);
        }



        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }
}
