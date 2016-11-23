package uas.pe.edu.pucp.newuas.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.model.CitaInfoResponse;
import uas.pe.edu.pucp.newuas.model.StudentInfoResponse;


public class VisualizarCitaFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_visualizar_cita, container, false);


        TextView codigoCita = (TextView) view.findViewById(R.id.VerCodigoAtenderCita);
        TextView alumnoCita = (TextView) view.findViewById(R.id.VerAlumnoAtenderCita);
        TextView fechaCita = (TextView) view.findViewById(R.id.VerFechaAtenderCita);
        TextView horaI = (TextView) view.findViewById(R.id.VerHoraIAtenderCita);
        TextView lugarCita = (TextView) view.findViewById(R.id.VerLugarAtenderCita);
        TextView extraCita = (TextView) view.findViewById(R.id.VerExtraAtenderCita);
        TextView obsCita = (TextView) view.findViewById(R.id.VerObsAtenderCita);

        Bundle bundle = this.getArguments();
        List<CitaInfoResponse> tutGroup= null;
        if (bundle != null){
            tutGroup= (List<CitaInfoResponse>) bundle.getSerializable("Tutoria");
        }
        List<StudentInfoResponse> infoAlumno =  tutGroup.get(0).getStudentInfo();

        String idCita = tutGroup.get(0).getId() + "";
        String codigoNombreAlumno = infoAlumno.get(0).getCodigo() + "-" + infoAlumno.get(0).getNombre() + " " + infoAlumno.get(0).getApePaterno();
        String fechaCompleta =  tutGroup.get(0).getInicio();
        String fecha = fechaCompleta.substring(0,10);
        String hora = fechaCompleta.substring(11,16);
        int horaEnt = Integer.parseInt(hora.substring(0,2));
        if(horaEnt < 12) hora = hora + " am";
        else hora = hora + " pm";

        String lugarC = tutGroup.get(0).getLugar();
        String extra = tutGroup.get(0).getAdicional();
        String obs = tutGroup.get(0).getObservacion();


        codigoCita.setText(idCita);
        alumnoCita.setText(codigoNombreAlumno);
        fechaCita.setText(fecha);
        horaI.setText(hora);
        lugarCita.setText(lugarC);
        extraCita.setText(extra);
        obsCita.setText(obs);

        return view;


    }


}
