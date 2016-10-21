package uas.pe.edu.pucp.newuas.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import uas.pe.edu.pucp.newuas.R;

public class PSP_cycleFragment extends Fragment {

    public PSP_cycleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        getActivity().setTitle("Ciclo");
        return inflater.inflate(R.layout.fragment_psp_cycle, container, false);
    }

}
