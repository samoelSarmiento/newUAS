package uas.pe.edu.pucp.newuas.fragment;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.adapter.SupFreeHoursSpinerAdapter;
import uas.pe.edu.pucp.newuas.controller.PSPController;
import uas.pe.edu.pucp.newuas.model.MyToast;
import uas.pe.edu.pucp.newuas.model.PSPFreeHour;


public class PSP_StudentNewMeetingSup extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

   private Button btnCancel, btnRegister;

    private ArrayList<PSPFreeHour> freeHours;
    Spinner spinner;

    public PSP_StudentNewMeetingSup() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PSP_StudentNewMeetingSup.
     */
    // TODO: Rename and change types and number of parameters
    public static PSP_StudentNewMeetingSup newInstance(String param1, String param2) {
        PSP_StudentNewMeetingSup fragment = new PSP_StudentNewMeetingSup();
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
            freeHours = (ArrayList<PSPFreeHour>)getArguments().getSerializable("freeHours");

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_psp__student_new_meeting_sup, container, false);
        btnRegister = (Button)view.findViewById(R.id.btn_psp_student_new_meeting_register);
        btnCancel = (Button)view.findViewById(R.id.btn_psp_student_new_meeting_cancel);


        btnCancel.setOnClickListener(this);
        btnRegister.setOnClickListener(this);

        spinner = (Spinner) view.findViewById(R.id.cmb_psp_student_new_meeting);

        SupFreeHoursSpinerAdapter adapter = new SupFreeHoursSpinerAdapter(getActivity(), android.R.layout.simple_spinner_item,freeHours);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        return view;
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_psp_student_new_meeting_register:


                int position =        spinner.getSelectedItemPosition();
                position = position -1;
                if(position >= 0){

                    PSPFreeHour hour = freeHours.get(position);
                    PSPController controller =  new PSPController();
                    controller.storeMeetingByStudent(getActivity(),hour);
                }else {
                    MyToast.makeText(getActivity(),"Seleccione un horario disponible valido",Toast.LENGTH_SHORT,MyToast.errorAlert).show();


                }

                break;

            case R.id.btn_psp_student_new_meeting_cancel:

                getFragmentManager().popBackStack();
                break;




        }
    }
}
