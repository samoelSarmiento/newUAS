package uas.pe.edu.pucp.newuas.view;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.media.VolumeProviderCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.zip.Inflater;

import okio.InflaterSource;
import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.controller.PSPController;
import uas.pe.edu.pucp.newuas.controller.PSPControllerJ;

import uas.pe.edu.pucp.newuas.datapersistency.SharedPreference;
import uas.pe.edu.pucp.newuas.fragment.PSP_cycleFragment;

import uas.pe.edu.pucp.newuas.fragment.PSP_dates_supervisor;
import uas.pe.edu.pucp.newuas.fragment.PSP_groupsFragment;
import uas.pe.edu.pucp.newuas.fragment.PSP_meetingsFragment;
import uas.pe.edu.pucp.newuas.fragment.PSP_messagesFragment;
import uas.pe.edu.pucp.newuas.fragment.PSP_studentsFragment;
import uas.pe.edu.pucp.newuas.fragment.PSP_supervisorFragment;
import uas.pe.edu.pucp.newuas.fragment.psp_dates_supervisor_jefe;
import uas.pe.edu.pucp.newuas.model.PSPGroup;
import uas.pe.edu.pucp.newuas.model.Student;
import uas.pe.edu.pucp.newuas.model.User;


public class NavigationDrawerPSP extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    int idPerfil;




    LayoutInflater layoutInflater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer_psp);







     //   setContentView(R.layout.activity_navigation_drawer_psp);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        Menu menu = navigationView.getMenu();




        if(Configuration.LOGIN_USER.getUser().getIdPerfil() == 0) {
            PSPController controller = new PSPController();
            controller.getStudentGroup(this);
        }



        showGroupMenu(menu);




        navigationView.setNavigationItemSelectedListener(this);
        //perfiles
        setTitle("PSP");

    }

/*
    @Subscribe
    public void onReceiveStudent(Student student){

        Toast.makeText(this,"LLego al activity",Toast.LENGTH_SHORT).show();

    }*/

    public void showGroupMenu(Menu menu){


  switch(Configuration.LOGIN_USER.getUser().getIdPerfil()){
      case 3:
            //ADMIN

          break;
      case 0:



          //controller.getStudent(this);

            //STUDENTS
          menu.findItem(R.id.nav_item_pspStudents).setVisible(false);
          menu.findItem(R.id.nav_item_pspTutors).setVisible(false);
          menu.findItem(R.id.nav_item_pspCycle).setVisible(false);
          menu.findItem(R.id.nav_item_pspDocuments_teacher).setVisible(false);
          menu.findItem(R.id.nav_item_pspPhases).setVisible(false);





         // menu.setGroupVisible(R.id.nav_psp_group_students, true);
          break;
      case 1:
          //Coordinador
          menu.findItem(R.id.nav_item_pspTutors).setVisible(false);
          menu.findItem(R.id.nav_item_pspGroup_student).setVisible(false);
          menu.findItem(R.id.nav_item_pspPhases).setVisible(false);
          menu.findItem(R.id.nav_item_pspCycle).setVisible(false);
          menu.findItem(R.id.nav_item_pspDocuments_teacher).setVisible(false);

      case 2:
          //Teacher
          menu.findItem(R.id.nav_item_pspCycle).setVisible(false);
          menu.findItem(R.id.nav_item_pspTutors).setVisible(false);
          menu.findItem(R.id.nav_item_pspStudents).setVisible(false);
          //menu.findItem(R.id.nav_item_pspDates_supervisor).setVisible(false);
          //menu.findItem(R.id.nav_item_pspDocuments_teacher).setVisible(false);
          //menu.findItem(R.id.nav_item_pspGroup_student).setVisible(false);
          //menu.findItem(R.id.nav_item_pspPhases).setVisible(false);


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


    @Override
    protected void onResume() {
        super.onResume();
       // mBus.register(this);

    }

    @Override
    protected void onPause() {
        super.onPause();
       // mBus.unregister(this);

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment  fragment =  new Fragment();
        FragmentManager fragmentManager =  getSupportFragmentManager();




        if (id == R.id.nav_item_pspCycle) {
            PSP_cycleFragment psp_cycleFragment = new PSP_cycleFragment();

            getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container_psp,psp_cycleFragment).commit();
            setTitle(item.getTitle());

        } else if (id == R.id.nav_item_pspTutors) {


            fragment = new PSP_supervisorFragment();

            getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container_psp, fragment).commit();
            setTitle(item.getTitle());

        } else if (id == R.id.nav_item_pspStudents) {

            try {
                fragment = new PSP_studentsFragment();

                getFragmentManager().beginTransaction().replace(R.id.fragment_container_psp, fragment).commit();
                setTitle(item.getTitle());
            }catch (Exception ex){
                ex.printStackTrace();

            }

        } else if (id == R.id.nav_item_pspDates_supervisor) {

           // fragment = new PSP_meetingsFragment();
            PSP_dates_supervisor fragmentDates =  new PSP_dates_supervisor();
            getFragmentManager().beginTransaction().replace(R.id.fragment_container_psp, fragmentDates).commit();
            setTitle(item.getTitle());




        } else if (id == R.id.nav_item_pspPhases){
            try {



                PSPController controller = new PSPController();
                controller.getPhases(this);
            }catch (Exception ex){
                ex.printStackTrace();
            }





        }else if (id == R.id.nav_item_pspDocuments_teacher){
        try {
     PSPControllerJ controller = new PSPControllerJ();
            controller.getStudents(this);
        }catch (Exception ex){
            ex.printStackTrace();
        }





    }
    else if (id == R.id.nav_item_pspGroup_student){


                Intent intent  = getIntent();

            try {

                Bundle bundle =  intent.getBundleExtra("PSPGroup");
                if(bundle == null){



                    Log.d("GROUP NAV", "BUNDLE  NO NULL");
                    PSPController pspController = new PSPController();
                    // pspController.getStudentGroup(this);
                    pspController.getGroups(this);


                }else{

                    Log.d("GROUP NAV", "BUNDLE  NULL");
                    Fragment messagesFragment = new PSP_messagesFragment();
                    Bundle bundleMessage = new Bundle();
                    bundleMessage.putString("MESSAGE","Ya tiene grupo asignado");
                    messagesFragment.setArguments(bundleMessage);
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container_psp,messagesFragment).addToBackStack(null).commit();
                    setTitle("Grupos");


                }






            }catch(Exception ex){

                        ex.printStackTrace();


            }



        }else if(id == R.id.nav_item_pspGrades){


            PSPController controller =  new PSPController();
            controller.getTeacherStudents(this);
            setTitle("Ver notas");




        }

        else if(id == R.id.nav_pspExit) {
            DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which) {
                        case DialogInterface.BUTTON_POSITIVE:
                            Intent intent = new Intent(getBaseContext(), LogInActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
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
