package uas.pe.edu.pucp.newuas.fragment;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.adapter.PSPGroupAdapter;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.controller.PSPController;
import uas.pe.edu.pucp.newuas.datapersistency.SharedPreference;
import uas.pe.edu.pucp.newuas.model.PSPGroup;


public class PSP_groupsFragment extends Fragment implements View.OnClickListener {

    private ArrayList<PSPGroup> list;

    private String mParam1;
    private String mParam2;


    private ListView groupList;
    private PSPGroupAdapter groupAdapter;


    private Button btnChoose;
    private Button btnCancel;


    public PSP_groupsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_psp_groups, container, false);

        btnChoose = (Button) view.findViewById(R.id.btn_psp_groups_choose);
        btnCancel = (Button) view.findViewById(R.id.btn_psp_groups_cancel);

        btnChoose.setOnClickListener(this);
        groupList = (ListView) view.findViewById(R.id.lv_psp_groups);

/*        Log.d("OnCreateView", "LLEGO primero");

        PSPGroup group1  =  new PSPGroup();
        group1.setIdGroup(1);
        group1.setDescription("Grupo mayor de 120");

        PSPGroup group2  =  new PSPGroup();
        group2.setIdGroup(2);
        group2.setDescription("Grupo menor de 120");*/


        Bundle bundle = getArguments();
        if (bundle != null) {

            ArrayList<PSPGroup> groups = (ArrayList<PSPGroup>) bundle.getSerializable("PSPGroups");
            groupAdapter = new PSPGroupAdapter(getActivity(), groups);
            groupList.setAdapter(groupAdapter);




        }


        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btn_psp_groups_choose:
                //Actualiza el grupo que pertenece el alumno
                PSPController controller =  new PSPController();
                SharedPreference shared = new SharedPreference(getActivity());
                if(!shared.getGroupStatus(Configuration.LOGIN_USER.getUser())) {
                    int value = groupAdapter.getSelectedItem().getIdGroup();
                    Log.d("Selected", "" + value);
                    controller.updateGroup(getActivity(), value);
                }


                break;

            case R.id.btn_psp_groups_cancel:



                break;


        }

    }
}
