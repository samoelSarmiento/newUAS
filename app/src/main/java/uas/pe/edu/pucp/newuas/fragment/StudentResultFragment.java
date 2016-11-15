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

/**
 * A simple {@link Fragment} subclass.
 */
public class StudentResultFragment extends Fragment {


    public StudentResultFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_student_result, container, false);
        TextView tvIdent = (TextView) view.findViewById(R.id.tvValueIdent);
        TextView tvDescrip = (TextView) view.findViewById(R.id.tvValueDescription);
        Button btAspect = (Button) view.findViewById(R.id.btAspects);
        Bundle bundle = getArguments();
        if (bundle != null) {
            final StudentResult result = (StudentResult) bundle.getSerializable("result");
            if (result != null) {
                tvIdent.setText(result.getIdentificador());
                tvDescrip.setText(result.getDescripcion());
                final Context context = getActivity();
                btAspect.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EducationalObjectiveController controller = new EducationalObjectiveController();
                        controller.getStudentResultAspects(context, result.getIdResultadoEstudiantil());
                    }
                });
            }
        }
        return view;
    }

}
