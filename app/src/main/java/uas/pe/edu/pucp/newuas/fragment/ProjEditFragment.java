package uas.pe.edu.pucp.newuas.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.controller.ProjectController;
import uas.pe.edu.pucp.newuas.model.Projects;

/**
 * Created by Andree on 26/10/2016.
 */

public class ProjEditFragment extends Fragment implements View.OnClickListener{//, DatePickerDialog.OnDateSetListener{

    EditText projName,  projDeliv, projDesc;
    TextView projInitDate,projFinDate;
    Button projSave,projCancel;
    ImageButton selInit,selFin;
    Projects p;
    Context context;
    int dayI,monthI,yearI,dayF,monthF,yearF;
    //Calendar calI=Calendar.getInstance(),calF=Calendar.getInstance();
    private static DatePickerDialog.OnDateSetListener selectorListener, selectorListener2;
    Date date;

    public ProjEditFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_projects_edit, container, false);
        context = getActivity();
        getActivity().setTitle("Proyectos");

        projName=(EditText) view.findViewById(R.id.projName);
        projInitDate=(TextView) view.findViewById(R.id.projInitDate);
        projFinDate=(TextView) view.findViewById(R.id.projFinDate);
        projDeliv=(EditText) view.findViewById(R.id.projDeliv);
        projDesc=(EditText) view.findViewById(R.id.projDesc);
        projSave=(Button) view.findViewById(R.id.projSave);
        projCancel=(Button) view.findViewById(R.id.projCancel);
        selInit=(ImageButton)view.findViewById(R.id.selInitDate);
        selFin=(ImageButton)view.findViewById(R.id.selFinDate);

        Bundle bundle = this.getArguments();
        Projects proj=null;
        if (bundle != null){
            //Toast.makeText(getActivity(), "entre2", Toast.LENGTH_SHORT).show();
            proj= (Projects) bundle.getSerializable("EditProj");
        }
        p=proj;
        projName.setText(proj.getNombre());
        projInitDate.setText(proj.getFechaIni());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        date=new Date();
        try{
            date =format.parse(proj.getFechaIni());

        }catch (ParseException e){
        }
        //calI.setTime(date);
        String day = (String) android.text.format.DateFormat.format("dd",date);
        dayI=Integer.parseInt(day);
        String month = (String) android.text.format.DateFormat.format("MM",date);
        monthI=Integer.parseInt(month);
        String year = (String) android.text.format.DateFormat.format("yyyy",date);
        yearI = Integer.parseInt(year);


        projFinDate.setText(proj.getFechaFin());
        try{
            date =format.parse(proj.getFechaFin());
        }catch (ParseException e){
        }
        //calF.setTime(date);
        day = (String) android.text.format.DateFormat.format("dd",date);
        dayF=Integer.parseInt(day);
        month = (String) android.text.format.DateFormat.format("MM",date);
        monthF=Integer.parseInt(month);
        year = (String) android.text.format.DateFormat.format("yyyy",date);
        yearF=Integer.parseInt(year);


        String cantEnt="" + proj.getNumEntregables();
        projDeliv.setText(cantEnt);
        projDesc.setText(proj.getDescripcion());

        projSave.setOnClickListener(this);
        projCancel.setOnClickListener(this);
        selInit.setOnClickListener(this);
        selFin.setOnClickListener(this);

        selectorListener =  new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePickerDialog datePickerDialog, int year, int month, int day) {
                dayI = day; monthI = month+1; yearI = year;
                String format = "%1$02d";
                String date = year +  "-" + String.format(format, (month + 1)) + "-" + String.format(format, day);
                projInitDate.setText(date);
            }
        };

        selectorListener2 =  new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePickerDialog datePickerDialog, int year, int month, int day) {
                dayF = day; monthF = month+1; yearF = year;
                String format = "%1$02d";
                String date = year +  "-" + String.format(format, (month + 1)) + "-" + String.format(format, day);
                projFinDate.setText(date);
            }
        };

        return view;
    }


    @Override
    public void onClick(View v) {
        ProjectController projectController = new ProjectController();
        switch (v.getId()){
            case R.id.projSave:

                //Toast.makeText(getActivity(), "entre", Toast.LENGTH_SHORT).show();

                Projects changedProj = p;
                changedProj.setNombre(projName.getText().toString());
                changedProj.setDescripcion(projDesc.getText().toString());
                String nEnt=projDeliv.getText().toString();
                Integer cantEnt=Integer.parseInt(nEnt);
                changedProj.setNumEntregables(cantEnt);
                changedProj.setFechaIni(projInitDate.getText().toString());
                changedProj.setFechaFin(projFinDate.getText().toString());
                //Date date = new Date();
                //date.getYear();

                projectController.editProj(context,changedProj);

                //projectController.getProjectById(context,changedProj.getId());
                //Toast.makeText(getActivity(), "entre", Toast.LENGTH_SHORT).show();
                break;

            case R.id.projCancel:
                projectController.getProjectById(context,p.getId());
                break;
            case R.id.selInitDate:
                DatePickerDialog d = DatePickerDialog.newInstance(selectorListener, yearI, monthI-1, dayI);
                d.show(getActivity().getFragmentManager(), "");
                //Toast.makeText(getActivity(), date.toString(), Toast.LENGTH_SHORT).show();
                //Toast.makeText(getActivity(), dayI + " " + monthI + " " + yearI, Toast.LENGTH_SHORT).show();
                /*DatePickerDialog datepicker = new DatePickerDialog(getActivity(),new DatePickerDialog.OnDateSetListener(){

                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        projInitDate.setText(dayOfMonth + "/" + month + "/" + year);
                    }
                },Calendar.YEAR,Calendar.MONTH,Calendar.DAY_OF_MONTH);//,year,month,day);

                datepicker.setTitle("Fecha Inicial");
                datepicker.show();*/
                //DatePickerFragment fragment = new DatePickerFragment();
                //fragment.show(getFragmentManager(),"holis");
                break;
            case R.id.selFinDate:
                DatePickerDialog d2 = DatePickerDialog.newInstance(selectorListener2, yearF, monthF-1, dayF);
                d2.show(getActivity().getFragmentManager(), "");
                break;
        }
    }
}
