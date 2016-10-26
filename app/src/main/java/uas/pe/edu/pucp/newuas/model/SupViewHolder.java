package uas.pe.edu.pucp.newuas.model;

import android.view.View;
import android.widget.TextView;

import java.awt.font.TextAttribute;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import uas.pe.edu.pucp.newuas.R;

/**
 * Created by Franz on 21/10/2016.
 */

public class SupViewHolder {
    TextView tvPspNameSupervisor, tvPspIdentifierSupervisor;




    public void buildView(View inflater, ArrayList lista, int position) {

        tvPspNameSupervisor = (TextView) inflater.findViewById(R.id.tv_psp_name_supervisor);
        tvPspIdentifierSupervisor = (TextView)  inflater.findViewById(R.id.tv_psp_identifier_supervisor);

        PSPSupervisor supervisor =(PSPSupervisor) lista.get(position);

        this.tvPspNameSupervisor.setText(supervisor.getName());
        this.tvPspIdentifierSupervisor.setText(supervisor.getCodigo());


    }


}
