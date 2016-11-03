package uas.pe.edu.pucp.newuas.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.model.Student;

/**
 * Created by Franz on 28/10/2016.
 */

public class PSPSupDocumentAdapter extends BaseAdapter {


    ArrayList<Student> items;
    Context context;
    LayoutInflater layoutInflater;

    public PSPSupDocumentAdapter(Context context, ArrayList<Student> items) {
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
        View view = layoutInflater.inflate(R.layout.fragment_psp_documents_item,null);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.studentName.setText(items.get(position).getNombre() + " " + items.get(position).getApellidoPaterno() + " " + items.get(position).getApellidoMaterno());
        //viewHolder.invMail.setText(items.get(position).getCorreo());
        return view;
    }

    public static class ViewHolder{
        TextView studentName;
        TextView invMail;

        public ViewHolder(View view) {
            studentName = (TextView)view.findViewById(R.id.student_item_name);
            //invMail = (TextView)view.findViewById(R.id.inv_mail);
        }

    }}
