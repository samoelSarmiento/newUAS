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
import java.util.List;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.controller.DeliverableController;
import uas.pe.edu.pucp.newuas.model.Deliverable;
import uas.pe.edu.pucp.newuas.model.Investigator;
import uas.pe.edu.pucp.newuas.model.MyToast;
import uas.pe.edu.pucp.newuas.model.StudentInfoResponse;
import uas.pe.edu.pucp.newuas.model.Teacher;

/**
 * Created by Andree on 20/11/2016.
 */

public class DelivEditFragment extends Fragment {

    Context context;
    Deliverable deliv;
    TextView delivName, delivResp, delivFechaIni, delivFechaLim, delivAvance, delivObs;
    ImageButton delivInitBut, delivFinBut;
    Button delivSave, delivCancel;
    int dayI, monthI, yearI, dayF, monthF, yearF;
    //Calendar calI=Calendar.getInstance(),calF=Calendar.getInstance();
    private static DatePickerDialog.OnDateSetListener selectorListener, selectorListener2;
    Date dateI, dateF;

    public DelivEditFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_deliverable_edit, container, false);
        context = getActivity();
        getActivity().setTitle("Proyectos > Entregables");

        delivName = (TextView) view.findViewById(R.id.delivName);
        delivFechaIni = (TextView) view.findViewById(R.id.delivFechaIni);
        delivFechaLim = (TextView) view.findViewById(R.id.delivFechaLim);
        delivAvance = (TextView) view.findViewById(R.id.delivAvance);

        //
        delivResp = (TextView) view.findViewById(R.id.delivResp);
        delivObs = (TextView) view.findViewById(R.id.delivObs);
        //

        delivInitBut = (ImageButton) view.findViewById(R.id.delivInitBut);
        delivFinBut = (ImageButton) view.findViewById(R.id.delivFinBut);
        delivSave = (Button) view.findViewById(R.id.delivSave);
        delivCancel = (Button) view.findViewById(R.id.delivCancel);

        Bundle bundle = this.getArguments();

        if (bundle != null) {
            //Toast.makeText(getActivity(), "entre2", Toast.LENGTH_SHORT).show();
            deliv = (Deliverable) bundle.getSerializable("EditDeliv");
        }

        delivName.setText(deliv.getNombre());
        delivFechaIni.setText(deliv.getFechaInicio());

        List<Investigator> inv = deliv.getInvestigator();
        String resp = "";
        for (int i = 0; i < inv.size(); i++) {
            String nombre = inv.get(i).getNombre() + " " + inv.get(i).getApePaterno() + " " + inv.get(i).getApeMaterno();
            if (i == 0) resp = resp + nombre;
            else resp = resp + "\n" + nombre;
        }

        List<StudentInfoResponse> stud = deliv.getStudent();
        //Toast.makeText(getActivity(), stud.size()+"", Toast.LENGTH_SHORT).show();
        String resp2 = "";
        if (stud != null)
            for (int i = 0; i < stud.size(); i++) {
                String nombre = stud.get(i).getNombre() + " " + stud.get(i).getApePaterno() + " " + stud.get(i).getApeMaterno();
                if (i == 0) resp2 = resp2 + nombre;
                else resp2 = resp2 + "\n" + nombre;
            }

        List<Teacher> teacher = deliv.getTeacher();
        //Toast.makeText(getActivity(), teacher.size()+"", Toast.LENGTH_SHORT).show();
        String resp3 = "";
        if (teacher != null)
            for (int i = 0; i < teacher.size(); i++) {
                String nombre = teacher.get(i).getNombre() + " " + teacher.get(i).getApellidoPaterno() + " " + teacher.get(i).getApellidoMaterno();
                if (i == 0) resp3 = resp3 + nombre;
                else resp3 = resp3 + "\n" + nombre;
            }

        if(stud.size()!=0)resp = resp + "\n" + resp2;

        if (teacher.size()!=0) resp=resp + "\n" + resp3;


        delivResp.setText(resp);



        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        dateI = new Date();
        try {
            dateI = format.parse(deliv.getFechaInicio());

        } catch (ParseException e) {
        }
        //calI.setTime(date);
        String day = (String) android.text.format.DateFormat.format("dd", dateI);
        dayI = Integer.parseInt(day);
        String month = (String) android.text.format.DateFormat.format("MM", dateI);
        monthI = Integer.parseInt(month);
        String year = (String) android.text.format.DateFormat.format("yyyy", dateI);
        yearI = Integer.parseInt(year);

        delivFechaLim.setText(deliv.getFechaLimite());
        dateF = new Date();
        try {
            dateF = format.parse(deliv.getFechaLimite());
        } catch (ParseException e) {
        }
        //calF.setTime(date);
        day = (String) android.text.format.DateFormat.format("dd", dateF);
        dayF = Integer.parseInt(day);
        month = (String) android.text.format.DateFormat.format("MM", dateF);
        monthF = Integer.parseInt(month);
        year = (String) android.text.format.DateFormat.format("yyyy", dateF);
        yearF = Integer.parseInt(year);

        selectorListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePickerDialog datePickerDialog, int year, int month, int day) {
                dayI = day;
                monthI = month + 1;
                yearI = year;
                String format = "%1$02d";
                String date = year + "-" + String.format(format, (month + 1)) + "-" + String.format(format, day);
                delivFechaIni.setText(date);
                SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    dateI = format2.parse(date);
                } catch (ParseException e) {
                }
            }
        };

        selectorListener2 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePickerDialog datePickerDialog, int year, int month, int day) {
                dayF = day;
                monthF = month + 1;
                yearF = year;
                String format = "%1$02d";
                String date = year + "-" + String.format(format, (month + 1)) + "-" + String.format(format, day);
                delivFechaLim.setText(date);
                SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    dateF = format2.parse(date);
                } catch (ParseException e) {
                }
            }
        };


        delivAvance.setText(deliv.getPorcenAvance() + "");

        delivInitBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog d = DatePickerDialog.newInstance(selectorListener, yearI, monthI - 1, dayI);
                d.show(getActivity().getFragmentManager(), "");
            }
        });
        delivFinBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog d2 = DatePickerDialog.newInstance(selectorListener2, yearF, monthF - 1, dayF);
                d2.show(getActivity().getFragmentManager(), "");
            }
        });
        delivSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Deliverable d = deliv;
                d.setFechaInicio(delivFechaIni.getText().toString());
                d.setFechaLimite(delivFechaLim.getText().toString());

                String projFI = d.getProjects().getFechaIni();
                String projFF = d.getProjects().getFechaFin();
                SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
                Date dateFI = new Date();
                Date dateFF = new Date();
                try {
                    dateFI = format2.parse(projFI);
                    dateFF = format2.parse(projFF);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                if (dateF.after(dateI)) {
                    if (dateFF.after(dateF)) {
                        if (dateFI.before(dateI)) {
                            DeliverableController deliverableController = new DeliverableController();
                            //Toast.makeText(getActivity(), "Hmm", Toast.LENGTH_LONG).show();

                            deliverableController.editDeliv(context, d);
                        } else {
                            MyToast.makeText(getActivity(), "Le fecha inicio debe ser posterior a la fecha inicio del proyecto", Toast.LENGTH_LONG, MyToast.infoAlert).show();
                        }
                    } else {
                        MyToast.makeText(getActivity(), "Le fecha límite debe ser anterior a la fecha fin del proyecto", Toast.LENGTH_LONG, MyToast.infoAlert).show();
                    }
                } else {
                    MyToast.makeText(getActivity(), "Verifique las fechas", Toast.LENGTH_LONG, MyToast.infoAlert).show();
                }
            }
        });
        delivCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeliverableController deliverableController = new DeliverableController();
                deliverableController.getDelivById(context, deliv.getId(), true);
            }
        });

        return view;
    }

}
