package uas.pe.edu.pucp.newuas.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.controller.ImprovementPlanController;
import uas.pe.edu.pucp.newuas.controller.InvEventController;
import uas.pe.edu.pucp.newuas.model.InvEvent;
import uas.pe.edu.pucp.newuas.model.InvGroups;
import uas.pe.edu.pucp.newuas.model.MyToast;
import uas.pe.edu.pucp.newuas.model.SuggestionRequest;

/**
 * Created by Andree on 04/11/2016.
 */

public class InvEventEditFragment extends Fragment implements View.OnClickListener {

    EditText invEvName, invEvDesc, invEvHora, invEvUbic;
    TextView invEvFecha;
    Button saveBut, cancelBut;
    ImageButton selFecha, selHora;
    InvEvent invEv;
    Context context;
    ImageView invEvImage;
    int day, month, year;
    String day2, month2, year2, dayEv, monthEv, yearEv;
    String hourEv, minuteEv;
    private static DatePickerDialog.OnDateSetListener selectorListener;
    private static TimePickerDialog.OnTimeSetListener timeListener;
    Date date;

    public InvEventEditFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inv_event_edit, container, false);
        context = getActivity();
        getActivity().setTitle("Grupos de Inv. > Eventos");

        invEvName = (EditText) view.findViewById(R.id.invEvName);
        invEvDesc = (EditText) view.findViewById(R.id.invEvDesc);
        invEvFecha = (TextView) view.findViewById(R.id.invEvFecha);
        invEvHora = (EditText) view.findViewById(R.id.invEvHora);
        //invEvMin = (EditText) view.findViewById(R.id.invEvMin);
        invEvUbic = (EditText) view.findViewById(R.id.invEvUbic);
        saveBut = (Button) view.findViewById(R.id.invEvSave);
        cancelBut = (Button) view.findViewById(R.id.invEvCancel);
        selFecha = (ImageButton) view.findViewById(R.id.selFecha);
        invEvImage = (ImageView) view.findViewById(R.id.invEvImage);

        Bundle bundle = this.getArguments();
        InvEvent invEvent = null;
        if (bundle != null) {
            //Toast.makeText(getActivity(), "entre2", Toast.LENGTH_SHORT).show();
            invEvent = (InvEvent) bundle.getSerializable("EditInvEv");
        }
        invEv = invEvent;
        invEvName.setText(invEvent.getNombre());
        invEvDesc.setText(invEvent.getDescripcion());
        invEvFecha.setText(invEvent.getFecha());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        date = new Date();
        try {
            date = format.parse(invEvent.getFecha());

        } catch (ParseException e) {
        }
        //calI.setTime(date);
        dayEv = (String) android.text.format.DateFormat.format("dd", date);
        day = Integer.parseInt(dayEv);
        monthEv = (String) android.text.format.DateFormat.format("MM", date);
        month = Integer.parseInt(monthEv);
        yearEv = (String) android.text.format.DateFormat.format("yyyy", date);
        year = Integer.parseInt(yearEv);

        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date2 = new Date();
        try {
            date2 = format2.parse(invEvent.getHora());

        } catch (ParseException e) {
        }
        hourEv = (String) android.text.format.DateFormat.format("hh", date2);
        //hourEv = Integer.parseInt(hour);
        minuteEv = (String) android.text.format.DateFormat.format("mm", date2);
        //minuteEv = Integer.parseInt(minute);
        day2 = (String) android.text.format.DateFormat.format("dd", date2);
        month2 = (String) android.text.format.DateFormat.format("MM", date2);
        year2 = (String) android.text.format.DateFormat.format("yyyy", date2);


        invEvHora.setText(hourEv + ":" + minuteEv);
        //invEvMin.setText(minute);

        invEvUbic.setText(invEvent.getUbicacion());

        if (invEvent.getImagen() != null)
            Picasso.with(context).load(Configuration.BASE_URL + "/" + invEvent.getImagen()).into(invEvImage);
        else
            Picasso.with(context).load(Configuration.NOPHOTO_URL).into(invEvImage);
        saveBut.setOnClickListener(this);
        cancelBut.setOnClickListener(this);
        selFecha.setOnClickListener(this);

        selectorListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePickerDialog datePickerDialog, int yearEve, int monthEve, int dayEve) {
                day = dayEve;
                month = monthEve + 1;
                year = yearEve;
                String format = "%1$02d";
                String date = year + "-" + String.format(format, (month)) + "-" + String.format(format, day);
                dayEv = String.format(format, day);
                monthEv = String.format(format, (month));
                yearEv = year + "";
                invEvFecha.setText(date);
            }
        };

        timeListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute, int second) {
                hourEv=hourOfDay+"";
                minuteEv=minute+"";
                invEvHora.setText(hourOfDay + ":" + minute);
            }
        };


        return view;
    }


    @Override
    public void onClick(View v) {
        InvEventController invEvController = new InvEventController();
        switch (v.getId()) {
            case R.id.invEvSave:

                //Toast.makeText(getActivity(),invEvName.getText().toString() , Toast.LENGTH_SHORT).show();
                String nom = invEvName.getText().toString();
                String desc = invEvDesc.getText().toString();
                String ubic = invEvUbic.getText().toString();
                /*
                String h = invEvHora.getText().toString();
                hourEv = Integer.parseInt(h);
                String m = invEvMin.getText().toString();
                minuteEv = Integer.parseInt(m);*/

                Date now = new Date();
                //Toast.makeText(getActivity(),now.toString() , Toast.LENGTH_SHORT).show();

                if (!nom.isEmpty() && !desc.isEmpty() && !ubic.isEmpty()){// && !h.isEmpty() && !m.isEmpty()) {
                    /*if (hourEv < 24 && minuteEv < 60) {
                        if (h.length() == 1) h = "0" + h;
                        if (m.length() == 1) m = "0" + m;
*/
                        String fecha = yearEv + "-" + monthEv + "-" + dayEv;// + " " + h + ":" + m + ":00";
                        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
                        Date dateEv = new Date();
                        try {
                            dateEv = format2.parse(fecha);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                        if (dateEv.after(now)) {

                            InvEvent changedIE = invEv;
                            changedIE.setNombre(invEvName.getText().toString());
                            changedIE.setDescripcion(invEvDesc.getText().toString());
                            changedIE.setFecha(invEvFecha.getText().toString());

                            changedIE.setHora(year2 + "-" + month2 + "-" + day2 + " " + hourEv + ":" + minuteEv + ":00");


                            changedIE.setUbicacion(invEvUbic.getText().toString());

                            invEvController.editInvEv(context, changedIE);
                            //invGroupController.getInvGroupById(context,invG.getId());
                            //Toast.makeText(getActivity(), "entre", Toast.LENGTH_SHORT).show();

                        } else {
                            MyToast.makeText(getActivity(), "La fecha debe ser posterior a hoy", Toast.LENGTH_LONG, MyToast.errorAlert).show();
                        }/*
                    } else {
                        MyToast.makeText(getActivity(), "Verifique la hora", Toast.LENGTH_LONG, MyToast.errorAlert).show();
                    }*/

                } else {
                    MyToast.makeText(getActivity(), "Verifique los campos vacíos", Toast.LENGTH_LONG, MyToast.infoAlert).show();
                }

                break;

            case R.id.invEvCancel:
                invEvController.getInvEvById(context, invEv.getId(), true);
                break;
            case R.id.selFecha:
                DatePickerDialog d = DatePickerDialog.newInstance(selectorListener, year, month - 1, day);
                //Calendar c = Calendar.getInstance();
                //d.setMinDate(c);
                d.show(getActivity().getFragmentManager(), "");
                break;
        }
    }
}
