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
import uas.pe.edu.pucp.newuas.model.PSPGroup;


public class PSP_groupsFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private ListView groupList;
    private PSPGroupAdapter groupAdapter;


    private Button btnChoose;
    private Button btnCancel;


    public PSP_groupsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PSP_groupsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PSP_groupsFragment newInstance(String param1, String param2) {
        PSP_groupsFragment fragment = new PSP_groupsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


        Log.d("onCreate", "LLEGO primero");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      View view = inflater.inflate(R.layout.fragment_psp_groups, container, false);

        btnChoose = (Button)view.findViewById(R.id.btn_psp_groups_choose);
        btnCancel = (Button)view.findViewById(R.id.btn_psp_groups_cancel);


        btnChoose.setOnClickListener(this);

        groupList  = (ListView) view.findViewById(R.id.lv_psp_groups);



        Log.d("OnCreateView", "LLEGO primero");

        PSPGroup group1  =  new PSPGroup();
        group1.setIdGroup(1);
        group1.setDescription("Grupo mayor de 120");

        PSPGroup group2  =  new PSPGroup();
        group2.setIdGroup(2);
        group2.setDescription("Grupo menor de 120");



    //    Bundle bundle = getArguments();
      //  if(bundle != null){


            /*
          ArrayList<PSPGroup> groups = (ArrayList<PSPGroup>)bundle.getSerializable("PSPGroups");*/

            ArrayList<PSPGroup> groups =  new ArrayList<>();
            groups.add(group1);
            groups.add(group2);
            groupAdapter =  new PSPGroupAdapter(getActivity(),groups);
            groupList.setAdapter(groupAdapter);




    //    }




        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btn_psp_groups_choose:
                //Actualiza el grupo que pertenece el alumno

                 int value = ((int) groupList.getSelectedItemId());




                break;

            case R.id.btn_psp_groups_cancel:
                break;




        }

    }
}
