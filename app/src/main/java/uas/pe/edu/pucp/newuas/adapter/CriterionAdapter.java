package uas.pe.edu.pucp.newuas.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.model.Aspect;
import uas.pe.edu.pucp.newuas.model.Criterion;

/**
 * Created by Marshall on 4/11/2016.
 */

public class CriterionAdapter extends BaseAdapter {


    List<Criterion> items;
    Context context;
    LayoutInflater layoutInflater;

    public CriterionAdapter(Context context, List<Criterion> items) {

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
        return items.get(position).getIdCriterio();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.item_criterion, null);

        ViewHolder viewHolder = new ViewHolder();

        viewHolder.tvCritName = (TextView) view.findViewById(R.id.tvCritName);
        viewHolder.tvCritStatus = (TextView) view.findViewById(R.id.tvCritStatus);

        viewHolder.tvCritName.setText(items.get(position).getNombre());

        if (items.get(position).getEstado() == 0) {
            viewHolder.tvCritStatus.setText(R.string.tvInactivo);
            viewHolder.tvCritStatus.setTextColor(Color.RED);
        } else {
            viewHolder.tvCritStatus.setText(R.string.tvActivo);
            viewHolder.tvCritStatus.setTextColor(Color.GREEN);
        }


        return view;
    }

    private static class ViewHolder {
        TextView tvCritName;
        TextView tvCritStatus;
    }
}
