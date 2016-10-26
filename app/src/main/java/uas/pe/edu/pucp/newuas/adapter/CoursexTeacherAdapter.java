package uas.pe.edu.pucp.newuas.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.model.Schedules;
import uas.pe.edu.pucp.newuas.model.Teacher;

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
        View view = layoutInflater.inflate(R.layout.item_course_teachers, null);
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.tvHorario = (TextView) view.findViewById(R.id.tvValueHorario);
        ListView lvTeacherList = (ListView) view.findViewById(R.id.lvTeacherList);
        viewHolder.tvHorario.setText(items.get(position).getCodigo());
        Schedules schedules = items.get(position);
        List<Teacher> teachersList = schedules.getProfessors();
        List<String> teacherNames = new ArrayList<>();
        for (Teacher teacher : teachersList) {
            teacherNames.add(teacher.getNombre() + " " + teacher.getApellidoPaterno() + " " + teacher.getApellidoMaterno());
        }
        String[] arrayTeacherNames = new String[teacherNames.size()];
        teacherNames.toArray(arrayTeacherNames);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(view.getContext(), android.R.layout.simple_list_item_1, android.R.id.text1, arrayTeacherNames);
        lvTeacherList.setAdapter(arrayAdapter);
        return view;
    }

    private static class ViewHolder {
        TextView tvHorario;
    }
}
