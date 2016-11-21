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
import uas.pe.edu.pucp.newuas.model.ScheduleInfoResponse;
import uas.pe.edu.pucp.newuas.model.ScheduleMeetingResponse;
import uas.pe.edu.pucp.newuas.model.TUTInfoResponse;


public class TutorInfoFragment extends Fragment {

    TextView teacher_detail_nombre;
    TextView teacher_detail_apellido;
    TextView teacher_detail_email;
    TextView teacher_detail_oficina;
    TextView teacher_detail_anexo;
    TextView teacher_detail_telefono;
    TextView lu8,lu9,lu10,lu11,lu12,lu13,lu14,lu15,lu16,lu17,lu18,lu19,lu20,lu21;
    TextView ma8,ma9,ma10,ma11,ma12,ma13,ma14,ma15,ma16,ma17,ma18,ma19,ma20,ma21;
    TextView mi8,mi9,mi10,mi11,mi12,mi13,mi14,mi15,mi16,mi17,mi18,mi19,mi20,mi21;
    TextView ju8,ju9,ju10,ju11,ju12,ju13,ju14,ju15,ju16,ju17,ju18,ju19,ju20,ju21;
    TextView vi8,vi9,vi10,vi11,vi12,vi13,vi14,vi15,vi16,vi17,vi18,vi19,vi20,vi21;
    TextView sa8,sa9,sa10,sa11,sa12,sa13,sa14,sa15,sa16,sa17,sa18,sa19,sa20,sa21;


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

        //Preparate para la bueno mi pana, espero que nunca hereden esta parte

        lu8 = (TextView)view.findViewById(R.id.lu8);
        lu9 = (TextView)view.findViewById(R.id.lu9);
        lu10 = (TextView)view.findViewById(R.id.lu10);
        lu11= (TextView)view.findViewById(R.id.lu11);
        lu12 = (TextView)view.findViewById(R.id.lu12);
        lu13 = (TextView)view.findViewById(R.id.lu13);
        lu14 = (TextView)view.findViewById(R.id.lu14);
        lu15 = (TextView)view.findViewById(R.id.lu15);
        lu16 = (TextView)view.findViewById(R.id.lu16);
        lu17 = (TextView)view.findViewById(R.id.lu17);
        lu18 = (TextView)view.findViewById(R.id.lu18);
        lu19 = (TextView)view.findViewById(R.id.lu19);
        lu20 = (TextView)view.findViewById(R.id.lu20);
        lu21 = (TextView)view.findViewById(R.id.lu21);

        ma8 = (TextView)view.findViewById(R.id.ma8);
        ma9 = (TextView)view.findViewById(R.id.ma9);
        ma10 = (TextView)view.findViewById(R.id.ma10);
        ma11= (TextView)view.findViewById(R.id.ma11);
        ma12 = (TextView)view.findViewById(R.id.ma12);
        ma13 = (TextView)view.findViewById(R.id.ma13);
        ma14 = (TextView)view.findViewById(R.id.ma14);
        ma15 = (TextView)view.findViewById(R.id.ma15);
        ma16 = (TextView)view.findViewById(R.id.ma16);
        ma17 = (TextView)view.findViewById(R.id.ma17);
        ma18 = (TextView)view.findViewById(R.id.ma18);
        ma19 = (TextView)view.findViewById(R.id.ma19);
        ma20 = (TextView)view.findViewById(R.id.ma20);
        ma21 = (TextView)view.findViewById(R.id.ma21);


        mi8 = (TextView)view.findViewById(R.id.mi8);
        mi9 = (TextView)view.findViewById(R.id.mi9);
        mi10 = (TextView)view.findViewById(R.id.mi10);
        mi11= (TextView)view.findViewById(R.id.mi11);
        mi12 = (TextView)view.findViewById(R.id.mi12);
        mi13 = (TextView)view.findViewById(R.id.mi13);
        mi14 = (TextView)view.findViewById(R.id.mi14);
        mi15 = (TextView)view.findViewById(R.id.mi15);
        mi16 = (TextView)view.findViewById(R.id.mi16);
        mi17 = (TextView)view.findViewById(R.id.mi17);
        mi18 = (TextView)view.findViewById(R.id.mi18);
        mi19 = (TextView)view.findViewById(R.id.mi19);
        mi20 = (TextView)view.findViewById(R.id.mi20);
        mi21 = (TextView)view.findViewById(R.id.mi21);

