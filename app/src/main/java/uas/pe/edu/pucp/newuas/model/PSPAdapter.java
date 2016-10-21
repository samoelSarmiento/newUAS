package uas.pe.edu.pucp.newuas.model;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import uas.pe.edu.pucp.newuas.R;

/**
 * Created by Franz on 21/10/2016.
 */

public class PSPAdapter  extends BaseAdapter {

    LayoutInflater inflater;
    ArrayList items;



    public PSPAdapter(Context context, ArrayList items){

        this.items = items;
        this.inflater = LayoutInflater.from(context);



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

        if(!items.isEmpty()) {

            try {
                if (items.get(position) instanceof PSPDocument) {
                    view = inflater.inflate(R.layout.item_psp_documents, null);
                    DocViewHolder viewHolderA = new DocViewHolder();
                    viewHolderA.buildView(view, items, position);


                }

                if(items.get(position) instanceof PSPSupervisor){

                    view = inflater.inflate(R.layout.item_psp_supervisor, null);
                    SupViewHolder viewHolderSup  = new SupViewHolder();
                    viewHolderSup.buildView(view,items,position);



                }
            } catch (Exception ex) {

                ex.printStackTrace();
            }
        }
        return view;
    }


}
