package uas.pe.edu.pucp.newuas.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.model.PSPPhase;
import uas.pe.edu.pucp.newuas.model.Student;

/**
 * Created by Franz on 04/11/2016.
 */

public class PSPStudentsAdapter  extends BaseAdapter {


    private ArrayList<Student> items;
    private Context context;
    private LayoutInflater layoutInflater;


    public PSPStudentsAdapter(Context context, ArrayList<Student> items) {
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
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null)
            view = layoutInflater.inflate(R.layout.item_psp_students, null);

        Log.d("Adapter", "LLego");

        try {
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.tvIdentifierStudent = (TextView) view.findViewById(R.id.psp_identifier_student);
            viewHolder.tvNameStudent = (TextView) view.findViewById(R.id.psp_name_student);


            viewHolder.tvIdentifierStudent.setText(items.get(position).getCodigo());
            viewHolder.tvNameStudent.setText(items.get(position).getNombre() + items.get(position).getApellidoPaterno() +
                    items.get(position).getApellidoMaterno());


        } catch (Exception ex) {
            ex.printStackTrace();
        }


        return view;


    }


    public static class ViewHolder {
        TextView tvIdentifierStudent, tvNameStudent;

    }
}