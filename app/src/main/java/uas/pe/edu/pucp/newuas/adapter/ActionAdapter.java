package uas.pe.edu.pucp.newuas.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.model.Action;
import uas.pe.edu.pucp.newuas.model.ImprovementPlan;
import uas.pe.edu.pucp.newuas.model.Teacher;

/**
 * Created by Marshall on 3/11/2016.
 */
public class ActionAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Action> items;
    private LayoutInflater layoutInflater;

    public ActionAdapter(Context context, ArrayList<Action> items) {
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
        return items.get(position).getIdPlanAccion();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.item_improvement_plan_action, null);
        ViewHolder viewHolder = new ViewHolder();

        viewHolder.tvActSem = (TextView) view.findViewById(R.id.tvactionsemester);
        viewHolder.tvActDesc = (TextView) view.findViewById(R.id.tvactiondesc);
        viewHolder.tvActResp = (TextView) view.findViewById(R.id.tvactionresp);
        viewHolder.tvActComm = (TextView) view.findViewById(R.id.tvactioncomm);
        viewHolder.tvActPerc = (TextView) view.findViewById(R.id.tvactionperc);

        viewHolder.tvActSem.setText(items.get(position).getSemester().getDescripcion());
        viewHolder.tvActDesc.setText(items.get(position).getDescripcion());


        Teacher tch = items.get(position).getTeacher();
        if (tch != null)
            viewHolder.tvActResp.setText("Por: " + tch.getNombre() + " " + tch.getApellidoPaterno() + " " + tch.getApellidoPaterno());
        else{
            viewHolder.tvActResp.setText("Por: Todos");
        }

        if(items.get(position).getComentario()==null){
            viewHolder.tvActComm.setText("Sin comentarios");
        }else{
            viewHolder.tvActComm.setText(items.get(position).getComentario());
        }

        if(items.get(position).getPorcentaje()==null){
            viewHolder.tvActPerc.setText("0%");
        }else{
            viewHolder.tvActPerc.setText(items.get(position).getPorcentaje() + "%");
        }





        return view;


    }

    private static class ViewHolder {
        TextView tvActSem;
        TextView tvActDesc;
        TextView tvActResp;
        TextView tvActComm;
        TextView tvActPerc;

    }
}
