package uas.pe.edu.pucp.newuas.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.model.Investigator;
import uas.pe.edu.pucp.newuas.model.UserMe;
import uas.pe.edu.pucp.newuas.model.UserMeResponse;
import uas.pe.edu.pucp.newuas.model.UserResponse;

/**
 * Created by Andree on 20/10/2016.
 */

public class InvestigatorsAdapter extends BaseAdapter{

    ArrayList<Investigator> items;
    Context context;
    LayoutInflater layoutInflater;

    public InvestigatorsAdapter(Context context, ArrayList<Investigator> items) {
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
        /*View view = layoutInflater.inflate(R.layout.fragment_investigators_item,null);
        return view;*/
        /*
        ViewHolder viewHolder = new ViewHolder();

        viewHolder.invName = (TextView) view.findViewById(R.id.inv_name);
        viewHolder.invName.setText(items.get(position).getNombre() + " " + items.get(position).getApePaterno() + " " + items.get(position).getApeMaterno());*/
/*
        viewHolder.invMail = (TextView) view.findViewById(R.id.invMail);
        viewHolder.invMail.setText(items.get(position).getCorreo());

        viewHolder.invEsp = (TextView) view.findViewById(R.id.invEsp);
        viewHolder.invEsp.setText(items.get(position).getFaculty().getNombre());

        viewHolder.invTel = (TextView) view.findViewById(R.id.invTel);
        viewHolder.invTel.setText(items.get(position).getCelular());
*/
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.fragment_investigators_item, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.invName.setText(items.get(position).getNombre() + " " + items.get(position).getApePaterno() + " " + items.get(position).getApeMaterno());
        viewHolder.invMail.setText(items.get(position).getCorreo());

        return convertView;
    }

    public static class ViewHolder{
        TextView invName;
        TextView invMail;

        public ViewHolder(View view) {
            invName = (TextView)view.findViewById(R.id.inv_name);
            invMail = (TextView)view.findViewById(R.id.inv_mail);
        }

    }
}
