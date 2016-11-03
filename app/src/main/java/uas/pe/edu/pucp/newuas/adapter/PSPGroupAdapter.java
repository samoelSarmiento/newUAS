package uas.pe.edu.pucp.newuas.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.model.PSPGroup;
import uas.pe.edu.pucp.newuas.model.PSPListViewAdapter;

/**
 * Created by Franz on 26/10/2016.
 */

public class PSPGroupAdapter extends BaseAdapter {

    private ArrayList<PSPGroup> items;
    private Context context;
    private boolean group;
    private LayoutInflater layoutInflater;
    private int selectedPosition = 0;

    public PSPGroupAdapter(Context context, ArrayList<PSPGroup> items,  boolean hasGroup) {
        this.items = items;
        this.context = context;
        this.group = hasGroup;
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
        return items.get(position).getIdGroup();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        if(view ==null)
            view = layoutInflater.inflate(R.layout.item_psp_groups, null);

        Log.d("Adapter", "LLego");
        Log.d("GRUPO", "" + items.get(position).getIdGroup());
        ViewHolder viewHolder =  new ViewHolder();

                viewHolder.tvPspNumberGroup = (TextView) view.findViewById(R.id.tv_item_psp_number_group);
                viewHolder.tvPspDescriptionGroup = (TextView) view.findViewById(R.id.tv_item_psp_description_group);
                viewHolder.rbPspGroup = (RadioButton) view.findViewById(R.id.rb_item_psp_choose_group);

                viewHolder.rbPspGroup.setChecked(position == selectedPosition);
                viewHolder.rbPspGroup.setTag(position);
                viewHolder.rbPspGroup.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        selectedPosition = (Integer) v.getTag();
                        notifyDataSetChanged();

                    }});

        viewHolder.tvPspNumberGroup.setText(items.get(position).getNumero());
        viewHolder.tvPspDescriptionGroup.setText(items.get(position).getDescription());
        return view;




    }

    public static class ViewHolder{
        TextView tvPspNumberGroup, tvPspDescriptionGroup;
        RadioButton rbPspGroup;

    }
    public  PSPGroup  getSelectedItem (){
       return items.get(selectedPosition);

    }
}
