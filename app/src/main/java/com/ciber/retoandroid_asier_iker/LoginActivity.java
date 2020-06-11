package com.ciber.retoandroid_asier_iker;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    Button login;
    TextView register;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DatabaseHelper(this);
        username = (EditText) findViewById(R.id.ED_username);
        password = (EditText) findViewById(R.id.ED_password);
        login = (Button) findViewById(R.id.button_login);
        register = (TextView) findViewById(R.id.TV_register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerintent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(registerintent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString().trim();
                String pwd = password.getText().toString().trim();
                Boolean result = db.checkuser(user, pwd);
                if (result == true) {
                    Intent HomePage = new Intent(LoginActivity.this, HomeActivity.class);
                    Toast.makeText(LoginActivity.this, "Succesfully Logged-In", Toast.LENGTH_SHORT).show();
                    /***/
                    Bundle bundle = new Bundle();
                    bundle.putString("user",username.getText().toString().trim());
                    HomePage.putExtras(bundle);
                    /***/
                    startActivity(HomePage);
                } else {
                    Toast.makeText(LoginActivity.this, "Login Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
