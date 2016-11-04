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

import java.io.Serializable;
import java.util.ArrayList;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.adapter.PSPStudentsAdapter;
import uas.pe.edu.pucp.newuas.controller.PSPController;
import uas.pe.edu.pucp.newuas.model.PSPListViewAdapter;
import uas.pe.edu.pucp.newuas.model.PSPPhase;
import uas.pe.edu.pucp.newuas.model.Student;

/**

 */
public class PSP_teacherStudentsList extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    ListView lvPSPStudents;

    PSPStudentsAdapter adapter;



    public PSP_teacherStudentsList() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PSP_teacherStudentsList.
     */
    // TODO: Rename and change types and number of parameters
    public static PSP_teacherStudentsList newInstance(String param1, String param2) {
        PSP_teacherStudentsList fragment = new PSP_teacherStudentsList();
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
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_psp_teacher_students_list, container, false);
        lvPSPStudents = (ListView) view.findViewById(R.id.lv_psp_students);


        Bundle bundle =  getArguments();
        if(bundle != null){

            ArrayList<Student> list = (ArrayList<Student>) bundle.getSerializable("PSPStudents");
            adapter = new PSPStudentsAdapter(getActivity(),list);
            lvPSPStudents.setAdapter(adapter);
            lvPSPStudents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                    Student student  =   (Student) adapter.getItem(position);
                    PSPController controller =  new PSPController();
                    controller.getStudentGrades(getActivity(),student);


                }
            });

        }


        return view;
    }





}
