package uas.pe.edu.pucp.newuas.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.adapter.PSPSupMeetingStudentsAdapter;
import uas.pe.edu.pucp.newuas.controller.PSPController;
import uas.pe.edu.pucp.newuas.model.Student;


public class PSP_SupMeetingsStudentsFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    PSPSupMeetingStudentsAdapter adapter;
    Button btnNewMeeting;

    public PSP_SupMeetingsStudentsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PSP_SupMeetingsStudentsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PSP_SupMeetingsStudentsFragment newInstance(String param1, String param2) {
        PSP_SupMeetingsStudentsFragment fragment = new PSP_SupMeetingsStudentsFragment();
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

        View view = inflater.inflate(R.layout.fragment_psp__sup_meetings_students, container, false);
        final ListView listView = (ListView)view.findViewById(R.id.lv_psp_sup_meeting_students);
        btnNewMeeting = (Button) view.findViewById(R.id.btn_psp_meetings_students_newmeeting);
        btnNewMeeting.setOnClickListener(this);

        Bundle bundle = getArguments();

        if(bundle!= null){

            final ArrayList<Student> lista =   (ArrayList<Student>)bundle.get("PSPStudents");
            adapter  =  new PSPSupMeetingStudentsAdapter(getActivity(),lista);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Student student = (Student) adapter.getItem(position);
                    PSPController controller =  new PSPController();
                    controller.getSupMeetingByStudent(getActivity(),student);


                }
            });

        }



        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btn_psp_meetings_students_newmeeting:

                PSPController controller =  new PSPController();
                controller.getSupStudentsForNewMeeting(getActivity());
               break;



        }
    }
}
