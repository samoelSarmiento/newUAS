package uas.pe.edu.pucp.newuas.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.model.Deliverable;
import uas.pe.edu.pucp.newuas.model.InvEvent;

/**
 * Created by Andree on 11/11/2016.
 */

public class DeliverableAdapter extends BaseAdapter{

    ArrayList<Deliverable> items;
    Context context;
    LayoutInflater layoutInflater;

    public DeliverableAdapter(Context context, ArrayList<Deliverable> items) {
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
        View view = layoutInflater.inflate(R.layout.fragment_deliverable_item,null);
        DeliverableAdapter.ViewHolder viewHolder = new DeliverableAdapter.ViewHolder(view);

        viewHolder.delivName.setText(items.get(position).getNombre());
        return view;
    }

    public static class ViewHolder{
        TextView delivName;

        public ViewHolder(View view) {
            delivName = (TextView)view.findViewById(R.id.deliv_name);
        }
    }

}
