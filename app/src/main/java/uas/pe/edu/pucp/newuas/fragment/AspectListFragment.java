package uas.pe.edu.pucp.newuas.fragment;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.adapter.AspectAdapter;
import uas.pe.edu.pucp.newuas.model.Aspect;

public class AspectListFragment extends Fragment {

    ListView lvAspect = null;
    AspectAdapter adapter;

    public AspectListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        getActivity().setTitle("Aspectos");
        View view = inflater.inflate(R.layout.fragment_aspect_list, container, false);
        lvAspect = (ListView) view.findViewById(R.id.lvAspects);
        Bundle bundle = getArguments();
        if (bundle != null) {
            List<Aspect> list = (List<Aspect>) bundle.getSerializable("aspects");
            Log.d("MMM", list.size() + "");
            Context context = getActivity();
            adapter = new AspectAdapter(context, list);
            lvAspect.setAdapter(adapter);
        }
        return view;
    }

}
