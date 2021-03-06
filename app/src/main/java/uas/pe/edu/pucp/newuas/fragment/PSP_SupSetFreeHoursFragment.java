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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;
import com.wdullaer.materialdatetimepicker.time.Timepoint;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import retrofit2.Callback;
import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.adapter.SupSetFreehourCoursesSpinnerAdapter;
import uas.pe.edu.pucp.newuas.controller.PSPController;
import uas.pe.edu.pucp.newuas.model.MyToast;
import uas.pe.edu.pucp.newuas.model.PSPFreeHour;
import uas.pe.edu.pucp.newuas.model.PSPMeetingRequest;
import uas.pe.edu.pucp.newuas.model.PSPProcess;

/**

 */
public class PSP_SupSetFreeHoursFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public String solicitud;
    public String hora;
    ImageButton btnCalendar;
    Button btnSolicitar, btnCancel;
    EditText txtFecha, txtHour;
    EditText txtLugar;
    Spinner courseSpinner;

    ImageButton btnClock;
    int day, year, month;
    private static DatePickerDialog.OnDateSetListener selectorListener;
    private static TimePickerDialog.OnTimeSetListener selectTimeListener;
    Calendar[] dates = new Calendar[2];
    Calendar cal1 = Calendar.getInstance();
    Calendar cal2 = Calendar.getInstance();
    Calendar maxTime = Calendar.getInstance();
    ArrayList<PSPProcess> processList;


    public PSP_SupSetFreeHoursFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PSP_SupSetFreeHoursFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PSP_SupSetFreeHoursFragment newInstance(String param1, String param2) {
        PSP_SupSetFreeHoursFragment fragment = new PSP_SupSetFreeHoursFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_psp__sup_set_free_hours, container, false);







        txtFecha = (EditText) view.findViewById(R.id.et_psp_sup_freehour_date);
        btnSolicitar = (Button) view.findViewById(R.id.btn_psp_sup_freehour_register);
        btnCalendar = (ImageButton) view.findViewById(R.id.btn_psp_sup_freehour_calendar);
        btnCancel =(Button) view.findViewById(R.id.btn_psp_sup_freehour_cancel);
        btnClock = (ImageButton) view.findViewById(R.id.btn_psp_sup_freehour_clock);
        txtHour = (EditText) view.findViewById(R.id.et_psp_sup_freehour_hour);
        courseSpinner =  (Spinner) view.findViewById(R.id.cmb_psp_sup_freehour_course);



        if (getArguments() != null){

            processList =  (ArrayList<PSPProcess>) getArguments().getSerializable("process");
            SupSetFreehourCoursesSpinnerAdapter adapter =  new SupSetFreehourCoursesSpinnerAdapter(getActivity(),android.R.layout.simple_spinner_item,processList);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            courseSpinner.setAdapter(adapter);


        }


        btnClock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Calendar c = Calendar.getInstance();
                int hour = c.get(Calendar.HOUR_OF_DAY);
                int minute = 0;

                Log.d("Hour" , ""+ hour);
                TimePickerDialog timePicker =  TimePickerDialog.newInstance(selectTimeListener, hour, minute, true);

                timePicker.enableMinutes(false);

                Timepoint timeAt;

                timeAt = new Timepoint(8);



                Timepoint timeTo =  new Timepoint(21);
                timePicker.setMinTime(timeAt);
                timePicker.setMaxTime(timeTo);

                timePicker.show(getActivity().getFragmentManager(), "TimePickerDialog");

            }
        });

        selectTimeListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute, int second) {



                String fecha = txtFecha.getText().toString();

                Log.d("fecha" , fecha);

                SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");



                    Date dateNow = new Date();
                    String  dateNowString  =formatDate.format(dateNow);

                    Log.d("fecha Now", dateNowString);

                    if(fecha.matches(dateNowString)){

                        Calendar cal = Calendar.getInstance();

                        int hour  = cal.get(Calendar.HOUR_OF_DAY);
                        Log.d("hour1-", "" + hour);
                        cal.add(Calendar.HOUR_OF_DAY,1);
                        int hour1  = cal.get(Calendar.HOUR_OF_DAY);
                        Log.d("HOUR_NOW","" + hour1);
                        Log.d("HOUROFDAY", "" + hourOfDay);

                        if(hourOfDay < hour1){

                            MyToast.makeText(getActivity(),"Error en la hora", Toast.LENGTH_SHORT,MyToast.errorAlert).show();


                        }else{


                            String format = "%1$02d";
                            hora = String.format(format,hourOfDay) + ":" + minute + "0";
                            txtHour.setText(hora);


                        }



                    }else{

                        String format = "%1$02d";
                        hora = String.format(format,hourOfDay) + ":" + minute + "0";
                        txtHour.setText(hora);
                    }


            }
        };



        final String [] valorFecha = new String[1], valorHora = new String[1];

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

        final String[] lista = {"tema 1", "tema 2", "tema 3"};
/*
        Spinner s = (Spinner) view.findViewById(R.id.cmb_psp_meeting_topic);
        s.setAdapter(null);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_item, lista);
        s.setAdapter(adapter);
*/
        valorFecha[0] = txtFecha.getText().toString();

        //  valorTema[0] = spinnerTemas.getSelectedItem().toString();

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
                        d.setMinDate(Calendar.getInstance());
                        d.setMaxDate(maxTime);
                        d.setDisabledDays(dates);
                        d.show(getActivity().getFragmentManager(), "Datepickerdialog");
                    }
                }
        );

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                getFragmentManager().popBackStack();
            }
        });


        btnSolicitar.setOnClickListener(

                new View.OnClickListener(){
                    @Override

                    public void onClick(View v) {


                        solicitud = "Está a punto de confirmar su disponibilidad para el " + valorFecha[0] + " a las " + valorHora[0] + "\n ¿Desea continuar?";

                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                        builder.setMessage(solicitud).setNegativeButton("No",  new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();

                            }
                        }).setPositiveButton("Si", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                        PSPController controller = new PSPController();
                                        PSPFreeHour freeHour = new PSPFreeHour();


                                        if(txtHour.getText().toString().matches("")){

                                            MyToast.makeText(getActivity(),"Asignar una hora valida",Toast.LENGTH_SHORT,MyToast.infoAlert).show();
                                            return;


                                        }


                                        int position = courseSpinner.getSelectedItemPosition();
                                        position = position -1;
                                        if(position < 0 ) {
                                            MyToast.makeText(getActivity(), "Escoja un curso", Toast.LENGTH_SHORT, MyToast.infoAlert).show();
                                            return;
                                        }

                                        freeHour.setFecha(valorFecha[0]);

                                        freeHour.setIdProcess(processList.get(position).getIdProcess());

                                        freeHour.setHoraIni(hora);

                                        controller.setSupFreeHour(getActivity(),freeHour);





                                    }
                                }
                        ).show();
                    }
                }

        );

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getFragmentManager().popBackStack();
            }
        });





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
