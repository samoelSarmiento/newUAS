package uas.pe.edu.pucp.newuas.fragment;

import android.app.Fragment;
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


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PSP_documentsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PSP_documentsFragment newInstance(String param1, String param2) {
        PSP_documentsFragment fragment = new PSP_documentsFragment();
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
    public void onStart() {
        super.onStart();

try {
    list = new ArrayList<>();
/*
    PSPDocument document = new PSPDocument();
    document.setName("Doc_2016-2");
    document.setAuthor("Rafa");
    document.setDate(Calendar.getInstance());
    document.setFormat("Excel");
    list.add(document);
*/




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
