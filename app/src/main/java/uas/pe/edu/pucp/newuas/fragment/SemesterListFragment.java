package uas.pe.edu.pucp.newuas.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.adapter.MeasureInstrumentAdapter;
import uas.pe.edu.pucp.newuas.adapter.SemesterAdapter;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.controller.SpecialtyController;
import uas.pe.edu.pucp.newuas.model.MeasureInstrument;
import uas.pe.edu.pucp.newuas.model.Semester;

/**
 * Created by Marshall on 25/10/2016.
 */

public class SemesterListFragment extends Fragment {

    ListView lvSemesters;
    ArrayList<Semester> list;

    SemesterAdapter semAdapter;

    public SemesterListFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        getActivity().setTitle("Semestres");
        View view = inflater.inflate(R.layout.fragment_semester_list, container, false);
        lvSemesters = (ListView) view.findViewById(R.id.lvSemester);

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            ArrayList<Semester> str = (ArrayList<Semester>) bundle.getSerializable("Semesters");
            list = str;
            Context context = getActivity();
            semAdapter = new SemesterAdapter(context, list);
            lvSemesters.setAdapter(semAdapter);

            lvSemesters.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Semester sem = (Semester) semAdapter.getItem(position);
                    SpecialtyController sc = new SpecialtyController();
                    Context context = getActivity();
                    if (Configuration.isAdmin()) {
                        sc.getCoursesxSpecialyxCycle(context, Configuration.SPECIALTY.getIdEspecialidad(), sem.getIdCicloAcademico());
                    } else {
                        int idEspecialidad = Configuration.getIdEspecialidad();
                        sc.getCoursesxSpecialyxCycle(context, idEspecialidad, sem.getIdCicloAcademico());
                    }
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
