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

import uas.pe.edu.pucp.newuas.R;

import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.controller.InvGroupController;
import uas.pe.edu.pucp.newuas.controller.InvestigatorController;
import uas.pe.edu.pucp.newuas.controller.ProjectController;
import uas.pe.edu.pucp.newuas.fragment.CourseFragment;
import uas.pe.edu.pucp.newuas.fragment.InvGroupFragment;
import uas.pe.edu.pucp.newuas.fragment.InvestigatorsFragment;
import uas.pe.edu.pucp.newuas.fragment.ProjectsFragment;

public class NavigationDrawerInvestigacion extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer_investigacion);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        setTitle("Grupos de Inv.");
        getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container, new InvGroupFragment()).commit();
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
        getMenuInflater().inflate(R.menu.navigation_drawer_investigacion, menu);
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

        if (id == R.id.nav_invGroup) {
            InvGroupController invGroupController = new InvGroupController();
            invGroupController.getInvGroups(this);
            /*InvGroupFragment invGroupFragment = new InvGroupFragment();
            getFragmentManager().beginTransaction().add(R.id.fragment_container, invGroupFragment).commit();
            setTitle(item.getTitle());*/
        } else if (id == R.id.nav_proj) {
            ProjectController projController = new ProjectController();
            projController.getProjects(this);
            /*ProjectsFragment projectsFragment = new ProjectsFragment();
            getFragmentManager().beginTransaction().add(R.id.fragment_container, projectsFragment).commit();
            setTitle(item.getTitle());*/
        } else if (id == R.id.nav_inv) {
            InvestigatorController invController = new InvestigatorController();
            invController.getInvestigators(this);
            /*
            InvestigatorsFragment invetigatorsFragment = new InvestigatorsFragment();
            getFragmentManager().beginTransaction().add(R.id.fragment_container, invetigatorsFragment).commit();
            setTitle(item.getTitle());*/
        } else if (id == R.id.nav_back) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_logOut) {
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
