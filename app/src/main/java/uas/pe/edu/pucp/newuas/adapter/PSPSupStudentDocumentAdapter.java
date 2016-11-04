package uas.pe.edu.pucp.newuas.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.model.Document;
import uas.pe.edu.pucp.newuas.model.Document;
import uas.pe.edu.pucp.newuas.model.Student;

/**
 * Created by Franz on 29/10/2016.
 */

public class PSPSupStudentDocumentAdapter extends BaseAdapter {
    ArrayList<Document> items;
    Context context;
    LayoutInflater layoutInflater;

    public PSPSupStudentDocumentAdapter(Context context, ArrayList<Document> items) {
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
        View view = layoutInflater.inflate(R.layout.item_psp_sup_student_document,null);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.name.setText(items.get(position).getObservaciones() );
        viewHolder.status.setText(items.get(position).getIdTipoEstado() + "");
        return view;
    }

    public static class ViewHolder{
        TextView name;
        TextView status;

        public ViewHolder(View view) {
            name = (TextView)view.findViewById(R.id.tv_item_psp_sup_doc_name);
            status = (TextView)view.findViewById(R.id.tv_item_psp_sup_doc_status);
        }

    }


}
