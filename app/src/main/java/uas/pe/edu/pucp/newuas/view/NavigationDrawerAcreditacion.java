package uas.pe.edu.pucp.newuas.view;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.io.Serializable;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.controller.MeasurePeriodController;
import uas.pe.edu.pucp.newuas.controller.SpecialtyController;
import uas.pe.edu.pucp.newuas.fragment.MySelfFragment;
import uas.pe.edu.pucp.newuas.fragment.SpecialtyListFragment;

public class NavigationDrawerAcreditacion extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public static String[] niveles = {"5", "6", "7", "8", "9", "10"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer_acreditacion);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
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
            bundle.putSerializable("specialties", (Serializable) Configuration.LOGIN_USER.getSpecialtyList());
            specialtyListFragment.setArguments(bundle);
            getFragmentManager().beginTransaction().replace(R.id.fragment_container, specialtyListFragment).commit();
        } else {
            setTitle("Mi Perfil");
            getFragmentManager().beginTransaction().replace(R.id.fragment_container, new MySelfFragment()).commit();

        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        setTitle(item.getTitle());
        int id = item.getItemId();
        if (id == R.id.nav_myself) {
            MySelfFragment mySelfFragment = new MySelfFragment();
            getFragmentManager().beginTransaction().replace(R.id.fragment_container, mySelfFragment).commit();
        } else if (id == R.id.nav_specialty_list) {
            SpecialtyListFragment specialtyListFragment = new SpecialtyListFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("specialties", (Serializable) Configuration.LOGIN_USER.getSpecialtyList());
            specialtyListFragment.setArguments(bundle);
            getFragmentManager().beginTransaction().replace(R.id.fragment_container, specialtyListFragment).commit();
        } else if (id == R.id.nav_myspecialty) {
            SpecialtyController specialtyController = new SpecialtyController();

            specialtyController.getSpecialties(this);

            //while(Configuration.SPECIALTY == null);
            //System.out.println(Configuration.SPECIALTY.getNombre());
            //Specialty sp = specialtyController.getSpecialties(this);
            //System.out.println(sp.getNombre());
            //Specialty sp = Configuration.SPECIALTY;


            /*
            Gson gson = new Gson();
            String spj = gson.toJson(sp);
            System.out.println(spj);
            Bundle bundle = new Bundle();
            bundle.putSerializable("Specialty", spj);
            spFragment.setArguments(bundle); */


        } else if (id == R.id.nav_courses) {
            //obtener todos los cursos x especialidad
            SpecialtyController specialtyController = new SpecialtyController();
            if (Configuration.LOGIN_USER.getUser().getIdPerfil() == 3) {
                boolean result = specialtyController.getCoursesxSpecialy(this, Configuration.SPECIALTY.getIdEspecialidad());
            } else {
                boolean result = specialtyController.getCoursesxSpecialy(this, Configuration.LOGIN_USER.getUser().getAccreditor().getIdEspecialidad());
            }
//            if (result) {
//                CourseFragment coursesFragment = new CourseFragment();
//                getFragmentManager().beginTransaction().replace(R.id.fragment_container, coursesFragment).commit();
//            }else
//                Toast.makeText(this,"Error de conexion",Toast.LENGTH_LONG).show();
        } else if (id == R.id.nav_eduobjectivo) {

        } else if (id == R.id.nav_sizperiod) {
            MeasurePeriodController measurePeriodController = new MeasurePeriodController();
            boolean result = measurePeriodController.getMeasurePeriods(this);


        } else if (id == R.id.nav_studresult) {

        } else if (id == R.id.nav_criteria) {

        } else if (id == R.id.nav_upgplan) {

        } else if (id == R.id.nav_efforttable) {

        } else if (id == R.id.nav_sizeresult) {

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
