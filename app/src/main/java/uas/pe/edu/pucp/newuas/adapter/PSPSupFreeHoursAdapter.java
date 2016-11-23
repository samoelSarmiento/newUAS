package uas.pe.edu.pucp.newuas.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.model.PSPFreeHour;
import uas.pe.edu.pucp.newuas.model.PSPGrade;

/**
 * Created by Franz on 21/11/2016.
 */

public class PSPSupFreeHoursAdapter  extends BaseAdapter {


    private ArrayList<PSPFreeHour> items;
    private Context context;
    private LayoutInflater layoutInflater;


    public PSPSupFreeHoursAdapter(Context context, ArrayList<PSPFreeHour> items) {
        this.items = items;
        this.context = context;
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

        View view = layoutInflater.inflate(R.layout.item_psp_sup_freehour, null);

        Log.d("Adapter", "LLego");

        try {
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.tvFecha = (TextView) view.findViewById(R.id.tv_item_psp_sup_freehour_date);
            viewHolder.tvHora = (TextView) view.findViewById(R.id.tv_item_psp_sup_freehour_hour);


            viewHolder.tvFecha.append(items.get(position).getFecha());
            viewHolder.tvHora.append(items.get(position).getHoraIni());


        } catch (Exception ex) {
            ex.printStackTrace();
        }


        return view;


    }


    public static class ViewHolder {
        TextView tvFecha, tvHora;

    }}
