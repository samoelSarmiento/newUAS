package uas.pe.edu.pucp.newuas.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.model.InvGroups;

/**
 * Created by Andree on 25/10/2016.
 */

public class InvGroupDetailFragment extends Fragment {

    TextView invGroupName, invGroupDesc,invGroupEsp;
    Button invGroupBut,invGroupSeeEv;
    InvGroups invG;

    public InvGroupDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inv_group_detail, container, false);

        getActivity().setTitle("Grupos de Inv.");

        invGroupName=(TextView) view.findViewById(R.id.invGroupName);
        invGroupDesc=(TextView) view.findViewById(R.id.invGroupDesc);
        invGroupEsp=(TextView) view.findViewById(R.id.invGroupEsp);
        invGroupBut=(Button) view.findViewById(R.id.invGroupEdit);
        invGroupSeeEv=(Button) view.findViewById(R.id.invGroupSeeEv);

        Bundle bundle = this.getArguments();
        List<InvGroups> invGroup=null;
        if (bundle != null){
            //Toast.makeText(getActivity(), "entre2", Toast.LENGTH_SHORT).show();
            invGroup= (List<InvGroups>) bundle.getSerializable("InvGroup");
        }
        invG=invGroup.get(0);
        invGroupName.setText(invGroup.get(0).getNombre());
        invGroupDesc.setText(invGroup.get(0).getDescripcion());
        invGroupEsp.setText(invGroup.get(0).getFaculty().getNombre());

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

            }
        });

        return view;
    }


}
