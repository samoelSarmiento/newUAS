package uas.pe.edu.pucp.newuas.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.model.PSPGrade;
import uas.pe.edu.pucp.newuas.model.Student;

/**
 * Created by Franz on 04/11/2016.
 */

public class PSPStudentGradesAdapter   extends BaseAdapter {


    private ArrayList<PSPGrade> items;
    private Context context;
    private LayoutInflater layoutInflater;


    public PSPStudentGradesAdapter(Context context, ArrayList<PSPGrade> items) {
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
            view = layoutInflater.inflate(R.layout.psp_item_student_grades, null);

        Log.d("Adapter", "LLego");

        try {
           ViewHolder viewHolder = new ViewHolder();
            viewHolder.tvViewIdentifierGrade = (TextView) view.findViewById(R.id.tv_item_psp_grade_description);
            viewHolder.tvGrade = (TextView) view.findViewById(R.id.tv_item_psp_grade);


            viewHolder.tvViewIdentifierGrade.setText("Nota " + (position+1));
            viewHolder.tvGrade.setText(String.valueOf(items.get(position).getNota()) );


        } catch (Exception ex) {
            ex.printStackTrace();
        }


        return view;


    }


    public static class ViewHolder {
        TextView tvViewIdentifierGrade, tvGrade;

    }
}
