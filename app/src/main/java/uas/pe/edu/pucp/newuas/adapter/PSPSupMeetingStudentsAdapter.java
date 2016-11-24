package uas.pe.edu.pucp.newuas.adapter;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.fragment.PSP_SupStudentNewMeetingFragment;
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
    public View getView(final int position, final View convertView, ViewGroup parent) {


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
        viewHolder.icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    PopupMenu popup = new PopupMenu(context,v);
                    popup.getMenuInflater().inflate(R.menu.supstudentmeeting_popup, popup.getMenu());
                    popup.show();

                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            switch (item.getItemId()){

                                case R.id.menu_item_student_showMeeting:
                                    Toast.makeText(context,"Ver citas", Toast.LENGTH_SHORT).show();
                                    break;

                                case R.id.menu_item_student_requestMeeting:

                                    /*
                                    Fragment fragment = PSP_SupStudentNewMeetingFragment.newInstance(items.get(position));
                                    ((Activity)context).getFragmentManager().beginTransaction().replace(R.id.fragment_container_psp,fragment)
                                            .addToBackStack(null).commit();
                                    Toast.makeText(context,"Add meeting", Toast.LENGTH_SHORT).show();*/
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
        TextView name, identifier, mail;
        ImageView icon;


        public ViewHolder() {





        }

    }

}
