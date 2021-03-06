package uas.pe.edu.pucp.newuas.fragment;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.KeyListener;
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
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.controller.TutStudentController;
import uas.pe.edu.pucp.newuas.model.AppointInformationRegisterTuto;
import uas.pe.edu.pucp.newuas.model.MyToast;
import uas.pe.edu.pucp.newuas.model.ScheduleInfoResponse;
import uas.pe.edu.pucp.newuas.model.ScheduleMeetingResponse;
import uas.pe.edu.pucp.newuas.model.TUTInfoResponse;
import uas.pe.edu.pucp.newuas.view.LogInActivity;
import uas.pe.edu.pucp.newuas.view.NavigationDrawerTutoria;


public class AlumnoNuevaCitaFragment extends Fragment {


    public String solicitud;
    ImageButton btnCalendar;
    Button btnSolicitar,btnCancelar;
    Spinner spinnerHoras, spinnerTemas;
    EditText txtFecha;
    int day, year, month;
    int duracionCita;
    int ndays[] = new int[1];
    private static DatePickerDialog.OnDateSetListener selectorListener;
    //Calendar[] dates = new Calendar[1];
    List<Calendar> dates = new ArrayList<Calendar>();
    Calendar cal1 = Calendar.getInstance();
    Calendar cal2 = Calendar.getInstance();
    Calendar maxTime = Calendar.getInstance();
    //String infoSolicitar = "Est� a punto de confirmar una cita con su tutor para el 09/11/2016 a las 10:00  \n �Desea continuar?";
    public static List<ScheduleInfoResponse> sir ;
    public static List<ScheduleMeetingResponse> smr ;


    public AlumnoNuevaCitaFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

            getActivity().setTitle("Solicitud de una nueva cita");
            final View view = inflater.inflate(R.layout.fragment_alumno_nueva_cita, container, false);
            txtFecha = (EditText) view.findViewById(R.id.dateText);
            btnSolicitar = (Button) view.findViewById(R.id.buttonSolicitar);
            btnCancelar = (Button) view.findViewById(R.id.buttonCancelar);
            btnCalendar = (ImageButton) view.findViewById(R.id.btnCalendar);
            spinnerHoras = (Spinner) view.findViewById(R.id.spinnerHora);
            spinnerTemas = (Spinner) view.findViewById(R.id.spinnerTema);

            //KeyListener mKeyListener = txtFecha.getKeyListener();
            txtFecha.setKeyListener(null);


            final String [] valorFecha = new String[1], valorHora = new String[1], valorTema = new String[1];

            Bundle bundle = this.getArguments();
            List<TUTInfoResponse> tutGroup= null;
            if (bundle != null){
                tutGroup= (List<TUTInfoResponse>) bundle.getSerializable("Tutoria");
                ndays[0] = tutGroup.get(0).getNumberDays();
                sir = tutGroup.get(0).getScheduleInfo();
                smr = tutGroup.get(0).getScheduleMeeting();
                duracionCita = tutGroup.get(0).getDuracionCita();
                //sir.get(0).
                Calendar c = Calendar.getInstance();
                year = c.get(Calendar.YEAR);
                month = c.get(Calendar.MONTH);
                day = c.get(Calendar.DAY_OF_MONTH);
                //showDate();
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
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, NavigationDrawerTutoria.nameTopic);
                s.setAdapter(adapter);


                valorFecha[0] = txtFecha.getText().toString();
                valorTema[0] = spinnerTemas.getSelectedItem().toString();

                selectorListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePickerDialog datePickerDialog, int i, int i1, int i2) {
                        day = i2;
                        month = i1;
                        year = i;
                        String format = "%1$02d";
                        String date = String.format(format, i2) + "/" + String.format(format, (i1 + 1)) + "/" + i;
                        txtFecha.setText(date);
                        valorFecha[0] = date.toString();

                        Spinner hora = (Spinner) view.findViewById(R.id.spinnerHora);
                        List<String> horasDispo = obtenerHorasDisponible(sir, smr, duracionCita, date.toString());
                        hora.setAdapter(null);
                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, horasDispo);
                        hora.setAdapter(adapter);

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
                                dates = obtenerFechasDisponibles(ndays[0], sir);
                                Calendar[] cdates = dates.toArray(new Calendar[dates.size()]);
                                d.setSelectableDays(cdates);
                                d.show(getActivity().getFragmentManager(), "Datepickerdialog");
                            }
                        }
                );


                btnSolicitar.setOnClickListener(

                        new View.OnClickListener() {
                            @Override

                            public void onClick(View v) {


                                if (txtFecha.getText().toString().matches("") || spinnerHoras.getSelectedItem() == null) {
                                    MyToast.makeText(getActivity(), "Debe rellenar los espacios en blanco!", Toast.LENGTH_LONG, MyToast.infoAlert).show();
                                } else {
                                    valorHora[0] = spinnerHoras.getSelectedItem().toString();
                                    valorTema[0] = spinnerTemas.getSelectedItem().toString();
                                    solicitud = "Está a punto de confirmar una cita con su tutor para el " + valorFecha[0] + " a las " + valorHora[0] + "¿Desea continuar?";
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
                                    builder.setMessage(solicitud).setNegativeButton("No", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();

                                        }
                                    }).setPositiveButton("Si", new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog, int id) {
                                                    dialog.cancel();
                                                    MyToast.makeText(getActivity(), "Se ha solicitado una nueva cita", Toast.LENGTH_LONG, MyToast.checkAlert).show();
                                                    TutStudentController tsc = new TutStudentController();
                                                    tsc.appointmentRequest(getActivity(), Configuration.LOGIN_USER.getUser().getIdUsuario(), valorFecha[0], valorHora[0], valorTema[0], duracionCita);

                                                }
                                            }
                                    ).show();
                                }
                            }
                        }

                );

                btnCancelar.setOnClickListener(

                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                TutStudentController tsc = new TutStudentController();
                                tsc.showTopics(getActivity());
                            }
                        }

                );
            }

            else
                Toast.makeText(getActivity(), "Intentelo nuevamente", Toast.LENGTH_LONG).show();





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

    public List<String> obtenerHorasDisponible(List<ScheduleInfoResponse> sir, List<ScheduleMeetingResponse> smr,int duracionCita, String paramString)
    {

        List<String> horaInicio = new ArrayList<String>();

        int dia = Integer.parseInt(paramString.substring(0, 2));
        int mes = Integer.parseInt(paramString.substring(3, 5));
        int anho = Integer.parseInt(paramString.substring(6, 10));
        Calendar c = new GregorianCalendar(anho, mes - 1, dia);
        int dayToday = c.get(Calendar.DAY_OF_WEEK);
        if (dayToday == 1 ) dayToday = 7;
        else if (dayToday == 7) dayToday = 6;
        else if (dayToday == 6) dayToday = 5;
        else if (dayToday == 5) dayToday = 4;
        else if (dayToday == 4) dayToday = 3;
        else if (dayToday == 3) dayToday = 2;
        else if (dayToday == 2) dayToday = 1;


        int intervalo = 60 / duracionCita;

        for (int i = 0; i<sir.size(); i++){
            if (sir.get(i).getDia() == dayToday){
                String h = sir.get(i).getHoraInicio().substring(0,2);
                String m = sir.get(i).getHoraInicio().substring(3,5);
                String addHM = h + ":" + m;
                horaInicio.add(addHM);
                for (int j=1; j< intervalo; j++){
                    String tiempo = sir.get(i).getHoraInicio();
                    String hora = tiempo.substring(0,2);
                    int minInt = Integer.parseInt(tiempo.substring(3,5));
                    int minAddInt = minInt + duracionCita*j;
                    String minAddStr = "" + minAddInt;
                    String tiempoAgregar = hora + ":" + minAddStr;
                    horaInicio.add(tiempoAgregar);
                }
            }
        }

        Collections.sort(horaInicio);

        for (int i = 0; i < smr.size();  i++){

            //String fechaCompToda = smr.get(0).getInicio();
            //String fechaComp = fechaCompToda.substring()

            if (true)  {

                String tiempoEliminar = smr.get(i).getInicio();
                String fechaGuion = tiempoEliminar.substring(0, 10);
                Log.d("xd", "moosstrar" + fechaGuion);
                int anhoWeek = Integer.parseInt(fechaGuion.substring(0, 4));
                int mesWeek = Integer.parseInt(fechaGuion.substring(5, 7));
                int diaWeek = Integer.parseInt(fechaGuion.substring(8, 10));


                if (anho == anhoWeek && mes == mesWeek && dia == diaWeek) {
                    String horaMin = tiempoEliminar.substring(11, 16);
                    int posEliminar = 0;
                    for (int h = 0; h < horaInicio.size(); h++) {
                        if (horaMin.equals(horaInicio.get(h))) {
                            Log.d("xd", horaMin + " xxaffsafsfsaf " + horaInicio);
                            posEliminar = h;
                            break;
                        }
                    }
                        Log.d("xd", "LLEGUE ACAAA " + posEliminar);
                    horaInicio.remove(posEliminar);
                }


            }
        }

        Calendar today = Calendar.getInstance();
        int diaToday = today.get(Calendar.DAY_OF_MONTH);
        int mesToday = today.get(Calendar.MONTH) + 1;
        int anhoToday = today.get(Calendar.YEAR);
        int hora = today.get(Calendar.HOUR_OF_DAY); // 24 hour clock
        int minute  = today.get(Calendar.MINUTE);

        Log.d("xd", "el negrito de ojos claros");
        List nuevasHoras = new ArrayList<String>();
        if (diaToday == dia && mesToday == mes && anhoToday == anho){
            Log.d("xd", "TU MARIDO TE QUIERE???");
            int pos = 0;
            for (int i = 0 ; i < horaInicio.size(); i++){

                String horaMinList = horaInicio.get(i);
                int horaActual = Integer.parseInt(horaMinList.substring(0,2));
                int minActual = Integer.parseInt(horaMinList.substring(3,5));

                Log.d("xd", " " + horaActual + " " +  minActual + " " +  hora + " " + minute );
                if (horaActual <= hora ){
                    Log.d("xd", " QUITAAAAAAAAAAAAAAAALOOOOO" );
                }
                else if  (horaActual == hora && minActual < minute) {
                    Log.d("xd", " QUITAAAAAAAAAAAAAAAALOOOOO" );
                }
                else{
                    nuevasHoras.add(horaInicio.get(i));
                }

            }
            return nuevasHoras;
        }

        return horaInicio;

    }

}


