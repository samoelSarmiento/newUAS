package uas.pe.edu.pucp.newuas.view;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
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


                /*
                final ProgressBar p=(ProgressBar) findViewById(R.id.progressBar);
                p.setVisibility(View.VISIBLE);
                */



                String user = edtUser.getText().toString();
                String password = edtPassword.getText().toString();

                /*
                ProgressDialog pd = new ProgressDialog(this );
                pd.setMessage("Cargando...");
                pd.setCanceledOnTouchOutside(false);
                pd.show();
                */

                /*
                YourAsyncTask yat = new YourAsyncTask(this, user, password);

                yat.execute();

                */


                if (!user.isEmpty() && !password.isEmpty()) {

                    System.out.println("Log in antes");
                    try{
                        UserController userController = new UserController();
                        userController.logIn(LogInActivity.this, user, password);

                    }catch (Exception e){
                        //pd.hide();
                    }

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

    /*
    class YourAsyncTask extends AsyncTask<Void, Void, Void> {

        Activity activity;
        String user;
        String password;

        public YourAsyncTask(LogInActivity activity, String user, String password){
            this.activity = activity;
            this.user = user;
            this.password = password;

        };

        protected Void doInBackground(Void... args) {
            // do background work here

            if (!user.isEmpty() && !password.isEmpty()) {
                System.out.println("Log in antes");
                UserController userController = new UserController();
                userController.logIn(LogInActivity.this, user, password);
            } else {
                Toast.makeText(activity, "Campos vacios. Intente nuevamente", Toast.LENGTH_SHORT).show();
            }
            return null;
        }

        protected void onPostExecute(Void result) {
            // do UI work here

            ProgressDialog pd = new ProgressDialog(activity );
            pd.setMessage("loading");
            pd.show();
        }
    }

    */




}



