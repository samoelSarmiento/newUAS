package uas.pe.edu.pucp.newuas.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.adapter.PSPInscriptionFilesItemsAdapter;
import uas.pe.edu.pucp.newuas.model.InscriptionFilePSP;

public class InscriptionFilePSPJ extends Fragment   {

    PSPInscriptionFilesItemsAdapter adapter;
    ListView lv ;
    Button btEnviarComentario;
    Button btAceptar;

    public InscriptionFilePSPJ() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView( final LayoutInflater inflater,final ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_inscription_file_pspj, container, false) ;
        getActivity().setTitle("Informe de inscripcion");
        lv = (ListView)  view.findViewById(R.id.psp_lstItemsIncriptionFiles);
        Bundle bundle = this.getArguments();
        ArrayList<InscriptionFilePSP> file ;
        if (bundle != null){
             file = (ArrayList<InscriptionFilePSP>) bundle.getSerializable("InscriptionFilePSP");
            adapter = new PSPInscriptionFilesItemsAdapter (getActivity() , file  );
            lv.setAdapter(adapter);
        }


        btEnviarComentario = (Button)view.findViewById(R.id.btEnviarComentariopspSobreinscripcion);
        btAceptar = (Button)view.findViewById(R.id.btAceptarpspSobreinscripcion);

        btEnviarComentario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               PSP_enviar_comentario_informe_inscripcion fragment = new PSP_enviar_comentario_informe_inscripcion();
                (getActivity()).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container_psp,fragment).commit();


            }
        });

        btAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




            }
        });


        return view;
    }


}
