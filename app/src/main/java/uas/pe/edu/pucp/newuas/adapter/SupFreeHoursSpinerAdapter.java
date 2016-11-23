package uas.pe.edu.pucp.newuas.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import uas.pe.edu.pucp.newuas.model.PSPFreeHour;

/**
 * Created by Franz on 21/11/2016.
 */

public class SupFreeHoursSpinerAdapter extends ArrayAdapter<String> {

    Context context;

    ArrayList<PSPFreeHour> lista;

    public SupFreeHoursSpinerAdapter(Context context, int resource , ArrayList<PSPFreeHour> lista) {
        super(context, resource);

        this.context = context;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Nullable
    @Override
    public String getItem(int position) {

        String cadena  = lista.get(position).getFecha() + " " + lista.get(position).getHoraIni()+ ":00" +
                " - " + lista.get(position).getSupervisor().getName() + " " + lista.get(position).getSupervisor().getApellidoPaterno();

        return cadena;
    }

    @Override
    public void setDropDownViewResource(int resource) {
        super.setDropDownViewResource(resource);
    }
}
