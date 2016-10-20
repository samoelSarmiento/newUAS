package uas.pe.edu.pucp.newuas.model.Fragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import uas.pe.edu.pucp.newuas.R;


public class AlumnoNuevaCitaFragment extends Fragment  {


    ImageButton btn;
    EditText txtFecha;
    int day, year, month;
    private static DatePickerDialog.OnDateSetListener selectorListener;
    Calendar[] dates = new Calendar[2];
    Calendar cal1 = Calendar.getInstance();
    Calendar cal2 = Calendar.getInstance();
    Calendar maxTime = Calendar.getInstance();


    public AlumnoNuevaCitaFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_alumno_nueva_cita, container, false);
        txtFecha = (EditText) view.findViewById(R.id.dateText);
        btn = (ImageButton) view.findViewById(R.id.btnCalendar);
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

        selectorListener =  new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePickerDialog datePickerDialog, int i, int i1, int i2) {
                day = i2; month = i1; year = i;
                String format = "%1$02d";
                String date = String.format(format, i2) + "/" + String.format(format, (i1 + 1)) + "/" + i;
                txtFecha.setText(date);
            }
        };

        btn.setOnClickListener(
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
        cal1.setFirstDayOfWeek(Calendar.SUNDAY);
        cal2.setFirstDayOfWeek(Calendar.SUNDAY);
        cal1.add(Calendar.DAY_OF_WEEK_IN_MONTH,29);
        cal2.add(Calendar.DAY_OF_YEAR,7);
        // OBTENEMOS EL DIA ACTUAL //

        String dateString = String.format("%d-%d-%d", year, month + 1, day);
        Date date = new SimpleDateFormat("yyyy-M-d").parse(dateString);
        // Then get the day of week from the Date based on specific locale.
        String dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date);
        Log.d("MyTag","ADICTO ALL " + dayOfWeek); // Wednesday
        // cal1.add(Calendar.DAY_OF_MONTH,Calendar.SATURDAY);
        //  cal2.add(Calendar.DAY_OF_MONTH,Calendar.SUNDAY);
        //  Log.d("MyTag","" + Calendar.`);
        dates[0] = cal1;
        dates[1] = cal2;
        return dates;
    }


}



