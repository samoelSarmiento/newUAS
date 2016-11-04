package uas.pe.edu.pucp.newuas.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.model.Criterion;
import uas.pe.edu.pucp.newuas.model.CriterionLevel;

/**
 * Created by Marshall on 4/11/2016.
 */

public class CriterionLevelAdapter extends BaseAdapter {
    List<CriterionLevel> items;
    Context context;
    LayoutInflater layoutInflater;

    public CriterionLevelAdapter(Context context, List<CriterionLevel> items){

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
        return items.get(position).getIdNivelCriterio();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.item_critlevel,null);
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.tvCritLevName = (TextView)view.findViewById(R.id.tvCritLevName);
        viewHolder.tvCritLevVal = (TextView)view.findViewById(R.id.tvCritLevVal);

        viewHolder.tvCritLevName.setText(items.get(position).getDescripcion());
        viewHolder.tvCritLevName.setText(items.get(position).getValor()+"");




        return view;
    }

    public static class ViewHolder{
        TextView tvCritLevName;
        TextView tvCritLevVal;
    }
}
