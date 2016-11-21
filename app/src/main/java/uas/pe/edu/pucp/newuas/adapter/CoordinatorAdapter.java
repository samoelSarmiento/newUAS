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
import uas.pe.edu.pucp.newuas.controller.TutTutorController;
import uas.pe.edu.pucp.newuas.fragment.AcceptAppointmentStudentFragment;
import uas.pe.edu.pucp.newuas.fragment.TutorInfoFragment;
import uas.pe.edu.pucp.newuas.model.SingleRowCoord;
import uas.pe.edu.pucp.newuas.model.SingleRowTuto;
import uas.pe.edu.pucp.newuas.view.NavigationDrawerTutoria;
import uas.pe.edu.pucp.newuas.view.NavigationDrawerTutoriaTutor;

/**
 * Created by Wingerlion on 02/11/2016.
 */
public class CoordinatorAdapter extends BaseAdapter {
    Context context;
    public List<SingleRowCoord> lista;

    public CoordinatorAdapter(Context c, List<SingleRowCoord> sr) {

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
        View row = inflater.inflate(R.layout.fragment_single_row_coordinator, viewGroup, false);

        TextView code = (TextView) row.findViewById(R.id.codeCoordinatorSingleRow);
        TextView studentName = (TextView) row.findViewById(R.id.studentCoordinatorSingleRow);
        TextView tutorName = (TextView) row.findViewById(R.id.tutorCoordinatorSingleRow);
        TextView state = (TextView) row.findViewById(R.id.stateCoordinatorSingleRow);


        SingleRowCoord temp = lista.get(position);
        code.setText(temp.getCode());
        studentName.setText(temp.getStudentName());
        tutorName.setText(temp.getTutorName());
        state.setText(temp.getState());

        return row;

    }
}
