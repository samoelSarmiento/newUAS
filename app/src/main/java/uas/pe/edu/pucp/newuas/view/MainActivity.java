package uas.pe.edu.pucp.newuas.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import uas.pe.edu.pucp.newuas.R;


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
                break;
            case R.id.btModuleTutEv:
                break;
        }
    }
}
