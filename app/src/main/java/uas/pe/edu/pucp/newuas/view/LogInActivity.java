package uas.pe.edu.pucp.newuas.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


    import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.controller.UserController;

public class LogInActivity extends AppCompatActivity {

    Button btnIngresar = null;
    EditText edtUser = null;
    EditText edtPassword = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        //Elementos de Login
        btnIngresar = (Button)findViewById(R.id.btnLogin);
        edtUser = (EditText)findViewById(R.id.edtName);
        edtPassword = (EditText)findViewById(R.id.edtPassword);

        //listener
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edtUser.getText().toString();
                String password = edtPassword.getText().toString();
                System.out.println("Log in antes");
                UserController.LogIn(LogInActivity.this,user,password);
                System.out.println("Log in despues");

            }
        });
    }
}
