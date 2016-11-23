package uas.pe.edu.pucp.newuas.view;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.controller.PSPController;
import uas.pe.edu.pucp.newuas.controller.PSPControllerJ;

import uas.pe.edu.pucp.newuas.fragment.PSP_SupSetFreeHoursFragment;
import uas.pe.edu.pucp.newuas.fragment.PSP_cycleFragment;

import uas.pe.edu.pucp.newuas.fragment.PSP_dates_supervisor;
import uas.pe.edu.pucp.newuas.fragment.PSP_meetings_studentFragment;
import uas.pe.edu.pucp.newuas.fragment.PSP_messagesFragment;
import uas.pe.edu.pucp.newuas.fragment.PSP_studentsFragment;
import uas.pe.edu.pucp.newuas.fragment.PSP_supervisorFragment;
import uas.pe.edu.pucp.newuas.model.MyToast;


public class NavigationDrawerPSP extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    int idPerfil;
    private int hot_number =  5;
    private TextView ui_hot;


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


        if (Configuration.LOGIN_USER.getUser().getIdPerfil() == 0) {
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


    public void showGroupMenu(Menu menu) {


        switch (Configuration.LOGIN_USER.getUser().getIdPerfil()) {
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
                menu.findItem(R.id.nav_items_pspSupxStudenMeeting).setVisible(false);
                menu.findItem(R.id.nav_item_pspDates_supervisor).setVisible(false);
                menu.findItem(R.id.nav_item_pspDates_supervisor_employer_student).setVisible(false);
                menu.findItem(R.id.nav_item_pspSupFreeHours).setVisible(false);
                menu.findItem(R.id.nav_item_pspStudents).setVisible(false);
                menu.findItem(R.id.nav_item_pspStudents_Supervis).setVisible(false);
                menu.findItem(R.id.nav_item_pspGrades).setVisible(false);
                // menu.setGroupVisible(R.id.nav_psp_group_students, true);
                break;
            case 1:
                //Coordinador
                menu.findItem(R.id.nav_item_pspTutors).setVisible(false);
                menu.findItem(R.id.nav_item_pspGroup_student).setVisible(false);
                menu.findItem(R.id.nav_item_pspPhases).setVisible(false);
                menu.findItem(R.id.nav_item_pspCycle).setVisible(false);
                menu.findItem(R.id.nav_item_pspDocuments_teacher).setVisible(false);
                menu.findItem(R.id.nav_item_pspSupFreeHours).setVisible(false);

            case 2:
                //Teacher
                menu.findItem(R.id.nav_item_pspCycle).setVisible(false);
                menu.findItem(R.id.nav_item_pspTutors).setVisible(false);
                menu.findItem(R.id.nav_item_pspStudents).setVisible(false);
                //menu.findItem(R.id.nav_item_pspDates_supervisor).setVisible(false);
                menu.findItem(R.id.nav_item_pspDocuments_teacher).setVisible(false);
                //menu.findItem(R.id.nav_item_pspGroup_student).setVisible(false);
                //menu.findItem(R.id.nav_item_pspPhases).setVisible(false);



            case 6:


                //Supervisor
         //       menu.findItem(R.id.nav_item_pspDocuments_teacher).setVisible(false);
                menu.findItem(R.id.nav_items_pspSupxStudenMeeting);
                menu.findItem(R.id.nav_items_pspSupxStudenMeeting);
                menu.findItem(R.id.nav_item_pspTutors).setVisible(false);
                menu.findItem(R.id.nav_item_pspCycle).setVisible(false);

                menu.findItem(R.id.nav_item_pspDocuments_teacher).setVisible(false);

                menu.findItem(R.id.nav_item_pspGrades).setVisible(false);
         //       menu.findItem(R.id.nav_item_pspDocuments_teacher).setVisible(false);


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
        super.onCreateOptionsMenu(menu);
        // Inflate the menu; this adds items to the action bar if it is present.
        //  showNotificationIcons(menu);
         getMenuInflater().inflate(R.menu.navigation_drawer_acreditacion, menu);

        return true;
    }


    public void showNotificationIcons(Menu menu){


        if(Configuration.LOGIN_USER.getUser().getIdPerfil() == 0) {
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.student_notificationbar, menu);
            View menu_holist = menu.findItem(R.id.menu_hotlist).getActionView();
            menu_holist.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(getApplicationContext(), "Tiene " + hot_number + "reuniones pendientes ", Toast.LENGTH_SHORT).show();


                }
            });
            if (menu_holist != null) {
                ui_hot = (TextView) menu_holist.findViewById(R.id.hotlist_hot);
            } else
                Log.d("MENU", "ES NULL");
            updateHotCount(hot_number);

        }

    }

    public void updateHotCount(final int new_number){
        if(ui_hot == null) return;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(new_number ==0 )
                    ui_hot.setVisibility(View.INVISIBLE);
                else{

                    ui_hot.setVisibility(View.VISIBLE);
                    ui_hot.setText(Integer.toString(new_number));

                }
            }
        });


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

        Fragment fragment = new Fragment();
        FragmentManager fragmentManager = getSupportFragmentManager();


        if (id == R.id.nav_item_pspCycle) {



            /*
            PSP_cycleFragment psp_cycleFragment = new PSP_cycleFragment();

            getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container_psp, psp_cycleFragment).commit();
            setTitle(item.getTitle());
*/
        } else if (id == R.id.nav_item_pspTutors) {


            fragment = new PSP_supervisorFragment();

            getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container_psp, fragment).commit();
            setTitle(item.getTitle());

        } else if (id == R.id.nav_item_pspStudents_Supervis) {
            PSPControllerJ controller = new PSPControllerJ();
            controller.getStudentsForSelectAll(this);


        } else if (id == R.id.nav_item_pspStudents) {

            try {
                fragment = new PSP_studentsFragment();

                getFragmentManager().beginTransaction().replace(R.id.fragment_container_psp, fragment).commit();
                setTitle(item.getTitle());
            } catch (Exception ex) {
                ex.printStackTrace();

            }

        }else if(id  == R.id.nav_item_pspStudentMeetings){


            PSPController controller =  new PSPController();
            controller.getStudentMeetings(this);


        } else if (id == R.id.nav_item_pspDates_supervisor) {

            // fragment = new PSP_meetingsFragment();
            PSP_dates_supervisor fragmentDates = new PSP_dates_supervisor();
            getFragmentManager().beginTransaction().replace(R.id.fragment_container_psp, fragmentDates).commit();
            setTitle(item.getTitle());

        } else if (id == R.id.nav_item_pspDates_supervisor_employer_student) {


            PSPControllerJ controller = new PSPControllerJ();
            controller.getDatesSupervisorEmployerStudent(this);

        } else if (id == R.id.nav_item_pspPhases) {
            try {


                PSPController controller = new PSPController();
                controller.getPhases(this);
            } catch (Exception ex) {
                ex.printStackTrace();
            }


        } else if (id == R.id.nav_item_pspDocuments_teacher) {
            try {
                PSPControllerJ controller = new PSPControllerJ();
                controller.getStudents(this);
            } catch (Exception ex) {
                ex.printStackTrace();
            }


        } else if (id == R.id.nav_item_pspGroup_student) {


            Intent intent = getIntent();

            try {

                Bundle bundle = intent.getBundleExtra("PSPGroup");
                if (bundle == null) {


                    Log.d("GROUP NAV", "BUNDLE  NO NULL");
                    PSPController pspController = new PSPController();
                    // pspController.getStudentGroup(this);
                    pspController.getGroups(this);


                } else {

                    Log.d("GROUP NAV", "BUNDLE  NULL");
                    Fragment messagesFragment = new PSP_messagesFragment();
                    Bundle bundleMessage = new Bundle();
                    bundleMessage.putString("MESSAGE", "Ya tiene grupo asignado");
                    messagesFragment.setArguments(bundleMessage);
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container_psp, messagesFragment).addToBackStack(null).commit();
                    setTitle("Grupos");


                }


            } catch (Exception ex) {

                ex.printStackTrace();


            }


        } else if (id == R.id.nav_item_pspGrades) {






            PSPController controller = new PSPController();
            controller.getStudentSupFinalScores(this);

          //  controller.getTeacherStudents(this);
            setTitle("Ver notas");


        } else if (id == R.id.nav_items_pspSupxStudenMeeting) {

            /*
            Fragment fragmentDates = new PSP_SupSetFreeHoursFragment();
            getFragmentManager().beginTransaction().replace(R.id.fragment_container_psp, fragmentDates).commit();
            setTitle(item.getTitle());*/


            PSPController controller = new PSPController();
            controller.getSupStudents(this);


        } else if(id == R.id.nav_item_pspSupFreeHours){

            PSPController controller =  new PSPController();
            controller.getSupFreeHours(this);


        }
        else if (id == R.id.nav_pspExit) {
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
