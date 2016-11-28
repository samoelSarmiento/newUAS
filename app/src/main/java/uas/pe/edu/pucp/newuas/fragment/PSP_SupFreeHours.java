package uas.pe.edu.pucp.newuas.fragment;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.adapter.PSPSupFreeHoursAdapter;
import uas.pe.edu.pucp.newuas.controller.PSPController;
import uas.pe.edu.pucp.newuas.model.PSPFreeHour;


public class PSP_SupFreeHours extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ListView listView;
    PSPSupFreeHoursAdapter adapter;
    Button btnRegisterNewFreeHour;

    public PSP_SupFreeHours() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PSP_SupFreeHours.
     */
    // TODO: Rename and change types and number of parameters
    public static PSP_SupFreeHours newInstance(String param1, String param2) {
        PSP_SupFreeHours fragment = new PSP_SupFreeHours();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view  = inflater.inflate(R.layout.fragment_psp__sup_free_hours, container, false);

         listView = (ListView) view.findViewById(R.id.lv_psp_sup_freeHours);
        btnRegisterNewFreeHour  =(Button) view.findViewById(R.id.btn_psp_sup_new_free_hour);

        btnRegisterNewFreeHour.setOnClickListener(this);

        if (getArguments() != null) {
            ArrayList<PSPFreeHour> lista  = ( ArrayList<PSPFreeHour>) getArguments().getSerializable("freeHours");
            adapter =  new PSPSupFreeHoursAdapter(getActivity(),lista);
            listView.setAdapter(adapter);


        }




        return view;
    }

    @Override
    public void onResume() {
        super.onResume();


        Log.d("SUP_FREE_HOURS", "volvi");


        PSPController controller =  new PSPController();
        controller.refreshFreeHours(getActivity(), adapter);





    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btn_psp_sup_new_free_hour:

                PSPController controller = new PSPController();
                controller.createFreehour(getActivity());
                break;


        }
    }
}
