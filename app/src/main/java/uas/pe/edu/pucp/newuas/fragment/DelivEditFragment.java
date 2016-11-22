package uas.pe.edu.pucp.newuas.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.controller.DeliverableController;
import uas.pe.edu.pucp.newuas.model.Deliverable;
import uas.pe.edu.pucp.newuas.model.Investigator;

/**
 * Created by Andree on 20/11/2016.
 */

public class DelivEditFragment extends Fragment {

    Context context;
    Deliverable deliv;
    TextView delivName,delivResp,delivFechaIni,delivFechaLim,delivAvance,delivObs;
    ImageButton delivInitBut, delivFinBut;
    Button delivSave,delivCancel;
    int dayI,monthI,yearI,dayF,monthF,yearF;
    //Calendar calI=Calendar.getInstance(),calF=Calendar.getInstance();
    private static DatePickerDialog.OnDateSetListener selectorListener, selectorListener2;
    Date dateI,dateF;

    public DelivEditFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_deliverable_edit, container, false);
        context = getActivity();
        getActivity().setTitle("Proyectos > Entregables");

        delivName= (TextView) view.findViewById(R.id.delivName);
        delivFechaIni=(TextView) view.findViewById(R.id.delivFechaIni);
        delivFechaLim=(TextView) view.findViewById(R.id.delivFechaLim);
        delivAvance=(TextView) view.findViewById(R.id.delivAvance);

        //
        delivResp=(TextView) view.findViewById(R.id.delivResp);
        delivObs=(TextView) view.findViewById(R.id.delivObs);
        //

        delivInitBut=(ImageButton) view.findViewById(R.id.delivInitBut);
        delivFinBut=(ImageButton) view.findViewById(R.id.delivFinBut);
        delivSave=(Button) view.findViewById(R.id.delivSave);
        delivCancel=(Button) view.findViewById(R.id.delivCancel);

        Bundle bundle = this.getArguments();

        if (bundle != null) {
            //Toast.makeText(getActivity(), "entre2", Toast.LENGTH_SHORT).show();
            deliv = (Deliverable) bundle.getSerializable("EditDeliv");
        }

        delivName.setText(deliv.getNombre());
        delivFechaIni.setText(deliv.getFechaInicio());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        dateI=new Date();
        try{
            dateI =format.parse(deliv.getFechaInicio());

        }catch (ParseException e){
        }
        //calI.setTime(date);
        String day = (String) android.text.format.DateFormat.format("dd",dateI);
        dayI=Integer.parseInt(day);
        String month = (String) android.text.format.DateFormat.format("MM",dateI);
        monthI=Integer.parseInt(month);
        String year = (String) android.text.format.DateFormat.format("yyyy",dateI);
        yearI = Integer.parseInt(year);

        delivFechaLim.setText(deliv.getFechaLimite());
        dateF=new Date();
        try{
            dateF =format.parse(deliv.getFechaLimite());
        }catch (ParseException e){
        }
        //calF.setTime(date);
        day = (String) android.text.format.DateFormat.format("dd",dateF);
        dayF=Integer.parseInt(day);
        month = (String) android.text.format.DateFormat.format("MM",dateF);
        monthF=Integer.parseInt(month);
        year = (String) android.text.format.DateFormat.format("yyyy",dateF);
        yearF=Integer.parseInt(year);

        selectorListener =  new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePickerDialog datePickerDialog, int year, int month, int day) {
                dayI = day; monthI = month+1; yearI = year;
                String format = "%1$02d";
                String date = year +  "-" + String.format(format, (month + 1)) + "-" + String.format(format, day);
                delivFechaIni.setText(date);
                SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
                try{
                    dateI =format2.parse(date);
                }catch (ParseException e){
                }
            }
        };

        selectorListener2 =  new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePickerDialog datePickerDialog, int year, int month, int day) {
                dayF = day; monthF = month+1; yearF = year;
                String format = "%1$02d";
                String date = year +  "-" + String.format(format, (month + 1)) + "-" + String.format(format, day);
                delivFechaLim.setText(date);
                SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
                try{
                    dateF =format2.parse(date);
                }catch (ParseException e){
                }
            }
        };


        delivAvance.setText(deliv.getPorcenAvance()+"");

        delivInitBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog d = DatePickerDialog.newInstance(selectorListener, yearI, monthI-1, dayI);
                d.show(getActivity().getFragmentManager(), "");
            }
        });
        delivFinBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog d2 = DatePickerDialog.newInstance(selectorListener2, yearF, monthF-1, dayF);
                d2.show(getActivity().getFragmentManager(), "");
            }
        });
        delivSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Deliverable d = deliv;
                d.setFechaInicio(delivFechaIni.getText().toString());
                d.setFechaLimite(delivFechaLim.getText().toString());

                if(dateF.after(dateI)){
                    DeliverableController deliverableController = new DeliverableController();
                    //Toast.makeText(getActivity(), "Hmm", Toast.LENGTH_LONG).show();
                    deliverableController.editDeliv(context,d);
                }else{
                    Toast.makeText(getActivity(), "Verifique las fechas", Toast.LENGTH_LONG).show();
                }
            }
        });
        delivCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeliverableController deliverableController = new DeliverableController();
                deliverableController.getDelivById(context,deliv.getId());
            }
        });

        return view;
    }

}
