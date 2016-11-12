package uas.pe.edu.pucp.newuas.fragment;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.controller.TutTutorController;
import uas.pe.edu.pucp.newuas.model.AppointInformationRegisterTuto;
import uas.pe.edu.pucp.newuas.view.NavigationDrawerTutoriaTutor;


public class TutorNewNoAppointFragment extends Fragment {


    public String solicitud;
    ImageButton btnCalendar;
    Button btnSolicitar;
    Spinner spinnerHorasI, spinnerHorasF, spinnerTemas, spinnerAlumnos;
    EditText txtFecha, txtObservacion;
    int day, year, month;
    private static DatePickerDialog.OnDateSetListener selectorListener;
    Calendar[] dates = new Calendar[2];
    Calendar cal1 = Calendar.getInstance();
    Calendar cal2 = Calendar.getInstance();
    Calendar maxTime = Calendar.getInstance();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tutor_new_no_appoint, container, false);
        getActivity().setTitle("Tutoría");
        txtFecha = (EditText) view.findViewById(R.id.dateTextTutorNewAppoint);
        btnSolicitar = (Button) view.findViewById(R.id.buttonSolicitarTutorNewNoAssignmentReg);
        spinnerHorasI = (Spinner) view.findViewById(R.id.spinnerHoraINoAppoint);
        spinnerHorasF = (Spinner) view.findViewById(R.id.spinnerHoraFNoAppoint);
        spinnerTemas = (Spinner) view.findViewById(R.id.spinnerTema);
        spinnerAlumnos = (Spinner) view.findViewById(R.id.tutorStudentSpinner);
        txtObservacion = (EditText) view.findViewById(R.id.tutoTextObsNoAppoint);

        final String [] valorFecha = new String[1], valorHoraI = new String[1], valorHoraF = new String[1], valorTema = new String[1];
        final String [] valorNombre = new String[1];



        Bundle bundle = this.getArguments();
        List<AppointInformationRegisterTuto> tutGroup= null;
        if (bundle != null){
            tutGroup= (List<AppointInformationRegisterTuto>) bundle.getSerializable("Tutoria");
        }

        /*
        List<String> nombreAlumnos = obtenerNombreAlumnos(tutGroup);
        Spinner studentName = (Spinner) view.findViewById(R.id.tutorStudentSpinner);
        studentName.setAdapter(null);
        ArrayAdapter<String> adapterStudent = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item, nombreAlumnos);
        studentName.setAdapter(adapterStudent);
        */
        Spinner s = (Spinner) view.findViewById(R.id.spinnerTema);
        s.setAdapter(null);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item, NavigationDrawerTutoriaTutor.nameTopic);
        s.setAdapter(adapter);

        valorHoraI[0] = spinnerHorasI.getSelectedItem().toString();
        valorHoraF[0] = spinnerHorasF.getSelectedItem().toString();
        valorTema[0] = spinnerTemas.getSelectedItem().toString();
        //valorNombre[0] = spinnerAlumnos.getSelectedItem().toString();



        btnSolicitar.setOnClickListener(

                new View.OnClickListener(){
                    @Override

                    public void onClick(View v) {
                        valorTema[0] = spinnerTemas.getSelectedItem().toString();
                        valorHoraI[0] = spinnerHorasI.getSelectedItem().toString();
                        valorHoraF[0] = spinnerHorasI.getSelectedItem().toString();
                      //      valorNombre[0] = spinnerAlumnos.getSelectedItem().toString();
                        //solicitud = "Está a punto de confirmar una cita con su tutor para el " + valorFecha[0] + " a las " + valorHora[0] + "\n ¿Desea continuar?";
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
                                        //TutTutorController tsc = new TutTutorController();
                                        //tsc.appointmentRequest(getActivity (), Configuration.LOGIN_USER.getUser().getIdUsuario(),valorFecha[0], valorHora[0],valorTema[0],valorNombre[0]);

                                    }
                                }
                        ).show();
                    }
                }

        );

        return view;
    }

    public List<String> obtenerNombreAlumnos(List<AppointInformationRegisterTuto> studentInformation){

        List<String> retornar = new ArrayList<String>();
        for ( AppointInformationRegisterTuto si : studentInformation){
            retornar.add(si.getFullName());
        }

        return retornar;
    }

}