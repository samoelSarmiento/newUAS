package uas.pe.edu.pucp.newuas.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.model.InvGroups;


/**
 * Created by Andree on 25/10/2016.
 */

public class InvGroupsAdapter extends BaseAdapter{

    ArrayList<InvGroups> items;
    Context context;
    LayoutInflater layoutInflater;

    public InvGroupsAdapter(Context context, ArrayList<InvGroups> items) {
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

        View view = layoutInflater.inflate(R.layout.fragment_inv_group_item,null);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.invGroupName.setText(items.get(position).getNombre());
        return view;


    }

    public static class ViewHolder{
        TextView invGroupName;

        public ViewHolder(View view) {
            invGroupName = (TextView)view.findViewById(R.id.invGroup_name);
        }
    }

}
