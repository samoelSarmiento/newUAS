package uas.pe.edu.pucp.newuas.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import uas.pe.edu.pucp.newuas.R;

public class LogInActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnIngresar = null;
    EditText edtUser = null;
    EditText edtPassword = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        //Elementos de Login
        btnIngresar = (Button) findViewById(R.id.btnLogin);
        edtUser = (EditText) findViewById(R.id.edtName);
        edtPassword = (EditText) findViewById(R.id.edtPassword);

        //listener
        btnIngresar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                String user = edtUser.getText().toString();
                String password = edtPassword.getText().toString();
                System.out.println("Log in antes");
                //UserController.LogIn(LogInActivity.this,user,password);
                System.out.println("Log in despues");
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}
