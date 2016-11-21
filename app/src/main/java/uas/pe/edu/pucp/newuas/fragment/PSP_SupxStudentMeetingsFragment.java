package uas.pe.edu.pucp.newuas.fragment;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.adapter.PSPSupxStudentMeetingAdapter;
import uas.pe.edu.pucp.newuas.model.PSPMeeting;
import uas.pe.edu.pucp.newuas.model.Student;


public class PSP_SupxStudentMeetingsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    PSPSupxStudentMeetingAdapter adapter;


    public PSP_SupxStudentMeetingsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PSP_SupxStudentMeetingsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PSP_SupxStudentMeetingsFragment newInstance(String param1, String param2) {
        PSP_SupxStudentMeetingsFragment fragment = new PSP_SupxStudentMeetingsFragment();
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

        View view =  inflater.inflate(R.layout.fragment_psp__supx_student_meetings, container, false);


        Bundle bundle = getArguments();

        if (bundle!= null) {

            ListView listView =  (ListView) view.findViewById(R.id.lv_psp_sup_student_meetings);
            ArrayList<PSPMeeting> meetings = (ArrayList<PSPMeeting>) bundle.getSerializable("Meetings");
            Log.d("SupxStudent", "" + meetings.size());
            final Student student = (Student) bundle.getSerializable("Student");
            adapter = new PSPSupxStudentMeetingAdapter(getActivity(),meetings, student);

            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    /*
                    PSPMeeting meeting= (PSPMeeting)adapter.getItem(position);
                    Fragment fragment = new PSP_SupxStudentMeetingDetailFragment();
                    Bundle bundle = new Bundle();

                    bundle.putSerializable("PSPMeeting",meeting);
                    bundle.putSerializable("Student", student);
                    fragment.setArguments(bundle);

                    getFragmentManager().beginTransaction().setCustomAnimations(R.animator.enter,R.animator.exit,R.animator.slide_out_right,R.animator.slide_in_right)
                            .replace(R.id.fragment_container_psp,fragment).addToBackStack(null).commit();

                */
                }
            });


        }

            // Inflate the layout for this fragment
        return view;
    }

}