        ju8 = (TextView)view.findViewById(R.id.ju8);
        ju9 = (TextView)view.findViewById(R.id.ju9);
        ju10 = (TextView)view.findViewById(R.id.ju10);
        ju11= (TextView)view.findViewById(R.id.ju11);
        ju12 = (TextView)view.findViewById(R.id.ju12);
        ju13 = (TextView)view.findViewById(R.id.ju13);
        ju14 = (TextView)view.findViewById(R.id.ju14);
        ju15 = (TextView)view.findViewById(R.id.ju15);
        ju16 = (TextView)view.findViewById(R.id.ju16);
        ju17 = (TextView)view.findViewById(R.id.ju17);
        ju18 = (TextView)view.findViewById(R.id.ju18);
        ju19 = (TextView)view.findViewById(R.id.ju19);
        ju20 = (TextView)view.findViewById(R.id.ju20);
        ju21 = (TextView)view.findViewById(R.id.ju21);


        vi8 = (TextView)view.findViewById(R.id.vi8);
        vi9 = (TextView)view.findViewById(R.id.vi9);
        vi10 = (TextView)view.findViewById(R.id.vi10);
        vi11= (TextView)view.findViewById(R.id.vi11);
        vi12 = (TextView)view.findViewById(R.id.vi12);
        vi13 = (TextView)view.findViewById(R.id.vi13);
        vi14 = (TextView)view.findViewById(R.id.vi14);
        vi15 = (TextView)view.findViewById(R.id.vi15);
        vi16 = (TextView)view.findViewById(R.id.vi16);
        vi17 = (TextView)view.findViewById(R.id.vi17);
        vi18 = (TextView)view.findViewById(R.id.vi18);
        vi19 = (TextView)view.findViewById(R.id.vi19);
        vi20 = (TextView)view.findViewById(R.id.vi20);
        vi21 = (TextView)view.findViewById(R.id.vi21);

        sa8 = (TextView)view.findViewById(R.id.sa9);
        sa9 = (TextView)view.findViewById(R.id.sa9);
        sa10 = (TextView)view.findViewById(R.id.sa10);
        sa11= (TextView)view.findViewById(R.id.sa11);
        sa12 = (TextView)view.findViewById(R.id.sa12);
        sa13 = (TextView)view.findViewById(R.id.sa13);
        sa14 = (TextView)view.findViewById(R.id.sa14);
        sa15 = (TextView)view.findViewById(R.id.sa15);
        sa16 = (TextView)view.findViewById(R.id.sa16);
        sa17 = (TextView)view.findViewById(R.id.sa17);
        sa18 = (TextView)view.findViewById(R.id.sa18);
        sa19 = (TextView)view.findViewById(R.id.sa19);
        sa20 = (TextView)view.findViewById(R.id.sa20);
        sa21 = (TextView)view.findViewById(R.id.sa21);



