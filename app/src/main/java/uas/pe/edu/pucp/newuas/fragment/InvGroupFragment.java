package uas.pe.edu.pucp.newuas.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import uas.pe.edu.pucp.newuas.R;

/**
 * Created by Andree on 19/10/2016.
 */
public class InvGroupFragment extends Fragment{

    public InvGroupFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        getActivity().setTitle("Grupos de Inv.");
        return inflater.inflate(R.layout.fragment_inv_group, container, false);
    }

}
