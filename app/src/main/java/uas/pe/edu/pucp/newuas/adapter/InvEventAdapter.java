package uas.pe.edu.pucp.newuas.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.model.InvEvent;

/**
 * Created by Andree on 04/11/2016.
 */

public class InvEventAdapter extends BaseAdapter{

    ArrayList<InvEvent> items;
    Context context;
    LayoutInflater layoutInflater;

    public InvEventAdapter(Context context, ArrayList<InvEvent> items) {
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
        View view = layoutInflater.inflate(R.layout.fragment_inv_event_item,null);
        InvEventAdapter.ViewHolder viewHolder = new InvEventAdapter.ViewHolder(view);

        viewHolder.invEvName.setText(items.get(position).getNombre());
        return view;
    }

    public static class ViewHolder{
        TextView invEvName;

        public ViewHolder(View view) {
            invEvName = (TextView)view.findViewById(R.id.invEv_name);
        }
    }
}
