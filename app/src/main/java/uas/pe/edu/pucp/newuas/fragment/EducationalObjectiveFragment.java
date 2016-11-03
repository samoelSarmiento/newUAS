package uas.pe.edu.pucp.newuas.fragment;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.controller.EducationalObjectiveController;
import uas.pe.edu.pucp.newuas.model.EducationalObjective;

public class EducationalObjectiveFragment extends Fragment {


    public EducationalObjectiveFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_educational_objective, container, false);
        TextView tvNumber = (TextView) view.findViewById(R.id.tvValueNumber);
        TextView tvDesc = (TextView) view.findViewById(R.id.tvValueDescription);
        Button btResEst = (Button) view.findViewById(R.id.btResultadoEstudiantil);
        final Context context = getActivity();
        Bundle bundle = getArguments();
        if (bundle != null) {
            final EducationalObjective eo = (EducationalObjective) bundle.getSerializable("eo");
            if (eo != null) {
                String number = eo.getNumero() + "";
                tvNumber.setText(number);
                tvDesc.setText(eo.getDescripcion());
                btResEst.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EducationalObjectiveController controller = new EducationalObjectiveController();
                        controller.getStudentResults(context, eo.getIdEspecialidad(), eo.getIdObjetivoEducacional());
                    }
                });
            }
        }
        return view;
    }
}
