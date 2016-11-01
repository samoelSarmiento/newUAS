package uas.pe.edu.pucp.newuas.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.model.EducationalObjective;
import uas.pe.edu.pucp.newuas.model.Period;

/**
 * Created by Marshall on 31/10/2016.
 */

public class EducationalObjectiveAdapter extends BaseAdapter{
    private Context context;
    private ArrayList<EducationalObjective> items;
    private LayoutInflater layoutInflater;

    public EducationalObjectiveAdapter(Context context, ArrayList<EducationalObjective> items) {
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

        View view = layoutInflater.inflate(R.layout.item_educationalobjective,null);
        EducationalObjectiveAdapter.ViewHolder viewHolder = new EducationalObjectiveAdapter.ViewHolder();

        viewHolder.tvEducationalObjective = (TextView) view.findViewById(R.id.tvEduObj);


        viewHolder.tvEducationalObjective.setText(items.get(position).getDescripcion());
        //Integer vigente = items.get(position).getVigente();

/*

        viewHolder.tvEducationalObjective = (ListView) view.findViewById(R.id.tvUserName);

        viewHolder.tvEducationalObjective.setText(items.get(position).getNombre());
        */
        return view;
    }

    public static class ViewHolder{
        TextView tvEducationalObjective;
    }
}
