package uas.pe.edu.pucp.newuas.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import uas.pe.edu.pucp.newuas.R;
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

            SingleRow temp = list.get(position);
            titleDate.setText(temp.getFecha());
            titleHour.setText(temp.getHora());
            titleTopic.setText(temp.getTema());
            titleState.setText(temp.getEstado() );

            return row;

    }
}