package uas.pe.edu.pucp.newuas.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.adapter.ImprovementPlanAdapter;
import uas.pe.edu.pucp.newuas.model.ImprovementPlan;

/**
 * Created by Marshall on 2/11/2016.
 */

public class ImprovementPlanListFragment extends Fragment {


    ListView lvIp;
    ArrayList<ImprovementPlan> list;

    ImprovementPlanAdapter ipAdapter;

    public ImprovementPlanListFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_improvement_plan_list,container,false);

        lvIp = (ListView) view.findViewById(R.id.lvIp);
        Bundle bundle = this.getArguments();
        if (bundle!=null){
            ArrayList<ImprovementPlan> ips = (ArrayList<ImprovementPlan>) bundle.getSerializable("ImprovementPlans");
            list = ips;
            Context context = getActivity();
            ipAdapter = new ImprovementPlanAdapter(context, list);
            lvIp.setAdapter(ipAdapter);

            //onclick




        }

        return view;

        //return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }
}
