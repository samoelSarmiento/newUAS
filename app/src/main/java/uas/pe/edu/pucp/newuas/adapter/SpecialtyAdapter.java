package uas.pe.edu.pucp.newuas.adapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import com.google.gson.Gson;

import java.util.ArrayList;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.fragment.SpecialtyFragment;
import uas.pe.edu.pucp.newuas.model.Specialty;

/**
 * Created by samoe on 25/10/2016.
 */

public class SpecialtyAdapter extends BaseAdapter {
    private ArrayList<Specialty> items;
    private Context context;
    private LayoutInflater layoutInflater;

    public SpecialtyAdapter(Context context, ArrayList<Specialty> items) {
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_specialty, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.specialty = (Button) convertView.findViewById(R.id.btnSpecialtyDisplay);
            viewHolder.specialty.setId(position);
            viewHolder.specialty.setAllCaps(true);
            viewHolder.specialty.setText(items.get(position).getNombre());
            viewHolder.specialty.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Configuration.SPECIALTY = items.get(position);
                    SpecialtyFragment specialtyFragment = new SpecialtyFragment();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("specialty", items.get(position));
                    specialtyFragment.setArguments(bundle);
                    ((Activity) context).getFragmentManager()
                            .beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.fragment_container, specialtyFragment)
                            .commit();
                    ((Activity) context).setTitle("Mi Especialidad");
                }
            });
        }
        return convertView;
    }

    private static class ViewHolder {
        Button specialty;
    }
}
