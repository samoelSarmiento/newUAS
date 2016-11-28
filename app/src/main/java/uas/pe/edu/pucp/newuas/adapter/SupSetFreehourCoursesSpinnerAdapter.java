package uas.pe.edu.pucp.newuas.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import uas.pe.edu.pucp.newuas.model.PSPProcess;

/**
 * Created by Franz on 28/11/2016.
 */

public class SupSetFreehourCoursesSpinnerAdapter extends ArrayAdapter<String> {

        Context context;

        ArrayList<PSPProcess> lista;

public SupSetFreehourCoursesSpinnerAdapter(Context context, int resource , ArrayList<PSPProcess> lista) {
        super(context, resource);

        this.context = context;
        this.lista = lista;
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
            cadena  = lista.get(position).getCurso();
            return cadena;
        }

@Override
public void setDropDownViewResource(int resource) {
        super.setDropDownViewResource(resource);
        }
}
