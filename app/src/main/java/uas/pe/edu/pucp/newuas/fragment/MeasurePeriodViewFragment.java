package uas.pe.edu.pucp.newuas.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.adapter.MeasurePeriodAdapter;
import uas.pe.edu.pucp.newuas.controller.EducationalObjectiveController;
import uas.pe.edu.pucp.newuas.controller.MeasureInstrumentsController;
import uas.pe.edu.pucp.newuas.controller.SemesterController;
import uas.pe.edu.pucp.newuas.model.Period;

/**
 * Created by Marshall on 24/10/2016.
 */

public class MeasurePeriodViewFragment extends Fragment {
    Period period = null;
    Integer idPeriod = null;

    public MeasurePeriodViewFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("Periodo");

        View view = inflater.inflate(R.layout.fragment_measureperiodview, container, false);

        TextView tvMeasureResStartSemester = (TextView) view.findViewById(R.id.tvMeasureResStartSemester);
        TextView tvMeasureResEndSemester = (TextView) view.findViewById(R.id.tvMeasureResEndSemester);
        TextView tvMeasureCritLevel = (TextView) view.findViewById(R.id.tvMeasureCritLevel);
        TextView tvMeasureAccLevel = (TextView) view.findViewById(R.id.tvMeasureAccLevel);
        TextView tvMeasureAccPerc = (TextView) view.findViewById(R.id.tvMeasureAccPerc);

        Button btnMeaInst = (Button) view.findViewById(R.id.btnMeaInst);
        Button btnSemPer = (Button) view.findViewById(R.id.btnSemestersofPeriod);
        Button btnEduObj = (Button) view.findViewById(R.id.btnObjEdu);

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            final Period str = (Period) bundle.getSerializable("Period");
            tvMeasureResStartSemester.setText(str.getConfiguration().getCycleAcademicStart().getDescripcion());
            tvMeasureResEndSemester.setText(str.getConfiguration().getCycleAcademicEnd().getDescripcion());
            tvMeasureCritLevel.setText(str.getConfiguration().getCantNivelCriterio() + "");
            tvMeasureAccLevel.setText(str.getConfiguration().getNivelEsperado() + "");
            tvMeasureAccPerc.setText(str.getConfiguration().getUmbralAceptacion() + "%");
            this.period = str;
            this.idPeriod = period.getIdPeriodo();

            btnMeaInst.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MeasureInstrumentsController mic = new MeasureInstrumentsController();
                    mic.getMeasureInstrumentsOfPeriod(str.getIdPeriodo(), getActivity());
                }
            });

            btnSemPer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SemesterController sc = new SemesterController();
                    sc.getSemestersofPeriod(getActivity(), str.getIdPeriodo());

                }
            });

            btnEduObj.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EducationalObjectiveController eoc = new EducationalObjectiveController();
                    eoc.getEducationalObjectivesofPeriodSpec(getActivity(), str.getIdPeriodo(), str.getIdEspecialidad());
                }
            });
        }
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();


    }
}
