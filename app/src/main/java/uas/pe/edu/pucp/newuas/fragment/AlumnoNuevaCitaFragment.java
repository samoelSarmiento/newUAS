package uas.pe.edu.pucp.newuas.fragment;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.controller.TutStudentController;
import uas.pe.edu.pucp.newuas.view.LogInActivity;
import uas.pe.edu.pucp.newuas.view.NavigationDrawerTutoria;


public class AlumnoNuevaCitaFragment extends Fragment {


    public String solicitud;
    ImageButton btnCalendar;
    Button btnSolicitar;
    Spinner spinnerHoras, spinnerTemas;
    EditText txtFecha;
    int day, year, month;
    private static DatePickerDialog.OnDateSetListener selectorListener;
    Calendar[] dates = new Calendar[2];
    Calendar cal1 = Calendar.getInstance();
    Calendar cal2 = Calendar.getInstance();
    Calendar maxTime = Calendar.getInstance();
    //String infoSolicitar = "Está a punto de confirmar una cita con su tutor para el 09/11/2016 a las 10:00  \n ¿Desea continuar?";



    public AlumnoNuevaCitaFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

            getActivity().setTitle("Tutoría");
            final View view = inflater.inflate(R.layout.fragment_alumno_nueva_cita, container, false);
            txtFecha = (EditText) view.findViewById(R.id.dateText);
            btnSolicitar = (Button) view.findViewById(R.id.buttonSolicitar);
            btnCalendar = (ImageButton) view.findViewById(R.id.btnCalendar);
            spinnerHoras = (Spinner) view.findViewById(R.id.spinnerHora);
            spinnerTemas = (Spinner) view.findViewById(R.id.spinnerTema);

            final String [] valorFecha = new String[1], valorHora = new String[1], valorTema = new String[1];

            Calendar c = Calendar.getInstance();
            year = c.get(Calendar.YEAR);
            month = c.get(Calendar.MONTH);
            day = c.get(Calendar.DAY_OF_MONTH);
            showDate();
            gettingMaxTime();
            try {
                dates = gettingDisabledDays();
            } catch (ParseException e) {
                e.printStackTrace();
            }

