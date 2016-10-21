package uas.pe.edu.pucp.newuas.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.model.SpecialtyxCourseDisplay;

/**
 * Created by samoe on 20/10/2016.
 */

public class SpecialtyxCoursesAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<SpecialtyxCourseDisplay> items;
    private LayoutInflater layoutInflater;

    public SpecialtyxCoursesAdapter(Context context, ArrayList<SpecialtyxCourseDisplay> items) {
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

        View view = layoutInflater.inflate(R.layout.item_course_x_specialty, null);
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.tvCode = (TextView) view.findViewById(R.id.tvCode);
        viewHolder.tvCourse = (TextView) view.findViewById(R.id.tvNameCurso);
        viewHolder.tvCode.setText(items.get(position).getCodigo());
        viewHolder.tvCourse.setText(items.get(position).getNombre());
        return view;
    }

    private static class ViewHolder {
        TextView tvCode, tvCourse;
    }
}
