package uas.pe.edu.pucp.newuas.fragment;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.adapter.EvaluationAdapter;
import uas.pe.edu.pucp.newuas.adapter.EvaluationNameStateAdapter;
import uas.pe.edu.pucp.newuas.model.Evaluation;

public class EvaluationFragment extends Fragment {
    public EvaluationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_evaluation, container, false);
        Bundle bundle = getArguments();
        if (bundle != null) {
            Evaluation eva = (Evaluation) bundle.getSerializable("Evaluacion");
            TextView tvNameEvaluation = (TextView) view.findViewById(R.id.tvNameEvaluation);
            TextView tvValueEstado = (TextView) view.findViewById(R.id.tvValueEstado);
            TextView tvValueFechaInicio = (TextView) view.findViewById(R.id.tvValueFechaInicio);
            TextView tvValueFechaFin = (TextView) view.findViewById(R.id.tvValueFechaFin);
            TextView tvValueDescription = (TextView) view.findViewById(R.id.tvValueDescription);
            TextView tvValueTime = (TextView) view.findViewById(R.id.tvValueTime);
            if (eva != null) {
                tvNameEvaluation.setText(eva.getNombre());
                if (eva.getEstado() == 0) tvValueEstado.setText(R.string.no_vigente);
                else tvValueEstado.setText(R.string.vigente);
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                SimpleDateFormat display = new SimpleDateFormat("dd-MM-yyyy", new Locale("es", "ES"));
                String fechaInicio = eva.getFecha_Inicio();
                String fechaFin = eva.getFecha_Fin();
                try {
                    Date fInicio = format.parse(fechaInicio);
                    tvValueFechaInicio.setText(display.format(fInicio));
                    Date fFin = format.parse(fechaFin);
                    tvValueFechaFin.setText(display.format(fFin));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                tvValueDescription.setText(eva.getDescripcion());
                String tiempo = eva.getTiempo() + " minutos";
                tvValueTime.setText(tiempo);
            }
        }
        return view;
    }
}
