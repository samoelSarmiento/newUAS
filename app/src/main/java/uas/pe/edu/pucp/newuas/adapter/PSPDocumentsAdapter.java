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
import java.util.Locale;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.model.PSPDocument;

/**
 * Created by Franz on 28/10/2016.
 */

public class PSPDocumentsAdapter extends BaseAdapter {


    private ArrayList<PSPDocument> items;
    private Context context;
    private LayoutInflater layoutInflater;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.US);

    public PSPDocumentsAdapter(Context context, ArrayList<PSPDocument> items) {
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


        try {
           ViewHolder viewHolder = new ViewHolder();
            viewHolder.tvPspDocumentTitle = (TextView) view.findViewById(R.id.tv_item_psp_phase);
            viewHolder.tvPspDocumentTemplate = (TextView)  view.findViewById(R.id.tv_item_psp_starting_date);
            viewHolder.tvPspDocumentName = (TextView) view.findViewById(R.id.tv_item_psp_end_date);
            viewHolder.tvPspDocumentStatus =  (TextView) view.findViewById(R.id.tv_item_psp_end_date);
            viewHolder.tvPspDocumentPhase =  (TextView) view.findViewById(R.id.tv_item_psp_end_date);




            viewHolder.tvPspDocumentTitle .setText( String.valueOf(items.get(position)));
            viewHolder.tvPspDocumentTemplate.setText("");
            viewHolder.tvPspDocumentName.setText("");
            viewHolder.tvPspDocumentStatus.setText("");
            viewHolder.tvPspDocumentPhase.setText("");



        }catch (Exception ex){ex.printStackTrace();}


        return view;



    }


    public static class ViewHolder{
        TextView tvPspDocumentTitle, tvPspDocumentTemplate, tvPspDocumentName,
        tvPspDocumentStatus,tvPspDocumentPhase;

    }



}
