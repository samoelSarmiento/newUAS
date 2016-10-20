package uas.pe.edu.pucp.newuas.fragment;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.model.User;

public class MySelfFragment extends Fragment {

    public MySelfFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        User user = Configuration.LOGIN_USER;
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_self, container, false);
        TextView tvName = (TextView) view.findViewById(R.id.tvValueName);
        TextView tvSurnames = (TextView) view.findViewById(R.id.tvSurames);
        TextView tvEmail = (TextView) view.findViewById(R.id.tvEmail);

        

        return view;
    }

}