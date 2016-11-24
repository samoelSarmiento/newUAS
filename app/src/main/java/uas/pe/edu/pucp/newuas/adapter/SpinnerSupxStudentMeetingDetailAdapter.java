package uas.pe.edu.pucp.newuas.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import uas.pe.edu.pucp.newuas.model.Status;

/**
 * Created by Franz on 23/11/2016.
 */

public class SpinnerSupxStudentMeetingDetailAdapter extends ArrayAdapter<String> {

    Context context;

    ArrayList<Status> lista;

    public SpinnerSupxStudentMeetingDetailAdapter(Context context, int resource , ArrayList<Status> lista) {
        super(context, resource);

        this.context = context;
        this.lista = lista;
    }


    @Override
    public int getPosition(String item) {
        Log.d("ITEM", item);

        for(int i = 0; i <lista.size() ; i++)
            if (lista.get(i).getDescription().contains(item)) return i +1;
        return -1;
    }

    @Override
    public int getCount() {
        return lista.size() + 1;
    }

    @Nullable
    @Override
    public String getItem(int position) {
        String cadena  = null;

        position = position- 1;
        if(position< 0)
            cadena = "--Seleccionar--";
        else
            cadena  = lista.get(position).getDescription();


        return cadena;
    }

    @Override
    public void setDropDownViewResource(int resource) {
        super.setDropDownViewResource(resource);
    }
}