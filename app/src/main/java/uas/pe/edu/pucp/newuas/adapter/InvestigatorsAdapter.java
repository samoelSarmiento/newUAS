package uas.pe.edu.pucp.newuas.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.model.UserResponse;

/**
 * Created by Andree on 20/10/2016.
 */

public class InvestigatorsAdapter extends BaseAdapter{

    ArrayList<UserResponse> items;
    Context context;
    LayoutInflater layoutInflater;

    public InvestigatorsAdapter(Context context, ArrayList<UserResponse> items) {
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
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.fragment_investigators_detail,null);
        ViewHolder viewHolder = new ViewHolder();

        viewHolder.invName = (TextView) view.findViewById(R.id.invName);
        viewHolder.invName.setText(items.get(position).getUser().getInvestigator().getNombre());

        viewHolder.invMail = (TextView) view.findViewById(R.id.invMail);
        viewHolder.invMail.setText(items.get(position).getUser().getInvestigator().getCorreo());

        viewHolder.invEsp = (TextView) view.findViewById(R.id.invEsp);
        viewHolder.invEsp.setText(items.get(position).getUser().getInvestigator().getIdEspecialidad());

        viewHolder.invTel = (TextView) view.findViewById(R.id.invTel);
        viewHolder.invTel.setText(items.get(position).getUser().getInvestigator().getCelular());

        return view;
    }

    public static class ViewHolder{
        TextView invName;
        TextView invMail;
        TextView invEsp;
        TextView invTel;
    }
}
