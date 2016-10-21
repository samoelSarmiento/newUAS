package uas.pe.edu.pucp.newuas.fragment;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.model.Accreditor;
import uas.pe.edu.pucp.newuas.model.Investigator;
import uas.pe.edu.pucp.newuas.model.Teacher;
import uas.pe.edu.pucp.newuas.model.User;
import uas.pe.edu.pucp.newuas.model.UserResponse;

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
        UserResponse userResponse = Configuration.LOGIN_USER;
        User user = userResponse.getUser();
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_self, container, false);
        TextView tvName = (TextView) view.findViewById(R.id.tvValueName);
        TextView tvSurnames = (TextView) view.findViewById(R.id.tvValueSurnames);
        TextView tvEmail = (TextView) view.findViewById(R.id.tvValueEmail);

        if (user.getAccreditor() != null) {
            Accreditor accreditor = user.getAccreditor();
            tvName.setText(accreditor.getNombre());
            tvSurnames.setText(accreditor.getApellidoPaterno() + " " + accreditor.getApellidoMaterno());
            tvEmail.setText(accreditor.getCorreo());
        } else if (user.getInvestigator() != null) {
            Investigator accreditor = user.getInvestigator();
            tvName.setText(accreditor.getNombre());
            tvSurnames.setText(accreditor.getApePaterno() + " " + accreditor.getApeMaterno());
            tvEmail.setText(accreditor.getCorreo());
        } else if (user.getTeacher() != null) {
            Teacher accreditor = user.getTeacher();
            tvName.setText(accreditor.getNombre());
            tvSurnames.setText(accreditor.getApellidoPaterno() + " " + accreditor.getApellidoMaterno());
            tvEmail.setText(accreditor.getCorreo());
        }


        return view;
    }

}