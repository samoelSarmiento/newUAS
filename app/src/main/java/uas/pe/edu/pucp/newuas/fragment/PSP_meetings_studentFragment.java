package uas.pe.edu.pucp.newuas.fragment;

import android.app.Fragment;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.adapter.PSPStudentMeetingsAdapter;
import uas.pe.edu.pucp.newuas.controller.PSPController;
import uas.pe.edu.pucp.newuas.model.PSPMeeting;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PSP_meetings_studentFragment} interface
 * to handle interaction events.
 * Use the {@link PSP_meetings_studentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PSP_meetings_studentFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER



    Button btnNewMeeting;
    PSPStudentMeetingsAdapter  adapter;
    ArrayList<PSPMeeting>  meetings;

    public PSP_meetings_studentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PSP_meetings_studentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PSP_meetings_studentFragment newInstance(String param1, String param2) {
        PSP_meetings_studentFragment fragment = new PSP_meetings_studentFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

            meetings = (ArrayList<PSPMeeting>) getArguments().getSerializable("Meetings");

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view  =  inflater.inflate(R.layout.fragment_psp_meetings_student, container, false);


         btnNewMeeting = (Button)view.findViewById(R.id.btn_psp_student_new_meeting);
        btnNewMeeting.setOnClickListener(this);


        if(meetings!= null){
             adapter = new PSPStudentMeetingsAdapter(getActivity(),meetings);

              ListView listView = (ListView) view.findViewById(R.id.lv_psp_student_meetings);
              listView.setAdapter(adapter);


                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            PSPController controller = new PSPController();
                            PSPMeeting meeting =  (PSPMeeting) adapter.getItem(position);
                            controller.getStudentForStudentMeetingDetail(getActivity(),meeting);



                    }
                });
        }


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        PSPController controller = new PSPController();
        controller.refreshStudentMeetings(getActivity(),  adapter);
       

    }

    @Override
    public void onClick(View v) {
       switch(v.getId()){

           case R.id.btn_psp_student_new_meeting:

               PSPController controller =  new PSPController();
               controller.getSupFreeHourForStudent(getActivity());


       }
    }
}
