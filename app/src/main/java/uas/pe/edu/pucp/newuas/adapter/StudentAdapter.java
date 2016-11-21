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
import uas.pe.edu.pucp.newuas.model.Student;

/**
 * Created by samoe on 15/11/2016.
 */

public class StudentAdapter extends BaseAdapter {

    List<Student> items;
    Context context;
    LayoutInflater layoutInflater;

    public StudentAdapter(List<Student> items, Context context) {
        this.items = items;
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Student getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_students, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.tvCode = (TextView) convertView.findViewById(R.id.tvCode);
            viewHolder.tvNombre = (TextView) convertView.findViewById(R.id.tvName);

            Student student = items.get(position);
            viewHolder.tvCode.setText(student.getCodigo());
            String fullname = student.getNombre() + " " + student.getApellidoPaterno() + " " + student.getApellidoMaterno();
            viewHolder.tvNombre.setText(fullname);
        }
        return convertView;
    }

    private static class ViewHolder {
        TextView tvCode, tvNombre;
    }
}
