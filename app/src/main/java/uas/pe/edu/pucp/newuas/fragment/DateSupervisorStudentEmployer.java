package uas.pe.edu.pucp.newuas.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView;

import java.io.Serializable;
import java.util.ArrayList;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.adapter.DatesSuperEmployerAdapter;
import uas.pe.edu.pucp.newuas.adapter.PSPDocumentsAdapter;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.controller.PSPControllerJ;
import uas.pe.edu.pucp.newuas.controller.TutStudentController;
import uas.pe.edu.pucp.newuas.datapersistency.RestCon;
import uas.pe.edu.pucp.newuas.datapersistency.RetrofitHelper;
import uas.pe.edu.pucp.newuas.model.Psp_dates_supervisor_employers;
import uas.pe.edu.pucp.newuas.model.Psp_dates_supervisor_employers_get;
import uas.pe.edu.pucp.newuas.model.SingleRow;
import uas.pe.edu.pucp.newuas.model.Student;
import uas.pe.edu.pucp.newuas.view.NavigationDrawerTutoriaTutor;

public class DateSupervisorStudentEmployer extends Fragment {

    ListView listDates;
    DatesSuperEmployerAdapter adapter;
    public static ArrayList<Psp_dates_supervisor_employers_get> datesSupEmp = new  ArrayList<Psp_dates_supervisor_employers_get> ();
    Button newAppointment;
    ImageButton btnAceptar;
    public static ArrayList<SingleRow> list;

    public DateSupervisorStudentEmployer() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_date_supervisor_student_employer, container, false);

        getActivity().setTitle("Citas con Jefes");
        listDates  = (ListView) view.findViewById(R.id.listViewCustom_psp_dates_sup_emp);
        Bundle bundle = this.getArguments();

        if (bundle != null) {
            datesSupEmp  = (ArrayList<Psp_dates_supervisor_employers_get>) bundle.getSerializable("DateSuperEmployerPSP");
            adapter = new DatesSuperEmployerAdapter(getActivity(), datesSupEmp);
            listDates.setAdapter(adapter);
        }

        newAppointment = (Button) view.findViewById(R.id.btnNewAssignment_psp_dates_sup_emp);
        newAppointment.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //((NavigationDrawerTutoria)getActivity()).replaceFragment(new AlumnoNuevaCitaFragment());
                        PSPControllerJ controller = new PSPControllerJ() ;
                        controller.getStudentsForDates(getActivity());
                    }
                }
        );




        return view;
        }

        }
