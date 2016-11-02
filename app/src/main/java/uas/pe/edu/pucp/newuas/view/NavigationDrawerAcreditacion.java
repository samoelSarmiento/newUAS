package uas.pe.edu.pucp.newuas.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.List;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.controller.MeasurePeriodController;
import uas.pe.edu.pucp.newuas.controller.SpecialtyController;
import uas.pe.edu.pucp.newuas.fragment.MySelfFragment;
import uas.pe.edu.pucp.newuas.fragment.SpecialtyFragment;
import uas.pe.edu.pucp.newuas.fragment.SpecialtyListFragment;
import uas.pe.edu.pucp.newuas.model.Specialty;

public class NavigationDrawerAcreditacion extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public static String[] niveles = {"5", "6", "7", "8", "9", "10"};
    private List<Specialty> specialtyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundleIntent = getIntent().getExtras();
        if (bundleIntent != null)
            specialtyList = (List<Specialty>) bundleIntent.getSerializable("specialtyList");

        setContentView(R.layout.activity_navigation_drawer_acreditacion);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        if (Configuration.LOGIN_USER.getUser().getIdPerfil() == 3) {
            //cambiar la visibilidad de los elementos
            navigationView.getMenu().findItem(R.id.nav_specialty_list).setVisible(true);
            navigationView.getMenu().findItem(R.id.nav_myself).setVisible(false);
            //poner la lista de especialidades como la pantalla principal
            SpecialtyListFragment specialtyListFragment = new SpecialtyListFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("specialties", (Serializable) specialtyList);
            specialtyListFragment.setArguments(bundle);
            getFragmentManager()
                    .beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.fragment_container, specialtyListFragment)
                    .commit();
        } else {
            setTitle("Mi Perfil");
            getFragmentManager()
                    .beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.fragment_container, new MySelfFragment())
                    .commit();

        }


    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() == 0) {
            super.onBackPressed();
        } else {
            getFragmentManager().popBackStack();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_drawer_acreditacion, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        setTitle(item.getTitle());
        int id = item.getItemId();
        if (id == R.id.nav_myself) {
            MySelfFragment mySelfFragment = new MySelfFragment();
            getFragmentManager()
                    .beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.fragment_container, mySelfFragment)
                    .commit();
        } else if (id == R.id.nav_specialty_list) {
            SpecialtyListFragment specialtyListFragment = new SpecialtyListFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("specialties", (Serializable) specialtyList);
            specialtyListFragment.setArguments(bundle);
            getFragmentManager()
                    .beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.fragment_container, specialtyListFragment)
                    .commit();
        } else if (id == R.id.nav_myspecialty) {
            if (Configuration.LOGIN_USER.getUser().getIdPerfil() == 3) {

                SpecialtyFragment spFragment = new SpecialtyFragment();

                Gson gsonf = new Gson();
                String spj = gsonf.toJson(Configuration.SPECIALTY);
                System.out.println(spj);
                Bundle bundle = new Bundle();
                bundle.putString("Specialty", spj);
                spFragment.setArguments(bundle);
                getFragmentManager()
                        .beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.fragment_container, spFragment)
                        .commit();
                setTitle("Especialidad");
            } else {
                SpecialtyController specialtyController = new SpecialtyController();
                if (Configuration.LOGIN_USER.getUser().getAccreditor() != null)
                    specialtyController.getSpecialties(this, Configuration.LOGIN_USER.getUser().getAccreditor().getIdEspecialidad());
                if (Configuration.LOGIN_USER.getUser().getTeacher() != null)
                    specialtyController.getSpecialties(this, Configuration.LOGIN_USER.getUser().getTeacher().getIdEspecialidad());
            }
        } else if (id == R.id.nav_sizperiod) {
            MeasurePeriodController measurePeriodController = new MeasurePeriodController();
            boolean result = measurePeriodController.getMeasurePeriods(this);


        } else if (id == R.id.nav_upgplan) {

        } else if (id == R.id.nav_consolidate) {

        } else if (id == R.id.nav_signout) {
            DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which) {
                        case DialogInterface.BUTTON_POSITIVE:
                            //Borra los shared preferences
                            Configuration.LOGIN_USER = null;
                            //regresa al login
                            Intent intent = new Intent(getBaseContext(), LogInActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
                            break;

                        case DialogInterface.BUTTON_NEGATIVE:
                            //Nada pasa
                            break;
                    }
                }
            };
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("¿Salir?").setNegativeButton("No", dialogClickListener)
                    .setPositiveButton("Si", dialogClickListener).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
