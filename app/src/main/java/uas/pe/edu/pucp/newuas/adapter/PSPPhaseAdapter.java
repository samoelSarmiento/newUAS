package uas.pe.edu.pucp.newuas.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.model.PSPGroup;
import uas.pe.edu.pucp.newuas.model.PSPPhase;

/**
 * Created by Franz on 28/10/2016.
 */

public class PSPPhaseAdapter extends BaseAdapter{



    private ArrayList<PSPPhase> items;
    private Context context;
    private LayoutInflater layoutInflater;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.US);

    public PSPPhaseAdapter(Context context, ArrayList<PSPPhase> items) {
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
        View view = convertView;
        if(view ==null)
            view = layoutInflater.inflate(R.layout.item_psp_phases, null);

        Log.d("Adapter", "LLego");
        Log.d("GRUPO", "" + items.get(position).getNumero());
        try {
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.tvPspPhaseNumber = (TextView) view.findViewById(R.id.tv_item_psp_phase);
            viewHolder.tvPspPhaseStartDate = (TextView)  view.findViewById(R.id.tv_item_psp_starting_date);
            viewHolder.tvPspPhaseEndDate = (TextView) view.findViewById(R.id.tv_item_psp_end_date);
            viewHolder.icon  = (ImageView)view.findViewById(R.id.iv_item_psp_phase);


            viewHolder.tvPspPhaseNumber .setText( String.valueOf(items.get(position).getNumero()));

            String stDate = simpleDateFormat.format(items.get(position).getFechaInicio());
            viewHolder.tvPspPhaseStartDate .setText(stDate);
            String enDate = simpleDateFormat.format(items.get(position).getFechaFin());
            viewHolder.tvPspPhaseEndDate.setText(enDate);

        }catch (Exception ex){ex.printStackTrace();}


        return view;



    }


    public static class ViewHolder{
        TextView tvPspPhaseNumber, tvPspPhaseStartDate, tvPspPhaseEndDate;
        ImageView icon;

    }
}
