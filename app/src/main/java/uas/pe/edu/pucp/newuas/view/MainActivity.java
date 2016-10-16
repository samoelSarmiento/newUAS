package uas.pe.edu.pucp.newuas.view;

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
        switch (v.getId()){
            case R.id.btModuleAcr:
                break;
        }
    }
}
