package uas.pe.edu.pucp.newuas.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.PorterDuff;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.controller.TutStudentController;
import uas.pe.edu.pucp.newuas.controller.TutTutorController;
import uas.pe.edu.pucp.newuas.fragment.AcceptAppointmentStudentFragment;
import uas.pe.edu.pucp.newuas.fragment.TutorInfoFragment;
import uas.pe.edu.pucp.newuas.model.SingleRowTuto;
import uas.pe.edu.pucp.newuas.view.NavigationDrawerTutoria;
import uas.pe.edu.pucp.newuas.view.NavigationDrawerTutoriaTutor;

/**
 * Created by Wingerlion on 02/11/2016.
 */
public class AppointmentAdapterTutor extends BaseAdapter {
    Context context;
    public List<SingleRowTuto> lista;

    public AppointmentAdapterTutor(Context c, List<SingleRowTuto> sr) {

        context = c;
        lista = sr;

    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.fragment_single_row_tutor, viewGroup, false);
        TextView titleDate = (TextView) row.findViewById(R.id.dateSingleRowTuto);
        TextView titleHour = (TextView) row.findViewById(R.id.hourSingleRowTuto);
        TextView titleTopic = (TextView) row.findViewById(R.id.topicSingleRowTuto);
        TextView titleState = (TextView) row.findViewById(R.id.stateSingleRowTuto);
        TextView nameState = (TextView) row.findViewById(R.id.alumnSingleRowTuto);
        ImageButton icon1 = (ImageButton) row.findViewById(R.id.icon1SingleRowTuto);
        ImageButton icon2 = (ImageButton) row.findViewById(R.id.icon2SingleRowTuto);

        SingleRowTuto temp = lista.get(position);
        titleDate.setText(temp.getFecha());
        titleHour.setText(temp.getHora());
        titleTopic.setText(temp.getTema());
        titleState.setText(temp.getEstado());
        nameState.setText(temp.getNombreAlumno());
        icon1.setImageResource(temp.getIcon1());
        icon2.setImageResource(temp.getIcon2());

        if (temp.getEstado().equals("Pendiente")) {
            titleState.setBackgroundColor(Color.parseColor("#ff9800"));
        }
        else if (temp.getEstado().equals("Confirmada") )
            titleState.setBackgroundColor(Color.parseColor("#26a69a"));
        else if (temp.getEstado().equals("Cancelada") )
            titleState.setBackgroundColor(Color.parseColor("#d9534f"));
        else if (temp.getEstado().equals("Sugerida") ) {
            titleState.setBackgroundColor(Color.parseColor("#FFFF00"));
            titleState.setTextColor(Color.BLACK);
        }
        else if (temp.getEstado().equals("Rechazada") )
            titleState.setBackgroundColor(Color.parseColor("#9e9e9e"));
        else if (temp.getEstado().equals("Asistida") )
            titleState.setBackgroundColor(Color.parseColor("#4051b5"));
        else if (temp.getEstado().equals("No asistida"))
            titleState.setBackgroundColor(Color.parseColor("#4caf50"));



        final String solicitud = "Esta a punto de  confirmar una  cita con su alumno para el día " +  temp.getFecha()  + " a las " + temp.getHora() + " ¿Desea continuar?";
        final String solicitud2 = "Esta a punto de  cancelar una  cita con su alumno para el día " +  temp.getFecha()  + " a las " + temp.getHora() + " ¿Desea continuar?";
        final int idAppoint = temp.getIdAppoint();

        final Context contextAdapter = viewGroup.getContext();


        Calendar c = Calendar.getInstance();
        int year       = c.get(Calendar.YEAR);
        int month      = c.get(Calendar.MONTH); // Jan = 0, dec = 11
        int dayOfMonth = c.get(Calendar.DAY_OF_MONTH);

        String dayOfM = "" + dayOfMonth;
        if (dayOfM.length() == 1) dayOfM = "0" + dayOfM;
        String actualDate = year + "-" + (month+1) + "-" + dayOfM;

         Log.d("tag", temp.getEstado() + " " + temp.getFecha() + " fecha xxx " + actualDate);


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
                                            TutTutorController tsc = new TutTutorController();
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
                                            Toast.makeText(context, "Se ha rechazado la cita con el alumno", Toast.LENGTH_LONG).show();
                                                TutTutorController tsc = new TutTutorController();
                                                tsc.rechazarListTutor(context, idAppoint);
                                        }
                                    }
                            ).show();

                        }
                    }
            );
        }
        else if (temp.getEstado().equals("Confirmada")  && temp.getFecha().equals(actualDate)){

            icon1.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            TutTutorController tsc = new TutTutorController();
                            tsc.RealizarCitaConfirmada(context,idAppoint);
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
                                            TutTutorController tsc = new TutTutorController();
                                            tsc.cancelListTutor(context, idAppoint);
                                        }
                                    }
                            ).show();

                        }
                    }
            );
        }

        else if (temp.getEstado().equals("Confirmada") && !temp.getFecha().equals(actualDate) ) {

            icon1.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            TutTutorController tsc = new TutTutorController();
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
                                            TutTutorController tsc = new TutTutorController();
                                            tsc.cancelListTutor(context, idAppoint);
                                        }
                                    }
                            ).show();

                        }
                    }
            );
        }



        else if (temp.getEstado().equals("Pendiente")){

            //icon1.setVisibility(View.GONE);
            icon1.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            TutTutorController tsc = new TutTutorController();
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
                                            Toast.makeText(context, "Se ha rechazado la cita con el alumno", Toast.LENGTH_LONG).show();
                                            TutTutorController tsc = new TutTutorController();
                                            tsc.cancelListTutor(context, idAppoint);
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

                            TutTutorController tsc = new TutTutorController();
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

                            TutTutorController tsc = new TutTutorController();
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

                            TutTutorController tsc = new TutTutorController();
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

                            TutTutorController tsc = new TutTutorController();
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
