package uas.pe.edu.pucp.newuas.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.model.StudentEffort;

/**
 * Created by samoe on 21/11/2016.
 */

public class StudentEffortAdapter extends BaseAdapter {
    List<StudentEffort> items;
    Context context;
    LayoutInflater layoutInflater;

    public StudentEffortAdapter(Context context, List<StudentEffort> items) {
        this.items = items;
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public StudentEffort getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.item_student_effort, parent, false);
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.tvCriterio = (TextView) view.findViewById(R.id.tvCriterio);
        viewHolder.tvNota = (TextView) view.findViewById(R.id.tvNota);
        StudentEffort effort = items.get(position);
        viewHolder.tvCriterio.setText(effort.getCriterion().getNombre());
        String nota = effort.getNota() + "";
        viewHolder.tvNota.setText(nota);
        return view;
    }

    private static class ViewHolder {
        TextView tvCriterio, tvNota;
    }
}
