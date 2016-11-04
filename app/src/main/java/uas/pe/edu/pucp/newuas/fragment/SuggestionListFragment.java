package uas.pe.edu.pucp.newuas.fragment;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.adapter.SuggestionAdapter;
import uas.pe.edu.pucp.newuas.model.Suggestion;

/**
 * A simple {@link Fragment} subclass.
 */
public class SuggestionListFragment extends Fragment {

    ListView lvSuggestions;
    SuggestionAdapter adapter;

    public SuggestionListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_suggestion_list, container, false);
        Bundle bundle = getArguments();
        if (bundle != null) {
            List<Suggestion> list = (List<Suggestion>) bundle.getSerializable("suggestions");
            lvSuggestions = (ListView) view.findViewById(R.id.lvSuggestions);
            Context context = getActivity();
            adapter = new SuggestionAdapter(context, list);
            lvSuggestions.setAdapter(adapter);
        }
        return view;
    }

}
