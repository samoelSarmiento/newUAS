package uas.pe.edu.pucp.newuas.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import uas.pe.edu.pucp.newuas.R;

/**
 * Created by samoe on 01/11/2016.
 */

public class StudentResultAdapter extends BaseAdapter {
    private List<StudentResult> item;
    private Context context;
    private LayoutInflater layoutInflater;


    public StudentResultAdapter(Context context, List<StudentResult> item) {
        this.item = item;
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return item.size();
    }

    @Override
    public StudentResult getItem(int position) {
        return item.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.item_student_result, null);
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.tvIdentif = (TextView) view.findViewById(R.id.tvIdentif);
        viewHolder.tvDescrip = (TextView) view.findViewById(R.id.tvDescription);
        viewHolder.tvIdentif.setText(item.get(position).getIdentificador());
        viewHolder.tvDescrip.setText(item.get(position).getDescripcion());
        return view;
    }

    private static class ViewHolder {
        TextView tvIdentif, tvDescrip;
    }
}
