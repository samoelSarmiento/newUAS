package uas.pe.edu.pucp.newuas.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import uas.pe.edu.pucp.newuas.model.Student;

/**
 * Created by Franz on 21/11/2016.
 */

public class SupStudentsNewMeetingSpinnerAdapter extends ArrayAdapter<String> {

    Context context;
    ArrayList<Student> lista;


    public SupStudentsNewMeetingSpinnerAdapter(Context context, int resource,  ArrayList<Student> lista) {
        super(context, resource);
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size() + 1;
    }

    @Nullable
    @Override
    public String getItem(int position) {

        String cadena= null;
        if(position == 0){
            cadena = "--Seleccionar--";

        }else {
            position--;
            cadena = lista.get(position).getNombre() + " " + lista.get(position).getApellidoPaterno() + " " +
                    lista.get(position).getApellidoMaterno();
        }
        return cadena;
    }

    @Override
    public void setDropDownViewResource(int resource) {
        super.setDropDownViewResource(resource);
    }




}
