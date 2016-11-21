package uas.pe.edu.pucp.newuas.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.model.PSPGrade;
import uas.pe.edu.pucp.newuas.model.PSPMeeting;
import uas.pe.edu.pucp.newuas.model.StringResponse;

/**
 * Created by Franz on 20/11/2016.
 */

public class PSPStudentMeetingsAdapter extends BaseAdapter {


    private ArrayList<PSPMeeting> items;
    private Context context;
    private LayoutInflater layoutInflater;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.US);

    public PSPStudentMeetingsAdapter(Context context, ArrayList<PSPMeeting> items) {
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

        View  view = layoutInflater.inflate(R.layout.item_psp_student_meeting, null);

        Log.d("Adapter", "LLego");

        try {
            ViewHolder viewHolder = new ViewHolder(view);

            viewHolder.tvSupName.append(String.valueOf(position + 1));
            String date = simpleDateFormat.format(items.get(position).getFecha());
            viewHolder.tvDateMeeting.append( date );
            viewHolder.tvHourMeeting.append(items.get(position).getHora_inicio());


        } catch (Exception ex) {
            ex.printStackTrace();
        }


        return view;


    }


    public static class ViewHolder {
        TextView tvSupName, tvDateMeeting,  tvHourMeeting;
        ImageView icon;


        public ViewHolder(View view){

            tvSupName = (TextView) view.findViewById(R.id.tv_item_psp_student_meeting_sup_name);
            tvDateMeeting = (TextView) view.findViewById(R.id.tv_item_psp_student_meeting_date);
            tvHourMeeting = (TextView) view.findViewById(R.id.tv_item_psp_student_meeting_hour);
            icon= (ImageView) view.findViewById(R.id.iv_item_psp_student_meeting_arrow);





        }

    }

}
