package uas.pe.edu.pucp.newuas.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.model.MeasureInstrument;
import uas.pe.edu.pucp.newuas.model.Period;

/**
 * Created by Marshall on 25/10/2016.
 */

public class MeasureInstrumentAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<MeasureInstrument> items;
    private LayoutInflater layoutInflater;

    public MeasureInstrumentAdapter(Context context, ArrayList<MeasureInstrument> items) {
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

        View view = layoutInflater.inflate(R.layout.item_measureinstrument,null);
        MeasureInstrumentAdapter.ViewHolder viewHolder = new MeasureInstrumentAdapter.ViewHolder();
        viewHolder.tvMeaInst = (TextView) view.findViewById(R.id.tvMeaInst);

        viewHolder.tvMeaInst.setText(items.get(position).getNombre());
        /*
        viewHolder.tvPeriod = (TextView) view.findViewById(R.id.tvPeriod);

        viewHolder.tvPeriodStatus = (TextView)view.findViewById(R.id.tvPeriodStatus);

        viewHolder.tvPeriod.setText(items.get(position).getConfiguration().getCycleAcademicStart().getDescripcion() + " - " + items.get(position).getConfiguration().getCycleAcademicEnd().getDescripcion());
        Integer vigente = items.get(position).getVigente();
        if (vigente == 0) viewHolder.tvPeriodStatus.setText("INACTIVO");
        else viewHolder.tvPeriodStatus.setText("ACTIVO"); */

/*

        viewHolder.tvPeriod = (ListView) view.findViewById(R.id.tvUserName);

        viewHolder.tvPeriod.setText(items.get(position).getNombre());
        */
        return view;
    }

    private static class ViewHolder{
        TextView tvMeaInst;

    }
}
