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

import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.controller.TutTutorController;
import uas.pe.edu.pucp.newuas.model.AppointInformationRegisterTuto;
import uas.pe.edu.pucp.newuas.model.NoAppointmentResponse;
import uas.pe.edu.pucp.newuas.model.ScheduleInfoResponse;
import uas.pe.edu.pucp.newuas.model.ScheduleMeetingResponse;
import uas.pe.edu.pucp.newuas.model.StudentInfoResponse;
import uas.pe.edu.pucp.newuas.model.TUTInfoResponse;
import uas.pe.edu.pucp.newuas.view.NavigationDrawerTutoriaTutor;


public class TutorNewNoAppointFragment extends Fragment {


    public String solicitud;
    ImageButton btnTime;
    Button btnSolicitar,btnCancelar;
    Spinner spinnerHorasI, spinnerHorasF, spinnerTemas, spinnerAlumnos;
    EditText txtFecha, txtObservacion,txtHora;
    int day, year, month , idAlumno;
    String date,hora;
    private static TimePickerDialog.OnTimeSetListener selectorListener;
    Calendar[] dates = new Calendar[2];
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
        View view = inflater.inflate(R.layout.fragment_tutor_new_no_appoint, container, false);
        getActivity().setTitle("Tutoría");


        Bundle bundle = this.getArguments();
        tutGroup= null;
        if (bundle != null){
            tutGroup= (List<NoAppointmentResponse>) bundle.getSerializable("Tutoria");
        }


        txtFecha = (EditText) view.findViewById(R.id.dateTextTutorNewAppoint);
        btnSolicitar = (Button) view.findViewById(R.id.buttonSolicitarTutorNewNoAssignmentReg);
        btnCancelar = (Button) view.findViewById(R.id.buttonCancelarTutorNewNoAssigmentReg);
        spinnerTemas = (Spinner) view.findViewById(R.id.spinnerTema);
        spinnerAlumnos = (Spinner) view.findViewById(R.id.tutorStudentSpinner);
        txtObservacion = (EditText) view.findViewById(R.id.tutoTextObsNoAppoint);
        txtHora = (EditText)  view.findViewById(R.id.timeText);
        btnTime = (ImageButton) view.findViewById(R.id.btnClock);

        final String [] valorFecha = new String[1], valorHoraI = new String[1], valorHoraF = new String[1], valorTema = new String[1];
        final String [] valorNombre = new String[1];



        List<String> nombreAlumnos = obtenerNombreAlumnos(tutGroup.get(0).getStudentInfo());
        Spinner studentName = (Spinner) view.findViewById(R.id.tutorStudentSpinner);
        studentName.setAdapter(null);
        ArrayAdapter<String> adapterStudent = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item, nombreAlumnos);
        studentName.setAdapter(adapterStudent);


        Spinner s = (Spinner) view.findViewById(R.id.spinnerTema);
        s.setAdapter(null);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item, NavigationDrawerTutoriaTutor.nameTopic);
        s.setAdapter(adapter);

        final int duracionCita = tutGroup.get(0).getDuracionCita();
        Calendar c = Calendar.getInstance();
        int anho = c.get(Calendar.YEAR);
        int month      = c.get(Calendar.MONTH); // Jan = 0, dec = 11
        int dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
        date = dayOfMonth + "/" + month + "/" + anho;
        sir = tutGroup.get(0).getScheduleInfo();
        smr = tutGroup.get(0).getScheduleMeeting();

       // List<String> horasDisponibles = obtenerHorasDisponibles(sir,smr,duracionCita,date);
       // spinnerHorasI.setAdapter(null);
       // ArrayAdapter<String> adapterHoras = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item, horasDisponibles);
       // spinnerHorasI.setAdapter(adapterHoras);


        //valorHoraI[0] = spinnerHorasI.getSelectedItem().toString();
        valorTema[0] = spinnerTemas.getSelectedItem().toString();
        //valorNombre[0] = spinnerAlumnos.getSelectedItem().toString();

        //TIME PICKEEEEEEEEEEEEEEEEEEEEEEER

        selectorListener =  new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute, int second) {
                hora = hourOfDay + ":" + minute;
                txtHora.setText(hora);
            }
        };



        btnTime.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final Calendar c = Calendar.getInstance();
                        int hour = c.get(Calendar.HOUR_OF_DAY);
                        int minute = c.get(Calendar.MINUTE);
                        TimePickerDialog d = TimePickerDialog.newInstance(selectorListener,hour,minute,true);
                        d.show(getActivity().getFragmentManager(), "TimePickerDialog");
                    }
                }
        );

        //TIMEE PICKEEEEEEEEEEEEEEEEEEEEEEER



        btnCancelar.setOnClickListener(

                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        TutTutorController tsc = new TutTutorController();
                        tsc.showTopics(getActivity());
                    }
                }

        );

        btnSolicitar.setOnClickListener(

                new View.OnClickListener(){
                    @Override

                    public void onClick(View v) {
                        valorTema[0] = spinnerTemas.getSelectedItem().toString();
                        //valorHoraI[0] = spinnerHorasI.getSelectedItem().toString();
                        valorNombre[0] = spinnerAlumnos.getSelectedItem().toString();

                         idAlumno = obtenerIdAlumno(tutGroup.get(0).getStudentInfo(),valorNombre[0]);

                        String solicitud = "Está a punto de atender la cita ¿Desea continuar?";
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
                                        Toast.makeText(getActivity(), "Se ha atendido la cita!", Toast.LENGTH_LONG).show();
                                        TutTutorController tsc = new TutTutorController();
                                        tsc.atencionNoConfirmada(getActivity (), Configuration.LOGIN_USER.getUser().getIdUsuario(),date, hora,valorTema[0], txtObservacion.getText().toString(),idAlumno, duracionCita);

                                    }
                                }
                        ).show();
                    }
                }

        );

        return view;
    }

    public List<String> obtenerNombreAlumnos(List<StudentInfoResponse> studentInformation){

        List<String> retornar = new ArrayList<String>();
        for ( StudentInfoResponse si : studentInformation){
            retornar.add(si.getApePaterno() + " " + si.getApeMaterno() + " " + si.getNombre());
        }

        return retornar;
    }

    public int obtenerIdAlumno(List<StudentInfoResponse> studentInformation,String nombreBuscado){

        int valorBuscado = 2;
        for ( StudentInfoResponse si : studentInformation){
            if (nombreBuscado.equals(si.getApePaterno() + " " + si.getApeMaterno() + " " + si.getNombre()))
                valorBuscado = si.getId();
        }

        return valorBuscado;
    }

    public List<String> obtenerHorasDisponibles(List<ScheduleInfoResponse> sir, List<ScheduleMeetingResponse> smr, int duracionCita, String paramString)
    {

        List<String> horaInicio = new ArrayList<String>();

        int dia = Integer.parseInt(paramString.substring(0, 2));
        int mes = Integer.parseInt(paramString.substring(3, 5));
        int anho = Integer.parseInt(paramString.substring(6, 10));
        Calendar c = new GregorianCalendar(anho, mes, dia);
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

        return horaInicio;

    }

}
