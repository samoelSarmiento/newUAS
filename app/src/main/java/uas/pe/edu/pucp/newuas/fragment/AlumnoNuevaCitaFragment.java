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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.controller.TutStudentController;
import uas.pe.edu.pucp.newuas.model.AppointInformationRegisterTuto;
import uas.pe.edu.pucp.newuas.model.ScheduleInfoResponse;
import uas.pe.edu.pucp.newuas.model.TUTInfoResponse;
import uas.pe.edu.pucp.newuas.view.LogInActivity;
import uas.pe.edu.pucp.newuas.view.NavigationDrawerTutoria;


public class AlumnoNuevaCitaFragment extends Fragment {


    public String solicitud;
    ImageButton btnCalendar;
    Button btnSolicitar;
    Spinner spinnerHoras, spinnerTemas;
    EditText txtFecha;
    int day, year, month;
    int ndays[] = new int[1];
    private static DatePickerDialog.OnDateSetListener selectorListener;
    //Calendar[] dates = new Calendar[1];
    List<Calendar> dates = new ArrayList<Calendar>();
    Calendar cal1 = Calendar.getInstance();
    Calendar cal2 = Calendar.getInstance();
    Calendar maxTime = Calendar.getInstance();
    //String infoSolicitar = "Está a punto de confirmar una cita con su tutor para el 09/11/2016 a las 10:00  \n ¿Desea continuar?";
    public static List<ScheduleInfoResponse> sir ;


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

            Bundle bundle = this.getArguments();
            List<TUTInfoResponse> tutGroup= null;
            if (bundle != null){
                tutGroup= (List<TUTInfoResponse>) bundle.getSerializable("Tutoria");
            }


            ndays[0] = tutGroup.get(0).getNumberDays();
            sir = tutGroup.get(0).getScheduleInfo();
            //sir.get(0).
            Calendar c = Calendar.getInstance();
            year = c.get(Calendar.YEAR);
            month = c.get(Calendar.MONTH);
            day = c.get(Calendar.DAY_OF_MONTH);
            showDate();
            gettingMaxTime();

        /*
            try {
                dates = gettingDisabledDays();
            } catch (ParseException e) {
                e.printStackTrace();
            }
         */

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
                            //Calendar rekt = Calendar.getInstance();
                            dates = obtenerFechasDisponibles(ndays[0],sir);
                            Calendar [] cdates =  dates.toArray(new Calendar[dates.size()]);
                            d.setSelectableDays(cdates);
                            //d.setHighlightedDays(cdates);
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

    public List<Calendar> obtenerFechasDisponibles(int dia, List<ScheduleInfoResponse> listaHorarios){

        List<Calendar> fechas = new ArrayList<Calendar>();
        List<Integer> diaL = new ArrayList<Integer>();
        List<Integer> mesL = new ArrayList<Integer>();
        List<Integer> anhoL = new ArrayList<Integer>();

        int totalSemanas = dia / 7;
        Calendar now = Calendar.getInstance();
        int dayToday = now.get(Calendar.DAY_OF_WEEK);
        if (dayToday == 1 ) dayToday = 7;
        else if (dayToday == 7) dayToday = 6;
        else if (dayToday == 6) dayToday = 5;
        else if (dayToday == 5) dayToday = 4;
        else if (dayToday == 4) dayToday = 3;
        else if (dayToday == 3) dayToday = 2;
        else if (dayToday == 2) dayToday = 1;

        for (int i = 0; i<listaHorarios.size(); i++){
            int dayNeeded =  listaHorarios.get(i).getDia();
            int finalDay = dayToday - dayNeeded;
            if (finalDay > 0 ) {
                Calendar kaka = Calendar.getInstance();
                now = Calendar.getInstance();
                now.add(Calendar.DAY_OF_MONTH, -1 * finalDay);
                diaL.add(now.get(Calendar.DAY_OF_MONTH));
                mesL.add(now.get(Calendar.MONTH));
                anhoL.add(now.get(Calendar.YEAR));
            }
            else{
                finalDay = dayNeeded - dayToday;
                Calendar kaka = Calendar.getInstance();
                now = Calendar.getInstance();
                now.add(Calendar.DAY_OF_MONTH, finalDay);
                diaL.add(now.get(Calendar.DAY_OF_MONTH));
                mesL.add(now.get(Calendar.MONTH));
                anhoL.add(now.get(Calendar.YEAR));
            }
        }

        List<Calendar> calendarArray = new ArrayList<Calendar>();
        for (int i = 0; i< diaL.size(); i++) {
            for (int j = 0; j < totalSemanas; j++) {
                Calendar c1 = new GregorianCalendar(anhoL.get(i), mesL.get(i), diaL.get(i));
                c1.add(Calendar.DAY_OF_YEAR, 7 * j);
                fechas.add(c1);
            }
        }



        return fechas;

    }
}



