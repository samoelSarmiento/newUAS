package uas.pe.edu.pucp.newuas.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.controller.ImprovementPlanController;
import uas.pe.edu.pucp.newuas.controller.InvEventController;
import uas.pe.edu.pucp.newuas.model.InvEvent;
import uas.pe.edu.pucp.newuas.model.InvGroups;
import uas.pe.edu.pucp.newuas.model.SuggestionRequest;

/**
 * Created by Andree on 04/11/2016.
 */

public class InvEventEditFragment extends Fragment implements View.OnClickListener{

    EditText invEvName, invEvDesc, invEvHora, invEvUbic;
    TextView invEvFecha;
    Button saveBut,cancelBut;
    ImageButton selFecha;
    InvEvent invEv;
    Context context;
    int day,month,year;
    private static DatePickerDialog.OnDateSetListener selectorListener;
    Date date;

    public InvEventEditFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inv_event_edit, container, false);
        context=getActivity();
        getActivity().setTitle("Grupos de Inv. > Eventos");

        invEvName=(EditText) view.findViewById(R.id.invEvName);
        invEvDesc=(EditText) view.findViewById(R.id.invEvDesc);
        invEvFecha=(TextView) view.findViewById(R.id.invEvFecha);
        invEvHora=(EditText) view.findViewById(R.id.invEvHora);
        invEvUbic=(EditText) view.findViewById(R.id.invEvUbic);
        saveBut=(Button) view.findViewById(R.id.invEvSave);
        cancelBut=(Button) view.findViewById(R.id.invEvCancel);
        selFecha = (ImageButton)view.findViewById(R.id.selFecha);

        Bundle bundle = this.getArguments();
        InvEvent invEvent=null;
        if (bundle != null){
            //Toast.makeText(getActivity(), "entre2", Toast.LENGTH_SHORT).show();
            invEvent= (InvEvent) bundle.getSerializable("EditInvEv");
        }
        invEv=invEvent;
        invEvName.setText(invEvent.getNombre());
        invEvDesc.setText(invEvent.getDescripcion());
        invEvFecha.setText(invEvent.getFecha());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        date=new Date();
        try{
            date =format.parse(invEvent.getFecha());

        }catch (ParseException e){
        }
        //calI.setTime(date);
        String dayEv = (String) android.text.format.DateFormat.format("dd",date);
        day=Integer.parseInt(dayEv);
        String monthEv = (String) android.text.format.DateFormat.format("MM",date);
        month=Integer.parseInt(monthEv);
        String yearEv = (String) android.text.format.DateFormat.format("yyyy",date);
        year = Integer.parseInt(yearEv);

        invEvHora.setText(invEvent.getHora());
        invEvUbic.setText(invEvent.getUbicacion());

        saveBut.setOnClickListener(this);
        cancelBut.setOnClickListener(this);
        selFecha.setOnClickListener(this);

        selectorListener =  new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePickerDialog datePickerDialog, int yearEv, int monthEv, int dayEv) {
                day = dayEv; month = monthEv+1; year = yearEv;
                String format = "%1$02d";
                String date = year +  "-" + String.format(format, (month)) + "-" + String.format(format, day);
                invEvFecha.setText(date);
            }
        };

        return view;
    }


    @Override
    public void onClick(View v) {
        InvEventController invEvController = new InvEventController();
        switch (v.getId()){
            case R.id.invEvSave:

                //Toast.makeText(getActivity(),invEvName.getText().toString() , Toast.LENGTH_SHORT).show();
                String nom = invEvName.getText().toString();
                String desc = invEvDesc.getText().toString();
                String ubic =invEvUbic.getText().toString();
                if (!nom.isEmpty() && !desc.isEmpty() && !ubic.isEmpty()) {
                    //fecha y hora!!!!!!

                    InvEvent changedIE = invEv;
                    changedIE.setNombre(invEvName.getText().toString());
                    changedIE.setDescripcion(invEvDesc.getText().toString());
                    changedIE.setFecha(invEvFecha.getText().toString());
                    changedIE.setHora(invEvHora.getText().toString());
                    changedIE.setUbicacion(invEvUbic.getText().toString());

                    invEvController.editInvEv(context,changedIE);
                    //invGroupController.getInvGroupById(context,invG.getId());
                    //Toast.makeText(getActivity(), "entre", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "Verifique los campos vacíos", Toast.LENGTH_LONG).show();
                }

                break;

            case R.id.invEvCancel:
                invEvController.getInvEvById(context,invEv.getId());
                break;
            case R.id.selFecha:
                DatePickerDialog d = DatePickerDialog.newInstance(selectorListener, year, month-1, day);
                //Calendar c = Calendar.getInstance();
                //d.setMinDate(c);
                d.show(getActivity().getFragmentManager(), "");
                break;
        }
    }
}
