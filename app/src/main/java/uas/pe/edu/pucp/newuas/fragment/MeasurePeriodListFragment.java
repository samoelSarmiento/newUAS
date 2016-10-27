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
import uas.pe.edu.pucp.newuas.model.Period;

/**
 * Created by Marshall on 24/10/2016.
 */

public class MeasurePeriodListFragment extends Fragment {

    ListView lvPeriods;
    ArrayList<Period> list;

    MeasurePeriodAdapter mpAdapter;

    public MeasurePeriodListFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        getActivity().setTitle("Periodos de Medicion");

        View view = inflater.inflate(R.layout.fragment_measureperiodlist, container, false);

        ListView lvPeriods = (ListView) view.findViewById(R.id.lvPeriods);

        /*

        TextView tvsplabel = (TextView) view.findViewById(R.id.tvSpecialtyLabel);
        TextView tvspcode = (TextView) view.findViewById(R.id.tvSpecialtyCode);
        TextView tvspcoord = (TextView) view.findViewById(R.id.tvSpecialtyCoord);
        TextView tvspdesc = (TextView) view.findViewById(R.id.tvSpecialtyDesc);

        */

        Bundle bundle = this.getArguments();
        if (bundle != null){

            ArrayList<Period> str = (ArrayList<Period>) bundle.getSerializable("Periods");
            list = str;

            /*
            Gson gson = new Gson();
            JsonParser jp = new JsonParser();
            JsonArray json = jp.parse(str).getAsJsonArray();
            Log.d("TAG",json.getAsString());
            Context context = getActivity();
            */
            Context context = getActivity();
            mpAdapter = new MeasurePeriodAdapter(context,list);
            lvPeriods.setAdapter(mpAdapter);

            lvPeriods.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Period per = (Period) mpAdapter.getItem(position);
                    Log.d("periodo",per.getIdEspecialidad()+ "");

                    MeasurePeriodViewFragment mpvFragment = new MeasurePeriodViewFragment();

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Period", per);
                    mpvFragment.setArguments(bundle);

                    Context context = getActivity();

                    ((Activity)context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container,mpvFragment).commit();
                    ((Activity)context).setTitle("Periodo de Medicion");
                }
            });
            /*
            tvsplabel.setText(json.get("Nombre").getAsString());
            tvspcode.setText(json.get("Codigo").getAsString());
            JsonObject json2 = json.get("coordinator").getAsJsonObject();
            tvspcoord.setText(json2.get("Nombre").getAsString() + " " + json2.get("ApellidoPaterno").getAsString() + " " + json2.get("ApellidoMaterno").getAsString());
            tvspdesc.setText(json.get("Descripcion").getAsString());
            Log.d("TAG",json.get("Nombre").getAsString());
            //Log.d("TAG",json.getAsString());
            */
        }






        return view;

    }

    @Override
    public void onStart(){
        super.onStart();






    }

}
