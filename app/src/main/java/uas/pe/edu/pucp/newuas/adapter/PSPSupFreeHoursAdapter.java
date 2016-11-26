package uas.pe.edu.pucp.newuas.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

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
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
    private SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd/MM/yyyy", Locale.US);


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

            Date date  =simpleDateFormat.parse(items.get(position).getFecha());
            viewHolder.tvFecha.append(simpleDateFormat2.format(date));
            viewHolder.tvHora.append(items.get(position).getHoraIni() + ":00");


        } catch (Exception ex) {
            ex.printStackTrace();
        }


        return view;


    }
    public void setItems(ArrayList<PSPFreeHour> freeHours){
        items = freeHours;


    }


    public static class ViewHolder {
        TextView tvFecha, tvHora;

    }}
