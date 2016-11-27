package uas.pe.edu.pucp.newuas.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import uas.pe.edu.pucp.newuas.R;

/**
 * Created by Andree on 27/11/2016.
 */

public class EmptyListFragment extends Fragment {

    public EmptyListFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_empty_list_message, container, false);
        //getActivity().setTitle("Proyectos > Entregables");
        return view;
    }
}
