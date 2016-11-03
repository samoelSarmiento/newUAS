package uas.pe.edu.pucp.newuas.model;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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
        Log.d("xd", sr.get(0).getNombreAlumno()+" ");
        Log.d("xd","THE FAINAL COAUNTDOWWWN");
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

        Log.d("xd", lista.size() +"  asasfasfafsfs");
        Log.d("xd","THE FAINAL 66666666666666666666666666666666");

        SingleRowTuto temp = lista.get(position);
        titleDate.setText(temp.getFecha());
        titleHour.setText(temp.getHora());
        titleTopic.setText(temp.getTema());
        titleState.setText(temp.getEstado() );
        nameState.setText(temp.getNombreAlumno() );


        return row;

    }
}
