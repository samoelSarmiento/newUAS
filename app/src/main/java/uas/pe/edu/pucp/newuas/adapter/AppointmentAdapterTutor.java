package uas.pe.edu.pucp.newuas.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.LightingColorFilter;
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
import java.util.List;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.controller.TutStudentController;
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

        //final String solicitud = "Esta a punto de  confirmar una cita con su alumno para el día " +  temp.getCreado()  + " a las " + temp.getHora() + "       ¿Desea continuar?";
        final String solicitud =    "Esta a punto de  confirmar una      cita con su alumno para el día " +  temp.getFecha()  + " a las " + temp.getHora() + "                     ¿Desea continuar?";

        icon1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setTitle("Confirmación de cita");
                        builder.setMessage(solicitud).setNegativeButton("Cancelar",  new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();

                            }
                        }).setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                        Toast.makeText(context, "Se ha confirmado la cita con el alumno", Toast.LENGTH_LONG).show();
                                        //TutStudentController tsc = new TutStudentController();
                                        //tsc.appointmentRequest(context, Configuration.LOGIN_USER.getUser().getIdUsuario(),valorFecha[0], valorHora[0],valorTema[0]);
                                    }
                                }
                        ).show();




                    }
                }


        );


        return row;

    }
}
