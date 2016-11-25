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
import java.util.List;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.adapter.PSPStudentGradesAdapter;
import uas.pe.edu.pucp.newuas.controller.PSPController;
import uas.pe.edu.pucp.newuas.model.PSPGrade;
import uas.pe.edu.pucp.newuas.model.PSPNotificationScpreRequest;
import uas.pe.edu.pucp.newuas.model.PSPStudentFinalGrade;

/**

 */
public class PSP_studentGradesDetail extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    PSPStudentGradesAdapter adapter;

    ListView  listView;
    public PSP_studentGradesDetail() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PSP_studentGradesDetail.
     */
    // TODO: Rename and change types and number of parameters
    public static PSP_studentGradesDetail newInstance(String param1, String param2) {
        PSP_studentGradesDetail fragment = new PSP_studentGradesDetail();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment



       View view =  inflater.inflate(R.layout.fragment_psp_student_grades_detail, container, false);

         listView =  (ListView) view.findViewById(R.id.lv_psp_student_grades);






        if(getArguments()!= null){

            Bundle bundle = getArguments();
            ArrayList<PSPStudentFinalGrade> list  =   (ArrayList<PSPStudentFinalGrade>) bundle.getSerializable("FinalScores");


               adapter =  new PSPStudentGradesAdapter(getActivity(), list);
               listView.setAdapter(adapter);





        }


        return view;
    }


}
