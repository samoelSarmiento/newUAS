package uas.pe.edu.pucp.newuas.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.model.Student;

/**
 * Created by Franz on 10/11/2016.
 */

public class PSPSupMeetingStudentsAdapter extends BaseAdapter {

    List<Student> items;
    Context context;
    LayoutInflater layoutInflater;

    public PSPSupMeetingStudentsAdapter(Context context , List<Student> items){

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
        return items.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View view = layoutInflater.inflate(R.layout.item_psp_sup_meeting_students,null);



        ViewHolder viewHolder = new ViewHolder();

        viewHolder.name = (TextView)view.findViewById(R.id.tv_item_psp_sup_meeting_student_name);
        viewHolder.identifier = (TextView)view.findViewById(R.id.tv_item_psp_sup_meeting_student_id);
        viewHolder.mail= (TextView)view.findViewById(R.id.tv_item_psp_sup_meeting_student_mail);
        viewHolder.icon = (ImageView)view.findViewById(R.id.iv_item_psp_sup_meeting_students);


        viewHolder.name.setText(items.get(position).getNombre() + " "  + items.get(position).getApellidoPaterno() + " " + items.get(position).getApellidoMaterno());

        viewHolder.identifier.setText(items.get(position).getCodigo());
        Log.d("Codigo", items.get(position).getCodigo());
        viewHolder.mail.setText(items.get(position).getCorreo());
        return view;
    }


    public static class ViewHolder{
        TextView name, identifier, mail;
        ImageView icon;


        public ViewHolder() {





        }

    }

}
