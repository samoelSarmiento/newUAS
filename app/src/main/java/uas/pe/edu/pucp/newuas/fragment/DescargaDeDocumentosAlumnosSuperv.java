package uas.pe.edu.pucp.newuas.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.adapter.DocumentsForSupAdapter;
import uas.pe.edu.pucp.newuas.adapter.PSPDocumentsAdapter;
import uas.pe.edu.pucp.newuas.controller.PSPController;
import uas.pe.edu.pucp.newuas.controller.PSPControllerJ;
import uas.pe.edu.pucp.newuas.model.DocumentStudentPsp;
import uas.pe.edu.pucp.newuas.model.MyToast;
import uas.pe.edu.pucp.newuas.model.Student;

public class DescargaDeDocumentosAlumnosSuperv extends Fragment {

    ListView lvDocuments;
    DocumentsForSupAdapter documentsAdapter;
    public static DocumentStudentPsp documentSelected  ;

    public DescargaDeDocumentosAlumnosSuperv() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_descarga_de_documentos_alumnos_superv, container, false);
        getActivity().setTitle("Documentos ");
        lvDocuments  = (ListView) view.findViewById(R.id.psp_documentListSu);
        Bundle bundle = this.getArguments();
        if (bundle != null){
            ArrayList<DocumentStudentPsp> documents = (ArrayList<DocumentStudentPsp>) bundle.getSerializable("DocumentsPSP");
            documentsAdapter = new DocumentsForSupAdapter(getActivity(), documents);
            lvDocuments.setAdapter(documentsAdapter);

        }
        lvDocuments.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
           //     Toast.makeText(getActivity(), "Proximamente", Toast.LENGTH_SHORT).show();
                documentSelected = (DocumentStudentPsp) documentsAdapter.getItem(position);
                MyToast.makeText(getActivity(), "Item seleccionado " + documentSelected.getId() , Toast.LENGTH_SHORT, MyToast.infoAlert).show();

                PSPControllerJ controller = new PSPControllerJ();
                controller.obtenerDocumentosFullAlumnoSuperv(  getActivity() ,documentSelected.getId()  );


             //   DocumentPspStudentSupervFragment fragmentCalled = new DocumentPspStudentSupervFragment();
             //   ( getActivity()).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container_psp,fragmentCalled).commit();
            }
        });
        return  view ;
    }


}
