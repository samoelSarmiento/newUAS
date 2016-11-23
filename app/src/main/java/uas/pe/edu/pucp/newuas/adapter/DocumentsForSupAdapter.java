package uas.pe.edu.pucp.newuas.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.model.DocumentStudentPsp;

/**
 * Created by jemarroquin on 21/11/2016.
 */
public class DocumentsForSupAdapter extends BaseAdapter {
    ArrayList<DocumentStudentPsp> items;
    Context context;
    LayoutInflater layoutInflater;
    public DocumentsForSupAdapter(Context context, ArrayList<DocumentStudentPsp> items) {
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
        View view = layoutInflater.inflate(R.layout.fragment_psp_documents_sup_item,null);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.documentName.setText(items.get(position).getTituloPlantilla()  );

        return view;
    }

    public static class ViewHolder{
        TextView documentName;
        TextView invMail;

        public ViewHolder(View view) {
            documentName = (TextView)view.findViewById(R.id.document_student_superv_item_name);

        }

    }}
