package uas.pe.edu.pucp.newuas.view;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.fragment.PSP_cycleFragment;
import uas.pe.edu.pucp.newuas.fragment.PSP_documentsFragment;
import uas.pe.edu.pucp.newuas.fragment.PSP_groupsFragment;
import uas.pe.edu.pucp.newuas.fragment.PSP_studentsFragment;
import uas.pe.edu.pucp.newuas.fragment.PSP_supervisorFragment;


public class NavigationDrawerPSP extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer_psp);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        setTitle("PSP");

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
        int id = item.getItemId();

        Fragment  fragment =  new Fragment();
        FragmentManager fragmentManager =  getSupportFragmentManager();




        if (id == R.id.nav_pspCycle) {
            PSP_cycleFragment psp_cycleFragment = new PSP_cycleFragment();

            getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container_psp,psp_cycleFragment).commit();
            setTitle(item.getTitle());

        } else if (id == R.id.nav_pspTutors) {


            fragment = new PSP_supervisorFragment();

            getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container_psp, fragment).commit();
            setTitle(item.getTitle());

        } else if (id == R.id.nav_pspStudents) {

            try {
                fragment = new PSP_studentsFragment();

                getFragmentManager().beginTransaction().replace(R.id.fragment_container_psp, fragment).commit();
                setTitle(item.getTitle());
            }catch (Exception ex){
                ex.printStackTrace();

            }

        } else if (id == R.id.nav_pspDates) {

            fragment =  new PSP_groupsFragment();
            getFragmentManager().beginTransaction().replace(R.id.fragment_container_psp,fragment).commit();
            setTitle("Grupos");

        } else if (id == R.id.nav_pspDocuments) {
            try {
                fragment= new PSP_documentsFragment();
                getFragmentManager().beginTransaction().replace(R.id.fragment_container_psp, fragment).commit();
                setTitle(item.getTitle());
            }catch (Exception ex){
                ex.printStackTrace();
            }
        } else if (id == R.id.nav_pspExit) {
            DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which) {
                        case DialogInterface.BUTTON_POSITIVE:
                            Intent intent = new Intent(getBaseContext(), LogInActivity.class);
                            startActivity(intent);
                            break;
                        case DialogInterface.BUTTON_NEGATIVE:
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
