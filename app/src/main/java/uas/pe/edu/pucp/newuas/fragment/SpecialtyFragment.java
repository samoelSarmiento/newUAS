package uas.pe.edu.pucp.newuas.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import uas.pe.edu.pucp.newuas.R;

/**
 * Created by Marshall on 20/10/2016.
 */

public class SpecialtyFragment extends Fragment{
    public SpecialtyFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        getActivity().setTitle("Especialidad");

        View view = inflater.inflate(R.layout.fragment_specialty, container, false);

        TextView tvsplabel = (TextView) view.findViewById(R.id.tvSpecialtyLabel);
        TextView tvspcode = (TextView) view.findViewById(R.id.tvSpecialtyCode);
        TextView tvspcoord = (TextView) view.findViewById(R.id.tvSpecialtyCoord);
        TextView tvspdesc = (TextView) view.findViewById(R.id.tvSpecialtyDesc);


        Bundle bundle = this.getArguments();
        if (bundle != null){
            String str = bundle.getString("Specialty");
            Gson gson = new Gson();
            JsonParser jp = new JsonParser();
            JsonObject json = jp.parse(str).getAsJsonObject();
            tvsplabel.setText(json.get("Nombre").toString());
            Log.d("TAG",json.get("Nombre").toString());
            //Log.d("TAG",json.getAsString());
        }


        return view;

    }


}
