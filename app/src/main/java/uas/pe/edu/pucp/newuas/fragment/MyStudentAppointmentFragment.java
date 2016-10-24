package uas.pe.edu.pucp.newuas.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.view.NavigationDrawerTutoria;


public class MyStudentAppointmentFragment extends Fragment {

    Button newAppointment;

    public MyStudentAppointmentFragment() {
        // Required empty public constructor
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        // Inflate the layout for this fragment
        final View view =   inflater.inflate(R.layout.fragment_my_student_appointment, container, false);
        newAppointment = (Button)view.findViewById(R.id.btnNewAssignment);
        newAppointment.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {

                        /*
                        Fragment fragmentStudent = new AlumnoNuevaCitaFragment();
                        FragmentManager fragMr = getActivity().getSupportFragmentManager();
                        Fragment currentFragment =  fragMr.findFragmentById(R.id.fragment_containerStudent);
                        Fragment kekeke = getFragmentManager().findFragmentById(R.id.fragment_containerStudent);
                        Log.d("MyTag","LLEGUE ACA PUTO 2");
                        if  (currentFragment == null) Log.d("MyTag","BABABABA");
                        if  (kekeke == null) Log.d("MyTag","EATIN A TACOOOO");
                        FragmentTransaction transaction = getFragmentManager().beginTransaction();
                        if  (currentFragment != null) Log.d("MyTag","XXXXXXXXXXXX");

                        // transaction.replace(R.id.fragment_containerStudent, fragmentStudent );
                        // transaction.remove(getFragmentManager().findFragmentById(R.id.fragment_containerStudent)).commit;
                        transaction.remove(currentFragment);
                        transaction.addToBackStack(null);
                        transaction.commit();*/

                        ((NavigationDrawerTutoria)getActivity()).replaceFragment(new AlumnoNuevaCitaFragment());
        /*
                        FragmentManager fragMr = ((NavigationDrawerTutoria) getActivity).;

                        Fragment fragmentStudent = new AlumnoNuevaCitaFragment();
                        Fragment currentFragment = getFragmentManager().findFragmentById(R.id.fragment_containerStudent);
                        FragmentTransaction transaction = getFragmentManager().beginTransaction();
                  //      transaction.remove(currentFragment);


                        transaction.replace(R.id.fragment_containerStudent, fragmentStudent );
                        transaction.addToBackStack(null);
                        transaction.commit();
          */
                    }
                }
        );


        return view;

    }

}
