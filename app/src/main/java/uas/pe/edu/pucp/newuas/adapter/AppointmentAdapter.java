package uas.pe.edu.pucp.newuas.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.List;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.controller.TutStudentController;
import uas.pe.edu.pucp.newuas.controller.TutTutorController;
import uas.pe.edu.pucp.newuas.model.SingleRow;

/**
 * Created by Wingerlion on 01/11/2016.
 */
public class AppointmentAdapter extends BaseAdapter {

        Context context;
        public  List<SingleRow> list;
        public AppointmentAdapter(Context c, List<SingleRow> sr){

            context = c;
            list = sr;

        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View row = inflater.inflate(R.layout.fragment_single_row_student,viewGroup,false);
            TextView titleDate = (TextView) row.findViewById(R.id.dateSingleRow);
            TextView titleHour = (TextView) row.findViewById(R.id.hourSingleRow);
            TextView titleTopic = (TextView) row.findViewById(R.id.topicSingleRow);
            TextView titleState = (TextView) row.findViewById(R.id.stateSingleRow);
            ImageButton icon1 = (ImageButton) row.findViewById(R.id.icon1SingleRow);
            ImageButton icon2 = (ImageButton) row.findViewById(R.id.icon2SingleRow);


            SingleRow temp = list.get(position);
            titleDate.setText(temp.getFecha());
            titleHour.setText(temp.getHora());
            titleTopic.setText(temp.getTema());
            titleState.setText(temp.getEstado());
            icon1.setImageResource(temp.getIcon1());
            icon2.setImageResource(temp.getIcon2());

            if (temp.getEstado().equals("Pendiente")) {
                titleState.setBackgroundColor(Color.parseColor("#ff9800"));
            }
            else if (temp.getEstado().equals("Confirmada") )
                titleState.setBackgroundColor(Color.parseColor("#26a69a"));
            else if (temp.getEstado().equals("Cancelada") )
                titleState.setBackgroundColor(Color.parseColor("#d9534f"));
            else if (temp.getEstado().equals("Sugerida") )
                titleState.setBackgroundColor(Color.parseColor("#FFFF00"));
            else if (temp.getEstado().equals("Rechazada") )
                titleState.setBackgroundColor(Color.parseColor("#9e9e9e"));
            else if (temp.getEstado().equals("Asistida") )
                titleState.setBackgroundColor(Color.parseColor("#4051b5"));
            else if (temp.getEstado().equals("No asistida"))
                titleState.setBackgroundColor(Color.parseColor("#4caf50"));



            final String solicitud = "Esta a punto de  confirmar una  cita con su alumno para el día " +  temp.getFecha()  + " a las " + temp.getHora() + " ¿Desea continuar?";
            final String solicitud2 = "Esta a punto de  cancelar una  cita con su alumno para el día " +  temp.getFecha()  + " a las " + temp.getHora() + " ¿Desea continuar?";
            final int idAppoint = temp.getIdAppoint();

            Calendar c = Calendar.getInstance();
            int year       = c.get(Calendar.YEAR);
            int month      = c.get(Calendar.MONTH); // Jan = 0, dec = 11
            int dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
            String actualDate = year + "-" + (month+1) + "-" + dayOfMonth;

            if (temp.getEstado().equals("Sugerida") ) {
                icon1.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                                builder.setTitle("Confirmación de cita");
                                builder.setMessage(solicitud).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();

                                    }
                                }).setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                dialog.cancel();
                                                Toast.makeText(context, "Se ha confirmado la cita con el alumno", Toast.LENGTH_LONG).show();
                                                TutStudentController tsc = new TutStudentController();
                                                tsc.refreshListTutor(context, idAppoint);
                                            }
                                        }
                                ).show();

                            }
                        }
                );

                icon2.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                                builder.setTitle("Cancelación de cita");
                                builder.setMessage(solicitud2).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();

                                    }
                                }).setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                dialog.cancel();
                                                Toast.makeText(context, "Se ha cancelado la cita con el alumno", Toast.LENGTH_LONG).show();
                                                TutStudentController tsc = new TutStudentController();
                                                tsc.rechazarListTutor(context,idAppoint);
                                                //tsc.cancelListTutor(context, idAppoint);
                                            }
                                        }
                                ).show();

                            }
                        }
                );
            }
            else if (temp.getEstado().equals("Confirmada")){

                icon1.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                TutStudentController tsc = new TutStudentController();
                                tsc.visualizarCitaConfirmada(context,idAppoint);

                            }
                        }
                );

                icon2.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                                builder.setTitle("Cancelación de cita");
                                builder.setMessage(solicitud2).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();

                                    }
                                }).setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                dialog.cancel();
                                                Toast.makeText(context, "Se ha cancelado la cita con el alumno", Toast.LENGTH_LONG).show();
                                                TutStudentController tsc = new TutStudentController();
                                                tsc.cancelListTutor(context, idAppoint);
                                            }
                                        }
                                ).show();

                            }
                        }
                );

            }



            else if (temp.getEstado().equals("Pendiente")){

                icon1.setVisibility(View.GONE);
                icon1.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {


                            }
                        }
                );

                icon2.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                                builder.setTitle("Cancelación de cita");
                                builder.setMessage(solicitud2).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();

                                    }
                                }).setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                dialog.cancel();
                                                Toast.makeText(context, "Se ha cancelado la cita con el alumno", Toast.LENGTH_LONG).show();
                                                TutStudentController tsc = new TutStudentController();
                                                tsc.rechazarListTutor(context,idAppoint);
                                                //tsc.cancelListTutor(context, idAppoint);
                                            }
                                        }
                                ).show();

                            }
                        }
                );

            }

            else if (temp.getEstado().equals("Cancelada") ){

                icon2.setVisibility(View.GONE);
                icon1.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                TutStudentController tsc = new TutStudentController();
                                tsc.visualizarCitaConfirmada(context,idAppoint);
                            }
                        }
                );
                icon2.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        }
                );
            }


            else if (temp.getEstado().equals("Rechazada") ){

                icon2.setVisibility(View.GONE);
                icon1.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                TutStudentController tsc = new TutStudentController();
                                tsc.visualizarCitaConfirmada(context,idAppoint);
                            }
                        }
                );


                icon2.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        }
                );
            }

            else if (temp.getEstado().equals("Asistida") ){

                icon2.setVisibility(View.GONE);
                icon1.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                TutStudentController tsc = new TutStudentController();
                                tsc.visualizarCitaConfirmada(context,idAppoint);
                            }
                        }
                );

                icon2.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        }
                );
            }

            else if (temp.getEstado().equals("No asistida") ){

                icon2.setVisibility(View.GONE);
                icon1.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                TutStudentController tsc = new TutStudentController();
                                tsc.visualizarCitaConfirmada(context,idAppoint);
                            }
                        }
                );


                icon2.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        }
                );
            }


            return row;

    }
}