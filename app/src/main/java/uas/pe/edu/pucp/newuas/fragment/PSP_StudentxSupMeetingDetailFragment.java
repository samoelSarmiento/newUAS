package uas.pe.edu.pucp.newuas.fragment;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Locale;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.model.PSPMeeting;
import uas.pe.edu.pucp.newuas.model.Student;


public class PSP_StudentxSupMeetingDetailFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters

Button cancel;
PSPMeeting meetings;
    Student student;
    SimpleDateFormat simpleDateFormat;
    public PSP_StudentxSupMeetingDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PSP_StudentxSupMeetingDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PSP_StudentxSupMeetingDetailFragment newInstance(String param1, String param2) {
        PSP_StudentxSupMeetingDetailFragment fragment = new PSP_StudentxSupMeetingDetailFragment();
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
            meetings = (PSPMeeting) getArguments().getSerializable("PSPMeeting");
            student = (Student)getArguments().getSerializable("Student");

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_psp__studentx_sup_meeting_detail, container, false);

        Bundle bundle = getArguments();

        if (bundle!= null){





            TextView number = (TextView) view.findViewById(R.id.tv_psp_student_meeting_number);
            TextView idStudent = (TextView) view.findViewById(R.id.tv_psp_student_meeting_student_id);
            TextView name = (TextView) view.findViewById(R.id.tv_psp_student_meeting_student_name);
            TextView date = (TextView) view.findViewById(R.id.tv_psp_student_meeting_date);
            TextView atHour = (TextView) view.findViewById(R.id.tv_psp_student_meeting_at_hour);
            TextView toHour = (TextView) view.findViewById(R.id.tv_psp_student_meeting_to_hour);
            EditText place = (EditText) view.findViewById(R.id.et_psp_student_meeting_place);
            EditText observation = (EditText)view.findViewById(R.id.et_psp_student_meeting_observations);
            EditText feedback = (EditText)view.findViewById(R.id.et_psp_student_meeting_feedback);



            cancel = (Button)view.findViewById(R.id.btn_psp_student_meeting_detail_cancel);

            simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.US);

            number.setText("" + meetings.getIdMeeting());
            idStudent.setText("" + student.getCodigo());
            name.setText(student.getNombre() + " " + student.getApellidoPaterno() +
                    " " + student.getApellidoMaterno());
            String dateMeeting = simpleDateFormat.format(meetings.getFecha());
            date.setText(dateMeeting);
            atHour.setText(meetings.getHora_inicio());
            toHour.setText(meetings.getHora_fin());

            place.setText(meetings.getLugar());
            observation.setText(meetings.getObservaciones());
            feedback.setText(meetings.getRetroalimentacion());


            cancel.setOnClickListener(this);

        // Inflate the layout for this fragment

    }

        return view;

}

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btn_psp_student_meeting_detail_cancel:
                getFragmentManager().popBackStack();
                break;

        }
    }


}
