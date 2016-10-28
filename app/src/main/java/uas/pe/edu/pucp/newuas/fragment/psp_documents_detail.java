package uas.pe.edu.pucp.newuas.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
//import android.net.Uri;
import android.os.Bundle;
//import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.model.PSPDocument;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link psp_documents_detail.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link psp_documents_detail#newInstance} factory method to
 * create an instance of this fragment.
 */
public class psp_documents_detail extends Fragment {

    TextView text1, text2,text3 ;
    Button editBut;



    PSPDocument documento ;

    public psp_documents_detail() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_psp_documents_detail, container, false);

        getActivity().setTitle("Documentos");

        text1=(TextView) view.findViewById(R.id.doc1PSP);
        text2=(TextView) view.findViewById(R.id.doc2PSP);
        text3=(TextView) view.findViewById(R.id.doc3PSP);
        //   invEsp=(TextView) view.findViewById(R.id.invEsp);
           editBut=(Button)view.findViewById(R.id.butDescargarPSP) ;

        Bundle bundle = this.getArguments();
        List<PSPDocument> investigator=null;
        if (bundle != null){

            investigator= (List<PSPDocument>) bundle.getSerializable("PSPDocument");
        }
        documento=investigator.get(0);
        text1.setText(documento.idPSPDocument );
        text2.setText(documento.observaciones );
        text3.setText(documento.ruta);
        //   invEsp.setText(investigator.get(0).getFaculty().getNombre());

        editBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return view;
    }





    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */

}
