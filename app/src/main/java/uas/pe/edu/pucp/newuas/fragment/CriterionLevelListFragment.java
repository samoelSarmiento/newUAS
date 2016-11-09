package uas.pe.edu.pucp.newuas.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.adapter.CriterionAdapter;
import uas.pe.edu.pucp.newuas.adapter.CriterionLevelAdapter;
import uas.pe.edu.pucp.newuas.model.CriterionLevel;

/**
 * Created by Marshall on 4/11/2016.
 */

public class CriterionLevelListFragment extends Fragment{

    ListView lvCritLevs = null;
    CriterionLevelAdapter crlAdapter;



    public CriterionLevelListFragment() {

    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getActivity().setTitle("Niveles de criterio");
        View view = inflater.inflate(R.layout.fragment_criterion_level_list,container,false);
        lvCritLevs = (ListView) view.findViewById(R.id.lvCritLevs);
        Bundle bundle = this.getArguments();
        if(bundle!=null){
            List<CriterionLevel> list = (List<CriterionLevel>)bundle.getSerializable("critlevs");
            Context context = getActivity();
            crlAdapter = new CriterionLevelAdapter(context,list);
            lvCritLevs.setAdapter(crlAdapter);




        }


        return view;

        //return super.onCreateView(inflater, container, savedInstanceState);
    }
}
