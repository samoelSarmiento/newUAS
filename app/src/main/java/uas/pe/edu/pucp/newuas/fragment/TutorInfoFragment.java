package uas.pe.edu.pucp.newuas.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.model.TUTInfoResponse;


public class TutorInfoFragment extends Fragment {

    TextView teacher_detail_nombre;
    TextView teacher_detail_apellido;
    TextView teacher_detail_email;
    TextView teacher_detail_oficina;
    TextView teacher_detail_anexo;
    TextView teacher_detail_telefono;

    public TutorInfoFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        TUTInfoResponse tutG;

        View view =   inflater.inflate(R.layout.fragment_tutor_info, container, false);

        teacher_detail_nombre = (TextView)view.findViewById(R.id.teacher_detail_nombre);
        teacher_detail_apellido = (TextView)view.findViewById(R.id.teacher_detail_Apellido);
        teacher_detail_email = (TextView)view.findViewById(R.id.teacher_detail_email);
        teacher_detail_oficina = (TextView)view.findViewById(R.id.teacher_detail_oficina);
        teacher_detail_anexo = (TextView)view.findViewById(R.id.teacher_detail_anexo);
        teacher_detail_telefono = (TextView)view.findViewById(R.id.teacher_detail_telefono);

        Bundle bundle = this.getArguments();
        List<TUTInfoResponse> tutGroup= null;
        if (bundle != null){
            tutGroup= (List<TUTInfoResponse>) bundle.getSerializable("Tutoria");
        }
        tutG=tutGroup.get(0);

        teacher_detail_nombre.setText(tutG.getNombre());
        teacher_detail_apellido.setText(tutG.getApellidoPaterno() + " " + tutG.getApellidoMaterno());
        teacher_detail_email.setText(tutG.getCorreo());
        teacher_detail_oficina.setText(tutG.getOficina());
        teacher_detail_anexo.setText(tutG.getAnexo());
        teacher_detail_telefono.setText(tutG.getTelefono());

        getArguments().remove("Tutoria");

        return view;

    }

    @Override
    public void onStart(){
        super.onStart();
    }



}
