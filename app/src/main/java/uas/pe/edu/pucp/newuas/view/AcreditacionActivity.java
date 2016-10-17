package uas.pe.edu.pucp.newuas.view;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.FrameLayout;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.fragment.CoursesFragment;

/**
 * Created by samoe on 17/10/2016.
 */

public class AcreditacionActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acreditacion);


        if (findViewById(R.id.fragment_acreditacion) != null) {

            if (savedInstanceState == null) {
                CoursesFragment coursesFragment = new CoursesFragment();
                getFragmentManager().beginTransaction().add(R.id.fragment_acreditacion,coursesFragment).commit();
            }
        }
    }
}