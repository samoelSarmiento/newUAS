package uas.pe.edu.pucp.newuas.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.model.Aspect;

/**
 * Created by samoe on 02/11/2016.
 */

public class AspectAdapter extends BaseAdapter {
    List<Aspect> items;
    Context context;
    LayoutInflater layoutInflater;

    public AspectAdapter(Context context, List<Aspect> items) {
        this.context = context;
        this.items = items;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Aspect getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.item_aspect, null);
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.tvValueAspect = (TextView) view.findViewById(R.id.tvAspect);
        viewHolder.tvValueAspect.setText(items.get(position).getNombre());
        return view;
    }

    private static class ViewHolder {
        TextView tvValueAspect;
    }
}
