package uas.pe.edu.pucp.newuas.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.controller.ImprovementPlanController;
import uas.pe.edu.pucp.newuas.model.Suggestion;
import uas.pe.edu.pucp.newuas.model.SuggestionRequest;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewSuggerenceFragment extends Fragment {
    private final String regex = "[a-zA-Z ]+";

    public NewSuggerenceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new_suggerence, container, false);
        final EditText etTitulo = (EditText) view.findViewById(R.id.etTitle);
        final EditText etSuggerence = (EditText) view.findViewById(R.id.etValueSuggerence);
        Button btSave = (Button) view.findViewById(R.id.btnSave);
        Bundle bundle = getArguments();
        if (bundle != null) {
            final int ipId = bundle.getInt("ipId");
            btSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String titulo = etTitulo.getText().toString();
                    String sugerencia = etSuggerence.getText().toString();
                    if (!titulo.isEmpty() && !sugerencia.isEmpty()) {
                        if (titulo.matches(regex) && sugerencia.matches(regex)) {
                            ImprovementPlanController controller = new ImprovementPlanController();

                            SuggestionRequest request =
                                    new SuggestionRequest(Configuration.LOGIN_USER.getUser().getTeacher().getIdDocente(),
                                            Configuration.LOGIN_USER.getUser().getTeacher().getIdEspecialidad(),
                                            titulo, sugerencia);
                            controller.sendSuggestion(getActivity(), ipId, request);
                        } else {
                            Toast.makeText(getActivity(), "Solo se aceptan letras", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(getActivity(), "Ingrese un titulo o sugerencia", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
        return view;
    }

}