        List<ScheduleInfoResponse> scm = tutGroup.get(0).getScheduleInfo();
        for (int i = 0 ; i<scm.size(); i++){
            int dia = scm.get(i).getDia();
            String horaI = scm.get(i).getHoraInicio();
            String horaStr = horaI.substring(0,2);
            int horaInt = Integer.parseInt(horaStr);
            if (dia == 1){

                if (horaInt == 8) lu8.setText("O");
                else if (horaInt == 9) lu9.setText("O");
                else if (horaInt == 10) lu10.setText("O");
                else if (horaInt == 11) lu11.setText("O");
                else if (horaInt == 12) lu12.setText("O");
                else if (horaInt == 13) lu13.setText("O");
                else if (horaInt == 14) lu14.setText("O");
                else if (horaInt == 15) lu15.setText("O");
                else if (horaInt == 16) lu16.setText("O");
                else if (horaInt == 17) lu17.setText("O");
                else if (horaInt == 18) lu18.setText("O");
                else if (horaInt == 19) lu19.setText("O");
                else if (horaInt == 20) lu20.setText("O");
                else if (horaInt == 21) lu21.setText("O");

            }
            else if (dia == 2){

                if (horaInt == 8) ma8.setText("O");
                else if (horaInt == 9) ma9.setText("O");
                else if (horaInt == 10) ma10.setText("O");
                else if (horaInt == 11) ma11.setText("O");
                else if (horaInt == 12) ma12.setText("O");
                else if (horaInt == 13) ma13.setText("O");
                else if (horaInt == 14) ma14.setText("O");
                else if (horaInt == 15) ma15.setText("O");
                else if (horaInt == 16) ma16.setText("O");
                else if (horaInt == 17) ma17.setText("O");
                else if (horaInt == 18) ma18.setText("O");
                else if (horaInt == 19) ma19.setText("O");
                else if (horaInt == 20) ma20.setText("O");
                else if (horaInt == 21) ma21.setText("O");

            }
            else if (dia == 3){

                if (horaInt == 8) mi8.setText("O");
                else if (horaInt == 9) mi9.setText("O");
                else if (horaInt == 10) mi10.setText("O");
                else if (horaInt == 11) mi11.setText("O");
                else if (horaInt == 12) mi12.setText("O");
                else if (horaInt == 13) mi13.setText("O");
                else if (horaInt == 14) mi14.setText("O");
                else if (horaInt == 15) mi15.setText("O");
                else if (horaInt == 16) mi16.setText("O");
                else if (horaInt == 17) mi17.setText("O");
                else if (horaInt == 18) mi18.setText("O");
                else if (horaInt == 19) mi19.setText("O");
                else if (horaInt == 20) mi20.setText("O");
                else if (horaInt == 21) mi21.setText("O");

            }
            else if (dia == 4){

                if (horaInt == 8) ju8.setText("O");
                else if (horaInt == 9) ju9.setText("O");
                else if (horaInt == 10) ju10.setText("O");
                else if (horaInt == 11) ju11.setText("O");
                else if (horaInt == 12) ju12.setText("O");
                else if (horaInt == 13) ju13.setText("O");
                else if (horaInt == 14) ju14.setText("O");
                else if (horaInt == 15) ju15.setText("O");
                else if (horaInt == 16) ju16.setText("O");
                else if (horaInt == 17) ju17.setText("O");
                else if (horaInt == 18) ju18.setText("O");
                else if (horaInt == 19) ju19.setText("O");
                else if (horaInt == 20) ju20.setText("O");
                else if (horaInt == 21) ju21.setText("O");


            }
            else if (dia == 5){

                if (horaInt == 8) vi8.setText("O");
                else if (horaInt == 9) vi9.setText("O");
                else if (horaInt == 10) vi10.setText("O");
                else if (horaInt == 11) vi11.setText("O");
                else if (horaInt == 12) vi12.setText("O");
                else if (horaInt == 13) vi13.setText("O");
                else if (horaInt == 14) vi14.setText("O");
                else if (horaInt == 15) vi15.setText("O");
                else if (horaInt == 16) vi16.setText("O");
                else if (horaInt == 17) vi17.setText("O");
                else if (horaInt == 18) vi18.setText("O");
                else if (horaInt == 19) vi19.setText("O");
                else if (horaInt == 20) vi20.setText("O");
                else if (horaInt == 21) vi21.setText("O");


            }

            else if (dia == 6){


                if (horaInt == 8) sa8.setText("O");
                else if (horaInt == 9) sa9.setText("O");
                else if (horaInt == 10) sa10.setText("O");
                else if (horaInt == 11) sa11.setText("O");
                else if (horaInt == 12) sa12.setText("O");
                else if (horaInt == 13) sa13.setText("O");
                else if (horaInt == 14) sa14.setText("O");
                else if (horaInt == 15) sa15.setText("O");
                else if (horaInt == 16) sa16.setText("O");
                else if (horaInt == 17) sa17.setText("O");
                else if (horaInt == 18) sa18.setText("O");
                else if (horaInt == 19) sa19.setText("O");
                else if (horaInt == 20) sa20.setText("O");
                else if (horaInt == 21) sa21.setText("O");

            }

        }



        return view;

    }


}
