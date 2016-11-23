package uas.pe.edu.pucp.newuas.adapter;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.controller.PSPController;
import uas.pe.edu.pucp.newuas.fragment.PSP_SupxStudentMeetingDetailFragment;
import uas.pe.edu.pucp.newuas.model.PSPMeeting;
import uas.pe.edu.pucp.newuas.model.Student;

/**
 * Created by Franz on 10/11/2016.
 */

public class PSPSupxStudentMeetingAdapter extends BaseAdapter{


    List<PSPMeeting> items;
    Context context;
    Student student;
    LayoutInflater layoutInflater;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.US);


    public PSPSupxStudentMeetingAdapter(Context context , List<PSPMeeting> items, Student student ){

        this.student = student;

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
        return items.get(position).getIdMeeting();
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {


        View view = layoutInflater.inflate(R.layout.item_psp_sup_student_meetings,null);

        ViewHolder viewHolder = new ViewHolder(view);

        String date = simpleDateFormat.format(items.get(position).getFecha());

        viewHolder.date.append(date);
        viewHolder.idMeeting.append("" + items.get(position).getIdMeeting());
      // String atHour = simpleDateFormat.format(items.get(position).getHora_inicio());
        viewHolder.atHour.append(items.get(position).getHora_inicio());
        //String toHour = simpleDateFormat.format(items.get(position).getHore_fin());
        viewHolder.toHour.append(items.get(position).getHora_fin());
        String status;
        int tipo_estado = items.get(position).getStatus().getIdStatus();
        if(tipo_estado== 1)
            status = "Pendiente";
        else if(tipo_estado == 2)
            status = "Realizada";
        else
            status = "Cancelado";

        viewHolder.status.append(status);

        viewHolder.icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup =  new PopupMenu(context,v);
                popup.getMenuInflater().inflate(R.menu.supxstudentmeeting_popup, popup.getMenu());
                popup.show();

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch(item.getItemId()){
                            case R.id.menu_item_meeting_student_showDetails:

                                PSPMeeting meeting = items.get(position);

                                Fragment fragment = new PSP_SupxStudentMeetingDetailFragment();
                                Bundle bundle = new Bundle();

                                bundle.putSerializable("PSPMeeting",meeting);
                                bundle.putSerializable("Student", student);
                                fragment.setArguments(bundle);


                                ((Activity)context).getFragmentManager().beginTransaction().setCustomAnimations(R.animator.enter,R.animator.exit,R.animator.slide_out_right,R.animator.slide_in_right)
                                        .replace(R.id.fragment_container_psp,fragment).addToBackStack(null).commit();




                                break;

                            case R.id.menu_item_meeting_student_notification:

                                PSPController controller =  new PSPController();
                                controller.supSendNotificationToStudent(context,student);
                                break;

                        }

                        return true;
                    }
                });


            }
        });



        return view;
    }


    public static class ViewHolder{
        TextView idMeeting, date, atHour, toHour, status;
        ImageView icon;


        public ViewHolder(View view) {


                idMeeting = (TextView)view.findViewById(R.id.tv_item_psp_sup_student_meeting_id);
                date = (TextView)view.findViewById(R.id.tv_item_psp_sup_student_meeting_date);
                atHour = (TextView)view.findViewById(R.id.tv_item_psp_sup_student_meeting_atHour);
                toHour = (TextView)view.findViewById(R.id.tv_item_psp_sup_student_meeting_toHour);
                status = (TextView)view.findViewById(R.id.tv_item_psp_sup_student_meeting_status);
                icon = (ImageView)view.findViewById(R.id.iv_item_psp_sup_student_meeting_icon);



        }

    }
}
