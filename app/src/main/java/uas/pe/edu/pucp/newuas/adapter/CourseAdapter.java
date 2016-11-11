package uas.pe.edu.pucp.newuas.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.model.CourseResponse;

/**
 * Created by samoe on 10/11/2016.
 */

public class CourseAdapter extends BaseAdapter {
    List<CourseResponse> items;
    Context context;
    LayoutInflater layoutInflater;

    public CourseAdapter(List<CourseResponse> items, Context context) {
        this.items = items;
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public CourseResponse getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.item_course, null);
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.tvCode = (TextView) view.findViewById(R.id.tvCodigo);
        viewHolder.tvCourse = (TextView) view.findViewById(R.id.tvCourse);

        viewHolder.tvCode.setText(items.get(position).getCodigo());
        viewHolder.tvCourse.setText(items.get(position).getNombre());
        return view;
    }

    private static class ViewHolder {
        TextView tvCode, tvCourse;
    }
}
