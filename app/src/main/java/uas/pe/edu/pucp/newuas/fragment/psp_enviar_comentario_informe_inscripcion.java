package uas.pe.edu.pucp.newuas.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.adapter.PSPDocumentsAdapter;
import uas.pe.edu.pucp.newuas.adapter.PSPInscriptionFilesItemsAdapter;
import uas.pe.edu.pucp.newuas.controller.PSPControllerJ;
import uas.pe.edu.pucp.newuas.model.InscriptionFilePSP;
import uas.pe.edu.pucp.newuas.model.Investigator;
import uas.pe.edu.pucp.newuas.view.NavigationDrawerPSP;

public class PSP_enviar_comentario_informe_inscripcion extends Fragment implements View.OnClickListener {

Button btEnviarComentario , btCancelar ;
 //  static InscriptionFilePSP inscription ;
    EditText comentario ;
    Button guardarComentario, cancelarComentario;



    public PSP_enviar_comentario_informe_inscripcion(  ) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_psp_enviar_comentario_informe_inscripcion, container, false);
        getActivity().setTitle("Comentarios");

        comentario=(EditText) view.findViewById(R.id.editTextComentarioPSPinforme);
        btEnviarComentario=(Button) view.findViewById(R.id.btEnviarComentarioPSPaccion);
        btCancelar=(Button) view.findViewById(R.id.btEnviarComentarioPSPcancelar);
// //   inscription.setId(       PSPInscriptionFilesItemsAdapter.inscripcion.getId()   );

        btEnviarComentario.setOnClickListener(this);
        btCancelar.setOnClickListener(this);

        return view ;


    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btEnviarComentarioPSPaccion:
                //Toast.makeText(getActivity(), "entre", Toast.LENGTH_SHORT).show();

                InscriptionFilePSP inscription = new InscriptionFilePSP();
                inscription.setId( PSPInscriptionFilesItemsAdapter.inscripcion.getId()  );
                inscription.setRecomendaciones(       comentario.getText().toString()   );

                PSPControllerJ controller = new PSPControllerJ() ;
                controller.enviarComentarioInforme( getActivity() , inscription);

                Intent intentPSP = new Intent(getActivity(), NavigationDrawerPSP.class);
                startActivity(intentPSP);
                Toast.makeText(getActivity(), "Comentario enviado correctamente", Toast.LENGTH_SHORT).show();

                break;

            case R.id.btEnviarComentarioPSPcancelar:

                intentPSP = new Intent(getActivity(), NavigationDrawerPSP.class);
                startActivity(intentPSP);
                // investigatorController.getInvestigatorById(context,inv.getId());
                break;
        }




    }
}
