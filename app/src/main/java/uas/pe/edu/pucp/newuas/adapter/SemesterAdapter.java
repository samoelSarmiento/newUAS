package uas.pe.edu.pucp.newuas.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.model.Semester;

/**
 * Created by Marshall on 25/10/2016.
 */

public class SemesterAdapter extends BaseAdapter {

    private ArrayList<Semester> items;
    private Context context;
    private LayoutInflater layoutInflater;

    public SemesterAdapter(Context context, ArrayList<Semester> items) {
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
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return items.get(position).getIdCiclo();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.item_semester, null);
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.tvSemester = (TextView)view.findViewById(R.id.tvSemester);
        viewHolder.tvSemester.setText(items.get(position).getDescripcion());

        return view;
    }

    private static class ViewHolder {
        TextView tvSemester;
    }

}