            Spinner s = (Spinner) view.findViewById(R.id.spinnerTema);
            s.setAdapter(null);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item, NavigationDrawerTutoria.nameTopic);
            s.setAdapter(adapter);

            valorFecha[0] = txtFecha.getText().toString();
            valorHora[0] = spinnerHoras.getSelectedItem().toString();
            valorTema[0] = spinnerTemas.getSelectedItem().toString();

            selectorListener =  new DatePickerDialog.OnDateSetListener(){
                @Override
                public void onDateSet(DatePickerDialog datePickerDialog, int i, int i1, int i2) {
                    day = i2; month = i1; year = i;
                    String format = "%1$02d";
                    String date = String.format(format, i2) + "/" + String.format(format, (i1 + 1)) + "/" + i;
                    txtFecha.setText(date);
                    valorFecha[0] = date.toString();
                }
            };

            btnCalendar.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            DatePickerDialog d = DatePickerDialog.newInstance(selectorListener, year, month, day);
                            Calendar now = Calendar.getInstance();
                            //Calendar future = now.add(Calendar.DAY_OF_YEAR,);
                            d.setMinDate(now);
                            // d.setMaxDate(maxTime);
                            //d.setDisabledDays(dates);
                            d.show(getActivity().getFragmentManager(), "Datepickerdialog");
                        }
                    }
            );


            btnSolicitar.setOnClickListener(

                    new View.OnClickListener(){
                        @Override

                        public void onClick(View v) {
                            valorTema[0] = spinnerTemas.getSelectedItem().toString();
                            valorHora[0] = spinnerHoras.getSelectedItem().toString();
                            solicitud = "Está a punto de confirmar una cita con su tutor para el " + valorFecha[0] + " a las " + valorHora[0] + "\n ¿Desea continuar?";
                            DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    switch (which) {
                                        case DialogInterface.BUTTON_POSITIVE:
                                            //Borra los shared preferences
                                            //regresa al login
                                            break;

                                        case DialogInterface.BUTTON_NEGATIVE:
                                            //Nada pasa
                                            break;
                                    }
                                }
                            };
                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                            builder.setMessage(solicitud).setNegativeButton("No",  new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                     dialog.cancel();

                                            }
                                 }).setPositiveButton("Si", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                dialog.cancel();
                                                Toast.makeText(getActivity(), "Se ha registrado una nueva cita", Toast.LENGTH_LONG).show();
                                                TutStudentController tsc = new TutStudentController();
                                                tsc.appointmentRequest(getActivity (), Configuration.LOGIN_USER.getUser().getIdUsuario(),valorFecha[0], valorHora[0],valorTema[0]);

                                            }
                                        }
                                    ).show();
                        }
                    }

            );




            return view;
        }

        public void showDate(){
            String format = "%1$02d";
            String fecha =String.format(format,day)+"/"+String.format(format,(month+1))+"/"+year;
            txtFecha.setText(fecha);
        }

    public void gettingMaxTime(){
        String dateStr = day + "/"+ (month+2) + "/" + year;
        SimpleDateFormat curFormater = new SimpleDateFormat("dd/MM/yyyy");
        Date dateObj = null;
        try {
            dateObj = curFormater.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        maxTime.setTime(dateObj);
    }

    public Calendar[] gettingDisabledDays() throws ParseException {

        // cal1.add(Calendar.DAY_OF_WEEK,Calendar.SATURDAY);
        // cal2.add(Calendar.DAY_OF_WEEK,Calendar.SUNDAY);
        // cal1.setFirstDayOfWeek(Calendar.SUNDAY);
        // cal2.setFirstDayOfWeek(Calendar.SUNDAY);
        // cal1.add(Calendar.DAY_OF_WEEK_IN_MONTH,29);
        // cal2.add(Calendar.DAY_OF_YEAR,7);
        // OBTENEMOS EL DIA ACTUAL //

        String dateString = String.format("%d-%d-%d", year, month + 1, day);
        Date date = new SimpleDateFormat("yyyy-M-d").parse(dateString);
        // Then get the day of week from the Date based on specific locale.
        String dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date);
        String day1 = new String ("Monday");
        String day2 = new String ("Tuesday");
        String day3 = new String ("Wednesday");
        String day4 = new String ("Thursday");
        String day5 = new String ("Friday");
        String day6 = new String ("Saturday");
        String day7 = new String ("Sunday");

        if (day1.equals(dayOfWeek)){
            cal1.add(Calendar.DAY_OF_WEEK,5);
            cal2.add(Calendar.DAY_OF_WEEK,6);
        }
        else if (day2.equals(dayOfWeek)){
            cal1.add(Calendar.DAY_OF_WEEK,4);
            cal2.add(Calendar.DAY_OF_WEEK,5);
        }
        else if (day3.equals(dayOfWeek)) {
            cal1.add(Calendar.DAY_OF_WEEK,3);
            cal2.add(Calendar.DAY_OF_WEEK,4);
        }
        else if (day4.equals(dayOfWeek)) {
           //  cal1.add(Calendar.DAY_OF_WEEK,2);
           //  cal2.add(Calendar.DAY_OF_WEEK,3);

            cal1.add(Calendar.DAY_OF_WEEK,9);
            cal2.add(Calendar.DAY_OF_WEEK,10);
        }
        else if (day5.equals(dayOfWeek)){
            cal1.add(Calendar.DAY_OF_WEEK,1);
            cal2.add(Calendar.DAY_OF_WEEK,2);
        }
        else if (day6.equals(dayOfWeek)) {
            cal1.add(Calendar.DAY_OF_WEEK,0);
            cal2.add(Calendar.DAY_OF_WEEK,1);
        }
        else if (day7.equals(dayOfWeek)) {
            cal1.add(Calendar.DAY_OF_WEEK,-1);
            cal2.add(Calendar.DAY_OF_WEEK,0);
        }




        // cal1.add(Calendar.DAY_OF_MONTH,Calendar.SATURDAY);
        //  cal2.add(Calendar.DAY_OF_MONTH,Calendar.SUNDAY);
        //  Log.d("MyTag","" + Calendar.`);
        dates[0] = cal1;
        dates[1] = cal2;
        return dates;
    }


}



