package uas.pe.edu.pucp.newuas.fragment;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Locale;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.model.PSPPhase;


public class PSP_phaseDetailFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;



    public PSP_phaseDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PSP_phaseDetailFragment.
     */
    public static PSP_phaseDetailFragment newInstance(String param1, String param2) {
        PSP_phaseDetailFragment fragment = new PSP_phaseDetailFragment();
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
        // Inflate the layout for this fragment\
        View view  =  inflater.inflate(R.layout.fragment_psp_phase_detail, container, false);

        Bundle bundle  = getArguments();
        if(bundle != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
            PSPPhase phase = (PSPPhase)bundle.getSerializable("PHASE");
            TextView textView1 = (TextView) view.findViewById(R.id.tv_item_psp_phase_number);
            TextView textView2 = (TextView) view.findViewById(R.id.tv_item_psp_phase_description);
            TextView textView3 = (TextView) view.findViewById(R.id.tv_item_psp_phase_start_date);
            TextView textView4 = (TextView) view.findViewById(R.id.tv_item_psp_phase_end_date);
            textView1.setText(String.valueOf(phase.getNumero()));
            textView2.setText(phase.getDescripcion());
            textView3.setText(simpleDateFormat.format(phase.getFechaInicio()));
            textView4.setText(simpleDateFormat.format(phase.getFechaFin()));

        }

        return view;




    }



}
