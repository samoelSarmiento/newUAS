package uas.pe.edu.pucp.newuas.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.model.ImprovementPlan;
import uas.pe.edu.pucp.newuas.model.Period;

/**
 * Created by Marshall on 2/11/2016.
 */

public class ImprovementPlanAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<ImprovementPlan> items;
    private LayoutInflater layoutInflater;

    public ImprovementPlanAdapter(Context context, ArrayList<ImprovementPlan> items) {
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
        return items.get(position).getIdPlanMejora();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.item_improvement_plan, null);
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.tvIpDesc = (TextView) view.findViewById(R.id.tviplistname);
        viewHolder.tvIpUser = (TextView) view.findViewById(R.id.tviplistuser);
        viewHolder.tvIpStatus = (TextView) view.findViewById(R.id.tvipliststatus);

        viewHolder.tvIpDesc.setText(items.get(position).getDescripcion());
        if (items.get(position).getTeacher() == null) {
            String todos = "Todos";
            viewHolder.tvIpUser.setText(todos);
        } else {
            viewHolder.tvIpUser.setText(items.get(position).getTeacher().getNombre() + " " + items.get(position).getTeacher().getApellidoPaterno() + " " + items.get(position).getTeacher().getApellidoMaterno());
        }
        viewHolder.tvIpStatus.setText(items.get(position).getEstado());
        if (items.get(position).getEstado().equals("Pendiente")){
            viewHolder.tvIpStatus.setTextColor(Color.YELLOW);

        }
        if (items.get(position).getEstado().equals("En Ejecución")){
            viewHolder.tvIpStatus.setTextColor(Color.rgb(164, 198, 57));

        }
        if (items.get(position).getEstado().equals("Cerrado")){
            viewHolder.tvIpStatus.setTextColor(Color.RED);

        }



        return view;
    }

    private static class ViewHolder {
        TextView tvIpDesc;
        TextView tvIpUser;
        TextView tvIpStatus;


    }
}
