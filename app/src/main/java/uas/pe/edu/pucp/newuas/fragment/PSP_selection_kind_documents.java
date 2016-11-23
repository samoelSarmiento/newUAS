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

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.controller.PSPControllerJ;
import uas.pe.edu.pucp.newuas.controller.SpecialtyController;
import uas.pe.edu.pucp.newuas.view.NavigationDrawerInvestigacion;
import uas.pe.edu.pucp.newuas.view.NavigationDrawerPSP;
import uas.pe.edu.pucp.newuas.view.NavigationDrawerTutoria;

public class PSP_selection_kind_documents extends Fragment  {


    LayoutInflater layoutInflater;
    Context context  ;
    Button informe , documentos;
    public PSP_selection_kind_documents() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_psp_selection_kind_documents, container, false);
        documentos = (Button)view.findViewById(R.id.psp_boton_documentos_supervisor);
        informe = (Button)view.findViewById(R.id.psp_boton_informe_supervisor);
        informe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PSPControllerJ controller = new PSPControllerJ();
                controller.obtenerInforme(getActivity() );
            }
        });
        documentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PSPControllerJ controller = new PSPControllerJ();
                controller.getDocumentsStudentSup(getActivity() );
            }
        });
        getActivity().setTitle("Tipo de documento");
        return view;
    }



}
