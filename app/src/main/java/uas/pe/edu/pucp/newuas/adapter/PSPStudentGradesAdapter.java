package uas.pe.edu.pucp.newuas.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.controller.PSPController;
import uas.pe.edu.pucp.newuas.model.PSPGrade;
import uas.pe.edu.pucp.newuas.model.PSPNotificationScpreRequest;
import uas.pe.edu.pucp.newuas.model.PSPStudentFinalGrade;
import uas.pe.edu.pucp.newuas.model.Student;

/**
 * Created by Franz on 04/11/2016.
 */

public class PSPStudentGradesAdapter   extends BaseAdapter {


    private ArrayList<PSPStudentFinalGrade> items;
    private Context context;
    private LayoutInflater layoutInflater;


    public PSPStudentGradesAdapter(Context context, ArrayList<PSPStudentFinalGrade> items) {
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
    public View getView(final int position, View convertView, ViewGroup parent) {


        View view = layoutInflater.inflate(R.layout.psp_item_student_grades, null);

        Log.d("Adapter", "LLego");

        try {
           ViewHolder viewHolder = new ViewHolder();
            viewHolder.tvStudentName = (TextView) view.findViewById(R.id.tv_item_psp_grade_student_name);
            viewHolder.tvGrade = (TextView) view.findViewById(R.id.tv_item_psp_grade_finalscore);
            viewHolder.tvStudentId = (TextView) view.findViewById(R.id.tv_item_psp_grade_student_id);
            viewHolder.mail = (ImageButton) view.findViewById(R.id.iv_item_psp_grade_mail);

            viewHolder.mail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PSPNotificationScpreRequest score = new PSPNotificationScpreRequest();

                    Log.d("POSITION","" + position);
                    score.setCodigo(items.get(position).getIdAlumno());
                    score.setScore(items.get(position).getGrade());
                    PSPController controller = new PSPController();
                    controller.notififyScore(context,score);

                }
            });

            viewHolder.tvStudentName.setText(items.get(position).getNombre() + " "
                    + items.get(position).getApellidoPaterno() + " "
                    + items.get(position).getApellidoMaterno());
            viewHolder.tvStudentId.setText(items.get(position).getCodigo());
            int grade = items.get(position).getGrade();
            if(grade >= 0 )
                 viewHolder.tvGrade.setText(String.valueOf(items.get(position).getGrade()) );


        } catch (Exception ex) {
            ex.printStackTrace();
        }


        return view;


    }


    public static class ViewHolder {
        TextView tvStudentName, tvGrade , tvStudentId;
        ImageButton mail;

    }
}
