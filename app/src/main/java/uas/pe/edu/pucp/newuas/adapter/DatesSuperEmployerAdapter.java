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
import uas.pe.edu.pucp.newuas.model.Psp_dates_supervisor_employers;
import uas.pe.edu.pucp.newuas.model.Psp_dates_supervisor_employers_get;
import uas.pe.edu.pucp.newuas.model.Student;

/**
 * Created by jemarroquin on 10/11/2016.
 */
public class DatesSuperEmployerAdapter  extends BaseAdapter {
    ArrayList<Psp_dates_supervisor_employers_get> items;
    Context context;
    LayoutInflater layoutInflater;
    public DatesSuperEmployerAdapter(Context context, ArrayList<Psp_dates_supervisor_employers_get> items) { //, ArrayList<Student> items
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
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.dates_super_employer_item,null);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.studentName.setText(items.get(position).getFecha() + " " + items.get(position).getHoraInicio() + " " + items.get(position).getLugar());
        return view;
    }
    public static class ViewHolder{
        TextView studentName;
        public ViewHolder(View view) {
            studentName = (TextView)view.findViewById(R.id.date_super_employer_item);
        }
    }
}
