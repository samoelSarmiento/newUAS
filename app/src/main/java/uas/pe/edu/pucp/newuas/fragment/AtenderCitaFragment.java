package uas.pe.edu.pucp.newuas.fragment;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.controller.TutStudentController;
import uas.pe.edu.pucp.newuas.controller.TutTutorController;
import uas.pe.edu.pucp.newuas.model.AppointInformationRegisterTuto;
import uas.pe.edu.pucp.newuas.model.CitaInfoResponse;
import uas.pe.edu.pucp.newuas.model.MyToast;
import uas.pe.edu.pucp.newuas.model.StudentInfoResponse;


public class AtenderCitaFragment extends Fragment {

    String idCita;
    EditText obsCita;

    public AtenderCitaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_atender_cita, container, false);
        Button btnSolicitar = (Button) view.findViewById(R.id.btnSolicitarAtenderCita);
        Button btnCancelar = (Button) view.findViewById(R.id.btnCancelarAtenderCita);


        getActivity().setTitle("Atención de cita");


        TextView codigoCita = (TextView) view.findViewById(R.id.codigoAtenderCita);
        TextView alumnoCita = (TextView) view.findViewById(R.id.alumnoAtenderCita);
        TextView fechaCita = (TextView) view.findViewById(R.id.fechaAtenderCita);
        TextView horaI = (TextView) view.findViewById(R.id.horaIAtenderCita);
        TextView lugarCita = (TextView) view.findViewById(R.id.lugarAtenderCita);
        TextView extraCita = (TextView) view.findViewById(R.id.extraAtenderCita);
        obsCita = (EditText) view.findViewById(R.id.observacionAtenderCita);

        Bundle bundle = this.getArguments();
        List<CitaInfoResponse> tutGroup= null;
        if (bundle != null){
            tutGroup= (List<CitaInfoResponse>) bundle.getSerializable("Tutoria");
        }
        List<StudentInfoResponse> infoAlumno =  tutGroup.get(0).getStudentInfo();

        idCita = tutGroup.get(0).getId() + "";
        String codigoNombreAlumno = infoAlumno.get(0).getCodigo() + "-" + infoAlumno.get(0).getNombre() + " " + infoAlumno.get(0).getApePaterno();
        String fechaCompleta =  tutGroup.get(0).getInicio();
        String fecha = fechaCompleta.substring(0,10);
        String hora = fechaCompleta.substring(11,16);
        int horaEnt = Integer.parseInt(hora.substring(0,2));
        if(horaEnt < 12) hora = hora + " am";
        else hora = hora + " pm";
        String lugarC = tutGroup.get(0).getLugar();
        String extra = tutGroup.get(0).getAdicional();

        codigoCita.setText(idCita);
        alumnoCita.setText(codigoNombreAlumno);
        fechaCita.setText(fecha);
        horaI.setText(hora);
        lugarCita.setText(lugarC);
        extraCita.setText(extra);


        btnSolicitar.setOnClickListener(

                new View.OnClickListener(){
                    @Override

                    public void onClick(View v) {

                        String solicitud = "Está a punto de atender la cita ¿Desea continuar?";
                        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                switch (which) {
                                    case DialogInterface.BUTTON_POSITIVE:
                                        //Borra los shared preferences
                                        //regresa al login
                                        break;

                                    case DialogInterface.BUTTON_NEGATIVE:
                                        //Nada pasa
                                        break;
                                }
                            }
                        };
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                        builder.setMessage(solicitud).setNegativeButton("No",  new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();

                            }
                        }).setPositiveButton("Si", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                        MyToast.makeText(getActivity(), "Se ha atendido la cita!", Toast.LENGTH_LONG, MyToast.checkAlert).show();
                                        TutTutorController tsc = new TutTutorController();
                                        tsc.atencionCita(getActivity (), Integer.parseInt(idCita),obsCita.getText().toString());
                                    }
                                }
                        ).show();
                    }
                }

        );

        btnCancelar.setOnClickListener(

                new View.OnClickListener(){
                    @Override

                    public void onClick(View v) {
                        TutTutorController tsc = new TutTutorController();
                        tsc.showTopics(getActivity());
                    }
                }

        );


        return view;
    }


}
