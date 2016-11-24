package uas.pe.edu.pucp.newuas.fragment;

import android.app.Fragment;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import uas.pe.edu.pucp.newuas.R;
//import uas.pe.edu.pucp.newuas.adapter.PSPSupDocumentAdapter;
import uas.pe.edu.pucp.newuas.adapter.PSPDocumentsAdapter;
import uas.pe.edu.pucp.newuas.model.Student;


public class PspGetStudentsForDateEmployer extends Fragment {

    ListView lvStudents;
    PSPDocumentsAdapter documentsAdapter;
    static Student studentSelected ;
    public  PspGetStudentsForDateEmployer () {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view  = inflater.inflate(R.layout.fragment_psp_documents, container, false);
        getActivity().setTitle("Selec. al alumno");
        lvStudents  = (ListView) view.findViewById(R.id.psp_studentList);
        Bundle bundle = this.getArguments();
        if (bundle != null){
            ArrayList<Student> students = (ArrayList<Student>) bundle.getSerializable("Students");
            documentsAdapter = new PSPDocumentsAdapter(getActivity(), students);
            lvStudents.setAdapter(documentsAdapter);

        }
        lvStudents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               studentSelected = (Student) documentsAdapter.getItem(position);
               Psp_dates_supervisor_jefe psp = new Psp_dates_supervisor_jefe();
               getFragmentManager().beginTransaction().replace(R.id.fragment_container_psp, psp).commit();
            }
        });
        return view ;
    }
}
