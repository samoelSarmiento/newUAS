package uas.pe.edu.pucp.newuas.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.model.Period;
import uas.pe.edu.pucp.newuas.model.SpecialtyxCourseDisplay;

/**
 * Created by Marshall on 23/10/2016.
 */

public class MeasurePeriodAdapter extends BaseAdapter{

    private Context context;
    private ArrayList<Period> items;
    private LayoutInflater layoutInflater;

    public MeasurePeriodAdapter(Context context, ArrayList<Period> items) {
        this.context = context;
        this.items = items;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }




    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = layoutInflater.inflate(R.layout.item_measureperiod,null);
        ViewHolder viewHolder = new ViewHolder();

        viewHolder.tvPeriod = (TextView) view.findViewById(R.id.tvPeriod);

        viewHolder.tvPeriodStatus = (TextView)view.findViewById(R.id.tvPeriodStatus);

        viewHolder.tvPeriod.setText(items.get(position).getConfiguration().getCycleAcademicStart().getDescripcion() + " - " + items.get(position).getConfiguration().getCycleAcademicEnd().getDescripcion());
        Integer vigente = items.get(position).getVigente();
        if (vigente == 0){
            viewHolder.tvPeriodStatus.setTextColor(Color.RED);
            viewHolder.tvPeriodStatus.setText("INACTIVO");
        }
        else {

            viewHolder.tvPeriodStatus.setTextColor(Color.rgb(164,198,57));
            viewHolder.tvPeriodStatus.setText("ACTIVO");
        }

/*

        viewHolder.tvPeriod = (ListView) view.findViewById(R.id.tvUserName);

        viewHolder.tvPeriod.setText(items.get(position).getNombre());
        */
        return view;
    }

    private static class ViewHolder{
        TextView tvPeriod;
        TextView tvPeriodStatus;
    }
}
