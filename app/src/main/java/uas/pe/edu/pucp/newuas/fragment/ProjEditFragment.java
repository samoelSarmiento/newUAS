package uas.pe.edu.pucp.newuas.fragment;

import android.app.Activity;
import android.app.DatePickerDialog;
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
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.DateFormat;
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
    Button projSave,projCancel,selInit,selFin;
    Projects p;
    Context context;
    int dayI,monthI,yearI,dayF,monthF,yearF;

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
        selInit=(Button)view.findViewById(R.id.selInitDate);
        selFin=(Button)view.findViewById(R.id.selFinDate);

        Bundle bundle = this.getArguments();
        Projects proj=null;
        if (bundle != null){
            //Toast.makeText(getActivity(), "entre2", Toast.LENGTH_SHORT).show();
            proj= (Projects) bundle.getSerializable("EditProj");
        }
        p=proj;
        projName.setText(proj.getNombre());
        projInitDate.setText(proj.getFechaIni());
        projFinDate.setText(proj.getFechaFin());
        String cantEnt="" + proj.getNumEntregables();
        projDeliv.setText(cantEnt);
        projDesc.setText(proj.getDescripcion());

        projSave.setOnClickListener(this);
        projCancel.setOnClickListener(this);
        selInit.setOnClickListener(this);
        selFin.setOnClickListener(this);

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
                DatePickerDialog datepicker = new DatePickerDialog(getActivity(),new DatePickerDialog.OnDateSetListener(){

                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        projInitDate.setText(dayOfMonth + "/" + month + "/" + year);
                    }
                },Calendar.YEAR,Calendar.MONTH,Calendar.DAY_OF_MONTH);//,year,month,day);

                datepicker.setTitle("Fecha Inicial");
                datepicker.show();
                //DatePickerFragment fragment = new DatePickerFragment();
                //fragment.show(getFragmentManager(),"holis");
                break;
            case R.id.selFinDate:

                break;
        }
    }
    /*
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar calendar = new GregorianCalendar(year,month,dayOfMonth);
        setDate(calendar);
    }

    private void setDate(final Calendar calendar){
        final DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
        projInitDate.setText(dateFormat.format(calendar.getTime()));
    }

    public static class DatePickerFragment extends DialogFragment{

        @Override
        public Dialog onCreateDialog (Bundle savedInstanceState){
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            return new DatePickerDialog(getActivity(),(DatePickerDialog.OnDateSetListener)getActivity(),year,month,day);
        }
    }*/
}
