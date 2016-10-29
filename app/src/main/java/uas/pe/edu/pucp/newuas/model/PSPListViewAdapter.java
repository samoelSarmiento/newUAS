package uas.pe.edu.pucp.newuas.model;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import uas.pe.edu.pucp.newuas.R;

/**
 * Created by Franz on 20/10/2016.
 */

public class PSPListViewAdapter extends BaseAdapter{

    LayoutInflater inflater;
    private ArrayList<PSPStudent> items;


    public PSPListViewAdapter(ArrayList items, Context c) {
        this.items = items;
        inflater =  (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
        if(convertView==null)
            view = inflater.inflate(R.layout.item_psp_students, null);

        Log.d("Adapter", "LLego");
        try {
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.tvPspIdStudent = (TextView) view.findViewById(R.id.psp_identifier_student);
            viewHolder.tvPspNameStudent  = (TextView) view.findViewById(R.id.psp_name_student);
            viewHolder.tvPspNameTeacher  = (TextView) view.findViewById(R.id.psp_name_teacher);


            viewHolder.tvPspIdStudent .setText( "" + items.get(position).getCodigo());
            viewHolder.tvPspNameStudent .setText(items.get(position).getName());
            viewHolder.tvPspNameTeacher.setText( items.get(position).getTeacherName());
        }catch (Exception ex){ex.printStackTrace();}


        return view;




    }

    public static class ViewHolder{

        TextView tvPspIdStudent, tvPspNameStudent, tvPspNameTeacher;




    }
}
