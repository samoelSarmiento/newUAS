package uas.pe.edu.pucp.newuas.fragment;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.model.PSPAdapter;
import uas.pe.edu.pucp.newuas.model.PSPSupervisor;



public class PSP_supervisorFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    private ArrayList<PSPSupervisor> list;
    private PSPAdapter adapter;

    private ListView lvPSPSupervisor;

    public PSP_supervisorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PSP_supervisorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PSP_supervisorFragment newInstance(String param1, String param2) {
        PSP_supervisorFragment fragment = new PSP_supervisorFragment();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_psp_supervisor, container, false);
         lvPSPSupervisor = (ListView) view.findViewById(R.id.lv_psp_supervisors);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();


        list = new ArrayList<>();
        PSPSupervisor sup = new PSPSupervisor();
        sup.setCodigo("11111");
        sup.setNombre("Juan Morales");

        PSPSupervisor sup2 =  new PSPSupervisor();
        sup.setNombre("Alberto Cardenas");
        sup.setCodigo("11115");

        list.add(sup);
        list.add(sup2);


        PSPAdapter adapter =  new PSPAdapter(getActivity(),list);
        lvPSPSupervisor.setAdapter(adapter);



    }
}
