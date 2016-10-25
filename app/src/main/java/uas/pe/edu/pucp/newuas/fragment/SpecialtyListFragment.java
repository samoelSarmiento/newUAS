package uas.pe.edu.pucp.newuas.fragment;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.adapter.SpecialtyAdapter;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.model.Specialty;

public class SpecialtyListFragment extends Fragment {

    public ArrayList<Specialty> list;
    SpecialtyAdapter adapter;

    public SpecialtyListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("Especialidades");
        View view = inflater.inflate(R.layout.fragment_specialty_list, container, false);
        // Inflate the layout for this fragment

        ListView lvSpecialties = (ListView) view.findViewById(R.id.lvSpecialties);
        Bundle bundle = getArguments();
        if (bundle != null) {
            list = (ArrayList<Specialty>) bundle.getSerializable("specialties");
            Context context = getActivity();
            adapter = new SpecialtyAdapter(context,list);
            lvSpecialties.setAdapter(adapter);
        }
        return view;
    }

}
