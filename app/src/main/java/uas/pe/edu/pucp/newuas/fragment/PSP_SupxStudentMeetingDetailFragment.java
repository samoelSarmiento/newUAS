package uas.pe.edu.pucp.newuas.fragment;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.adapter.SpinnerSupxStudentMeetingDetailAdapter;
import uas.pe.edu.pucp.newuas.controller.PSPController;
import uas.pe.edu.pucp.newuas.model.MyToast;
import uas.pe.edu.pucp.newuas.model.PSPMeeting;
import uas.pe.edu.pucp.newuas.model.Status;
import uas.pe.edu.pucp.newuas.model.Student;


public class PSP_SupxStudentMeetingDetailFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private SimpleDateFormat simpleDateFormat;
    Button edit, cancel;
    PSPMeeting meetings;
    Student student;
    EditText place,  observation, feedback;
    Spinner spinner;
    ArrayList<Status> status;




    public PSP_SupxStudentMeetingDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PSP_SupxStudentMeetingDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PSP_SupxStudentMeetingDetailFragment newInstance(String param1, String param2) {
        PSP_SupxStudentMeetingDetailFragment fragment = new PSP_SupxStudentMeetingDetailFragment();
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


        View view = inflater.inflate(R.layout.fragment_psp__supx_student_meeting_detail, container, false);



        Bundle bundle = getArguments();

        if (bundle!= null){

             meetings = (PSPMeeting) bundle.getSerializable("PSPMeeting");
             student = (Student)bundle.getSerializable("Student");
            status = (ArrayList<Status>)bundle.getSerializable("Status");



            TextView number = (TextView) view.findViewById(R.id.tv_psp_sup_meeting_number);
            TextView idStudent = (TextView) view.findViewById(R.id.tv_psp_sup_meeting_student_id);
            TextView name = (TextView) view.findViewById(R.id.tv_psp_sup_meeting_student_name);
            TextView date = (TextView) view.findViewById(R.id.tv_psp_sup_meeting_date);
            TextView atHour = (TextView) view.findViewById(R.id.tv_psp_sup_meeting_at_hour);
            TextView toHour = (TextView) view.findViewById(R.id.tv_psp_sup_meeting_to_hour);
             place = (EditText) view.findViewById(R.id.et_psp_sup_meeting_place);
             observation = (EditText)view.findViewById(R.id.et_psp_sup_meeting_observations);
             feedback = (EditText)view.findViewById(R.id.et_psp_sup_meeting_feedback);
            spinner = (Spinner)view.findViewById(R.id.cmb_psp_sup_meeting_status);


            SpinnerSupxStudentMeetingDetailAdapter adapter =  new SpinnerSupxStudentMeetingDetailAdapter(getActivity(),
                    android.R.layout.simple_spinner_item,status);

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);

            int position =  adapter.getPosition(meetings.getStatus().getDescription());

            spinner.setSelection(position);



            edit = (Button)view.findViewById(R.id.btn_psp_sup_meeting_detail_edit);
            cancel = (Button)view.findViewById(R.id.btn_psp_sup_meeting_detail_cancel);

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


            edit.setOnClickListener(this);
            cancel.setOnClickListener(this);

        }









        // Inflate the layout for this fragment
        return view;
    }


    @Override
    public void onClick(View v) {

        switch(v.getId()){

            case R.id.btn_psp_sup_meeting_detail_edit:

                String etPlace =place.getText().toString();
                String etObservation = observation.getText().toString();
                String etFeedback = feedback.getText().toString();
                String message = "";


                meetings.setLugar(etPlace);
                meetings.setObservaciones(etObservation);
                meetings.setRetroalimentacion(etFeedback);
                int pos =  spinner.getSelectedItemPosition() - 1;
                Log.d("POSITION","" + pos);
                if(pos>= 0)
                    meetings.getStatus().setIdStatus(status.get(pos).getIdStatus());
                else{

                    MyToast.makeText(getActivity(),"No ha seleccionado un estado" , Toast.LENGTH_SHORT, MyToast.errorAlert).show();
                    return;
                }


                PSPController controller = new PSPController();
                controller.updateMeetingDetail(getActivity(),meetings);
                getFragmentManager().popBackStack();


                break;

            case R.id.btn_psp_sup_meeting_detail_cancel:
                getFragmentManager().popBackStack();
                break;


        }


    }
}
