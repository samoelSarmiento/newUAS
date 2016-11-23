package uas.pe.edu.pucp.newuas.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.adapter.InvEventAdapter;
import uas.pe.edu.pucp.newuas.controller.InvEventController;
import uas.pe.edu.pucp.newuas.model.InvEvent;
import uas.pe.edu.pucp.newuas.model.InvGroups;

/**
 * Created by Andree on 04/11/2016.
 */

public class InvEventFragment extends Fragment {

    ListView lvInvEv;
    InvEventAdapter invEventAdapter;

    public InvEventFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inv_event, container, false);
        getActivity().setTitle("Grupos de Inv. > Eventos");

        lvInvEv=(ListView) view.findViewById(R.id.invEvList);

        Bundle bundle = this.getArguments();
        if (bundle != null){
            ArrayList<InvEvent> invEv = (ArrayList<InvEvent>) bundle.getSerializable("Events");

            invEventAdapter= new InvEventAdapter(getActivity(), invEv);
            lvInvEv.setAdapter(invEventAdapter);
        }
        lvInvEv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                InvEvent invEvent = (InvEvent) invEventAdapter.getItem(position);
                //Toast.makeText(getActivity(), position + "", Toast.LENGTH_SHORT).show();
                InvEventController invController = new InvEventController();
                //Toast.makeText(getActivity(), "entre", Toast.LENGTH_SHORT).show();
                invController.getInvEvById(getActivity(),invEvent.getId());

            }
        });

        return view;
    }
}
