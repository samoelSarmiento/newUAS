package uas.pe.edu.pucp.newuas.fragment;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.model.PSPListViewAdapter;
import uas.pe.edu.pucp.newuas.model.PSPStudent;

public class PSP_studentsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    ListView lvPSPStudents;
    ArrayList<PSPStudent> list;
    PSPListViewAdapter studentsAdapter;



    public PSP_studentsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PSP_studentsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PSP_studentsFragment newInstance(String param1, String param2) {
        PSP_studentsFragment fragment = new PSP_studentsFragment();
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
        Log.d("FRAGMENT", "Entra primero");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_psp__students, container, false);
        lvPSPStudents = (ListView) view.findViewById(R.id.lv_psp_students);
        return view;
    }


    @Override
    public void onStart() {
        super.onStart();


        list = new ArrayList<>();

        PSPStudent st1 = new PSPStudent();
        st1.setCodigo(1);
       st1.setNombre("Alumno 1");
        st1.setApellidoPaterno("Profesor 1");

        PSPStudent st2 = new PSPStudent();
       st2.setCodigo(5);
      st2.setNombre("Alumno 2");
        st2.setApellidoPaterno("Profesor 2");


        list.add(st1);
        list.add(st2);

        try{
            studentsAdapter =  new PSPListViewAdapter(list, getActivity());
            lvPSPStudents.setAdapter(studentsAdapter);
        }catch (Exception ex){
            ex.printStackTrace();
        }



    }


}