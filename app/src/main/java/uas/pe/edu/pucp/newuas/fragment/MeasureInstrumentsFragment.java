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

import java.util.ArrayList;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.adapter.MeasureInstrumentAdapter;
import uas.pe.edu.pucp.newuas.adapter.MeasurePeriodAdapter;
import uas.pe.edu.pucp.newuas.model.MeasureInstrument;
import uas.pe.edu.pucp.newuas.model.Period;

/**
 * Created by Marshall on 24/10/2016.
 */

public class MeasureInstrumentsFragment extends Fragment {

    ListView lvMeaInst;
    ArrayList<MeasureInstrument> list;

    MeasureInstrumentAdapter miAdapter;

    public MeasureInstrumentsFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        getActivity().setTitle("Instrumentos de Medicion");

        View view = inflater.inflate(R.layout.fragment_measureinstruments, container, false);

        ListView lvMeaInst = (ListView) view.findViewById(R.id.lvMeaInst);

        /*

        TextView tvsplabel = (TextView) view.findViewById(R.id.tvSpecialtyLabel);
        TextView tvspcode = (TextView) view.findViewById(R.id.tvSpecialtyCode);
        TextView tvspcoord = (TextView) view.findViewById(R.id.tvSpecialtyCoord);
        TextView tvspdesc = (TextView) view.findViewById(R.id.tvSpecialtyDesc);

        */

        Bundle bundle = this.getArguments();
        if (bundle != null){

            ArrayList<MeasureInstrument> str = (ArrayList<MeasureInstrument>) bundle.getSerializable("MeasureInst");
            list = str;

            /*
            Gson gson = new Gson();
            JsonParser jp = new JsonParser();
            JsonArray json = jp.parse(str).getAsJsonArray();
            Log.d("TAG",json.getAsString());
            Context context = getActivity();
            */
            Context context = getActivity();
            miAdapter = new MeasureInstrumentAdapter(context,list);
            lvMeaInst.setAdapter(miAdapter);

            /*
            lvMeaInst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    MeasureInstrument mi = (MeasureInstrument) miAdapter.getItem(position);
                    Log.d("mi",mi.getIdEspecialidad()+ "");

                    MeasurePeriodViewFragment mpvFragment = new MeasurePeriodViewFragment();

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Period", per);
                    mpvFragment.setArguments(bundle);

                    Context context = getActivity();

                    ((Activity)context).getFragmentManager().beginTransaction().replace(R.id.fragment_container,mpvFragment).commit();
                    ((Activity)context).setTitle("Periodo de Medicion");
                }
            }); */
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
