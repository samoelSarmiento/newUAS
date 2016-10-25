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
import java.util.List;

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
        View view = layoutInflater.inflate(R.layout.specialty_list_detail, null);
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.specialty = (Button) view.findViewById(R.id.btnSpecialtyDisplay);
        viewHolder.specialty.setId(position);
        viewHolder.specialty.setText(items.get(position).getNombre());
        viewHolder.specialty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Configuration.SPECIALTY = items.get(position);
                SpecialtyFragment specialtyFragment = new SpecialtyFragment();
                Gson gsonf = new Gson();
                String spj = gsonf.toJson(items.get(position));
                Bundle bundle = new Bundle();
                bundle.putString("Specialty", spj);
                specialtyFragment.setArguments(bundle);
                ((Activity) context).getFragmentManager().beginTransaction().replace(R.id.fragment_container, specialtyFragment).commit();
            }
        });
        return view;
    }

    private static class ViewHolder {
        Button specialty;
    }
}
