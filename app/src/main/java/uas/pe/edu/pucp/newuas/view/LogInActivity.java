package uas.pe.edu.pucp.newuas.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.controller.UserController;
import uas.pe.edu.pucp.newuas.datapersistency.DatabaseHelper;

public class
LogInActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnIngresar = null;
    EditText edtUser = null;
    EditText edtPassword = null;
    DatabaseHelper databaseHelper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        //Elementos de Login
        btnIngresar = (Button) findViewById(R.id.btnLogin);
        edtUser = (EditText) findViewById(R.id.edtName);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        databaseHelper = new DatabaseHelper(this);
        //listener
        btnIngresar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                String user = edtUser.getText().toString();
                String password = edtPassword.getText().toString();
                if (!user.isEmpty() && !password.isEmpty()) {
                    System.out.println("Log in antes");
                    UserController userController = new UserController();
                    userController.logIn(LogInActivity.this, user, password);
                } else {
                    Toast.makeText(this, "Campos vacios. Intente nuevamente", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    public DatabaseHelper getDatabaseHelper() {
        return databaseHelper;
    }

    public void setDatabaseHelper(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }


}
