package uas.pe.edu.pucp.newuas.fragment;

import android.content.Intent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.adapter.DocumentInformationFullAdapter;
import uas.pe.edu.pucp.newuas.adapter.PSPInscriptionFilesItemsAdapter;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.controller.FileDownloadController;
import uas.pe.edu.pucp.newuas.model.DocumentStudentPsp;
import uas.pe.edu.pucp.newuas.model.InscriptionFilePSP;
import uas.pe.edu.pucp.newuas.model.MyToast;
import uas.pe.edu.pucp.newuas.view.NavigationDrawerPSP;

public class DocumentPspStudentSupervFragment extends Fragment {

    DocumentInformationFullAdapter adapter;
    ListView lv ;
    Button btDescargarDocumento;
    Button btAceptar;
    public DocumentPspStudentSupervFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(final LayoutInflater inflater,final ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_document_psp_student_superv, container, false);
        getActivity().setTitle("Documento");
        lv = (ListView)  view.findViewById(R.id.psp_lstItemsDocumentFiles);
        Bundle bundle = this.getArguments();
        ArrayList<DocumentStudentPsp> file = null ;
        if (bundle != null){
            file = (ArrayList<DocumentStudentPsp>) bundle.getSerializable("DocumentFullPSP");
            adapter = new DocumentInformationFullAdapter (getActivity() , file  );
            lv.setAdapter(adapter);
        }

        btDescargarDocumento = (Button)view.findViewById(R.id.btDescargarDocumentoPsp );
        btAceptar = (Button)view.findViewById(R.id.btAceptarpspSobreDocumento);
        btDescargarDocumento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        String rutaDocumento = DocumentInformationFullAdapter.documento.getRuta() ;
                if ( (rutaDocumento != null) && (!rutaDocumento.equals("")) ) {
                    Toast.makeText(getActivity(), Configuration.BASE_URL + "/"+ rutaDocumento , Toast.LENGTH_SHORT).show();
                         //Descargamos el documento
                         FileDownloadController fdc = new FileDownloadController();
                         fdc.downloadFile(getActivity(), Configuration.BASE_URL + "/"+ rutaDocumento  );
                } else {
                    MyToast.makeText(getActivity(), "El alumno aún no sube el documento" , Toast.LENGTH_SHORT, MyToast.errorAlert).show();
                }
           }
        });

        btAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent  intentPSP = new Intent(getActivity(), NavigationDrawerPSP.class);
                startActivity(intentPSP);
            }
        });
        return view ;
    }
}
