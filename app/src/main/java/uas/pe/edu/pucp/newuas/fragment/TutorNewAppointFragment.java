package uas.pe.edu.pucp.newuas.fragment;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.controller.TutStudentController;
import uas.pe.edu.pucp.newuas.controller.TutTutorController;
import uas.pe.edu.pucp.newuas.model.AppointInformationRegisterTuto;
import uas.pe.edu.pucp.newuas.model.MyToast;
import uas.pe.edu.pucp.newuas.model.NoAppointmentResponse;
import uas.pe.edu.pucp.newuas.model.ScheduleInfoResponse;
import uas.pe.edu.pucp.newuas.model.ScheduleMeetingResponse;
import uas.pe.edu.pucp.newuas.model.StudentInfoResponse;
import uas.pe.edu.pucp.newuas.model.TUTInfoResponse;
import uas.pe.edu.pucp.newuas.view.NavigationDrawerTutoria;
import uas.pe.edu.pucp.newuas.view.NavigationDrawerTutoriaTutor;


public class TutorNewAppointFragment extends Fragment {


    public String solicitud;
    ImageButton btnCalendar;
    Button btnSolicitar,btnCancelar;
    Spinner spinnerHoras, spinnerTemas, spinnerAlumnos;
    EditText txtFecha;
    int day, year, month,duracionCita, idAlumno;
    int ndays[] = new int[1];
    private static DatePickerDialog.OnDateSetListener selectorListener;
    //Calendar[] dates = new Calendar[2];
    List<Calendar> dates = new ArrayList<Calendar>();
    Calendar cal1 = Calendar.getInstance();
    Calendar cal2 = Calendar.getInstance();
    Calendar maxTime = Calendar.getInstance();
    public static List<ScheduleInfoResponse> sir ;
    public static List<ScheduleMeetingResponse> smr ;
    List<NoAppointmentResponse> tutGroup;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_tutor_new_appoint, container, false);
        getActivity().setTitle("Solicitud de una nueva cita");
        txtFecha = (EditText) view.findViewById(R.id.dateTextTutorNewAppoint);
        btnSolicitar = (Button) view.findViewById(R.id.buttonSolicitarTutorNewAssignmentReg);
        btnCancelar = (Button) view.findViewById(R.id.buttonCancelarTutorNewAssigmentReg);
        btnCalendar = (ImageButton) view.findViewById(R.id.btnCalendarTutorNewAppoint);
        spinnerHoras = (Spinner) view.findViewById(R.id.spinnerTutHora);
        spinnerTemas = (Spinner) view.findViewById(R.id.spinnerTema);
        spinnerAlumnos = (Spinner) view.findViewById(R.id.tutorStudentSpinner);

        final String [] valorFecha = new String[1], valorHora = new String[1], valorTema = new String[1];
        final String [] valorNombre = new String[1];

        Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

        Bundle bundle = this.getArguments();
        //List<AppointInformationRegisterTuto> tutGroup= null;
        tutGroup = null;
        if (bundle != null){
            tutGroup= (List<NoAppointmentResponse>) bundle.getSerializable("Tutoria");
        }
        // Disponibilidad de las citas

        ndays[0] = tutGroup.get(0).getNumberDays();
        duracionCita = tutGroup.get(0).getDuracionCita();
        sir = tutGroup.get(0).getScheduleInfo();
        smr = tutGroup.get(0).getScheduleMeeting();

        List<String> nombreAlumnos = obtenerNombreAlumnos(tutGroup.get(0).getStudentInfo());
        Spinner studentName = (Spinner) view.findViewById(R.id.tutorStudentSpinner);
        studentName.setAdapter(null);
        ArrayAdapter<String> adapterStudent = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item, nombreAlumnos);
        studentName.setAdapter(adapterStudent);


        Spinner s = (Spinner) view.findViewById(R.id.spinnerTema);
        s.setAdapter(null);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item, NavigationDrawerTutoriaTutor.nameTopic);
        s.setAdapter(adapter);

        valorFecha[0] = txtFecha.getText().toString();
        //valorHora[0] = spinnerHoras.getSelectedItem().toString();
        valorTema[0] = spinnerTemas.getSelectedItem().toString();
        valorNombre[0] = spinnerAlumnos.getSelectedItem().toString();

        selectorListener =  new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePickerDialog datePickerDialog, int i, int i1, int i2) {
                day = i2; month = i1; year = i;
                String format = "%1$02d";
                String date = String.format(format, i2) + "/" + String.format(format, (i1 + 1)) + "/" + i;
                txtFecha.setText(date);
                valorFecha[0] = date.toString();

                Spinner hora = (Spinner) view.findViewById(R.id.spinnerTutHora);
                List<String> horasDispo = obtenerHorasDisponible(sir,smr,duracionCita,date.toString());
                hora.setAdapter(null);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item, horasDispo);
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
                        dates = obtenerFechasDisponibles(ndays[0],sir);
                        Calendar [] cdates =  dates.toArray(new Calendar[dates.size()]);
                        d.setSelectableDays(cdates);
                        d.show(getActivity().getFragmentManager(), "Datepickerdialog");

                    }
                }
        );


        btnSolicitar.setOnClickListener(

                new View.OnClickListener(){
                    @Override

                    public void onClick(View v) {
                        if (txtFecha.getText().toString().matches("") || spinnerHoras.getSelectedItem() == null) {
                            MyToast.makeText(getActivity(), "Debe rellenar los espacios en blanco!", Toast.LENGTH_LONG, MyToast.infoAlert).show();
                        }
                        else {
                            valorTema[0] = spinnerTemas.getSelectedItem().toString();
                            valorHora[0] = spinnerHoras.getSelectedItem().toString();
                            valorNombre[0] = spinnerAlumnos.getSelectedItem().toString();
                            idAlumno = obtenerIdAlumno(tutGroup.get(0).getStudentInfo(), valorNombre[0]);

                            solicitud = "Está a punto de confirmar una cita con su alumno para el " + valorFecha[0] + " a las " + valorHora[0] + "\n ¿Desea continuar?";
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
                                            MyToast.makeText(getActivity(), "Se ha registrado una nueva cita", Toast.LENGTH_LONG, MyToast.checkAlert).show();
                                            TutTutorController tsc = new TutTutorController();
                                            //tsc.appointmentRequest(getActivity(), Configuration.LOGIN_USER.getUser().getIdUsuario(), valorFecha[0], valorHora[0], valorTema[0], valorNombre[0]);
                                                tsc.appointmentRequest(getActivity(), Configuration.LOGIN_USER.getUser().getIdUsuario(), valorFecha[0], valorHora[0], valorTema[0], "", idAlumno, duracionCita);

                                        }
                                    }
                            ).show();
                        }
                    }
                }

        );


        btnCancelar.setOnClickListener(

                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        TutTutorController tsc = new TutTutorController();
                        tsc.showTopics(getActivity());
                    }
                }

        );



        return view;
    }

    public int obtenerIdAlumno(List<StudentInfoResponse> studentInformation, String nombreBuscado) {

        int valorBuscado = 2;
        for (StudentInfoResponse si : studentInformation) {
            if (nombreBuscado.equals(si.getApePaterno() + " " + si.getApeMaterno() + " " + si.getNombre()))
                valorBuscado = si.getId();
        }

        return valorBuscado;
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

    public void showDate(){
        String format = "%1$02d";
        String fecha =String.format(format,day)+"/"+String.format(format,(month+1))+"/"+year;
        txtFecha.setText(fecha);
    }



    public List<String> obtenerNombreAlumnos(List<StudentInfoResponse> studentInformation) {

        List<String> retornar = new ArrayList<String>();
        for (StudentInfoResponse si : studentInformation) {
            retornar.add(si.getApePaterno() + " " + si.getApeMaterno() + " " + si.getNombre());
        }

        return retornar;
    }

    public List<String> obtenerHorasDisponible(List<ScheduleInfoResponse> sir, List<ScheduleMeetingResponse> smr, int duracionCita, String paramString)
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
            String tiempoEliminar = smr.get(i).getInicio();
            String fechaGuion = tiempoEliminar.substring(0,10);
            Log.d("xd","moosstrar" + fechaGuion);

            int anhoWeek =  Integer.parseInt(fechaGuion.substring(0,4));
            int mesWeek = Integer.parseInt(fechaGuion.substring(5,7));
            int diaWeek = Integer.parseInt(fechaGuion.substring(8,10));


            if (anho == anhoWeek && mes == mesWeek && dia == diaWeek){
                String horaMin = tiempoEliminar.substring(11,16);
                int posEliminar = 0;
                for (int h = 0; h<horaInicio.size();h++){
                    if (horaMin.equals(horaInicio.get(h)))  {
                        Log.d("xd", horaMin + " xxaffsafsfsaf " + horaInicio );
                        posEliminar = h;
                        break;
                    }
                }
                Log.d("xd", "LLEGUE ACAAA " + posEliminar);
                horaInicio.remove(posEliminar);
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
