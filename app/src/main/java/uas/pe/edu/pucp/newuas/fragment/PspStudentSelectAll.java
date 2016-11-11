package uas.pe.edu.pucp.newuas.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
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

import uas.pe.edu.pucp.newuas.controller.PSPControllerJ;
import uas.pe.edu.pucp.newuas.model.Student;


public class PspStudentSelectAll extends Fragment {

    ListView lvStudents;
    PSPDocumentsAdapter documentsAdapter;
    public static Student studentSelected ;
    public PspStudentSelectAll() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragment_psp_documents, container, false);
        getActivity().setTitle("Seleccione el alumno");
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
                //      Toast.makeText(getActivity(), "Proximamente", Toast.LENGTH_SHORT).show();

                studentSelected = (Student) documentsAdapter.getItem(position);

//una ventana más abierta a partir del studiante seleccionado


                PSPControllerJ controller = new PSPControllerJ();
                controller.getInformationStudent(getActivity() );

              //  pspSelectAllStudentsDetail fragmentCalled = new pspSelectAllStudentsDetail() ;
               //  ( getActivity()).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container_psp,fragmentCalled).commit();

            }
        });
        return view ;

    }


}
