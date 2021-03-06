package uas.pe.edu.pucp.newuas.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.controller.InvEventController;
import uas.pe.edu.pucp.newuas.datapersistency.RetrofitHelper;
import uas.pe.edu.pucp.newuas.model.InvEvent;
import uas.pe.edu.pucp.newuas.model.InvGroups;

/**
 * Created by Andree on 04/11/2016.
 */

public class InvEventDetailFragment extends Fragment {

    TextView invEvName, invEvDesc,invEvFecha, invEvHora, invEvUbic;
    Button invEvBut;
    InvEvent invEv;
    ImageView invEvImage;
    Context context;
    Boolean editEvAvailability;

    public InvEventDetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inv_event_detail, container, false);
        context = getActivity();
        getActivity().setTitle("Grupos de Inv. > Eventos");

        invEvName=(TextView) view.findViewById(R.id.invEvName);
        invEvDesc=(TextView) view.findViewById(R.id.invEvDesc);
        invEvFecha=(TextView) view.findViewById(R.id.invEvFecha);
        invEvHora=(TextView) view.findViewById(R.id.invEvHora);
        invEvUbic=(TextView) view.findViewById(R.id.invEvUbic);
        invEvBut=(Button) view.findViewById(R.id.invEvEdit) ;
        invEvImage=(ImageView) view.findViewById(R.id.invEvImage);



        Bundle bundle = this.getArguments();
        List<InvEvent> invEvento=null;
        boolean botonEdit=false;
        if (bundle != null){
            //Toast.makeText(getActivity(), "entre2", Toast.LENGTH_SHORT).show();
            botonEdit=bundle.getBoolean("BotonEdit");
            editEvAvailability=bundle.getBoolean("editEvAvailability");
            invEvento= (List<InvEvent>) bundle.getSerializable("Event");
        }

        //if(!botonEdit) invEvBut.setVisibility(View.INVISIBLE);

        invEv=invEvento.get(0);
        invEvName.setText(invEvento.get(0).getNombre());
        invEvDesc.setText(invEvento.get(0).getDescripcion());
        invEvFecha.setText(invEvento.get(0).getFecha());



        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date=new Date();
        try{
            date =format.parse(invEvento.get(0).getHora());

        }catch (ParseException e){
        }
        String hour = (String) android.text.format.DateFormat.format("hh",date);
        Integer hourEv=Integer.parseInt(hour);
        String minute = (String) android.text.format.DateFormat.format("mm",date);
        Integer minuteEv=Integer.parseInt(minute);


        invEvHora.setText(hour + ":" + minute);
        invEvUbic.setText(invEvento.get(0).getUbicacion());

        if(invEvento.get(0).getImagen()!=null)
            Picasso.with(context).load(Configuration.BASE_URL + "/"+ invEvento.get(0).getImagen()).into(invEvImage);
        else
            Picasso.with(context).load(Configuration.NOPHOTO_URL).into(invEvImage);
        /*if(invGroup.get(0).getImagen()!=null) {
            Bitmap bmp;
            try{
                InputStream in = new URL(RetrofitHelper.serverURL + invGroup.get(0).getImagen()).openStream();
                bmp = BitmapFactory.decodeStream(in);
                invGImage.setImageBitmap(bmp);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/

        invEvBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("EditInvEv", invEv);
                InvEventEditFragment mpvFragment = new InvEventEditFragment();
                mpvFragment.setArguments(bundle);

                Context context = getActivity();
                //Toast.makeText(getActivity(), "entre", Toast.LENGTH_SHORT).show();
                ((Activity)context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container,mpvFragment).commit();
                ((Activity)context).setTitle("Grupos de Inv. > Eventos");
            }
        });

        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");

        try{
            date =format2.parse(invEvento.get(0).getFecha());

        }catch (ParseException e){
        }

        Date now = new Date();
        if(now.after(date)) invEvBut.setVisibility(View.GONE);
        else {//permisos!
            if(!editEvAvailability)
                invEvBut.setVisibility(View.GONE);
        }


        return view;
    }
}
