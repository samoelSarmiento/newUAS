package uas.pe.edu.pucp.newuas.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.model.InvGroups;

/**
 * Created by Andree on 25/10/2016.
 */

public class InvGroupDetailFragment extends Fragment {

    TextView invGroupName, invGroupDesc,invGroupEsp;



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

        Bundle bundle = this.getArguments();
        List<InvGroups> invGroup=null;
        if (bundle != null){
            //Toast.makeText(getActivity(), "entre2", Toast.LENGTH_SHORT).show();
            invGroup= (List<InvGroups>) bundle.getSerializable("InvGroup");
        }
        invGroupName.setText(invGroup.get(0).getNombre());
        invGroupDesc.setText(invGroup.get(0).getDescripcion());
        invGroupEsp.setText(invGroup.get(0).getFaculty().getNombre());

        return view;
    }


}
