package uas.pe.edu.pucp.newuas.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.model.Evaluation;


/**
 * Created by Pedro on 10/11/2016.
 */

public class EvaluationAdapter extends BaseAdapter {
    List<Evaluation> items;
    Context context;
    LayoutInflater layoutInflater;

    public EvaluationAdapter(Context context, List<Evaluation> items) {
        this.context = context;
        this.items = items;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Evaluation getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = layoutInflater.inflate(R.layout.item_evaluation, null);

        ViewHolder viewHolder = new ViewHolder();

        viewHolder.estado = (TextView) view.findViewById(R.id.estado);
        viewHolder.nombre = (TextView) view.findViewById(R.id.nombre);
        viewHolder.fechaInicio = (TextView) view.findViewById(R.id.fechaInicio);
        viewHolder.fechaFin = (TextView) view.findViewById(R.id.fechaFin);

        Evaluation evaluation = items.get(position);
        if (evaluation.getEstado() == 0) viewHolder.estado.setText(R.string.no_vigente);
        else viewHolder.estado.setText(R.string.vigente);

        viewHolder.nombre.setText(evaluation.getNombre());

        //parsear fecha de creacion y modificacion
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        SimpleDateFormat sdfDisplay = new SimpleDateFormat("dd MMM hh:mm a", new Locale("es", "ES"));
        try {
            Date fechaI = sdf.parse(evaluation.getFecha_Inicio());
            Date fechaFin = sdf.parse(evaluation.getFecha_Fin());
            viewHolder.fechaInicio.setText(sdfDisplay.format(fechaI));
            viewHolder.fechaFin.setText(sdfDisplay.format(fechaFin));
            //Date update = sdf.parse(evaluation.getFecha_Fin());


        } catch (ParseException e) {
            e.printStackTrace();
        }


        return view;
    }

    private static class ViewHolder {
        TextView estado, nombre, fechaInicio, fechaFin;
    }

}
