package uas.pe.edu.pucp.newuas.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import uas.pe.edu.pucp.newuas.R;

/**
 * Created by Wingerlion on 02/11/2016.
 */
public class AppointmentAdapterTutor extends BaseAdapter {
    Context context;
    public List<SingleRowTuto> list;
    public AppointmentAdapterTutor(Context c, List<SingleRowTuto> sr){

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
        TextView titleDate = (TextView) row.findViewById(R.id.dateSingleRowTuto);
        TextView titleHour = (TextView) row.findViewById(R.id.hourSingleRowTuto);
        TextView titleTopic = (TextView) row.findViewById(R.id.topicSingleRowTuto);
        TextView titleState = (TextView) row.findViewById(R.id.stateSingleRowTuto);
        TextView nameState = (TextView) row.findViewById(R.id.alumnSingleRowTuto);

        SingleRowTuto temp = list.get(position);
        titleDate.setText(temp.getFecha());
        titleHour.setText(temp.getHora());
        titleTopic.setText(temp.getTema());
        titleState.setText(temp.getEstado() );
        titleState.setText(temp.getNombreAlumno() );

        return row;

    }
}
