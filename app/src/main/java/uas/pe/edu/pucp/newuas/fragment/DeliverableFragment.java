package uas.pe.edu.pucp.newuas.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.adapter.DeliverableAdapter;
import uas.pe.edu.pucp.newuas.adapter.InvEventAdapter;
import uas.pe.edu.pucp.newuas.controller.DeliverableController;
import uas.pe.edu.pucp.newuas.controller.InvEventController;
import uas.pe.edu.pucp.newuas.model.Deliverable;
import uas.pe.edu.pucp.newuas.model.InvEvent;

/**
 * Created by Andree on 11/11/2016.
 */

public class DeliverableFragment extends Fragment {

    ListView delivList;
    DeliverableAdapter deliverableAdapter;

    public DeliverableFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_deliverable, container, false);
        getActivity().setTitle("Proyectos > Entregables");

        delivList=(ListView) view.findViewById(R.id.delivList);

        Bundle bundle = this.getArguments();
        if (bundle != null){
            ArrayList<Deliverable> delivs = (ArrayList<Deliverable>) bundle.getSerializable("Deliverables");

            deliverableAdapter= new DeliverableAdapter(getActivity(), delivs);
            delivList.setAdapter(deliverableAdapter);
        }
        delivList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Deliverable deliv = (Deliverable) deliverableAdapter.getItem(position);

                DeliverableController deliverableController = new DeliverableController();
                //Toast.makeText(getActivity(), "entre", Toast.LENGTH_SHORT).show();
                deliverableController.getDelivById(getActivity(),deliv.getId());

            }
        });

        return view;
    }
}
