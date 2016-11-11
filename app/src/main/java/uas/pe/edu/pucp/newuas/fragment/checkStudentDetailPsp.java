package uas.pe.edu.pucp.newuas.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.model.Investigator;
import uas.pe.edu.pucp.newuas.model.TutStudentForPsp;
import uas.pe.edu.pucp.newuas.view.NavigationDrawerPSP;


public class checkStudentDetailPsp extends Fragment {

    public checkStudentDetailPsp() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        TutStudentForPsp estudiante = new TutStudentForPsp() ;

        View view = inflater.inflate(R.layout.fragment_check_student_detail_psp, container, false);

        TextView tvValueCodigo = (TextView) view.findViewById(R.id.codigoPspStudentTutValue);
        TextView tvValueNombre = (TextView) view.findViewById(R.id.nombrePspStudentTutValue);
        TextView tvValueApellido = (TextView) view.findViewById(R.id.apellidoPspStudentTutValue);
        TextView tvValueCorreo = (TextView) view.findViewById(R.id.correoPspStudentTutValue);
        Button botonVolver = (Button)view.findViewById(R.id.btVolverPspTutStudent);

        Bundle bundle = this.getArguments();
        List<TutStudentForPsp> listaEstudiantes=null;

        if (bundle != null){

            listaEstudiantes= (List<TutStudentForPsp>) bundle.getSerializable("tutstudentpsp");

        }
      //  Toast.makeText(getActivity(), listaEstudiantes.get(0).getCorreo(), Toast.LENGTH_SHORT).show();


        tvValueCodigo.setText(listaEstudiantes.get(0).getCodigo() ) ;
        tvValueNombre.setText(listaEstudiantes.get(0).getNombre() ) ;
        tvValueApellido.setText(listaEstudiantes.get(0).getApePaterno() + " " + listaEstudiantes.get(0).getApeMaterno()) ;
        tvValueCorreo.setText(listaEstudiantes.get(0).getCorreo() ) ;

        botonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intentPSP = new Intent(getActivity(), NavigationDrawerPSP.class);
                startActivity(intentPSP);
            }
        });


        return view;
    }

}
