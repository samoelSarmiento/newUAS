package uas.pe.edu.pucp.newuas.fragment;

import android.app.Activity;
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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.controller.TutStudentController;
import uas.pe.edu.pucp.newuas.model.AppointmentFilterRequest;
import uas.pe.edu.pucp.newuas.model.AppointmentRequest;
import uas.pe.edu.pucp.newuas.model.AppointmentRequestMirror;
import uas.pe.edu.pucp.newuas.model.TUTInfoResponse;
import uas.pe.edu.pucp.newuas.view.NavigationDrawerTutoria;


public class StudentFilterAppointmentFragment extends Fragment {

    Button btnAceptar, btnCancelar;
    EditText txtFechaInicio,txtFechaFin;
    ImageButton btnCalendarInicio, btnCalendarFin;
    private static DatePickerDialog.OnDateSetListener selectorListenerBegin;
    private static DatePickerDialog.OnDateSetListener selectorListenerEnd;
    Spinner s;
    List<String> listaSpinner = new ArrayList<String>();
    int dayI, monthI,yearI, dayF, monthF, yearF ,y;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_student_filter_appointment, container, false);
        final View view1 = view;

        txtFechaInicio = (EditText) view.findViewById(R.id.txtFechaBeginFilterStudent);
        txtFechaFin= (EditText) view.findViewById(R.id.txtFechaEndFilterStudent);
        btnCalendarInicio = (ImageButton) view.findViewById(R.id.btnCalendarBeginFilterStudent);
        btnCalendarFin = (ImageButton) view.findViewById(R.id.btnCalendarEndFilterStudent);
        btnAceptar = (Button) view.findViewById(R.id.buttonSolicitarFilterStudent);
        final String [] valorFechaI = new String[1], valorFechaF = new String[1];

        s = (Spinner) view.findViewById(R.id.spinnerMotivoFilter);
        s.setAdapter(null);
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item, NavigationDrawerTutoria.nameTopic);
        listaSpinner.add("Pendiente"); listaSpinner.add("Confirmada"); listaSpinner.add("Cancelada"); listaSpinner.add("Sugerida"); listaSpinner.add("");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,listaSpinner);
        s.setAdapter(adapter);

        Calendar c = Calendar.getInstance();
        yearI = c.get(Calendar.YEAR);
        monthI = c.get(Calendar.MONTH);
        dayI = c.get(Calendar.DAY_OF_MONTH);
        yearF = c.get(Calendar.YEAR);
        monthF = c.get(Calendar.MONTH);
        dayF = c.get(Calendar.DAY_OF_MONTH);

        selectorListenerBegin =  new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePickerDialog datePickerDialog, int i, int i1, int i2) {
                dayI = i2; monthI = i1; yearI= i;
                String format = "%1$02d";
                String date1 = String.format(format, i2) + "/" + String.format(format, (i1 + 1)) + "/" + i;
                txtFechaInicio.setText(date1);
                valorFechaI[0] = date1;
            }
        };

        selectorListenerEnd =  new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePickerDialog datePickerDialog, int i, int i1, int i2) {
                dayF = i2; monthF = i1; yearF = i;
                String format = "%1$02d";
                String date2 = String.format(format, i2) + "/" + String.format(format, (i1 + 1)) + "/" + i;
                txtFechaFin.setText(date2);
                valorFechaF[0] = date2;

            }
        };

        btnCalendarInicio.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DatePickerDialog d = DatePickerDialog.newInstance(selectorListenerBegin, yearI, monthI, dayI);
                        //d.setDisabledDays(dates);
                        d.show(getActivity().getFragmentManager(), "Datepickerdialog");
                    }
                }
        );

        btnCalendarFin.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DatePickerDialog d = DatePickerDialog.newInstance(selectorListenerEnd, yearF, monthF , dayF);
                        //d.setDisabledDays(dates);
                        d.show(getActivity().getFragmentManager(), "Datepickerdialog");
                    }
                }
        );
            btnAceptar.setOnClickListener(

                    new View.OnClickListener() {
                        @Override

                        public void onClick(View v) {
                            if ((txtFechaInicio.toString().matches("") && txtFechaFin.toString().matches("")) || (!(txtFechaInicio.toString()).isEmpty() && !(txtFechaFin.toString()).isEmpty())) {
                                String motivo = s.getSelectedItem().toString();
                                Toast.makeText(getActivity(), "Se ha filtrado correctamente", Toast.LENGTH_LONG).show();
                                AppointmentRequestMirror appointFilterInfo = new AppointmentRequestMirror(Configuration.LOGIN_USER.getUser().getIdUsuario(), valorFechaI[0], valorFechaF[0], motivo, 2);
                                Bundle bundle = new Bundle();
                                bundle.putSerializable("Tutoria", (Serializable) appointFilterInfo);
                                StudentAppointFragment mp = new StudentAppointFragment();
                                mp.setArguments(bundle);
                                (getActivity()).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container, mp).commit();
                            }
                            else
                                Toast.makeText(getActivity(), "Debe llenar los dos campos de fecha!", Toast.LENGTH_SHORT).show();


                        }
                    }

            );


        return view;
    }


}
