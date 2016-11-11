package uas.pe.edu.pucp.newuas.fragment;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.adapter.SuggestionAdapter;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.model.Suggestion;
import uas.pe.edu.pucp.newuas.view.NavigationDrawerAcreditacion;

/**
 * A simple {@link Fragment} subclass.
 */
public class SuggestionListFragment extends Fragment {

    ListView lvSuggestions;
    SuggestionAdapter adapter;
    int ipId = 0;

    public SuggestionListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Configuration.isOnlyInvestigator()
                || Configuration.isAccreditor()
                || Configuration.isAdmin()
                || Configuration.isOnlySupervisor()) {
            super.setHasOptionsMenu(false);
        }else{
            super.setHasOptionsMenu(true);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("Sugerencias");
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_suggestion_list, container, false);
        Bundle bundle = getArguments();
        if (bundle != null) {
            List<Suggestion> list = (List<Suggestion>) bundle.getSerializable("suggestions");
            lvSuggestions = (ListView) view.findViewById(R.id.lvSuggestions);
            ipId = bundle.getInt("idIp");
            Context context = getActivity();
            adapter = new SuggestionAdapter(context, list);
            lvSuggestions.setAdapter(adapter);
        }
        return view;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_suggerence:
                NewSuggerenceFragment fragment = new NewSuggerenceFragment();
                Bundle bd = new Bundle();
                bd.putInt("idIp", ipId);
                fragment.setArguments(bd);
                getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container, fragment).commit();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.navigation_drawer_acreditacion, menu);
    }

}
