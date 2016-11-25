package uas.pe.edu.pucp.newuas.fragment;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.controller.InvEventController;
import uas.pe.edu.pucp.newuas.datapersistency.RetrofitHelper;
import uas.pe.edu.pucp.newuas.model.InvGroups;

/**
 * Created by Andree on 25/10/2016.
 */

public class InvGroupDetailFragment extends Fragment {

    TextView invGroupName, invGroupDesc,invGroupEsp;
    Button invGroupBut,invGroupSeeEv;
    InvGroups invG;
    ImageView invGImage;
    Context context;
    Boolean editEvAvailability=true;

    public InvGroupDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inv_group_detail, container, false);
        context = getActivity();
        getActivity().setTitle("Grupos de Inv.");

        invGroupName=(TextView) view.findViewById(R.id.invGroupName);
        invGroupDesc=(TextView) view.findViewById(R.id.invGroupDesc);
        invGroupEsp=(TextView) view.findViewById(R.id.invGroupEsp);
        invGroupBut=(Button) view.findViewById(R.id.invGroupEdit);
        invGroupSeeEv=(Button) view.findViewById(R.id.invGroupSeeEv);
        invGImage=(ImageView) view.findViewById(R.id.invGImage);

        Bundle bundle = this.getArguments();
        List<InvGroups> invGroup=null;
        boolean botonEdit=false;
        if (bundle != null){
            //Toast.makeText(getActivity(), "entre2", Toast.LENGTH_SHORT).show();
            botonEdit=bundle.getBoolean("BotonEdit");
            invGroup= (List<InvGroups>) bundle.getSerializable("InvGroup");
        }

        if(!botonEdit) invGroupBut.setVisibility(View.INVISIBLE);

        invG=invGroup.get(0);
        invGroupName.setText(invGroup.get(0).getNombre());
        invGroupDesc.setText(invGroup.get(0).getDescripcion());
        invGroupEsp.setText(invGroup.get(0).getFaculty().getNombre());

        if(invGroup.get(0).getImagen()!=null)
            Picasso.with(context).load(Configuration.BASE_URL +"/"+ invGroup.get(0).getImagen()).into(invGImage);

        editEvAvailability = true;

        //permisos
        if(invGroup.get(0).getIdLider()!= Configuration.getIdUsuario()){
            editEvAvailability=false;
            invGroupBut.setVisibility(View.INVISIBLE);
        }


        if(Configuration.isAdmin()){
            editEvAvailability=true;
            invGroupBut.setVisibility(View.VISIBLE);
        }


        invGroupBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("EditInvGroup", invG);
                InvGroupEditFragment mpvFragment = new InvGroupEditFragment();
                mpvFragment.setArguments(bundle);

                Context context = getActivity();
                //Toast.makeText(getActivity(), "entre", Toast.LENGTH_SHORT).show();
                ((Activity)context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container,mpvFragment).commit();
                ((Activity)context).setTitle("Grupos de Inv.");
            }
        });
        invGroupSeeEv.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                InvEventController invEventController = new InvEventController();
                invEventController.getInvEvents(context,invG.getId(),editEvAvailability);
            }
        });

        return view;
    }


}
