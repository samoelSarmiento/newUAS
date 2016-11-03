package uas.pe.edu.pucp.newuas.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.adapter.MeasurePeriodAdapter;
import uas.pe.edu.pucp.newuas.controller.MeasurePeriodController;
import uas.pe.edu.pucp.newuas.model.Period;

/**
 * Created by Marshall on 24/10/2016.
 */

public class MeasurePeriodListFragment extends Fragment {

    ListView lvPeriods;
    ArrayList<Period> list;

    MeasurePeriodAdapter mpAdapter;

    public MeasurePeriodListFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_measureperiodlist, container, false);

        ListView lvPeriods = (ListView) view.findViewById(R.id.lvPeriods);

        Bundle bundle = this.getArguments();
        if (bundle != null) {

            ArrayList<Period> str = (ArrayList<Period>) bundle.getSerializable("Periods");
            list = str;
            Context context = getActivity();
            mpAdapter = new MeasurePeriodAdapter(context, list);
            lvPeriods.setAdapter(mpAdapter);

            lvPeriods.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Period per = (Period) mpAdapter.getItem(position);
                    Log.d("periodo", per.getIdEspecialidad() + "");

                    MeasurePeriodController mpc = new MeasurePeriodController();
                    Context context = getActivity();

                    mpc.getMeasurePeriod(context, per.getIdPeriodo());

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
