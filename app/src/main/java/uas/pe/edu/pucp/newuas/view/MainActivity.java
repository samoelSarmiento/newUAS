package uas.pe.edu.pucp.newuas.view;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.configuration.Configuration;


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
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btModuleAcr:
                intent = new Intent(this, NavigationDrawerAcreditacion.class);
                startActivity(intent);
                break;
            case R.id.btModuleInv:
                intent = new Intent(this, NavigationDrawerInvestigacion.class);
                startActivity(intent);
                break;
            case R.id.btModulePsp:
                Intent intentPSP = new Intent(this, NavigationDrawerPSP.class);
                startActivity(intentPSP);
                break;
            case R.id.btModuleTutEv:
                if (Configuration.LOGIN_USER.getUser().getIdPerfil() == 2)
                    intent = new Intent(this, NavigationDrawerTutoriaTutor.class);
                else 
                   intent = new Intent(this, NavigationDrawerTutoria.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onBackPressed() {

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

    }
}
