package uas.pe.edu.pucp.newuas.fragment;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Calendar;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.adapter.DocumentsAdapter;
import uas.pe.edu.pucp.newuas.controller.PSPController;
import uas.pe.edu.pucp.newuas.model.PSPAdapter;
import uas.pe.edu.pucp.newuas.model.PSPDocument;
import uas.pe.edu.pucp.newuas.model.PSPStudent;


public class PSP_documentsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    ListView lvStudents;
    DocumentsAdapter documentsAdapter;
    public PSP_documentsFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragment_psp_documents, container, false);
        getActivity().setTitle("Documentos");
        lvStudents  = (ListView) view.findViewById(R.id.lv_psp_documents);
        Bundle bundle = this.getArguments();
        if (bundle != null){
            ArrayList<PSPStudent> students = (ArrayList<PSPStudent>) bundle.getSerializable("PSPStudent");
            documentsAdapter = new  DocumentsAdapter (getActivity(), students);
            lvStudents.setAdapter(documentsAdapter);
        }
        lvStudents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //    PSPStudent students = (PSPStudent) documentsAdapter.getItem(position);
                PSPController documentsController = new PSPController();
            //  documentsController.getDocumentsByStudent(getActivity(),students.getIdAlumno());
                documentsController.getDocumentsByStudent(getActivity());
            }
        });
        return view ;
    }




}
