package uas.pe.edu.pucp.newuas.model;

import android.content.Context;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import uas.pe.edu.pucp.newuas.R;

/**
 * Created by Wingerlion on 02/11/2016.
 */
public class AppointmentAdapterTutor extends BaseAdapter {
    Context context;
    public List<SingleRowTuto> lista;
    public AppointmentAdapterTutor(Context c, List<SingleRowTuto> sr){

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
        View row = inflater.inflate(R.layout.fragment_single_row_tutor,viewGroup,false);
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
        titleState.setText(temp.getEstado() );
        nameState.setText(temp.getNombreAlumno());
        icon1.setImageResource(temp.getIcon1());
        icon2.setImageResource(temp.getIcon2());


        return row;

    }
}
