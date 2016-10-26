package uas.pe.edu.pucp.newuas.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.model.Schedules;

/**
 * Created by Marshall on 25/10/2016.
 */

public class CoursexTeacherAdapter extends BaseAdapter {
    private Context context;
    private List<Schedules> items;
    private LayoutInflater layoutInflater;

    public CoursexTeacherAdapter(List<Schedules> items, Context context) {
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
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.item_course_x_specialty, null);
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.tvHorario = (TextView) view.findViewById(R.id.tvValueHorario);
        //V:
        return null;
    }

    private static class ViewHolder{
        TextView tvHorario;
    }
}
