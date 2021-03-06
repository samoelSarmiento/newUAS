package uas.pe.edu.pucp.newuas.view;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.controller.FileDownloadController;
import uas.pe.edu.pucp.newuas.controller.InvGroupController;
import uas.pe.edu.pucp.newuas.controller.SpecialtyController;
import uas.pe.edu.pucp.newuas.model.Specialty;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btModuleAcr, btModulePsp, btModuleTutEv, btModuleInv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btModuleAcr = (Button) findViewById(R.id.btModuleAcr);
        btModulePsp = (Button) findViewById(R.id.btModulePsp);
        btModuleTutEv = (Button) findViewById(R.id.btModuleTutEv);
        btModuleInv = (Button) findViewById(R.id.btModuleInv);
        //Listeners
        btModuleAcr.setOnClickListener(this);
        btModulePsp.setOnClickListener(this);
        btModuleTutEv.setOnClickListener(this);
        btModuleInv.setOnClickListener(this);

        //acreditador y administrador pueden entrar solo a acreditacion
        if (Configuration.isAccreditor() || Configuration.isAdmin()) {
            btModuleAcr.setVisibility(View.VISIBLE);
            if (Configuration.isAdmin()) {
                btModuleInv.setVisibility(View.VISIBLE);
            }
        } else {
            //investigaor normal
            if (Configuration.isOnlyInvestigator()) {
                btModuleInv.setVisibility(View.VISIBLE);
            } else {
                //estudiante normal
                if (Configuration.isStudent()) {
                    btModuleTutEv.setVisibility(View.VISIBLE);
                    //si lleva psp
                    if (Configuration.LOGIN_USER.getUser().getStudent() != null && Configuration.LOGIN_USER.getUser().getStudent().getLleva_psp() != null && Configuration.LOGIN_USER.getUser().getStudent().getLleva_psp().equals("1")) {
                        btModulePsp.setVisibility(View.VISIBLE);
                    }
                } else {
                    //solo supervisor
                    if (Configuration.isOnlySupervisor()) {
                        btModulePsp.setVisibility(View.VISIBLE);
                    } else {
                        btModuleAcr.setVisibility(View.VISIBLE);
                        btModulePsp.setVisibility(View.VISIBLE);
                        btModuleTutEv.setVisibility(View.VISIBLE);
                        btModuleInv.setVisibility(View.VISIBLE);
                    }
                }
            }
        }


    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btModuleAcr:
                SpecialtyController specialtyController = new SpecialtyController();
                try {
                    specialtyController.getAllSpecialties(this);
                } catch (Exception e) {
                    e.printStackTrace();
                    //pd.hide();
                }
                break;
            case R.id.btModuleInv:
                /*InvGroupController invGroupController = new InvGroupController();
                try {
                    invGroupController.getInvGroups(this);
                } catch (Exception e) {
                    e.printStackTrace();
                    //pd.hide();
                }*/
                intent = new Intent(this, NavigationDrawerInvestigacion.class);
                startActivity(intent);
                break;
            case R.id.btModulePsp:


                Intent intentPSP = new Intent(this, NavigationDrawerPSP.class);
                startActivity(intentPSP);
                break;
            case R.id.btModuleTutEv:
                if (Configuration.LOGIN_USER.getUser().getIdPerfil() == 2) {
                    intent = new Intent(this, NavigationDrawerTutoriaTutor.class);
                } else if (Configuration.LOGIN_USER.getUser().getIdPerfil() == 0) {
                    intent = new Intent(this, NavigationDrawerTutoria.class);
                } else intent = new Intent(this, NavigationDrawerTutoriaCoord.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
        /*
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        //seteamos el loginuser a null
                        Configuration.LOGIN_USER = null;

                        Intent intent = new Intent(getBaseContext(), LogInActivity.class);
                        startActivity(intent);
                        finish();

                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        break;
                }
            }
        };
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Cerrar sesión?").setNegativeButton("No", dialogClickListener)
                .setPositiveButton("Si", dialogClickListener).show();
*/
    }
}
